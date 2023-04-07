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

    public static void setup(Cultivation addon) {
        new CultivationProduce(CultivationGroups.PRODUCE, CultivationStacks.PRODUCE_GRAPE, RecipeTypes.BUSH)
            .setBlendable(true)
            .register(addon);

        new CultivationProduce(CultivationGroups.PRODUCE, CultivationStacks.PRODUCE_BANANA, RecipeTypes.TREE)
            .setBlendable(true)
            .setSliceable(true)
            .setMashable(true)
            .setCoppable(true)
            .setBakeable(true)
            .setFryable(true)
            .setGrillable(true)
            .register(addon);

        new CultivationProduce(CultivationGroups.PRODUCE, CultivationStacks.PRODUCE_ORANGE, RecipeTypes.TREE)
            .setBlendable(true)
            .setSliceable(true)
            .register(addon);

        new CultivationProduce(CultivationGroups.PRODUCE, CultivationStacks.PRODUCE_GREEN_APPLE, RecipeTypes.TREE)
            .setBlendable(true)
            .setSliceable(true)
            .setBakeable(true)
            .register(addon);
    }
}
