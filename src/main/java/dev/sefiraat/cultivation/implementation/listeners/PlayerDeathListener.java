package dev.sefiraat.cultivation.implementation.listeners;

import dev.sefiraat.cultivation.managers.TaskManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import javax.annotation.Nonnull;

public class PlayerDeathListener implements Listener {

    // Removes a player's time from the AirTimeTask as, if they have dies, their time doesn't count
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerDies(@Nonnull PlayerDeathEvent event) {
        TaskManager.getInstance().getAirTimeTask().removePlayer(event.getEntity());
    }
}
