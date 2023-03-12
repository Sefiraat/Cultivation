package dev.sefiraat.cultivation.api.interfaces;

import io.github.bakedlibs.dough.collections.RandomizedSet;
import org.bukkit.inventory.ItemStack;

/**
 * This interface defines a Cultivation object that can be trimmed, describing what can be trimmed from
 * it as well as if it is trimmable
 */
public interface CultivationTrimmable {
    
    /**
     * Defines the {@link ItemStack}'s that will/can drop when trimmed. Defaults to null.
     *
     * @return The {@link ItemStack}'s that will/can drop when trimmed. Defaults to null.
     */
    default RandomizedSet<ItemStack> getTrimmingResult() {
        return null;
    }
}
