package dev.sefiraat.cultivation.api.utils;

import dev.sefiraat.cultivation.Cultivation;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.text.MessageFormat;
import java.util.UUID;

public final class StatisticUtils {

    private static final MessageFormat EXP = new MessageFormat("{0}.{1}.EXP");
    private static final MessageFormat PLANT_BREED_UNLOCK = new MessageFormat("{0}.PLANT.BREEDING.{1}.UNLOCKED");
    private StatisticUtils() {
        throw new IllegalStateException("Utility class");
    }

    @ParametersAreNonnullByDefault
    public static void incrementExp(Player player, LevelType type, Integer amount) {
        incrementExp(player.getUniqueId(), type, amount);
    }

    @ParametersAreNonnullByDefault
    public static void incrementExp(UUID player, LevelType type, Integer amount) {
        Integer currentExp = Cultivation.getConfigManager().getExp().getInt(
            EXP.format(new Object[]{player, type.name()}),
            0
        );
        Cultivation.getConfigManager().getExp().set(
            EXP.format(new Object[]{player, type.name()}),
            currentExp + amount
        );
    }

    @ParametersAreNonnullByDefault
    public static void setExp(Player player, LevelType type, Integer amount) {
        setExp(player.getUniqueId(), type, amount);
    }

    @ParametersAreNonnullByDefault
    public static void setExp(UUID player, LevelType type, Integer amount) {
        Cultivation.getConfigManager().getExp().set(
            EXP.format(new Object[]{player, type.name()}),
            amount
        );
    }

    public static void unlockDiscovery(@Nonnull Player player, @Nonnull String itemId) {
        unlockDiscovery(player.getUniqueId(), itemId);
    }

    public static void unlockDiscovery(@Nonnull UUID player, @Nonnull String itemId) {
        Cultivation.getConfigManager().getCodex().set(PLANT_BREED_UNLOCK.format(new Object[]{player, itemId}), true);
    }

    public static boolean isDiscovered(@Nonnull Player player, @Nonnull String itemId) {
        return isDiscovered(player.getUniqueId(), itemId);
    }

    public static boolean isDiscovered(@Nonnull UUID player, @Nonnull String itemId) {
        return Cultivation.getConfigManager().getCodex().getBoolean(
            PLANT_BREED_UNLOCK.format(new Object[]{player, itemId})
        );
    }

}

