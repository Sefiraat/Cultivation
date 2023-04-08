package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.api.slimefun.items.produce.CultivationProduce;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;

public final class CultivationProducts {

    private CultivationProducts() {
        throw new IllegalStateException("Utility class");
    }

    public static final CultivationProduce GRAPE = new CultivationProduce(
        CultivationGroups.PRODUCE,
        CultivationStacks.GRAPE,
        RecipeTypes.BUSH
    )
        .setBlendable(true);

    public static final CultivationProduce STRAWBERRY = new CultivationProduce(
        CultivationGroups.PRODUCE,
        CultivationStacks.STRAWBERRY,
        RecipeTypes.BUSH
    )
        .setBlendable(true)
        .setSliceable(true);

    public static final CultivationProduce PEANUT = new CultivationProduce(
        CultivationGroups.PRODUCE,
        CultivationStacks.PEANUT,
        RecipeTypes.BUSH
    )
        .setBlendable(true);

    public static final CultivationProduce BANANA = new CultivationProduce(
        CultivationGroups.PRODUCE,
        CultivationStacks.PRODUCE_BANANA,
        RecipeTypes.TREE
    )
        .setBlendable(true)
        .setSliceable(true)
        .setMashable(true)
        .setCoppable(true)
        .setBakeable(true)
        .setFryable(true)
        .setGrillable(true);

    public static final CultivationProduce ORANGE = new CultivationProduce(
        CultivationGroups.PRODUCE,
        CultivationStacks.PRODUCE_ORANGE,
        RecipeTypes.TREE
    )
        .setBlendable(true)
        .setSliceable(true);

    public static final CultivationProduce GREEN_APPLE = new CultivationProduce(
        CultivationGroups.PRODUCE,
        CultivationStacks.PRODUCE_GREEN_APPLE,
        RecipeTypes.TREE
    )
        .setBlendable(true)
        .setSliceable(true)
        .setBakeable(true);



    public static void setup(Cultivation addon) {
        GRAPE.register(addon);
        STRAWBERRY.register(addon);
        PEANUT.register(addon);
        BANANA.register(addon);
        ORANGE.register(addon);
        GREEN_APPLE.register(addon);
    }
}
