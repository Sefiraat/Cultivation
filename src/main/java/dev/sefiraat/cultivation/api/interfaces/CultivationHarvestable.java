package dev.sefiraat.cultivation.api.interfaces;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * This interface defines a Cultivation object that can be harvested, describing what can be harvested from
 * it as well as if it is harvestable
 */
public interface CultivationHarvestable {

    /**
     * Defines the {@link ItemStack} that will drop when harvested. Defaults to null.
     *
     * @return The {@link ItemStack} that will drop when harvested. Defaults to null.
     */
    @Nullable
    default ItemStack getHarvestingResult() {
        return null;
    }
}
