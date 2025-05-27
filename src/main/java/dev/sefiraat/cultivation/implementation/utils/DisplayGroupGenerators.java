package dev.sefiraat.cultivation.implementation.utils;

import dev.sefiraat.sefilib.entity.display.DisplayGroup;
import dev.sefiraat.sefilib.entity.display.builders.BlockDisplayBuilder;
import dev.sefiraat.sefilib.entity.display.builders.ItemDisplayBuilder;
import dev.sefiraat.sefilib.entity.display.builders.TextDisplayBuilder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Display;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.TextDisplay;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;
import java.util.Map;

public final class DisplayGroupGenerators {

    private DisplayGroupGenerators() {
        throw new IllegalStateException("Utility class");
    }

    public static DisplayGroup generateCrossedCropStickGroup(@Nonnull Location location) {
        final DisplayGroup displayGroup = generateCropStickGroup(location);
        displayGroup.addDisplay(
            "flat_z_1",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0, 1, -0.43))
                .setItemStack(new ItemStack(Material.STICK))
                .setTransformation(Transformations.STICK_FLAT_Z_ALIGN.getTransformation())
                .build(displayGroup)
        );
        displayGroup.addDisplay(
            "flat_z_2",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0, 1, 0.5))
                .setItemStack(new ItemStack(Material.STICK))
                .setTransformation(Transformations.STICK_FLAT_Z_ALIGN.getTransformation())
                .build(displayGroup)
        );
        displayGroup.addDisplay(
            "flat_x_1",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0.45, 1, 0))
                .setItemStack(new ItemStack(Material.STICK))
                .setTransformation(Transformations.STICK_FLAT_X_ALIGN.getTransformation())
                .build(displayGroup)
        );
        displayGroup.addDisplay(
            "flat_x_2",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(-0.35, 1, 0))
                .setItemStack(new ItemStack(Material.STICK))
                .setTransformation(Transformations.STICK_FLAT_X_ALIGN.getTransformation())
                .build(displayGroup)
        );
        return displayGroup;
    }

    public static DisplayGroup generateCropStickGroup(@Nonnull Location location) {
        final DisplayGroup displayGroup = new DisplayGroup(location, 0, 0);
        displayGroup.addDisplay(
            "standing_1",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(-0.45, 0.5, -0.47))
                .setItemStack(new ItemStack(Material.STICK))
                .setTransformation(Transformations.STICK_POINT_UPRIGHT.getTransformation())
                .build(displayGroup)
        );
        displayGroup.addDisplay(
            "standing_2",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0.37, 0.5, -0.47))
                .setItemStack(new ItemStack(Material.STICK))
                .setTransformation(Transformations.STICK_POINT_UPRIGHT.getTransformation())
                .build(displayGroup)
        );
        displayGroup.addDisplay(
            "standing_3",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0.37, 0.5, 0.47))
                .setItemStack(new ItemStack(Material.STICK))
                .setTransformation(Transformations.STICK_POINT_UPRIGHT.getTransformation())
                .build(displayGroup)
        );
        displayGroup.addDisplay(
            "standing_4",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(-0.45, 0.5, 0.47))
                .setItemStack(new ItemStack(Material.STICK))
                .setTransformation(Transformations.STICK_POINT_UPRIGHT.getTransformation())
                .build(displayGroup)
        );
        return displayGroup;
    }

    public static DisplayGroup generateCloche(@Nonnull Location location) {
        final DisplayGroup displayGroup = new DisplayGroup(location, 1.5f, 0.5f);
        displayGroup.addDisplay(
            "cloche_base",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0, 0.5, 0))
                .setItemStack(new ItemStack(Material.STRIPPED_MANGROVE_LOG))
                .setTransformation(Transformations.CLOCHE_BASE.getTransformation())
                .build(displayGroup)
        );
        displayGroup.addDisplay(
            "cloche_glass",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0, 1.25, 0))
                .setItemStack(new ItemStack(Material.GLASS))
                .setTransformation(Transformations.CLOCHE_GLASS.getTransformation())
                .build(displayGroup)
        );
        displayGroup.addDisplay(
            "cloche_dirt",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0, 0.85, 0))
                .setItemStack(new ItemStack(Material.DIRT))
                .setTransformation(Transformations.CLOCHE_DIRT.getTransformation())
                .build(displayGroup)
        );
        displayGroup.addDisplay(
            "plant",
            new ItemDisplayBuilder()
                .setItemStack(new ItemStack(Material.AIR))
                .setGroupParentOffset(new Vector(0, 1.25, 0))
                .setTransformation(Transformations.HIDDEN.getTransformation())
                .build(displayGroup)
        );
        return displayGroup;
    }

    public static void addPlantToCloche(@Nonnull DisplayGroup displayGroup) {
        final Map<String, Display> displays = displayGroup.getDisplays();
        if (!displays.containsKey("plant")) {
            displayGroup.addDisplay(
                    "plant",
                    new ItemDisplayBuilder()
                        .setItemStack(new ItemStack(Material.AIR))
                        .setGroupParentOffset(new Vector(0, 1.25, 0))
                        .setTransformation(Transformations.HIDDEN.getTransformation())
                        .build(displayGroup)
            );
        }
        updateItemDisplay(displayGroup, "plant", Transformations.PLANT_HANGING_DROP, new ItemStack(Material.SMALL_DRIPLEAF));
    }

    public static void hidePlantInCloche(@Nonnull DisplayGroup displayGroup) {
        if (displayGroup.getDisplays().get("plant") instanceof ItemDisplay itemDisplay) {
            itemDisplay.setItemStack(new ItemStack(Material.AIR));
            itemDisplay.setInterpolationDelay(-1);
            itemDisplay.setInterpolationDuration(4);
            itemDisplay.setTransformation(Transformations.HIDDEN.getTransformation());
        }
    }

    public static DisplayGroup generatePlant(@Nonnull Location location) {
        final DisplayGroup displayGroup = new DisplayGroup(location);
        displayGroup.addDisplay(
            "plant",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0, 0.5, 0))
                .setTransformation(Transformations.DEFAULT_TRANSFORMATION.getTransformation())
                .setItemStack(new ItemStack(Material.SMALL_DRIPLEAF))
                .build(displayGroup)
        );
        return displayGroup;
    }

    public static DisplayGroup generateBush(@Nonnull Location location) {
        final DisplayGroup displayGroup = new DisplayGroup(location);
        displayGroup.addDisplay(
            "bush",
            new BlockDisplayBuilder()
                .setGroupParentOffset(new Vector(-0.5, 0, -0.5))
                .setBlockData(Material.SWEET_BERRY_BUSH.createBlockData())
                .build(displayGroup)
        );
        return displayGroup;
    }

    public static void setBushAge(@Nonnull DisplayGroup displayGroup, int age) {
        BlockDisplay blockDisplay = (BlockDisplay) displayGroup.getDisplays().get("bush");
        BlockData blockData = blockDisplay.getBlock();
        if (blockData instanceof Ageable ageable) {
            ageable.setAge(age);
            blockDisplay.setBlock(ageable);
        }
    }

    public static void growItemsInPlant(@Nonnull DisplayGroup displayGroup, @Nonnull Material material) {
        growItemsInPlant(displayGroup, new ItemStack(material));
    }

    public static void growItemsInPlant(@Nonnull DisplayGroup displayGroup, @Nonnull ItemStack itemStack) {
        final Map<String, Display> displays = displayGroup.getDisplays();
        if (!displays.containsKey("drop_1")) {
            displayGroup.addDisplay(
                    "drop_1",
                    new ItemDisplayBuilder()
                            .setGroupParentOffset(new Vector(0.32, 0.08, 0.32))
                            .setItemStack(itemStack)
                            .setTransformation(Transformations.HIDDEN.getTransformation())
                            .build(displayGroup)
            );
        }
        updateItemDisplay(displayGroup, "drop_1", Transformations.PLANT_HANGING_DROP, itemStack);
        if (!displays.containsKey("drop_2")) {
            displayGroup.addDisplay(
                    "drop_2",
                    new ItemDisplayBuilder()
                            .setGroupParentOffset(new Vector(-0.32, 0.39, -0.32))
                            .setItemStack(itemStack)
                            .setTransformation(Transformations.HIDDEN.getTransformation())
                            .build(displayGroup)
            );
        }
        updateItemDisplay(displayGroup, "drop_2", Transformations.PLANT_HANGING_DROP, itemStack);
        if (!displays.containsKey("drop_3")) {
            displayGroup.addDisplay(
                    "drop_3",
                    new ItemDisplayBuilder()
                            .setGroupParentOffset(new Vector(-0.32, 0.64, 0.32))
                            .setItemStack(itemStack)
                            .setTransformation(Transformations.HIDDEN.getTransformation())
                            .build(displayGroup)
            );
        }
        updateItemDisplay(displayGroup, "drop_3", Transformations.PLANT_HANGING_DROP, itemStack);
    }

    public static void growItemsInBush(@Nonnull DisplayGroup displayGroup, @Nonnull Material material) {
        growItemsInBush(displayGroup, new ItemStack(material));
    }

    public static void growItemsInBush(@Nonnull DisplayGroup displayGroup, @Nonnull ItemStack itemStack) {
        final Map<String, Display> displays = displayGroup.getDisplays();
        if (!displays.containsKey("drop_1")) {
            displayGroup.addDisplay(
                    "drop_1",
                    new ItemDisplayBuilder()
                            .setGroupParentOffset(new Vector(0.32, 0.19, 0.32))
                            .setItemStack(itemStack)
                            .setTransformation(Transformations.HIDDEN.getTransformation())
                            .build(displayGroup)
            );
        }
        updateItemDisplay(displayGroup, "drop_1", Transformations.BUSH_HANGING_DROP, itemStack);
        if (!displays.containsKey("drop_2")) {
            displayGroup.addDisplay(
                    "drop_2",
                    new ItemDisplayBuilder()
                            .setGroupParentOffset(new Vector(-0.32, 0.43, -0.32))
                            .setItemStack(itemStack)
                            .setTransformation(Transformations.HIDDEN.getTransformation())
                            .build(displayGroup)
            );
        }
        updateItemDisplay(displayGroup, "drop_2", Transformations.BUSH_HANGING_DROP, itemStack);
        if (!displays.containsKey("drop_3")) {
            displayGroup.addDisplay(
                    "drop_3",
                    new ItemDisplayBuilder()
                            .setGroupParentOffset(new Vector(-0.32, 0.71, 0.32))
                            .setItemStack(itemStack)
                            .setTransformation(Transformations.HIDDEN.getTransformation())
                            .build(displayGroup)
            );
        }
        updateItemDisplay(displayGroup, "drop_3", Transformations.BUSH_HANGING_DROP, itemStack);
    }

    public static void updateItemDisplay(@Nonnull DisplayGroup displayGroup, @Nonnull String displayName, Transformations transformation, @Nonnull ItemStack itemStack) {
        final Display display = displayGroup.getDisplays().get(displayName);
        if (display instanceof ItemDisplay itemDisplay) {
            itemDisplay.setItemStack(itemStack);
            itemDisplay.setInterpolationDelay(-1);
            itemDisplay.setInterpolationDuration(20);
            itemDisplay.setTransformation(transformation.getTransformation());
        }
    }

    public static void hideItemsInPlant(@Nonnull DisplayGroup displayGroup) {
        final Map<String, Display> displays = displayGroup.getDisplays();
        final Display drop1 = displays.get("drop_1");
        if (drop1 != null) {
            drop1.setInterpolationDelay(-1);
            drop1.setInterpolationDuration(2);
            drop1.setTransformation(Transformations.HIDDEN.getTransformation());
        }
        final Display drop2 = displays.get("drop_2");
        if (drop2 != null) {
            drop2.setInterpolationDelay(-1);
            drop2.setInterpolationDuration(2);
            drop2.setTransformation(Transformations.HIDDEN.getTransformation());
        }
        final Display drop3 = displays.get("drop_3");
        if (drop3 != null) {
            drop3.setInterpolationDelay(-1);
            drop3.setInterpolationDuration(2);
            drop3.setTransformation(Transformations.HIDDEN.getTransformation());
        }
    }

    public static DisplayGroup generateBaseCounter(@Nonnull Location location) {
        final DisplayGroup displayGroup = new DisplayGroup(location, 1.01f, 1.01f);
        displayGroup.addDisplay(
            "counter_base",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0, 0.4, 0))
                .setItemStack(new ItemStack(Material.STRIPPED_DARK_OAK_LOG))
                .setTransformation(Transformations.COUNTER_BODY.getTransformation())
                .build(displayGroup)
        );
        displayGroup.addDisplay(
            "counter_top",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0, 0.8, 0))
                .setItemStack(new ItemStack(Material.WHITE_CONCRETE))
                .setTransformation(Transformations.COUNTER_TOP.getTransformation())
                .build(displayGroup)
        );
        return displayGroup;
    }

    public static DisplayGroup generateChoppingCounter(@Nonnull Location location) {
        DisplayGroup displayGroup = generateBaseCounter(location);
        displayGroup.addDisplay(
            "chopping_board",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0.1, 0.9, 0.15))
                .setItemStack(new ItemStack(Material.POLISHED_BLACKSTONE))
                .setTransformation(Transformations.CHOPPING_BOARD.getTransformation())
                .build(displayGroup)
        );
        displayGroup.addDisplay(
            "knife",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0.1, 0.95, 0.15))
                .setItemStack(new ItemStack(Material.IRON_SWORD))
                .setTransformation(Transformations.CHOPPING_BOARD_KNIFE.getTransformation())
                .build(displayGroup)
        );
        return displayGroup;
    }

    public static DisplayGroup generateBlenderCounter(@Nonnull Location location) {
        DisplayGroup displayGroup = generateBaseCounter(location);
        displayGroup.addDisplay(
            "blender_base",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(-0.3, 0.9, -0.3))
                .setItemStack(new ItemStack(Material.QUARTZ_BLOCK))
                .setTransformation(Transformations.BLENDER_BASE.getTransformation())
                .build(displayGroup)
        );
        displayGroup.addDisplay(
            "blender_top",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(-0.3, 1.15, -0.3))
                .setItemStack(new ItemStack(Material.GLASS))
                .setTransformation(Transformations.BLENDER_TOP.getTransformation())
                .build(displayGroup)
        );
        return displayGroup;
    }

    public static DisplayGroup generateSlicingCounter(@Nonnull Location location) {
        DisplayGroup displayGroup = generateBaseCounter(location);
        displayGroup.addDisplay(
            "chopping_board",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0.2, 0.9, 0.3))
                .setItemStack(new ItemStack(Material.LAPIS_BLOCK))
                .setTransformation(Transformations.CHOPPING_BOARD_2.getTransformation())
                .build(displayGroup)
        );
        displayGroup.addDisplay(
            "knife",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0.2, 0.95, 0.3))
                .setItemStack(new ItemStack(Material.SHEARS))
                .setTransformation(Transformations.CHOPPING_BOARD_KNIFE_2.getTransformation())
                .build(displayGroup)
        );
        return displayGroup;
    }

    public static DisplayGroup generateMashingCounter(@Nonnull Location location) {
        DisplayGroup displayGroup = generateBaseCounter(location);
        displayGroup.addDisplay(
            "bowl",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0.05, 0.92, 0.1))
                .setItemStack(new ItemStack(Material.COMPOSTER))
                .setTransformation(Transformations.MASHING_BOWL.getTransformation())
                .build(displayGroup)
        );
        displayGroup.addDisplay(
            "masher",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0.1, 0.85, -0.3))
                .setItemStack(new ItemStack(Material.NETHERITE_HOE))
                .setTransformation(Transformations.MASHER.getTransformation())
                .build(displayGroup)
        );
        return displayGroup;
    }

    public static DisplayGroup generateGrindingCounter(@Nonnull Location location) {
        DisplayGroup displayGroup = generateBaseCounter(location);
        BlockData blockData = Material.CAULDRON.createBlockData();
        displayGroup.addDisplay(
            "bowl",
            new BlockDisplayBuilder()
                .setGroupParentOffset(new Vector(0.1, 0.82, -0.2))
                .setBlockData(blockData)
                .setTransformation(Transformations.GRINDING_BOWL.getTransformation(false))
                .build(displayGroup)
        );
        displayGroup.addDisplay(
            "bone",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(-0.1, 0.85, 0.3))
                .setItemStack(new ItemStack(Material.BONE))
                .setTransformation(Transformations.BONE.getTransformation())
                .build(displayGroup)
        );
        return displayGroup;
    }

    public static DisplayGroup generateOvenCounter(@Nonnull Location location) {
        DisplayGroup displayGroup = generateBaseCounter(location);
        displayGroup.addDisplay(
            "oven_door",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0, 0.34, 0.45))
                .setItemStack(new ItemStack(Material.POLISHED_BLACKSTONE))
                .setTransformation(Transformations.OVEN_DOOR.getTransformation())
                .build(displayGroup)
        );
        displayGroup.addDisplay(
            "buttons",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0, 0.68, 0.45))
                .setItemStack(new ItemStack(Material.ACTIVATOR_RAIL))
                .setTransformation(Transformations.COOKING_BUTTONS.getTransformation())
                .build(displayGroup)
        );
        return displayGroup;
    }

    public static DisplayGroup generateFryingCounter(@Nonnull Location location) {
        DisplayGroup displayGroup = generateBaseCounter(location);
        displayGroup.addDisplay(
            "hob",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0, 0.85, 0))
                .setItemStack(new ItemStack(Material.TINTED_GLASS))
                .setTransformation(Transformations.FRY_HOB.getTransformation())
                .build(displayGroup)
        );
        displayGroup.addDisplay(
            "hob_core",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0, 0.82, 0))
                .setItemStack(new ItemStack(Material.BLACK_CONCRETE))
                .setTransformation(Transformations.FRY_HOB_CORE.getTransformation())
                .build(displayGroup)
        );
        displayGroup.addDisplay(
            "buttons",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0, 0.68, 0.45))
                .setItemStack(new ItemStack(Material.ACTIVATOR_RAIL))
                .setTransformation(Transformations.COOKING_BUTTONS.getTransformation())
                .build(displayGroup)
        );
        return displayGroup;
    }

    public static DisplayGroup generateBoilingCounter(@Nonnull Location location) {
        DisplayGroup displayGroup = generateFryingCounter(location);
        Levelled blockData = (Levelled) Material.WATER_CAULDRON.createBlockData();
        blockData.setLevel(3);
        displayGroup.addDisplay(
            "pot",
            new BlockDisplayBuilder()
                .setGroupParentOffset(new Vector(-0.15, 0.85, -0.15))
                .setBlockData(blockData)
                .setTransformation(Transformations.BOILING_POT.getTransformation(false))
                .build(displayGroup)
        );

        return displayGroup;
    }

    public static DisplayGroup generateFinishingCounter(@Nonnull Location location) {
        DisplayGroup displayGroup = generateBaseCounter(location);
        displayGroup.addDisplay(
            "hob",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0, 0.85, 0))
                .setItemStack(new ItemStack(Material.POLISHED_DIORITE))
                .setTransformation(Transformations.FRY_HOB.getTransformation())
                .build(displayGroup)
        );
        return displayGroup;
    }

    public static DisplayGroup generateGrillingCounter(@Nonnull Location location) {
        DisplayGroup displayGroup = generateBaseCounter(location);
        displayGroup.addDisplay(
            "grill_door",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0, 0.50, 0.45))
                .setItemStack(new ItemStack(Material.POLISHED_BLACKSTONE))
                .setTransformation(Transformations.GRILL_DOOR.getTransformation())
                .build(displayGroup)
        );
        displayGroup.addDisplay(
            "buttons",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0, 0.68, 0.45))
                .setItemStack(new ItemStack(Material.ACTIVATOR_RAIL))
                .setTransformation(Transformations.COOKING_BUTTONS.getTransformation())
                .build(displayGroup)
        );
        return displayGroup;
    }

    public static void addNameToGroup(@Nonnull DisplayGroup displayGroup, @Nonnull String name) {
        removeNameFromGroup(displayGroup);
        displayGroup.addDisplay(
            "name",
            new TextDisplayBuilder()
                .setGroupParentOffset(new Vector(0, 1.5, 0))
                .setBillboard(Display.Billboard.VERTICAL)
                .setLineWidth(100)
                .setSeeThrough(true)
                .setTextOpacity((byte) 40)
                .setTextAlignment(TextDisplay.TextAlignment.CENTER)
                .setText(name)
                .build(displayGroup)
        );
    }

    public static void removeNameFromGroup(@Nonnull DisplayGroup displayGroup) {
        displayGroup.killDisplay("name");
    }

    public static boolean hasName(@Nonnull DisplayGroup displayGroup) {
        return displayGroup.getDisplays().containsKey("name");
    }
}
