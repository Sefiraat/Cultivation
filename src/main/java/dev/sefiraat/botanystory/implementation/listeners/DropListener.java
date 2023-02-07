package dev.sefiraat.botanystory.implementation.listeners;

import dev.sefiraat.botanystory.api.slimefun.RecipeTypes;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The purpose of this listener is to drop registered items when breaking the specified vanilla
 * block.
 * Recipes should be registered using {@link RecipeTypes#createWorldDropRecipe(ItemStack, ItemStack, double)}
 * which returns an ItemStack array used for Slimefun's recipe
 * {@link RecipeTypes#VANILLA_DROP}
 */
public class DropListener implements Listener {

    @Nonnull
    private static final Map<Material, BlockDrop> DROP_MAP = new EnumMap<>(Material.class);

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onBlockBreak(@Nonnull BlockBreakEvent event) {
        final BlockDrop blockDrop = DROP_MAP.get(event.getBlock().getType());

        if (blockDrop == null) {
            return;
        }
        blockDrop.rollDrop(event);
    }

    @Nonnull
    public static Map<Material, BlockDrop> getDropMap() {
        return DROP_MAP;
    }

    /**
     * This class represents a drop including its source, the item to drop and the chance for it to occur
     * Including a method to roll for and spawn the drop itself.
     */
    public static class BlockDrop {
        private final ItemStack stackToDrop;
        private final Material dropFrom;
        private final double dropChance;

        public BlockDrop(@Nonnull ItemStack stackToDrop, @Nonnull Material dropFrom, double dropChance) {
            this.stackToDrop = stackToDrop;
            this.dropFrom = dropFrom;
            this.dropChance = dropChance;
        }

        @Nonnull
        public ItemStack getStackToDrop() {
            return stackToDrop;
        }

        @Nonnull
        public Material getDropFrom() {
            return dropFrom;
        }

        public double getDropChance() {
            return dropChance;
        }

        public void rollDrop(@Nonnull BlockBreakEvent event) {
            final double roll = ThreadLocalRandom.current().nextDouble();
            if (roll <= this.dropChance) {
                final ItemStack drop = stackToDrop.clone();
                final Location location = event.getBlock().getLocation().clone().add(.5, .5, .5);
                location.getWorld().dropItem(location, drop);
            }
        }
    }
}
