package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
import dev.sefiraat.cultivation.implementation.slimefun.machines.GardenCloche;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.inventory.ItemStack;

public final class CultivationMachines {

    private CultivationMachines() {
        throw new IllegalStateException("Utility class");
    }

    public static final GardenCloche GARDEN_CLOCHE = new GardenCloche(
        CultivationGroups.MACHINES,
        CultivationStacks.GARDEN_CLOCHE,
        RecipeType.ENHANCED_CRAFTING_TABLE,
        new ItemStack[]{
            null, SlimefunItems.HARDENED_GLASS, null,
            null, SlimefunItems.CROP_GROWTH_ACCELERATOR, null,
            null, SlimefunItems.GOLD_24K_BLOCK, null
        }
    );

    public static void setup(Cultivation addon) {
        GARDEN_CLOCHE.register(addon);
    }
}
