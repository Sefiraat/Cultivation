package dev.sefiraat.cultivation.api.slimefun.items.plants;

import dev.sefiraat.cultivation.api.slimefun.plant.Growth;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.inventory.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * A plant that does nothing by itself. Used for breeding purposes only.
 */
public class NothingPlant extends CultivationPlant {

    @ParametersAreNonnullByDefault
    public NothingPlant(SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Growth growth) {
        super(item, recipeType, recipe, growth);
    }

    @ParametersAreNonnullByDefault
    public NothingPlant(SlimefunItemStack item, Growth growth) {
        super(item, growth);
    }

    @Override
    protected boolean validateFlora() {
        return true;
    }
}
