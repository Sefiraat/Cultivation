package dev.sefiraat.cultivation.api.interfaces;

import dev.sefiraat.sefilib.string.Theme;
import org.bukkit.Material;

import javax.annotation.Nonnull;
import java.util.Set;

/**
 * This interface represents a Cultivation Flora Object placed in a/the world.
 */
public interface CultivationFlora extends CultivationGrower, CultivationTicking, CustomPlacementBlock {

    /**
     * Defines the flora's theme. Used for particle generation.
     *
     * @return The {@link Theme} to be used
     */
    @Nonnull
    Theme getTheme();

    /**
     * This set defines Materials that the plant can be placed/grow on.
     * The placement will be cancelled otherwise.
     *
     * @return The set of {@link Material} that are valid for placement
     */
    @Nonnull
    Set<Material> getPlacements();

    /**
     * Defines the chance at which this flora will grow each tick, between 0 (0%) and 1 (100%)
     * When fully grown this will govern breeding attempts
     *
     * @return The growth rate
     */
    double getGrowthRate();
}
