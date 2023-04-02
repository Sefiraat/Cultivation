package dev.sefiraat.cultivation.api.slimefun.plant;

import org.bukkit.Material;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Set;

/**
 * This class is used to collate the various classes used to describe the way a plant grows
 * and/or interacts with the world.
 */
public class Growth {

    @Nullable
    private final PlantTheme theme;
    @Nonnull
    private final Set<Material> placements;
    private final double growthRate;

    @ParametersAreNonnullByDefault
    public Growth(@Nullable PlantTheme theme, Set<Material> places, double growthRate) {
        this.theme = theme;
        this.placements = places;
        this.growthRate = growthRate;
    }

    @ParametersAreNonnullByDefault
    public Growth(@Nullable PlantTheme theme, Material placementMaterial, double growthRate) {
        this(theme, Set.of(placementMaterial), growthRate);
    }

    @Nullable
    public PlantTheme getTheme() {
        return theme;
    }

    @Nonnull
    public Set<Material> getPlacements() {
        return placements;
    }

    public double getGrowthRate() {
        return growthRate;
    }

}
