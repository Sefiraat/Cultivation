package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class Crafting {

    private Crafting() {
        throw new IllegalStateException("Utility class");
    }

    public static void setup(Cultivation addon) {

        new SlimefunItem(
            CultivationGroups.CRAFTING,
            CultivationStacks.MYSTICAL_LOG,
            RecipeType.ANCIENT_ALTAR,
            new ItemStack[]{
                null, SlimefunItems.AIR_RUNE, null,
                SlimefunItems.EARTH_RUNE, new ItemStack(Material.OAK_SAPLING), SlimefunItems.FIRE_RUNE,
                null, SlimefunItems.WATER_RUNE, null
            }
        ).register(addon);
    }
}
