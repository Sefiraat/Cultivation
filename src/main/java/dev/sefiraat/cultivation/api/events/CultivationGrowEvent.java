package dev.sefiraat.cultivation.api.events;

import dev.sefiraat.cultivation.api.interfaces.CultivationFlora;
import dev.sefiraat.cultivation.api.slimefun.items.CultivationFloraItem;
import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * This event is fired before a flora object grows a stage. This event can be cancelled to stop growth
 *
 * @see CultivationFlora
 */
public class CultivationGrowEvent extends Event implements Cancellable {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    @Nonnull
    private final Location location;
    @Nonnull
    private final CultivationFloraItem<?> growingFlora;
    private final int growthStage;
    private boolean cancelled;

    @ParametersAreNonnullByDefault
    public CultivationGrowEvent(Location location, CultivationFloraItem<?> growingFlora, int growthStage) {
        this.location = location;
        this.growingFlora = growingFlora;
        this.growthStage = growthStage;
    }

    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Nonnull
    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    /**
     * @return The {@link Location} of the currently growing flora
     */
    @Nonnull
    public Location getLocation() {
        return location;
    }

    /**
     * @return The {@link CultivationFlora} that is about to grow
     */
    @Nonnull
    public CultivationFlora getGrowingFlora() {
        return growingFlora;
    }

    /**
     * @return The current growth stage
     */
    public int getGrowthStage() {
        return growthStage;
    }
}
