package dev.sefiraat.cultivation.implementation.slimefun.tools;

import dev.sefiraat.cultivation.api.slimefun.items.bushes.CultivationBush;
import dev.sefiraat.sefilib.slimefun.items.RefillableUseItem;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class TrimmingTool extends RefillableUseItem {
    public TrimmingTool(ItemGroup group, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(group, item, recipeType, recipe);
    }
    
    @NotNull
    @Override
    public ItemUseHandler getItemHandler() {
        return playerRightClickEvent -> {
            if (playerRightClickEvent.getClickedBlock().isEmpty()) {
                // No block preset
                return;
            }
    
            Block block = playerRightClickEvent.getClickedBlock().get();
            SlimefunItem item = BlockStorage.check(block);
    
            if (item instanceof CultivationBush trimmable && trimmable.isMature(block)) {
                ItemStack trimmingResult = trimmable.getTrimmingResult();
                trimmable.updateGrowthStage(block, 1);
                block.getWorld().dropItem(block.getLocation(), trimmingResult.clone());
            }
    
            damageItem(playerRightClickEvent.getPlayer(), playerRightClickEvent.getItem());
        };
    }
}
