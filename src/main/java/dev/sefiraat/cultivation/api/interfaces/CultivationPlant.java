package dev.sefiraat.cultivation.api.interfaces;

import dev.sefiraat.cultivation.api.slimefun.items.CultivationSeed;
import dev.sefiraat.cultivation.api.slimefun.plant.GrowthStages;
import dev.sefiraat.sefilib.string.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Set;

/**
 * This interface represents a plant placed in a/the world, and it's behavior as it ticks and grows
 * including information about how it grows and develops
 */
public interface CultivationPlant {

    /**
     * This method will fire every single time the CultivationPlant ticks
     *
     * @param location The location of the plant being ticked
     * @param seed     The {@link SlimefunItem} being ticked
     * @param data     The {@link Config} from BlockStorage for the location
     */
    @ParametersAreNonnullByDefault
    default void onTickAlways(Location location, CultivationSeed seed, Config data) {

    }

    /**
     * This method will fire when the CultivationPlant ticks when fully grown
     *
     * @param location The location of the plant being ticked
     * @param seed     The {@link SlimefunItem} being ticked
     * @param data     The {@link Config} from BlockStorage for the location
     */
    @ParametersAreNonnullByDefault
    default void onTickFullyGrown(Location location, CultivationSeed seed, Config data) {

    }

    /**
     * This method will fire each time the plant grows a single step
     *
     * @param location The location of the plant being ticked
     * @param seed     The {@link SlimefunItem} being ticked
     * @param data     The {@link Config} from BlockStorage for the location
     */
    @ParametersAreNonnullByDefault
    default void onGrowthStep(Location location, CultivationSeed seed, Config data) {

    }

    /**
     * This method will fire once when the plant reaches full maturity
     *
     * @param location The location of the plant being ticked
     * @param seed     The {@link SlimefunItem} being ticked
     * @param data     The {@link Config} from BlockStorage for the location
     */
    @ParametersAreNonnullByDefault
    default void onFullyMatures(Location location, CultivationSeed seed, Config data) {

    }

    /**
     * Defines the {@link ItemStack} that will drop when harvested. Defaults to null.
     * Ensure you check {@link CultivationPlant#isHarvestable()} first
     *
     * @return The {@link ItemStack} that will drop when harvested. Defaults to null.
     */
    @Nullable
    default ItemStack getHarvestingResult() {
        return null;
    }

    /**
     * This method returns whether the item can be harvested, defaults to
     * checking {@link CultivationPlant#getHarvestingResult()}. Will stop the harvester from working
     * if false.
     *
     * @return true if harvestable
     */
    default boolean isHarvestable() {
        return getHarvestingResult() != null;
    }

    /**
     * Defines the plant's theme. Used for particle generation.
     *
     * @return The {@link Theme} to be used
     */
    @Nonnull
    Theme getTheme();

    /**
     * This set defines the types of Crux that the plant can be placed/grow on.
     * The placement will be cancelled otherwise.
     *
     * @return The set of {@link Material} that are valid for placement
     */
    @Nonnull
    Set<Material> getPlacements();

    /**
     * Defines the chance at which this plant will grow each tick, between 0 (0%) and 1 (100%)
     * When fully grown this will govern breeding attempts
     *
     * @return The growth rate
     */
    double getGrowthRate();

    /**
     * Defines the possible growth stages for this plant.
     *
     * @return The list of {@link GrowthStages} of valid growth stages (including the Seed)
     */
    GrowthStages getGrowthStages();
}
