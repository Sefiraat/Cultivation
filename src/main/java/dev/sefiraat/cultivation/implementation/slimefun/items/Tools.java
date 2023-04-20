package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
import dev.sefiraat.cultivation.implementation.slimefun.tools.CropSticks;
import dev.sefiraat.cultivation.implementation.slimefun.tools.PlantAnalyser;
import dev.sefiraat.cultivation.implementation.slimefun.tools.RecipeUnlock;
import dev.sefiraat.cultivation.implementation.slimefun.tools.SeedPack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class Tools {

    public static final RecipeUnlock RECIPE_UNLOCK = new RecipeUnlock();

    private Tools() {
        throw new IllegalStateException("Utility class");
    }

    public static void setup(Cultivation addon) {

        new CropSticks(
            CultivationGroups.TOOLS,
            CultivationStacks.CROP_STICKS,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                new ItemStack(Material.STICK), new ItemStack(Material.STICK), null,
                new ItemStack(Material.STICK), new ItemStack(Material.STICK), null,
                null, null, null
            }
        ).register(addon);

        new PlantAnalyser(
            CultivationGroups.TOOLS,
            CultivationStacks.PLANT_ANALYSER,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                new ItemStack(Material.DIAMOND), new ItemStack(Material.GLASS), null,
                SlimefunItems.BLISTERING_INGOT, SlimefunItems.CROP_GROWTH_ACCELERATOR, null,
                null, null, null
            }
        ).register(addon);

        new SeedPack(
            CultivationGroups.TOOLS,
            CultivationStacks.SEED_PACK,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                new ItemStack(Material.LEATHER), new ItemStack(Material.STRING), new ItemStack(Material.LEATHER),
                new ItemStack(Material.LEATHER), null, new ItemStack(Material.LEATHER),
                new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER), new ItemStack(Material.LEATHER)
            }
        ).register(addon);

        RECIPE_UNLOCK.register(addon);
    }
}
