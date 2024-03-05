package dev.sefiraat.cultivation.implementation.utils;

import org.bukkit.Bukkit;

public class GeneralUtils {

    private GeneralUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static int getMajorServerVersion() {
        return Integer.parseInt(Bukkit.getServer().getBukkitVersion().split("\\.")[1]);
    }
}
