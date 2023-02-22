package dev.sefiraat.cultivation.api.events;

import dev.sefiraat.cultivation.api.slimefun.plant.CultivationTreeType;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import org.bukkit.Location;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.world.WorldEvent;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

public class CultivationTreeGrowEvent extends WorldEvent implements Cancellable {
    private static final HandlerList HANDLER_LIST = new HandlerList();
    private boolean cancelled = false;
    @Nonnull
    private final Location location;
    @Nonnull
    private final CultivationTreeType species;
    private final Player player;
    private final List<BlockState> blocks;
    private final SlimefunItem slimefunItem;
    @ParametersAreNonnullByDefault
    public CultivationTreeGrowEvent(Location location,
                                    CultivationTreeType species,
                                    Player player,
                                    List<BlockState> blocks,
                                    SlimefunItem slimefunItem
    ) {
        super(location.getWorld());
        this.location = location;
        this.species = species;
        this.player = player;
        this.blocks = blocks;
        this.slimefunItem = slimefunItem;
    }

    @Nonnull
    public Location getLocation() {
        return this.location;
    }

    @Nonnull
    public CultivationTreeType getSpecies() {
        return this.species;
    }

    @Nonnull
    public Player getPlayer() {
        return this.player;
    }

    @Nonnull
    public List<BlockState> getBlocks() {
        return this.blocks;
    }

    @Nonnull
    public SlimefunItem getSlimefunItem() {return  this.slimefunItem;}

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
