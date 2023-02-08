package dev.sefiraat.cultivation.api.utils;

import dev.sefiraat.sefilib.string.Theme;
import net.md_5.bungee.api.ChatColor;

public final class CultivationThemes {

    private CultivationThemes() {
        throw new IllegalStateException("Utility class");
    }

    public static final Theme MAIN = new Theme(ChatColor.of("#8a0e0e"), "Cultivation");
    public static final Theme DISCOVEREY = new Theme(ChatColor.of("#a60e03"), "Discovery");
    public static final Theme CRAFTING = new Theme(ChatColor.of("#dbcea9"), "Crafting Material");
    public static final Theme RECIPE_TYPE = new Theme(ChatColor.of("#ffe89c"), "Recipe Type");
    public static final Theme MACHINE = new Theme(ChatColor.of("#3295a8"), "Machine");
    public static final Theme TOOL = new Theme(ChatColor.of("#3295a8"), "Tool");
    public static final Theme SEED = new Theme(ChatColor.of("#a241bf"), "Seed");
    public static final Theme SAPLING = new Theme(ChatColor.of("#a241bf"), "Sapling");

    // Seeds
    public static final Theme SEED_RED = new Theme(ChatColor.of("#c41d1d"));
    public static final Theme SEED_ORANGE = new Theme(ChatColor.of("#c4761d"));
    public static final Theme SEED_YELLOW = new Theme(ChatColor.of("#c4b31d"));
    public static final Theme SEED_GREEN = new Theme(ChatColor.of("#4ac41d"));
    public static final Theme SEED_BLUE = new Theme(ChatColor.of("#1d36c4"));
    public static final Theme SEED_CYAN = new Theme(ChatColor.of("#1fcccc"));
    public static final Theme SEED_PURPLE = new Theme(ChatColor.of("#811dc4"));
}
