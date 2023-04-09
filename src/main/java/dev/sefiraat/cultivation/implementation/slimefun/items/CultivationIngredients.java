package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.slimefun.items.produce.CultivationByProduct;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class CultivationIngredients {

    private CultivationIngredients() {
        throw new IllegalStateException("Utility class");
    }

    // region Custom Registrations

    public static final CultivationByProduct PEANUT_BUTTER = new CultivationByProduct(
        CultivationStacks.PEANUT_BUTTER,
        RecipeTypes.FINISHING,
        RecipeTypes.createFoodFinishingRecipe(
            CultivationStacks.PEANUT_BUTTER,
            new ItemStack[]{
                CultivationProducts.PEANUT.getBlended().getItem(), new ItemStack(Material.SUGAR), SlimefunItems.BUTTER,
                null, null, null,
                null, null, null
            }
        )
    );

    public static final CultivationByProduct GRAPE_JELLY = new CultivationByProduct(
        CultivationStacks.GRAPE_JELLY,
        RecipeTypes.FINISHING,
        RecipeTypes.createFoodFinishingRecipe(
            CultivationStacks.GRAPE_JELLY,
            new ItemStack[]{
                CultivationProducts.GRAPE.getBlended().getItem(), new ItemStack(Material.SUGAR), null,
                null, null, null,
                null, null, null
            }
        )
    );

    public static final CultivationByProduct STRAWBERRY_JELLY = new CultivationByProduct(
        CultivationStacks.STRAWBERRY_JELLY,
        RecipeTypes.FINISHING,
        RecipeTypes.createFoodFinishingRecipe(
            CultivationStacks.STRAWBERRY_JELLY,
            new ItemStack[]{
                CultivationProducts.STRAWBERRY.getBlended().getItem(), new ItemStack(Material.SUGAR), null,
                null, null, null,
                null, null, null
            }
        )
    );

    // endregion

    public static void setup(Cultivation addon) {
        PEANUT_BUTTER.register(addon);
        GRAPE_JELLY.register(addon);
        STRAWBERRY_JELLY.register(addon);
    }
}
