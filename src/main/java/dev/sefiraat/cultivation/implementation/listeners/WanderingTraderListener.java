package dev.sefiraat.cultivation.implementation.listeners;

import dev.sefiraat.cultivation.implementation.slimefun.items.CultivationTools;
import org.bukkit.Material;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class WanderingTraderListener implements Listener {

    @EventHandler
    public void onWanderingTraderSpawn(@Nonnull EntitySpawnEvent event) {
        if (event.getEntity() instanceof WanderingTrader trader) {
            ItemStack randomItem = CultivationTools.RECIPE_UNLOCK.generateRandomRecipeUnlock();
            MerchantRecipe merchantRecipe = new MerchantRecipe(randomItem, 1);
            merchantRecipe.addIngredient(new ItemStack(Material.EMERALD, 64));
            List<MerchantRecipe> recipes = new ArrayList<>(trader.getRecipes());
            recipes.add(merchantRecipe);
            trader.setRecipes(recipes);

        }
    }
}
