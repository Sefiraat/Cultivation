package dev.sefiraat.cultivation.api.slimefun.items;

import com.google.common.base.Preconditions;
import dev.sefiraat.cultivation.Registry;
import dev.sefiraat.cultivation.api.events.CultivationBushGrowEvent;
import dev.sefiraat.cultivation.api.events.CultivationGrowEvent;
import dev.sefiraat.cultivation.api.events.CultivationPlantGrowEvent;
import dev.sefiraat.cultivation.api.interfaces.CultivationFlora;
import dev.sefiraat.cultivation.api.slimefun.items.bushes.CultivationBush;
import dev.sefiraat.cultivation.api.slimefun.items.plants.CultivationPlant;
import dev.sefiraat.cultivation.api.slimefun.plant.Growth;
import dev.sefiraat.cultivation.api.utils.LevelType;
import dev.sefiraat.cultivation.api.utils.StatisticUtils;
import dev.sefiraat.cultivation.implementation.listeners.CustomPlacementListener;
import dev.sefiraat.cultivation.implementation.utils.Keys;
import dev.sefiraat.sefilib.misc.ParticleUtils;
import dev.sefiraat.sefilib.string.Theme;
import dev.sefiraat.sefilib.world.LocationUtils;
import io.github.bakedlibs.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockUseHandler;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public abstract class CultivationFloraItem<T extends CultivationFloraItem<T>> extends SlimefunItem
    implements CultivationFlora {

    @Nonnull
    protected final Map<Location, UUID> ownerCache = new HashMap<>();
    @Nonnull
    protected Growth growth;
    @Nullable
    protected ItemStack displayStack;

    protected CultivationFloraItem(ItemGroup itemGroup,
                                   SlimefunItemStack item,
                                   RecipeType recipeType,
                                   ItemStack[] recipe,
                                   @Nullable ItemStack recipeOutput,
                                   @Nonnull Growth growth
    ) {
        super(itemGroup, item, recipeType, recipe, recipeOutput);
        this.growth = growth;
    }

    @Override
    public void preRegister() {
        addItemHandler(
            new BlockTicker() {
                @Override
                public boolean isSynchronized() {
                    return true;
                }

                @Override
                public void tick(Block block, SlimefunItem item, Config data) {
                    if (item == null) {
                        return;
                    }
                    try {
                        onTick(block, (T) item, data);
                    } catch (ClassCastException exception) {
                        // TODO Do we need to handle or can we ignore?
                    }
                }
            },
            new BlockBreakHandler(false, false) {
                @Override
                @ParametersAreNonnullByDefault
                public void onPlayerBreak(BlockBreakEvent blockBreakEvent, ItemStack itemStack, List<ItemStack> list) {
                    // Todo
                }
            },
            (BlockUseHandler) this::onBlockUse
        );
    }

    @Override
    public void postRegister() {
        new BlockMenuPreset(this.getId(), this.getItemName()) {

            @Override
            public void init() {
                setSize(9);
                addMenuOpeningHandler(HumanEntity::closeInventory);
            }

            @Override
            public boolean canOpen(@Nonnull Block block, @Nonnull Player player) {
                return true;
            }

            @Override
            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow itemTransportFlow) {
                return new int[0];
            }

            @Override
            public void newInstance(@Nonnull BlockMenu menu, @Nonnull Block block) {
                final String owner = BlockStorage.getLocationInfo(block.getLocation(), Keys.FLORA_OWNER);
                if (owner != null) {
                    final UUID uuid = UUID.fromString(owner);
                    addOwner(block.getLocation(), uuid);
                }
            }
        };
    }

    public void addOwner(@Nonnull Location location, @Nonnull UUID uuid) {
        ownerCache.put(location, uuid);
    }

    @ParametersAreNonnullByDefault
    protected void onTick(Block block, T flora, Config data) {
        Location location = block.getLocation();
        int growthStage = Integer.parseInt(data.getString(Keys.FLORA_GROWTH_STAGE));
        onTickAlways(location, flora, data);
        if (growthStage >= getMaxGrowthStages()) {
            onTickFullyGrown(location, flora, data);
            tryBreed(block, flora);
        } else {
            tryGrow(block, flora, data, location, growthStage);
        }
    }

    /**
     * Can be overridden by implementations to add an effect when the block is right-clicked.
     *
     * @param event The {@link PlayerRightClickEvent} being sent from Slimefun
     */
    protected void onBlockUse(@Nonnull PlayerRightClickEvent event) {

    }

    protected void tryBreed(@Nonnull Block block, @Nonnull T flora) {

    }

    @ParametersAreNonnullByDefault
    void tryGrow(Block block, T flora, Config data, Location location, int growthStage) {
        final double growthRandom = ThreadLocalRandom.current().nextDouble();
        if (growthRandom <= getGrowthRate() && getMaxGrowthStages() > growthStage) {

            CultivationGrowEvent<T> event = getEvent(flora, location, growthStage);

            if (event == null) {
                // todo Don't like this, can we change
                return;
            }

            Bukkit.getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                return;
            }
            updateGrowthStage(block, growthStage + 1);
            if (getMaxGrowthStages() == growthStage + 1) {
                StatisticUtils.incrementExp(getOwner(location), LevelType.HORTICULTURALIST, 1);
                onFullyMatures(location, flora, data);
                finalGrowthDisplay(location);
            } else {
                growthDisplay(location);
            }
        }
    }

    @Nullable
    private CultivationGrowEvent<T> getEvent(T flora, Location location, int growthStage) {
        if (flora instanceof CultivationBush bush) {
            return (CultivationGrowEvent<T>) new CultivationBushGrowEvent(location, bush, growthStage);
        } else if (flora instanceof CultivationPlant plant) {
            return (CultivationGrowEvent<T>) new CultivationPlantGrowEvent(location, plant, growthStage);
        } else {
            return null;
        }
    }

    protected abstract void updateGrowthStage(@Nonnull Block block, int growthStage);

    @Nonnull
    public UUID getOwner(@Nonnull Location location) {
        UUID uuid = ownerCache.get(location);
        // Owner cannot be null if called correctly
        Preconditions.checkNotNull(uuid, "Owner is null, has this been called correctly");
        return uuid;
    }

    protected void finalGrowthDisplay(@Nonnull Location location) {
        ParticleUtils.displayParticleRandomly(LocationUtils.centre(location), Particle.WAX_ON, 0.5, 4);
    }

    protected void growthDisplay(@Nonnull Location location) {
        ParticleUtils.displayParticleRandomly(LocationUtils.centre(location), 0.5, 4, getTheme().getDustOptions(1f));
    }

    @Nonnull
    @Override
    public Theme getTheme() {
        return growth.getStages().getTheme();
    }

    @Nonnull
    @Override
    public Set<Material> getPlacements() {
        return growth.getPlacements();
    }

    @Override
    public double getGrowthRate() {
        return growth.getGrowthRate();
    }

    /**
     * This method is fired when the block is placed
     * see {@link CustomPlacementListener}
     *
     * @param event The {@link BlockPlaceEvent} triggered from the block placement
     */
    @Override
    public void whenPlaced(@Nonnull BlockPlaceEvent event) {
        final Block block = event.getBlock();
        final Block blockBelow = block.getRelative(BlockFace.DOWN);
        final Location location = block.getLocation();

        if (getPlacements().contains(blockBelow.getType())) {
            final UUID uuid = event.getPlayer().getUniqueId();
            BlockStorage.addBlockInfo(location, Keys.FLORA_GROWTH_STAGE, "0");
            BlockStorage.addBlockInfo(location, Keys.FLORA_OWNER, uuid.toString());
            ownerCache.put(location, uuid);
            return;
        }
        // Can't be placed here so cancel the event
        event.setCancelled(true);
    }

    public boolean isMature(@Nonnull Block block) {
        return isMature(block.getLocation());
    }

    @Override
    public boolean isMature(@Nonnull Location location) {
        final String stage = BlockStorage.getLocationInfo(location, Keys.FLORA_GROWTH_STAGE);
        if (stage == null) {
            return false;
        }
        final int growthStage = Integer.parseInt(stage);
        return growthStage >= getMaxGrowthStages();
    }

    public void updateGrowthStage(@Nonnull Location location, int growthStage) {
        updateGrowthStage(location.getBlock(), growthStage);
    }

    /**
     * Sets the {@link Growth} of the plant
     *
     * @param growth The required {@link Growth}
     */
    @Nonnull
    public T setGrowth(@Nonnull Growth growth) {
        this.growth = growth;
        String[] lore = new String[0];
        if (this.getItem().getItemMeta().hasLore()) {
            lore = this.getItem().getItemMeta().getLore().toArray(lore);
        }
        this.displayStack = new CustomItemStack(
            this.growth.getFullyGrownPlant(),
            this.getItemName(),
            lore
        );
        return (T) this;
    }

    /**
     * Tries to register the seed (if it passes validation) first into the Registry, then its
     * breeding pairs and finally with Slimefun.
     *
     * @param addon The addon registering this Seed
     */
    public void tryRegister(@Nonnull SlimefunAddon addon) {
        if (validateFlora()) {
            Registry.getInstance().addPlant(this);
            register(addon);
        }
    }

    /**
     * This method should validate a seed's fields have been initialised correctly
     * before it's registered. This will also set the Display plant used.
     * Be sure to call super() if extending further
     */
    @OverridingMethodsMustInvokeSuper
    protected abstract boolean validateFlora();

    @Nullable
    public ItemStack getDisplayItemStack() {
        return displayStack;
    }

}
