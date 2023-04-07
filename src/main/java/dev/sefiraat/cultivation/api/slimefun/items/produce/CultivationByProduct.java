package dev.sefiraat.cultivation.api.slimefun.items.produce;

import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import org.bukkit.inventory.ItemStack;

public class CultivationByProduct extends UnplaceableBlock {
    public CultivationByProduct(SlimefunItemStack item, RecipeType recipeType, ItemStack input) {
        super(CultivationGroups.BY_PRODUCTS, item, recipeType, new ItemStack[]{
            null, null, null,
            null, input, null,
            null, null, null
        });
    }
    public CultivationByProduct(SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(CultivationGroups.BY_PRODUCTS, item, recipeType, recipe);
    }
}
