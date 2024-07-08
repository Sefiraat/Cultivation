package dev.sefiraat.cultivation.implementation.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.CommandPermission;
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
import dev.sefiraat.cultivation.api.datatypes.FloraLevelProfileDataType;
import dev.sefiraat.cultivation.api.datatypes.SeedPackDataType;
import dev.sefiraat.cultivation.api.datatypes.instances.FloraLevelProfile;
import dev.sefiraat.cultivation.api.datatypes.instances.SeedPackInstance;
import dev.sefiraat.cultivation.api.slimefun.items.plants.CultivationPlant;
import dev.sefiraat.cultivation.api.slimefun.items.trees.TreeBlockDescriptor;
import dev.sefiraat.cultivation.implementation.slimefun.tools.SeedPack;
import dev.sefiraat.sefilib.entity.display.DisplayGroup;
import dev.sefiraat.sefilib.string.Theme;
import io.github.bakedlibs.dough.blocks.BlockPosition;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Orientable;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Interaction;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@CommandAlias("cultivation|cv")
public class CultivationCommands extends BaseCommand {

    @Default
    public void onDefault(CommandSender sender) {
        sender.sendMessage(Theme.ERROR + "Please provide a valid subcommand.");
    }

    //TODO apply permissions
    @Subcommand("pos1")
    @CommandPermission("cultivation.admin.structures")
    public void onPos1(Player player) {
        BlockPosition position = Registry.getInstance().addPositionOne(player);
        player.sendMessage("Set position 1 to: %s %s %s".formatted(position.getX(), position.getY(), position.getZ()));
    }

    @Subcommand("pos2")
    @CommandPermission("cultivation.admin.structures")
    public void onPos2(Player player) {
        BlockPosition position = Registry.getInstance().addPositionTwo(player);
        player.sendMessage("Set position 2 to: %s %s %s".formatted(position.getX(), position.getY(), position.getZ()));
    }

