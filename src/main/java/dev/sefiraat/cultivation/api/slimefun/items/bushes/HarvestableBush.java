package dev.sefiraat.cultivation.api.slimefun.items.bushes;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.interfaces.CultivationHarvestable;
import dev.sefiraat.cultivation.api.slimefun.plant.Growth;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * This plant can be harvested by right-clicking with an open hand
 * The plant then reverts to its first stage.
 */
public class HarvestableBush extends CultivationBush implements CultivationHarvestable {

    @Nullable
    private ItemStack harvestItemStack;

    @ParametersAreNonnullByDefault
    public HarvestableBush(SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Growth growth) {
        super(item, recipeType, recipe, growth);
    }

    @Nonnull
    public HarvestableBush setHarvestingResult(@Nonnull ItemStack harvestStack) {
        this.harvestItemStack = harvestStack;
        return this;
    }

    @Nullable
    @Override
    public ItemStack getHarvestingResult() {
        return this.harvestItemStack;
    }

    @Override
    public boolean isHarvestReady(@NotNull Location location) {
        return this.isMature(location);
    }

    @Override
    protected void updateGrowthStage(@NotNull Block block, int growthStage) {
        // TODO to be added as part of bush development
    }

    @Override
    @OverridingMethodsMustInvokeSuper
    protected boolean validateFlora() {
        if (this.harvestItemStack == null) {
            Cultivation.logWarning(this.getId() + " has no ItemStack for harvesting, it will not be registered.");
            return false;
        }
        return true;
    }
}
