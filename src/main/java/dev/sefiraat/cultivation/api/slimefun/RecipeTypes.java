package dev.sefiraat.cultivation.api.slimefun;

import dev.sefiraat.cultivation.api.utils.CultivationThemes;
import dev.sefiraat.cultivation.implementation.listeners.DropListener;
import dev.sefiraat.cultivation.implementation.utils.Keys;
import dev.sefiraat.sefilib.string.Theme;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * This is used to store and initialise the {@link RecipeType}s used in the addon.
 */
public final class RecipeTypes {

    @Nonnull
    public static final RecipeType PLANT_HARVEST = new RecipeType(
        Keys.newKey("plant_harvest"),
        Theme.themedItemStack(
            Material.PRISMARINE_SHARD,
            CultivationThemes.RECIPE_TYPE,
            "Plant Harvesting",
            List.of("This item can be harvested from a plant.")
        )
    );
    @Nonnull
    public static final RecipeType PLANT_BREEDING = new RecipeType(
        Keys.newKey("plant_breeding"),
        Theme.themedItemStack(
            Material.FLOWER_POT,
            CultivationThemes.RECIPE_TYPE,
            "Plant Breeding",
            List.of(
                "This seed is found via breeding.",
                "You breed plants by placing",
                "two plants down with an air block",
                "between them.",
                "",
                "The breeding dictionary can be used",
                "to track your discoveries.",
                "",
                "Hint: Black particles mean the",
                "two plants CANNOT breed."
            )
        )
    );
    @Nonnull
    public static final RecipeType VANILLA_DROP = new RecipeType(
        Keys.newKey("vanilla_block_drop"),
        Theme.themedItemStack(
            Material.BROWN_DYE,
            CultivationThemes.RECIPE_TYPE,
            "World Drop",
            List.of("Drops from blocks when broken in the world.")
        )
    );

    private RecipeTypes() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This method both registers the drop and returns an ItemStack array that can be used
     * for Slimefun's recipe system. {@link RecipeTypes#VANILLA_DROP}
     *
     * @param stackToDrop The {@link ItemStack} to drop in the world
     * @param dropFrom    The {@link ItemStack} to drop from (#getType() is used) and the stack is used in the recipe.
     * @param dropChance  The chance (0-1) for the drop to occur
     * @return A {@link ItemStack[]} used for Slimefun's Recipe registration with the dropFrom item in the middle.
     */
    @Nonnull
    public static ItemStack[] createWorldDropRecipe(@Nonnull ItemStack stackToDrop,
                                                    @Nonnull ItemStack dropFrom,
                                                    double dropChance
    ) {
        final Material material = dropFrom.getType();
        DropListener.getDropMap().put(material, new DropListener.BlockDrop(stackToDrop, material, dropChance));
        return new ItemStack[]{
            null, null, null,
            null, dropFrom, null,
            null, null, null
        };
    }
}
