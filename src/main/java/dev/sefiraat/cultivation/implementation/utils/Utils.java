package dev.sefiraat.cultivation.implementation.utils;

import org.bukkit.Bukkit;

public class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }

    public static int getMajorServerVersion() {
        return Integer.parseInt(Bukkit.getServer().getBukkitVersion().split("\\.")[1]);
    }
}
