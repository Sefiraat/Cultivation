package dev.sefiraat.cultivation.implementation.listeners;

import dev.sefiraat.cultivation.Registry;
import dev.sefiraat.cultivation.api.slimefun.items.bushes.CultivationBush;
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
import java.util.concurrent.ThreadLocalRandom;

public class WanderingTraderListener implements Listener {

    @EventHandler
    public void onWanderingTraderSpawn(@Nonnull EntitySpawnEvent event) {
        if (event.getEntity() instanceof WanderingTrader trader) {
            List<MerchantRecipe> recipes = new ArrayList<>(trader.getRecipes());
            addBreedingRecipe(recipes);
            addBushRecipe(recipes);
            trader.setRecipes(recipes);
        }
    }

    private void addBreedingRecipe(@Nonnull List<MerchantRecipe> recipes) {
        ItemStack randomItem = CultivationTools.RECIPE_UNLOCK.generateRandomRecipeUnlock();
        MerchantRecipe merchantRecipe = new MerchantRecipe(randomItem, 1);
        merchantRecipe.addIngredient(new ItemStack(Material.EMERALD, 64));
        recipes.add(merchantRecipe);
    }

    private void addBushRecipe(@Nonnull List<MerchantRecipe> recipes) {
        int randomUpper = Registry.getInstance().getRegisteredBushes().size();
        int random = ThreadLocalRandom.current().nextInt(randomUpper);
        CultivationBush bush = Registry.getInstance().getRegisteredBushes().get(random);
        ItemStack itemStack = bush.getItem().clone();
        MerchantRecipe merchantRecipe = new MerchantRecipe(itemStack, 1);
        merchantRecipe.addIngredient(new ItemStack(Material.DIAMOND, 20));
        recipes.add(merchantRecipe);
    }
}
