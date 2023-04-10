package dev.sefiraat.cultivation.api.slimefun.items.trees;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.items.produce.ProduceCore;
import dev.sefiraat.cultivation.api.utils.Skins;
import io.github.bakedlibs.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Axis;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Orientable;
import org.bukkit.block.data.Rotatable;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNullableByDefault;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CultivationTree extends SlimefunItem {

    private final String treeFileName;
    private final ProduceCore produce;
    private final Skins skin;
    private final CultivationLeaves leaves;

    public CultivationTree(ItemGroup itemGroup,
                           SlimefunItemStack item,
                           String treeFileName,
                           ProduceCore produce,
                           Skins skin
    ) {
        super(itemGroup, item, RecipeType.NULL, new ItemStack[0]);
        this.treeFileName = treeFileName;
        this.produce = produce;
        this.skin = skin;
        leaves = new CultivationLeaves(this).buildRegister(Cultivation.getInstance());
    }

    public void grow(@Nonnull Location location) {
        InputStream stream = Cultivation.class.getResourceAsStream("/trees/" + treeFileName + ".json");

        if (stream == null) {
            return;
        }

        JsonReader jsonReader = new JsonReader(new InputStreamReader(stream));
        JsonObject jsonObject = new Gson().fromJson(jsonReader, JsonObject.class);
        JsonArray jsonArray = jsonObject.getAsJsonArray("structure");

        for (JsonElement jsonElement : jsonArray.asList()) {
            if (!(jsonElement instanceof JsonObject object)) {
                continue;
            }

            int x = object.get("x").getAsInt();
            int y = object.get("y").getAsInt();
            int z = object.get("z").getAsInt();
            JsonElement blockFaceElement = object.get("direction");
            String blockFaceString = blockFaceElement == null ? null :blockFaceElement.getAsString();
            JsonElement axisElement = object.get("axis");
            String axisString = axisElement == null ? null : axisElement.getAsString();
            String blockId = object.get("block_id").getAsString();
            String[] idStrings = blockId.split(":");
            ItemStack itemStack;
            Location placeLocation = location.clone().add(x, y, z);
            Block block = placeLocation.getBlock();
            if (idStrings[0].equals("slimefun")) {
                SlimefunItem slimefunItem = SlimefunItem.getById(idStrings[1]);
                if (slimefunItem == null) {
                    continue;
                }
                itemStack = slimefunItem.getItem();
                applyBlock(itemStack, blockFaceString, axisString, block);
                // temp setting tree item - for reusable trees.
                if (slimefunItem.getItem().getType() == Material.PLAYER_HEAD) {
                    BlockStorage.store(block, produce.getId());
                } else {
                    BlockStorage.store(block, slimefunItem.getId());
                }
            } else {
                itemStack = new ItemStack(Material.valueOf(idStrings[1]));
                applyBlock(itemStack, blockFaceString, axisString, block);
            }
        }
    }

    @ParametersAreNullableByDefault
    private void applyBlock(@Nonnull ItemStack itemStack, String rotationalFace, String axisString, @Nonnull Block block) {
        if (itemStack.getType() == Material.PLAYER_HEAD) {
            block.setType(rotationalFace != null ? Material.PLAYER_WALL_HEAD : Material.PLAYER_HEAD, true);
            PlayerHead.setSkin(block, skin.getPlayerSkin(), true);
        } else {
            block.setType(itemStack.getType(), true);
            if (Tag.LEAVES.isTagged(itemStack.getType())) {
                BlockStorage.store(block, leaves.getId());
            }
        }

        if (rotationalFace != null) {
            Rotatable rotational = (Rotatable) block.getBlockData();
            rotational.setRotation(BlockFace.valueOf(rotationalFace));
            block.setBlockData(rotational);
        }

        if (axisString != null) {
            Orientable orientable = (Orientable) block.getBlockData();
            orientable.setAxis(Axis.valueOf(axisString));
            block.setBlockData(orientable);
        }
    }

    public CultivationTree buildRegister(@Nonnull SlimefunAddon addon) {
        register(addon);
        return this;
    }

}
