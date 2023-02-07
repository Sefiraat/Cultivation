package dev.sefiraat.botanystory.implementation.listeners;

import dev.sefiraat.botanystory.api.interfaces.CustomPlacementBlock;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import javax.annotation.Nonnull;

/**
 * The purpose of this listener is to allow us to cancel the block placement if not on the
 * correct material. If done within the onBlockPlace handler, the BlockStorage is retained
 * leading to dupes.
 * Also allows other objects implementing {@link CustomPlacementBlock}
 * to fire their own methods
 * TODO PR to slimefun to either do blockstorage after checking the event is cancelled or to remove
 */
public class CustomPlacementListener implements Listener {

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onBlockPlaced(@Nonnull BlockPlaceEvent event) {
        final SlimefunItem slimefunItem = SlimefunItem.getByItem(event.getItemInHand());
        if (slimefunItem instanceof CustomPlacementBlock block) {
            block.whenPlaced(event);
        }
    }
}
