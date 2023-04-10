package dev.sefiraat.cultivation.implementation.utils;

import dev.sefiraat.cultivation.Cultivation;
import org.bukkit.NamespacedKey;

import javax.annotation.Nonnull;

public final class Keys {

    private Keys() {
        throw new IllegalStateException("Utility class");
    }

    // Region Slimefun BlockStorage Keys
    public static final String FLORA_GROWTH_STAGE = "growth-stage";
    public static final String FLORA_OWNER = "plant-owner";
    public static final NamespacedKey COOLDOWN = newKey("cooldown");
    public static final NamespacedKey DROPPED_PLAYER = newKey("dropped-player");
    public static final NamespacedKey RECIPE_ID = newKey("recipe-id");
    public static final NamespacedKey SATIATED = newKey("satiated");

    @Nonnull
    public static NamespacedKey newKey(@Nonnull String value) {
        return new NamespacedKey(Cultivation.getInstance(), value);
    }
}
