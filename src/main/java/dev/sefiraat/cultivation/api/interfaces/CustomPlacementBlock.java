package dev.sefiraat.cultivation.api.interfaces;

import dev.sefiraat.cultivation.implementation.listeners.CustomPlacementListener;
import org.bukkit.event.block.BlockPlaceEvent;

import javax.annotation.Nonnull;

/**
 * This interface is used on blocks that need a custom placement method outside of the one Slimefun offers.
 * See {@link CustomPlacementListener} for more.
 */
public interface CustomPlacementBlock {

    void whenPlaced(@Nonnull BlockPlaceEvent event);

}
