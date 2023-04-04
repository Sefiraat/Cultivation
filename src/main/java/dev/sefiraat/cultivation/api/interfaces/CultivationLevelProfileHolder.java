package dev.sefiraat.cultivation.api.interfaces;

import dev.sefiraat.cultivation.api.datatypes.instances.FloraLevelProfile;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.block.Block;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNullableByDefault;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public interface CultivationLevelProfileHolder {

    Map<Location, FloraLevelProfile> PROFILE_MAP = new HashMap<>();

    @Nonnull
    default FloraLevelProfile getLevelProfile(@Nonnull Block block) {
        return getLevelProfile(block.getLocation());
    }

    @Nonnull
    default FloraLevelProfile getLevelProfile(@Nonnull Location location) {
        return Objects.requireNonNullElseGet(
            PROFILE_MAP.get(location),
            () -> {
                String levelString = BlockStorage.getLocationInfo(location, FloraLevelProfile.BS_KEY_LEVEL);
                String speedString = BlockStorage.getLocationInfo(location, FloraLevelProfile.BS_KEY_SPEED);
                String strengthString = BlockStorage.getLocationInfo(location, FloraLevelProfile.BS_KEY_STRENGTH);
                return getLevelProfile(levelString, speedString, strengthString);
            }
        );
    }

    @Nonnull
    default FloraLevelProfile getLevelProfile(@Nonnull Config config) {
        String levelString = config.getString(FloraLevelProfile.BS_KEY_LEVEL);
        String speedString = config.getString(FloraLevelProfile.BS_KEY_SPEED);
        String strengthString = config.getString(FloraLevelProfile.BS_KEY_STRENGTH);
        return getLevelProfile(levelString, speedString, strengthString);
    }

    @ParametersAreNullableByDefault
    default FloraLevelProfile getLevelProfile(String levelString, String speedString, String strengthString) {
        int level = levelString == null ? 1 : Integer.parseInt(levelString);
        int speed = speedString == null ? 1 : Integer.parseInt(speedString);
        int strength = strengthString == null ? 1 : Integer.parseInt(strengthString);
        return new FloraLevelProfile(level, speed, strength);
    }

    default void setLevelProfile(@Nonnull Location location, FloraLevelProfile profile) {
        setLevelProfile(location, profile.getLevel(), profile.getSpeed(), profile.getStrength());
        PROFILE_MAP.put(location, profile);
    }

    default void setLevelProfile(@Nonnull Location location, int level, int speed, int strength) {
        BlockStorage.addBlockInfo(location, FloraLevelProfile.BS_KEY_LEVEL, String.valueOf(level));
        BlockStorage.addBlockInfo(location, FloraLevelProfile.BS_KEY_SPEED, String.valueOf(speed));
        BlockStorage.addBlockInfo(location, FloraLevelProfile.BS_KEY_STRENGTH, String.valueOf(strength));
    }
}
