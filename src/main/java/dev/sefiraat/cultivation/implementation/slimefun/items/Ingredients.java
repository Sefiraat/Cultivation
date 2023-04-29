package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.api.slimefun.items.produce.ByProduct;
import dev.sefiraat.cultivation.api.slimefun.items.produce.ProduceCore;
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
        new ItemStack[]{
            Products.PEANUT.getBlended().getItem(), new ItemStack(Material.SUGAR), SlimefunItems.BUTTER,
            null, null, null,
            null, null, null
        }
    ).buildRegister(Cultivation.getInstance());

    public static final ByProduct GRAPE_JELLY = new ByProduct(
        CultivationStacks.GRAPE_JELLY,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            Products.GRAPE.getBlended().getItem(), new ItemStack(Material.SUGAR), null,
            null, null, null,
            null, null, null
        }
    ).buildRegister(Cultivation.getInstance());

    public static final ByProduct STRAWBERRY_JELLY = new ByProduct(
        CultivationStacks.STRAWBERRY_JELLY,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            Products.STRAWBERRY.getBlended().getItem(), new ItemStack(Material.SUGAR), null,
            null, null, null,
            null, null, null
        }
    ).buildRegister(Cultivation.getInstance());

    public static final ByProduct MAYONNAISE = new ByProduct(
        CultivationStacks.MAYONNAISE,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            Products.RAPESEED.getGround().getItem(), new ItemStack(Material.EGG), null,
            null, null, null,
            null, null, null
        }
    ).buildRegister(Cultivation.getInstance());

    public static final ByProduct EGG_SALAD = new ByProduct(
        CultivationStacks.EGG_SALAD,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            Products.EGG.getBoiled().getItem(), Ingredients.MAYONNAISE.getItem(), null,
            null, null, null,
            null, null, null
        }
    ).buildRegister(Cultivation.getInstance());

    public static final ByProduct PIE_CRUST = new ByProduct(
        CultivationStacks.PIE_CRUST,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            new ItemStack(Material.MILK_BUCKET), Products.EGG.getBlendedItem(), SlimefunItems.WHEAT_FLOUR,
            null, null, null,
            null, null, null
        }
    ).buildRegister(Cultivation.getInstance());

    public static final ByProduct PASTA = new ByProduct(
        CultivationStacks.PASTA,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            SlimefunItems.WHEAT_FLOUR, Products.EGG.getBlendedItem(), null,
            null, null, null,
            null, null, null
        }
    ).buildRegister(Cultivation.getInstance());

    public static final ByProduct BISCUIT_DOUGH = new ByProduct(
        CultivationStacks.BISCUIT_DOUGH,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            SlimefunItems.WHEAT_FLOUR, new ItemStack(Material.SUGAR), SlimefunItems.BUTTER,
            new ItemStack(Material.MILK_BUCKET), null, null,
            null, null, null
        }
    ).buildRegister(Cultivation.getInstance());

    public static final ByProduct BISCUIT_BASE = new ByProduct(
        CultivationStacks.BISCUIT_BASE,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            BISCUIT_DOUGH.getItem(), BISCUIT_DOUGH.getItem(), BISCUIT_DOUGH.getItem(),
            null, null, null,
            null, null, null
        }
    ).buildRegister(Cultivation.getInstance());

    public static final ByProduct MEATBALLS = new ByProduct(
        CultivationStacks.MEATBALLS,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            Products.BEEF.getGroundItem(), Products.EGG.getBlendedItem(), null,
            SlimefunItems.WHEAT_FLOUR, SlimefunItems.SALT, null,
            null, null, null
        }
    ).buildRegister(Cultivation.getInstance());

    public static final ProduceCore PEPPERONI = new ProduceCore(
        CultivationGroups.BY_PRODUCTS,
        CultivationStacks.PEPPERONI,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            Products.PORK.getGroundItem(), Products.GARLIC.getGroundItem(), Products.CAYENNE_PEPPER.getGroundItem(),
            Products.MUSTARD_SEEDS.getGroundItem(), SlimefunItems.SALT, null,
            null, null, null
        }
    ).buildRegister(Cultivation.getInstance());

    public static final ByProduct DOUGH = new ByProduct(
        CultivationStacks.DOUGH,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            SlimefunItems.WHEAT_FLOUR, SlimefunItems.WHEAT_FLOUR, new ItemStack(Material.EGG),
            new ItemStack(Material.WATER_BUCKET), SlimefunItems.SALT, null,
            null, null, null
        }
    ).buildRegister(Cultivation.getInstance());

    public static final ByProduct CREAM_CHEESE = new ByProduct(
        CultivationStacks.CREAM_CHEESE,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            new ItemStack(Material.MILK_BUCKET), SlimefunItems.SALT, Products.LEMON.getBlendedItem(),
            null, null, null,
            null, null, null
        }
    ).buildRegister(Cultivation.getInstance());

    public static final ByProduct KETCHUP = new ByProduct(
        CultivationStacks.KETCHUP,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            Products.TOMATO.getBlendedItem(), new ItemStack(Material.SUGAR), null,
            null, null, null,
            null, null, null
        }
    ).buildRegister(Cultivation.getInstance());

    public static final ByProduct MUSTARD = new ByProduct(
        CultivationStacks.MUSTARD,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            Products.MUSTARD_SEEDS.getBlendedItem(), new ItemStack(Material.WATER_BUCKET), SlimefunItems.SALT,
            Products.THYME.getChoppedItem(), Products.TURMERIC.getChoppedItem(), new ItemStack(Material.SUGAR),
            null, null, null
        }
    ).buildRegister(Cultivation.getInstance());

    public static final ByProduct TORTILLAS = new ByProduct(
        CultivationStacks.TORTILLAS,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            Products.SWEETCORN.getGroundItem(), Products.SWEETCORN.getGroundItem(), Products.SWEETCORN.getGroundItem(),
            null, null, null,
            null, null, null
        }
    ).buildRegister(Cultivation.getInstance());

    public static final ByProduct PICO_DE_GALLO = new ByProduct(
        CultivationStacks.PICO_DE_GALLO,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            Products.TOMATO.getChoppedItem(), Products.CHILLI_PEPPER.getChoppedItem(), Products.ONION.getChoppedItem(),
            Products.LIME.getBlendedItem(), Products.CILANTRO.getChoppedItem(), null,
            null, null, null
        }
    ).buildRegister(Cultivation.getInstance());

    // endregion

    public static void setup(Cultivation addon) {

    }
}
