package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.api.slimefun.items.trees.CultivationTree;
import dev.sefiraat.cultivation.api.slimefun.items.trees.TreeDesign;
import dev.sefiraat.cultivation.api.utils.Skins;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;

public final class Trees {

    private Trees() {
        throw new IllegalStateException("Utility class");
    }

    public static final CultivationTree TREE_BANANA = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_BANANA,
        TreeDesign.BASIC_1,
        Products.BANANA,
        Skins.BANANA
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationTree TREE_LEMON = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_LEMON,
        TreeDesign.BASIC_2,
        Products.LEMON,
        Skins.LEMON
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationTree TREE_ORANGE = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_ORANGE,
        TreeDesign.BASIC_3,
        Products.ORANGE,
        Skins.ORANGE
    ).buildRegister(Cultivation.getInstance());
    
    public static final CultivationTree TREE_GREEN_APPLE = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_GREEN_APPLE,
        TreeDesign.ACACIA_1,
        Products.GREEN_APPLE,
        Skins.GREEN_APPLE
    ).buildRegister(Cultivation.getInstance());
    
    public static final CultivationTree TREE_PINEAPPLE = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_PINEAPPLE,
        TreeDesign.OAK_2,
        Products.PINEAPPLE,
        Skins.PINEAPPLE
    ).buildRegister(Cultivation.getInstance());
    
    public static final CultivationTree TREE_MANGO = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_MANGO,
        TreeDesign.BIRCH_1,
        Products.MANGO,
        Skins.MANGO
    ).buildRegister(Cultivation.getInstance());
    
    public static final CultivationTree TREE_PEACH = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_PEACH,
        TreeDesign.BIRCH_2,
        Products.PEACH,
        Skins.PEACH
    ).buildRegister(Cultivation.getInstance());
    
    public static final CultivationTree TREE_APRICOT = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_APRICOT,
        TreeDesign.DARK_OAK_1,
        Products.APRICOT,
        Skins.APRICOT
    ).buildRegister(Cultivation.getInstance());
    
    public static final CultivationTree TREE_PEAR = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_PEAR,
        TreeDesign.DARK_OAK_2,
        Products.PEAR,
        Skins.PEAR
    ).buildRegister(Cultivation.getInstance());
    
    public static final CultivationTree TREE_CHERRY = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_CHERRY,
        TreeDesign.CHERRY_1,
        Products.CHERRY,
        Skins.CHERRY
    ).buildRegister(Cultivation.getInstance());
    
    public static final CultivationTree TREE_KIWI = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_KIWI,
        TreeDesign.JUNGLE_1,
        Products.KIWI,
        Skins.KIWI
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationTree TREE_LIME = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_LIME,
        TreeDesign.OAK_2,
        Products.LIME,
        Skins.LIME
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationTree TREE_CHESTNUT = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_CHESTNUT,
        TreeDesign.OAK_2,
        Products.CHESTNUT,
        Skins.CHESTNUT
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationTree TREE_HAZELNUT = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_HAZELNUT,
        TreeDesign.JUNGLE_1,
        Products.HAZELNUT,
        Skins.HAZELNUT
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationTree TREE_PECAN = new CultivationTree(
        CultivationGroups.TREES,
        CultivationStacks.TREE_PECAN,
        TreeDesign.DARK_OAK_2,
        Products.PECAN,
        Skins.PECAN
    ).buildRegister(Cultivation.getInstance());

    public static void setup(Cultivation addon) {

    }
}
