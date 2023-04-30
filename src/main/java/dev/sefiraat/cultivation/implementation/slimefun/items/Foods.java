package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.slimefun.items.produce.Food;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
import dev.sefiraat.sefilib.misc.Chance;
import dev.sefiraat.sefilib.misc.ParticleUtils;
import dev.sefiraat.sefilib.world.LocationUtils;
import io.github.bakedlibs.dough.collections.Pair;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Allay;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;

public final class Foods {

    private Foods() {
        throw new IllegalStateException("Utility class");
    }

    public static final Food LEMON_DROP = new Food(
        CultivationStacks.LEMON_DROP,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            Products.LEMON.getBoiledItem(), Products.SUGAR.getBoiledItem(), null,
            null, null, null,
            null, null, null
        },
        player -> {
            for (PotionEffect activePotionEffect : player.getActivePotionEffects()) {
                player.removePotionEffect(activePotionEffect.getType());
            }
        }
    ).overrideEatingMessage("You feel your palette being cleansed.")
        .buildRegister(Cultivation.getInstance());

    public static final Food PEANUT_BUTTER_JELLY_SANDWICH = new Food(
        CultivationStacks.FOOD_PEANUT_BUTTER_JELLY_SANDWICH,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            null, Products.BREAD.getSlicedItem(), null,
            Ingredients.GRAPE_JELLY.getItem(), Ingredients.PEANUT_BUTTER.getItem(), Ingredients.STRAWBERRY_JELLY.getItem(),
            null, Products.BREAD.getSlicedItem(), null
        },
        player -> simplePlayerEffect(
            player,
            10,
            new Pair<>(PotionEffectType.INCREASE_DAMAGE, 2)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final Food BACON_SANDWICH = new Food(
        CultivationStacks.BACON_SANDWICH,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            null, Products.BREAD.getSlicedItem(), null,
            null, Products.PORK.getFriedItem(), null,
            null, Products.BREAD.getSlicedItem(), null
        },
        player -> simplePlayerEffect(
            player,
            4,
            new Pair<>(PotionEffectType.INCREASE_DAMAGE, 0),
            new Pair<>(PotionEffectType.SPEED, 0)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final Food SALMON_NIGIRI = new Food(
        CultivationStacks.SALMON_NIGIRI,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            null, Products.SALMON.getSlicedItem(), null,
            null, Products.RICE.getBoiledItem(), null,
            null, null, null
        },
        player -> simplePlayerEffect(
            player,
            4,
            new Pair<>(PotionEffectType.REGENERATION, 0)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final Food CAJUN_GARLIC_BUTTER_COD = new Food(
        CultivationStacks.CAJUN_GARLIC_BUTTER_COD,
        RecipeTypes.BAKING,
        new ItemStack[]{
            Products.COD.getFriedItem(), SlimefunItems.BUTTER, null,
            Products.GARLIC.getChoppedItem(), Products.CAYENNE_PEPPER.getGroundItem(), null,
            null, null, null
        },
        player -> simplePlayerEffect(
            player,
            8,
            new Pair<>(PotionEffectType.REGENERATION, 1),
            new Pair<>(PotionEffectType.SPEED, 0)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final Food SHAKSHUKA = new Food(
        CultivationStacks.SHAKSHUKA,
        RecipeTypes.BAKING,
        new ItemStack[]{
            new ItemStack(Material.EGG), Products.ONION.getChoppedItem(), Products.BELL_PEPPER.getItem(),
            Products.GARLIC.getChoppedItem(), Products.BELL_PEPPER.getGroundItem(), Products.TOMATO.getItem(),
            null, null, null
        },
        player -> simplePlayerEffect(
            player,
            8,
            new Pair<>(PotionEffectType.HERO_OF_THE_VILLAGE, 0),
            new Pair<>(PotionEffectType.LUCK, 0)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final Food FUGU = new Food(
        CultivationStacks.FUGU,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            null, Products.PUFFERFISH.getSlicedItem(), null,
            null, Products.RICE.getBoiledItem(), null,
            null, null, null
        },
        player -> {
            if (Chance.testChance(0.33)) {
                player.damage(999);
            } else {
                simplePlayerEffect(player, 2, new Pair<>(PotionEffectType.INCREASE_DAMAGE, 4));
            }
        }
    ).buildRegister(Cultivation.getInstance());

    public static final Food SHEPHERDS_PIE = new Food(
        CultivationStacks.SHEPHERDS_PIE,
        RecipeTypes.BAKING,
        new ItemStack[]{
            SlimefunItems.CHEESE, Products.POTATO.getMashedItem(), SlimefunItems.CHEESE,
            Products.CARROT.getChoppedItem(), Products.PEA.getItem(), Products.ONION.getFriedItem(),
            Products.BEEF.getGroundItem(), Products.BEEF.getGroundItem(), Products.BEEF.getGroundItem()
        },
        player -> simplePlayerEffect(
            player,
            20,
            new Pair<>(PotionEffectType.REGENERATION, 1)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final Food EGG_SALAD_SANDWICH = new Food(
        CultivationStacks.EGG_SALAD_SANDWICH,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            null, Products.BREAD.getSlicedItem(), null,
            Products.LETTUCE.getChoppedItem(), Ingredients.EGG_SALAD.getItem(), Products.TOMATO.getSlicedItem(),
            null, Products.BREAD.getSlicedItem(), null
        },
        player -> simplePlayerEffect(
            player,
            20,
            new Pair<>(PotionEffectType.REGENERATION, 1)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final Food CHICKEN_POT_PIE = new Food(
        CultivationStacks.CHICKEN_POT_PIE,
        RecipeTypes.BAKING,
        new ItemStack[]{
            null, Ingredients.PIE_CRUST.getItem(), null,
            Products.CARROT.getChoppedItem(), Products.CHICKEN.getChoppedItem(), Products.ONION.getChoppedItem(),
            SlimefunItems.BUTTER, new ItemStack(Material.MILK_BUCKET), Products.MUSTARD_SEEDS.getGroundItem()
        },
        player -> simplePlayerEffect(
            player,
            20,
            new Pair<>(PotionEffectType.JUMP, 1),
            new Pair<>(PotionEffectType.SATURATION, 0)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final Food CHICKEN_PASTA_BAKE = new Food(
        CultivationStacks.CHICKEN_PASTA_BAKE,
        RecipeTypes.BAKING,
        new ItemStack[]{
            SlimefunItems.CHEESE, SlimefunItems.CHEESE, SlimefunItems.CHEESE,
            Ingredients.PASTA.getItem(), Ingredients.PASTA.getItem(), Ingredients.PASTA.getItem(),
            Products.GARLIC.getGroundItem(), new ItemStack(Material.MILK_BUCKET), Products.MUSTARD_SEEDS.getGroundItem()
        },
        player -> simplePlayerEffect(
            player,
            10,
            new Pair<>(PotionEffectType.NIGHT_VISION, 0),
            new Pair<>(PotionEffectType.WATER_BREATHING, 0)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final Food CHICKEN_ALFREDO_MAC_AND_CHEESE = new Food(
        CultivationStacks.CHICKEN_ALFREDO_MAC_AND_CHEESE,
        RecipeTypes.BAKING,
        new ItemStack[]{
            SlimefunItems.CHEESE, Products.BROCCOLI.getChoppedItem(), SlimefunItems.CHEESE,
            Ingredients.PASTA.getItem(), Products.CHICKEN.getSlicedItem(), Ingredients.PASTA.getItem(),
            Products.GARLIC.getGroundItem(), SlimefunItems.HEAVY_CREAM, Products.ONION.getChoppedItem()
        },
        player -> simplePlayerEffect(
            player,
            2,
            new Pair<>(PotionEffectType.FIRE_RESISTANCE, 1),
            new Pair<>(PotionEffectType.DAMAGE_RESISTANCE, 2)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final Food SUGARED_SKULL = new Food(
        CultivationStacks.SUGARED_SKULL,
        RecipeTypes.BAKING,
        new ItemStack[]{
            Products.SUGAR.getGroundItem(), Products.SUGAR.getGroundItem(), Products.SUGAR.getGroundItem(),
            null, new ItemStack(Material.SKELETON_SKULL), null,
            null, null, null
        },
        player -> simplePlayerEffect(player, 0, new Pair<>(PotionEffectType.DARKNESS, 2))
    ).buildRegister(Cultivation.getInstance());

    public static final Food KEY_LIME_PIE = new Food(
        CultivationStacks.KEY_LIME_PIE,
        RecipeTypes.BAKING,
        new ItemStack[]{
            Products.LIME.getBlendedItem(), SlimefunItems.HEAVY_CREAM, Products.LIME.getGroundItem(),
            new ItemStack(Material.SUGAR), new ItemStack(Material.EGG), SlimefunItems.BUTTER,
            Ingredients.BISCUIT_BASE.getItem(), Ingredients.BISCUIT_BASE.getItem(), Ingredients.BISCUIT_BASE.getItem(),
        },
        player -> simplePlayerEffect(
            player,
            12,
            new Pair<>(PotionEffectType.FAST_DIGGING, 3)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final Food TAQUITO = new Food(
        CultivationStacks.TAQUITO,
        RecipeTypes.BAKING,
        new ItemStack[]{
            SlimefunItems.CHEESE, Products.CHICKEN.getChoppedItem(), Ingredients.PICO_DE_GALLO.getItem(),
            Products.CUMIN.getGroundItem(), Products.CHILLI_PEPPER.getChoppedItem(), Products.BLACK_PEPPER.getGroundItem(),
            Ingredients.TORTILLAS.getItem(), Ingredients.TORTILLAS.getItem(), Ingredients.TORTILLAS.getItem(),
        },
        player -> {
            simplePlayerEffect(player, 8);
            Location location = LocationUtils.randomLocation(player.getLocation(), 2);
            IronGolem golem = (IronGolem) location.getWorld().spawnEntity(location, EntityType.IRON_GOLEM);
            golem.setPlayerCreated(true);
        }
    ).buildRegister(Cultivation.getInstance());

    public static final Food FRUIT_SALAD = new Food(
        CultivationStacks.FRUIT_SALAD,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            Products.APPLE.getChoppedItem(), Products.PEAR.getChoppedItem(), Products.ORANGE.getChoppedItem(),
            Products.KIWI.getChoppedItem(), Products.APRICOT.getChoppedItem(), Products.BANANA.getChoppedItem(),
            null, null, null
        },
        player -> simplePlayerEffect(
            player,
            12,
            new Pair<>(PotionEffectType.SPEED, 2)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final Food CAESAR_SALAD = new Food(
        CultivationStacks.CAESAR_SALAD,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            Products.TOMATO.getChoppedItem(), Products.LETTUCE.getChoppedItem(), Products.CHICKEN.getGrilledItem(),
            Products.RAPESEED.getGroundItem(), Products.BELL_PEPPER.getSlicedItem(), Products.MUSTARD_SEEDS.getBlendedItem(),
            null, null, null
        },
        player -> simplePlayerEffect(
            player,
            12,
            new Pair<>(PotionEffectType.SPEED, 0),
            new Pair<>(PotionEffectType.INVISIBILITY, 0),
            new Pair<>(PotionEffectType.SLOW_FALLING, 0)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final Food BOWL_OF_STEVE = new Food(
        CultivationStacks.BOWL_OF_STEVE,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            null, new ItemStack(Material.PLAYER_HEAD), null,
            Products.TOMATO.getSlicedItem(), Products.BELL_PEPPER.getSlicedItem(), Products.CUCUMBER.getSlicedItem(),
            Products.LETTUCE.getChoppedItem(), Products.LETTUCE.getChoppedItem(), Products.LETTUCE.getChoppedItem()
        },
        player -> {
            simplePlayerEffect(
                player,
                0,
                new Pair<>(PotionEffectType.SLOW_DIGGING, 9),
                new Pair<>(PotionEffectType.SLOW, 5),
                new Pair<>(PotionEffectType.INCREASE_DAMAGE, 9)
            );
            player.setHealth(1);
        }
    ).buildRegister(Cultivation.getInstance());

    public static final Food BISCUIT = new Food(
        CultivationStacks.BISCUIT,
        RecipeTypes.BAKING,
        new ItemStack[]{
            Ingredients.BISCUIT_DOUGH.getItem(), null, null,
            null, null, null,
            null, null, null
        },
        player -> player.setVelocity(new Vector(0, 3, 0))
    ).buildRegister(Cultivation.getInstance());

    public static final Food COMPRESSED_BISCUIT = new Food(
        CultivationStacks.COMPRESSED_BISCUIT,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            BISCUIT.getItem(), BISCUIT.getItem(), BISCUIT.getItem(),
            BISCUIT.getItem(), BISCUIT.getItem(), BISCUIT.getItem(),
            BISCUIT.getItem(), BISCUIT.getItem(), BISCUIT.getItem()
        },
        player -> player.setVelocity(new Vector(0, 5, 0))
    ).buildRegister(Cultivation.getInstance());

    public static final Food GRILLED_SALMON_SALAD = new Food(
        CultivationStacks.GRILLED_SALMON_SALAD,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            null, Products.SALMON.getGrilledItem(), null,
            Products.LETTUCE.getSlicedItem(), Products.LETTUCE.getSlicedItem(), Products.LETTUCE.getSlicedItem(),
            Products.TOMATO.getSlicedItem(), Products.RAPESEED.getGroundItem(), Products.RED_MUSHROOM.getSlicedItem()
        },
        player -> simplePlayerEffect(
            player,
            8,
            new Pair<>(PotionEffectType.REGENERATION, 0),
            new Pair<>(PotionEffectType.HEALTH_BOOST, 4)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final Food WITHER_ROSE_SALAD = new Food(
        CultivationStacks.WITHER_ROSE_SALAD,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            null, new ItemStack(Material.WITHER_ROSE), null,
            Products.LETTUCE.getSlicedItem(), Products.LETTUCE.getSlicedItem(), Products.LETTUCE.getSlicedItem(),
            Products.TOMATO.getSlicedItem(), Products.RAPESEED.getGroundItem(), Products.RED_MUSHROOM.getSlicedItem()
        },
        player -> {
            simplePlayerEffect(
                player,
                0,
                new Pair<>(PotionEffectType.WITHER, 1),
                new Pair<>(PotionEffectType.HEALTH_BOOST, 19)
            );
            simplePlayerEffect(player, 999);
        }
    ).buildRegister(Cultivation.getInstance());

    public static final Food ORANGE_JUICE = new Food(
        CultivationStacks.ORANGE_JUICE,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            Products.ORANGE.getBlendedItem(), new ItemStack(Material.GLASS), null,
            null, null, null,
            null, null, null
        },
        player -> simplePlayerEffect(player, 0, new Pair<>(PotionEffectType.SPEED, 3))
    ).buildRegister(Cultivation.getInstance());

    public static final Food LASAGNA = new Food(
        CultivationStacks.LASAGNA,
        RecipeTypes.BAKING,
        new ItemStack[]{
            Ingredients.PASTA.getItem(), SlimefunItems.CHEESE, Products.TOMATO.getChoppedItem(),
            SlimefunItems.HEAVY_CREAM, Ingredients.PASTA.getItem(), SlimefunItems.CHEESE,
            Products.TOMATO.getChoppedItem(), SlimefunItems.CHEESE, Ingredients.PASTA.getItem()
        },
        player -> {
            simplePlayerEffect(
                player,
                0,
                new Pair<>(PotionEffectType.REGENERATION, 1),
                new Pair<>(PotionEffectType.DAMAGE_RESISTANCE, 1)
            );
            simplePlayerEffect(player, 999);
        }
    ).buildRegister(Cultivation.getInstance());

    public static final Food SPAGHETTI = new Food(
        CultivationStacks.SPAGHETTI,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            Ingredients.PASTA.getItem(), null, null,
            null, Ingredients.PASTA.getItem(), null,
            null, null, Ingredients.PASTA.getItem()
        },
        player -> simplePlayerEffect(player, 2)
    ).buildRegister(Cultivation.getInstance());

    public static final Food SPAGHETTI_AND_MEATBALLS = new Food(
        CultivationStacks.SPAGHETTI_AND_MEATBALLS,
        RecipeTypes.BAKING,
        new ItemStack[]{
            null, Ingredients.MEATBALLS.getItem(), null,
            null, SPAGHETTI.getItem(), null,
            null, null, null
        },
        player -> simplePlayerEffect(player, 2, new Pair<>(PotionEffectType.BAD_OMEN, 0))
    ).buildRegister(Cultivation.getInstance());

    public static final Food BURGER = new Food(
        CultivationStacks.BURGER,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            null, new ItemStack(Material.BREAD), null,
            SlimefunItems.CHEESE, Ingredients.COOKED_BURGER_PATTY.getItem(), Products.TOMATO.getSlicedItem(),
            null, new ItemStack(Material.BREAD), null
        },
        player -> simplePlayerEffect(player, 8, new Pair<>(PotionEffectType.REGENERATION, 2))
    ).buildRegister(Cultivation.getInstance());

    public static final Food PIZZA_CHEESE = new Food(
        CultivationStacks.PIZZA_CHEESE,
        RecipeTypes.BAKING,
        new ItemStack[]{
            SlimefunItems.CHEESE, SlimefunItems.CHEESE, SlimefunItems.CHEESE,
            Products.TOMATO.getBlendedItem(), Products.TOMATO.getBlendedItem(), Products.TOMATO.getBlendedItem(),
            Ingredients.DOUGH.getItem(), Ingredients.DOUGH.getItem(), Ingredients.DOUGH.getItem()
        },
        player -> simplePlayerEffect(player, 8, new Pair<>(PotionEffectType.SLOW, 0))
    ).buildRegister(Cultivation.getInstance());

    public static final Food PIZZA_MUSHROOM = new Food(
        CultivationStacks.PIZZA_MUSHROOM,
        RecipeTypes.BAKING,
        new ItemStack[]{
            SlimefunItems.CHEESE, Products.RED_MUSHROOM.getSlicedItem(), SlimefunItems.CHEESE,
            Products.TOMATO.getBlendedItem(), Products.TOMATO.getBlendedItem(), Products.TOMATO.getBlendedItem(),
            Ingredients.DOUGH.getItem(), Ingredients.DOUGH.getItem(), Ingredients.DOUGH.getItem()
        },
        player -> simplePlayerEffect(
            player,
            12,
            new Pair<>(PotionEffectType.SLOW, 0),
            new Pair<>(PotionEffectType.FAST_DIGGING, 1)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final Food PIZZA_PEPPERONI = new Food(
        CultivationStacks.PIZZA_PEPPERONI,
        RecipeTypes.BAKING,
        new ItemStack[]{
            SlimefunItems.CHEESE, Ingredients.PEPPERONI.getSlicedItem(), SlimefunItems.CHEESE,
            Products.TOMATO.getBlendedItem(), Products.TOMATO.getBlendedItem(), Products.TOMATO.getBlendedItem(),
            Ingredients.DOUGH.getItem(), Ingredients.DOUGH.getItem(), Ingredients.DOUGH.getItem()
        },
        player -> simplePlayerEffect(
            player,
            12,
            new Pair<>(PotionEffectType.SPEED, 0),
            new Pair<>(PotionEffectType.FAST_DIGGING, 0),
            new Pair<>(PotionEffectType.JUMP, 0)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final Food CHEESY_SCALLOPED_COURGETTE = new Food(
        CultivationStacks.CHEESY_SCALLOPED_COURGETTE,
        RecipeTypes.BAKING,
        new ItemStack[]{
            SlimefunItems.CHEESE, Products.COURGETTE.getSlicedItem(), SlimefunItems.CHEESE,
            Products.COURGETTE.getSlicedItem(), new ItemStack(Material.MILK_BUCKET), Products.COURGETTE.getSlicedItem(),
            Products.THYME.getChoppedItem(), SlimefunItems.SALT, SlimefunItems.BUTTER
        },
        player -> simplePlayerEffect(
            player,
            4,
            new Pair<>(PotionEffectType.NIGHT_VISION, 0),
            new Pair<>(PotionEffectType.INVISIBILITY, 0)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final Food PECAN_PIE = new Food(
        CultivationStacks.PECAN_PIE,
        RecipeTypes.BAKING,
        new ItemStack[]{
            Products.PECAN.getChoppedItem(), Products.PECAN.getChoppedItem(), Products.PECAN.getChoppedItem(),
            new ItemStack(Material.EGG), new ItemStack(Material.SUGAR), SlimefunItems.HEAVY_CREAM,
            Ingredients.PIE_CRUST.getItem(), Ingredients.PIE_CRUST.getItem(), Ingredients.PIE_CRUST.getItem()
        },
        player -> simplePlayerEffect(
            player,
            8,
            new Pair<>(PotionEffectType.LEVITATION, 0)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final Food GARLIC_BUTTER_MUSHROOMS = new Food(
        CultivationStacks.GARLIC_BUTTER_MUSHROOMS,
        RecipeTypes.BAKING,
        new ItemStack[]{
            SlimefunItems.BUTTER, SlimefunItems.BUTTER, SlimefunItems.BUTTER,
            Products.THYME.getChoppedItem(), Products.GARLIC.getChoppedItem(), SlimefunItems.SALT,
            Products.BROWN_MUSHROOM.getSlicedItem(), Products.BROWN_MUSHROOM.getSlicedItem(), Products.BROWN_MUSHROOM.getSlicedItem()
        },
        player -> simplePlayerEffect(
            player,
            4,
            new Pair<>(PotionEffectType.GLOWING, 0)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final Food BLUE_CANDY = new Food(
        CultivationStacks.BLUE_CANDY,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            Products.SUGAR.getBoiledItem(), Products.SUGAR.getBoiledItem(), Products.SUGAR.getBoiledItem(),
            Products.SUGAR.getBoiledItem(), new ItemStack(Material.BLUE_DYE), Products.SUGAR.getBoiledItem(),
            Products.SUGAR.getBoiledItem(), Products.SUGAR.getBoiledItem(), Products.SUGAR.getBoiledItem()
        },
        player -> {
            Location location = LocationUtils.randomLocation(player.getLocation(), 2);
            Allay allay = (Allay) location.getWorld().spawnEntity(location, EntityType.ALLAY);
            allay.startDancing();
        }
    ).buildRegister(Cultivation.getInstance());

    public static final Food BOILED_EGG = new Food(
        CultivationStacks.SOFT_BOILED_EGG,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            null, null, null,
            null, Products.EGG.getBoiledItem(), null,
            null, null, null
        },
        player -> {
            simplePlayerEffect(player, 2);
            if (Chance.testChance(0.4)) {
                Location location = LocationUtils.randomLocation(player.getLocation(), 2);
                location.getWorld().spawnEntity(location, EntityType.CHICKEN);
            }
        }
    ).buildRegister(Cultivation.getInstance());

    public static final Food RAMEN_BEEF = new Food(
        CultivationStacks.RAMEN_BEEF,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            null, Products.BEEF.getBoiledItem(), null,
            null, Ingredients.PASTA.getItem(), null,
            null, null, null
        },
        player -> simplePlayerEffect(player, 0, new Pair<>(PotionEffectType.HEALTH_BOOST, 0))
    ).buildRegister(Cultivation.getInstance());

    public static final Food RAMEN_CHICKEN = new Food(
        CultivationStacks.RAMEN_CHICKEN,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            null, Products.CHICKEN.getBoiledItem(), null,
            null, Ingredients.PASTA.getItem(), null,
            null, null, null
        },
        player -> simplePlayerEffect(player, 0, new Pair<>(PotionEffectType.HEALTH_BOOST, 0))
    ).buildRegister(Cultivation.getInstance());

    public static final Food RAMEN_SEAFOOD = new Food(
        CultivationStacks.RAMEN_SEAFOOD,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            null, Products.COD.getBoiledItem(), null,
            null, Ingredients.PASTA.getItem(), null,
            null, null, null
        },
        player -> simplePlayerEffect(player, 0, new Pair<>(PotionEffectType.HEALTH_BOOST, 0))
    ).buildRegister(Cultivation.getInstance());

    public static final Food RAMEN_BEEF_HEARTY = new Food(
        CultivationStacks.RAMEN_BEEF_HEARTY,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            CultivationStacks.SPINACH, CultivationStacks.PEA, Products.EGG.getFriedItem(),
            new ItemStack(Material.CARROT), RAMEN_BEEF.getItem(), Products.BELL_PEPPER.getFriedItem(),
            Products.GINGER.getChoppedItem(), Products.PARSLEY.getChoppedItem(), Products.GARLIC.getChoppedItem()
        },
        player ->
            simplePlayerEffect(
                player,
                999,
                new Pair<>(PotionEffectType.HEALTH_BOOST, 1),
                new Pair<>(PotionEffectType.SPEED, 0)
            )
    ).buildRegister(Cultivation.getInstance());

    public static final Food RAMEN_CHICKEN_HEARTY = new Food(
        CultivationStacks.RAMEN_CHICKEN_HEARTY,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            Products.ONION.getChoppedItem(), SlimefunItems.BUTTER, Products.RED_MUSHROOM.getChoppedItem(),
            SlimefunItems.SALT, RAMEN_CHICKEN.getItem(), Products.CHILLI_PEPPER.getSlicedItem(),
            Products.GINGER.getChoppedItem(), Products.PARSLEY.getChoppedItem(), Products.GARLIC.getChoppedItem()
        },
        player ->
            simplePlayerEffect(
                player,
                999,
                new Pair<>(PotionEffectType.HEALTH_BOOST, 1),
                new Pair<>(PotionEffectType.SPEED, 0)
            )
    ).buildRegister(Cultivation.getInstance());

    public static final Food RAMEN_SEAFOOD_HEARTY = new Food(
        CultivationStacks.RAMEN_SEAFOOD_HEARTY,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            Products.EGG.getBoiledItem(), Products.PUFFERFISH.getGrilledItem(), CultivationStacks.CURRY_LEAF,
            Products.LIME.getSlicedItem(), RAMEN_SEAFOOD.getItem(), Products.SALMON.getGrilledItem(),
            Products.GINGER.getChoppedItem(), Products.CILANTRO.getChoppedItem(), Products.GARLIC.getChoppedItem()
        },
        player ->
            simplePlayerEffect(
                player,
                999,
                new Pair<>(PotionEffectType.HEALTH_BOOST, 1),
                new Pair<>(PotionEffectType.SPEED, 0)
            )
    ).buildRegister(Cultivation.getInstance());

    public static final Food BAGEL = new Food(
        CultivationStacks.BAGEL,
        RecipeTypes.BAKING,
        new ItemStack[]{
            null, SlimefunItems.SALT, null,
            null, Ingredients.DOUGH.getItem(), null,
            null, null, null
        },
        player -> simplePlayerEffect(player, 5)
    ).buildRegister(Cultivation.getInstance());

    public static final Food BAGEL_BITE = new Food(
        CultivationStacks.BAGEL_BITE,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            null, SlimefunItems.CHEESE, null,
            null, Products.TOMATO.getBlendedItem(), null,
            null, BAGEL.getItem(), null
        },
        player -> {
            ParticleUtils.displayParticleRandomly(player, Particle.FLAME, 1, 50);
            player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXTINGUISH_FIRE, 1f, 1f);
            player.setFireTicks(40);
            player.setFoodLevel(10);
        }
    ).overrideEatingMessage("Ouch!")
        .buildRegister(Cultivation.getInstance());

    public static final Food BAGEL_CREAM_CHEESE = new Food(
        CultivationStacks.BAGEL_CREAM_CHEESE,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            null, BAGEL.getItem(), null,
            null, Ingredients.CREAM_CHEESE.getItem(), null,
            null, null, null
        },
        player -> simplePlayerEffect(player, 10, new Pair<>(PotionEffectType.HEALTH_BOOST, 0))
    ).buildRegister(Cultivation.getInstance());

    public static final Food MEATLOAF = new Food(
        CultivationStacks.MEATLOAF,
        RecipeTypes.BAKING,
        new ItemStack[]{
            Ingredients.KETCHUP.getItem(), new ItemStack(Material.EGG), Products.BREAD.getChoppedItem(),
            new ItemStack(Material.MILK_BUCKET), Products.BEEF.getGroundItem(), Products.THYME.getChoppedItem(),
            SlimefunItems.SALT, Products.ONION.getChoppedItem(), Ingredients.MUSTARD.getItem()
        },
        player -> simplePlayerEffect(player, 999,
                                     new Pair<>(PotionEffectType.HEALTH_BOOST, 3),
                                     new Pair<>(PotionEffectType.DAMAGE_RESISTANCE, 2),
                                     new Pair<>(PotionEffectType.FAST_DIGGING, 1),
                                     new Pair<>(PotionEffectType.SLOW, 1)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final Food SAUSAGE = new Food(
        CultivationStacks.SAUSAGE,
        RecipeTypes.GRILLED,
        new ItemStack[]{
            new ItemStack(Material.SUGAR), SlimefunItems.SALT, Products.GARLIC.getChoppedItem(),
            Products.PORK.getGroundItem(), null, null,
            null, null, null
        },
        player -> simplePlayerEffect(player, 2)
    ).buildRegister(Cultivation.getInstance());

    public static final Food SOYLENT = new Food(
        CultivationStacks.SOYLENT,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            Products.BEEF.getBlendedItem(), Products.BANANA.getBlendedItem(), Products.COCOA.getBlendedItem(),
            Products.AVOCADO.getBlendedItem(), new ItemStack(Material.WATER_BUCKET), Products.VANILLA.getBlendedItem(),
            Products.SPINACH.getBlendedItem(), Products.SOY_BEANS.getBlendedItem(), new ItemStack(Material.ICE)
        },
        player -> simplePlayerEffect(
            player,
            0,
            new Pair<>(PotionEffectType.BAD_OMEN, 0),
            new Pair<>(PotionEffectType.WEAKNESS, 3)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final Food TATER_TOTS = new Food(
        CultivationStacks.TATER_TOTS,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            null, SlimefunItems.SALT, null,
            null, Products.POTATO.getFriedItem(), null,
            null, null, null
        },
        player -> simplePlayerEffect(player, 1, new Pair<>(PotionEffectType.SPEED, 1))
    ).buildRegister(Cultivation.getInstance());

    public static final Food SWEET_BEEHIVE = new Food(
        CultivationStacks.SWEET_BEEHIVE,
        RecipeTypes.FINISHING,
        new ItemStack[]{
            new ItemStack(Material.HONEYCOMB), new ItemStack(Material.HONEYCOMB), new ItemStack(Material.HONEYCOMB),
            null, new ItemStack(Material.BEEHIVE), null,
            null, null, null
        },
        player -> {
            for (int i = 0; i < 4; i++) {
                Location location = LocationUtils.randomLocation(player.getLocation(), 2);
                location.getWorld().spawnEntity(location, EntityType.BEE, true);
            }
        }
    ).buildRegister(Cultivation.getInstance());

    public static final Food CINNAMON_ROLL = new Food(
        CultivationStacks.CINNAMON_ROLL,
        RecipeTypes.BAKING,
        new ItemStack[]{
            Ingredients.DOUGH.getItem(), Ingredients.DOUGH.getItem(), new ItemStack(Material.SUGAR),
            Ingredients.DOUGH.getItem(), Products.CINNAMON.getGroundItem(), Ingredients.DOUGH.getItem(),
            Ingredients.DOUGH.getItem(), Ingredients.DOUGH.getItem(), Ingredients.DOUGH.getItem()
        },
        player -> simplePlayerEffect(
            player,
            8,
            new Pair<>(PotionEffectType.LEVITATION, 0),
            new Pair<>(PotionEffectType.SLOW_FALLING, 0)
        )
    ).buildRegister(Cultivation.getInstance());

    public static void setup(Cultivation addon) {

    }

    @SafeVarargs
    private static void simplePlayerEffect(@Nonnull Player player,
                                           int healing,
                                           Pair<PotionEffectType, Integer>... effectIntegerPair
    ) {
        simplePlayerEffect(player, healing);
        for (Pair<PotionEffectType, Integer> pair : effectIntegerPair) {
            PotionEffectType type = pair.getFirstValue();
            Integer amplification = pair.getSecondValue();
            if (type == null || amplification == null) {
                continue;
            }
            player.addPotionEffect(new PotionEffect(type, 12000, amplification));
        }
    }

    private static void simplePlayerEffect(@Nonnull Player player, int healing) {
        AttributeInstance health = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (health == null) {
            return;
        }
        player.setHealth(Math.min(health.getValue(), player.getHealth() + healing));
    }
}
