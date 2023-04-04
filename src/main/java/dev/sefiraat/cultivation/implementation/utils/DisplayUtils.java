package dev.sefiraat.cultivation.implementation.utils;

import dev.sefiraat.sefilib.entity.display.DisplayGroup;
import dev.sefiraat.sefilib.entity.display.builders.ItemDisplayBuilder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;

public final class DisplayUtils {

    private DisplayUtils() {
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
        return displayGroup;
    }

    public static void addPlantToCloche(@Nonnull DisplayGroup displayGroup) {
        displayGroup.addDisplay(
            "plant",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0, 1.25, 0))
                .setTransformation(Transformations.CLOCHE_GLASS.getTransformation())
                .setItemStack(new ItemStack(Material.SMALL_DRIPLEAF))
                .build(displayGroup)
        );
    }

    public static void removePlantFromCloche(@Nonnull DisplayGroup displayGroup) {
        displayGroup.killDisplay("plant");
    }

    public static DisplayGroup generatePlant(@Nonnull Location location) {
        final DisplayGroup displayGroup = new DisplayGroup(location);
        displayGroup.addDisplay(
            "plant",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0, 0.5, 0))
                .setItemStack(new ItemStack(Material.SMALL_DRIPLEAF))
                .build(displayGroup)
        );
        return displayGroup;
    }

    public static void addItemsToPlant(@Nonnull DisplayGroup displayGroup, @Nonnull Material material) {
        displayGroup.addDisplay(
            "drop_1",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(0.32, 0.08, 0.32))
                .setItemStack(new ItemStack(material))
                .setTransformation(Transformations.PLANT_HANGING_DROP.getTransformation())
                .build(displayGroup)
        );
        displayGroup.addDisplay(
            "drop_2",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(-0.32, 0.39, -0.32))
                .setItemStack(new ItemStack(material))
                .setTransformation(Transformations.PLANT_HANGING_DROP.getTransformation())
                .build(displayGroup)
        );
        displayGroup.addDisplay(
            "drop_3",
            new ItemDisplayBuilder()
                .setGroupParentOffset(new Vector(-0.32, 0.64, 0.32))
                .setItemStack(new ItemStack(material))
                .setTransformation(Transformations.PLANT_HANGING_DROP.getTransformation())
                .build(displayGroup)
        );
    }

    public static void removeItemsFromPlant(@Nonnull DisplayGroup displayGroup) {
        displayGroup.killDisplay("drop_1");
        displayGroup.killDisplay("drop_2");
        displayGroup.killDisplay("drop_3");
    }
}
