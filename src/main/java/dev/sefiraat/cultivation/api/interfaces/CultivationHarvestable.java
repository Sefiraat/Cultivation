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
     * This method returns whether the item can be harvested, defaults to
     * checking {@link CultivationHarvestable#getHarvestingResult()}. Will stop the harvester from working
     * if false.
     *
     * @return true if harvestable
     */
    default boolean isHarvestable() {
        return getHarvestingResult() != null;
    }

    /**
     * Defines the {@link ItemStack} that will drop when harvested. Defaults to null.
     * Ensure you check {@link CultivationHarvestable#isHarvestable()} first
     *
     * @return The {@link ItemStack} that will drop when harvested. Defaults to null.
     */
    @Nullable
    default ItemStack getHarvestingResult() {
        return null;
    }

    /**
     * This method should return if the flora object is ready to be harvested.
     *
     * @param location The location of the Cultivation Object in question
     * @return True if the object is ready to be harvested.
     */
    boolean isHarvestReady(@Nonnull Location location);

    /**
     * This method should return if the flora object is ready to be harvested.
     *
     * @param block The block containing the Cultivation Object in question
     * @return True if the object is ready to be harvested.
     */
    default boolean isHarvestReady(@Nonnull Block block) {
        return isHarvestReady(block.getLocation());
    }

}
