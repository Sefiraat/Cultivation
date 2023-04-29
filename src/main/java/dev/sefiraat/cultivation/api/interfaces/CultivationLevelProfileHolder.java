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
                String analysedString = BlockStorage.getLocationInfo(location, FloraLevelProfile.BS_KEY_ANALYZED);
                return getLevelProfile(levelString, speedString, strengthString, analysedString);
            }
        );
    }

    @Nonnull
    default FloraLevelProfile getLevelProfile(@Nonnull Config config) {
        String levelString = config.getString(FloraLevelProfile.BS_KEY_LEVEL);
        String speedString = config.getString(FloraLevelProfile.BS_KEY_SPEED);
        String strengthString = config.getString(FloraLevelProfile.BS_KEY_STRENGTH);
        String analyzedString = config.getString(FloraLevelProfile.BS_KEY_ANALYZED);
        return getLevelProfile(levelString, speedString, strengthString, analyzedString);
    }

    @ParametersAreNullableByDefault
    default FloraLevelProfile getLevelProfile(String levelString,
                                              String speedString,
                                              String strengthString,
                                              String analysedString
    ) {
        int level = levelString == null ? 1 : Integer.parseInt(levelString);
        int speed = speedString == null ? 1 : Integer.parseInt(speedString);
        int strength = strengthString == null ? 1 : Integer.parseInt(strengthString);
        boolean analyzed = Boolean.parseBoolean(analysedString);
        return new FloraLevelProfile(level, speed, strength, analyzed);
    }

    default void setLevelProfile(@Nonnull Location location, FloraLevelProfile profile) {
        setLevelProfile(location, profile.getLevel(), profile.getSpeed(), profile.getStrength(), profile.isAnalyzed());
        PROFILE_MAP.put(location, profile);
    }

    default void removeLevelProfile(@Nonnull Location location) {
        PROFILE_MAP.remove(location);
    }

    default void setLevelProfile(@Nonnull Location location, int level, int speed, int strength, boolean analyzed) {
        BlockStorage.addBlockInfo(location, FloraLevelProfile.BS_KEY_LEVEL, String.valueOf(level));
        BlockStorage.addBlockInfo(location, FloraLevelProfile.BS_KEY_SPEED, String.valueOf(speed));
        BlockStorage.addBlockInfo(location, FloraLevelProfile.BS_KEY_STRENGTH, String.valueOf(strength));
        BlockStorage.addBlockInfo(location, FloraLevelProfile.BS_KEY_ANALYZED, String.valueOf(analyzed));
    }
}
