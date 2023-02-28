package dev.sefiraat.cultivation.api.utils;

import dev.sefiraat.cultivation.Cultivation;
import org.bukkit.entity.Player;

import javax.annotation.ParametersAreNonnullByDefault;
import java.text.MessageFormat;
import java.util.UUID;

public final class StatisticUtils {

    private static final MessageFormat EXP = new MessageFormat("{0}.{1}.EXP");

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

}

