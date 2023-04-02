package dev.sefiraat.cultivation.implementation.listeners;

import dev.sefiraat.cultivation.api.slimefun.items.plants.CultivationPlant;
import dev.sefiraat.sefilib.protections.Protections;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import javax.annotation.Nonnull;

public class InteractionListener implements Listener {

    @EventHandler
    public void onInteraction(@Nonnull PlayerInteractEntityEvent event) {
        if (event.getRightClicked().getType() == EntityType.INTERACTION) {
            Player player = event.getPlayer();
            Block block = event.getRightClicked().getLocation().getBlock();
            SlimefunItem item = BlockStorage.check(block);

            if (!(item instanceof CultivationPlant) || !Protections.hasPermission(player, block, Interaction.INTERACT_BLOCK)) {
                return;
            }

            EquipmentSlot slot = event.getHand();
            PlayerInteractEvent interactEvent = new PlayerInteractEvent(
                player,
                Action.RIGHT_CLICK_BLOCK,
                player.getInventory().getItem(slot),
                block,
                BlockFace.UP
            );

            Bukkit.getPluginManager().callEvent(interactEvent);

            if (slot == EquipmentSlot.HAND) {
                player.swingMainHand();
            } else {
                player.swingOffHand();
            }
        }
    }

    @EventHandler
    public void onAttack(@Nonnull EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player player 
            && event.getEntity().getType() == EntityType.INTERACTION
        ) {
            Block block = event.getEntity().getLocation().getBlock();
            SlimefunItem slimefunItem = BlockStorage.check(block);
            if (slimefunItem instanceof CultivationPlant
                && Protections.hasPermission(player, block, Interaction.BREAK_BLOCK)
            ) {
                BlockBreakEvent breakEvent = new BlockBreakEvent(
                    block,
                    player
                );
                Bukkit.getPluginManager().callEvent(breakEvent);
            }
        }
    }




}
