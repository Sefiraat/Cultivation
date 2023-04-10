package dev.sefiraat.cultivation.implementation.listeners;

import dev.sefiraat.cultivation.api.interfaces.CustomPlacementBlock;
import dev.sefiraat.cultivation.api.slimefun.items.bushes.CultivationBush;
import dev.sefiraat.cultivation.api.slimefun.items.plants.CultivationPlant;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

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
    public void onBlockPlace(@Nonnull BlockPlaceEvent event) {
        SlimefunItem slimefunItem = SlimefunItem.getByItem(event.getItemInHand());
        if (slimefunItem instanceof CustomPlacementBlock block) {
            block.whenPlaced(event);
        }
    }

    @EventHandler
    public void onWaterHitsPlant(@Nonnull BlockFromToEvent event) {
        Location location = event.getBlock().getLocation();
        unsafelyKillItem(location, BlockStorage.check(location));
    }

    @EventHandler
    public void onPistonExtends(@Nonnull BlockPistonExtendEvent event) {
        for (Block block : event.getBlocks()) {
            Block issueBlock = block.getRelative(BlockFace.UP);
            Location location = issueBlock.getLocation();
            unsafelyKillItem(location, BlockStorage.check(location));
        }
    }
    @EventHandler
    public void onPistonRetracts(@Nonnull BlockPistonRetractEvent event) {
        for (Block block : event.getBlocks()) {
            Block issueBlock = block.getRelative(BlockFace.UP);
            Location location = issueBlock.getLocation();
            unsafelyKillItem(location, BlockStorage.check(location));
        }
    }

    private void unsafelyKillItem(@Nonnull Location location, @Nullable SlimefunItem slimefunItem) {
        if (slimefunItem instanceof CultivationPlant plant) {
            location.getWorld().dropItem(location, plant.getDroppedItemStack(location));
            plant.removeCropped(location);
            plant.removePlantDisplayGroup(location);
            BlockStorage.clearBlockInfo(location);
            location.getBlock().setType(Material.AIR);
        } else if (slimefunItem instanceof CultivationBush bush) {
            location.getWorld().dropItem(location, bush.getItem().clone());
            bush.removeBushDisplayGroup(location);
            BlockStorage.clearBlockInfo(location);
        }
    }
}
