package dev.sefiraat.cultivation.implementation.listeners;

import dev.sefiraat.cultivation.api.slimefun.items.trees.CultivationTree;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;

import javax.annotation.Nonnull;

public class TreeListener implements Listener {

    @EventHandler
    public void onTreeGrows(@Nonnull StructureGrowEvent event) {
        Location location = event.getLocation();
        SlimefunItem slimefunItem = BlockStorage.check(location);
        if (slimefunItem instanceof CultivationTree tree) {
            event.setCancelled(true);
            BlockStorage.clearBlockInfo(location);
            tree.grow(location);
        }
    }
}
