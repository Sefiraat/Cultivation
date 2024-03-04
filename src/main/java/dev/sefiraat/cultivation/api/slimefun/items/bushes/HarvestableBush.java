package dev.sefiraat.cultivation.api.slimefun.items.bushes;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.interfaces.CultivationHarvestable;
import dev.sefiraat.cultivation.api.slimefun.plant.Growth;
import dev.sefiraat.cultivation.implementation.utils.Keys;
import io.github.bakedlibs.dough.collections.RandomizedSet;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * This bush can be harvested by right-clicking with an open hand
 * The bush then reverts to its first stage.
 */
public class HarvestableBush extends CultivationBush implements CultivationHarvestable {

    /*
        TODO Plants and Bushes now behave so similarly they can likely be made generic.
            Remembering:
            Plants have LevelProfiles, bushes do not
            Max Growth Stages need to be taken better care of, while noting 0 and 1 have unique effects.
     */
    private final RandomizedSet<ItemStack> harvestItems = new RandomizedSet<>();

    private final Map<Location, ItemStack> nextDrop = new HashMap<>();

    @ParametersAreNonnullByDefault
    public HarvestableBush(SlimefunItemStack item, Growth growth) {
        super(item, growth);
    }

    @Override
    protected void onBlockUse(PlayerRightClickEvent event) {
        // shouldn't be possible, but just to be safe
        Optional<Block> blockOptional = event.getClickedBlock();
        if (blockOptional.isEmpty() || harvestItems.size() == 0) {
            return;
        }
        Block block = blockOptional.get();
        harvest(block);
    }

    public void harvest(@Nonnull Block block) {
        if (this.isMature(block)) {
            updateGrowthStage(block, 0);
            ItemStack itemStack = nextDrop.remove(block.getLocation());
            if (itemStack == null) {
                ItemStack drop = harvestItems.getRandom();
                if (drop != null) {
                    block.getWorld().dropItem(block.getLocation(), drop.clone());
                }
            } else {
                block.getWorld().dropItem(block.getLocation(), itemStack);
            }
        }
    }

    @Override
    public void whenPlaced(@NotNull BlockPlaceEvent event) {
        super.whenPlaced(event);
        addDisplayBush(event.getBlock().getLocation());
        event.getBlock().setType(Material.AIR);
    }

    @Nonnull
    public HarvestableBush addHarvestingResult(@Nonnull ItemStack harvestStack) {
        return addHarvestingResult(harvestStack, 1);
    }

    @Nonnull
    public HarvestableBush addHarvestingResult(@Nonnull ItemStack harvestStack, int weight) {
        this.harvestItems.add(harvestStack, weight);
        return this;
    }

    @Nonnull
    @Override
    public RandomizedSet<ItemStack> getHarvestingResults() {
        return this.harvestItems;
    }

    @Override
    public void updateGrowthStage(@NotNull Block block, int growthStage) {
        // todo Fuck numbers
        Location location = block.getLocation();
        setAge(location, growthStage);
        if (growthStage == 0) {
            hideItems(location);
        } else if (growthStage == 3) {
            ItemStack itemStack = getRandomItem();
            if (itemStack != null) {
                nextDrop.put(block.getLocation(), itemStack);
                growItems(block.getLocation(), itemStack.clone());
            }
        }
        BlockStorage.addBlockInfo(block, Keys.FLORA_GROWTH_STAGE, String.valueOf(growthStage));
    }

    @Nullable
    public ItemStack getRandomItem() {
        return this.harvestItems.getRandom().clone();
    }

    @Override
    @OverridingMethodsMustInvokeSuper
    protected boolean validateFlora() {
        if (this.harvestItems.size() == 0) {
            Cultivation.logWarning(this.getId() + " has no ItemStack for harvesting, it will not be registered.");
            return false;
        }
        return true;
    }
}
