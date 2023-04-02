package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.slimefun.items.plants.NothingPlant;
import dev.sefiraat.cultivation.api.slimefun.plant.CommonPlacements;
import dev.sefiraat.cultivation.api.slimefun.plant.Growth;
import dev.sefiraat.cultivation.api.slimefun.plant.PlantTheme;
import dev.sefiraat.cultivation.api.utils.EntityDefinitions;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
import io.github.thebusybiscuit.slimefun4.utils.tags.SlimefunTag;
import org.bukkit.Material;

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
                PlantTheme.YELLOW,
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
    }
}
