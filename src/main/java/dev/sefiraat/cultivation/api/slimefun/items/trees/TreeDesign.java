package dev.sefiraat.cultivation.api.slimefun.items.trees;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import dev.sefiraat.cultivation.Cultivation;
import io.github.bakedlibs.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
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
import java.util.ArrayList;
import java.util.List;

public enum TreeDesign {

    BASIC_1("tree_1"),
    BASIC_2("tree_2"),
    BASIC_3("tree_3"),
    BASIC_4("tree_4"),
    BASIC_5("tree_5"),
    BASIC_6("tree_6"),
    ACACIA_1("tree_acacia_bwhite_4"),
    ACACIA_2("tree_acacia_oddish_1"),
    BIRCH_1("tree_birch_bwhite_2"),
    BIRCH_2("tree_birch_oddish_3"),
    CHERRY_1("tree_cherry_decoy_3"),
    CHRISTMAS_1("tree_christmas_style_decoy_2"),
    DARK_OAK_1("tree_darkoak_bwhite_1"),
    DARK_OAK_2("tree_jungle_bwhite_3"),
    JUNGLE_1("tree_jungle_oddish_1"),
    JUNGLE_2("tree_jungle_bwhite_3"),
    MANGROVE_1("tree_mangrove_decoy_1"),
    OAK_1("tree_oak_oddish_4"),
    OAK_2("tree_oak_oddish_5");

    public final String location;
    public String author;
    public final List<TreeBlockDescriptor> descriptors = new ArrayList<>();

    TreeDesign(@Nonnull String fileLocation) {
        this.location = fileLocation;
        loadTreeDesign();
    }

    private void loadTreeDesign() {
        InputStream stream = Cultivation.class.getResourceAsStream("/trees/" + location + ".json");

        if (stream == null) {
            return;
        }

        JsonReader jsonReader = new JsonReader(new InputStreamReader(stream));
        JsonObject jsonObject = new Gson().fromJson(jsonReader, JsonObject.class);
        JsonArray jsonArray = jsonObject.getAsJsonArray("structure");
        this.author = jsonObject.get("author").getAsString();

        for (JsonElement jsonElement : jsonArray.asList()) {
            if (!(jsonElement instanceof JsonObject object)) {
                continue;
            }

            int x = object.get("x").getAsInt();
            int y = object.get("y").getAsInt();
            int z = object.get("z").getAsInt();
            JsonElement blockFaceElement = object.get("direction");
            String blockFaceString = blockFaceElement == null ? null : blockFaceElement.getAsString();
            JsonElement axisElement = object.get("axis");
            String axisString = axisElement == null ? null : axisElement.getAsString();
            String blockId = object.get("block_id").getAsString();

            TreeBlockDescriptor descriptor = new TreeBlockDescriptor(blockId, x, y, z);

            if (axisString != null) {
                descriptor.setAxis(Axis.valueOf(axisString));
            }

            if (blockFaceString != null) {
                descriptor.setBlockFace(BlockFace.valueOf(blockFaceString));
            }
            descriptors.add(descriptor);
        }
    }

    public boolean testBuild(@Nonnull Location location) {
        for (TreeBlockDescriptor descriptor : this.descriptors) {
            int x = descriptor.getX();
            int y = descriptor.getY();
            int z = descriptor.getZ();
            Block block = location.clone().add(x, y, z).getBlock();
            if (x == 0 && y == 0 && z == 0) {
                continue;
            }
            if (!block.getType().isAir()) {
                return false;
            }
        }
        return true;
    }

    public void grow(@Nonnull Location location, @Nonnull CultivationTree tree) {
        for (TreeBlockDescriptor descriptor : this.descriptors) {
            int x = descriptor.getX();
            int y = descriptor.getY();
            int z = descriptor.getZ();
            String blockId = descriptor.getName();
            Axis axis = descriptor.getAxis();
            BlockFace blockFace = descriptor.getBlockFace();
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
                applyBlock(tree, itemStack, blockFace, axis, block);
                // temp setting tree item - for reusable trees.
                if (slimefunItem.getItem().getType() == Material.PLAYER_HEAD) {
                    BlockStorage.store(block, tree.getProduce().getId());
                } else {
                    BlockStorage.store(block, slimefunItem.getId());
                }
            } else {
                itemStack = new ItemStack(Material.valueOf(idStrings[1]));
                applyBlock(tree, itemStack, blockFace, axis, block);
            }
        }
    }

    @ParametersAreNullableByDefault
    private void applyBlock(@Nonnull CultivationTree tree,
                            @Nonnull ItemStack itemStack,
                            BlockFace face,
                            Axis axis,
                            @Nonnull Block block
    ) {
        if (itemStack.getType() == Material.PLAYER_HEAD) {
            block.setType(face != null ? Material.PLAYER_WALL_HEAD : Material.PLAYER_HEAD, true);
            PlayerHead.setSkin(block, tree.getSkin().getPlayerSkin(), true);
        } else {
            block.setType(itemStack.getType(), true);
            if (Tag.LEAVES.isTagged(itemStack.getType())) {
                BlockStorage.store(block, tree.getLeaves().getId());
            }
        }

        if (face != null) {
            Rotatable rotational = (Rotatable) block.getBlockData();
            rotational.setRotation(face);
            block.setBlockData(rotational);
        }

        if (axis != null) {
            Orientable orientable = (Orientable) block.getBlockData();
            orientable.setAxis(axis);
            block.setBlockData(orientable);
        }
    }
}
