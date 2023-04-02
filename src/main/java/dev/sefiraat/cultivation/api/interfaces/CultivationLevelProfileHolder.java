package dev.sefiraat.cultivation.api.interfaces;

import dev.sefiraat.cultivation.api.datatypes.instances.FloraLevelProfile;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.block.Block;

import javax.annotation.Nonnull;

public interface CultivationLevelProfileHolder {

    @Nonnull
    default FloraLevelProfile getLevelProfile(@Nonnull Block block) {
        return getLevelProfile(block.getLocation());
    }

    @Nonnull
    default FloraLevelProfile getLevelProfile(@Nonnull Location location) {
        int level = Integer.parseInt(BlockStorage.getLocationInfo(location, FloraLevelProfile.BS_KEY_LEVEL));
        int speed = Integer.parseInt(BlockStorage.getLocationInfo(location, FloraLevelProfile.BS_KEY_SPEED));
        int strength = Integer.parseInt(BlockStorage.getLocationInfo(location, FloraLevelProfile.BS_KEY_STRENGTH));
        return new FloraLevelProfile(level, speed, strength);
    }

    @Nonnull
    default FloraLevelProfile getLevelProfile(@Nonnull Config config) {
        int level = Integer.parseInt(config.getString(FloraLevelProfile.BS_KEY_LEVEL));
        int speed = Integer.parseInt(config.getString(FloraLevelProfile.BS_KEY_SPEED));
        int strength = Integer.parseInt(config.getString(FloraLevelProfile.BS_KEY_STRENGTH));
        return new FloraLevelProfile(level, speed, strength);
    }

    default void setLevelProfile(@Nonnull Location location, FloraLevelProfile profile) {
        setLevelProfile(location, profile.getLevel(), profile.getSpeed(), profile.getStrength());
    }

    default void setLevelProfile(@Nonnull Location location, int level, int speed, int strength) {
        BlockStorage.addBlockInfo(location, FloraLevelProfile.BS_KEY_LEVEL, String.valueOf(level));
        BlockStorage.addBlockInfo(location, FloraLevelProfile.BS_KEY_SPEED, String.valueOf(speed));
        BlockStorage.addBlockInfo(location, FloraLevelProfile.BS_KEY_STRENGTH, String.valueOf(strength));
    }
}
