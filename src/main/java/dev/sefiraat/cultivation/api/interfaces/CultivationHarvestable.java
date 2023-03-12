package dev.sefiraat.cultivation.api.interfaces;

import io.github.bakedlibs.dough.collections.RandomizedSet;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;

/**
 * This interface defines a Cultivation object that can be harvested, describing what can be harvested from
 * it as well as if it is harvestable
 */
public interface CultivationHarvestable {

    /**
     * Defines the {@link ItemStack}'s that will/can drop when harvested. Defaults to null.
     *
     * @return The {@link ItemStack}'s that will/can drop when harvested. Defaults to null.
     */
    @Nullable
    default RandomizedSet<ItemStack> getHarvestingResults() {
        return null;
    }
}
