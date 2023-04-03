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

    // endregion
}
