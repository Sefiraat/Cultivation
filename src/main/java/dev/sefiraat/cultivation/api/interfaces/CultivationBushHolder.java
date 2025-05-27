package dev.sefiraat.cultivation.api.interfaces;

import dev.sefiraat.cultivation.implementation.utils.DisplayGroupGenerators;
import dev.sefiraat.sefilib.entity.display.DisplayGroup;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.UUID;

public interface CultivationBushHolder {

    String BUSH = "bush_display_present";
    String GROUP_PARENT = "bush_display_group";

    default boolean hasDisplayBush(@Nonnull Block block) {
        return hasDisplayBush(block.getLocation());
    }

    default boolean hasDisplayBush(@Nonnull Location location) {
        String hasBush = BlockStorage.getLocationInfo(location, BUSH);
        return Boolean.parseBoolean(hasBush);
    }

    default boolean hasDisplayBush(@Nonnull Config config) {
        String hasBush = config.getString(BUSH);
        return Boolean.parseBoolean(hasBush);
    }

    default void removeBush(@Nonnull Location location) {
        removeBushDisplayGroup(location);
        BlockStorage.addBlockInfo(location, BUSH, null);
        BlockStorage.addBlockInfo(location, GROUP_PARENT, null);
    }

    default void addDisplayBush(@Nonnull Location location) {
        DisplayGroup displayGroup = DisplayGroupGenerators.generateBush(location.clone().add(0.5, 0, 0.5));
        BlockStorage.addBlockInfo(location, BUSH, "true");
        BlockStorage.addBlockInfo(location, GROUP_PARENT, displayGroup.getParentUUID().toString());
    }

    default void setAge(@Nonnull Location location, int age) {
        DisplayGroup displayGroup = getBushDisplayGroup(location);
        if (displayGroup != null) {
            DisplayGroupGenerators.setBushAge(displayGroup, age);
        }
    }

    default void growItems(@Nonnull Location location, @Nonnull ItemStack itemStack) {
        if (hasDisplayBush(location)) {
            DisplayGroup group = getBushDisplayGroup(location);
            DisplayGroupGenerators.growItemsInBush(group, itemStack);
        }
    }

    default void hideItems(@Nonnull Location location) {
        if (hasDisplayBush(location)) {
            DisplayGroup group = getBushDisplayGroup(location);
            DisplayGroupGenerators.hideItemsInPlant(group);
        }
    }

    @Nullable
    default UUID getBushDisplayGroupUUID(@Nonnull Location location) {
        String uuid = BlockStorage.getLocationInfo(location, GROUP_PARENT);
        if (uuid == null) {
            return null;
        }
        return UUID.fromString(uuid);
    }

    @Nullable
    default DisplayGroup getBushDisplayGroup(@Nonnull Location location) {
        UUID uuid = getBushDisplayGroupUUID(location);
        if (uuid == null) {
            return null;
        }
        return DisplayGroup.fromUUID(uuid);
    }

    default void removeBushDisplayGroup(@Nonnull Location location) {
        DisplayGroup displayGroup = getBushDisplayGroup(location);
        if (displayGroup != null) {
            displayGroup.remove();
        }
    }
}
