package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.api.slimefun.items.produce.CultivationProduceCore;
import dev.sefiraat.cultivation.api.slimefun.items.produce.CultivationProduceVanilla;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
import org.bukkit.Material;

public final class CultivationProducts {

    private CultivationProducts() {
        throw new IllegalStateException("Utility class");
    }

    // region Grown/found produce

    public static final CultivationProduceCore GRAPE = new CultivationProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.GRAPE,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationProduceCore STRAWBERRY = new CultivationProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.STRAWBERRY,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationProduceCore PEANUT = new CultivationProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.PEANUT,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationProduceCore BANANA = new CultivationProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.BANANA,
        RecipeTypes.TREE
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationProduceCore ORANGE = new CultivationProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.ORANGE,
        RecipeTypes.TREE
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationProduceCore GREEN_APPLE = new CultivationProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.GREEN_APPLE,
        RecipeTypes.TREE
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationProduceCore RICE = new CultivationProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.RICE,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationProduceCore GARLIC = new CultivationProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.GARLIC,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationProduceCore CAYENNE_PEPPER = new CultivationProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.CAYENNE_PEPPER,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationProduceCore TOMATO = new CultivationProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.TOMATO,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationProduceCore BELL_PEPPER = new CultivationProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.BELL_PEPPER,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationProduceCore ONION = new CultivationProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.ONION,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationProduceCore PEA = new CultivationProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.PEA,
        RecipeTypes.BUSH
    ).buildRegister(Cultivation.getInstance());

    // endregion

    // region Vanilla Registrations

    public static final CultivationProduceVanilla BEEF = new CultivationProduceVanilla(Material.BEEF);
    public static final CultivationProduceVanilla CHICKEN = new CultivationProduceVanilla(Material.CHICKEN);
    public static final CultivationProduceVanilla PORK = new CultivationProduceVanilla(Material.PORKCHOP);
    public static final CultivationProduceVanilla MUTTON = new CultivationProduceVanilla(Material.MUTTON);
    public static final CultivationProduceVanilla RABBIT = new CultivationProduceVanilla(Material.RABBIT);
    public static final CultivationProduceVanilla COD = new CultivationProduceVanilla(Material.COD);
    public static final CultivationProduceVanilla SALMON = new CultivationProduceVanilla(Material.SALMON);
    public static final CultivationProduceVanilla APPLE = new CultivationProduceVanilla(Material.APPLE);
    public static final CultivationProduceVanilla SWEET_BERRY = new CultivationProduceVanilla(Material.SWEET_BERRIES);
    public static final CultivationProduceVanilla GLOW_BERRY = new CultivationProduceVanilla(Material.GLOW_BERRIES);
    public static final CultivationProduceVanilla BEETROOT = new CultivationProduceVanilla(Material.BEETROOT);
    public static final CultivationProduceVanilla GOLDEN_APPLE = new CultivationProduceVanilla(Material.GOLDEN_APPLE);
    public static final CultivationProduceVanilla NOTCH_APPLE = new CultivationProduceVanilla(Material.ENCHANTED_GOLDEN_APPLE);
    public static final CultivationProduceVanilla CARROT = new CultivationProduceVanilla(Material.CARROT);
    public static final CultivationProduceVanilla GOLDEN_CARROT = new CultivationProduceVanilla(Material.GOLDEN_CARROT);
    public static final CultivationProduceVanilla EGG = new CultivationProduceVanilla(Material.EGG);
    public static final CultivationProduceVanilla POTATO = new CultivationProduceVanilla(Material.POTATO);
    public static final CultivationProduceVanilla CHORUS_FRUIT = new CultivationProduceVanilla(Material.CHORUS_FRUIT);
    public static final CultivationProduceVanilla MELON = new CultivationProduceVanilla(Material.MELON);
    public static final CultivationProduceVanilla PUMPKIN = new CultivationProduceVanilla(Material.PUMPKIN);
    public static final CultivationProduceVanilla ROTTEN_FLESH = new CultivationProduceVanilla(Material.ROTTEN_FLESH);
    public static final CultivationProduceVanilla COCOA = new CultivationProduceVanilla(Material.COCOA_BEANS);
    public static final CultivationProduceVanilla BROWN_MUSHROOM = new CultivationProduceVanilla(Material.BROWN_MUSHROOM);
    public static final CultivationProduceVanilla RED_MUSHROOM = new CultivationProduceVanilla(Material.RED_MUSHROOM);
    public static final CultivationProduceVanilla WHEAT = new CultivationProduceVanilla(Material.WHEAT);
    public static final CultivationProduceVanilla PUFFERFISH = new CultivationProduceVanilla(Material.PUFFERFISH);

    // endregion

    public static void setup(Cultivation addon) {

    }
}
