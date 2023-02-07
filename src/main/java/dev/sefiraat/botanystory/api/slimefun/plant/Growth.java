package dev.sefiraat.botanystory.api.slimefun.plant;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Set;

/**
 * This class collates the various classes used to describe the way a plant grows
 * and/or interacts with the world.
 */
public class Growth {

    @Nonnull
    private final GrowthStages stages;
    @Nonnull
    private final Set<Material> placements;
    private final double growthRate;

    @ParametersAreNonnullByDefault
    public Growth(GrowthStages stages, Set<Material> places, double growthRate) {
        this.stages = stages;
        this.placements = places;
        this.growthRate = growthRate;
    }

    @Nonnull
    public GrowthStages getStages() {
        return stages;
    }

    @Nonnull
    public Set<Material> getPlacements() {
        return placements;
    }

    public double getGrowthRate() {
        return growthRate;
    }

    @Nonnull
    public ItemStack getFullyGrownPlant() {
        return this.stages.getStages().get(this.stages.getStages().size() - 1).getPlayerHead();
    }
}
