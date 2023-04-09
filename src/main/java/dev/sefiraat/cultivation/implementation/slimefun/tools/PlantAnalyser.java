package dev.sefiraat.cultivation.implementation.slimefun.tools;

import dev.sefiraat.cultivation.api.datatypes.instances.FloraLevelProfile;
import dev.sefiraat.cultivation.api.interfaces.CultivationBushHolder;
import dev.sefiraat.cultivation.api.interfaces.CultivationLevelProfileHolder;
import dev.sefiraat.cultivation.api.interfaces.CultivationPlantHolder;
import dev.sefiraat.cultivation.implementation.utils.DisplayGroupGenerators;
import dev.sefiraat.sefilib.entity.display.DisplayGroup;
import dev.sefiraat.sefilib.string.Theme;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

public class PlantAnalyser extends SimpleSlimefunItem<ItemUseHandler> implements NotPlaceable {

    public PlantAnalyser(ItemGroup group, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(group, item, recipeType, recipe);
    }

    @Nonnull
    @Override
    public ItemUseHandler getItemHandler() {
        return PlantAnalyser::onRightClick;
    }

    private static void onRightClick(PlayerRightClickEvent playerRightClickEvent) {
        if (playerRightClickEvent.getClickedBlock().isEmpty()) {
            // No block preset
            return;
        }

        Block block = playerRightClickEvent.getClickedBlock().get();
        SlimefunItem item = BlockStorage.check(block);

        if (item == null) {
            return;
        }

        if (playerRightClickEvent.getPlayer().isSneaking()) {
            applyName(item, block);
        } else {
            showStats(playerRightClickEvent, item, block);
        }
    }

    @ParametersAreNonnullByDefault
    private static void showStats(PlayerRightClickEvent event, SlimefunItem item, Block block) {
        if (item instanceof CultivationLevelProfileHolder profileHolder) {
            FloraLevelProfile profile = profileHolder.getLevelProfile(block);
            Player player = event.getPlayer();
            player.sendMessage(Theme.CLICK_INFO.apply(item.getItemName()));
            player.sendMessage(Theme.CLICK_INFO.asTitle("Drop Level", profile.getLevel()));
            player.sendMessage(Theme.CLICK_INFO.asTitle("Growth Speed", profile.getSpeed()));
            player.sendMessage(Theme.CLICK_INFO.asTitle("Breed Strength", profile.getStrength()));
        }
    }

    private static void applyName(@Nonnull SlimefunItem item, @Nonnull Block block) {
        DisplayGroup group = getGroup(item, block.getLocation());
        if (group == null) {
            return;
        }
        String name = item.getItemName();
        String[] split = name.split(":");
        if (split.length > 1) {
            name = split[1].trim();
        }

        if (DisplayGroupGenerators.hasName(group)) {
            DisplayGroupGenerators.removeNameFromGroup(group);
        } else {
            DisplayGroupGenerators.addNameToGroup(group, name);
        }
    }

    @Nullable
    private static DisplayGroup getGroup(@Nonnull SlimefunItem item, @Nonnull Location location) {
        if (item instanceof CultivationPlantHolder holder) {
            return holder.getPlantDisplayGroup(location);
        } else if (item instanceof CultivationBushHolder holder) {
            return holder.getBushDisplayGroup(location);
        }
        return null;
    }
}
