package dev.sefiraat.cultivation.api.events;

import dev.sefiraat.cultivation.api.slimefun.items.bushes.CultivationBush;
import org.bukkit.Location;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * This event is fired before a bush grows a stage. This event can be cancelled to stop growth
 *
 * @see CultivationBush
 */
public class CultivationBushGrowEvent extends CultivationGrowEvent {

    @ParametersAreNonnullByDefault
    public CultivationBushGrowEvent(Location location, CultivationBush growingBush, int growthStage) {
        super(location, growingBush, growthStage);
    }
}
