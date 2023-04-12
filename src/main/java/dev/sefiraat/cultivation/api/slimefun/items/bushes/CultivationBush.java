package dev.sefiraat.cultivation.api.slimefun.items.bushes;

import dev.sefiraat.cultivation.Registry;
import dev.sefiraat.cultivation.api.interfaces.CultivationBushHolder;
import dev.sefiraat.cultivation.api.interfaces.CultivationFlora;
import dev.sefiraat.cultivation.api.interfaces.CultivationTrimmable;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.api.slimefun.items.CultivationFloraItem;
import dev.sefiraat.cultivation.api.slimefun.plant.Growth;
import dev.sefiraat.cultivation.implementation.slimefun.tools.TrimmingTool;
import dev.sefiraat.sefilib.entity.display.DisplayInteractable;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.OverridingMethodsMustInvokeSuper;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

/**
 * This bush can be trimmed by right-clicking a {@link TrimmingTool}
 * dropping the provided ItemStack into the world.
 * This class is used to define a Bush that will grow as a {@link CultivationFlora}
 */
public abstract class CultivationBush extends CultivationFloraItem<CultivationBush>
    implements CultivationFlora, CultivationTrimmable, CultivationBushHolder, DisplayInteractable {

    @ParametersAreNonnullByDefault
    protected CultivationBush(SlimefunItemStack item, Growth growth) {
        super(CultivationGroups.BUSHES, item, RecipeTypes.TRADING_FARMER, new ItemStack[0], null, growth);
    }

    @Override
    public void preRegister() {
        super.preRegister();
        addItemHandler(
            new BlockBreakHandler(false, false) {
                @Override
                @ParametersAreNonnullByDefault
                public void onPlayerBreak(BlockBreakEvent blockBreakEvent, ItemStack itemStack, List<ItemStack> list) {
                    onBreak(blockBreakEvent);
                }
            }
        );
    }

    @Override
    public int getMaxGrowthStages() {
        return 3;
    }

    @OverridingMethodsMustInvokeSuper
    protected void onBreak(@NotNull BlockBreakEvent event) {
        removeBush(event.getBlock().getLocation());
    }

    @Override
    public CultivationBush tryRegister(@NotNull SlimefunAddon addon) {
        Registry.getInstance().addBush(this);
        return super.tryRegister(addon);
    }
}
