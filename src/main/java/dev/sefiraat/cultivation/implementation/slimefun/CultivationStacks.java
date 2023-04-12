package dev.sefiraat.cultivation.implementation.slimefun;

import dev.sefiraat.cultivation.api.utils.CultivationThemes;
import dev.sefiraat.cultivation.api.utils.Skins;
import dev.sefiraat.sefilib.itemstacks.ItemStackGenerators;
import dev.sefiraat.sefilib.string.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.collections.Pair;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public final class CultivationStacks {

    private CultivationStacks() {
        throw new IllegalStateException("Utility class");
    }

    // region Crafting Materials

    public static final SlimefunItemStack MYSTICAL_LOG = Theme.themedSlimefunItemStack(
        "CLT_MYSTICAL_WOOD",
        ItemStackGenerators.createEnchantedItemStack(
            Material.OAK_LOG,
            true,
            new Pair<>(Enchantment.ARROW_DAMAGE, 1)
        ),
        CultivationThemes.TOOL,
        "Mystical Log",
        "This seemingly simple log it brimming",
        "with an unknown power"
    );

    // endregion

    // region Trees

    public static final SlimefunItemStack TREE_BANANA = Theme.themedSlimefunItemStack(
        "CLT_TREE_BANANA",
        new ItemStack(Material.ACACIA_SAPLING),
        CultivationThemes.SAPLING,
        "Cultivation Tree: Banana",
        List.of(
            "A tree that grows fingers, grim!"
        )
    );

    public static final SlimefunItemStack TREE_LEMON = Theme.themedSlimefunItemStack(
        "CLT_TREE_LEMON",
        new ItemStack(Material.ACACIA_SAPLING),
        CultivationThemes.SAPLING,
        "Cultivation Tree: Lemon",
        List.of(
            "Just looking at this tree taste sour."
        )
    );

    public static final SlimefunItemStack TREE_ORANGE = Theme.themedSlimefunItemStack(
        "CLT_TREE_ORANGE",
        new ItemStack(Material.JUNGLE_SAPLING),
        CultivationThemes.SAPLING,
        "Cultivation Tree: Orange",
        List.of(
            "Little orbs of sunshine."
        )
    );

    public static final SlimefunItemStack TREE_GREEN_APPLE = Theme.themedSlimefunItemStack(
        "CLT_TREE_GREEN_APPLE",
        new ItemStack(Material.BIRCH_SAPLING),
        CultivationThemes.SAPLING,
        "Cultivation Tree: Green Apple",
        List.of(
            "Grows large and crisp green apples."
        )
    );

    public static final SlimefunItemStack TREE_PINEAPPLE = Theme.themedSlimefunItemStack(
        "CLT_TREE_PINEAPPLE",
        new ItemStack(Material.JUNGLE_SAPLING),
        CultivationThemes.SAPLING,
        "Cultivation Tree: Pineapple",
        List.of(
            "WHERE IS MY PIZZA?"
        )
    );

    public static final SlimefunItemStack TREE_MANGO = Theme.themedSlimefunItemStack(
        "CLT_TREE_MANGO",
        new ItemStack(Material.OAK_SAPLING),
        CultivationThemes.SAPLING,
        "Cultivation Tree: Mango",
        List.of(
            "Best when at it's ripest."
        )
    );

    public static final SlimefunItemStack TREE_PEACH = Theme.themedSlimefunItemStack(
        "CLT_TREE_PEACH",
        new ItemStack(Material.BIRCH_SAPLING),
        CultivationThemes.SAPLING,
        "Cultivation Tree: Peach",
        List.of(
            "James was looking for this, I think?"
        )
    );

    public static final SlimefunItemStack TREE_APRICOT = Theme.themedSlimefunItemStack(
        "CLT_TREE_APRICOT",
        new ItemStack(Material.BIRCH_SAPLING),
        CultivationThemes.SAPLING,
        "Cultivation Tree: Apricot",
        List.of(
            "Inside is a single pit of despair."
        )
    );

    public static final SlimefunItemStack TREE_PEAR = Theme.themedSlimefunItemStack(
        "CLT_TREE_PEAR",
        new ItemStack(Material.ACACIA_SAPLING),
        CultivationThemes.SAPLING,
        "Cultivation Tree: Pear",
        List.of(
            "A Pair of Pears were paired for parity."
        )
    );

    public static final SlimefunItemStack TREE_CHERRY = Theme.themedSlimefunItemStack(
        "CLT_TREE_CHERRY",
        new ItemStack(Material.OAK_SAPLING),
        CultivationThemes.SAPLING,
        "Cultivation Tree: Cherry",
        List.of(
            "Tie the knot!"
        )
    );

    public static final SlimefunItemStack TREE_KIWI = Theme.themedSlimefunItemStack(
        "CLT_TREE_KIWI",
        new ItemStack(Material.BIRCH_SAPLING),
        CultivationThemes.SAPLING,
        "Cultivation Tree: Kiwi",
        List.of(
            "A New Zealand Tree? Have I got that right?"
        )
    );

    public static final SlimefunItemStack TREE_LIME = Theme.themedSlimefunItemStack(
        "CLT_TREE_LIME",
        new ItemStack(Material.JUNGLE_SAPLING),
        CultivationThemes.SAPLING,
        "Cultivation Tree: Lime",
        List.of(
            "Did you know Limes are just Lemons holding their breath?"
        )
    );

    public static final SlimefunItemStack TREE_CHESTNUT = Theme.themedSlimefunItemStack(
        "CLT_TREE_CHESTNUT",
        new ItemStack(Material.OAK_SAPLING),
        CultivationThemes.SAPLING,
        "Cultivation Tree: Chestnut",
        List.of(
            "A tree clearly designed to be climbed."
        )
    );

    public static final SlimefunItemStack TREE_HAZELNUT = Theme.themedSlimefunItemStack(
        "CLT_TREE_HAZELNUT",
        new ItemStack(Material.OAK_SAPLING),
        CultivationThemes.SAPLING,
        "Cultivation Tree: Hazelnut",
        List.of(
            "Shaking this tree is a childhood past-time."
        )
    );

    // endregion

    // region Bushes

    public static final SlimefunItemStack BUSH_GRAPE = Theme.themedSlimefunItemStack(
        "CLT_BUSH_GRAPE",
        Skins.SPIKEY_PURPLE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Grape",
        List.of(
            "Ripe and juicy grapes that practically fall",
            "off the bush."
        )
    );

    public static final SlimefunItemStack BUSH_PEANUTS = Theme.themedSlimefunItemStack(
        "CLT_BUSH_PEANUTS",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Peanuts",
        List.of(
            "Solid and fragrant and full of protein."
        )
    );

    public static final SlimefunItemStack BUSH_STRAWBERRY = Theme.themedSlimefunItemStack(
        "CLT_BUSH_STRAWBERRY",
        Skins.SPIKEY_RED_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Strawberry",
        List.of(
            "Solid and fragrant and full of protein."
        )
    );

    public static final SlimefunItemStack BUSH_RICE = Theme.themedSlimefunItemStack(
        "CLT_BUSH_RICE",
        Skins.SPIKEY_YELLOW_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Rice",
        List.of(
            "The ultimate staple food."
        )
    );

    public static final SlimefunItemStack BUSH_GARLIC = Theme.themedSlimefunItemStack(
        "CLT_BUSH_GARLIC",
        Skins.SPIKEY_YELLOW_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Garlic",
        List.of(
            "This bush has simply the worst breath."
        )
    );

    public static final SlimefunItemStack BUSH_CAYENNE_PEPPER = Theme.themedSlimefunItemStack(
        "CLT_BUSH_CAYENNE_PEPPER",
        Skins.SPIKEY_RED_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Cayenne Pepper",
        List.of(
            "A bush with a peppery attitude."
        )
    );

    public static final SlimefunItemStack BUSH_TOMATO = Theme.themedSlimefunItemStack(
        "CLT_BUSH_TOMATO",
        Skins.SPIKEY_RED_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Tomato",
        List.of(
            "Ripe and ready."
        )
    );

    public static final SlimefunItemStack BUSH_BELL_PEPPER = Theme.themedSlimefunItemStack(
        "CLT_BUSH_BELL_PEPPER",
        Skins.SPIKEY_RED_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Bell Pepper",
        List.of(
            "Careful walking by this, you may ring",
            "the bell."
        )
    );

    public static final SlimefunItemStack BUSH_ONION = Theme.themedSlimefunItemStack(
        "CLT_BUSH_ONION",
        Skins.SPIKEY_YELLOW_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Onion",
        List.of(
            "Does this bush look like it's tearing up?"
        )
    );

    public static final SlimefunItemStack BUSH_PEA = Theme.themedSlimefunItemStack(
        "CLT_BUSH_PEA",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Peas",
        List.of(
            "I prefer Q's"
        )
    );

    public static final SlimefunItemStack BUSH_RAPESEED = Theme.themedSlimefunItemStack(
        "CLT_BUSH_RAPESEED",
        Skins.SPIKEY_BLUE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Rapeseed",
        List.of(
            "This bush is exuding some oily substance."
        )
    );

    public static final SlimefunItemStack BUSH_LETTUCE = Theme.themedSlimefunItemStack(
        "CLT_BUSH_LETTUCE",
        Skins.SPIKEY_GREEN_4.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Lettuce",
        List.of(
            "Does lettuce even grow on bushes?",
            "Spoiler: No, it doesn't."
        )
    );

    public static final SlimefunItemStack BUSH_MUSTARD = Theme.themedSlimefunItemStack(
        "CLT_BUSH_MUSTARD",
        Skins.SPIKEY_YELLOW_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Mustard Seeds",
        List.of(
            "Like fire in your mouth."
        )
    );

    public static final SlimefunItemStack BUSH_BROCCOLI = Theme.themedSlimefunItemStack(
        "CLT_BUSH_BROCCOLI",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Broccoli",
        List.of(
            "Tiny trees you can eat? Who invented this!?"
        )
    );

    public static final SlimefunItemStack BUSH_CINNAMON = Theme.themedSlimefunItemStack(
        "CLT_BUSH_CINNAMON",
        Skins.SPIKEY_ORANGE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Cinnamon",
        List.of(
            "A delightfully fragrant bush."
        )
    );

    public static final SlimefunItemStack BUSH_BASIL = Theme.themedSlimefunItemStack(
        "CLT_BUSH_BASIL",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Basil",
        List.of(
            "A light hearted bush full of whimsy."
        )
    );

    public static final SlimefunItemStack BUSH_BAY_LEAF = Theme.themedSlimefunItemStack(
        "CLT_BUSH_BAY_LEAF",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Bay Leaf",
        List.of(
            "The smell of this bush travels for miles."
        )
    );

    public static final SlimefunItemStack BUSH_CILANTRO = Theme.themedSlimefunItemStack(
        "CLT_BUSH_CILANTRO",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Cilantro",
        List.of(
            "A faint citrus and spice smell comes from this bush."
        )
    );

    public static final SlimefunItemStack BUSH_CHICORY = Theme.themedSlimefunItemStack(
        "CLT_BUSH_CHICORY",
        Skins.SPIKEY_BLUE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Chicory",
        List.of(
            "I thought chicory was a root? Does this addon",
            "even do it's research!?"
        )
    );

    public static final SlimefunItemStack BUSH_CHIVES = Theme.themedSlimefunItemStack(
        "CLT_BUSH_CHIVES",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Chives",
        List.of(
            "A bush that produces what is, effectively, the world's",
            "smallest onion."
        )
    );

    public static final SlimefunItemStack BUSH_CLOVE = Theme.themedSlimefunItemStack(
        "CLT_BUSH_CLOVE",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Clove",
        List.of(
            "A bush that just reminds me of Christmas."
        )
    );

    public static final SlimefunItemStack BUSH_CUMIN = Theme.themedSlimefunItemStack(
        "CLT_BUSH_CUMIN",
        Skins.SPIKEY_YELLOW_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Cumin",
        List.of(
            "A bush that lets of a warm citrus aroma."
        )
    );

    public static final SlimefunItemStack BUSH_CHILLI_PEPPER = Theme.themedSlimefunItemStack(
        "CLT_BUSH_CHILLI_PEPPER",
        Skins.SPIKEY_RED_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Chilli Pepper",
        List.of(
            "Just looking at this bush burns my tongue."
        )
    );

    public static final SlimefunItemStack BUSH_CURRY_LEAF = Theme.themedSlimefunItemStack(
        "CLT_BUSH_CURRY_LEAF",
        Skins.SPIKEY_RED_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Curry Leaf",
        List.of(
            "Best when dry roasted."
        )
    );

    public static final SlimefunItemStack BUSH_DILL = Theme.themedSlimefunItemStack(
        "CLT_BUSH_DILL",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Dill",
        List.of(
            "This bush grows much faster than others."
        )
    );

    public static final SlimefunItemStack BUSH_FENNEL = Theme.themedSlimefunItemStack(
        "CLT_BUSH_FENNEL",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Fennel",
        List.of(
            "Why does this bush repel bugs!?"
        )
    );

    public static final SlimefunItemStack BUSH_GINGER = Theme.themedSlimefunItemStack(
        "CLT_BUSH_GINGER",
        Skins.SPIKEY_YELLOW_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Ginger",
        List.of(
            "This bush is nice when boiled whole."
        )
    );

    public static final SlimefunItemStack BUSH_HORSERADISH = Theme.themedSlimefunItemStack(
        "CLT_BUSH_HORSERADISH",
        Skins.SPIKEY_YELLOW_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Horseradish",
        List.of(
            "Again, this growing on a bush just doesn't make sense."
        )
    );

    public static final SlimefunItemStack BUSH_JASMINE = Theme.themedSlimefunItemStack(
        "CLT_BUSH_JASMINE",
        Skins.SPIKEY_YELLOW_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Jasmine",
        List.of(
            "The scent from this bush is so soft and mellow."
        )
    );

    public static final SlimefunItemStack BUSH_JUNIPER_BERRY = Theme.themedSlimefunItemStack(
        "CLT_BUSH_JUNIPER_BERRY",
        Skins.SPIKEY_BLUE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Juniper Berry",
        List.of(
            "So sweet on the bush, peppery when dried."
        )
    );

    public static final SlimefunItemStack BUSH_KAFFIR_LIME = Theme.themedSlimefunItemStack(
        "CLT_BUSH_KAFFIR_LIME",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Kaffir Lime",
        List.of(
            "A bush whose leafs are more wanted than it's fruit."
        )
    );

    public static final SlimefunItemStack BUSH_LAVENDER = Theme.themedSlimefunItemStack(
        "CLT_BUSH_LAVENDER",
        Skins.SPIKEY_PURPLE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Lavender",
        List.of(
            "This bush wafts it's smell everywhere."
        )
    );

    public static final SlimefunItemStack BUSH_LICORICE = Theme.themedSlimefunItemStack(
        "CLT_BUSH_LICORICE",
        Skins.SPIKEY_YELLOW_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Licorice",
        List.of(
            "Gross"
        )
    );

    public static final SlimefunItemStack BUSH_MACE = Theme.themedSlimefunItemStack(
        "CLT_BUSH_MACE",
        Skins.SPIKEY_PURPLE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Mace",
        List.of(
            "This bush seems to be repelling attackers?"
        )
    );

    public static final SlimefunItemStack BUSH_MARJORAM = Theme.themedSlimefunItemStack(
        "CLT_BUSH_MARJORAM",
        Skins.SPIKEY_YELLOW_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Marjoram",
        List.of(
            "A large woody smelling bush."
        )
    );

    public static final SlimefunItemStack BUSH_MINT = Theme.themedSlimefunItemStack(
        "CLT_BUSH_MINT",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Mint",
        List.of(
            "Simply the best smelling bush."
        )
    );

    public static final SlimefunItemStack BUSH_OREGANO = Theme.themedSlimefunItemStack(
        "CLT_BUSH_OREGANO",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Oregano",
        List.of(
            "This pungent smelling bush deters visitors."
        )
    );

    public static final SlimefunItemStack BUSH_PARSLEY = Theme.themedSlimefunItemStack(
        "CLT_BUSH_PARSLEY",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Parsley",
        List.of(
            "Throw this bush in lava, now :D"
        )
    );

    public static final SlimefunItemStack BUSH_ROSEMARY = Theme.themedSlimefunItemStack(
        "CLT_BUSH_ROSEMARY",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Rosemary",
        List.of(
            "A bush whose smell reminds people of sunday lunches."
        )
    );

    public static final SlimefunItemStack BUSH_SASSAFRAS = Theme.themedSlimefunItemStack(
        "CLT_BUSH_SASSAFRAS",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Sassafras",
        List.of(
            "This bush love to be planted near small bodies",
            "of water."
        )
    );

    public static final SlimefunItemStack BUSH_SHISO = Theme.themedSlimefunItemStack(
        "CLT_BUSH_SHISO",
        Skins.SPIKEY_PURPLE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Shiso",
        List.of(
            "I like to think this bush is the love child",
            "of a mint bush and a basil bush. Too bad",
            "bush breeding isn't a thing!"
        )
    );

    public static final SlimefunItemStack BUSH_STAR_ANISE = Theme.themedSlimefunItemStack(
        "CLT_BUSH_STAR_ANISE",
        Skins.SPIKEY_ORANGE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Star Anise",
        List.of(
            "A small comes off this bush that is so unique",
            "to anise, you can't even believe."
        )
    );

    public static final SlimefunItemStack BUSH_TARRAGON = Theme.themedSlimefunItemStack(
        "CLT_BUSH_TARRAGON",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Tarragon",
        List.of(
            "This bush doesn't like to draw too much attention."
        )
    );

    public static final SlimefunItemStack BUSH_THYME = Theme.themedSlimefunItemStack(
        "CLT_BUSH_THYME",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Thyme",
        List.of(
            "This bush is always running out of... Thyme... *cough*"
        )
    );

    public static final SlimefunItemStack BUSH_TURMERIC = Theme.themedSlimefunItemStack(
        "CLT_BUSH_TURMERIC",
        Skins.SPIKEY_YELLOW_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Turmeric",
        List.of(
            "A waft of spice hits your nose just",
            "holding this bush."
        )
    );

    public static final SlimefunItemStack BUSH_VANILLA = Theme.themedSlimefunItemStack(
        "CLT_BUSH_VANILLA",
        Skins.SPIKEY_YELLOW_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Vanilla",
        List.of(
            "This bush grows natively near StarBucks locations."
        )
    );

    public static final SlimefunItemStack BUSH_WASABI = Theme.themedSlimefunItemStack(
        "CLT_BUSH_WASABI",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Wasabi",
        List.of(
            "Another root growing off of a bush?",
            "Sigh..."
        )
    );

    public static final SlimefunItemStack BUSH_ARTICHOKE = Theme.themedSlimefunItemStack(
        "CLT_BUSH_ARTICHOKE",
        Skins.SPIKEY_YELLOW_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Artichoke",
        List.of(
            "By far the best bush to strangle an",
            "artist with. Sigh. Puns be hard."
        )
    );

    public static final SlimefunItemStack BUSH_AUBERGINE = Theme.themedSlimefunItemStack(
        "CLT_BUSH_AUBERGINE",
        Skins.SPIKEY_PURPLE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Aubergine",
        List.of(
            "I refuse to use the word eggplant. I just do."
        )
    );

    public static final SlimefunItemStack BUSH_ASPARAGUS = Theme.themedSlimefunItemStack(
        "CLT_BUSH_ASPARAGUS",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Asparagus",
        List.of(
            "This asparagus bush makes a good",
            "stalker!"
        )
    );

    public static final SlimefunItemStack BUSH_BRUSSELS_SPROUTS = Theme.themedSlimefunItemStack(
        "CLT_BUSH_BRUSSELS_SPROUTS",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Brussels Sprouts",
        List.of(
            "A bush that can sometimes produce noxious",
            "gas."
        )
    );

    public static final SlimefunItemStack BUSH_CABBAGE = Theme.themedSlimefunItemStack(
        "CLT_BUSH_CABBAGE",
        Skins.SPIKEY_PURPLE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Cabbage",
        List.of(
            "A bush that comes with a large amount of",
            "emotional cabbage."
        )
    );

    public static final SlimefunItemStack BUSH_CAULIFLOWER = Theme.themedSlimefunItemStack(
        "CLT_BUSH_CAULIFLOWER",
        Skins.SPIKEY_YELLOW_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Cauliflower",
        List.of(
            "A bush capable of producing little clouds",
            "of delight."
        )
    );

    public static final SlimefunItemStack BUSH_CELERY = Theme.themedSlimefunItemStack(
        "CLT_BUSH_CELERY",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Celery",
        List.of(
            "This bush is redundant.",
            "Sefi doesn't like Celery."
        )
    );

    public static final SlimefunItemStack BUSH_KALE = Theme.themedSlimefunItemStack(
        "CLT_BUSH_KALE",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Kale",
        List.of(
            "When you plant this bush, you get the feeling",
            "that everything is going to be o-kale."
        )
    );

    public static final SlimefunItemStack BUSH_SPINACH = Theme.themedSlimefunItemStack(
        "CLT_BUSH_SPINACH",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Spinach",
        List.of(
            "This bush is Popeye's best friend."
        )
    );

    public static final SlimefunItemStack BUSH_BLACK_BEANS = Theme.themedSlimefunItemStack(
        "CLT_BUSH_BLACK_BEANS",
        Skins.SPIKEY_PURPLE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Black Beans",
        List.of(
            "This bush gently whispers to you:",
            "You are a great human bean."
        )
    );

    public static final SlimefunItemStack BUSH_GREEN_BEANS = Theme.themedSlimefunItemStack(
        "CLT_BUSH_GREEN_BEANS",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Green Beans",
        List.of(
            "Throw tomato sauce over this bush to make",
            "baked beans."
        )
    );

    public static final SlimefunItemStack BUSH_CHICKPEAS = Theme.themedSlimefunItemStack(
        "CLT_BUSH_CHICKPEAS",
        Skins.SPIKEY_ORANGE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Chickpeas",
        List.of(
            "A bush made by breeding a chicken with",
            "a pea. SCIENCE."
        )
    );

    public static final SlimefunItemStack BUSH_SOY_BEANS = Theme.themedSlimefunItemStack(
        "CLT_BUSH_SOY_BEANS",
        Skins.SPIKEY_YELLOW_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Soy Beans",
        List.of(
            "This bush is a friendly delight. It makes",
            "me soy happy."
        )
    );

    public static final SlimefunItemStack BUSH_PINTO_BEANS = Theme.themedSlimefunItemStack(
        "CLT_BUSH_PINTO_BEANS",
        Skins.SPIKEY_PURPLE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Pinto Beans",
        List.of(
            "It wont be long until we successfully breed",
            "a direct-burrito bush, right?"
        )
    );

    public static final SlimefunItemStack BUSH_RUNNER_BEANS = Theme.themedSlimefunItemStack(
        "CLT_BUSH_RUNNER_BEANS",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Runner Beans",
        List.of(
            "This bush has feet o.o?"
        )
    );

    public static final SlimefunItemStack BUSH_NETTLES = Theme.themedSlimefunItemStack(
        "CLT_BUSH_NETTLES",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Nettles",
        List.of(
            "Be careful when walking through this bush!"
        )
    );

    public static final SlimefunItemStack BUSH_OKRA = Theme.themedSlimefunItemStack(
        "CLT_BUSH_OKRA",
        Skins.SPIKEY_PURPLE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Okra",
        List.of(
            "Voted the number 1 vegetable according to",
            "Okra Winfrey's Vegetable Club."
        )
    );

    public static final SlimefunItemStack BUSH_LEEK = Theme.themedSlimefunItemStack(
        "CLT_BUSH_LEEK",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Leek",
        List.of(
            "Did you know a leek is just an onion that",
            "wears a corset? True story."
        )
    );

    public static final SlimefunItemStack BUSH_SHALLOT = Theme.themedSlimefunItemStack(
        "CLT_BUSH_SHALLOT",
        Skins.SPIKEY_PURPLE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Shallot",
        List.of(
            "This bush rapidly produces lovely mini onions.",
            "Luckily you don't need a shallot."
        )
    );

    public static final SlimefunItemStack BUSH_JALAPENO = Theme.themedSlimefunItemStack(
        "CLT_BUSH_JALAPENO",
        Skins.SPIKEY_RED_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Jalapeno",
        List.of(
            "Just holding this bush gives you a",
            "1% change to set ablaze."
        )
    );

    public static final SlimefunItemStack BUSH_RADICCHIO = Theme.themedSlimefunItemStack(
        "CLT_BUSH_RADICCHIO",
        Skins.SPIKEY_PURPLE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Radicchio",
        List.of(
            "Want to sound fancy? But Radicchio into any",
            "meal - it's basically like cabbage but",
            "makes you seem refined."
        )
    );

    public static final SlimefunItemStack BUSH_RHUBARB = Theme.themedSlimefunItemStack(
        "CLT_BUSH_RHUBARB",
        Skins.SPIKEY_PURPLE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Rhubarb",
        List.of(
            "Did you know rhubarb was a vegetable?",
            "I thought it was a type of hammer."
        )
    );

    public static final SlimefunItemStack BUSH_CELERIAC = Theme.themedSlimefunItemStack(
        "CLT_BUSH_CELERIAC",
        Skins.SPIKEY_ORANGE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Celeriac",
        List.of(
            "Yet another root growing off of a bush?",
            "SefiDumb™"
        )
    );

    public static final SlimefunItemStack BUSH_PARSNIP = Theme.themedSlimefunItemStack(
        "CLT_BUSH_PARSNIP",
        Skins.SPIKEY_YELLOW_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Parsnip",
        List.of(
            "Just skip the middleman and roast the bush",
            "directly."
        )
    );

    public static final SlimefunItemStack BUSH_RUTABAGA = Theme.themedSlimefunItemStack(
        "CLT_BUSH_RUTABAGA",
        Skins.SPIKEY_PURPLE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Rutabaga",
        List.of(
            "Swede. Its a swede."
        )
    );

    public static final SlimefunItemStack BUSH_RADDISH = Theme.themedSlimefunItemStack(
        "CLT_BUSH_RADDISH",
        Skins.SPIKEY_RED_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Raddish",
        List.of(
            "This plant just did a skateboarding trick.",
            "Totally Rad...ish."
        )
    );

    public static final SlimefunItemStack BUSH_SWEET_POTATO = Theme.themedSlimefunItemStack(
        "CLT_BUSH_SWEET_POTATO",
        Skins.SPIKEY_PURPLE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Sweet Potato",
        List.of(
            "This bush is just so sweet. I heard it",
            "complimenting you while you weren't listening."
        )
    );

    public static final SlimefunItemStack BUSH_TURNIP = Theme.themedSlimefunItemStack(
        "CLT_BUSH_TURNIP",
        Skins.SPIKEY_ORANGE_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Turnip",
        List.of(
            "According to the British Government",
            "this bush will solve all our problems."
        )
    );

    public static final SlimefunItemStack BUSH_SWEETCORN = Theme.themedSlimefunItemStack(
        "CLT_BUSH_SWEETCORN",
        Skins.SPIKEY_YELLOW_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Sweetcorn",
        List.of(
            "This bush is just crying out to be built into",
            "a maze."
        )
    );

    public static final SlimefunItemStack BUSH_COURGETTE = Theme.themedSlimefunItemStack(
        "CLT_BUSH_COURGETTE",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Courgette",
        List.of(
            "Why does this bush just keep shouting the",
            "word Zucchini? I guess it must be american?"
        )
    );

    public static final SlimefunItemStack BUSH_CUCUMBER = Theme.themedSlimefunItemStack(
        "CLT_BUSH_CUCUMBER",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Cucumber",
        List.of(
            "This bush was designed solely for the purposes",
            "of your lovely summer salads."
        )
    );

    public static final SlimefunItemStack BUSH_MARROW = Theme.themedSlimefunItemStack(
        "CLT_BUSH_MARROW",
        Skins.SPIKEY_GREEN_5.getPlayerHead(),
        CultivationThemes.BUSH,
        "Cultivation Bush: Marrow",
        List.of(
            "I'm surprised this bush can hold it's",
            "own weight."
        )
    );

    // endregion

    // region Plants

    public static final SlimefunItemStack PLANT_DARKNESS = Theme.themedSlimefunItemStack(
        "CLT_PLANT_DARKNESS",
        Skins.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Darkness",
        List.of(
            "A plant that seethes in unbridled",
            "rage."
        )
    );

    public static final SlimefunItemStack PLANT_LIGHT = Theme.themedSlimefunItemStack(
        "CLT_PLANT_LIGHT",
        Skins.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Light",
        List.of(
            "A plant that exudes an aura",
            "of pure love."
        )
    );

    public static final SlimefunItemStack PLANT_EARTH = Theme.themedSlimefunItemStack(
        "CLT_PLANT_EARTH",
        Skins.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Earth",
        List.of(
            "A plant that enriches the world",
            "surrounding it."
        )
    );

    public static final SlimefunItemStack PLANT_WATER = Theme.themedSlimefunItemStack(
        "CLT_PLANT_WATER",
        Skins.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Water",
        List.of(
            "A plant that nurtures and provides",
            "life to the surrounding area."
        )
    );

    public static final SlimefunItemStack PLANT_FIRE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_FIRE",
        Skins.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Fire",
        List.of(
            "A plant that both provides the",
            "sources of destruction as well as",
            "rebirth."
        )
    );

    public static final SlimefunItemStack PLANT_AIR = Theme.themedSlimefunItemStack(
        "CLT_PLANT_AIR",
        Skins.SEED_CYAN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Air",
        List.of(
            "A plant that quietly hums with",
            "the melody of the surrounding nature."
        )
    );

    public static final SlimefunItemStack PLANT_POWER = Theme.themedSlimefunItemStack(
        "CLT_PLANT_POWER",
        Skins.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Power",
        List.of(
            "A plant that positively exudes power."
        )
    );

    public static final SlimefunItemStack PLANT_WEALTH = Theme.themedSlimefunItemStack(
        "CLT_PLANT_WEALTH",
        Skins.SEED_ORANGE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Wealth",
        List.of(
            "A plant that just screams exuberant wealth."
        )
    );

    public static final SlimefunItemStack PLANT_SPECTRUM = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SPECTRUM",
        Skins.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Spectrum",
        List.of(
            "A plant that slightly shifts it's color."
        )
    );

    public static final SlimefunItemStack PLANT_DIRT = Theme.themedSlimefunItemStack(
        "CLT_PLANT_DIRT",
        Skins.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Dirt",
        List.of(
            "Dirty on the surface but holding the",
            "building blocks for life itself."
        )
    );

    public static final SlimefunItemStack PLANT_GRASS = Theme.themedSlimefunItemStack(
        "CLT_PLANT_GRASS",
        Skins.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Grass",
        List.of(
            "The burgeoning life bound fourth",
            "from the ground."
        )
    );

    public static final SlimefunItemStack PLANT_FLOWER = Theme.themedSlimefunItemStack(
        "CLT_PLANT_FLOWER",
        Skins.SEED_ORANGE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Flowering",
        List.of(
            "A beautiful cornucopia presented well."
        )
    );

    public static final SlimefunItemStack PLANT_VINE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_VINE",
        Skins.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Vine",
        List.of(
            "A plant that instantly tangles itself",
            "up."
        )
    );

    public static final SlimefunItemStack PLANT_SAND = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SAND",
        Skins.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Sand",
        List.of(
            "This plant can sometimes crumble apart",
            "at a single touch."
        )
    );

    public static final SlimefunItemStack PLANT_RED_SAND = Theme.themedSlimefunItemStack(
        "CLT_PLANT_RED_SAND",
        Skins.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Red Sand",
        List.of(
            "This plant can sometimes crumble apart",
            "at a single touch - but... red-er."
        )
    );

    public static final SlimefunItemStack PLANT_MOSS = Theme.themedSlimefunItemStack(
        "CLT_PLANT_MOSS",
        Skins.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Moss",
        List.of(
            "This plant tends to spread uncontrollably."
        )
    );

    public static final SlimefunItemStack PLANT_SAPLING = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SAPLING",
        Skins.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Sapling",
        List.of(
            "This plant doesn't even make sense..."
        )
    );

    public static final SlimefunItemStack PLANT_MUSHROOM = Theme.themedSlimefunItemStack(
        "CLT_PLANT_MUSHROOM",
        Skins.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Mushroom",
        List.of(
            "Yup, a plant that makes mushrooms.",
            "Everything is totally normal over here."
        )
    );

    public static final SlimefunItemStack PLANT_WITHER_ROSE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_WITHER_ROSE",
        Skins.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Wither Rose",
        List.of(
            "This plant, somehow, pulsates a harmful",
            "aura around itself."
        )
    );

    public static final SlimefunItemStack PLANT_DARK_FLORA = Theme.themedSlimefunItemStack(
        "CLT_PLANT_DARK_FLORA",
        Skins.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Dark Flora",
        List.of(
            "A silent evil sits within this simple seed."
        )
    );

    public static final SlimefunItemStack PLANT_GLOWING_VINE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_GLOWING_VINE",
        Skins.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Glowing Vine",
        List.of(
            "A faint light emits from within this seed."
        )
    );

    public static final SlimefunItemStack PLANT_DIM_LIT = Theme.themedSlimefunItemStack(
        "CLT_PLANT_DIM_LIT",
        Skins.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Dim Lit",
        List.of(
            "A very dim light emits from within this seed."
        )
    );

    public static final SlimefunItemStack PLANT_COW = Theme.themedSlimefunItemStack(
        "CLT_PLANT_COW",
        Skins.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Cow",
        List.of(
            "If you hold this seed up to your ear",
            "and listen very carefully, you can hear",
            "an occasional mooing."
        )
    );

    public static final SlimefunItemStack PLANT_CHICKEN = Theme.themedSlimefunItemStack(
        "CLT_PLANT_CHICKEN",
        Skins.SEED_CYAN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Chicken",
        List.of(
            "Rumour says that if you hold this",
            "seed above your head and jump from a",
            "high place, you will glide rather than",
            "fall."
        )
    );

    public static final SlimefunItemStack PLANT_FISH = Theme.themedSlimefunItemStack(
        "CLT_PLANT_FISH",
        Skins.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Fish",
        List.of(
            "A ripe smell emanates from this seed."
        )
    );

    public static final SlimefunItemStack PLANT_TURTLE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_TURTLE",
        Skins.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Turtle",
        List.of(
            "A seed surrounded by a rock hard shell."
        )
    );

    public static final SlimefunItemStack PLANT_VILLAGER = Theme.themedSlimefunItemStack(
        "CLT_PLANT_VILLAGER",
        Skins.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Villager",
        List.of(
            "Yup, we condensed the essence of a villager",
            "into a plant. Apparently it hurt a lot."
        )
    );

    public static final SlimefunItemStack PLANT_RABBIT = Theme.themedSlimefunItemStack(
        "CLT_PLANT_RABBIT",
        Skins.SEED_ORANGE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Rabbit",
        List.of(
            "Bugs would be proud."
        )
    );

    public static final SlimefunItemStack PLANT_SHEEP = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SHEEP",
        Skins.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Sheep",
        List.of(
            "A plant with a coarse woolly texture."
        )
    );

    public static final SlimefunItemStack PLANT_PIG = Theme.themedSlimefunItemStack(
        "CLT_PLANT_PIG",
        Skins.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Pig",
        List.of(
            "A plant that snorts randomly."
        )
    );

    public static final SlimefunItemStack PLANT_BEE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_BEE",
        Skins.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Bee",
        List.of(
            "A plant with a very small, delicate, set of wings."
        )
    );

    public static final SlimefunItemStack PLANT_SQUID = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SQUID",
        Skins.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Squid",
        List.of(
            "Be careful, just touching this plant",
            "has the chance to explode ink all over",
            "the place."
        )
    );

    public static final SlimefunItemStack PLANT_GLOW_SQUID = Theme.themedSlimefunItemStack(
        "CLT_PLANT_GLOW_SQUID",
        Skins.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Glow Squid",
        List.of(
            "A glittering plant with a faint glow."
        )
    );

    public static final SlimefunItemStack PLANT_FROG = Theme.themedSlimefunItemStack(
        "CLT_PLANT_FROG",
        Skins.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Frog",
        List.of(
            "Ribbit!"
        )
    );

    public static final SlimefunItemStack PLANT_GOAT = Theme.themedSlimefunItemStack(
        "CLT_PLANT_GOAT",
        Skins.SEED_ORANGE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Goat",
        List.of(
            "A randomly violent plant that loves",
            "to jump around."
        )
    );

    public static final SlimefunItemStack PLANT_RAINBOW = Theme.themedSlimefunItemStack(
        "CLT_PLANT_RAINBOW",
        Skins.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Rainbow",
        List.of(
            "There may or may not be a pot of gold",
            "at the end of this plant."
        )
    );

    public static final SlimefunItemStack PLANT_WAXY = Theme.themedSlimefunItemStack(
        "CLT_PLANT_WAXY",
        Skins.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Waxy",
        List.of(
            "The sap from this plant forms into",
            "perfect candle shaped wax."
        )
    );

    public static final SlimefunItemStack PLANT_WOOLLY = Theme.themedSlimefunItemStack(
        "CLT_PLANT_WOOLLY",
        Skins.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Woolly",
        List.of(
            "A woolly plant, from root to petals!."
        )
    );

    public static final SlimefunItemStack PLANT_TERRA = Theme.themedSlimefunItemStack(
        "CLT_PLANT_TERRA",
        Skins.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Terra",
        List.of(
            "A hard earthy plant that cracks under pressure."
        )
    );

    public static final SlimefunItemStack PLANT_GLAZED = Theme.themedSlimefunItemStack(
        "CLT_PLANT_GLAZED",
        Skins.SEED_ORANGE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Glazed",
        List.of(
            "A plant that grows with an intricate design."
        )
    );

    public static final SlimefunItemStack PLANT_DUSTY = Theme.themedSlimefunItemStack(
        "CLT_PLANT_DUSTY",
        Skins.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Dusty",
        List.of(
            "This plant needs special care, the slightest",
            "strong breeze can be enough to make it fall",
            "apart."
        )
    );

    public static final SlimefunItemStack PLANT_CONCRETE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_CONCRETE",
        Skins.SEED_CYAN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Concrete",
        List.of(
            "This plant struggle to grow as it",
            "hardens so quickly."
        )
    );

    public static final SlimefunItemStack PLANT_STAINED = Theme.themedSlimefunItemStack(
        "CLT_PLANT_STAINED",
        Skins.SEED_CYAN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Stained",
        List.of(
            "This plant splits light into a veritable",
            "spectrum to nearby objects."
        )
    );

    public static final SlimefunItemStack PLANT_COBBLESTONE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_COBBLESTONE",
        Skins.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Cobblestone",
        List.of(
            "This plant is hard as a rock."
        )
    );

    public static final SlimefunItemStack PLANT_GRAVEL = Theme.themedSlimefunItemStack(
        "CLT_PLANT_GRAVEL",
        Skins.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Gravel",
        List.of(
            "This plant really doesn't know how",
            "to keep itself together."
        )
    );

    public static final SlimefunItemStack PLANT_CLAY = Theme.themedSlimefunItemStack(
        "CLT_PLANT_CLAY",
        Skins.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Clay",
        List.of(
            "This plant can be formed and reshaped freely.",
            "That doesn't mean it's a good idea to do so,",
            "though!"
        )
    );

    public static final SlimefunItemStack PLANT_IGNEOUS = Theme.themedSlimefunItemStack(
        "CLT_PLANT_IGNEOUS",
        Skins.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Igneous",
        List.of(
            "This plant has been formed by heat and",
            "pressure. Don't look at me like that! All",
            "these plant descriptions make total sense."
        )
    );

    public static final SlimefunItemStack PLANT_DEEPSLATE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_DEEPSLATE",
        Skins.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Deepslate",
        List.of(
            "Deep, slatey, <insert lore here>."
        )
    );

    public static final SlimefunItemStack PLANT_REINFORCED = Theme.themedSlimefunItemStack(
        "CLT_PLANT_REINFORCED",
        Skins.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Reinforced",
        List.of(
            "A plant that is able to hold itself up",
            "through anything."
        )
    );

    public static final SlimefunItemStack PLANT_BLACKSTONE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_BLACKSTONE",
        Skins.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Blackstone",
        List.of(
            "A plant that has been known to absorb light."
        )
    );

    public static final SlimefunItemStack PLANT_NETHERRACK = Theme.themedSlimefunItemStack(
        "CLT_PLANT_NETHERRACK",
        Skins.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Netherrack",
        List.of(
            "A tough hardy plant able to survive",
            "in most locales."
        )
    );

    public static final SlimefunItemStack PLANT_DARK_GRASS = Theme.themedSlimefunItemStack(
        "CLT_PLANT_DARK_GRASS",
        Skins.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Dark Grass",
        List.of(
            "A plant that has really lost it's",
            "identity."
        )
    );

    public static final SlimefunItemStack PLANT_MAGMA = Theme.themedSlimefunItemStack(
        "CLT_PLANT_MAGMA",
        Skins.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Magma",
        List.of(
            "A plant that's so hot it burns it's",
            "surroundings."
        )
    );

    public static final SlimefunItemStack PLANT_SOUL = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SOUL",
        Skins.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Soul",
        List.of(
            "A plant that can be heard screaming",
            "when its quiet."
        )
    );

    public static final SlimefunItemStack PLANT_BASALT = Theme.themedSlimefunItemStack(
        "CLT_PLANT_BASALT",
        Skins.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Basalt",
        List.of(
            "A very boring and dull plant."
        )
    );

    public static final SlimefunItemStack PLANT_GLASS = Theme.themedSlimefunItemStack(
        "CLT_PLANT_GLASS",
        Skins.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Glass",
        List.of(
            "At the right angle, you could",
            "swear you can see through this plant."
        )
    );

    public static final SlimefunItemStack PLANT_MUD = Theme.themedSlimefunItemStack(
        "CLT_PLANT_MUD",
        Skins.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Mud",
        List.of(
            "A plant that is nearly as dirty as",
            "the ground it comes from."
        )
    );

    public static final SlimefunItemStack PLANT_END_STONE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_END_STONE",
        Skins.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: End Stone",
        List.of(
            "A plant that hums with the void."
        )
    );

    public static final SlimefunItemStack PLANT_PURPUR = Theme.themedSlimefunItemStack(
        "CLT_PLANT_PURPUR",
        Skins.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Purpur",
        List.of(
            "An odd plant, seems far lighter",
            "than most."
        )
    );

    public static final SlimefunItemStack PLANT_COAL = Theme.themedSlimefunItemStack(
        "CLT_PLANT_COAL",
        Skins.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Coal",
        List.of(
            "A plant that holds such potential."
        )
    );

    public static final SlimefunItemStack PLANT_RAW_IRON = Theme.themedSlimefunItemStack(
        "CLT_PLANT_RAW_IRON",
        Skins.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Raw Iron",
        List.of(
            "A sturdy plant able to withstand most",
            "environments."
        )
    );

    public static final SlimefunItemStack PLANT_RAW_COPPER = Theme.themedSlimefunItemStack(
        "CLT_PLANT_RAW_COPPER",
        Skins.SEED_ORANGE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Raw Copper",
        List.of(
            "If left alone, this plant sometimes",
            "attracts lightning."
        )
    );

    public static final SlimefunItemStack PLANT_RAW_GOLD = Theme.themedSlimefunItemStack(
        "CLT_PLANT_RAW_GOLD",
        Skins.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Raw Gold",
        List.of(
            "This plant is commonly stolen by piglins",
            "if nearby."
        )
    );

    public static final SlimefunItemStack PLANT_REDSTONE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_REDSTONE",
        Skins.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Redstone",
        List.of(
            "A plant brimming with power throughout."
        )
    );

    public static final SlimefunItemStack PLANT_LAPIS = Theme.themedSlimefunItemStack(
        "CLT_PLANT_LAPIS",
        Skins.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Lapis",
        List.of(
            "A plant with a faint magical aura."
        )
    );

    public static final SlimefunItemStack PLANT_DIAMOND = Theme.themedSlimefunItemStack(
        "CLT_PLANT_DIAMOND",
        Skins.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Diamond",
        List.of(
            "A plant that just speaks of riches."
        )
    );

    public static final SlimefunItemStack PLANT_EMERALD = Theme.themedSlimefunItemStack(
        "CLT_PLANT_EMERALD",
        Skins.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Emerald",
        List.of(
            "Owners of this plant have to jump",
            "through hoops just to be able to afford it."
        )
    );

    public static final SlimefunItemStack PLANT_NETHER_QUARTZ = Theme.themedSlimefunItemStack(
        "CLT_PLANT_NETHER_QUARTZ",
        Skins.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Nether Quartz",
        List.of(
            "This plant has thorns so sharp that",
            "it's hard to work with."
        )
    );

    public static final SlimefunItemStack PLANT_SCRAPPY = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SCRAPPY",
        Skins.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Scrappy",
        List.of(
            "This plant really is the pinnacle of",
            "horticulturalism."
        )
    );

    public static final SlimefunItemStack PLANT_AMETHYST = Theme.themedSlimefunItemStack(
        "CLT_PLANT_AMETHYST",
        Skins.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Amethyst",
        List.of(
            "This plant loves to flourish in deep, dark",
            "locales."
        )
    );

    public static final SlimefunItemStack PLANT_ECHO = Theme.themedSlimefunItemStack(
        "CLT_PLANT_ECHO",
        Skins.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Echo",
        List.of(
            "This plant always knows how to find",
            "its way home."
        )
    );

    public static final SlimefunItemStack PLANT_SKELETON = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SKELETON",
        Skins.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Skeleton",
        List.of(
            "A plant that rattles as it sways."
        )
    );

    public static final SlimefunItemStack PLANT_SPIDER = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SPIDER",
        Skins.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Spider",
        List.of(
            "Kill it, kill it NAO!"
        )
    );

    public static final SlimefunItemStack PLANT_CREEPER = Theme.themedSlimefunItemStack(
        "CLT_PLANT_CREEPER",
        Skins.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Creeper",
        List.of(
            "Tsssssssssttt..."
        )
    );

    public static final SlimefunItemStack PLANT_ZOMBIE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_ZOMBIE",
        Skins.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Zombie",
        List.of(
            "This plant is dripping... something..."
        )
    );

    public static final SlimefunItemStack PLANT_DROWNED = Theme.themedSlimefunItemStack(
        "CLT_PLANT_DROWNED",
        Skins.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Drowned",
        List.of(
            "A Plant that is dripping wet, all",
            "the time."
        )
    );

    public static final SlimefunItemStack PLANT_GUARDIAN = Theme.themedSlimefunItemStack(
        "CLT_PLANT_GUARDIAN",
        Skins.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Guardian",
        List.of(
            "When touched, this plant releases",
            "spines."
        )
    );

    public static final SlimefunItemStack PLANT_ELDER_GUARDIAN = Theme.themedSlimefunItemStack(
        "CLT_PLANT_ELDER_GUARDIAN",
        Skins.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Elder Guardian",
        List.of(
            "Being near this plants makes people",
            "sluggish."
        )
    );

    public static final SlimefunItemStack PLANT_GHAST = Theme.themedSlimefunItemStack(
        "CLT_PLANT_GHAST",
        Skins.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Ghast",
        List.of(
            "A plant that has been known to",
            "randomly shoot fire balls."
        )
    );

    public static final SlimefunItemStack PLANT_SLIME = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SLIME",
        Skins.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Slime",
        List.of(
            "Why is it so sticky?"
        )
    );

    public static final SlimefunItemStack PLANT_MAGMA_CUBE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_MAGMA_CUBE",
        Skins.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Magma Cube",
        List.of(
            "When not being watched, this plant",
            "likes to bounce up and down."
        )
    );

    public static final SlimefunItemStack PLANT_BLAZE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_BLAZE",
        Skins.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Blaze",
        List.of(
            "A plant that is scorched around the edges."
        )
    );

    public static final SlimefunItemStack PLANT_WITHER_SKELETON = Theme.themedSlimefunItemStack(
        "CLT_PLANT_WITHER_SKELETON",
        Skins.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Wither Skeleton",
        List.of(
            "A plant known to be elusive and hardy."
        )
    );

    public static final SlimefunItemStack PLANT_WITHER = Theme.themedSlimefunItemStack(
        "CLT_PLANT_WITHER",
        Skins.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Wither",
        List.of(
            "A deadly plant that must be treated",
            "with care."
        )
    );

    public static final SlimefunItemStack PLANT_PHANTOM = Theme.themedSlimefunItemStack(
        "CLT_PLANT_PHANTOM",
        Skins.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Phantom",
        List.of(
            "A plant with lofty leaves."
        )
    );

    public static final SlimefunItemStack PLANT_SHULKER = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SHULKER",
        Skins.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Shulker",
        List.of(
            "A plant that often levitates off",
            "of the ground."
        )
    );

    public static final SlimefunItemStack PLANT_ENDERMAN = Theme.themedSlimefunItemStack(
        "CLT_PLANT_ENDERMAN",
        Skins.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Enderman",
        List.of(
            "If not treated carefully, this plant",
            "may teleport randomly!"
        )
    );

    public static final SlimefunItemStack PLANT_ENDER_DRAGON = Theme.themedSlimefunItemStack(
        "CLT_PLANT_ENDER_DRAGON",
        Skins.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Ender Dragon",
        List.of(
            "A real boss of a plant."
        )
    );

    public static final SlimefunItemStack PLANT_WITCH = Theme.themedSlimefunItemStack(
        "CLT_PLANT_WITCH",
        Skins.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Witch",
        List.of(
            "A plant that sounds like it's softly",
            "muttering spells."
        )
    );

    // endregion

    // region Bushes


    // endregion

    // region Tools

    public static final SlimefunItemStack CROP_STICKS = Theme.themedSlimefunItemStack(
        "CLT_CROP_STICKS",
        Material.STICK,
        CultivationThemes.TOOL,
        "Crop Sticks",
        "Crop sticks must be applied to a",
        "placed seed in order for it to grow.",
        "Placing a second set will cross-crop",
        "the plant allowing it to spread and/or",
        "breed."
    );

    public static final SlimefunItemStack HARVESTING_TOOL_SIMPLE = Theme.themedSlimefunItemStack(
        "CLT_HARVESTING_TOOL_SIMPLE",
        Material.TRIPWIRE_HOOK,
        CultivationThemes.TOOL,
        "Simple Harvesting Tool",
        "A very basic tool that allows",
        "the user to harvest Cultivation Plants.",
        Theme.WARNING + "Works on Tier 1 plants",
        "",
        Theme.applyThemeAsTitle(Theme.CLICK_INFO, "Right Click", "Harvests a fully grown Cultivation Plant"),
        "",
        LoreBuilder.usesLeft(50)
    );

    public static final SlimefunItemStack TRIMMING_TOOL_SIMPLE = Theme.themedSlimefunItemStack(
        "CLT_TRIMMING_TOOL_SIMPLE",
        Material.SHEARS,
        CultivationThemes.TOOL,
        "Simple Trimming Tool",
        "A very basic tool that allows",
        "the user to trim Cultivation Bushes.",
        "",
        Theme.applyThemeAsTitle(Theme.CLICK_INFO, "Right Click", "Takes a trimming of a fully grown Cultivation Bush"),
        "",
        LoreBuilder.usesLeft(50)
    );

    public static final SlimefunItemStack PLANT_ANALYSER = Theme.themedSlimefunItemStack(
        "CLT_PLANT_ANALYSER",
        Material.DIAMOND,
        CultivationThemes.TOOL,
        "Plant Analyser",
        "A very basic tool that allows",
        "you to see a growing plant's details",
        "",
        Theme.applyThemeAsTitle(
            Theme.CLICK_INFO,
            "Right Click",
            "Lets you know the species and growth details of a plant."
        ),
        Theme.applyThemeAsTitle(Theme.CLICK_INFO, "Shift Right Click", "Displays a plant or bushes name.")
    );

    public static final SlimefunItemStack RECIPE_UNLOCK = Theme.themedSlimefunItemStack(
        "CLT_RECIPE_UNLOCK",
        Material.PAPER,
        CultivationThemes.TOOL,
        "Cultivation Knowledge Script",
        "Right click to learn a Cultivation",
        "breeding recipe.",
        "",
        Theme.CLICK_INFO.asTitle("Unlocks", "{0}")
    );

    // endregion

    // region Machines

    public static final SlimefunItemStack GARDEN_CLOCHE = Theme.themedSlimefunItemStack(
        "CLT_GARDEN_CLOCHE",
        Material.GLASS,
        CultivationThemes.MACHINE,
        "Garden Cloche",
        "Grows plants inside it automatically.",
        "",
        Theme.CLICK_INFO.asTitle("Power per Tick", 100)
    );

    public static final SlimefunItemStack COUNTER_NOTHING = Theme.themedSlimefunItemStack(
        "CLT_COUNTER_NOTHING",
        Material.STRIPPED_DARK_OAK_LOG,
        CultivationThemes.MACHINE,
        "Kitchen Counter: Empty",
        "Just for decoration!"
    );

    public static final SlimefunItemStack COUNTER_CHOPPING = Theme.themedSlimefunItemStack(
        "CLT_COUNTER_CHOPPING",
        Material.SMITHING_TABLE,
        CultivationThemes.MACHINE,
        "Kitchen Counter: Chopping Board",
        "Right click this block to chop produce."
    );

    public static final SlimefunItemStack COUNTER_SLICING = Theme.themedSlimefunItemStack(
        "CLT_COUNTER_SLICING",
        Material.CARTOGRAPHY_TABLE,
        CultivationThemes.MACHINE,
        "Kitchen Counter: Slicing Board",
        "Right click this block to slice produce."
    );

    public static final SlimefunItemStack COUNTER_MASHER = Theme.themedSlimefunItemStack(
        "CLT_COUNTER_MASHER",
        Material.CRAFTING_TABLE,
        CultivationThemes.MACHINE,
        "Kitchen Counter: Mashing Bowl",
        "Right click this block to mash produce."
    );

    public static final SlimefunItemStack COUNTER_GRINDER = Theme.themedSlimefunItemStack(
        "CLT_COUNTER_GRINDER",
        Material.CAULDRON,
        CultivationThemes.MACHINE,
        "Kitchen Counter: Grinding Pestle and Mortar",
        "Right click this block to grind produce."
    );

    public static final SlimefunItemStack COUNTER_BLENDER = Theme.themedSlimefunItemStack(
        "CLT_COUNTER_BLENDER",
        Material.FLETCHING_TABLE,
        CultivationThemes.MACHINE,
        "Kitchen Counter: Blender",
        "Right click this block to blend produce."
    );

    public static final SlimefunItemStack COUNTER_OVEN = Theme.themedSlimefunItemStack(
        "CLT_COUNTER_OVEN",
        Material.FURNACE,
        CultivationThemes.MACHINE,
        "Kitchen Counter: Oven",
        "Can bake certain produce items."
    );

    public static final SlimefunItemStack COUNTER_FRYER = Theme.themedSlimefunItemStack(
        "CLT_COUNTER_FRYING",
        Material.BLACK_STAINED_GLASS,
        CultivationThemes.MACHINE,
        "Kitchen Counter: Frying Pan",
        "Can fry certain produce items."
    );

    public static final SlimefunItemStack COUNTER_BOILING = Theme.themedSlimefunItemStack(
        "CLT_COUNTER_BOILING",
        Material.BLACK_STAINED_GLASS,
        CultivationThemes.MACHINE,
        "Kitchen Counter: Boiling Pot",
        "Can boil certain items."
    );

    public static final SlimefunItemStack COUNTER_GRILL = Theme.themedSlimefunItemStack(
        "CLT_COUNTER_GRILL",
        Material.CAMPFIRE,
        CultivationThemes.MACHINE,
        "Kitchen Counter: Grill",
        "Can grill certain produce items."
    );

    public static final SlimefunItemStack COUNTER_FINISHING = Theme.themedSlimefunItemStack(
        "CLT_COUNTER_FINISHING",
        Material.CRAFTING_TABLE,
        CultivationThemes.MACHINE,
        "Kitchen Counter: Finishing",
        "Used to craft products/by-products into",
        "other by-products or finished foods."
    );

    // endregion

    // region Produce

    public static final SlimefunItemStack BANANA = Theme.themedSlimefunItemStack(
        "CLT_BANANA",
        Skins.BANANA.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Banana",
        "I like the look and peel of this!"
    );

    public static final SlimefunItemStack LEMON = Theme.themedSlimefunItemStack(
        "CLT_LEMON",
        Skins.LEMON.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Lemon",
        "Why the sour look?"
    );

    public static final SlimefunItemStack ORANGE = Theme.themedSlimefunItemStack(
        "CLT_ORANGE",
        Skins.ORANGE.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Orange",
        "Isn't this meant to be clockwork?"
    );

    public static final SlimefunItemStack GREEN_APPLE = Theme.themedSlimefunItemStack(
        "CLT_GREEN_APPLE",
        Skins.GREEN_APPLE.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Green Apple",
        "The note says... Dear Teacher?"
    );

    public static final SlimefunItemStack PINEAPPLE = Theme.themedSlimefunItemStack(
        "CLT_PINEAPPLE",
        Skins.PINEAPPLE.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Pineapple",
        "This belongs on every pizza in existence.",
        "Wanna fight about it!?"
    );

    public static final SlimefunItemStack MANGO = Theme.themedSlimefunItemStack(
        "CLT_MANGO",
        Skins.MANGO.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Mango",
        "MAN, I gotta GO.",
        "Lore is hard..."
    );

    public static final SlimefunItemStack PEACH = Theme.themedSlimefunItemStack(
        "CLT_PEACH",
        Skins.PEACH.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Peach",
        "We don't talk about the Emoji"
    );

    public static final SlimefunItemStack APRICOT = Theme.themedSlimefunItemStack(
        "CLT_APRICOT",
        Skins.APRICOT.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Apricot",
        "You can make Pokéballs out of these.",
        "...",
        "What do you mean that's different thing...?"
    );

    public static final SlimefunItemStack PEAR = Theme.themedSlimefunItemStack(
        "CLT_PEAR",
        Skins.PEAR.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Pear",
        "Wouldn't you say this looks pear-fect?"
    );

    public static final SlimefunItemStack CHERRY = Theme.themedSlimefunItemStack(
        "CLT_CHERRY",
        Skins.CHERRY.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Cherry",
        "Oh, I thought they grew Glacé'd, shame!"
    );

    public static final SlimefunItemStack KIWI = Theme.themedSlimefunItemStack(
        "CLT_KIWI",
        Skins.KIWI.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Kiwi",
        "I put this in the addon under duress.",
        "Kiwis are evil and anyone who",
        "uses them will automatically lose",
        "100 points."
    );

    public static final SlimefunItemStack LIME = Theme.themedSlimefunItemStack(
        "CLT_LIME",
        Skins.KIWI.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Lime",
        "One upon a lime there was a delicious fruit..."
    );

    public static final SlimefunItemStack CHESTNUT = Theme.themedSlimefunItemStack(
        "CLT_CHESTNUT",
        Skins.CHESTNUT.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Chestnut",
        "Designed to be baked, immediately."
    );

    public static final SlimefunItemStack HAZELNUT = Theme.themedSlimefunItemStack(
        "CLT_HAZELNUT",
        Skins.HAZELNUT.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Hazelnut",
        "Do whatever you need to turn this into",
        "a coffee for me, now!"
    );

    public static final SlimefunItemStack GRAPE = Theme.themedSlimefunItemStack(
        "CLT_GRAPE",
        Skins.GRAPE.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Grape",
        "So plump!"
    );

    public static final SlimefunItemStack PEANUT = Theme.themedSlimefunItemStack(
        "CLT_PEANUT",
        Skins.PEANUT.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Peanut",
        "Reece's here I come!"
    );

    public static final SlimefunItemStack STRAWBERRY = Theme.themedSlimefunItemStack(
        "CLT_STRAWBERRY",
        Skins.STRAWBERRY.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Strawberry",
        "Just add cream!"
    );

    public static final SlimefunItemStack RICE = Theme.themedSlimefunItemStack(
        "CLT_RICE",
        Skins.RICE.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Rice",
        "Remember, you only live rice!"
    );

    public static final SlimefunItemStack GARLIC = Theme.themedSlimefunItemStack(
        "CLT_GARLIC",
        Skins.GARLIC.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Garlic",
        "Quick, before the vampires come!"
    );

    public static final SlimefunItemStack CAYENNE_PEPPER = Theme.themedSlimefunItemStack(
        "CLT_CAYENNE_PEPPER",
        Skins.PEPPERS.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Cayenne Pepper",
        "A soft spicy treat."
    );

    public static final SlimefunItemStack TOMATO = Theme.themedSlimefunItemStack(
        "CLT_TOMATO",
        Skins.TOMATO.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Tomato",
        "Right off of the vine.... err... bush?"
    );

    public static final SlimefunItemStack BELL_PEPPER = Theme.themedSlimefunItemStack(
        "CLT_BELL_PEPPER",
        Skins.BELL_PEPPER.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Bell Pepper",
        "Really rings true."
    );

    public static final SlimefunItemStack ONION = Theme.themedSlimefunItemStack(
        "CLT_ONION",
        Skins.ONION.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Onion",
        "Wait, why are you crying?"
    );

    public static final SlimefunItemStack PEA = Theme.themedSlimefunItemStack(
        "CLT_PEA",
        Skins.GREEN_APPLE.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Peas",
        "Often found in pairs within a pod, or so I hear."
    );

    public static final SlimefunItemStack RAPESEED = Theme.themedSlimefunItemStack(
        "CLT_RAPESEED",
        new ItemStack(Material.MELON_SEEDS),
        CultivationThemes.PRODUCE,
        "Rapeseed",
        "Oft-used to create oils."
    );

    public static final SlimefunItemStack LETTUCE = Theme.themedSlimefunItemStack(
        "CLT_LETTUCE",
        Skins.LETTUCE.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Lettuce",
        "Thin, watery and yet delicious."
    );

    public static final SlimefunItemStack MUSTARD_SEEDS = Theme.themedSlimefunItemStack(
        "CLT_MUSTARD_SEEDS",
        new ItemStack(Material.PUMPKIN_SEEDS),
        CultivationThemes.PRODUCE,
        "Mustard Seeds",
        "Chew them, I dare you!"
    );

    public static final SlimefunItemStack BROCCOLI = Theme.themedSlimefunItemStack(
        "CLT_BROCCOLI",
        Skins.BROCCOLI.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Broccoli",
        "Are you a giant holding a tree?",
        "Naw, just a tiny tree :)"
    );

    public static final SlimefunItemStack CINNAMON = Theme.themedSlimefunItemStack(
        "CLT_CINNAMON",
        new ItemStack(Material.STICK),
        CultivationThemes.PRODUCE,
        "Cinnamon",
        "Great to chew on in it's stick form."
    );

    public static final SlimefunItemStack BASIL = Theme.themedSlimefunItemStack(
        "CLT_BASIL",
        new ItemStack(Material.SMALL_DRIPLEAF),
        CultivationThemes.PRODUCE,
        "Basil",
        "A sweet leaf with a soft peppery aftertaste."
    );

    public static final SlimefunItemStack BAY_LEAF = Theme.themedSlimefunItemStack(
        "CLT_BAY_LEAF",
        new ItemStack(Material.LILY_PAD),
        CultivationThemes.PRODUCE,
        "Bay Leaf",
        "A strong aromat with many uses."
    );

    public static final SlimefunItemStack CILANTRO = Theme.themedSlimefunItemStack(
        "CLT_CILANTRO",
        new ItemStack(Material.MANGROVE_LEAVES),
        CultivationThemes.PRODUCE,
        "Cilantro",
        "A soft spice with a hit of citrus."
    );

    public static final SlimefunItemStack CHICORY = Theme.themedSlimefunItemStack(
        "CLT_CHICORY",
        new ItemStack(Material.BLUE_ORCHID),
        CultivationThemes.PRODUCE,
        "Chicory",
        "A nutty, bitter root."
    );

    public static final SlimefunItemStack CHIVES = Theme.themedSlimefunItemStack(
        "CLT_CHIVES",
        new ItemStack(Material.SEAGRASS),
        CultivationThemes.PRODUCE,
        "Chives",
        "A sweat, onion-tasting, herb."
    );

    public static final SlimefunItemStack CLOVE = Theme.themedSlimefunItemStack(
        "CLT_CLOVE",
        new ItemStack(Material.POPPY),
        CultivationThemes.PRODUCE,
        "Clove",
        "A super warm and intense flavour."
    );

    public static final SlimefunItemStack CUMIN = Theme.themedSlimefunItemStack(
        "CLT_CUMIN",
        new ItemStack(Material.DANDELION),
        CultivationThemes.PRODUCE,
        "Cumin",
        "A warm citrusy plant."
    );

    public static final SlimefunItemStack CHILLI_PEPPER = Theme.themedSlimefunItemStack(
        "CLT_CHILLY_PEPPER",
        Skins.PEPPERS.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Chilly Pepper",
        "I can eat a whole pepper without crying.",
        "Well, half.",
        "WEEEELLL.... 1/4",
        "...",
        "Ok I can touch one on my tounge"
    );

    public static final SlimefunItemStack CURRY_LEAF = Theme.themedSlimefunItemStack(
        "CLT_CURRY_LEAF",
        new ItemStack(Material.KELP),
        CultivationThemes.PRODUCE,
        "Curry Leaf",
        "The basis of so many wonderful foods."
    );

    public static final SlimefunItemStack DILL = Theme.themedSlimefunItemStack(
        "CLT_DILL",
        new ItemStack(Material.GRASS),
        CultivationThemes.PRODUCE,
        "Dill",
        "Just taste like grass to me. Why",
        "do people like this?"
    );

    public static final SlimefunItemStack FENNEL = Theme.themedSlimefunItemStack(
        "CLT_FENNEL",
        new ItemStack(Material.OXEYE_DAISY),
        CultivationThemes.PRODUCE,
        "Fennel",
        "Like a mix of Anise and Liquorice."
    );

    public static final SlimefunItemStack GINGER = Theme.themedSlimefunItemStack(
        "CLT_GINGER",
        new ItemStack(Material.HANGING_ROOTS),
        CultivationThemes.PRODUCE,
        "Ginger",
        "Chopped Ginger in boiling water, heals all ailments!"
    );

    public static final SlimefunItemStack HORSERADISH = Theme.themedSlimefunItemStack(
        "CLT_HORSERADISH",
        new ItemStack(Material.HANGING_ROOTS),
        CultivationThemes.PRODUCE,
        "Horseradish",
        "$100 if you bite right into it."
    );

    public static final SlimefunItemStack JASMINE = Theme.themedSlimefunItemStack(
        "CLT_JASMINE",
        new ItemStack(Material.WHITE_TULIP),
        CultivationThemes.PRODUCE,
        "Jasmine",
        "Makes for a wonderful tea."
    );

    public static final SlimefunItemStack JUNIPER_BERRY = Theme.themedSlimefunItemStack(
        "CLT_JUNIPER_BERRY",
        new ItemStack(Material.GLOW_BERRIES),
        CultivationThemes.PRODUCE,
        "Juniper Berries",
        "Dried to a peppery perfection."
    );

    public static final SlimefunItemStack KAFFIR_LIME = Theme.themedSlimefunItemStack(
        "CLT_KAFFIR_LIME",
        new ItemStack(Material.KELP),
        CultivationThemes.PRODUCE,
        "Kaffir Lime Leaf",
        "A leaf with a mighty zest."
    );

    public static final SlimefunItemStack LAVENDER = Theme.themedSlimefunItemStack(
        "CLT_LAVENDER",
        new ItemStack(Material.PURPLE_DYE),
        CultivationThemes.PRODUCE,
        "Lavender",
        "A smell that can make me drift slowly to sleep."
    );

    public static final SlimefunItemStack LICORICE = Theme.themedSlimefunItemStack(
        "CLT_LICORICE",
        new ItemStack(Material.HANGING_ROOTS),
        CultivationThemes.PRODUCE,
        "Licorice",
        "Run, run away now!"
    );

    public static final SlimefunItemStack MACE = Theme.themedSlimefunItemStack(
        "CLT_MACE",
        new ItemStack(Material.HANGING_ROOTS),
        CultivationThemes.PRODUCE,
        "Mace",
        "Used to spray in the face of attackers.",
        "...",
        "What do you mean that's not the right type of mace?"
    );

    public static final SlimefunItemStack MARJORAM = Theme.themedSlimefunItemStack(
        "CLT_MARJORAM",
        new ItemStack(Material.HANGING_ROOTS),
        CultivationThemes.PRODUCE,
        "Marjoram",
        "I'm in a bit of a curry, could we talk later?"
    );

    public static final SlimefunItemStack MINT = Theme.themedSlimefunItemStack(
        "CLT_MINT",
        new ItemStack(Material.HANGING_ROOTS),
        CultivationThemes.PRODUCE,
        "Mint",
        "Chew chew chew."
    );

    public static final SlimefunItemStack OREGANO = Theme.themedSlimefunItemStack(
        "CLT_OREGANO",
        new ItemStack(Material.HANGING_ROOTS),
        CultivationThemes.PRODUCE,
        "Oregano",
        "A classic staple cupboard herb."
    );

    public static final SlimefunItemStack PARSLEY = Theme.themedSlimefunItemStack(
        "CLT_PARSLEY",
        new ItemStack(Material.HANGING_ROOTS),
        CultivationThemes.PRODUCE,
        "Parsley",
        "Worst. Herb. Ever."
    );

    public static final SlimefunItemStack ROSEMARY = Theme.themedSlimefunItemStack(
        "CLT_ROSEMARY",
        new ItemStack(Material.HANGING_ROOTS),
        CultivationThemes.PRODUCE,
        "Rosemary",
        "Often misses thyme."
    );

    public static final SlimefunItemStack SASSAFRAS = Theme.themedSlimefunItemStack(
        "CLT_SASSAFRAS",
        new ItemStack(Material.HANGING_ROOTS),
        CultivationThemes.PRODUCE,
        "Sassafras",
        "Edible Root Beer, seriously google",
        "it, I buy it constantly now."
    );

    public static final SlimefunItemStack SHISO = Theme.themedSlimefunItemStack(
        "CLT_SHISO",
        new ItemStack(Material.HANGING_ROOTS),
        CultivationThemes.PRODUCE,
        "Shiso",
        "Mint with a side of love."
    );

    public static final SlimefunItemStack STAR_ANISE = Theme.themedSlimefunItemStack(
        "CLT_STAR_ANISE",
        new ItemStack(Material.HANGING_ROOTS),
        CultivationThemes.PRODUCE,
        "Star Anise",
        "One of the best and most unique flavours."
    );

    public static final SlimefunItemStack TARRAGON = Theme.themedSlimefunItemStack(
        "CLT_TARRAGON",
        new ItemStack(Material.HANGING_ROOTS),
        CultivationThemes.PRODUCE,
        "Tarragon",
        "I literally put this on anything.",
        "Spoiler: Im not a good chef."
    );

    public static final SlimefunItemStack THYME = Theme.themedSlimefunItemStack(
        "CLT_THYME",
        new ItemStack(Material.BIRCH_LEAVES),
        CultivationThemes.PRODUCE,
        "Thyme",
        "Often missed rosemary."
    );

    public static final SlimefunItemStack TURMERIC = Theme.themedSlimefunItemStack(
        "CLT_TURMERIC",
        new ItemStack(Material.YELLOW_DYE),
        CultivationThemes.PRODUCE,
        "Turmeric",
        "A strong musky presence to fill out many dishes."
    );

    public static final SlimefunItemStack VANILLA = Theme.themedSlimefunItemStack(
        "CLT_VANILLA",
        new ItemStack(Material.BLACK_DYE),
        CultivationThemes.PRODUCE,
        "Vanilla",
        "Instructions: Dip directly into a Latte"
    );

    public static final SlimefunItemStack WASABI = Theme.themedSlimefunItemStack(
        "CLT_WASABI",
        new ItemStack(Material.HANGING_ROOTS),
        CultivationThemes.PRODUCE,
        "Wasabi",
        "Help... wasabi..."
    );

    public static final SlimefunItemStack ARTICHOKE = Theme.themedSlimefunItemStack(
        "CLT_ARTICHOKE",
        Skins.CABBAGE.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Artichoke",
        "Rip out it's HEART!"
    );

    public static final SlimefunItemStack AUBERGINE = Theme.themedSlimefunItemStack(
        "CLT_AUBERGINE",
        Skins.AUBERGINE.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Aubergine",
        "Bright purple and 100% NOT egg shaped.",
        "Better call it an eggplant, right?"
    );

    public static final SlimefunItemStack ASPARAGUS = Theme.themedSlimefunItemStack(
        "CLT_ASPARAGUS",
        Skins.ASPARAGUS.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Asparagus",
        "Careful when visiting the bathroom later."
    );

    public static final SlimefunItemStack BRUSSELS_SPROUTS = Theme.themedSlimefunItemStack(
        "CLT_BRUSSELS_SPROUTS",
        Skins.KALE.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Brussels Sprouts",
        "A gassious delight."
    );

    public static final SlimefunItemStack CABBAGE = Theme.themedSlimefunItemStack(
        "CLT_CABBAGE",
        Skins.CABBAGE.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Cabbage",
        "A baggage of cabbage."
    );

    public static final SlimefunItemStack CAULIFLOWER = Theme.themedSlimefunItemStack(
        "CLT_CAULIFLOWER",
        Skins.CAULIFLOWER.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Cauliflower",
        "A portable cloud!"
    );

    public static final SlimefunItemStack CELERY = Theme.themedSlimefunItemStack(
        "CLT_CELERY",
        new ItemStack(Material.BAMBOO),
        CultivationThemes.PRODUCE,
        "Celery",
        "Literally just stringy water. Convince",
        "me otherwise."
    );

    public static final SlimefunItemStack KALE = Theme.themedSlimefunItemStack(
        "CLT_KALE",
        Skins.KALE.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Kale",
        "Help, im a 2020 smoothie hipster!"
    );

    public static final SlimefunItemStack SPINACH = Theme.themedSlimefunItemStack(
        "CLT_SPINACH",
        new ItemStack(Material.KELP),
        CultivationThemes.PRODUCE,
        "Spinach",
        "Wilted with love."
    );

    public static final SlimefunItemStack BLACK_BEANS = Theme.themedSlimefunItemStack(
        "CLT_BLACK_BEANS",
        new ItemStack(Material.MELON_SEEDS),
        CultivationThemes.PRODUCE,
        "Black Beans",
        "A delicious vegetarian protein."
    );

    public static final SlimefunItemStack GREEN_BEANS = Theme.themedSlimefunItemStack(
        "CLT_GREEN_BEANS",
        new ItemStack(Material.FROGSPAWN),
        CultivationThemes.PRODUCE,
        "Green Beans",
        "How creatively named!"
    );

    public static final SlimefunItemStack CHICKPEAS = Theme.themedSlimefunItemStack(
        "CLT_CHICKPEAS",
        new ItemStack(Material.BEETROOT_SEEDS),
        CultivationThemes.PRODUCE,
        "Chickpeas",
        "Black eyed peas can sing a tune, chickpeas can only hummus one."
    );

    public static final SlimefunItemStack SOY_BEANS = Theme.themedSlimefunItemStack(
        "CLT_SOY_BEANS",
        new ItemStack(Material.MELON_SEEDS),
        CultivationThemes.PRODUCE,
        "Soy Beans",
        "Soy milk cometh."
    );

    public static final SlimefunItemStack PINTO_BEANS = Theme.themedSlimefunItemStack(
        "CLT_PINTO_BEANS",
        new ItemStack(Material.MELON_SEEDS),
        CultivationThemes.PRODUCE,
        "Pinto Beans",
        "Kaching! It's burrito time."
    );

    public static final SlimefunItemStack RUNNER_BEANS = Theme.themedSlimefunItemStack(
        "CLT_RUNNER_BEANS",
        new ItemStack(Material.KELP),
        CultivationThemes.PRODUCE,
        "Runner Beans",
        "Always trying to get away."
    );

    public static final SlimefunItemStack NETTLES = Theme.themedSlimefunItemStack(
        "CLT_NETTLES",
        new ItemStack(Material.AZALEA_LEAVES),
        CultivationThemes.PRODUCE,
        "Nettles",
        "Please put on your gloves before holding these."
    );

    public static final SlimefunItemStack OKRA = Theme.themedSlimefunItemStack(
        "CLT_OKRA",
        Skins.LETTUCE.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Okra",
        "Grown alot in okra-homa... right, RIGHT?"
    );

    public static final SlimefunItemStack LEEK = Theme.themedSlimefunItemStack(
        "CLT_LEEK",
        Skins.LEEK.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Leek",
        "for some reason it's dripping with water?",
        "Perhaps it's sprung a leek?"
    );

    public static final SlimefunItemStack SHALLOT = Theme.themedSlimefunItemStack(
        "CLT_SHALLOT",
        Skins.ONION.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Shallot",
        "I do love a lot of shallot."
    );

    public static final SlimefunItemStack JALAPENO = Theme.themedSlimefunItemStack(
        "CLT_JALAPENO",
        Skins.PEPPERS.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Jalapeno",
        "HOT HOT HOT."
    );

    public static final SlimefunItemStack RADICCHIO = Theme.themedSlimefunItemStack(
        "CLT_RADICCHIO",
        Skins.RADDISH.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Radicchio",
        "Writing all this lore takes so long.",
        "It's radicchio-less."
    );

    public static final SlimefunItemStack RHUBARB = Theme.themedSlimefunItemStack(
        "CLT_RHUBARB",
        Skins.LEEK.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Rhubarb",
        "Just be sure to remove the leaves!"
    );

    public static final SlimefunItemStack CELERIAC = Theme.themedSlimefunItemStack(
        "CLT_CELERIAC",
        Skins.PARSNIP.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Celeriac",
        "A hearty root that's rooted (heh) in many",
        "traditional recipes."
    );

    public static final SlimefunItemStack PARSNIP = Theme.themedSlimefunItemStack(
        "CLT_PARSNIP",
        Skins.PARSNIP.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Parsnip",
        "Requires roasting immediately."
    );

    public static final SlimefunItemStack RUTABAGA = Theme.themedSlimefunItemStack(
        "CLT_RUTABAGA",
        Skins.RUTABAGA.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Rutabaga",
        "It actually hurts not calling this a swede."
    );

    public static final SlimefunItemStack RADDISH = Theme.themedSlimefunItemStack(
        "CLT_RADDISH",
        Skins.RADDISH.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Raddish",
        "Little pockets of fresh, crisp, sunshine."
    );

    public static final SlimefunItemStack SWEET_POTATO = Theme.themedSlimefunItemStack(
        "CLT_SWEET_POTATO",
        new ItemStack(Material.BEETROOT),
        CultivationThemes.PRODUCE,
        "Sweet Potato",
        "Yam yam yam."
    );

    public static final SlimefunItemStack TURNIP = Theme.themedSlimefunItemStack(
        "CLT_TURNIP",
        Skins.TURNIP.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Turnip",
        "Will solve all of life's problems."
    );

    public static final SlimefunItemStack SWEETCORN = Theme.themedSlimefunItemStack(
        "CLT_SWEETCORN",
        Skins.CORN.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Sweetcorn",
        "Perhaps the best vegetable around."
    );

    public static final SlimefunItemStack COURGETTE = Theme.themedSlimefunItemStack(
        "CLT_COURGETTE",
        new ItemStack(Material.BAMBOO),
        CultivationThemes.PRODUCE,
        "Courgette",
        "Pro Tip: Grate this into any pasta sauce",
        "for depth and texture."
    );

    public static final SlimefunItemStack CUCUMBER = Theme.themedSlimefunItemStack(
        "CLT_CUCUMBER",
        new ItemStack(Material.BAMBOO),
        CultivationThemes.PRODUCE,
        "Cucumber",
        "Water in a green shell, prove me",
        "wrong."
    );

    public static final SlimefunItemStack MARROW = Theme.themedSlimefunItemStack(
        "CLT_MARROW",
        Skins.SQUASH.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Marrow",
        "Did you know marrows are found within",
        "your bones?",
        "Yup, Sefi Smort."
    );

    // endregion

    // region Crafted By Products

    public static final SlimefunItemStack PEANUT_BUTTER = Theme.themedSlimefunItemStack(
        "CLT_PEANUT_BUTTER",
        Skins.PEANUT_BUTTER.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Peanut Butter",
        "Akin only to liquid gold."
    );

    public static final SlimefunItemStack GRAPE_JELLY = Theme.themedSlimefunItemStack(
        "CLT_GRAPE_JELLY",
        Skins.JAM_JAR_BLUE.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Grape Jelly",
        "Eating it with a spoon is a criminal offence."
    );

    public static final SlimefunItemStack STRAWBERRY_JELLY = Theme.themedSlimefunItemStack(
        "CLT_STRAWBERRY_JELLY",
        Skins.JAM_JAR_RED.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Strawberry Jelly",
        "Eating it with a spoon is a criminal offence."
    );

    public static final SlimefunItemStack OIL = Theme.themedSlimefunItemStack(
        "CLT_OIL",
        Skins.SPICE_YELLOW.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Oil",
        "Oil. Need I say more?"
    );

    public static final SlimefunItemStack MAYONNAISE = Theme.themedSlimefunItemStack(
        "CLT_MAYONNAISE",
        new ItemStack(Material.MILK_BUCKET),
        CultivationThemes.PRODUCE,
        "Mayonnaise",
        "A silky smooth mayo that can go with nearly anything."
    );

    public static final SlimefunItemStack EGG_SALAD = Theme.themedSlimefunItemStack(
        "CLT_EGG_SALAD",
        Skins.SPICE_YELLOW.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Egg Salad",
        "Open this on a train, I dare you!"
    );

    public static final SlimefunItemStack PIE_CRUST = Theme.themedSlimefunItemStack(
        "CLT_PIE_CRUST",
        Skins.PIE_CRUST.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Pie Crust",
        "If it were legal to eat this own it's own",
        "it'd be my main food source."
    );

    public static final SlimefunItemStack PASTA = Theme.themedSlimefunItemStack(
        "CLT_PASTA",
        Skins.PASTA.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Pasta",
        "Just plain pasta, simple yet wonderful."
    );

    public static final SlimefunItemStack BISCUIT_DOUGH = Theme.themedSlimefunItemStack(
        "CLT_BISCUIT_DOUGH",
        new ItemStack(Material.BROWN_DYE),
        CultivationThemes.PRODUCE,
        "Biscuit Dough",
        "Just remind yourself \"Don't eat it raw.\""
    );

    public static final SlimefunItemStack BISCUIT_BASE = Theme.themedSlimefunItemStack(
        "CLT_BISCUIT_BASE",
        new ItemStack(Material.OAK_TRAPDOOR),
        CultivationThemes.PRODUCE,
        "Biscuit Base",
        "Just 'cause it's flat now doesnt mean",
        "you can eat it raw."
    );

    public static final SlimefunItemStack MEATBALLS = Theme.themedSlimefunItemStack(
        "CLT_MEATBALLS",
        new ItemStack(Material.BROWN_DYE),
        CultivationThemes.PRODUCE,
        "Meatballs",
        "Balls of meat, who'd-a-thunk it."
    );

    // endregion

    // region Finished Foods

    public static final SlimefunItemStack FOOD_PEANUT_BUTTER_JELLY_SANDWICH = Theme.themedSlimefunItemStack(
        "CLT_PEANUT_BUTTER_JELLY_SANDWICH",
        Skins.PEANUT_BUTTER_JELLY_SANDWICH.getPlayerHead(),
        CultivationThemes.FOOD,
        "Peanut Butter Jelly Sandwich",
        "It really is the pinnacle of sandwich technology.",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "5 Hearts"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Power + 3")
    );

    public static final SlimefunItemStack EGG_SALAD_SANDWICH = Theme.themedSlimefunItemStack(
        "CLT_EGG_SALAD_SANDWICH",
        Skins.CHEESY_SANDWICH.getPlayerHead(),
        CultivationThemes.FOOD,
        "Egg Salad Sandwich",
        "Smells a bit, but tastes amazing!",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "5 Hearts"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Haste + 2")
    );

    public static final SlimefunItemStack BACON_SANDWICH = Theme.themedSlimefunItemStack(
        "CLT_BACON_SANDWICH",
        Skins.MEATY_SANDWICH.getPlayerHead(),
        CultivationThemes.FOOD,
        "Bacon Sandwich",
        "A simple classic!",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "2 Hearts"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Power + 1"),
        Theme.CLICK_INFO.asTitle("Effect 2", "Speed + 1")
    );

    public static final SlimefunItemStack SALMON_NIGIRI = Theme.themedSlimefunItemStack(
        "CLT_SALMON_NIGIRI",
        Skins.SUSHI_SALMON.getPlayerHead(),
        CultivationThemes.FOOD,
        "Salmon Nigiri",
        "A delightful yet subtle flavour.",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "2 Hearts"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Regen + 1")
    );

    public static final SlimefunItemStack CAJUN_GARLIC_BUTTER_COD = Theme.themedSlimefunItemStack(
        "CLT_CAJUN_GARLIC_BUTTER_COD",
        Skins.MEAL_RED_GREEN_BROWN.getPlayerHead(),
        CultivationThemes.FOOD,
        "Cajun Garlic Butter Cod",
        "A very simple dish busting with flavour.",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "4 Hearts"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Regen + 2"),
        Theme.CLICK_INFO.asTitle("Effect 2", "Speed + 1")
    );

    public static final SlimefunItemStack SHAKSHUKA = Theme.themedSlimefunItemStack(
        "CLT_SHAKSHUKA",
        Skins.SHAKSHUKA.getPlayerHead(),
        CultivationThemes.FOOD,
        "Shakshuka",
        "A heart warming dish with eggs for days.",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "4 Hearts"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Hero of the Village + 1"),
        Theme.CLICK_INFO.asTitle("Effect 2", "Luck + 1")
    );

    public static final SlimefunItemStack FUGU = Theme.themedSlimefunItemStack(
        "CLT_FUGU",
        Skins.SUSHI_TUNA.getPlayerHead(),
        CultivationThemes.FOOD,
        "Fugu",
        "Ready to roll the dice?",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "1 Hearts"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Power + 5"),
        Theme.CLICK_INFO.asTitle("Effect 2", "33% Chance to just die!")
    );

    public static final SlimefunItemStack SHEPHERDS_PIE = Theme.themedSlimefunItemStack(
        "CLT_SHEPHERDS_PIE",
        Skins.MEAL_YELLOW_RED_BROWN.getPlayerHead(),
        CultivationThemes.FOOD,
        "Shepherds Pie",
        "Warm, hearty and simply wonderful.",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "10 Hearts"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Regen + 2")
    );

    public static final SlimefunItemStack CHICKEN_POT_PIE = Theme.themedSlimefunItemStack(
        "CLT_CHICKEN_POT_PIE",
        Skins.PIE_BROWN.getPlayerHead(),
        CultivationThemes.FOOD,
        "Chicken Pot Pie",
        "A warming meal that really hits home.",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "10 Hearts"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Jump + 2"),
        Theme.CLICK_INFO.asTitle("Effect 2", "Saturation + 1")
    );

    public static final SlimefunItemStack CHICKEN_PASTA_BAKE = Theme.themedSlimefunItemStack(
        "CLT_CHICKEN_PASTA_BAKE",
        Skins.PASTA_BAKE.getPlayerHead(),
        CultivationThemes.FOOD,
        "Chicken Pasta Bake",
        "A student staple.",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "5 Hearts"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Night Vision + 1"),
        Theme.CLICK_INFO.asTitle("Effect 2", "Water Breathing + 1")
    );

    public static final SlimefunItemStack CHICKEN_ALFREDO_MAC_AND_CHEESE = Theme.themedSlimefunItemStack(
        "CLT_CHICKEN_ALFREDO_MAC_AND_CHEESE",
        Skins.MAC_AND_CHEESE.getPlayerHead(),
        CultivationThemes.FOOD,
        "Chicken Alfredo Mac and Cheese",
        "A posh twist on a common classic.",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "1 Hearts"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Fire Resistance + 2"),
        Theme.CLICK_INFO.asTitle("Effect 2", "Damage Resistance + 3")
    );

    public static final SlimefunItemStack KEY_LIME_PIE = Theme.themedSlimefunItemStack(
        "CLT_KEY_LIME_PIE",
        Skins.PIE_LIME.getPlayerHead(),
        CultivationThemes.FOOD,
        "Key Lime Pie",
        "Simply the best!",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "6 Hearts"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Haste + 4")
    );

    public static final SlimefunItemStack FRUIT_SALAD = Theme.themedSlimefunItemStack(
        "CLT_FRUIT_SALAD",
        Skins.FRUIT_SALAD.getPlayerHead(),
        CultivationThemes.FOOD,
        "Fruit Salad",
        "If you call it a salad, you can eat as much",
        "as you like, 'cause it's healthy.",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "2 Hearts"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Speed + 3")
    );

    public static final SlimefunItemStack CAESAR_SALAD = Theme.themedSlimefunItemStack(
        "CLT_CAESAR_SALAD",
        Skins.FRUIT_SALAD.getPlayerHead(),
        CultivationThemes.FOOD,
        "Caesar Salad",
        "A healthy classic.",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "4 Hearts"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Speed + 1"),
        Theme.CLICK_INFO.asTitle("Effect 2", "Invisibility + 1"),
        Theme.CLICK_INFO.asTitle("Effect 3", "Slow Falling + 1")
    );

    public static final SlimefunItemStack BISCUIT = Theme.themedSlimefunItemStack(
        "CLT_BISCUIT",
        new ItemStack(Material.COOKIE),
        CultivationThemes.FOOD,
        "Biscuit",
        "A little snack with a huge taste.",
        "",
        Theme.CLICK_INFO.asTitle("Effect 1", "Launches you into the air")
    );

    public static final SlimefunItemStack COMPRESSED_BISCUIT = Theme.themedSlimefunItemStack(
        "CLT_COMPRESSED_BISCUIT",
        new ItemStack(Material.COOKIE),
        CultivationThemes.FOOD,
        "Compressed Biscuit",
        "A little snack with a huge-er taste.",
        "",
        Theme.CLICK_INFO.asTitle("Effect 1", "Launches you into the air")
    );

    public static final SlimefunItemStack LEMON_DROP = Theme.themedSlimefunItemStack(
        "CLT_LEMON_DROP",
        new ItemStack(Material.YELLOW_DYE),
        CultivationThemes.FOOD,
        "Lemon Drop",
        "A palette cleanser.",
        "",
        Theme.CLICK_INFO.asTitle("Effect 1", "Clears all effects and makes you hungry again.")
    );

    public static final SlimefunItemStack GRILLED_SALMON_SALAD = Theme.themedSlimefunItemStack(
        "CLT_GRILLED_SALMON_SALAD",
        Skins.MEAL_SALAD.getPlayerHead(),
        CultivationThemes.FOOD,
        "Grilled Salmon Salad",
        "Delightfully flaky and brilliantly seasoned.",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "4 Hearts"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Regeneration + 1"),
        Theme.CLICK_INFO.asTitle("Effect 2", "Health Boost + 5")
    );

    public static final SlimefunItemStack WITHER_ROSE_SALAD = Theme.themedSlimefunItemStack(
        "CLT_WITHER_ROSE_SALAD",
        Skins.MEAL_SALAD.getPlayerHead(),
        CultivationThemes.FOOD,
        "Wither Rose Salad",
        "Teeming with power but with a harsh side-effect.",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "Full"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Health Boost + 20"),
        Theme.CLICK_INFO.asTitle("Effect 2", "Wither + 2")
    );

    public static final SlimefunItemStack ORANGE_JUICE = Theme.themedSlimefunItemStack(
        "CLT_ORANGE_JUICE",
        ItemStackGenerators.createPotion(Color.YELLOW),
        CultivationThemes.FOOD,
        "Orange Juice",
        "It really is the best way to start the day.",
        "",
        Theme.CLICK_INFO.asTitle("Effect 1", "Speed + 4")
    );

    public static final SlimefunItemStack LASAGNA = Theme.themedSlimefunItemStack(
        "CLT_LASAGNA",
        Skins.MEAL_YELLOW_RED_BROWN.getPlayerHead(),
        CultivationThemes.FOOD,
        "Lasagna",
        "Layers of awesomeness.",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "Full"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Regeneration + 1"),
        Theme.CLICK_INFO.asTitle("Effect 2", "Damage Reduction + 1")
    );

    public static final SlimefunItemStack SPAGHETTI = Theme.themedSlimefunItemStack(
        "CLT_SPAGHETTI",
        Skins.SPAGHETTI.getPlayerHead(),
        CultivationThemes.FOOD,
        "Spaghetti",
        "Just keep slurping.",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "1 Heart")
    );

    public static final SlimefunItemStack SPAGHETTI_AND_MEATBALLS = Theme.themedSlimefunItemStack(
        "CLT_SPAGHETTI_AND_MEATBALLS",
        Skins.SPAGHETTI.getPlayerHead(),
        CultivationThemes.FOOD,
        "Spaghetti and Meatballs",
        "Simple, classic and hearty.",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "4 Heart"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Bad Omen + 1")
    );

    // end region
}
