package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.api.slimefun.items.produce.CultivationFood;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
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
    );

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
    );

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
    );

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
    );

    public static void setup(Cultivation addon) {
        PEANUT_BUTTER_JELLY_SANDWICH.register(addon);
        BACON_SANDWICH.register(addon);
        SALMON_NIGIRI.register(addon);
        CAJUN_GARLIC_BUTTER_COD.register(addon);
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
