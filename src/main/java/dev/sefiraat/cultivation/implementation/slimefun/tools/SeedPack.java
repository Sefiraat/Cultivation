package dev.sefiraat.cultivation.implementation.slimefun.tools;

import dev.sefiraat.cultivation.api.datatypes.SeedPackDataType;
import dev.sefiraat.cultivation.api.datatypes.instances.FloraLevelProfile;
import dev.sefiraat.cultivation.api.datatypes.instances.SeedPackInstance;
import dev.sefiraat.cultivation.api.slimefun.items.plants.CultivationPlant;
import dev.sefiraat.sefilib.string.Theme;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.libraries.dough.data.persistent.PersistentDataAPI;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ClickAction;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.HashMap;

public class SeedPack extends SlimefunItem {

    public SeedPack(ItemGroup group, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(group, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        addItemHandler(onRightClick());
    }

    @NotNull
    public ItemUseHandler onRightClick() {
        return playerRightClickEvent -> {
            ItemStack itemStack = playerRightClickEvent.getItem();
            Player player = playerRightClickEvent.getPlayer();
            if (itemStack.getAmount() > 1) {
                player.sendMessage(Theme.ERROR.apply("You must unstack your pack(s) first."));
                return;
            }
            SeedPackGui gui = new SeedPackGui(itemStack);
            gui.open(player);
        };
    }

    public class SeedPackGui extends ChestMenu {

        protected static final int[] BACKGROUND_SLOTS = new int[]{
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 17, 18,
            20, 24, 26, 27, 29, 30, 31, 32, 33, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44
        };
        protected static final int SEED_SET_SLOT = 19;
        protected static final int[] SEED_SET_BACKGROUND = new int[]{
            10, 28
        };
        protected static final int SEED_PICKUP_SLOT = 25;
        protected static final int[] SEED_PICKUP_BACKGROUND = new int[]{
            16, 34
        };

        protected static final int INCREMENT_LEVEL_SLOT = 21;
        protected static final int INCREMENT_SPEED_SLOT = 22;
        protected static final int INCREMENT_STRENGTH_SLOT = 23;

        protected static final ItemStack SET_BACKGROUND_STACK = new CustomItemStack(
            Material.GREEN_STAINED_GLASS_PANE,
            Theme.PASSIVE.apply("Set seed here")
        );

        protected static final ItemStack PICKUP_BACKGROUND_STACK = new CustomItemStack(
            Material.GREEN_STAINED_GLASS_PANE,
            Theme.PASSIVE.apply("Retrieve here")
        );
        protected static final ItemStack NO_SEED_SET_STACK = new CustomItemStack(
            Material.ORANGE_STAINED_GLASS_PANE,
            Theme.WARNING.apply("No Seed Set"),
            Theme.PASSIVE.apply("Click the left hand side icon"),
            Theme.PASSIVE.apply("While holding a seed to set pack.")
        );

        private int level = 1;
        private int speed = 1;
        private int strength = 1;

        private final ItemStack packStack;
        private SeedPackInstance instance;

        public SeedPackGui(@Nonnull ItemStack packStack) {
            super("Seed Pack");
            ItemMeta itemMeta = packStack.getItemMeta();

            this.packStack = packStack;
            instance = PersistentDataAPI.get(
                itemMeta,
                SeedPackDataType.KEY,
                SeedPackDataType.TYPE,
                new SeedPackInstance()
            );

            setPlayerInventoryClickable(true);

            ChestMenuUtils.drawBackground(this, BACKGROUND_SLOTS);

            for (int i : SEED_PICKUP_BACKGROUND) {
                addItem(i, PICKUP_BACKGROUND_STACK, ChestMenuUtils.getEmptyClickHandler());
            }

            for (int i : SEED_SET_BACKGROUND) {
                addItem(i, SET_BACKGROUND_STACK, ChestMenuUtils.getEmptyClickHandler());
            }

            addItem(SEED_SET_SLOT, NO_SEED_SET_STACK, this::onClickSeedSetSlot);
            addItem(SEED_PICKUP_SLOT, NO_SEED_SET_STACK, this::onClickSeedGetSlot);

            addItem(INCREMENT_LEVEL_SLOT, getIncrementStack("Level", 1), (p, slot, item, action) -> {
                int value;
                if (action.isRightClicked()) {
                    value = Math.max(level - 1, 1);
                } else {
                    value = Math.min(level + 1, 10);
                }
                replaceExistingItem(INCREMENT_LEVEL_SLOT, getIncrementStack("Level", value));
                this.level = value;
                setOutputStack();
                return false;
            });
            addItem(INCREMENT_SPEED_SLOT, getIncrementStack("Speed", 1), (p, slot, item, action) -> {
                int value;
                if (action.isRightClicked()) {
                    value = Math.max(speed - 1, 1);
                } else {
                    value = Math.min(speed + 1, 10);
                }
                replaceExistingItem(INCREMENT_SPEED_SLOT, getIncrementStack("Speed", value));
                this.speed = value;
                setOutputStack();
                return false;
            });
            addItem(INCREMENT_STRENGTH_SLOT, getIncrementStack("Strength", 1), (p, slot, item, action) -> {
                int value;
                if (action.isRightClicked()) {
                    value = Math.max(strength - 1, 1);
                } else {
                    value = Math.min(strength + 1, 10);
                }
                replaceExistingItem(INCREMENT_STRENGTH_SLOT, getIncrementStack("Strength", value));
                this.strength = value;
                setOutputStack();
                return false;
            });

            setOutputStack();
            setInputStack();
        }

        private boolean onClickSeedSetSlot(Player player, int slot, ItemStack item, ClickAction action) {
            ItemStack itemStack = player.getItemOnCursor();
            if (itemStack == null || itemStack.getType().isAir()) {
                return false;
            }

            SlimefunItem slimefunItem = SlimefunItem.getByItem(itemStack);
            if (!(slimefunItem instanceof CultivationPlant plant)) {
                player.sendMessage(Theme.WARNING.apply("The item must be a Cultivation Plant Seed"));
                return false;
            }

            if (!instance.isEmpty()) {
                player.sendMessage(Theme.WARNING.apply("You must empty a pack before changing the type."));
                return false;
            }

            this.instance.setStoredItemId(plant.getId());
            replaceExistingItem(SEED_SET_SLOT, getSeedDisplayStack(plant));
            reapplyInstance();

            return false;
        }

        private boolean onClickSeedGetSlot(Player player, int slot, ItemStack item, ClickAction action) {
            SlimefunItem slimefunItem = SlimefunItem.getById(instance.storedItemId);
            if (!(slimefunItem instanceof CultivationPlant plant)) {
                player.sendMessage(Theme.WARNING.apply("You have not set a plant yet."));
                return false;
            }

            int amount = instance.getAmount(level, speed, strength);
            if (amount < 1) {
                player.sendMessage(Theme.WARNING.apply("You dont have any of this seed currently."));
                return false;
            }

            FloraLevelProfile profile = new FloraLevelProfile(level, speed, strength, true);

            ItemStack itemStack = CultivationPlant.getStack(plant, profile);

            HashMap<Integer, ItemStack> remainder = player.getInventory().addItem(itemStack);

            if (remainder.isEmpty()) {
                instance.takeOne(level, speed, strength);
            }
            setOutputStack();
            reapplyInstance();
            return false;
        }

        private void setInputStack() {
            SlimefunItem slimefunItem = SlimefunItem.getById(instance.storedItemId);
            if (!(slimefunItem instanceof CultivationPlant plant)) {
                replaceExistingItem(SEED_SET_SLOT, NO_SEED_SET_STACK);
                return;
            }
            ItemStack itemStack = getSeedDisplayStack(plant);
            replaceExistingItem(SEED_SET_SLOT, itemStack);
        }

        private void setOutputStack() {
            SlimefunItem slimefunItem = SlimefunItem.getById(instance.storedItemId);
            if (!(slimefunItem instanceof CultivationPlant plant)) {
                replaceExistingItem(SEED_PICKUP_SLOT, NO_SEED_SET_STACK);
                return;
            }
            int amount = instance.getAmount(level, speed, strength);
            ItemStack itemStack = getSeedGetStack(plant, amount);
            replaceExistingItem(SEED_PICKUP_SLOT, itemStack);
        }

        private void reapplyInstance() {
            ItemMeta itemMeta = this.packStack.getItemMeta();
            PersistentDataAPI.set(itemMeta, SeedPackDataType.KEY, SeedPackDataType.TYPE, this.instance);
            this.packStack.setItemMeta(itemMeta);
        }

        @Nonnull
        private ItemStack getSeedDisplayStack(@Nonnull CultivationPlant plant) {
            ItemStack itemStack = plant.getItem().clone();
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(Theme.CLICK_INFO.apply("Stored Seed Type"));
            itemStack.setItemMeta(itemMeta);
            return itemStack;
        }

        @Nonnull
        private ItemStack getSeedGetStack(@Nonnull CultivationPlant plant, int amount) {
            ItemStack itemStack = plant.getItem().clone();
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(Theme.CLICK_INFO.apply("Remove seed from pack"));
            itemStack.setItemMeta(itemMeta);
            itemStack.setAmount(Math.min(amount, 64));
            return itemStack;
        }
        
        private ItemStack getIncrementStack(@Nonnull String name, int value) {
            return new CustomItemStack(
                Material.YELLOW_STAINED_GLASS_PANE,
                Theme.CLICK_INFO.apply(name),
                Theme.CLICK_INFO.asTitle("Left Click", "Increase " + name),
                Theme.CLICK_INFO.asTitle("Right Click", "Decrease " + name),
                "",
                Theme.CLICK_INFO.asTitle("Current", value)
            );
        }
    }
}
