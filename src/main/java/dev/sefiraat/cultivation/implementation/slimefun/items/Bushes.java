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

        new HarvestableBush(CultivationStacks.BUSH_LICORICE, new Growth(
            PlantTheme.YELLOW,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.LICORICE)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_MACE, new Growth(
            PlantTheme.PURPLE,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.MACE)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_MARJORAM, new Growth(
            PlantTheme.YELLOW,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.MARJORAM)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_MINT, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.MINT)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_OREGANO, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.OREGANO)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_PARSLEY, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.PARSLEY)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_ROSEMARY, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.ROSEMARY)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_SASSAFRAS, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.SASSAFRAS)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_SHISO, new Growth(
            PlantTheme.PURPLE,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.SHISO)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_STAR_ANISE, new Growth(
            PlantTheme.ORANGE,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.STAR_ANISE)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_TARRAGON, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.TARRAGON)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_THYME, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.THYME)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_TURMERIC, new Growth(
            PlantTheme.YELLOW,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.TURMERIC)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_VANILLA, new Growth(
            PlantTheme.YELLOW,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.VANILLA)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_WASABI, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.WASABI)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_ARTICHOKE, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.ARTICHOKE)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_AUBERGINE, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.AUBERGINE)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_ASPARAGUS, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.ASPARAGUS)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_BRUSSELS_SPROUTS, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.BRUSSELS_SPROUTS)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_CABBAGE, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.CABBAGE)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_CAULIFLOWER, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.CAULIFLOWER)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_CELERY, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.CELERY)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_KALE, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.KALE)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_SPINACH, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.SPINACH)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_BLACK_BEANS, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.BLACK_BEANS)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_GREEN_BEANS, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.GREEN_BEANS)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_CHICKPEAS, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.CHICKPEAS)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_SOY_BEANS, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.SOY_BEANS)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_PINTO_BEANS, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.PINTO_BEANS)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_RUNNER_BEANS, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.RUNNER_BEANS)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_NETTLES, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.NETTLES)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_OKRA, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.OKRA)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_LEEK, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.LEEK)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_SHALLOT, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.SHALLOT)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_JALAPENO, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.JALAPENO)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_RADICCHIO, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.RADICCHIO)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_RHUBARB, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.RHUBARB)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_CELERIAC, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.CELERIAC)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_PARSNIP, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.PARSNIP)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_RUTABAGA, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.RUTABAGA)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_RADDISH, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.RADDISH)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_SWEET_POTATO, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.SWEET_POTATO)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_TURNIP, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.TURNIP)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_SWEETCORN, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.SWEETCORN)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_COURGETTE, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.COURGETTE)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_CUCUMBER, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.CUCUMBER)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_MARROW, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.MARROW)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_AVOCADO, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.AVOCADO)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_GREEN_ONION, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.GREEN_ONION)
            .tryRegister(addon);

        new HarvestableBush(CultivationStacks.BUSH_BLACK_PEPPER, new Growth(
            PlantTheme.GREEN,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.BLACK_PEPPER)
            .tryRegister(addon);
    }
}
