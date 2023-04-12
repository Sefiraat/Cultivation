package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.api.slimefun.items.produce.ProduceCore;
import dev.sefiraat.cultivation.api.slimefun.items.produce.ProduceVanilla;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
import org.bukkit.Material;

public final class Products {

    private Products() {
        throw new IllegalStateException("Utility class");
    }

    // region Grown/found produce

    public static final ProduceCore BANANA = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.BANANA,
        RecipeTypes.TREE
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore LEMON = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.LEMON,
        RecipeTypes.TREE
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore ORANGE = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.ORANGE,
        RecipeTypes.TREE
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore GREEN_APPLE = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.GREEN_APPLE,
        RecipeTypes.TREE
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore PINEAPPLE = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.PINEAPPLE,
        RecipeTypes.TREE
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore MANGO = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.MANGO,
        RecipeTypes.TREE
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore PEACH = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.PEACH,
        RecipeTypes.TREE
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore APRICOT = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.APRICOT,
        RecipeTypes.TREE
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore PEAR = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.PEAR,
        RecipeTypes.TREE
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore CHERRY = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.CHERRY,
        RecipeTypes.TREE
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore KIWI = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.KIWI,
        RecipeTypes.TREE
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore LIME = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.LIME,
        RecipeTypes.TREE
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore CHESTNUT = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.CHESTNUT,
        RecipeTypes.TREE
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore HAZELNUT = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.HAZELNUT,
        RecipeTypes.TREE
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore GRAPE = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.GRAPE,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore STRAWBERRY = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.STRAWBERRY,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore PEANUT = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.PEANUT,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore RICE = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.RICE,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore GARLIC = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.GARLIC,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore CAYENNE_PEPPER = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.CAYENNE_PEPPER,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore TOMATO = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.TOMATO,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore BELL_PEPPER = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.BELL_PEPPER,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore ONION = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.ONION,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore PEA = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.PEA,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore RAPESEED = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.RAPESEED,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore LETTUCE = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.LETTUCE,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore MUSTARD_SEEDS = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.MUSTARD_SEEDS,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore BROCCOLI = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.BROCCOLI,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore CINNAMON = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.CINNAMON,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore BASIL = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.BASIL,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore BAY_LEAF = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.BAY_LEAF,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore CILANTRO = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.CILANTRO,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore CHICORY = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.CHICORY,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore CHIVES = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.CHIVES,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore CLOVE = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.CLOVE,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore CUMIN = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.CUMIN,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore CHILLI_PEPPER = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.CHILLI_PEPPER,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore CURRY_LEAF = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.CURRY_LEAF,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore DILL = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.DILL,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore FENNEL = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.FENNEL,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore GINGER = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.GINGER,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore HORSERADISH = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.HORSERADISH,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore JASMINE = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.JASMINE,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore JUNIPER_BERRY = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.JUNIPER_BERRY,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore KAFFIR_LIME = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.KAFFIR_LIME,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore LAVENDER = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.LAVENDER,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore LICORICE = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.LICORICE,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore MACE = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.MACE,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore MARJORAM = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.MARJORAM,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore MINT = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.MINT,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore OREGANO = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.OREGANO,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore PARSLEY = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.PARSLEY,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore ROSEMARY = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.ROSEMARY,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore SASSAFRAS = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.SASSAFRAS,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore SHISO = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.SHISO,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore STAR_ANISE = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.STAR_ANISE,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore TARRAGON = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.TARRAGON,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore THYME = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.THYME,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore TURMERIC = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.TURMERIC,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore VANILLA = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.VANILLA,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore WASABI = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.WASABI,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore ARTICHOKE = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.ARTICHOKE,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore AUBERGINE = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.AUBERGINE,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore ASPARAGUS = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.ASPARAGUS,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore BRUSSELS_SPROUTS = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.BRUSSELS_SPROUTS,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore CABBAGE = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.CABBAGE,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore CAULIFLOWER = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.CAULIFLOWER,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore CELERY = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.CELERY,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore KALE = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.KALE,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore SPINACH = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.SPINACH,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore BLACK_BEANS = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.BLACK_BEANS,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore GREEN_BEANS = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.GREEN_BEANS,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore CHICKPEAS = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.CHICKPEAS,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore SOY_BEANS = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.SOY_BEANS,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore PINTO_BEANS = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.PINTO_BEANS,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore RUNNER_BEANS = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.RUNNER_BEANS,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore NETTLES = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.NETTLES,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore OKRA = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.OKRA,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore LEEK = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.LEEK,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore SHALLOT = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.SHALLOT,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore JALAPENO = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.JALAPENO,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore RADICCHIO = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.RADICCHIO,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore RHUBARB = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.RHUBARB,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore CELERIAC = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.CELERIAC,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore PARSNIP = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.PARSNIP,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());
    
    public static final ProduceCore RUTABAGA = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.RUTABAGA,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());
    
    public static final ProduceCore RADDISH = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.RADDISH,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore SWEET_POTATO = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.SWEET_POTATO,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());
    
    public static final ProduceCore TURNIP = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.TURNIP,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());
    
    public static final ProduceCore SWEETCORN = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.SWEETCORN,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());
    
    public static final ProduceCore COURGETTE = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.COURGETTE,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore CUCUMBER = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.CUCUMBER,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());
    
    public static final ProduceCore MARROW = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.MARROW,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    // endregion

    // region Vanilla Registrations

    public static final ProduceVanilla BEEF = new ProduceVanilla(Material.BEEF);
    public static final ProduceVanilla CHICKEN = new ProduceVanilla(Material.CHICKEN);
    public static final ProduceVanilla PORK = new ProduceVanilla(Material.PORKCHOP);
    public static final ProduceVanilla MUTTON = new ProduceVanilla(Material.MUTTON);
    public static final ProduceVanilla RABBIT = new ProduceVanilla(Material.RABBIT);
    public static final ProduceVanilla COD = new ProduceVanilla(Material.COD);
    public static final ProduceVanilla SALMON = new ProduceVanilla(Material.SALMON);
    public static final ProduceVanilla APPLE = new ProduceVanilla(Material.APPLE);
    public static final ProduceVanilla SWEET_BERRY = new ProduceVanilla(Material.SWEET_BERRIES);
    public static final ProduceVanilla GLOW_BERRY = new ProduceVanilla(Material.GLOW_BERRIES);
    public static final ProduceVanilla BEETROOT = new ProduceVanilla(Material.BEETROOT);
    public static final ProduceVanilla GOLDEN_APPLE = new ProduceVanilla(Material.GOLDEN_APPLE);
    public static final ProduceVanilla NOTCH_APPLE = new ProduceVanilla(Material.ENCHANTED_GOLDEN_APPLE);
    public static final ProduceVanilla CARROT = new ProduceVanilla(Material.CARROT);
    public static final ProduceVanilla GOLDEN_CARROT = new ProduceVanilla(Material.GOLDEN_CARROT);
    public static final ProduceVanilla EGG = new ProduceVanilla(Material.EGG);
    public static final ProduceVanilla POTATO = new ProduceVanilla(Material.POTATO);
    public static final ProduceVanilla CHORUS_FRUIT = new ProduceVanilla(Material.CHORUS_FRUIT);
    public static final ProduceVanilla MELON = new ProduceVanilla(Material.MELON);
    public static final ProduceVanilla PUMPKIN = new ProduceVanilla(Material.PUMPKIN);
    public static final ProduceVanilla ROTTEN_FLESH = new ProduceVanilla(Material.ROTTEN_FLESH);
    public static final ProduceVanilla COCOA = new ProduceVanilla(Material.COCOA_BEANS);
    public static final ProduceVanilla BROWN_MUSHROOM = new ProduceVanilla(Material.BROWN_MUSHROOM);
    public static final ProduceVanilla RED_MUSHROOM = new ProduceVanilla(Material.RED_MUSHROOM);
    public static final ProduceVanilla WHEAT = new ProduceVanilla(Material.WHEAT);
    public static final ProduceVanilla PUFFERFISH = new ProduceVanilla(Material.PUFFERFISH);
    public static final ProduceVanilla BREAD = new ProduceVanilla(Material.BREAD);
    public static final ProduceVanilla SUGAR = new ProduceVanilla(Material.SUGAR);
    public static final ProduceVanilla SEAWEED = new ProduceVanilla(Material.KELP);

    // endregion

    public static void setup(Cultivation addon) {

    }
}
