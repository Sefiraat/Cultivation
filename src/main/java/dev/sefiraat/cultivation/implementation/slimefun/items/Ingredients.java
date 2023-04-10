package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.slimefun.items.produce.ByProduct;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class Ingredients {

    private Ingredients() {
        throw new IllegalStateException("Utility class");
    }

    // region Custom Registrations

    public static final ByProduct PEANUT_BUTTER = new ByProduct(
        CultivationStacks.PEANUT_BUTTER,
        RecipeTypes.FINISHING,
        RecipeTypes.createFoodFinishingRecipe(
            CultivationStacks.PEANUT_BUTTER,
            new ItemStack[]{
                Products.PEANUT.getBlended().getItem(), new ItemStack(Material.SUGAR), SlimefunItems.BUTTER,
                null, null, null,
                null, null, null
            }
        )
    ).buildRegister(Cultivation.getInstance());

    public static final ByProduct GRAPE_JELLY = new ByProduct(
        CultivationStacks.GRAPE_JELLY,
        RecipeTypes.FINISHING,
        RecipeTypes.createFoodFinishingRecipe(
            CultivationStacks.GRAPE_JELLY,
            new ItemStack[]{
                Products.GRAPE.getBlended().getItem(), new ItemStack(Material.SUGAR), null,
                null, null, null,
                null, null, null
            }
        )
    ).buildRegister(Cultivation.getInstance());

    public static final ByProduct STRAWBERRY_JELLY = new ByProduct(
        CultivationStacks.STRAWBERRY_JELLY,
        RecipeTypes.FINISHING,
        RecipeTypes.createFoodFinishingRecipe(
            CultivationStacks.STRAWBERRY_JELLY,
            new ItemStack[]{
                Products.STRAWBERRY.getBlended().getItem(), new ItemStack(Material.SUGAR), null,
                null, null, null,
                null, null, null
            }
        )
    ).buildRegister(Cultivation.getInstance());

    public static final ByProduct MAYONNAISE = new ByProduct(
        CultivationStacks.MAYONNAISE,
        RecipeTypes.FINISHING,
        RecipeTypes.createFoodFinishingRecipe(
            CultivationStacks.MAYONNAISE,
            new ItemStack[]{
                Products.RAPESEED.getGround().getItem(), new ItemStack(Material.EGG), null,
                null, null, null,
                null, null, null
            }
        )
    ).buildRegister(Cultivation.getInstance());

    public static final ByProduct EGG_SALAD = new ByProduct(
        CultivationStacks.EGG_SALAD,
        RecipeTypes.FINISHING,
        RecipeTypes.createFoodFinishingRecipe(
            CultivationStacks.EGG_SALAD,
            new ItemStack[]{
                Products.EGG.getBoiled().getItem(), Ingredients.MAYONNAISE.getItem(), null,
                null, null, null,
                null, null, null
            }
        )
    ).buildRegister(Cultivation.getInstance());

    // endregion

    public static void setup(Cultivation addon) {

    }
}
