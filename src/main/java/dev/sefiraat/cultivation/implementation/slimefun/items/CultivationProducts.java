package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.api.slimefun.items.produce.CultivationProduce;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
import org.bukkit.inventory.ItemStack;

public final class CultivationProducts {

    private CultivationProducts() {
        throw new IllegalStateException("Utility class");
    }

    public static void setup(Cultivation addon) {

        new CultivationProduce(
            CultivationGroups.PRODUCE,
            CultivationStacks.PRODUCE_BANANA,
            RecipeTypes.TREE_HARVEST,
            new ItemStack[0]
        )
            .setCanBlend(true)
            .setCanSlice(true)
            .setCanMash(true)
            .setCanChop(true)
            .setCanBake(true)
            .setCanFry(true)
            .setCanGrill(true)
            .register(addon);

        new CultivationProduce(
            CultivationGroups.PRODUCE,
            CultivationStacks.PRODUCE_ORANGE,
            RecipeTypes.TREE_HARVEST,
            new ItemStack[0]
        )
            .setCanBlend(true)
            .setCanSlice(true)
            .register(addon);

        new CultivationProduce(
            CultivationGroups.PRODUCE,
            CultivationStacks.PRODUCE_GREEN_APPLE,
            RecipeTypes.TREE_HARVEST,
            new ItemStack[0]
        )
            .setCanBlend(true)
            .setCanSlice(true)
            .setCanBake(true)
            .register(addon);
    }
}
