package dev.sefiraat.cultivation.implementation.listeners;

import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.sefilib.entity.LivingEntityDefinition;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The purpose of this listener is to drop registered items when killing a specified Mob.
 * Recipes should be registered using {@link RecipeTypes#createMobDropRecipe(ItemStack, LivingEntityDefinition, double)}
 * which returns an ItemStack array used for Slimefun's recipe
 * {@link RecipeTypes#MOB}
 */
public class MobDropListener implements Listener {

    @Nonnull
    private static final Set<MobDrop> DROPS = new HashSet<>();

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onBlockBreak(@Nonnull EntityDeathEvent event) {
        if (event.getEntity().getKiller() == null) {
            // Only allow player kills to count
            return;
        }
        for (MobDrop mobDrop : DROPS) {
            if (mobDrop.dropsFrom(event.getEntityType())) {
                mobDrop.rollDrop(event);
            }
        }
    }

    @Nonnull
    public static Set<MobDrop> getDrops() {
        return Collections.unmodifiableSet(DROPS);
    }

    public static void addDrop(@Nonnull MobDrop drop) {
        DROPS.add(drop);
    }

    /**
     * This class represents a drop including its source, the item to drop and the chance for it to occur
     * Including a method to roll for and spawn the drop itself.
     */
    public static class MobDrop {
        private final ItemStack stackToDrop;
        private final Set<EntityType> dropFrom;
        private final double dropChance;

        public MobDrop(@Nonnull ItemStack stackToDrop, @Nonnull EntityType dropFrom, double dropChance) {
            this(stackToDrop, Set.of(dropFrom), dropChance);
        }

        public MobDrop(@Nonnull ItemStack stackToDrop, @Nonnull Set<EntityType> dropFrom, double dropChance) {
            this.stackToDrop = stackToDrop;
            this.dropFrom = dropFrom;
            this.dropChance = dropChance;
        }

        @Nonnull
        public ItemStack getStackToDrop() {
            return stackToDrop;
        }

        @Nonnull
        public Set<EntityType> getDropFrom() {
            return dropFrom;
        }

        public boolean dropsFrom(@Nonnull EntityType entityType) {
            return dropFrom.contains(entityType);
        }

        public double getDropChance() {
            return dropChance;
        }

        public void rollDrop(@Nonnull EntityDeathEvent event) {
            final double roll = ThreadLocalRandom.current().nextDouble();
            if (roll <= this.dropChance) {
                final ItemStack drop = stackToDrop.clone();
                final Location location = event.getEntity().getLocation();
                location.getWorld().dropItem(location, drop);
            }
        }
    }
}
