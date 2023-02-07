package dev.sefiraat.botanystory.implementation.utils;

import dev.sefiraat.botanystory.BotanyStory;
import org.bukkit.NamespacedKey;

import javax.annotation.Nonnull;

public final class Keys {

    private Keys() {
        throw new IllegalStateException("Utility class");
    }

    // Region Slimefun BlockStorage Keys
    public static final String SEED_GROWTH_STAGE = "growth-stage";
    public static final String BLOCK_OWNER = "plant-owner";
    public static final NamespacedKey COOLDOWN = newKey("cooldown");
    public static final NamespacedKey DROPPED_PLAYER = newKey("dropped-player");

    @Nonnull
    public static NamespacedKey newKey(@Nonnull String value) {
        return new NamespacedKey(BotanyStory.getInstance(), value);
    }
}
