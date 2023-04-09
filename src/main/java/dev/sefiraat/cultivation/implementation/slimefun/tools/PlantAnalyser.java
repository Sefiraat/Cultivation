package dev.sefiraat.cultivation.implementation.slimefun.tools;

import dev.sefiraat.cultivation.api.datatypes.instances.FloraLevelProfile;
import dev.sefiraat.cultivation.api.interfaces.CultivationLevelProfileHolder;
import dev.sefiraat.sefilib.string.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class PlantAnalyser extends SimpleSlimefunItem<ItemUseHandler> implements NotPlaceable {

    public PlantAnalyser(ItemGroup group, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(group, item, recipeType, recipe);
    }

    @Nonnull
    @Override
    public ItemUseHandler getItemHandler() {
        return playerRightClickEvent -> {
            if (playerRightClickEvent.getClickedBlock().isEmpty()) {
                // No block preset
                return;
            }

            Block block = playerRightClickEvent.getClickedBlock().get();
            SlimefunItem item = BlockStorage.check(block);

            if (item instanceof CultivationLevelProfileHolder profileHolder) {
                FloraLevelProfile profile = profileHolder.getLevelProfile(block);
                Player player = playerRightClickEvent.getPlayer();
                player.sendMessage(Theme.CLICK_INFO.apply(item.getItemName()));
                player.sendMessage(Theme.CLICK_INFO.asTitle("Drop Level", profile.getLevel()));
                player.sendMessage(Theme.CLICK_INFO.asTitle("Growth Speed", profile.getSpeed()));
                player.sendMessage(Theme.CLICK_INFO.asTitle("Breed Strength", profile.getStrength()));
            }
        };
    }
}
