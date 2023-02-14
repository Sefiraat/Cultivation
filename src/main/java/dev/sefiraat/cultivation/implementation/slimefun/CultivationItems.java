package dev.sefiraat.cultivation.implementation.slimefun;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.api.slimefun.items.bushes.HarvestableBush;
import dev.sefiraat.cultivation.api.slimefun.items.plants.HarvestablePlant;
import dev.sefiraat.cultivation.api.slimefun.plant.CommonPlacements;
import dev.sefiraat.cultivation.api.slimefun.plant.Growth;
import dev.sefiraat.cultivation.api.slimefun.plant.GrowthStages;
import dev.sefiraat.cultivation.implementation.slimefun.tools.HarvestingTool;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class CultivationItems {

    private CultivationItems() {
        throw new IllegalStateException("Utility class");
    }

    public static void setup(Cultivation addon) {

        // region Crafting Materials

        new SlimefunItem(
            CultivationGroups.CRAFTING,
            CultivationStacks.MYSTICAL_LOG,
            RecipeType.ANCIENT_ALTAR,
            new ItemStack[]{
                null, SlimefunItems.AIR_RUNE, null,
                SlimefunItems.EARTH_RUNE, new ItemStack(Material.OAK_SAPLING), SlimefunItems.FIRE_RUNE,
                null, SlimefunItems.WATER_RUNE, null
            }
        ).register(addon);

        // endregion

        // region Plants

        new HarvestablePlant(
            CultivationStacks.STONE_PLANT,
            new Growth(
                GrowthStages.FUNGAL_CYAN,
                CommonPlacements.COMMON_OVERWORLD,
                0.1
            )
        ).setHarvestingResult(new ItemStack(Material.STONE))
            .tryRegister(addon);

        // endregion

        // region Bushes

        new HarvestableBush(
            CultivationStacks.BERRY_BUSH,
            RecipeTypes.BUSH_TRIMMING,
            new ItemStack[0],
            new Growth(
                null,
                CommonPlacements.COMMON_OVERWORLD,
                0.1
            )
        ).setHarvestingResult(new ItemStack(Material.SWEET_BERRIES))
            .tryRegister(addon);

        // endregion

        // region Tools

        new HarvestingTool(
            CultivationGroups.TOOLS,
            CultivationStacks.HARVESTING_TOOL_SIMPLE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                null, CultivationStacks.MYSTICAL_LOG, CultivationStacks.MYSTICAL_LOG,
                CultivationStacks.MYSTICAL_LOG, null, null,
                CultivationStacks.MYSTICAL_LOG, CultivationStacks.MYSTICAL_LOG, null
            },
            50
        ).register(addon);

        // endregion

    }

}
