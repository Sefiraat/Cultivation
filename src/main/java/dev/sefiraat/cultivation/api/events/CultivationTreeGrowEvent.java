package dev.sefiraat.cultivation.api.events;

import dev.sefiraat.cultivation.api.slimefun.items.trees.TreeDesign;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.world.WorldEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

public class CultivationTreeGrowEvent extends WorldEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private boolean cancelled = false;
    @Nonnull
    private final Location location;
    @Nullable
    private final Player player;
    private final TreeDesign design;
    private final SlimefunItem slimefunItem;

    @ParametersAreNonnullByDefault
    public CultivationTreeGrowEvent(Location location,
                                    @Nullable Player player,
                                    TreeDesign design,
                                    SlimefunItem slimefunItem
    ) {
        super(location.getWorld());
        this.location = location;
        this.player = player;
        this.design = design;
        this.slimefunItem = slimefunItem;
    }

    @Nonnull
    public Location getLocation() {
        return this.location;
    }

    @Nullable
    public Player getPlayer() {
        return this.player;
    }

    @Nonnull
    public TreeDesign getDesign() {
        return this.design;
    }

    @Nonnull
    public SlimefunItem getSlimefunItem() {
        return this.slimefunItem;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Nonnull
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    @Nonnull
    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}
