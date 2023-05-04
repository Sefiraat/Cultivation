package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.slimefun.items.plants.HarvestablePlant;
import dev.sefiraat.cultivation.api.slimefun.items.plants.NothingPlant;
import dev.sefiraat.cultivation.api.slimefun.plant.CommonPlacements;
import dev.sefiraat.cultivation.api.slimefun.plant.Growth;
import dev.sefiraat.cultivation.api.slimefun.plant.PlantTheme;
import dev.sefiraat.cultivation.api.utils.EntityDefinitions;
import dev.sefiraat.cultivation.api.utils.GrowthRates;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
import io.github.thebusybiscuit.slimefun4.utils.tags.SlimefunTag;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public final class Plants {

    private Plants() {
        throw new IllegalStateException("Utility class");
    }

    public static void setup(Cultivation addon) {

        new NothingPlant(
            CultivationStacks.PLANT_DARKNESS,
            RecipeTypes.MOB,
            RecipeTypes.createMobDropRecipe(CultivationStacks.PLANT_DARKNESS, EntityDefinitions.getHostileMobs(), 0.05),
            new Growth(
                PlantTheme.RED,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_COMMON
            )
        ).tryRegister(addon);

        new NothingPlant(
            CultivationStacks.PLANT_LIGHT,
            RecipeTypes.MOB,
            RecipeTypes.createMobDropRecipe(CultivationStacks.PLANT_LIGHT, EntityDefinitions.getPassiveMobs(), 0.05),
            new Growth(
                PlantTheme.YELLOW,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_COMMON
            )
        ).tryRegister(addon);

        new NothingPlant(
            CultivationStacks.PLANT_EARTH,
            RecipeTypes.VANILLA_DROP,
            RecipeTypes.createBlockDropRecipe(CultivationStacks.PLANT_EARTH, SlimefunTag.ORES.getValues(), 0.05),
            new Growth(
                PlantTheme.GREEN,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_COMMON
            )
        ).tryRegister(addon);

        new NothingPlant(
            CultivationStacks.PLANT_WATER,
            RecipeTypes.BUCKETING,
            RecipeTypes.createBucketingRecipe(
                CultivationStacks.PLANT_WATER,
                Set.of(Material.WATER, Material.POWDER_SNOW),
                0.05
            ),
            new Growth(
                PlantTheme.BLUE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_COMMON
            )
        ).tryRegister(addon);

        new NothingPlant(
            CultivationStacks.PLANT_FIRE,
            RecipeTypes.BUCKETING,
            RecipeTypes.createBucketingRecipe(CultivationStacks.PLANT_FIRE, Material.LAVA, 0.05),
            new Growth(
                PlantTheme.RED,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_COMMON
            )
        ).tryRegister(addon);

        new NothingPlant(
            CultivationStacks.PLANT_AIR,
            RecipeTypes.MOB,
            RecipeTypes.createMobDropRecipe(CultivationStacks.PLANT_AIR, EntityDefinitions.getFlyingMobs(), 0.05),
            new Growth(
                PlantTheme.CYAN,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_COMMON
            )
        ).tryRegister(addon);

        new NothingPlant(
            CultivationStacks.PLANT_POWER,
            RecipeTypes.MOB,
            RecipeTypes.createMobDropRecipe(CultivationStacks.PLANT_POWER, EntityDefinitions.getBossMobs(), 0.2),
            new Growth(
                PlantTheme.RED,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_RARE
            )
        ).tryRegister(addon);

        new NothingPlant(
            CultivationStacks.PLANT_WEALTH,
            new Growth(
                PlantTheme.ORANGE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_RARE
            )
        ).addBreedingPair(
            CultivationStacks.PLANT_VILLAGER.getItemId(),
            CultivationStacks.PLANT_VILLAGER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new NothingPlant(
            CultivationStacks.PLANT_SPECTRUM,
            new Growth(
                PlantTheme.BLUE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addBreedingPair(
            CultivationStacks.PLANT_DARKNESS.getItemId(),
            CultivationStacks.PLANT_LIGHT.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_DIRT,
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_COMMON
            )
        ).addHarvestingResult(new ItemStack(Material.DIRT)
        ).addBreedingPair(
            CultivationStacks.PLANT_EARTH.getItemId(),
            CultivationStacks.PLANT_WATER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_GRASS,
            new Growth(
                PlantTheme.GREEN,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_COMMON
            )
        ).addHarvestingResult(new ItemStack(Material.GRASS_BLOCK)
        ).addBreedingPair(
            CultivationStacks.PLANT_DIRT.getItemId(),
            CultivationStacks.PLANT_WATER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_FLOWER,
            new Growth(
                PlantTheme.ORANGE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_COMMON
            )
        ).addHarvestingResult(new ItemStack(Material.CORNFLOWER, 3)
        ).addHarvestingResult(new ItemStack(Material.LILAC, 3)
        ).addHarvestingResult(new ItemStack(Material.LILY_OF_THE_VALLEY, 3)
        ).addHarvestingResult(new ItemStack(Material.DANDELION, 3)
        ).addHarvestingResult(new ItemStack(Material.POPPY, 3)
        ).addHarvestingResult(new ItemStack(Material.BLUE_ORCHID, 3)
        ).addHarvestingResult(new ItemStack(Material.ALLIUM, 3)
        ).addHarvestingResult(new ItemStack(Material.AZURE_BLUET, 3)
        ).addHarvestingResult(new ItemStack(Material.ORANGE_TULIP, 3)
        ).addHarvestingResult(new ItemStack(Material.PINK_TULIP, 3)
        ).addHarvestingResult(new ItemStack(Material.RED_TULIP, 3)
        ).addHarvestingResult(new ItemStack(Material.WHITE_TULIP, 3)
        ).addHarvestingResult(new ItemStack(Material.OXEYE_DAISY, 3)
        ).addBreedingPair(
            CultivationStacks.PLANT_GRASS.getItemId(),
            CultivationStacks.PLANT_WATER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_VINE,
            new Growth(
                PlantTheme.GREEN,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_COMMON
            )
        ).addHarvestingResult(new ItemStack(Material.VINE, 5)
        ).addBreedingPair(
            CultivationStacks.PLANT_DIRT.getItemId(),
            CultivationStacks.PLANT_FLOWER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_SAND,
            new Growth(
                PlantTheme.YELLOW,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_COMMON
            )
        ).addHarvestingResult(new ItemStack(Material.SAND)
        ).addBreedingPair(
            CultivationStacks.PLANT_DIRT.getItemId(),
            CultivationStacks.PLANT_EARTH.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_RED_SAND,
            new Growth(
                PlantTheme.RED,
                CommonPlacements.COMMON_OVERWORLD,
                0.1
            )
        ).addHarvestingResult(new ItemStack(Material.RED_SAND)
        ).addBreedingPair(
            CultivationStacks.PLANT_SAND.getItemId(),
            CultivationStacks.PLANT_EARTH.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_MOSS,
            new Growth(
                PlantTheme.GREEN,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.MOSS_BLOCK, 2)
        ).addBreedingPair(
            CultivationStacks.PLANT_GRASS.getItemId(),
            CultivationStacks.PLANT_COBBLESTONE.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_SAPLING,
            new Growth(
                PlantTheme.GREEN,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_COMMON
            )
        ).addHarvestingResult(new ItemStack(Material.ACACIA_SAPLING)
        ).addHarvestingResult(new ItemStack(Material.BIRCH_SAPLING)
        ).addHarvestingResult(new ItemStack(Material.DARK_OAK_SAPLING)
        ).addHarvestingResult(new ItemStack(Material.JUNGLE_SAPLING)
        ).addHarvestingResult(new ItemStack(Material.OAK_SAPLING)
        ).addHarvestingResult(new ItemStack(Material.SPRUCE_SAPLING)
        ).addHarvestingResult(new ItemStack(Material.MANGROVE_PROPAGULE)
        ).addBreedingPair(
            CultivationStacks.PLANT_DIRT.getItemId(),
            CultivationStacks.PLANT_LIGHT.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_MUSHROOM,
            new Growth(
                PlantTheme.RED,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_COMMON
            )
        ).addHarvestingResult(new ItemStack(Material.BROWN_MUSHROOM, 4)
        ).addHarvestingResult(new ItemStack(Material.RED_MUSHROOM, 4)
        ).addHarvestingResult(new ItemStack(Material.CRIMSON_FUNGUS, 2)
        ).addHarvestingResult(new ItemStack(Material.WARPED_FUNGUS, 2)
        ).addHarvestingResult(new ItemStack(Material.MYCELIUM)
        ).addBreedingPair(
            CultivationStacks.PLANT_FLOWER.getItemId(),
            CultivationStacks.PLANT_SLIME.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_WITHER_ROSE,
            new Growth(
                PlantTheme.RED,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_EPIC
            )
        ).addHarvestingResult(new ItemStack(Material.WITHER_ROSE)
        ).addBreedingPair(
            CultivationStacks.PLANT_FLOWER.getItemId(),
            CultivationStacks.PLANT_WITHER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_DARK_FLORA,
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.WEEPING_VINES)
        ).addHarvestingResult(new ItemStack(Material.TWISTING_VINES)
        ).addBreedingPair(
            CultivationStacks.PLANT_VINE.getItemId(),
            CultivationStacks.PLANT_NETHERRACK.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_GLOWING_VINE,
            new Growth(
                PlantTheme.YELLOW,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.GLOW_LICHEN, 3)
        ).addBreedingPair(
            CultivationStacks.PLANT_VINE.getItemId(),
            CultivationStacks.PLANT_LIGHT.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_DIM_LIT,
            new Growth(
                PlantTheme.BLUE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_RARE
            )
        ).addHarvestingResult(new ItemStack(Material.OCHRE_FROGLIGHT)
        ).addHarvestingResult(new ItemStack(Material.PEARLESCENT_FROGLIGHT)
        ).addHarvestingResult(new ItemStack(Material.VERDANT_FROGLIGHT)
        ).addBreedingPair(
            CultivationStacks.PLANT_FROG.getItemId(),
            CultivationStacks.PLANT_LIGHT.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_COW,
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.BEEF, 2)
        ).addHarvestingResult(new ItemStack(Material.LEATHER)
        ).addBreedingPair(
            CultivationStacks.PLANT_GRASS.getItemId(),
            CultivationStacks.PLANT_LIGHT.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_CHICKEN,
            new Growth(
                PlantTheme.CYAN,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.CHICKEN, 2)
        ).addHarvestingResult(new ItemStack(Material.FEATHER, 3)
        ).addHarvestingResult(new ItemStack(Material.EGG)
        ).addBreedingPair(
            CultivationStacks.PLANT_AIR.getItemId(),
            CultivationStacks.PLANT_LIGHT.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_FISH,
            new Growth(
                PlantTheme.BLUE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.COD)
        ).addHarvestingResult(new ItemStack(Material.SALMON)
        ).addHarvestingResult(new ItemStack(Material.TROPICAL_FISH)
        ).addHarvestingResult(new ItemStack(Material.PUFFERFISH)
        ).addBreedingPair(
            CultivationStacks.PLANT_WATER.getItemId(),
            CultivationStacks.PLANT_LIGHT.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_TURTLE,
            new Growth(
                PlantTheme.GREEN,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.SCUTE), 5
        ).addHarvestingResult(new ItemStack(Material.SEAGRASS, 5), 7
        ).addHarvestingResult(new ItemStack(Material.TURTLE_EGG), 1
        ).addBreedingPair(
            CultivationStacks.PLANT_CHICKEN.getItemId(),
            CultivationStacks.PLANT_WATER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_VILLAGER,
            new Growth(
                PlantTheme.YELLOW,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.PAPER, 10)
        ).addBreedingPair(
            CultivationStacks.PLANT_ZOMBIE.getItemId(),
            CultivationStacks.PLANT_LIGHT.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_RABBIT,
            new Growth(
                PlantTheme.ORANGE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.RABBIT), 4
        ).addHarvestingResult(new ItemStack(Material.RABBIT_HIDE), 4
        ).addHarvestingResult(new ItemStack(Material.RABBIT_FOOT), 1
        ).addBreedingPair(
            CultivationStacks.PLANT_CHICKEN.getItemId(),
            CultivationStacks.PLANT_EARTH.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_SHEEP,
            new Growth(
                PlantTheme.YELLOW,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.MUTTON)
        ).addHarvestingResult(new ItemStack(Material.WHITE_WOOL)
        ).addBreedingPair(
            CultivationStacks.PLANT_COW.getItemId(),
            CultivationStacks.PLANT_CHICKEN.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_PIG,
            new Growth(
                PlantTheme.RED,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.PORKCHOP, 2)
        ).addBreedingPair(
            CultivationStacks.PLANT_COW.getItemId(),
            CultivationStacks.PLANT_SHEEP.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_BEE,
            new Growth(
                PlantTheme.YELLOW,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.HONEYCOMB), 4
        ).addHarvestingResult(new ItemStack(Material.HONEY_BOTTLE), 1
        ).addBreedingPair(
            CultivationStacks.PLANT_COW.getItemId(),
            CultivationStacks.PLANT_SHEEP.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_SQUID,
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.INK_SAC, 3)
        ).addBreedingPair(
            CultivationStacks.PLANT_FISH.getItemId(),
            CultivationStacks.PLANT_COW.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_GLOW_SQUID,
            new Growth(
                PlantTheme.GREEN,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_RARE
            )
        ).addHarvestingResult(new ItemStack(Material.GLOW_INK_SAC, 3)
        ).addBreedingPair(
            CultivationStacks.PLANT_SQUID.getItemId(),
            CultivationStacks.PLANT_LIGHT.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_FROG,
            new Growth(
                PlantTheme.GREEN,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_RARE
            )
        ).addHarvestingResult(new ItemStack(Material.FROGSPAWN, 2)
        ).addBreedingPair(
            CultivationStacks.PLANT_SQUID.getItemId(),
            CultivationStacks.PLANT_BEE.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_GOAT,
            new Growth(
                PlantTheme.ORANGE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_RARE
            )
        ).addHarvestingResult(new ItemStack(Material.GOAT_HORN)
        ).addBreedingPair(
            CultivationStacks.PLANT_SHEEP.getItemId(),
            CultivationStacks.PLANT_POWER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_RAINBOW,
            new Growth(
                PlantTheme.BLUE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_COMMON
            )
        ).addHarvestingResult(new ItemStack(Material.BLACK_DYE, 4)
        ).addHarvestingResult(new ItemStack(Material.BLUE_DYE, 4)
        ).addHarvestingResult(new ItemStack(Material.BROWN_DYE, 4)
        ).addHarvestingResult(new ItemStack(Material.CYAN_DYE, 4)
        ).addHarvestingResult(new ItemStack(Material.GRAY_DYE, 4)
        ).addHarvestingResult(new ItemStack(Material.GREEN_DYE, 4)
        ).addHarvestingResult(new ItemStack(Material.LIGHT_BLUE_DYE, 4)
        ).addHarvestingResult(new ItemStack(Material.LIGHT_GRAY_DYE, 4)
        ).addHarvestingResult(new ItemStack(Material.LIME_DYE, 4)
        ).addHarvestingResult(new ItemStack(Material.MAGENTA_DYE, 4)
        ).addHarvestingResult(new ItemStack(Material.ORANGE_DYE, 4)
        ).addHarvestingResult(new ItemStack(Material.PINK_DYE, 4)
        ).addHarvestingResult(new ItemStack(Material.PURPLE_DYE, 4)
        ).addHarvestingResult(new ItemStack(Material.RED_DYE, 4)
        ).addHarvestingResult(new ItemStack(Material.WHITE_DYE, 4)
        ).addHarvestingResult(new ItemStack(Material.YELLOW_DYE, 4)
        ).addBreedingPair(
            CultivationStacks.PLANT_SPECTRUM.getItemId(),
            CultivationStacks.PLANT_SPECTRUM.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_WAXY,
            new Growth(
                PlantTheme.YELLOW,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.BLACK_CANDLE, 1)
        ).addHarvestingResult(new ItemStack(Material.BLUE_CANDLE, 1)
        ).addHarvestingResult(new ItemStack(Material.BROWN_CANDLE, 1)
        ).addHarvestingResult(new ItemStack(Material.CYAN_CANDLE, 1)
        ).addHarvestingResult(new ItemStack(Material.GRAY_CANDLE, 1)
        ).addHarvestingResult(new ItemStack(Material.GREEN_CANDLE, 1)
        ).addHarvestingResult(new ItemStack(Material.LIGHT_BLUE_CANDLE, 1)
        ).addHarvestingResult(new ItemStack(Material.LIGHT_GRAY_CANDLE, 1)
        ).addHarvestingResult(new ItemStack(Material.LIME_CANDLE, 1)
        ).addHarvestingResult(new ItemStack(Material.MAGENTA_CANDLE, 1)
        ).addHarvestingResult(new ItemStack(Material.ORANGE_CANDLE, 1)
        ).addHarvestingResult(new ItemStack(Material.PINK_CANDLE, 1)
        ).addHarvestingResult(new ItemStack(Material.PURPLE_CANDLE, 1)
        ).addHarvestingResult(new ItemStack(Material.RED_CANDLE, 1)
        ).addHarvestingResult(new ItemStack(Material.WHITE_CANDLE, 1)
        ).addHarvestingResult(new ItemStack(Material.YELLOW_CANDLE, 1)
        ).addBreedingPair(
            CultivationStacks.PLANT_RAINBOW.getItemId(),
            CultivationStacks.PLANT_BEE.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_WOOLLY,
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.BLACK_WOOL, 2)
        ).addHarvestingResult(new ItemStack(Material.BLUE_WOOL, 2)
        ).addHarvestingResult(new ItemStack(Material.BROWN_WOOL, 2)
        ).addHarvestingResult(new ItemStack(Material.CYAN_WOOL, 2)
        ).addHarvestingResult(new ItemStack(Material.GRAY_WOOL, 2)
        ).addHarvestingResult(new ItemStack(Material.GREEN_WOOL, 2)
        ).addHarvestingResult(new ItemStack(Material.LIGHT_BLUE_WOOL, 2)
        ).addHarvestingResult(new ItemStack(Material.LIGHT_GRAY_WOOL, 2)
        ).addHarvestingResult(new ItemStack(Material.LIME_WOOL, 2)
        ).addHarvestingResult(new ItemStack(Material.MAGENTA_WOOL, 2)
        ).addHarvestingResult(new ItemStack(Material.ORANGE_WOOL, 2)
        ).addHarvestingResult(new ItemStack(Material.PINK_WOOL, 2)
        ).addHarvestingResult(new ItemStack(Material.PURPLE_WOOL, 2)
        ).addHarvestingResult(new ItemStack(Material.RED_WOOL, 2)
        ).addHarvestingResult(new ItemStack(Material.WHITE_WOOL, 2)
        ).addHarvestingResult(new ItemStack(Material.YELLOW_WOOL, 2)
        ).addBreedingPair(
            CultivationStacks.PLANT_RAINBOW.getItemId(),
            CultivationStacks.PLANT_SHEEP.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_TERRA,
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.BLACK_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.BLUE_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.BROWN_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.CYAN_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.GRAY_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.GREEN_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.LIGHT_BLUE_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.LIGHT_GRAY_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.LIME_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.MAGENTA_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.ORANGE_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.PINK_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.PURPLE_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.RED_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.WHITE_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.YELLOW_TERRACOTTA, 2)
        ).addBreedingPair(
            CultivationStacks.PLANT_RAINBOW.getItemId(),
            CultivationStacks.PLANT_EARTH.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_GLAZED,
            new Growth(
                PlantTheme.ORANGE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.BLACK_GLAZED_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.BLUE_GLAZED_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.BROWN_GLAZED_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.CYAN_GLAZED_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.GRAY_GLAZED_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.GREEN_GLAZED_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.LIGHT_BLUE_GLAZED_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.LIGHT_GRAY_GLAZED_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.LIME_GLAZED_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.MAGENTA_GLAZED_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.ORANGE_GLAZED_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.PINK_GLAZED_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.PURPLE_GLAZED_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.RED_GLAZED_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.WHITE_GLAZED_TERRACOTTA, 2)
        ).addHarvestingResult(new ItemStack(Material.YELLOW_GLAZED_TERRACOTTA, 2)
        ).addBreedingPair(
            CultivationStacks.PLANT_TERRA.getItemId(),
            CultivationStacks.PLANT_FIRE.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_DUSTY,
            new Growth(
                PlantTheme.ORANGE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.BLACK_CONCRETE_POWDER, 2)
        ).addHarvestingResult(new ItemStack(Material.BLUE_CONCRETE_POWDER, 2)
        ).addHarvestingResult(new ItemStack(Material.BROWN_CONCRETE_POWDER, 2)
        ).addHarvestingResult(new ItemStack(Material.CYAN_CONCRETE_POWDER, 2)
        ).addHarvestingResult(new ItemStack(Material.GRAY_CONCRETE_POWDER, 2)
        ).addHarvestingResult(new ItemStack(Material.GREEN_CONCRETE_POWDER, 2)
        ).addHarvestingResult(new ItemStack(Material.LIGHT_BLUE_CONCRETE_POWDER, 2)
        ).addHarvestingResult(new ItemStack(Material.LIGHT_GRAY_CONCRETE_POWDER, 2)
        ).addHarvestingResult(new ItemStack(Material.LIME_CONCRETE_POWDER, 2)
        ).addHarvestingResult(new ItemStack(Material.MAGENTA_CONCRETE_POWDER, 2)
        ).addHarvestingResult(new ItemStack(Material.ORANGE_CONCRETE_POWDER, 2)
        ).addHarvestingResult(new ItemStack(Material.PINK_CONCRETE_POWDER, 2)
        ).addHarvestingResult(new ItemStack(Material.PURPLE_CONCRETE_POWDER, 2)
        ).addHarvestingResult(new ItemStack(Material.RED_CONCRETE_POWDER, 2)
        ).addHarvestingResult(new ItemStack(Material.WHITE_CONCRETE_POWDER, 2)
        ).addHarvestingResult(new ItemStack(Material.YELLOW_CONCRETE_POWDER, 2)
        ).addBreedingPair(
            CultivationStacks.PLANT_TERRA.getItemId(),
            CultivationStacks.PLANT_SAND.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_CONCRETE,
            new Growth(
                PlantTheme.CYAN,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.BLACK_CONCRETE, 2)
        ).addHarvestingResult(new ItemStack(Material.BLUE_CONCRETE, 2)
        ).addHarvestingResult(new ItemStack(Material.BROWN_CONCRETE, 2)
        ).addHarvestingResult(new ItemStack(Material.CYAN_CONCRETE, 2)
        ).addHarvestingResult(new ItemStack(Material.GRAY_CONCRETE, 2)
        ).addHarvestingResult(new ItemStack(Material.GREEN_CONCRETE, 2)
        ).addHarvestingResult(new ItemStack(Material.LIGHT_BLUE_CONCRETE, 2)
        ).addHarvestingResult(new ItemStack(Material.LIGHT_GRAY_CONCRETE, 2)
        ).addHarvestingResult(new ItemStack(Material.LIME_CONCRETE, 2)
        ).addHarvestingResult(new ItemStack(Material.MAGENTA_CONCRETE, 2)
        ).addHarvestingResult(new ItemStack(Material.ORANGE_CONCRETE, 2)
        ).addHarvestingResult(new ItemStack(Material.PINK_CONCRETE, 2)
        ).addHarvestingResult(new ItemStack(Material.PURPLE_CONCRETE, 2)
        ).addHarvestingResult(new ItemStack(Material.RED_CONCRETE, 2)
        ).addHarvestingResult(new ItemStack(Material.WHITE_CONCRETE, 2)
        ).addHarvestingResult(new ItemStack(Material.YELLOW_CONCRETE, 2)
        ).addBreedingPair(
            CultivationStacks.PLANT_DUSTY.getItemId(),
            CultivationStacks.PLANT_WATER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_STAINED,
            new Growth(
                PlantTheme.CYAN,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.BLACK_STAINED_GLASS, 2)
        ).addHarvestingResult(new ItemStack(Material.BLUE_STAINED_GLASS, 2)
        ).addHarvestingResult(new ItemStack(Material.BROWN_STAINED_GLASS, 2)
        ).addHarvestingResult(new ItemStack(Material.CYAN_STAINED_GLASS, 2)
        ).addHarvestingResult(new ItemStack(Material.GRAY_STAINED_GLASS, 2)
        ).addHarvestingResult(new ItemStack(Material.GREEN_STAINED_GLASS, 2)
        ).addHarvestingResult(new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS, 2)
        ).addHarvestingResult(new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS, 2)
        ).addHarvestingResult(new ItemStack(Material.LIME_STAINED_GLASS, 2)
        ).addHarvestingResult(new ItemStack(Material.MAGENTA_STAINED_GLASS, 2)
        ).addHarvestingResult(new ItemStack(Material.ORANGE_STAINED_GLASS, 2)
        ).addHarvestingResult(new ItemStack(Material.PINK_STAINED_GLASS, 2)
        ).addHarvestingResult(new ItemStack(Material.PURPLE_STAINED_GLASS, 2)
        ).addHarvestingResult(new ItemStack(Material.RED_STAINED_GLASS, 2)
        ).addHarvestingResult(new ItemStack(Material.WHITE_STAINED_GLASS, 2)
        ).addHarvestingResult(new ItemStack(Material.YELLOW_STAINED_GLASS, 2)
        ).addBreedingPair(
            CultivationStacks.PLANT_GLASS.getItemId(),
            CultivationStacks.PLANT_RAINBOW.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);
        
        new HarvestablePlant(
            CultivationStacks.PLANT_COBBLESTONE,
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_COMMON
            )
        ).addHarvestingResult(new ItemStack(Material.COBBLESTONE, 4)
        ).addBreedingPair(
            CultivationStacks.PLANT_FIRE.getItemId(),
            CultivationStacks.PLANT_WATER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);
        
        new HarvestablePlant(
            CultivationStacks.PLANT_GRAVEL,
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_COMMON
            )
        ).addHarvestingResult(new ItemStack(Material.GRAVEL, 4)
        ).addBreedingPair(
            CultivationStacks.PLANT_COBBLESTONE.getItemId(),
            CultivationStacks.PLANT_EARTH.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);
        
        new HarvestablePlant(
            CultivationStacks.PLANT_CLAY,
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_COMMON
            )
        ).addHarvestingResult(new ItemStack(Material.CLAY)
        ).addBreedingPair(
            CultivationStacks.PLANT_GRAVEL.getItemId(),
            CultivationStacks.PLANT_WATER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);
        
        new HarvestablePlant(
            CultivationStacks.PLANT_IGNEOUS,
            new Growth(
                PlantTheme.BLUE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.GRANITE, 4)
        ).addHarvestingResult(new ItemStack(Material.DIORITE, 4)
        ).addHarvestingResult(new ItemStack(Material.ANDESITE, 4)
        ).addHarvestingResult(new ItemStack(Material.CALCITE, 2)
        ).addHarvestingResult(new ItemStack(Material.TUFF, 2)
        ).addHarvestingResult(new ItemStack(Material.DRIPSTONE_BLOCK)
        ).addBreedingPair(
            CultivationStacks.PLANT_COBBLESTONE.getItemId(),
            CultivationStacks.PLANT_FIRE.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_DEEPSLATE,
            new Growth(
                PlantTheme.BLUE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.DEEPSLATE, 4)
        ).addBreedingPair(
            CultivationStacks.PLANT_COBBLESTONE.getItemId(),
            CultivationStacks.PLANT_EARTH.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_REINFORCED,
            new Growth(
                PlantTheme.BLUE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_LEGEND
            )
        ).addHarvestingResult(new ItemStack(Material.REINFORCED_DEEPSLATE)
        ).addBreedingPair(
            CultivationStacks.PLANT_DEEPSLATE.getItemId(),
            CultivationStacks.PLANT_SCRAPPY.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_BLACKSTONE,
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.BLACKSTONE, 4)
        ).addBreedingPair(
            CultivationStacks.PLANT_IGNEOUS.getItemId(),
            CultivationStacks.PLANT_FIRE.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_NETHERRACK,
            new Growth(
                PlantTheme.RED,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_COMMON
            )
        ).addHarvestingResult(new ItemStack(Material.NETHERRACK, 5)
        ).addBreedingPair(
            CultivationStacks.PLANT_DIRT.getItemId(),
            CultivationStacks.PLANT_FIRE.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_DARK_GRASS,
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.WARPED_NYLIUM, 4)
        ).addHarvestingResult(new ItemStack(Material.CRIMSON_NYLIUM, 4)
        ).addBreedingPair(
            CultivationStacks.PLANT_NETHERRACK.getItemId(),
            CultivationStacks.PLANT_GRASS.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_MAGMA,
            new Growth(
                PlantTheme.RED,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.MAGMA_BLOCK, 4)
        ).addBreedingPair(
            CultivationStacks.PLANT_MAGMA_CUBE.getItemId(),
            CultivationStacks.PLANT_NETHERRACK.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_SOUL,
            new Growth(
                PlantTheme.RED,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.SOUL_SAND, 4), 20
        ).addHarvestingResult(new ItemStack(Material.SOUL_SOIL, 3), 20
        ).addHarvestingResult(new ItemStack(Material.GHAST_TEAR), 1
        ).addBreedingPair(
            CultivationStacks.PLANT_SAND.getItemId(),
            CultivationStacks.PLANT_NETHERRACK.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_BASALT,
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.BASALT, 4)
        ).addBreedingPair(
            CultivationStacks.PLANT_NETHERRACK.getItemId(),
            CultivationStacks.PLANT_COBBLESTONE.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_GLASS,
            new Growth(
                PlantTheme.YELLOW,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.GLASS, 3)
        ).addBreedingPair(
            CultivationStacks.PLANT_SAND.getItemId(),
            CultivationStacks.PLANT_FIRE.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_MUD,
            new Growth(
                PlantTheme.BLUE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.MUD, 3)
        ).addBreedingPair(
            CultivationStacks.PLANT_DIRT.getItemId(),
            CultivationStacks.PLANT_DARKNESS.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_END_STONE,
            new Growth(
                PlantTheme.YELLOW,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.END_STONE, 3)
        ).addBreedingPair(
            CultivationStacks.PLANT_COBBLESTONE.getItemId(),
            CultivationStacks.PLANT_ENDERMAN.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_PURPUR,
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_RARE
            )
        ).addHarvestingResult(new ItemStack(Material.PURPUR_BLOCK, 3)
        ).addBreedingPair(
            CultivationStacks.PLANT_END_STONE.getItemId(),
            CultivationStacks.PLANT_SHULKER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_COAL,
            new Growth(
                PlantTheme.RED,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.COAL, 3)
        ).addBreedingPair(
            CultivationStacks.PLANT_FIRE.getItemId(),
            CultivationStacks.PLANT_EARTH.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_RAW_IRON,
            new Growth(
                PlantTheme.RED,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.RAW_IRON, 2)
        ).addBreedingPair(
            CultivationStacks.PLANT_COAL.getItemId(),
            CultivationStacks.PLANT_EARTH.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_RAW_COPPER,
            new Growth(
                PlantTheme.ORANGE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.RAW_COPPER, 2)
        ).addBreedingPair(
            CultivationStacks.PLANT_COAL.getItemId(),
            CultivationStacks.PLANT_EARTH.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_RAW_GOLD,
            new Growth(
                PlantTheme.YELLOW,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_RARE
            )
        ).addHarvestingResult(new ItemStack(Material.RAW_GOLD, 2)
        ).addBreedingPair(
            CultivationStacks.PLANT_RAW_IRON.getItemId(),
            CultivationStacks.PLANT_RAW_COPPER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_REDSTONE,
            new Growth(
                PlantTheme.RED,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_RARE
            )
        ).addHarvestingResult(new ItemStack(Material.REDSTONE, 5)
        ).addBreedingPair(
            CultivationStacks.PLANT_RAW_GOLD.getItemId(),
            CultivationStacks.PLANT_FLOWER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_LAPIS,
            new Growth(
                PlantTheme.BLUE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_RARE
            )
        ).addHarvestingResult(new ItemStack(Material.LAPIS_LAZULI, 5)
        ).addBreedingPair(
            CultivationStacks.PLANT_REDSTONE.getItemId(),
            CultivationStacks.PLANT_RAW_GOLD.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_DIAMOND,
            new Growth(
                PlantTheme.BLUE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_EPIC
            )
        ).addHarvestingResult(new ItemStack(Material.DIAMOND)
        ).addBreedingPair(
            CultivationStacks.PLANT_LAPIS.getItemId(),
            CultivationStacks.PLANT_WEALTH.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_EMERALD,
            new Growth(
                PlantTheme.GREEN,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_EPIC
            )
        ).addHarvestingResult(new ItemStack(Material.EMERALD)
        ).addBreedingPair(
            CultivationStacks.PLANT_VILLAGER.getItemId(),
            CultivationStacks.PLANT_WEALTH.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_NETHER_QUARTZ,
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_RARE
            )
        ).addHarvestingResult(new ItemStack(Material.QUARTZ, 3)
        ).addBreedingPair(
            CultivationStacks.PLANT_LAPIS.getItemId(),
            CultivationStacks.PLANT_DARKNESS.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_SCRAPPY,
            new Growth(
                PlantTheme.RED,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_LEGEND
            )
        ).addHarvestingResult(new ItemStack(Material.NETHERITE_SCRAP)
        ).addBreedingPair(
            CultivationStacks.PLANT_NETHER_QUARTZ.getItemId(),
            CultivationStacks.PLANT_POWER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_AMETHYST,
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.AMETHYST_SHARD, 3)
        ).addBreedingPair(
            CultivationStacks.PLANT_EARTH.getItemId(),
            CultivationStacks.PLANT_SPECTRUM.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_ECHO,
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_EPIC
            )
        ).addHarvestingResult(new ItemStack(Material.ECHO_SHARD)
        ).addBreedingPair(
            CultivationStacks.PLANT_AMETHYST.getItemId(),
            CultivationStacks.PLANT_EMERALD.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_SKELETON,
            new Growth(
                PlantTheme.GREEN,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.BONE, 2), 20
        ).addHarvestingResult(new ItemStack(Material.ARROW, 2), 20
        ).addHarvestingResult(new ItemStack(Material.SKELETON_SKULL, 1), 1
        ).addBreedingPair(
            CultivationStacks.PLANT_DARKNESS.getItemId(),
            CultivationStacks.PLANT_AIR.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_SPIDER,
            new Growth(
                PlantTheme.RED,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.SPIDER_EYE), 5
        ).addHarvestingResult(new ItemStack(Material.FERMENTED_SPIDER_EYE), 1
        ).addHarvestingResult(new ItemStack(Material.STRING, 3), 10
        ).addBreedingPair(
            CultivationStacks.PLANT_DARKNESS.getItemId(),
            CultivationStacks.PLANT_DARKNESS.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_CREEPER,
            new Growth(
                PlantTheme.GREEN,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.GUNPOWDER, 4), 30
        ).addHarvestingResult(new ItemStack(Material.CREEPER_HEAD), 1
        ).addBreedingPair(
            CultivationStacks.PLANT_DARKNESS.getItemId(),
            CultivationStacks.PLANT_FIRE.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_ZOMBIE,
            new Growth(
                PlantTheme.GREEN,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.ROTTEN_FLESH, 4), 20
        ).addHarvestingResult(new ItemStack(Material.ZOMBIE_HEAD), 1
        ).addBreedingPair(
            CultivationStacks.PLANT_DARKNESS.getItemId(),
            CultivationStacks.PLANT_EARTH.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_DROWNED,
            new Growth(
                PlantTheme.BLUE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_RARE
            )
        ).addHarvestingResult(new ItemStack(Material.ROTTEN_FLESH, 4), 90
        ).addHarvestingResult(new ItemStack(Material.NAUTILUS_SHELL), 9
        ).addHarvestingResult(new ItemStack(Material.TRIDENT), 1
        ).addBreedingPair(
            CultivationStacks.PLANT_ZOMBIE.getItemId(),
            CultivationStacks.PLANT_WATER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_GUARDIAN,
            new Growth(
                PlantTheme.BLUE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.PRISMARINE_SHARD, 2), 9
        ).addHarvestingResult(new ItemStack(Material.PRISMARINE_CRYSTALS, 1), 1
        ).addBreedingPair(
            CultivationStacks.PLANT_DROWNED.getItemId(),
            CultivationStacks.PLANT_TURTLE.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_ELDER_GUARDIAN,
            new Growth(
                PlantTheme.BLUE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_EPIC
            )
        ).addHarvestingResult(new ItemStack(Material.PRISMARINE_SHARD, 3), 10
        ).addHarvestingResult(new ItemStack(Material.PRISMARINE_CRYSTALS, 2), 4
        ).addHarvestingResult(new ItemStack(Material.SPONGE, 2), 1
        ).addBreedingPair(
            CultivationStacks.PLANT_GUARDIAN.getItemId(),
            CultivationStacks.PLANT_POWER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_GHAST,
            new Growth(
                PlantTheme.YELLOW,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_RARE
            )
        ).addHarvestingResult(new ItemStack(Material.GHAST_TEAR)
        ).addBreedingPair(
            CultivationStacks.PLANT_BLAZE.getItemId(),
            CultivationStacks.PLANT_MAGMA_CUBE.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_SLIME,
            new Growth(
                PlantTheme.GREEN,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.SLIME_BALL, 2)
        ).addBreedingPair(
            CultivationStacks.PLANT_PIG.getItemId(),
            CultivationStacks.PLANT_SQUID.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_MAGMA_CUBE,
            new Growth(
                PlantTheme.RED,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.MAGMA_CREAM, 1)
        ).addBreedingPair(
            CultivationStacks.PLANT_SLIME.getItemId(),
            CultivationStacks.PLANT_FIRE.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_BLAZE,
            new Growth(
                PlantTheme.RED,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.BLAZE_POWDER, 2), 7
        ).addHarvestingResult(new ItemStack(Material.BLAZE_ROD), 1
        ).addBreedingPair(
            CultivationStacks.PLANT_CREEPER.getItemId(),
            CultivationStacks.PLANT_PHANTOM.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_WITHER_SKELETON,
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_EPIC
            )
        ).addHarvestingResult(new ItemStack(Material.BONE, 6), 9
        ).addHarvestingResult(new ItemStack(Material.WITHER_SKELETON_SKULL), 1
        ).addBreedingPair(
            CultivationStacks.PLANT_SKELETON.getItemId(),
            CultivationStacks.PLANT_POWER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_WITHER,
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_LEGEND
            )
        ).addHarvestingResult(new ItemStack(Material.NETHER_STAR)
        ).addBreedingPair(
            CultivationStacks.PLANT_WITHER_SKELETON.getItemId(),
            CultivationStacks.PLANT_POWER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_PHANTOM,
            new Growth(
                PlantTheme.BLUE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.PHANTOM_MEMBRANE, 2)
        ).addBreedingPair(
            CultivationStacks.PLANT_SPIDER.getItemId(),
            CultivationStacks.PLANT_CHICKEN.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_SHULKER,
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_RARE
            )
        ).addHarvestingResult(new ItemStack(Material.SHULKER_SHELL, 2)
        ).addBreedingPair(
            CultivationStacks.PLANT_ENDERMAN.getItemId(),
            CultivationStacks.PLANT_TURTLE.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_ENDERMAN,
            new Growth(
                PlantTheme.GREEN,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_UNCOMMON
            )
        ).addHarvestingResult(new ItemStack(Material.ENDER_PEARL, 2), 7
        ).addHarvestingResult(new ItemStack(Material.ENDER_EYE), 1
        ).addBreedingPair(
            CultivationStacks.PLANT_PHANTOM.getItemId(),
            CultivationStacks.PLANT_DARKNESS.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_ENDER_DRAGON,
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_LEGEND
            )
        ).addHarvestingResult(new ItemStack(Material.DRAGON_BREATH, 2), 480
        ).addHarvestingResult(new ItemStack(Material.DRAGON_HEAD), 19
        ).addHarvestingResult(new ItemStack(Material.DRAGON_EGG), 1
        ).addBreedingPair(
            CultivationStacks.PLANT_ENDERMAN.getItemId(),
            CultivationStacks.PLANT_POWER.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);

        new HarvestablePlant(
            CultivationStacks.PLANT_WITCH,
            new Growth(
                PlantTheme.PURPLE,
                CommonPlacements.COMMON_OVERWORLD,
                GrowthRates.GROWTH_RATE_RARE
            )
        ).addHarvestingResult(new ItemStack(Material.REDSTONE, 6), 3
        ).addHarvestingResult(new ItemStack(Material.GLOWSTONE, 8), 1
        ).addBreedingPair(
            CultivationStacks.PLANT_VILLAGER.getItemId(),
            CultivationStacks.PLANT_FIRE.getItemId(),
            0.05,
            0.10
        ).tryRegister(addon);
    }
}
