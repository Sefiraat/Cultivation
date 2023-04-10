package dev.sefiraat.cultivation.implementation.tasks;

import dev.sefiraat.sefilib.misc.Chance;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class AirTimeTask extends BukkitRunnable {
    public static final double QUALIFYING_TIME = 5.0;
    public static final int TICK_RATE = 5;
    private static final Map<UUID, Integer> PLAYER_AIR_TIMES = new HashMap<>();
    private static final Set<AirTimeDrop> DROPS = new HashSet<>();

    @Override
    public void run() {
        // todo - Test for exploits/loopholes before v1
        if (DROPS.isEmpty()) {
            // No drops registered, no need to action anything.
            return;
        }

        for (Player player : Bukkit.getOnlinePlayers()) {
            Block block = player.getLocation().clone().subtract(0, 1, 0).getBlock();
            if (block.getType().isAir()) {
                // Player is in the air currently, lets begin counting their time.
                PLAYER_AIR_TIMES.merge(player.getUniqueId(), 1, Integer::sum);
            } else {
                // Player is on the ground - lets see if they had time and calc their possible DROPS
                Integer time = PLAYER_AIR_TIMES.get(player.getUniqueId());

                if (time == null) {
                    // No time recorded, next player
                    continue;
                }

                // work out time in seconds player was in the air
                double ticksPerSecond = 20d / TICK_RATE;
                double timeSeconds = time / ticksPerSecond;
                for (AirTimeDrop drop : DROPS) {
                    double chance = timeSeconds / drop.fullOddsTimeSeconds();
                    if (Chance.testChance(chance)) {
                        ItemStack toDrop = drop.itemStack();
                        player.getWorld().dropItem(player.getLocation(), toDrop);
                    }
                }
            }
        }
    }

    public void addDrop(@Nonnull AirTimeDrop drop) {
        DROPS.add(drop);
    }

    public void removePlayer(Player player) {
        removePlayer(player.getUniqueId());
    }

    public void removePlayer(UUID player) {
        PLAYER_AIR_TIMES.remove(player);
    }

    public record AirTimeDrop(@Nonnull ItemStack itemStack, double fullOddsTimeSeconds) {

    }
}
