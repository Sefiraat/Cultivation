package dev.sefiraat.cultivation.implementation.slimefun.machines;

import dev.sefiraat.cultivation.api.slimefun.items.produce.ByProduct;
import dev.sefiraat.cultivation.implementation.slimefun.items.Machines;
import dev.sefiraat.sefilib.entity.display.DisplayGroup;
import dev.sefiraat.sefilib.string.Theme;
import io.github.bakedlibs.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class PoweredKitchenMachineComplex extends KitchenRecipeMachineComplex implements EnergyNetComponent {
    private static final int[] INPUT_SLOTS = new int[]{
        10, 11, 12, 19, 20, 21, 28, 29, 30
    };
    private static final int OUTPUT_SLOT = 25;
    private static final int COOK_SLOT = 23;
    private static final int[] OUTPUT_SLOT_BACKGROUND = new int[]{
        16, 34
    };
    private static final int[] BACKGROUND = new int[]{
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 13, 14, 15, 16, 17, 18, 22, 24, 26, 27, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44
    };

    private final Map<ItemStack[], ItemStack> recipes = new HashMap<>();
    private final int powerRequirement;

    public PoweredKitchenMachineComplex(ItemGroup itemGroup,
                                        SlimefunItemStack item,
                                        RecipeType recipeType,
                                        ItemStack[] recipe,
                                        Function<Location, DisplayGroup> displayGroupFunction,
                                        int powerRequirement
    ) {
        super(itemGroup, item, recipeType, recipe, displayGroupFunction);
        this.powerRequirement = powerRequirement;
    }

    @Override
    protected void onRightClick(@NotNull PlayerRightClickEvent event) {
        Player player = event.getPlayer();
        if (player.isSneaking()) {
            super.onRightClick(event);
        } else {
            Block block = event.getClickedBlock().orElse(null);

            if (block == null) {
                return;
            }

            BlockMenu blockMenu = BlockStorage.getInventory(block);

            if (blockMenu == null || !blockMenu.canOpen(block, player)) {
                return;
            }
            blockMenu.open(player);
        }
    }

    @Nonnull
    @Override
    protected Map<ItemStack[], ItemStack> getRecipes() {
        return recipes;
    }

    @NotNull
    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }

    @Override
    public int getCapacity() {
        return 2500;
    }

    @Override
    public void postRegister() {
        new BlockMenuPreset(this.getId(), this.getItemName()) {

            @Override
            public void init() {
                ItemStack backgroundOutput = new CustomItemStack(
                    Material.ORANGE_STAINED_GLASS_PANE,
                    Theme.PASSIVE.apply("Cooked Output")
                );
                ItemStack cookButton = new CustomItemStack(
                    Material.RED_STAINED_GLASS_PANE,
                    Theme.CLICK_INFO.apply("Cook Produce"),
                    Theme.CLICK_INFO.asTitle("Power Required", powerRequirement)
                );
                drawBackground(BACKGROUND);
                drawBackground(backgroundOutput, OUTPUT_SLOT_BACKGROUND);
                addItem(COOK_SLOT, cookButton, ChestMenuUtils.getEmptyClickHandler());
            }

            @Override
            public void newInstance(@NotNull BlockMenu menu, @NotNull Block b) {
                menu.addMenuClickHandler(COOK_SLOT, (p, slot, item, action) -> {
                    if (getCharge(menu.getLocation()) < powerRequirement) {
                        p.sendMessage(Theme.ERROR.apply("Not enough power."));
                        return false;
                    }
                    ItemStack[] itemStacks = new ItemStack[9];
                    for (int i = 0; i < INPUT_SLOTS.length; i++) {
                        itemStacks[i] = menu.getItemInSlot(INPUT_SLOTS[i]);
                    }
                    ItemStack result = testRecipe(itemStacks);
                    SlimefunItem slimefunItem = SlimefunItem.getByItem(result);
                    if (slimefunItem != null && slimefunItem.isDisabled()) {
                        p.sendMessage(Theme.ERROR.apply("This recipe is disabled."));
                        return false;
                    }
                    if (result == null || !menu.fits(result, OUTPUT_SLOT)) {
                        p.sendMessage(Theme.ERROR.apply("No matching recipe."));
                        return false;
                    }

                    menu.pushItem(result, OUTPUT_SLOT);
                    for (int inputSlot : INPUT_SLOTS) {
                        ItemStack inputItem = menu.getItemInSlot(inputSlot);
                        if (inputItem == null || inputItem.getType().isAir()) {
                            continue;
                        }
                        if (isBucket(inputItem) && !(SlimefunItem.getByItem(inputItem) instanceof ByProduct)) {
                            inputItem.setType(Material.BUCKET);
                        } else {
                            inputItem.setAmount(inputItem.getAmount() - 1);
                        }
                    }
                    p.sendMessage(Theme.SUCCESS.apply("Tasty!"));
                    return false;
                });
            }

            @Override
            public boolean canOpen(@Nonnull Block block, @Nonnull Player player) {
                return Machines.GARDEN_CLOCHE.canUse(player, false)
                    && Slimefun.getProtectionManager()
                    .hasPermission(player, block.getLocation(), Interaction.INTERACT_BLOCK);
            }

            @Override
            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow) {
                if (flow == ItemTransportFlow.WITHDRAW) {
                    return new int[]{OUTPUT_SLOT};
                }
                return new int[0];
            }
        };
    }
}
