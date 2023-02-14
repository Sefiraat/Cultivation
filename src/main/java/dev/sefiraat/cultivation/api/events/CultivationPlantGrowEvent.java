package dev.sefiraat.cultivation.api.events;

import dev.sefiraat.cultivation.api.slimefun.items.plants.CultivationPlant;
import org.bukkit.Location;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * This event is fired before a plant grows a stage. This event can be cancelled to stop growth
 *
 * @see CultivationPlant
 */
public class CultivationPlantGrowEvent extends CultivationGrowEvent<CultivationPlant> {

    @ParametersAreNonnullByDefault
    public CultivationPlantGrowEvent(Location location, CultivationPlant growingPlant, int growthStage) {
        super(location, growingPlant, growthStage);
    }
}
