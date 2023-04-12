package dev.sefiraat.cultivation.implementation.slimefun.machines;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.datatypes.instances.FloraLevelProfile;
import dev.sefiraat.cultivation.api.slimefun.items.plants.HarvestablePlant;
import dev.sefiraat.cultivation.implementation.slimefun.items.Machines;
import dev.sefiraat.cultivation.implementation.utils.DisplayGroupGenerators;
import dev.sefiraat.sefilib.entity.display.DisplayGroup;
import dev.sefiraat.sefilib.entity.display.DisplayInteractable;
import dev.sefiraat.sefilib.string.Theme;
import io.github.bakedlibs.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class GardenCloche extends SlimefunItem implements DisplayInteractable, EnergyNetComponent {

    private static final String KEY_PLANT = "plant";
    private static final String KEY_UUID = "display-uuid";
    private static final int PLANT_SLOT = 20;
    private static final int[] OUTPUT_SLOTS = new int[]{
        14, 15, 16, 23, 24, 25, 32, 33, 34
    };
    private static final int[] PLANT_SLOT_BACKGROUND = new int[]{
        10, 11, 12, 19, 21, 28, 29, 30
    };
    private static final int[] BACKGROUND = new int[]{
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 13, 17, 18, 22, 26, 27, 31, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44
    };
    private static final int POWER_REQUIREMENT = 100;

    public GardenCloche(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        addItemHandler(
            new BlockPlaceHandler(false) {
                @Override
                public void onPlayerPlace(@NotNull BlockPlaceEvent e) {
                    e.getBlock().setType(Material.BARRIER);
                    setupDisplay(e.getBlock().getLocation());
                }
            },
            new BlockBreakHandler(false, false) {
                @Override
                @ParametersAreNonnullByDefault
                public void onPlayerBreak(BlockBreakEvent e, ItemStack item, List<ItemStack> drops) {
                    Location location = e.getBlock().getLocation();
                    removeDisplay(location);
                    e.getBlock().setType(Material.AIR);
                    BlockMenu blockMenu = BlockStorage.getInventory(location);
                    if (blockMenu != null) {
                        blockMenu.dropItems(location, PLANT_SLOT);
                        blockMenu.dropItems(location, OUTPUT_SLOTS);
                    }
                }
            },
            new BlockTicker() {
                @Override
                public boolean isSynchronized() {
                    return false;
                }

                @Override
                public void tick(Block block, SlimefunItem item, Config data) {
                    BlockMenu blockMenu = BlockStorage.getInventory(block);
                    ItemStack possiblePlant = blockMenu.getItemInSlot(PLANT_SLOT);
                    SlimefunItem slimefunItem = SlimefunItem.getByItem(possiblePlant);
                    Location location = block.getLocation();
                    if (slimefunItem instanceof HarvestablePlant plant) {
                        if (!hasDisplayPlant(location)) {
                            Bukkit.getScheduler().runTask(
                                Cultivation.getInstance(), () -> addPlantToDisplay(location)
                            );
                        }
                        if (getCharge(location) < POWER_REQUIREMENT) {
                            return;
                        }
                        FloraLevelProfile profile = FloraLevelProfile.fromItemStack(possiblePlant);
                        double growthRate = plant.getGrowthRate(profile);
                        double rand = ThreadLocalRandom.current().nextDouble();
                        if (rand < growthRate) {
                            ItemStack itemStack = plant.getRandomItemWithDropModifier(profile);
                            blockMenu.pushItem(itemStack, OUTPUT_SLOTS);
                            removeCharge(location, POWER_REQUIREMENT);
                        }
                    } else {
                        Bukkit.getScheduler().runTask(
                            Cultivation.getInstance(),
                            () -> removePlantFromDisplay(location)
                        );
                    }
                }
            }
        );
    }

    @Override
    public void postRegister() {
        new BlockMenuPreset(this.getId(), this.getItemName()) {

            @Override
            public void init() {
                ItemStack backgroundInput = new CustomItemStack(
                    Material.GREEN_STAINED_GLASS_PANE,
                    Theme.PASSIVE.apply("Insert Plant")
                );
                drawBackground(BACKGROUND);
                drawBackground(backgroundInput, PLANT_SLOT_BACKGROUND);
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
                    return OUTPUT_SLOTS;
                }
                return new int[0];
            }
        };
    }

    private boolean hasDisplayPlant(@Nonnull Location location) {
        String hasPlant = BlockStorage.getLocationInfo(location, KEY_PLANT);
        return Boolean.parseBoolean(hasPlant);
    }

    private void setupDisplay(@Nonnull Location location) {
        DisplayGroup displayGroup = DisplayGroupGenerators.generateCloche(location.clone().add(0.5, 0, 0.5));
        BlockStorage.addBlockInfo(location, KEY_UUID, displayGroup.getParentUUID().toString());
    }

    private void removeDisplay(@Nonnull Location location) {
        DisplayGroup group = getDisplayGroup(location);
        if (group != null) {
            group.remove();
        }
    }

    private void addPlantToDisplay(@Nonnull Location location) {
        BlockStorage.addBlockInfo(location, KEY_PLANT, "true");
        DisplayGroup group = getDisplayGroup(location);
        if (group != null) {
            DisplayGroupGenerators.addPlantToCloche(group);
        }
    }

    private void removePlantFromDisplay(@Nonnull Location location) {
        DisplayGroup displayGroup = getDisplayGroup(location);
        if (displayGroup != null) {
            DisplayGroupGenerators.removePlantFromCloche(displayGroup);
            BlockStorage.addBlockInfo(location, KEY_PLANT, null);
        }
    }

    @Nullable
    private UUID getDisplayGroupUUID(@Nonnull Location location) {
        String uuid = BlockStorage.getLocationInfo(location, KEY_UUID);
        if (uuid == null) {
            return null;
        }
        return UUID.fromString(uuid);
    }

    @Nullable
    private DisplayGroup getDisplayGroup(@Nonnull Location location) {
        UUID uuid = getDisplayGroupUUID(location);
        if (uuid == null) {
            return null;
        }
        return DisplayGroup.fromUUID(uuid);
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
}
