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

    public static final SlimefunItemStack COBBLESTONE_PLANT = Theme.themedSlimefunItemStack(
        "CLT_STONE_PLANT",
        PlantSkin.SEED_CYAN.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Cobblestone",
        List.of(
            "A plant that sits in stoney silence",
            "awaiting anything nearby to peak",
            "it's interest."
        )
    );

    public static final SlimefunItemStack DIRT_PLANT = Theme.themedSlimefunItemStack(
        "CLT_DIRT_PLANT",
        PlantSkin.SEED_PURPLE.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Dirt",
        List.of(
            "A plant that holds the burgeoning power",
            "of nature itself."
        )
    );

    public static final SlimefunItemStack FURNACE_PLANT = Theme.themedSlimefunItemStack(
        "CLT_FURNACE_PLANT",
        PlantSkin.SEED_RED.getPlayerHead(),
        CultivationThemes.PLANT,
        "Cultivation Plant: Furnace",
        List.of(
            "A plant that somehow grew from",
            "inside of a furnace?"
        )
    );

    // endregion

    // region Bushes

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

    // region Tools
    
    public static final SlimefunItemStack CROP_STICKS = Theme.themedSlimefunItemStack(
        "CLT_CROP_STICKS",
        Material.STICK,
        CultivationThemes.TOOL,
        "Crop Stick",
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
