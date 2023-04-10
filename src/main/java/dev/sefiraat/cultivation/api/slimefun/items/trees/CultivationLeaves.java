package dev.sefiraat.cultivation.api.slimefun.items.trees;

import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.sefilib.misc.Chance;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.List;

public class CultivationLeaves extends SlimefunItem {
    private final CultivationTree tree;

    public CultivationLeaves(CultivationTree tree) {
        super(
            CultivationGroups.HIDDEN_CONTENT,
            new SlimefunItemStack("CLT_LEAVES_" + tree.getId().substring(4),
                                  Material.ACACIA_LEAVES,
                                  "Cultivation Leaves"
            ),
            RecipeType.NULL,
            new ItemStack[0]
        );
        this.tree = tree;
    }

    @Override
    public void preRegister() {
        addItemHandler(
            new BlockBreakHandler(false, true) {
                @Override
                public void onPlayerBreak(BlockBreakEvent e, ItemStack item, List<ItemStack> drops) {
                    e.setDropItems(false);
                    if (Chance.testChance(0.2)) {
                        Block block = e.getBlock();
                        block.getWorld().dropItem(block.getLocation(), tree.getItem().clone());
                    }
                }
            }
        );
    }

    public CultivationLeaves buildRegister(@Nonnull SlimefunAddon addon) {
        register(addon);
        return this;
    }
}
