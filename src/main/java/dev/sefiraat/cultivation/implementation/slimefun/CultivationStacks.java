package dev.sefiraat.cultivation.implementation.slimefun;

import dev.sefiraat.cultivation.api.slimefun.plant.PlantSkin;
import dev.sefiraat.cultivation.api.utils.CultivationThemes;
import dev.sefiraat.sefilib.itemstacks.ItemStackGenerators;
import dev.sefiraat.sefilib.string.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.collections.Pair;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

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

    // region Plants

    public static final SlimefunItemStack PLANT_DARKNESS = Theme.themedSlimefunItemStack(
        "CLT_PLANT_DARKNESS",
        PlantSkin.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Darkness",
        List.of(
            "A plant that seethes in unbridled",
            "rage."
        )
    );

    public static final SlimefunItemStack PLANT_LIGHT = Theme.themedSlimefunItemStack(
        "CLT_PLANT_LIGHT",
        PlantSkin.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Light",
        List.of(
            "A plant that exudes an aura",
            "of pure love."
        )
    );

    public static final SlimefunItemStack PLANT_EARTH = Theme.themedSlimefunItemStack(
        "CLT_PLANT_EARTH",
        PlantSkin.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Earth",
        List.of(
            "A plant that enriches the world",
            "surrounding it."
        )
    );

    public static final SlimefunItemStack PLANT_WATER = Theme.themedSlimefunItemStack(
        "CLT_PLANT_WATER",
        PlantSkin.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Water",
        List.of(
            "A plant that nurtures and provides",
            "life to the surrounding area."
        )
    );

    public static final SlimefunItemStack PLANT_FIRE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_FIRE",
        PlantSkin.SEED_RED.getPlayerHead(),
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
        PlantSkin.SEED_CYAN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Air",
        List.of(
            "A plant that quietly hums with",
            "the melody of the surrounding nature."
        )
    );

    public static final SlimefunItemStack PLANT_POWER = Theme.themedSlimefunItemStack(
        "CLT_PLANT_POWER",
        PlantSkin.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Power",
        List.of(
            "A plant that positively exudes power."
        )
    );

    public static final SlimefunItemStack PLANT_WEALTH = Theme.themedSlimefunItemStack(
        "CLT_PLANT_WEALTH",
        PlantSkin.SEED_ORANGE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Wealth",
        List.of(
            "A plant that just screams exuberant wealth."
        )
    );

    public static final SlimefunItemStack PLANT_SPECTRUM = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SPECTRUM",
        PlantSkin.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Spectrum",
        List.of(
            "A plant that slightly shifts it's color."
        )
    );

    public static final SlimefunItemStack PLANT_DIRT = Theme.themedSlimefunItemStack(
        "CLT_PLANT_DIRT",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Dirt",
        List.of(
            "Dirty on the surface but holding the",
            "building blocks for life itself."
        )
    );

    public static final SlimefunItemStack PLANT_GRASS = Theme.themedSlimefunItemStack(
        "CLT_PLANT_GRASS",
        PlantSkin.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Grass",
        List.of(
            "The burgeoning life bound fourth",
            "from the ground."
        )
    );

    public static final SlimefunItemStack PLANT_FLOWER = Theme.themedSlimefunItemStack(
        "CLT_PLANT_FLOWER",
        PlantSkin.SEED_ORANGE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Flowering",
        List.of(
            "A beautiful cornucopia presented well."
        )
    );

    public static final SlimefunItemStack PLANT_VINE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_VINE",
        PlantSkin.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Vine",
        List.of(
            "A plant that instantly tangles itself",
            "up."
        )
    );

    public static final SlimefunItemStack PLANT_SAND = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SAND",
        PlantSkin.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Sand",
        List.of(
            "This plant can sometimes crumble apart",
            "at a single touch."
        )
    );

    public static final SlimefunItemStack PLANT_RED_SAND = Theme.themedSlimefunItemStack(
        "CLT_PLANT_RED_SAND",
        PlantSkin.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Red Sand",
        List.of(
            "This plant can sometimes crumble apart",
            "at a single touch - but... red-er."
        )
    );

    public static final SlimefunItemStack PLANT_MOSS = Theme.themedSlimefunItemStack(
        "CLT_PLANT_MOSS",
        PlantSkin.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Moss",
        List.of(
            "This plant tends to spread uncontrollably."
        )
    );

    public static final SlimefunItemStack PLANT_SAPLING = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SAPLING",
        PlantSkin.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Sapling",
        List.of(
            "This plant doesn't even make sense..."
        )
    );

    public static final SlimefunItemStack PLANT_MUSHROOM = Theme.themedSlimefunItemStack(
        "CLT_PLANT_MUSHROOM",
        PlantSkin.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Mushroom",
        List.of(
            "Yup, a plant that makes mushrooms.",
            "Everything is totally normal over here."
        )
    );

    public static final SlimefunItemStack PLANT_WITHER_ROSE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_WITHER_ROSE",
        PlantSkin.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Wither Rose",
        List.of(
            "This plant, somehow, pulsates a harmful",
            "aura around itself."
        )
    );

    public static final SlimefunItemStack PLANT_DARK_FLORA = Theme.themedSlimefunItemStack(
        "CLT_PLANT_DARK_FLORA",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Dark Flora",
        List.of(
            "A silent evil sits within this simple seed."
        )
    );

    public static final SlimefunItemStack PLANT_GLOWING_VINE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_GLOWING_VINE",
        PlantSkin.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Glowing Vine",
        List.of(
            "A faint light emits from within this seed."
        )
    );

    public static final SlimefunItemStack PLANT_DIM_LIT = Theme.themedSlimefunItemStack(
        "CLT_PLANT_DIM_LIT",
        PlantSkin.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Dim Lit",
        List.of(
            "A very dim light emits from within this seed."
        )
    );

    public static final SlimefunItemStack PLANT_COW = Theme.themedSlimefunItemStack(
        "CLT_PLANT_COW",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
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
        PlantSkin.SEED_CYAN.getPlayerHead(),
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
        PlantSkin.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Fish",
        List.of(
            "A ripe smell emanates from this seed."
        )
    );

    public static final SlimefunItemStack PLANT_TURTLE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_TURTLE",
        PlantSkin.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Turtle",
        List.of(
            "A seed surrounded by a rock hard shell."
        )
    );

    public static final SlimefunItemStack PLANT_VILLAGER = Theme.themedSlimefunItemStack(
        "CLT_PLANT_VILLAGER",
        PlantSkin.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Villager",
        List.of(
            "Yup, we condensed the essence of a villager",
            "into a plant. Apparently it hurt a lot."
        )
    );

    public static final SlimefunItemStack PLANT_RABBIT = Theme.themedSlimefunItemStack(
        "CLT_PLANT_RABBIT",
        PlantSkin.SEED_ORANGE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Rabbit",
        List.of(
            "Bugs would be proud."
        )
    );

    public static final SlimefunItemStack PLANT_SHEEP = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SHEEP",
        PlantSkin.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Sheep",
        List.of(
            "A plant with a coarse woolly texture."
        )
    );

    public static final SlimefunItemStack PLANT_PIG = Theme.themedSlimefunItemStack(
        "CLT_PLANT_PIG",
        PlantSkin.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Pig",
        List.of(
            "A plant that snorts randomly."
        )
    );

    public static final SlimefunItemStack PLANT_BEE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_BEE",
        PlantSkin.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Bee",
        List.of(
            "A plant with a very small, delicate, set of wings."
        )
    );

    public static final SlimefunItemStack PLANT_SQUID = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SQUID",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
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
        PlantSkin.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Glow Squid",
        List.of(
            "A glittering plant with a faint glow."
        )
    );

    public static final SlimefunItemStack PLANT_FROG = Theme.themedSlimefunItemStack(
        "CLT_PLANT_FROG",
        PlantSkin.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Frog",
        List.of(
            "Ribbit!"
        )
    );

    public static final SlimefunItemStack PLANT_GOAT = Theme.themedSlimefunItemStack(
        "CLT_PLANT_GOAT",
        PlantSkin.SEED_ORANGE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Goat",
        List.of(
            "A randomly violent plant that loves",
            "to jump around."
        )
    );

    public static final SlimefunItemStack PLANT_RAINBOW = Theme.themedSlimefunItemStack(
        "CLT_PLANT_RAINBOW",
        PlantSkin.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Rainbow",
        List.of(
            "There may or may not be a pot of gold",
            "at the end of this plant."
        )
    );

    public static final SlimefunItemStack PLANT_WAXY = Theme.themedSlimefunItemStack(
        "CLT_PLANT_WAXY",
        PlantSkin.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Waxy",
        List.of(
            "The sap from this plant forms into",
            "perfect candle shaped wax."
        )
    );

    public static final SlimefunItemStack PLANT_WOOLLY = Theme.themedSlimefunItemStack(
        "CLT_PLANT_WOOLLY",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Woolly",
        List.of(
            "A woolly plant, from root to petals!."
        )
    );

    public static final SlimefunItemStack PLANT_TERRA = Theme.themedSlimefunItemStack(
        "CLT_PLANT_TERRA",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Terra",
        List.of(
            "A hard earthy plant that cracks under pressure."
        )
    );

    public static final SlimefunItemStack PLANT_GLAZED = Theme.themedSlimefunItemStack(
        "CLT_PLANT_GLAZED",
        PlantSkin.SEED_ORANGE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Glazed",
        List.of(
            "A plant that grows with an intricate design."
        )
    );

    public static final SlimefunItemStack PLANT_DUSTY = Theme.themedSlimefunItemStack(
        "CLT_PLANT_DUSTY",
        PlantSkin.SEED_YELLOW.getPlayerHead(),
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
        PlantSkin.SEED_CYAN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Concrete",
        List.of(
            "This plant struggle to grow as it",
            "hardens so quickly."
        )
    );

    public static final SlimefunItemStack PLANT_STAINED = Theme.themedSlimefunItemStack(
        "CLT_PLANT_STAINED",
        PlantSkin.SEED_CYAN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Stained",
        List.of(
            "This plant splits light into a veritable",
            "spectrum to nearby objects."
        )
    );

    public static final SlimefunItemStack PLANT_COBBLESTONE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_COBBLESTONE",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Cobblestone",
        List.of(
            "This plant is hard as a rock."
        )
    );

    public static final SlimefunItemStack PLANT_GRAVEL = Theme.themedSlimefunItemStack(
        "CLT_PLANT_GRAVEL",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Gravel",
        List.of(
            "This plant really doesn't know how",
            "to keep itself together."
        )
    );

    public static final SlimefunItemStack PLANT_CLAY = Theme.themedSlimefunItemStack(
        "CLT_PLANT_CLAY",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
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
        PlantSkin.SEED_BLUE.getPlayerHead(),
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
        PlantSkin.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Deepslate",
        List.of(
            "Deep, slatey, <insert lore here>."
        )
    );

    public static final SlimefunItemStack PLANT_REINFORCED = Theme.themedSlimefunItemStack(
        "CLT_PLANT_REINFORCED",
        PlantSkin.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Reinforced",
        List.of(
            "A plant that is able to hold itself up",
            "through anything."
        )
    );

    public static final SlimefunItemStack PLANT_BLACKSTONE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_BLACKSTONE",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Blackstone",
        List.of(
            "A plant that has been known to absorb light."
        )
    );

    public static final SlimefunItemStack PLANT_NETHERRACK = Theme.themedSlimefunItemStack(
        "CLT_PLANT_NETHERRACK",
        PlantSkin.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Netherrack",
        List.of(
            "A tough hardy plant able to survive",
            "in most locales."
        )
    );

    public static final SlimefunItemStack PLANT_DARK_GRASS = Theme.themedSlimefunItemStack(
        "CLT_PLANT_DARK_GRASS",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Dark Grass",
        List.of(
            "A plant that has really lost it's",
            "identity."
        )
    );

    public static final SlimefunItemStack PLANT_MAGMA = Theme.themedSlimefunItemStack(
        "CLT_PLANT_MAGMA",
        PlantSkin.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Magma",
        List.of(
            "A plant that's so hot it burns it's",
            "surroundings."
        )
    );

    public static final SlimefunItemStack PLANT_SOUL = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SOUL",
        PlantSkin.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Soul",
        List.of(
            "A plant that can be heard screaming",
            "when its quiet."
        )
    );

    public static final SlimefunItemStack PLANT_BASALT = Theme.themedSlimefunItemStack(
        "CLT_PLANT_BASALT",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Basalt",
        List.of(
            "A very boring and dull plant."
        )
    );

    public static final SlimefunItemStack PLANT_GLASS = Theme.themedSlimefunItemStack(
        "CLT_PLANT_GLASS",
        PlantSkin.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Glass",
        List.of(
            "At the right angle, you could",
            "swear you can see through this plant."
        )
    );

    public static final SlimefunItemStack PLANT_MUD = Theme.themedSlimefunItemStack(
        "CLT_PLANT_MUD",
        PlantSkin.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Mud",
        List.of(
            "A plant that is nearly as dirty as",
            "the ground it comes from."
        )
    );

    public static final SlimefunItemStack PLANT_END_STONE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_END_STONE",
        PlantSkin.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: End Stone",
        List.of(
            "A plant that hums with the void."
        )
    );

    public static final SlimefunItemStack PLANT_PURPUR = Theme.themedSlimefunItemStack(
        "CLT_PLANT_PURPUR",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Purpur",
        List.of(
            "An odd plant, seems far lighter",
            "than most."
        )
    );

    public static final SlimefunItemStack PLANT_COAL = Theme.themedSlimefunItemStack(
        "CLT_PLANT_COAL",
        PlantSkin.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Coal",
        List.of(
            "A plant that holds such potential."
        )
    );

    public static final SlimefunItemStack PLANT_RAW_IRON = Theme.themedSlimefunItemStack(
        "CLT_PLANT_RAW_IRON",
        PlantSkin.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Raw Iron",
        List.of(
            "A sturdy plant able to withstand most",
            "environments."
        )
    );

    public static final SlimefunItemStack PLANT_RAW_COPPER = Theme.themedSlimefunItemStack(
        "CLT_PLANT_RAW_COPPER",
        PlantSkin.SEED_ORANGE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Raw Copper",
        List.of(
            "If left alone, this plant sometimes",
            "attracts lightning."
        )
    );

    public static final SlimefunItemStack PLANT_RAW_GOLD = Theme.themedSlimefunItemStack(
        "CLT_PLANT_RAW_GOLD",
        PlantSkin.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Raw Gold",
        List.of(
            "This plant is commonly stolen by piglins",
            "if nearby."
        )
    );

    public static final SlimefunItemStack PLANT_REDSTONE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_REDSTONE",
        PlantSkin.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Redstone",
        List.of(
            "A plant brimming with power throughout."
        )
    );

    public static final SlimefunItemStack PLANT_LAPIS = Theme.themedSlimefunItemStack(
        "CLT_PLANT_LAPIS",
        PlantSkin.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Lapis",
        List.of(
            "A plant with a faint magical aura."
        )
    );

    public static final SlimefunItemStack PLANT_DIAMOND = Theme.themedSlimefunItemStack(
        "CLT_PLANT_DIAMOND",
        PlantSkin.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Diamond",
        List.of(
            "A plant that just speaks of riches."
        )
    );

    public static final SlimefunItemStack PLANT_EMERALD = Theme.themedSlimefunItemStack(
        "CLT_PLANT_EMERALD",
        PlantSkin.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Emerald",
        List.of(
            "Owners of this plant have to jump",
            "through hoops just to be able to afford it."
        )
    );

    public static final SlimefunItemStack PLANT_NETHER_QUARTZ = Theme.themedSlimefunItemStack(
        "CLT_PLANT_NETHER_QUARTZ",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Nether Quartz",
        List.of(
            "This plant has thorns so sharp that",
            "it's hard to work with."
        )
    );

    public static final SlimefunItemStack PLANT_SCRAPPY = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SCRAPPY",
        PlantSkin.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Scrappy",
        List.of(
            "This plant really is the pinnacle of",
            "horticulturalism."
        )
    );

    public static final SlimefunItemStack PLANT_AMETHYST = Theme.themedSlimefunItemStack(
        "CLT_PLANT_AMETHYST",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Amethyst",
        List.of(
            "This plant loves to flourish in deep, dark",
            "locales."
        )
    );

    public static final SlimefunItemStack PLANT_ECHO = Theme.themedSlimefunItemStack(
        "CLT_PLANT_ECHO",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Echo",
        List.of(
            "This plant always knows how to find",
            "its way home."
        )
    );

    public static final SlimefunItemStack PLANT_SKELETON = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SKELETON",
        PlantSkin.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Skeleton",
        List.of(
            "A plant that rattles as it sways."
        )
    );

    public static final SlimefunItemStack PLANT_SPIDER = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SPIDER",
        PlantSkin.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Spider",
        List.of(
            "Kill it, kill it NAO!"
        )
    );

    public static final SlimefunItemStack PLANT_CREEPER = Theme.themedSlimefunItemStack(
        "CLT_PLANT_CREEPER",
        PlantSkin.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Creeper",
        List.of(
            "Tsssssssssttt..."
        )
    );

    public static final SlimefunItemStack PLANT_ZOMBIE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_ZOMBIE",
        PlantSkin.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Zombie",
        List.of(
            "This plant is dripping... something..."
        )
    );

    public static final SlimefunItemStack PLANT_DROWNED = Theme.themedSlimefunItemStack(
        "CLT_PLANT_DROWNED",
        PlantSkin.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Drowned",
        List.of(
            "A Plant that is dripping wet, all",
            "the time."
        )
    );

    public static final SlimefunItemStack PLANT_GUARDIAN = Theme.themedSlimefunItemStack(
        "CLT_PLANT_GUARDIAN",
        PlantSkin.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Guardian",
        List.of(
            "When touched, this plant releases",
            "spines."
        )
    );

    public static final SlimefunItemStack PLANT_ELDER_GUARDIAN = Theme.themedSlimefunItemStack(
        "CLT_PLANT_ELDER_GUARDIAN",
        PlantSkin.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Elder Guardian",
        List.of(
            "Being near this plants makes people",
            "sluggish."
        )
    );

    public static final SlimefunItemStack PLANT_GHAST = Theme.themedSlimefunItemStack(
        "CLT_PLANT_GHAST",
        PlantSkin.SEED_YELLOW.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Ghast",
        List.of(
            "A plant that has been known to",
            "randomly shoot fire balls."
        )
    );

    public static final SlimefunItemStack PLANT_SLIME = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SLIME",
        PlantSkin.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Slime",
        List.of(
            "Why is it so sticky?"
        )
    );

    public static final SlimefunItemStack PLANT_MAGMA_CUBE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_MAGMA_CUBE",
        PlantSkin.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Magma Cube",
        List.of(
            "When not being watched, this plant",
            "likes to bounce up and down."
        )
    );

    public static final SlimefunItemStack PLANT_BLAZE = Theme.themedSlimefunItemStack(
        "CLT_PLANT_BLAZE",
        PlantSkin.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Blaze",
        List.of(
            "A plant that is scorched around the edges."
        )
    );

    public static final SlimefunItemStack PLANT_WITHER_SKELETON = Theme.themedSlimefunItemStack(
        "CLT_PLANT_WITHER_SKELETON",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Wither Skeleton",
        List.of(
            "A plant known to be elusive and hardy."
        )
    );

    public static final SlimefunItemStack PLANT_WITHER = Theme.themedSlimefunItemStack(
        "CLT_PLANT_WITHER",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Wither",
        List.of(
            "A deadly plant that must be treated",
            "with care."
        )
    );

    public static final SlimefunItemStack PLANT_PHANTOM = Theme.themedSlimefunItemStack(
        "CLT_PLANT_PHANTOM",
        PlantSkin.SEED_BLUE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Phantom",
        List.of(
            "A plant with lofty leaves."
        )
    );

    public static final SlimefunItemStack PLANT_SHULKER = Theme.themedSlimefunItemStack(
        "CLT_PLANT_SHULKER",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Shulker",
        List.of(
            "A plant that often levitates off",
            "of the ground."
        )
    );

    public static final SlimefunItemStack PLANT_ENDERMAN = Theme.themedSlimefunItemStack(
        "CLT_PLANT_ENDERMAN",
        PlantSkin.SEED_GREEN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Enderman",
        List.of(
            "If not treated carefully, this plant",
            "may teleport randomly!"
        )
    );

    public static final SlimefunItemStack PLANT_ENDER_DRAGON = Theme.themedSlimefunItemStack(
        "CLT_PLANT_ENDER_DRAGON",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Ender Dragon",
        List.of(
            "A real boss of a plant."
        )
    );

    public static final SlimefunItemStack PLANT_WITCH = Theme.themedSlimefunItemStack(
        "CLT_PLANT_WITCH",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
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
        "CLT_HARVESTING_TOOL",
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
}
