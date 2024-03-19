package dev.sefiraat.cultivation.api.slimefun.items.plants;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.datatypes.instances.FloraLevelProfile;
import dev.sefiraat.cultivation.api.interfaces.CultivationHarvestable;
import dev.sefiraat.cultivation.api.slimefun.plant.Growth;
import dev.sefiraat.cultivation.api.slimefun.plant.PlantTheme;
import dev.sefiraat.cultivation.implementation.slimefun.tools.HarvestingTool;
import dev.sefiraat.cultivation.implementation.utils.Keys;
import io.github.bakedlibs.dough.collections.RandomizedSet;
import io.github.bakedlibs.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemSetting;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.settings.DoubleRangeSetting;
import io.github.thebusybiscuit.slimefun4.api.items.settings.IntRangeSetting;
import io.papermc.lib.PaperLib;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

/**
 * This plant can be harvested by right-clicking with a {@link HarvestingTool}
 * dropping the provided ItemStack into the world.
 * The plant then reverts to its first stage in its {@link PlantTheme}
 */
public class HarvestablePlant extends CultivationPlant implements CultivationHarvestable {

    private static final String KEY_GROWTH_RATE = "growth-rate";
    private final RandomizedSet<ItemStack> harvestItems = new RandomizedSet<>();
    private final Map<Location, ItemStack> nextDrop = new HashMap<>();

    @ParametersAreNonnullByDefault
    public HarvestablePlant(SlimefunItemStack item, Growth growth) {
        super(item, growth);
        addItemSetting(new DoubleRangeSetting(this, KEY_GROWTH_RATE, 0.001, growth.getGrowthRate(), 1D));
        Optional<ItemSetting<Double>> doubleOptional = getItemSetting(KEY_GROWTH_RATE, double.class);
        doubleOptional.ifPresent(doubleItemSetting -> this.growth.setGrowthRate(doubleItemSetting.getValue()));
    }

    @Nonnull
    public HarvestablePlant addHarvestingResult(@Nonnull ItemStack harvestStack) {
        return addHarvestingResult(harvestStack, 1);
    }

    @Nonnull
    public HarvestablePlant addHarvestingResult(@Nonnull ItemStack harvestStack, int weight) {
        String amountKey = "drop-" + harvestStack.getType().name().toLowerCase(Locale.ROOT) + "-amount";
        String weightKey = "drop-" + harvestStack.getType().name().toLowerCase(Locale.ROOT) + "-weight";
        int defaultAmount = harvestStack.getAmount();

        addItemSetting(new IntRangeSetting(this, amountKey, 1, defaultAmount, 64));
        addItemSetting(new IntRangeSetting(this, weightKey, 1, weight, 999));

        Optional<ItemSetting<Integer>> setAmount = getItemSetting(amountKey, int.class);
        Optional<ItemSetting<Integer>> setWeight = getItemSetting(weightKey, int.class);

        int finalAmount = setAmount.map(ItemSetting::getValue).orElse(defaultAmount);
        int finalWeight = setWeight.map(ItemSetting::getValue).orElse(weight);

        harvestStack.setAmount(finalAmount);

        this.harvestItems.add(harvestStack, finalWeight);
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
        harvest(block);
    }

    public void harvest(@Nonnull Block block) {
        if (this.isMature(block)) {
            updateGrowthStage(block, 1);
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
    public void updateGrowthStage(@Nonnull Block block, int growthStage) {
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
                growItems(block.getLocation(), new ItemStack(Material.AIR));
            }
            hideItems(block.getLocation());
            block.setType(Material.AIR);
        } else if (growthStage == 2) {
            ItemStack itemStack = getRandomItemWithDropModifier(block.getLocation());
            if (itemStack != null) {
                nextDrop.put(block.getLocation(), itemStack);
                growItems(block.getLocation(), itemStack.clone());
            }
        }
        BlockStorage.addBlockInfo(block, Keys.FLORA_GROWTH_STAGE, String.valueOf(growthStage));
    }

    @Nonnull
    @Override
    public RandomizedSet<ItemStack> getHarvestingResults() {
        return this.harvestItems;
    }

    @Nullable
    public ItemStack getRandomItemWithDropModifier(@Nonnull Location location) {
        FloraLevelProfile profile = getLevelProfile(location);
        return getRandomItemWithDropModifier(profile);
    }

    @Nullable
    public ItemStack getRandomItemWithDropModifier(@Nonnull FloraLevelProfile profile) {
        ItemStack itemStack = this.harvestItems.getRandom();

        if (itemStack == null) {
            return null;
        }

        ItemStack clone = itemStack.clone();

        int amount = clone.getAmount();
        int adjustedAmount = getDropAmount(profile.getLevel(), amount);

        clone.setAmount(adjustedAmount);
        return clone;
    }

    public int getDropAmount(int level, int defaultAmount) {
        return (int) defaultAmount + (defaultAmount * (level / 5));
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
