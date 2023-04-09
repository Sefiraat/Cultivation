package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.api.slimefun.items.produce.CultivationFood;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
import dev.sefiraat.sefilib.misc.Chance;
import io.github.bakedlibs.dough.collections.Pair;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import javax.annotation.Nonnull;

public final class CultivationFoods {

    private CultivationFoods() {
        throw new IllegalStateException("Utility class");
    }

    public static final CultivationFood PEANUT_BUTTER_JELLY_SANDWICH = new CultivationFood(
        CultivationGroups.FOODS,
        CultivationStacks.FOOD_PEANUT_BUTTER_JELLY_SANDWICH,
        RecipeTypes.createFoodFinishingRecipe(
            CultivationStacks.FOOD_PEANUT_BUTTER_JELLY_SANDWICH,
            new ItemStack[]{
                null, new ItemStack(Material.BREAD), null,
                CultivationIngredients.GRAPE_JELLY.getItem(), CultivationIngredients.PEANUT_BUTTER.getItem(), CultivationIngredients.STRAWBERRY_JELLY.getItem(),
                null, new ItemStack(Material.BREAD), null
            }
        ),
        player -> simplePlayerEffect(
            player,
            10,
            new Pair<>(PotionEffectType.INCREASE_DAMAGE, 2)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationFood BACON_SANDWICH = new CultivationFood(
        CultivationGroups.FOODS,
        CultivationStacks.BACON_SANDWICH,
        RecipeTypes.createFoodFinishingRecipe(
            CultivationStacks.BACON_SANDWICH,
            new ItemStack[]{
                null, new ItemStack(Material.BREAD), null,
                null, CultivationProducts.PORK.getFried().getItem(), null,
                null, new ItemStack(Material.BREAD), null
            }
        ),
        player -> simplePlayerEffect(
            player,
            4,
            new Pair<>(PotionEffectType.INCREASE_DAMAGE, 0),
            new Pair<>(PotionEffectType.SPEED, 0)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationFood SALMON_NIGIRI = new CultivationFood(
        CultivationGroups.FOODS,
        CultivationStacks.SALMON_NIGIRI,
        RecipeTypes.createFoodFinishingRecipe(
            CultivationStacks.SALMON_NIGIRI,
            new ItemStack[]{
                null, CultivationProducts.SALMON.getSliced().getItem(), null,
                null, CultivationProducts.RICE.getItem(), null,
                null, null, null
            }
        ),
        player -> simplePlayerEffect(
            player,
            4,
            new Pair<>(PotionEffectType.REGENERATION, 0)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationFood CAJUN_GARLIC_BUTTER_COD = new CultivationFood(
        CultivationGroups.FOODS,
        CultivationStacks.CAJUN_GARLIC_BUTTER_COD,
        RecipeTypes.createFoodFinishingRecipe(
            CultivationStacks.CAJUN_GARLIC_BUTTER_COD,
            new ItemStack[]{
                CultivationProducts.COD.getBaked().getItem(), SlimefunItems.BUTTER, null,
                CultivationProducts.GARLIC.getChopped().getItem(), CultivationProducts.CAYENNE_PEPPER.getGround().getItem(), null,
                null, null, null
            }
        ),
        player -> simplePlayerEffect(
            player,
            8,
            new Pair<>(PotionEffectType.REGENERATION, 1),
            new Pair<>(PotionEffectType.SPEED, 0)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationFood SHAKSHUKA = new CultivationFood(
        CultivationGroups.FOODS,
        CultivationStacks.SHAKSHUKA,
        RecipeTypes.createFoodFinishingRecipe(
            CultivationStacks.SHAKSHUKA,
            new ItemStack[]{
                CultivationProducts.EGG.getBaked().getItem(), CultivationProducts.ONION.getChopped().getItem(), CultivationProducts.BELL_PEPPER.getBaked().getItem(),
                CultivationProducts.GARLIC.getChopped().getItem(), CultivationProducts.BELL_PEPPER.getGround().getItem(), CultivationProducts.TOMATO.getBaked().getItem(),
                null, null, null
            }
        ),
        player -> simplePlayerEffect(
            player,
            8,
            new Pair<>(PotionEffectType.HERO_OF_THE_VILLAGE, 0),
            new Pair<>(PotionEffectType.LUCK, 0)
        )
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationFood FUGU = new CultivationFood(
        CultivationGroups.FOODS,
        CultivationStacks.FUGU,
        RecipeTypes.createFoodFinishingRecipe(
            CultivationStacks.FUGU,
            new ItemStack[]{
                null, CultivationProducts.PUFFERFISH.getSliced().getItem(), null,
                null, CultivationProducts.RICE.getItem(), null,
                null, null, null
            }
        ),
        player -> {
            if (Chance.testChance(0.33)) {
                player.damage(999);
            } else {
                simplePlayerEffect(player, 2, new Pair<>(PotionEffectType.INCREASE_DAMAGE, 4));
            }
        }
    ).buildRegister(Cultivation.getInstance());

    public static final CultivationFood SHEPHERDS_PIE = new CultivationFood(
        CultivationGroups.FOODS,
        CultivationStacks.SHEPHERDS_PIE,
        RecipeTypes.createFoodFinishingRecipe(
            CultivationStacks.SHEPHERDS_PIE,
            new ItemStack[]{
                SlimefunItems.CHEESE, CultivationProducts.POTATO.getMashed().getItem(), SlimefunItems.CHEESE,
                CultivationProducts.CARROT.getChopped().getItem(), CultivationProducts.PEA.getItem(), CultivationProducts.ONION.getFried().getItem(),
                CultivationProducts.BEEF.getGround().getItem(), CultivationProducts.BEEF.getGround().getItem(), CultivationProducts.BEEF.getGround().getItem()
            }
        ),
        player -> simplePlayerEffect(
            player,
            20,
            new Pair<>(PotionEffectType.REGENERATION, 1)
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
