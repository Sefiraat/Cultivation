package dev.sefiraat.cultivation.implementation.slimefun.tools;

import dev.sefiraat.cultivation.api.interfaces.CultivationCroppable;
import dev.sefiraat.sefilib.slimefun.items.RefillableUseItem;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class CropSticks extends SlimefunItem implements NotPlaceable {

    /**
     * Creates a new {@link RefillableUseItem}.
     *
     * @param group      The {@link ItemGroup} this item belongs to.
     * @param item       The {@link SlimefunItemStack} that is used to create this item.
     * @param recipeType The {@link RecipeType} of this item.
     * @param recipe     The recipe of this item.
     */
    public CropSticks(ItemGroup group, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(group, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        addItemHandler(getItemHandler());
    }

    @Nonnull
    public ItemUseHandler getItemHandler() {
        return playerRightClickEvent -> {
            if (playerRightClickEvent.getClickedBlock().isEmpty()) {
                // No block preset
                return;
            }

            Block block = playerRightClickEvent.getClickedBlock().get();
            SlimefunItem item = BlockStorage.check(block);

            if (item instanceof CultivationCroppable croppable && croppable.incrementCrop(block.getLocation())) {
                Player player = playerRightClickEvent.getPlayer();
                player.swingMainHand();
                if (player.getGameMode() != GameMode.CREATIVE) {
                    player.getItemInUse().setAmount(player.getItemInUse().getAmount() - 1);
                }
            }
        };
    }
}
