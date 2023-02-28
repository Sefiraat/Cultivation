package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.slimefun.items.plants.HarvestablePlant;
import dev.sefiraat.cultivation.api.slimefun.items.plants.NothingPlant;
import dev.sefiraat.cultivation.api.slimefun.plant.CommonPlacements;
import dev.sefiraat.cultivation.api.slimefun.plant.Growth;
import dev.sefiraat.cultivation.api.slimefun.plant.GrowthStages;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class CultivationPlants {

    private CultivationPlants() {
        throw new IllegalStateException("Utility class");
    }

    public static void setup(Cultivation addon) {

        new HarvestablePlant(
            CultivationStacks.COBBLESTONE_PLANT,
            RecipeTypes.VANILLA_DROP,
            RecipeTypes.createBlockDropRecipe(CultivationStacks.COBBLESTONE_PLANT, new ItemStack(Material.DIRT), 0.05),
            new Growth(
                GrowthStages.FUNGAL_CYAN,
                CommonPlacements.COMMON_OVERWORLD,
                0.1
            )
        ).addHarvestingResult(new ItemStack(Material.COBBLESTONE))
            .tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.DIRT_PLANT,
            RecipeTypes.VANILLA_DROP,
            RecipeTypes.createBlockDropRecipe(CultivationStacks.DIRT_PLANT, new ItemStack(Material.DIRT), 0.05),
            new Growth(
                GrowthStages.VINEY_PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                0.1
            )
        ).addHarvestingResult(new ItemStack(Material.DIRT))
            .tryRegister(addon);

        new NothingPlant(
            CultivationStacks.FURNACE_PLANT,
            RecipeTypes.VANILLA_DROP,
            RecipeTypes.createBlockDropRecipe(CultivationStacks.FURNACE_PLANT, new ItemStack(Material.FURNACE), 0.05),
            new Growth(
                GrowthStages.SPIKEY_RED,
                Material.MAGMA_BLOCK,
                0.1
            )
        ).tryRegister(addon);
    }
}
