package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.items.bushes.HarvestableBush;
import dev.sefiraat.cultivation.api.slimefun.plant.CommonPlacements;
import dev.sefiraat.cultivation.api.slimefun.plant.Growth;
import dev.sefiraat.cultivation.api.slimefun.plant.PlantTheme;
import dev.sefiraat.cultivation.api.utils.GrowthRates;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;

public final class Bushes {

    private Bushes() {
        throw new IllegalStateException("Utility class");
    }

    public static void setup(Cultivation addon) {

        new HarvestableBush(CultivationStacks.BUSH_GRAPE, new Growth(
            PlantTheme.PURPLE,
            CommonPlacements.COMMON_OVERWORLD,
            GrowthRates.GROWTH_RATE_COMMON
        ))
            .addHarvestingResult(CultivationStacks.GRAPE)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_STRAWBERRY, new Growth(
            PlantTheme.RED,
            CommonPlacements.COMMON_OVERWORLD,
            GrowthRates.GROWTH_RATE_COMMON
        ))
            .addHarvestingResult(CultivationStacks.STRAWBERRY)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_PEANUTS, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            GrowthRates.GROWTH_RATE_COMMON
        ))
            .addHarvestingResult(CultivationStacks.PEANUT)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_RICE, new Growth(
            PlantTheme.YELLOW,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.RICE)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_GARLIC, new Growth(
            PlantTheme.YELLOW,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.GARLIC)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_CAYENNE_PEPPER, new Growth(
            PlantTheme.YELLOW,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.CAYENNE_PEPPER)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_TOMATO, new Growth(
            PlantTheme.RED,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.TOMATO)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_BELL_PEPPER, new Growth(
            PlantTheme.RED,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.BELL_PEPPER)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_ONION, new Growth(
            PlantTheme.YELLOW,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.ONION)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_PEA, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.PEA)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_RAPESEED, new Growth(
            PlantTheme.BLUE,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.RAPESEED)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_LETTUCE, new Growth(
            PlantTheme.BLUE,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.LETTUCE)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_MUSTARD, new Growth(
            PlantTheme.YELLOW,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.MUSTARD_SEEDS)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_BROCCOLI, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.BROCCOLI)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_CINNAMON, new Growth(
            PlantTheme.YELLOW,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.CINNAMON)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_BASIL, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.BASIL)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_BAY_LEAF, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.BAY_LEAF)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_CILANTRO, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.CILANTRO)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_CHICORY, new Growth(
            PlantTheme.BLUE,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.CHICORY)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_CHIVES, new Growth(
            PlantTheme.BLUE,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.CHIVES)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_CLOVE, new Growth(
            PlantTheme.RED,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.CLOVE)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_CUMIN, new Growth(
            PlantTheme.YELLOW,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.CUMIN)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_CHILLI_PEPPER, new Growth(
            PlantTheme.RED,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.CHILLI_PEPPER)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_CURRY_LEAF, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.CURRY_LEAF)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_DILL, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.1
        ))
            .addHarvestingResult(CultivationStacks.DILL)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_FENNEL, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.FENNEL)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_GINGER, new Growth(
            PlantTheme.YELLOW,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.GINGER)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_HORSERADISH, new Growth(
            PlantTheme.YELLOW,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.HORSERADISH)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_JASMINE, new Growth(
            PlantTheme.YELLOW,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.JASMINE)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_JUNIPER_BERRY, new Growth(
            PlantTheme.BLUE,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.JUNIPER_BERRY)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_KAFFIR_LIME, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.KAFFIR_LIME)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_LAVENDER, new Growth(
            PlantTheme.PURPLE,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.LAVENDER)
            .tryRegister(addon);

    }
}
