package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
import dev.sefiraat.cultivation.implementation.slimefun.tools.CropSticks;
import dev.sefiraat.cultivation.implementation.slimefun.tools.HarvestingTool;
import dev.sefiraat.cultivation.implementation.slimefun.tools.TrimmingTool;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class CultivationTools {

    private CultivationTools() {
        throw new IllegalStateException("Utility class");
    }

    public static void setup(Cultivation addon) {

        new CropSticks(
            CultivationGroups.TOOLS,
            CultivationStacks.CROP_STICKS,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                new ItemStack(Material.STICK), new ItemStack(Material.STICK), null,
                new ItemStack(Material.STICK), null, new ItemStack(Material.STICK),
                null, null, null
            }
        ).register(addon);

        new HarvestingTool(
            CultivationGroups.TOOLS,
            CultivationStacks.HARVESTING_TOOL_SIMPLE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                CultivationStacks.MYSTICAL_LOG, CultivationStacks.MYSTICAL_LOG, CultivationStacks.MYSTICAL_LOG,
                CultivationStacks.MYSTICAL_LOG, null, CultivationStacks.MYSTICAL_LOG,
                null, CultivationStacks.MYSTICAL_LOG, null
            },
            50
        ).register(addon);

        new TrimmingTool(
            CultivationGroups.TOOLS,
            CultivationStacks.TRIMMING_TOOL_SIMPLE,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                null, CultivationStacks.MYSTICAL_LOG, new ItemStack(Material.IRON_INGOT),
                CultivationStacks.MYSTICAL_LOG, null, null,
                null, CultivationStacks.MYSTICAL_LOG, new ItemStack(Material.IRON_INGOT)
            },
            50
        ).register(addon);
    }
}
