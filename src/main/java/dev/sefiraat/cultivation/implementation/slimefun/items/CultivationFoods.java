package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.api.slimefun.items.produce.CultivationFood;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
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
        player -> simplePlayerEffect(player, 10, PotionEffectType.INCREASE_DAMAGE, 2)
    );

    public static void setup(Cultivation addon) {
        PEANUT_BUTTER_JELLY_SANDWICH.register(addon);

    }

    private static void simplePlayerEffect(@Nonnull Player player,
                                           int healing,
                                           PotionEffectType effectType,
                                           int amplification
    ) {
        simplePlayerEffect(player, healing);
        player.addPotionEffect(new PotionEffect(effectType, 12000, amplification));
    }

    private static void simplePlayerEffect(@Nonnull Player player, int healing) {
        AttributeInstance health = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (health == null) {
            return;
        }
        player.setHealth(Math.min(health.getValue(), player.getHealth() + healing));
    }
}
