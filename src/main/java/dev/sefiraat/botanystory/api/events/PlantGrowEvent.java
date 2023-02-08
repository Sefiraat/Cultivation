package dev.sefiraat.botanystory.api.events;

import dev.sefiraat.botanystory.api.slimefun.items.BotanySeed;
import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * This event is fired before a plant grows a stage. This event can be cancelled to stop growth
 *
 * @see BotanySeed
 */
public class PlantGrowEvent extends Event implements Cancellable {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    @Nonnull
    private final Location location;
    @Nonnull
    private final BotanySeed growingPlant;
    private final int growthStage;
    private boolean cancelled;

    @ParametersAreNonnullByDefault
    public PlantGrowEvent(Location location, BotanySeed growingPlant, int growthStage) {
        this.location = location;
        this.growingPlant = growingPlant;
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
     * @return The {@link Location} of the currently growing plant
     */
    @Nonnull
    public Location getLocation() {
        return location;
    }

    /**
     * @return The {@link BotanySeed} that is about to grow
     */
    @Nonnull
    public BotanySeed getGrowingPlant() {
        return growingPlant;
    }

    /**
     * @return The current growth stage, between 0-4
     */
    public int getGrowthStage() {
        return growthStage;
    }
}
