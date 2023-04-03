package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.slimefun.items.plants.HarvestablePlant;
import dev.sefiraat.cultivation.api.slimefun.items.plants.NothingPlant;
import dev.sefiraat.cultivation.api.slimefun.plant.CommonPlacements;
import dev.sefiraat.cultivation.api.slimefun.plant.Growth;
import dev.sefiraat.cultivation.api.slimefun.plant.PlantTheme;
import dev.sefiraat.cultivation.api.utils.EntityDefinitions;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
import io.github.thebusybiscuit.slimefun4.utils.tags.SlimefunTag;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public final class CultivationPlants {

    private CultivationPlants() {
        throw new IllegalStateException("Utility class");
    }

    public static void setup(Cultivation addon) {

        // region Basis plants (core)

        new NothingPlant(
            CultivationStacks.PLANT_DARKNESS,
            RecipeTypes.MOB,
            RecipeTypes.createMobDropRecipe(CultivationStacks.PLANT_DARKNESS, EntityDefinitions.getHostileMobs(), 0.05),
            new Growth(
                PlantTheme.RED,
                CommonPlacements.COMMON_OVERWORLD,
                0.1
            )
        ).tryRegister(addon);

        new NothingPlant(
            CultivationStacks.PLANT_LIGHT,
            RecipeTypes.MOB,
            RecipeTypes.createMobDropRecipe(CultivationStacks.PLANT_LIGHT, EntityDefinitions.getPassiveMobs(), 0.05),
            new Growth(
                PlantTheme.YELLOW,
                CommonPlacements.COMMON_OVERWORLD,
                0.1
            )
        ).tryRegister(addon);

        new NothingPlant(
            CultivationStacks.PLANT_EARTH,
            RecipeTypes.VANILLA_DROP,
            RecipeTypes.createBlockDropRecipe(CultivationStacks.PLANT_EARTH, SlimefunTag.ORES.getValues(), 0.05),
            new Growth(
                PlantTheme.GREEN,
                CommonPlacements.COMMON_OVERWORLD,
                0.1
            )
        ).tryRegister(addon);

        new NothingPlant(
            CultivationStacks.PLANT_WATER,
            RecipeTypes.VANILLA_DROP,
            RecipeTypes.createBucketingRecipe(
                CultivationStacks.PLANT_WATER,
                Set.of(Material.WATER, Material.POWDER_SNOW),
                0.05
            ),
            new Growth(
                PlantTheme.BLUE,
                CommonPlacements.COMMON_OVERWORLD,
                0.1
            )
        ).tryRegister(addon);

        new NothingPlant(
            CultivationStacks.PLANT_FIRE,
            RecipeTypes.VANILLA_DROP,
            RecipeTypes.createBucketingRecipe(CultivationStacks.PLANT_FIRE, Material.LAVA, 0.05),
            new Growth(
                PlantTheme.RED,
                CommonPlacements.COMMON_OVERWORLD,
                0.1
            )
        ).tryRegister(addon);

        new NothingPlant(
            CultivationStacks.PLANT_AIR,
            RecipeTypes.MOB,
            RecipeTypes.createMobDropRecipe(CultivationStacks.PLANT_AIR, EntityDefinitions.getFlyingMobs(), 0.05),
            new Growth(
                PlantTheme.CYAN,
                CommonPlacements.COMMON_OVERWORLD,
                0.1
            )
        ).tryRegister(addon);

        // endregion

        new HarvestablePlant(
            CultivationStacks.PLANT_DIRT,
            RecipeTypes.PLANT_BREEDING,
            new ItemStack[0],
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                0.05
            )
        ).addHarvestingResult(new ItemStack(Material.DIRT, 1)
        ).addBreedingPair(
            CultivationStacks.PLANT_EARTH.getItemId(),
            CultivationStacks.PLANT_WATER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_GRASS,
            RecipeTypes.PLANT_BREEDING,
            new ItemStack[0],
            new Growth(
                PlantTheme.GREEN,
                CommonPlacements.COMMON_OVERWORLD,
                0.05
            )
        ).addHarvestingResult(new ItemStack(Material.GRASS_BLOCK, 1)
        ).addBreedingPair(
            CultivationStacks.PLANT_DIRT.getItemId(),
            CultivationStacks.PLANT_WATER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

    }
}
