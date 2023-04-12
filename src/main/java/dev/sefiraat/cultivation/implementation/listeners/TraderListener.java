package dev.sefiraat.cultivation.implementation.listeners;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.Registry;
import dev.sefiraat.cultivation.api.slimefun.items.bushes.CultivationBush;
import dev.sefiraat.cultivation.api.slimefun.items.produce.ByProduct;
import dev.sefiraat.cultivation.api.slimefun.items.trees.CultivationTree;
import dev.sefiraat.cultivation.implementation.slimefun.items.Tools;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.VillagerCareerChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class TraderListener implements Listener {

    @EventHandler
    public void onWanderingTraderSpawn(@Nonnull EntitySpawnEvent event) {
        if (event.getEntity() instanceof WanderingTrader trader) {
            List<MerchantRecipe> recipes = new ArrayList<>(trader.getRecipes());
            addBreedingRecipe(recipes);
            addBushRecipe(recipes);
            trader.setRecipes(recipes);
        }
    }

    @EventHandler
    public void onVillagerChangesProfession(@Nonnull VillagerCareerChangeEvent event) {
        Villager villager = event.getEntity();
        if (event.getProfession() == Villager.Profession.FARMER) {
            Bukkit.getScheduler().runTaskLater(
                Cultivation.getInstance(), () -> addRecipe(villager, this::addBushRecipe),
                1
            );
        } else if (event.getProfession() == Villager.Profession.FLETCHER) {
            Bukkit.getScheduler().runTaskLater(
                Cultivation.getInstance(), () -> addRecipe(villager, this::addTreeRecipe),
                1
            );
        } else if (event.getProfession() == Villager.Profession.CLERIC) {
            Bukkit.getScheduler().runTaskLater(
                Cultivation.getInstance(), () -> addRecipe(villager, this::addByProductRecipe),
                1
            );
        }
    }

    private void addRecipe(@Nonnull Villager villager, @Nonnull Consumer<List<MerchantRecipe>> consumer) {
        List<MerchantRecipe> recipes = new ArrayList<>(villager.getRecipes());
        consumer.accept(recipes);
        villager.setRecipes(recipes);
    }

    private void addBreedingRecipe(@Nonnull List<MerchantRecipe> recipes) {
        ItemStack randomItem = Tools.RECIPE_UNLOCK.generateRandomRecipeUnlock();
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

    private void addTreeRecipe(@Nonnull List<MerchantRecipe> recipes) {
        int randomUpper = Registry.getInstance().getRegisteredTrees().size();
        int random = ThreadLocalRandom.current().nextInt(randomUpper);
        CultivationTree tree = Registry.getInstance().getRegisteredTrees().get(random);
        ItemStack itemStack = tree.getItem().clone();
        MerchantRecipe merchantRecipe = new MerchantRecipe(itemStack, 1);
        merchantRecipe.addIngredient(new ItemStack(Material.GOLD_INGOT, 64));
        recipes.add(merchantRecipe);
    }

    private void addByProductRecipe(@Nonnull List<MerchantRecipe> recipes) {
        for (int i = 0; i < 3; i++) {
            int randomUpper = Registry.getInstance().getRegisteredByProducts().size();
            int random = ThreadLocalRandom.current().nextInt(randomUpper);
            ByProduct byProduct = Registry.getInstance().getRegisteredByProducts().get(random);
            ItemStack itemStack = byProduct.getItem().clone();
            MerchantRecipe merchantRecipe = new MerchantRecipe(itemStack, 4);
            merchantRecipe.addIngredient(new ItemStack(Material.EMERALD, 1));
            recipes.add(merchantRecipe);
        }
    }
}
