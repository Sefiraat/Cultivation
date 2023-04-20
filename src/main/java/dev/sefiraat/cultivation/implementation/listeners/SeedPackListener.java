package dev.sefiraat.cultivation.implementation.listeners;

import dev.sefiraat.cultivation.api.datatypes.FloraLevelProfileDataType;
import dev.sefiraat.cultivation.api.datatypes.SeedPackDataType;
import dev.sefiraat.cultivation.api.datatypes.instances.FloraLevelProfile;
import dev.sefiraat.cultivation.api.datatypes.instances.SeedPackInstance;
import dev.sefiraat.cultivation.api.slimefun.items.plants.CultivationPlant;
import dev.sefiraat.cultivation.implementation.slimefun.tools.SeedPack;
import dev.sefiraat.sefilib.misc.ParticleUtils;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;

public class SeedPackListener implements Listener {

    @EventHandler
    public void onPickupItem(@Nonnull EntityPickupItemEvent event) {
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }

        Item item = event.getItem();
        ItemStack itemStack = item.getItemStack();
        SlimefunItem slimefunItem = SlimefunItem.getByItem(itemStack);

        if (!(slimefunItem instanceof CultivationPlant plant)) {
            return;
        }

        for (ItemStack content : player.getInventory().getContents()) {
            SlimefunItem packItem = SlimefunItem.getByItem(content);
            if (packItem instanceof SeedPack) {
                ItemMeta contentMeta = content.getItemMeta();
                SeedPackInstance instance = PersistentDataAPI.get(
                    contentMeta,
                    SeedPackDataType.KEY,
                    SeedPackDataType.TYPE
                );

                if (instance == null || !instance.getStoredItemId().equals(plant.getId())) {
                    continue;
                }

                ItemMeta dropMeta = itemStack.getItemMeta();
                FloraLevelProfile profile = PersistentDataAPI.get(
                    dropMeta,
                    FloraLevelProfileDataType.KEY,
                    FloraLevelProfileDataType.TYPE
                );

                if (profile == null) {
                    continue;
                }

                instance.add(profile, itemStack.getAmount());
                PersistentDataAPI.set(contentMeta, SeedPackDataType.KEY, SeedPackDataType.TYPE, instance);
                content.setItemMeta(contentMeta);
                event.setCancelled(true);
                ParticleUtils.displayParticleRandomly(item, 0.5, 5, plant.getTheme().getDustOptions(1));
                item.remove();
                return;
            }
        }
    }

}
