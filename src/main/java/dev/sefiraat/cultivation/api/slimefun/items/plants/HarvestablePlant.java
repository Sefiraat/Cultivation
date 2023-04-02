package dev.sefiraat.cultivation.api.slimefun.items.plants;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.interfaces.CultivationHarvestable;
import dev.sefiraat.cultivation.api.slimefun.plant.Growth;
import dev.sefiraat.cultivation.api.slimefun.plant.PlantSkin;
import dev.sefiraat.cultivation.api.slimefun.plant.PlantTheme;
import dev.sefiraat.cultivation.implementation.slimefun.tools.HarvestingTool;
import dev.sefiraat.cultivation.implementation.utils.Keys;
import io.github.bakedlibs.dough.collections.RandomizedSet;
import io.github.bakedlibs.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.papermc.lib.PaperLib;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Optional;

/**
 * This plant can be harvested by right-clicking with a {@link HarvestingTool}
 * dropping the provided ItemStack into the world.
 * The plant then reverts to its first stage in its {@link PlantTheme}
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
    protected void onBlockUse(@NotNull PlayerRightClickEvent event) {
        // shouldn't be possible, but just to be safe
        Optional<Block> blockOptional = event.getClickedBlock();
        if (blockOptional.isEmpty() || harvestItems.size() == 0) {
            return;
        }
        Block block = blockOptional.get();
        if (this.isMature(block)) {
            updateGrowthStage(block, 1);
            block.getWorld().dropItem(block.getLocation(), harvestItems.getRandom().clone());
        }
    }

    @Override
    public void updateGrowthStage(@Nonnull Block block, int growthStage) {
        // todo Fuck numbers
        if (growthStage == 0) {
            PlantTheme theme = growth.getTheme();
            if (theme != null) {
                PlayerHead.setSkin(block, theme.getSeed().getPlayerSkin(), false);
                PaperLib.getBlockState(block, false).getState().update(true, false);
                growthDisplay(block.getLocation());
            }
        } else if (growthStage == 1) {
            if (!hasDisplayPlant(block)) {
                addDisplayPlant(block.getLocation());
            } else {
                removeItems(block.getLocation());
            }
            block.setType(Material.AIR);
        } else if (growthStage == 2) {
            ItemStack itemStack = this.harvestItems.getRandom();
            if (itemStack != null) {
                addItemsToDisplay(block.getLocation(), itemStack.getType());
            }
        }
        BlockStorage.addBlockInfo(block, Keys.FLORA_GROWTH_STAGE, String.valueOf(growthStage));
    }

    @Nonnull
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
