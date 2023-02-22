package dev.sefiraat.cultivation.implementation.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.Registry;
import dev.sefiraat.sefilib.string.Theme;
import io.github.bakedlibs.dough.blocks.BlockPosition;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Enemy;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@CommandAlias("cultivation|cv")
public class CultivationCommands extends BaseCommand {

    @Default
    public void onDefault(CommandSender sender) {
        sender.sendMessage(Theme.ERROR + "Please provide a valid subcommand.");
    }


    //TODO apply permissions
    @Subcommand("pos1")
    public void onPos1(CommandSender sender) {
        if (sender instanceof Player player) {
            Registry.getInstance().addPositionOne(player);
            System.out.println("pos1 set");
        } else {
            sender.sendMessage(Theme.applyThemeToString(Theme.WARNING, "Must be executed by a player"));
        }
    }

    @Subcommand("pos2")
    public void onPos2(CommandSender sender) {
        if (sender instanceof Player player) {
            Registry.getInstance().addPositionTwo(player);
            System.out.println("pos2 set");
        } else {
            sender.sendMessage(Theme.applyThemeToString(Theme.WARNING, "Must be executed by a player"));
        }
    }

    @CommandCompletion("name")
    @Subcommand("saveStructure")
    public void saveStructure(CommandSender sender, String name) {
        if (!(sender instanceof Player player)) {
            return;
        }
        BlockPosition pos1 = Registry.getInstance().getPositionOne(player);
        BlockPosition pos2 = Registry.getInstance().getPositionTwo(player);
        Block base = player.getTargetBlockExact(20, FluidCollisionMode.NEVER);
        if (pos1 == null || pos2 == null || base == null) {
            return;
            //todo send message
        }

        Map<BlockPosition, String> blockPositions = new HashMap<>();
        int upperX = Math.max(pos1.getX(), pos2.getX());
        int upperY = Math.max(pos1.getY(), pos2.getY());
        int upperZ = Math.max(pos1.getZ(), pos2.getZ());
        int lowerX = Math.min(pos1.getX(), pos2.getX());
        int lowerY = Math.min(pos1.getY(), pos2.getY());
        int lowerZ = Math.min(pos1.getZ(), pos2.getZ());

        for (int x = lowerX; x <= upperX; x++) {
            for (int z = lowerZ; z <= upperZ; z++) {
                for (int y = lowerY; y <= upperY; y++) {
                    BlockPosition blockPosition = new BlockPosition(player.getWorld(), x, y, z);
                    Material blockMaterial = blockPosition.getBlock().getType();
                    if (isNotAllowed(blockMaterial)) {
                        continue;
                    }
                    String blockName = getBlockId(blockPosition.getBlock());
                    int offsetX = x - base.getX();
                    int offsetY = y - base.getY();
                    int offsetZ = z - base.getZ();
                    BlockPosition offset = new BlockPosition(player.getWorld(), offsetX, offsetY, offsetZ);
                    blockPositions.put(offset, blockName);
                }
            }
        }
        try {
            JsonObject root = new JsonObject();
            JsonArray structure = new JsonArray();
            for (Map.Entry<BlockPosition, String> entry : blockPositions.entrySet()) {
                JsonObject blockObject = new JsonObject();
                BlockPosition offset = entry.getKey();
                blockObject.add("block_id", new JsonPrimitive(entry.getValue()));
                blockObject.add("x", new JsonPrimitive(offset.getX()));
                blockObject.add("y", new JsonPrimitive(offset.getY()));
                blockObject.add("z", new JsonPrimitive(offset.getZ()));
                structure.add(blockObject);
            }
            root.add("name", new JsonPrimitive(name));
            root.add("structure", structure);
            Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
            String path = Cultivation.getInstance().getDataFolder().getAbsolutePath() + File.separator;
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + name + ".json"));
            gson.toJson(root, bufferedWriter);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException ioException) {
            Cultivation.logError(ioException.getMessage());
        }
        System.out.println("saved");
    }

    @CommandCompletion("name")
    @Subcommand("loadStructure")
    public void loadStructure(CommandSender sender, String name) {
        if (!(sender instanceof Player player)) {
            return;
        }
        File file = new File(Cultivation.getInstance().getDataFolder() + File.separator + name + ".json");
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(file));
            JsonObject jsonObject = new Gson().fromJson(jsonReader, JsonObject.class);
            JsonArray jsonArray = jsonObject.getAsJsonArray("structure");
            Block base = player.getTargetBlockExact(20, FluidCollisionMode.NEVER);

            if (base == null) {
                return;
            }

            for (JsonElement jsonElement : jsonArray.asList()) {
                if (!(jsonElement instanceof JsonObject object)) {
                    continue;
                }

                int x = object.get("x").getAsInt();
                int y = object.get("y").getAsInt();
                int z = object.get("z").getAsInt();
                String blockId = object.get("block_id").getAsString();
                String[] idStrings = blockId.split(":");
                ItemStack itemStack;
                Location location = base.getLocation().clone().add(x, y, z);
                Block block = location.getBlock();
                if (idStrings[0].equals("slimefun")) {
                    SlimefunItem slimefunItem = SlimefunItem.getById(idStrings[1]);
                    if (slimefunItem == null) {
                        continue;
                        //todo better error handling
                    }
                    itemStack = slimefunItem.getItem();
                    Material material = itemStack.getType();
                    block.setType(material, true);
                    BlockStorage.store(block, slimefunItem.getId());
                } else {
                    itemStack = new ItemStack(Material.valueOf(idStrings[1]));
                    Material material = itemStack.getType();
                    block.setType(material);
                }
            }
        } catch (FileNotFoundException exception) {
            Cultivation.logError(exception.getMessage());
        }
    }

    private boolean isNotAllowed(@Nonnull Material material) {
        return material.isAir() || material == Material.WATER || material == Material.LAVA;
    }

    private String getBlockId(Block block) {
        Material blockMaterial = block.getType();
        SlimefunItem slimefunItem = BlockStorage.check(block);
        return slimefunItem == null
            ? "minecraft:" + blockMaterial.name()
            : "slimefun:" + slimefunItem.getId();
    }


}

