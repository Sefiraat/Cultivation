package dev.sefiraat.cultivation.api.slimefun.plant;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

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
    private final GrowthStages stages;
    @Nonnull
    private final Set<Material> placements;
    private final double growthRate;

    @ParametersAreNonnullByDefault
    public Growth(@Nullable GrowthStages stages, Set<Material> places, double growthRate) {
        this.stages = stages;
        this.placements = places;
        this.growthRate = growthRate;
    }

    @Nullable
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

    @Nullable
    public ItemStack getFullyGrownPlant() {
        if (this.stages == null) {
            return null;
        }
        return this.stages.getStages().get(this.stages.getStages().size() - 1).getPlayerHead();
    }
}
