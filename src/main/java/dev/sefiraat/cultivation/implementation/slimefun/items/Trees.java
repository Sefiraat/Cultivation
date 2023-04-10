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

    public static final CultivationTree TREE_BANANA = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_BANANA,
        "tree_1",
        Products.BANANA,
        Skins.BANANA
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationTree TREE_LEMON = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_LEMON,
        "tree_2",
        Products.LEMON,
        Skins.LEMON
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationTree TREE_ORANGE = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_ORANGE,
        "tree_3",
        Products.ORANGE,
        Skins.ORANGE
    ).buildRegister(Cultivation.getInstance());
    
    public static final CultivationTree TREE_GREEN_APPLE = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_GREEN_APPLE,
        "tree_4",
        Products.GREEN_APPLE,
        Skins.GREEN_APPLE
    ).buildRegister(Cultivation.getInstance());
    
    public static final CultivationTree TREE_PINEAPPLE = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_PINEAPPLE,
        "tree_5",
        Products.PINEAPPLE,
        Skins.PINEAPPLE
    ).buildRegister(Cultivation.getInstance());
    
    public static final CultivationTree TREE_MANGO = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_MANGO,
        "tree_6",
        Products.MANGO,
        Skins.MANGO
    ).buildRegister(Cultivation.getInstance());
    
    public static final CultivationTree TREE_PEACH = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_PEACH,
        "tree_1",
        Products.PEACH,
        Skins.PEACH
    ).buildRegister(Cultivation.getInstance());
    
    public static final CultivationTree TREE_APRICOT = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_APRICOT,
        "tree_2",
        Products.APRICOT,
        Skins.APRICOT
    ).buildRegister(Cultivation.getInstance());
    
    public static final CultivationTree TREE_PEAR = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_PEAR,
        "tree_3",
        Products.PEAR,
        Skins.PEAR
    ).buildRegister(Cultivation.getInstance());
    
    public static final CultivationTree TREE_CHERRY = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_CHERRY,
        "tree_4",
        Products.CHERRY,
        Skins.CHERRY
    ).buildRegister(Cultivation.getInstance());
    
    public static final CultivationTree TREE_KIWI = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_KIWI,
        "tree_5",
        Products.KIWI,
        Skins.KIWI
    ).buildRegister(Cultivation.getInstance());

    public static void setup(Cultivation addon) {

    }
}
