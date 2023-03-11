package dev.sefiraat.cultivation.api.slimefun.items.plants;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.interfaces.CultivationHarvestable;
import dev.sefiraat.cultivation.api.slimefun.plant.Growth;
import dev.sefiraat.cultivation.api.slimefun.plant.GrowthStages;
import dev.sefiraat.cultivation.implementation.slimefun.tools.HarvestingTool;
import io.github.bakedlibs.dough.collections.RandomizedSet;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * This plant can be harvested by right-clicking with a {@link HarvestingTool}
 * dropping the provided ItemStack into the world.
 * The plant then reverts to its first stage in its {@link GrowthStages}
 */
public class HarvestablePlant extends CultivationPlant implements CultivationHarvestable {

    private final RandomizedSet<ItemStack> harvestItems = new RandomizedSet<>();

    @ParametersAreNonnullByDefault
    public HarvestablePlant(SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Growth growth) {
        super(item, recipeType, recipe, growth);
    }

    @ParametersAreNonnullByDefault
    public HarvestablePlant(SlimefunItemStack item, Growth growth) {
        super(item, growth);
    }

    @Nonnull
    public HarvestablePlant addHarvestingResult(@Nonnull ItemStack harvestStack) {
        return addHarvestingResult(harvestStack, 1);
    }

    @Nonnull
    public HarvestablePlant addHarvestingResult(@Nonnull ItemStack harvestStack, int weight) {
        this.harvestItems.add(harvestStack, weight);
        return this;
    }

    @Override
    public RandomizedSet<ItemStack> getHarvestingResults() {
        return this.harvestItems;
    }

    @Override
    @OverridingMethodsMustInvokeSuper
    protected boolean validateFlora() {
        if (this.harvestItems.isEmpty()) {
            Cultivation.logWarning(this.getId() + " has no ItemStack(s) for harvesting, it will not be registered.");
            return false;
        }
        return true;
    }
}
