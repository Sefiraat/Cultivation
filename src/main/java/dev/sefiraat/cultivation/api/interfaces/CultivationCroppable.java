package dev.sefiraat.cultivation.api.interfaces;

import dev.sefiraat.cultivation.implementation.utils.DisplayUtils;
import dev.sefiraat.sefilib.entity.display.DisplayGroup;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.block.Block;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.UUID;

public interface CultivationCroppable {

    String CROPPED = "crops_present";
    String CROSS_CROPPED = "cross_crop_present";
    String GROUP_PARENT = "crop_display_group";

    default boolean isCropped(@Nonnull Block block) {
        return isCropped(block.getLocation());
    }

    default boolean isCropped(@Nonnull Location location) {
        String cropped = BlockStorage.getLocationInfo(location, CROPPED);
        return Boolean.parseBoolean(cropped);
    }

    default boolean isCropped(@Nonnull Config config) {
        String cropped = config.getString(CROPPED);
        return Boolean.parseBoolean(cropped);
    }

    default boolean isCrossCropped(@Nonnull Block block) {
        return isCrossCropped(block.getLocation());
    }

    default boolean isCrossCropped(@Nonnull Location location) {
        String cropped = BlockStorage.getLocationInfo(location, CROSS_CROPPED);
        return Boolean.parseBoolean(cropped);
    }

    default boolean isCrossCropped(@Nonnull Config config) {
        String cropped = config.getString(CROSS_CROPPED);
        return Boolean.parseBoolean(cropped);
    }

    default boolean incrementCrop(@Nonnull Location location) {
        if (isCrossCropped(location)) {
            return false;
        } else if (isCropped(location)) {
            setCrossCropped(location);
            return true;
        } else {
            setCropped(location);
            return true;
        }
    }

    default void setCropped(@Nonnull Location location) {
        DisplayGroup displayGroup = DisplayUtils.generateCropStickGroup(location.clone().add(0.5, 0, 0.5));
        BlockStorage.addBlockInfo(location, CROPPED, "true");
        BlockStorage.addBlockInfo(location, GROUP_PARENT, displayGroup.getParentUUID().toString());
    }

    default void setCrossCropped(@Nonnull Location location) {
        if (isCropped(location)) {
            removeCropDisplayGroup(location);
        }
        DisplayGroup displayGroup = DisplayUtils.generateCrossedCropStickGroup(location.clone().add(0.5, 0, 0.5));
        BlockStorage.addBlockInfo(location, CROPPED, "true");
        BlockStorage.addBlockInfo(location, CROSS_CROPPED, "true");
        BlockStorage.addBlockInfo(location, GROUP_PARENT, displayGroup.getParentUUID().toString());
    }

    default void removeCropped(@Nonnull Location location) {
        removeCropDisplayGroup(location);
        BlockStorage.addBlockInfo(location, CROPPED, null);
        BlockStorage.addBlockInfo(location, CROSS_CROPPED, null);
        BlockStorage.addBlockInfo(location, GROUP_PARENT, null);
    }

    @Nullable
    default UUID getCropDisplayGroupUUID(@Nonnull Location location) {
        String uuid = BlockStorage.getLocationInfo(location, GROUP_PARENT);
        if (uuid == null) {
            return null;
        }
        return UUID.fromString(uuid);
    }

    @Nullable
    default DisplayGroup getCropDisplayGroup(@Nonnull Location location) {
        UUID uuid = getCropDisplayGroupUUID(location);
        if (uuid == null) {
            return null;
        }
        return DisplayGroup.fromUUID(uuid);
    }

    default void removeCropDisplayGroup(@Nonnull Location location) {
        DisplayGroup displayGroup = getCropDisplayGroup(location);
        if (displayGroup != null) {
            displayGroup.remove();
        }
    }
}
