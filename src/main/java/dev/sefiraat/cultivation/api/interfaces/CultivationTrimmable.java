package dev.sefiraat.cultivation.api.interfaces;

import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;

/**
 * This interface defines a Cultivation object that can be trimmed, describing what can be trimmed from
 * it as well as if it is trimmable
 */
public interface CultivationTrimmable {
    
    /**
     * Defines the {@link ItemStack} that will/can drop when trimmed. Defaults to null.
     *
     * @return The {@link ItemStack} that will/can drop when trimmed. Defaults to null.
     */
    @Nullable
    default ItemStack getTrimmingResult() {
        return null;
    }
}
