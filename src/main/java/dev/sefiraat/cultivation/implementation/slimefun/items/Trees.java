package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.api.slimefun.items.trees.CultivationTree;
import dev.sefiraat.cultivation.api.utils.Skins;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;

public final class Trees {

    private Trees() {
        throw new IllegalStateException("Utility class");
    }

    public static final CultivationTree TREE_GREEN_APPLE = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_GREEN_APPLE,
        "tree_1",
        Products.GREEN_APPLE,
        Skins.GREEN_APPLE
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationTree TREE_BANANA = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_BANANA,
        "tree_2",
        Products.BANANA,
        Skins.BANANA
    ).buildRegister(Cultivation.getInstance());

    public static void setup(Cultivation addon) {

    }
}
