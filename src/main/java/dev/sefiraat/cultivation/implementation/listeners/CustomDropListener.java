package dev.sefiraat.cultivation.implementation.listeners;

import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.sefilib.world.LocationUtils;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The purpose of this listener is to drop registered items when breaking the specified vanilla
 * block and/or bucketing up blocks.
 * Recipes should be registered using {@link RecipeTypes#createBlockDropRecipe(ItemStack, ItemStack, double)}
 * which returns an ItemStack array used for Slimefun's recipe
 * {@link RecipeTypes#VANILLA_DROP}
 */
public class CustomDropListener implements Listener {

    @Nonnull
    private static final Set<BlockDrop> BLOCK_DROPS = new HashSet<>();
    @Nonnull
    private static final Set<BlockDrop> BUCKETING_DROPS = new HashSet<>();

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onBlockBreak(@Nonnull BlockBreakEvent event) {
        if (BlockStorage.hasBlockInfo(event.getBlock())) {
            // Don't want to fire on SF Blocks
            return;
        }
        for (BlockDrop drop : BLOCK_DROPS) {
            if (drop.dropsFrom(event.getBlock().getType())) {
                drop.rollDrop(event);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onBucketFill(@Nonnull PlayerBucketFillEvent event) {
        if (BlockStorage.hasBlockInfo(event.getBlock())) {
            // Don't want to fire on SF Blocks
            return;
        }
        for (BlockDrop drop : BUCKETING_DROPS) {
            if (drop.dropsFrom(event.getBlock().getType())) {
                drop.rollDrop(event);
            }
        }
    }

    @Nonnull
    public static Set<BlockDrop> getBlockDrops() {
        return BLOCK_DROPS;
    }

    @Nonnull
    public static Set<BlockDrop> getBucketingDrops() {
        return BUCKETING_DROPS;
    }

    public static void addBlockDrop(@Nonnull BlockDrop drop) {
        BLOCK_DROPS.add(drop);
    }

    public static void addBucketingDrop(@Nonnull BlockDrop drop) {
        BUCKETING_DROPS.add(drop);
    }

    /**
     * This class represents a drop including its source, the item to drop and the chance for it to occur
     * Including a method to roll for and spawn the drop itself.
     */
    public static class BlockDrop {
        private final ItemStack stackToDrop;
        private final Set<Material> dropFrom;
        private final double dropChance;

        public BlockDrop(@Nonnull ItemStack stackToDrop, @Nonnull Material dropFrom, double dropChance) {
            this(stackToDrop, Set.of(dropFrom), dropChance);
        }

        public BlockDrop(@Nonnull ItemStack stackToDrop, @Nonnull Set<Material> dropFrom, double dropChance) {
            this.stackToDrop = stackToDrop;
            this.dropFrom = dropFrom;
            this.dropChance = dropChance;
        }

        @Nonnull
        public ItemStack getStackToDrop() {
            return stackToDrop;
        }

        @Nonnull
        public Set<Material> getDropFrom() {
            return dropFrom;
        }

        public boolean dropsFrom(@Nonnull Material material) {
            return dropFrom.contains(material);
        }

        public double getDropChance() {
            return dropChance;
        }

        public void rollDrop(@Nonnull BlockBreakEvent event) {
            final double roll = ThreadLocalRandom.current().nextDouble();
            if (roll <= this.dropChance) {
                final ItemStack drop = stackToDrop.clone();
                final Location location = LocationUtils.centre(event.getBlock().getLocation());
                location.getWorld().dropItem(location, drop);
            }
        }

        public void rollDrop(@Nonnull PlayerBucketFillEvent event) {
            final double roll = ThreadLocalRandom.current().nextDouble();
            if (roll <= this.dropChance) {
                final ItemStack drop = stackToDrop.clone();
                final Location location = LocationUtils.centre(event.getPlayer().getLocation());
                location.getWorld().dropItem(location, drop);
            }
        }
    }
}
