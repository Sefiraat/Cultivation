package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
import dev.sefiraat.cultivation.implementation.slimefun.tools.CropSticks;
import dev.sefiraat.cultivation.implementation.slimefun.tools.RecipeUnlock;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class CultivationTools {

    public static final RecipeUnlock RECIPE_UNLOCK = new RecipeUnlock();

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
                new ItemStack(Material.STICK), new ItemStack(Material.STICK), null,
                null, null, null
            }
        ).register(addon);

        RECIPE_UNLOCK.register(addon);
    }
}
