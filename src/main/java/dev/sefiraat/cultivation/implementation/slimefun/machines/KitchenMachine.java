package dev.sefiraat.cultivation.implementation.slimefun.machines;

import dev.sefiraat.cultivation.api.interfaces.DisplayIntractable;
import dev.sefiraat.sefilib.entity.display.DisplayGroup;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.entity.Display;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

public abstract class KitchenMachine extends KitchenObject implements DisplayIntractable {

    protected KitchenMachine(ItemGroup itemGroup,
                          SlimefunItemStack item,
                          RecipeType recipeType,
                          ItemStack[] recipe,
                          Function<Location, DisplayGroup> displayGroupFunction
    ) {
        super(itemGroup, item, recipeType, recipe, displayGroupFunction);
    }

    public void trySetTop(@Nonnull Location location, @Nonnull ItemStack itemStack) {
        if (itemStack.getType().isBlock() && itemStack.getType().isOccluding()) {
            DisplayGroup displayGroup = getDisplayGroup(location);
            if (displayGroup == null) {
                return;
            }
            Display display = displayGroup.getDisplays().get("counter_top");
            if (display instanceof ItemDisplay itemDisplay) {
                itemDisplay.setItemStack(itemStack.clone());
            }
        }
    }

    public void setUUID(@Nonnull DisplayGroup displayGroup, @Nonnull Location location) {
        BlockStorage.addBlockInfo(location, KEY_UUID, displayGroup.getParentUUID().toString());
    }

    @Nullable
    public UUID getUUID(@Nonnull Location location) {
        String uuid = BlockStorage.getLocationInfo(location, KEY_UUID);
        if (uuid == null) {
            return null;
        }
        return UUID.fromString(uuid);
    }

    @Nullable
    public DisplayGroup getDisplayGroup(@Nonnull Location location) {
        UUID uuid = getUUID(location);
        if (uuid == null) {
            return null;
        }
        return DisplayGroup.fromUUID(uuid);
    }

    public void addRecipe(@Nonnull String input, @Nonnull ItemStack output) {
        getRecipes().put(input, output);
    }

    @Nullable
    public ItemStack testRecipe(@Nonnull String input) {
        ItemStack itemStack = getRecipes().get(input);
        if (itemStack == null) {
            return null;
        }
        return itemStack.clone();
    }

    @Nonnull
    protected abstract Map<String, ItemStack> getRecipes();
}
