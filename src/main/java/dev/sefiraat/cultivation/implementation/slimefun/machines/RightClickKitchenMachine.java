package dev.sefiraat.cultivation.implementation.slimefun.machines;

import dev.sefiraat.sefilib.entity.display.DisplayGroup;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class RightClickKitchenMachine extends KitchenMachine {

    private final Map<String, ItemStack> recipes = new HashMap<>();

    public RightClickKitchenMachine(ItemGroup itemGroup,
                                    SlimefunItemStack item,
                                    RecipeType recipeType,
                                    ItemStack[] recipe,
                                    Function<Location, DisplayGroup> displayGroupFunction
    ) {
        super(itemGroup, item, recipeType, recipe, displayGroupFunction);
    }

    @Nonnull
    @Override
    protected Map<String, ItemStack> getRecipes() {
        return recipes;
    }

    @Override
    protected void onRightClick(@Nonnull PlayerRightClickEvent event) {
        if (event.getPlayer().isSneaking()) {
            super.onRightClick(event);
        }
        ItemStack itemStack = event.getItem();
        SlimefunItem slimefunItem = SlimefunItem.getByItem(itemStack);
        String id = itemStack.getType().name();
        if (slimefunItem != null) {
            id = slimefunItem.getId();
        }

        ItemStack result = testRecipe(id);
        Block block = event.getClickedBlock().orElse(null);

        if (block == null || result == null) {
            return;
        }

        Location location = block.getLocation().clone().add(0.5, 1, 0.5);
        location.getWorld().dropItem(location, result);
        itemStack.setAmount(itemStack.getAmount() - 1);

    }
}
