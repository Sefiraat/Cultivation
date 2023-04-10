package dev.sefiraat.cultivation.implementation.slimefun.machines;

import dev.sefiraat.sefilib.entity.display.DisplayGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import java.util.function.Function;

public class DoNothingKitchenObject extends KitchenObject {
    public DoNothingKitchenObject(ItemGroup itemGroup,
                                     SlimefunItemStack item,
                                     RecipeType recipeType,
                                     ItemStack[] recipe,
                                     Function<Location, DisplayGroup> displayGroupFunction
    ) {
        super(itemGroup, item, recipeType, recipe, displayGroupFunction);
    }
}
