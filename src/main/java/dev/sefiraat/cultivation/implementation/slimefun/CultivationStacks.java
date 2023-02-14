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

    // region Crafting Materials
    public static final SlimefunItemStack STONE_PLANT = Theme.themedSlimefunItemStack(
        "CLT_STONE_PLANT",
        PlantSkin.SEED_CYAN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Stone",
        List.of(
            "A plant that sits in stoney silence",
            "awaiting anything nearby to peak",
            "it's interest"
        )
    );

    // endregion

    // region Plants
    public static final SlimefunItemStack BERRY_BUSH = Theme.themedSlimefunItemStack(
        "CLT_BERRY_BUSH",
        Material.SWEET_BERRY_BUSH,
        CultivationThemes.PLANT,
        "Cultivation Plant: Stone",
        "A plant that sits in stoney silence",
        "awaiting anything nearby to peak",
        "it's interest"
    );

    // endregion

    // region Bushes
    public static final SlimefunItemStack HARVESTING_TOOL_SIMPLE = Theme.themedSlimefunItemStack(
        "CLT_ADDON_BERRY",
        Material.SHEARS,
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

    // endregion

    // region Tools

    private CultivationStacks() {
        throw new IllegalStateException("Utility class");
    }

    // endregion

}
