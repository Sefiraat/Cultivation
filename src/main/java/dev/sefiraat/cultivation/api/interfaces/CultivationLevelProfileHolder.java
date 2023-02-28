package dev.sefiraat.cultivation.api.interfaces;

import dev.sefiraat.cultivation.api.datatypes.instances.FloraLevelProfile;
import org.bukkit.Location;
import org.bukkit.block.Block;

import javax.annotation.Nonnull;

public interface CultivationLevelProfileHolder {

    @Nonnull
    default FloraLevelProfile getLevelProfile(@Nonnull Block block) {
        return getLevelProfile(block.getLocation());
    }

    @Nonnull
    FloraLevelProfile getLevelProfile(@Nonnull Location location);

}
