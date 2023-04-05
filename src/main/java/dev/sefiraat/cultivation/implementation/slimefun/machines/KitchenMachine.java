package dev.sefiraat.cultivation.implementation.slimefun.machines;

import dev.sefiraat.cultivation.api.interfaces.DisplayIntractable;
import dev.sefiraat.sefilib.entity.display.DisplayGroup;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockUseHandler;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Display;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

public class KitchenMachine extends SlimefunItem implements DisplayIntractable {

    private static final String KEY_UUID = "display-uuid";

    private final Map<String, ItemStack> recipes = new HashMap<>();
    private final Function<Location, DisplayGroup> displayGroupFunction;

    public KitchenMachine(ItemGroup itemGroup,
                          SlimefunItemStack item,
                          RecipeType recipeType,
                          ItemStack[] recipe,
                          Function<Location, DisplayGroup> displayGroupFunction
    ) {
        super(itemGroup, item, recipeType, recipe);
        this.displayGroupFunction = displayGroupFunction;
    }

    @Override
    public void preRegister() {
        addItemHandler(
            new BlockUseHandler() {
                @Override
                public void onRightClick(PlayerRightClickEvent e) {
                    ItemStack itemStack = e.getItem();
                    SlimefunItem slimefunItem = SlimefunItem.getByItem(itemStack);
                    String id = itemStack.getType().name();
                    if (slimefunItem != null) {
                        id = slimefunItem.getId();
                    }

                    ItemStack result = testRecipe(id);
                    Block block = e.getClickedBlock().orElse(null);

                    if (result == null) {
                        if (block != null) {
                            trySetTop(block.getLocation(), itemStack);
                        }
                        return;
                    }


                    if (block == null) {
                        return;
                    }

                    Location location = block.getLocation().clone().add(0.5, 1, 0.5);
                    location.getWorld().dropItem(location, result);
                    itemStack.setAmount(itemStack.getAmount() - 1);
                }
            },
            new BlockPlaceHandler(false) {
                @Override
                public void onPlayerPlace(@NotNull BlockPlaceEvent e) {
                    Location location = e.getBlock().getLocation();
                    DisplayGroup displayGroup = displayGroupFunction.apply(location.clone().add(0.5, 0, 0.5));
                    setUUID(displayGroup, location);
                    e.getBlock().setType(Material.BARRIER);
                }
            },
            new BlockBreakHandler(false, false) {
                @Override
                public void onPlayerBreak(BlockBreakEvent e, ItemStack item, List<ItemStack> drops) {
                    Location location = e.getBlock().getLocation();
                    DisplayGroup displayGroup = getDisplayGroup(location);
                    if (displayGroup == null) {
                        return;
                    }
                    displayGroup.remove();
                    e.getBlock().setType(Material.AIR);
                }
            }
        );
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
        recipes.put(input, output);
    }

    @Nullable
    public ItemStack testRecipe(@Nonnull String input) {
        ItemStack itemStack = recipes.get(input);
        return itemStack == null ? null : itemStack.clone();
    }
}
