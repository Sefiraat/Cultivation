package dev.sefiraat.cultivation.implementation.slimefun;

import dev.sefiraat.cultivation.api.utils.CultivationThemes;
import dev.sefiraat.cultivation.api.utils.Skins;
import dev.sefiraat.sefilib.itemstacks.ItemStackGenerators;
import dev.sefiraat.sefilib.string.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.collections.Pair;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
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
        Theme.applyThemeAsTitle(Theme.CLICK_INFO, "Right Click", "Lets you know the species and growth details of a plant."),
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
        "Grows plants inside it automatically."
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

    // endregion

    // region Finished Foods

    public static final SlimefunItemStack FOOD_PEANUT_BUTTER_JELLY_SANDWICH = Theme.themedSlimefunItemStack(
        "CLT_PEANUT_BUTTER_JELLY_SANDWICH",
        Skins.PEANUT_BUTTER_JELLY_SANDWICH.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Peanut Butter Jelly Sandwich",
        "It really is the pinnacle of sandwich technology.",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "5 Hearts"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Power + 3")
    );

    public static final SlimefunItemStack EGG_SALAD_SANDWICH = Theme.themedSlimefunItemStack(
        "CLT_EGG_SALAD_SANDWICH",
        Skins.CHEESY_SANDWICH.getPlayerHead(),
        CultivationThemes.PRODUCE,
        "Egg Salad Sandwich",
        "Smells a bit, but tastes amazing!",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "5 Hearts"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Haste + 2")
    );

    public static final SlimefunItemStack BACON_SANDWICH = Theme.themedSlimefunItemStack(
        "CLT_BACON_SANDWICH",
        Skins.MEATY_SANDWICH.getPlayerHead(),
        CultivationThemes.PRODUCE,
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
        CultivationThemes.PRODUCE,
        "Salmon Nigiri",
        "A delightful yet subtle flavour.",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "2 Hearts"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Regen + 1")
    );

    public static final SlimefunItemStack CAJUN_GARLIC_BUTTER_COD = Theme.themedSlimefunItemStack(
        "CLT_CAJUN_GARLIC_BUTTER_COD",
        Skins.MEAL_RED_GREEN_BROWN.getPlayerHead(),
        CultivationThemes.PRODUCE,
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
        CultivationThemes.PRODUCE,
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
        CultivationThemes.PRODUCE,
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
        CultivationThemes.PRODUCE,
        "Shepherds Pie",
        "Warm, hearty and simply wonderful.",
        "",
        Theme.CLICK_INFO.asTitle("Healing", "10 Hearts"),
        Theme.CLICK_INFO.asTitle("Effect 1", "Regen + 2")
    );


    // end region

}
