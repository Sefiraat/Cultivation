package dev.sefiraat.cultivation.api.interfaces;

import dev.sefiraat.cultivation.implementation.utils.DisplayUtils;
import dev.sefiraat.sefilib.entity.display.DisplayGroup;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.UUID;

public interface CultivationPlantHolder {

    String PLANT = "plant_display_present";
    String GROUP_PARENT = "plant_display_group";

    default boolean hasDisplayPlant(@Nonnull Block block) {
        return hasDisplayPlant(block.getLocation());
    }

    default boolean hasDisplayPlant(@Nonnull Location location) {
        String cropped = BlockStorage.getLocationInfo(location, PLANT);
        return Boolean.parseBoolean(cropped);
    }

    default boolean hasDisplayPlant(@Nonnull Config config) {
        String cropped = config.getString(PLANT);
        return Boolean.parseBoolean(cropped);
    }

    default void removePlant(@Nonnull Location location) {
        removePlantDisplayGroup(location);
        BlockStorage.addBlockInfo(location, PLANT, null);
        BlockStorage.addBlockInfo(location, GROUP_PARENT, null);
    }

    default void addDisplayPlant(@Nonnull Location location) {
        DisplayGroup displayGroup = DisplayUtils.generatePlant(location.clone().add(0.5, 0, 0.5));
        BlockStorage.addBlockInfo(location, PLANT, "true");
        BlockStorage.addBlockInfo(location, GROUP_PARENT, displayGroup.getParentUUID().toString());
    }

    default void addItemsToDisplay(@Nonnull Location location, @Nonnull Material material) {
        if (hasDisplayPlant(location)) {
            DisplayGroup group = getPlantDisplayGroup(location);
            DisplayUtils.addItemsToPlant(group, material);
        }
    }

    default void removeItems(@Nonnull Location location) {
        if (hasDisplayPlant(location)) {
            DisplayGroup group = getPlantDisplayGroup(location);
            DisplayUtils.removeItemsFromPlant(group);
        }
    }

    @Nullable
    default UUID getPlantDisplayGroupUUID(@Nonnull Location location) {
        String uuid = BlockStorage.getLocationInfo(location, GROUP_PARENT);
        if (uuid == null) {
            return null;
        }
        return UUID.fromString(uuid);
    }

    @Nullable
    default DisplayGroup getPlantDisplayGroup(@Nonnull Location location) {
        UUID uuid = getPlantDisplayGroupUUID(location);
        if (uuid == null) {
            return null;
        }
        return DisplayGroup.fromUUID(uuid);
    }

    default void removePlantDisplayGroup(@Nonnull Location location) {
        DisplayGroup displayGroup = getPlantDisplayGroup(location);
        if (displayGroup != null) {
            displayGroup.remove();
        }
    }
}
