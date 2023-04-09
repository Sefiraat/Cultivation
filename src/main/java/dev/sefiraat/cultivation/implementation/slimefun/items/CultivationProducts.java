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
    )
        .setBlendable(true);

    public static final CultivationProduceCore STRAWBERRY = new CultivationProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.STRAWBERRY,
        RecipeTypes.BUSH
    )
        .setBlendable(true)
        .setSliceable(true);

    public static final CultivationProduceCore PEANUT = new CultivationProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.PEANUT,
        RecipeTypes.BUSH
    )
        .setBlendable(true);

    public static final CultivationProduceCore BANANA = new CultivationProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.PRODUCE_BANANA,
        RecipeTypes.TREE
    )
        .setBlendable(true)
        .setSliceable(true)
        .setMashable(true)
        .setChoppable(true)
        .setBakeable(true)
        .setFryable(true)
        .setGrillable(true);

    public static final CultivationProduceCore ORANGE = new CultivationProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.ORANGE,
        RecipeTypes.TREE
    )
        .setBlendable(true)
        .setSliceable(true);

    public static final CultivationProduceCore GREEN_APPLE = new CultivationProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.GREEN_APPLE,
        RecipeTypes.TREE
    )
        .setBlendable(true)
        .setSliceable(true)
        .setBakeable(true);

    public static final CultivationProduceCore RICE = new CultivationProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.RICE,
        RecipeTypes.BUSH
    )
        .setFryable(true);

    public static final CultivationProduceCore GARLIC = new CultivationProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.GARLIC,
        RecipeTypes.BUSH
    )
        .setChoppable(true)
        .setGrindable(true)
        .setFryable(true);

    public static final CultivationProduceCore CAYENNE_PEPPER = new CultivationProduceCore(
        CultivationGroups.PRODUCE,
        CultivationStacks.CAYENNE_PEPPER,
        RecipeTypes.BUSH
    )
        .setChoppable(true)
        .setGrindable(true);

    // endregion

    // region Vanilla Registrations

    public static final CultivationProduceVanilla BEEF = new CultivationProduceVanilla(Material.BEEF)
        .setGrillable(true)
        .setGrindable(true)
        .setFryable(true)
        .createByProducts();

    public static final CultivationProduceVanilla CHICKEN = new CultivationProduceVanilla(Material.CHICKEN)
        .setGrillable(true)
        .setFryable(true)
        .createByProducts();

    public static final CultivationProduceVanilla PORK = new CultivationProduceVanilla(Material.PORKCHOP)
        .setGrillable(true)
        .setBakeable(true)
        .setFryable(true)
        .createByProducts();

    public static final CultivationProduceVanilla MUTTON = new CultivationProduceVanilla(Material.MUTTON)
        .setGrillable(true)
        .setGrindable(true)
        .setFryable(true)
        .createByProducts();

    public static final CultivationProduceVanilla RABBIT = new CultivationProduceVanilla(Material.RABBIT)
        .setGrillable(true)
        .setFryable(true)
        .createByProducts();

    public static final CultivationProduceVanilla COD = new CultivationProduceVanilla(Material.COD)
        .setGrillable(true)
        .setBakeable(true)
        .setFryable(true)
        .createByProducts();

    public static final CultivationProduceVanilla SALMON = new CultivationProduceVanilla(Material.SALMON)
        .setGrillable(true)
        .setBakeable(true)
        .setSliceable(true)
        .setFryable(true)
        .createByProducts();

    public static final CultivationProduceVanilla APPLE = new CultivationProduceVanilla(Material.APPLE)
        .setBakeable(true)
        .setBlendable(true)
        .createByProducts();

    public static final CultivationProduceVanilla SWEET_BERRY = new CultivationProduceVanilla(Material.SWEET_BERRIES)
        .setBlendable(true)
        .createByProducts();

    public static final CultivationProduceVanilla GLOW_BERRY = new CultivationProduceVanilla(Material.GLOW_BERRIES)
        .setBlendable(true)
        .createByProducts();

    public static final CultivationProduceVanilla BEETROOT = new CultivationProduceVanilla(Material.BEETROOT)
        .setBlendable(true)
        .createByProducts();

    public static final CultivationProduceVanilla GOLDEN_APPLE = new CultivationProduceVanilla(Material.GOLDEN_APPLE)
        .setBlendable(true)
        .createByProducts();

    public static final CultivationProduceVanilla NOTCH_APPLE = new CultivationProduceVanilla(Material.ENCHANTED_GOLDEN_APPLE)
        .setBlendable(true)
        .createByProducts();

    public static final CultivationProduceVanilla CARROT = new CultivationProduceVanilla(Material.CARROT)
        .setBakeable(true)
        .setChoppable(true)
        .setBlendable(true)
        .createByProducts();

    // endregion

    public static void setup(Cultivation addon) {
        GRAPE.register(addon);
        STRAWBERRY.register(addon);
        PEANUT.register(addon);
        BANANA.register(addon);
        ORANGE.register(addon);
        GREEN_APPLE.register(addon);
        RICE.register(addon);
        GARLIC.register(addon);
        CAYENNE_PEPPER.register(addon);
    }
}