    @CommandCompletion("name")
    @Subcommand("saveStructure")
    @CommandPermission("cultivation.admin.structures")
    public void saveStructure(Player player, String name) {
        BlockPosition pos1 = Registry.getInstance().getPositionOne(player);
        BlockPosition pos2 = Registry.getInstance().getPositionTwo(player);
        Block base = player.getTargetBlockExact(20, FluidCollisionMode.NEVER);
        if (pos1 == null || pos2 == null || base == null) {
            return;
            //todo send message
        }

        Map<TreeBlockDescriptor, String> blockDescriptors = new HashMap<>();

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
                    Block block = blockPosition.getBlock();
                    Material blockMaterial = block.getType();
                    if (isNotAllowed(blockMaterial)) {
                        continue;
                    }
                    String blockName = getBlockId(blockPosition.getBlock());
                    int offsetX = x - base.getX();
                    int offsetY = y - base.getY();
                    int offsetZ = z - base.getZ();
                    TreeBlockDescriptor descriptor = new TreeBlockDescriptor(blockName, offsetX, offsetY, offsetZ);

                    BlockData blockData = block.getBlockData();
                    if (blockData instanceof Orientable orientable) {
                        descriptor.setAxis(orientable.getAxis());
                    }

                    blockDescriptors.put(descriptor, blockName);
                }
            }
        }
        try {
            Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
            JsonObject root = new JsonObject();
            JsonArray structure = new JsonArray();
            for (Map.Entry<TreeBlockDescriptor, String> entry : blockDescriptors.entrySet()) {
                JsonObject blockObject = new JsonObject();
                TreeBlockDescriptor descriptor = entry.getKey();
                blockObject.add("block_id", new JsonPrimitive(descriptor.getName()));
                blockObject.add("x", new JsonPrimitive(descriptor.getX()));
                blockObject.add("y", new JsonPrimitive(descriptor.getY()));
                blockObject.add("z", new JsonPrimitive(descriptor.getZ()));
                if (descriptor.getBlockFace() != null) {
                    blockObject.add("direction", new JsonPrimitive(descriptor.getBlockFace().name()));
                }
                if (descriptor.getAxis() != null) {
                    blockObject.add("axis", new JsonPrimitive(descriptor.getAxis().name()));
                }
                structure.add(blockObject);
            }
            root.add("name", new JsonPrimitive(name));
            root.add("structure", structure);
            String path = Cultivation.getInstance().getDataFolder().getAbsolutePath() + File.separator;
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + name + ".json"));
            gson.toJson(root, bufferedWriter);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException ioException) {
            Cultivation.logError(ioException.getMessage());
        }

        Cultivation.logInfo("Saved Structure '%s'".formatted(name));
    }

    @CommandCompletion("name")
    @Subcommand("loadStructure")
    @CommandPermission("cultivation.admin.structures")
    public void loadStructure(Player player, String name) {
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

    @Subcommand("removeEntities")
    @CommandPermission("cultivation.admin.entities")
    public void removeDisplayGroups(Player player, int radius) {
        player.getWorld().getNearbyEntities(
                player.getLocation(),
                radius,
                radius,
                radius,
                Interaction.class::isInstance
        ).forEach(entity -> {
            DisplayGroup displayGroup = DisplayGroup.fromInteraction((Interaction) entity);
            if (displayGroup != null) {
                displayGroup.remove();
            }
        });
    }

    @CommandCompletion("growth_speed|drop_rate|strength 1|2|3|4|5|6|7|8|9|10")
    @Subcommand("modifyPlantStat")
    @CommandPermission("cultivation.admin.modify_stat")
    public void modifyPlantStat(Player player, String stat, int value) {
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        if (itemStack == null || itemStack.getType().isAir()) {
            player.sendMessage(Theme.WARNING.apply("You must be holding a Plant for this"));
            return;
        }

        SlimefunItem slimefunItem = SlimefunItem.getByItem(itemStack);
        if (!(slimefunItem instanceof CultivationPlant plant)) {
            player.sendMessage(Theme.WARNING.apply("You must be holding a Plant for this"));
            return;
        }

        if (value < 1 || value > 10) {
            player.sendMessage(Theme.WARNING.apply("Value must be between 1 and 10"));
            return;
        }

        FloraLevelProfile profile = PersistentDataAPI.get(
                itemStack.getItemMeta(),
                FloraLevelProfileDataType.KEY,
                FloraLevelProfileDataType.TYPE,
                new FloraLevelProfile(1, 1, 1, false)
        );

        switch (stat.toLowerCase(Locale.ROOT)) {
            case "growth_speed" -> profile.setSpeed(value);
            case "drop_rate" -> profile.setLevel(value);
            case "strength" -> profile.setStrength(value);
            default -> {
                player.sendMessage(Theme.WARNING.apply("Invalid plant stat. Must be growth_speed, drop_rate, or strength."));
                return;
            }
        };

        ItemStack newStack = CultivationPlant.getStack(plant, profile);
        newStack.setAmount(itemStack.getAmount());
        player.getInventory().setItemInMainHand(newStack);
    }

    @CommandCompletion("true|false")
    @Subcommand("modifyPlantAnalyzed")
    @CommandPermission("cultivation.admin.modify_analyzed")
    public void modifyPlantAnalyzed(Player player, boolean analyzed) {
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        if (itemStack == null || itemStack.getType().isAir()) {
            player.sendMessage(Theme.WARNING.apply("You must be holding a Plant for this"));
            return;
        }

        SlimefunItem slimefunItem = SlimefunItem.getByItem(itemStack);
        if (!(slimefunItem instanceof CultivationPlant plant)) {
            player.sendMessage(Theme.WARNING.apply("You must be holding a Plant for this"));
            return;
        }

        ItemMeta itemMeta = itemStack.getItemMeta();
        FloraLevelProfile profile = PersistentDataAPI.get(
                itemMeta,
                FloraLevelProfileDataType.KEY,
                FloraLevelProfileDataType.TYPE,
                new FloraLevelProfile(1, 1, 1, false)
        );

        profile.setAnalyzed(analyzed);
        ItemStack newStack = CultivationPlant.getStack(plant, profile);
        newStack.setAmount(itemStack.getAmount());
        player.getInventory().setItemInMainHand(newStack);
    }

    @Subcommand("packpeek")
    public void packPeek(Player player) {
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        if (itemStack == null || itemStack.getType().isAir()) {
            player.sendMessage(Theme.WARNING.apply("You must be holding a Seed Pack for this"));
            return;
        }

        SlimefunItem slimefunItem = SlimefunItem.getByItem(itemStack);
        if (!(slimefunItem instanceof SeedPack)) {
            player.sendMessage(Theme.WARNING.apply("You must be holding a Seed Pack for this"));
            return;
        }

        ItemMeta itemMeta = itemStack.getItemMeta();
        SeedPackInstance instance = PersistentDataAPI.get(itemMeta, SeedPackDataType.KEY, SeedPackDataType.TYPE);
        if (instance == null) {
            player.sendMessage(Theme.WARNING.apply("This pack is empty!"));
            return;
        }

        player.sendMessage("------------------------------------");
        player.sendMessage("Contents");
        player.sendMessage("------------------------------------");
        for (Map.Entry<FloraLevelProfile, Integer> entry : instance.getAmountMap().entrySet()) {
            FloraLevelProfile profile = entry.getKey();
            String neatKey =
                    " Lv: " + profile.getLevel() +
                    " Sp: " + profile.getSpeed() +
                    " St: " + profile.getStrength();
            player.sendMessage(Theme.CLICK_INFO.asTitle(neatKey, entry.getValue()));
        }
    }
}

