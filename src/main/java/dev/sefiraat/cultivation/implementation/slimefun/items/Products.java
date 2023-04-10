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

    public static final ProduceCore BANANA = new ProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.BANANA,
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

    // endregion

    public static void setup(Cultivation addon) {

    }
}
