package dev.sefiraat.cultivation.api.slimefun.items;

import com.google.common.base.Preconditions;
import dev.sefiraat.cultivation.Registry;
import dev.sefiraat.cultivation.api.events.PlantGrowEvent;
import dev.sefiraat.cultivation.api.interfaces.CultivationPlant;
import dev.sefiraat.cultivation.api.interfaces.CustomPlacementBlock;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.api.slimefun.plant.BreedResult;
import dev.sefiraat.cultivation.api.slimefun.plant.BreedResultType;
import dev.sefiraat.cultivation.api.slimefun.plant.BreedingPair;
import dev.sefiraat.cultivation.api.slimefun.plant.Growth;
import dev.sefiraat.cultivation.api.slimefun.plant.GrowthStages;
import dev.sefiraat.cultivation.api.slimefun.plant.SeedSkin;
import dev.sefiraat.cultivation.api.utils.LevelType;
import dev.sefiraat.cultivation.api.utils.StatisticUtils;
import dev.sefiraat.cultivation.implementation.listeners.CustomPlacementListener;
import dev.sefiraat.cultivation.implementation.utils.Keys;
import dev.sefiraat.cultivation.implementation.utils.WorldUtils;
import dev.sefiraat.sefilib.block.BlockUtils;
import dev.sefiraat.sefilib.misc.ParticleUtils;
import dev.sefiraat.sefilib.string.Theme;
import io.github.bakedlibs.dough.items.CustomItemStack;
import io.github.bakedlibs.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockUseHandler;
import io.papermc.lib.PaperLib;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Bukkit;
import org.bukkit.Color;
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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.OverridingMethodsMustInvokeSuper;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class is used to define a CultivationSeed that will grow as a {@link CultivationPlant}
 */
public abstract class CultivationSeed extends SlimefunItem implements CultivationPlant, CustomPlacementBlock {

    @Nonnull
    public static final Set<BlockFace> BREEDING_DIRECTIONS = Set.of(
        BlockFace.NORTH,
        BlockFace.SOUTH,
        BlockFace.EAST,
        BlockFace.WEST
    );

    @Nonnull
    protected final Map<Location, UUID> ownerCache = new HashMap<>();
    @Nonnull
    protected Growth growth;
    @Nullable
    protected ItemStack displayPlant;
    @Nonnull
    protected Set<BreedingPair> breedingPairs = new HashSet<>();

    @Nullable
    protected ItemStack crushingDrop;

    @ParametersAreNonnullByDefault
    protected CultivationSeed(SlimefunItemStack item, Growth growth) {
        this(item, RecipeTypes.PLANT_BREEDING, new ItemStack[0], growth);
    }

    @ParametersAreNonnullByDefault
    protected CultivationSeed(SlimefunItemStack item,
                              RecipeType recipeType,
                              ItemStack[] recipe,
                              Growth growth
    ) {
        this(item, recipeType, recipe, growth, null);
    }

    @ParametersAreNonnullByDefault
    protected CultivationSeed(SlimefunItemStack item,
                              RecipeType recipeType,
                              ItemStack[] recipe,
                              Growth growth,
                              @Nullable ItemStack recipeOutput
    ) {
        super(CultivationGroups.SEEDS, item, recipeType, recipe, recipeOutput);
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
                    if (item instanceof CultivationSeed seed) {
                        onTick(block, seed, data);
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

    @ParametersAreNonnullByDefault
    private void onTick(Block block, CultivationSeed seed, Config data) {
        final Location location = block.getLocation();
        int growthStage = Integer.parseInt(data.getString(Keys.SEED_GROWTH_STAGE));
        onTickAlways(location, seed, data);
        if (growthStage >= getGrowthStages().stages()) {
            onTickFullyGrown(location, seed, data);
            tryBreed(block, seed);
        } else {
            tryGrow(block, seed, data, location, growthStage);
        }
    }

    /**
     * Can be overridden by implementations to add an effect when the block is right-clicked.
     *
     * @param event The {@link PlayerRightClickEvent} being sent from Slimefun
     */
    protected void onBlockUse(@Nonnull PlayerRightClickEvent event) {

    }

    private void tryBreed(@Nonnull Block motherBlock, @Nonnull CultivationSeed mother) {
        final double breedChance = ThreadLocalRandom.current().nextDouble();
        if (breedChance > getGrowthRate()) {
            // No breed attempted this tick
            return;
        }

        for (BlockFace face : BREEDING_DIRECTIONS) {
            final Block middleBlock = motherBlock.getRelative(face);
            // There must be space for the new block
            if (middleBlock.getType() != Material.AIR) {
                return;
            }
            final Block potentialMate = middleBlock.getRelative(face);
            final SlimefunItem mateItem = BlockStorage.check(potentialMate);

            if (mateItem instanceof CultivationSeed mate) {
                testBreed(mother, mate, middleBlock, motherBlock);
            }
        }
    }

    @ParametersAreNonnullByDefault
    private void testBreed(CultivationSeed mother, CultivationSeed mate, Block middleBlock, Block motherBlock) {
        final BreedResult result = Registry.getInstance().getBreedResult(mother.getId(), mate.getId());

        if (result.getResultType() == BreedResultType.NO_PAIRS) {
            // No matching breeding pairs, lets feedback to the player then move to the next direction
            breedInvalidDisplay(middleBlock.getLocation());
        } else if (result.getResultType() == BreedResultType.SUCCESS) {
            // Breed was a success - spawn child, log discovery
            final CultivationSeed child = result.getMatchedPair().getChild();
            trySetChildSeed(motherBlock.getLocation(), middleBlock, child);
            StatisticUtils.incrementExp(getOwner(motherBlock.getLocation()), LevelType.HORTICULTURALIST, 1);
        } else if (result.getResultType() == BreedResultType.SPREAD) {
            // Breed failed, spread success - spawn copy of mother
            trySetChildSeed(motherBlock.getLocation(), middleBlock, mother);
        }
    }

    @ParametersAreNonnullByDefault
    private void tryGrow(Block block, CultivationSeed seed, Config data, Location location, int growthStage) {
        final double growthRandom = ThreadLocalRandom.current().nextDouble();
        if (growthRandom <= getGrowthRate() && getGrowthStages().stages() > growthStage) {
            PlantGrowEvent event = new PlantGrowEvent(location, seed, growthStage);
            Bukkit.getPluginManager().callEvent(event);
            if (event.isCancelled()) {
                return;
            }
            updateGrowthStage(block, growthStage + 1);
            if (getGrowthStages().stages() == growthStage + 1) {
                StatisticUtils.incrementExp(getOwner(location), LevelType.HORTICULTURALIST, 1);
                onFullyMatures(location, seed, data);
                finalGrowthDisplay(location);
            }
        }
    }

    private void breedInvalidDisplay(@Nonnull Location location) {
        ParticleUtils.displayParticleRandomly(
            WorldUtils.centre(location),
            0.5,
            2,
            new Particle.DustOptions(Color.BLACK, 1)
        );
    }

    @ParametersAreNonnullByDefault
    private void trySetChildSeed(Location motherLocation, Block cloneBlock, CultivationSeed childSeed) {
        cloneBlock.setType(Material.PLAYER_HEAD);
        PlayerHead.setSkin(cloneBlock, childSeed.getGrowthStages().get(0).getPlayerSkin(), false);
        PaperLib.getBlockState(cloneBlock, false).getState().update(true, false);
        BlockStorage.store(cloneBlock, childSeed.getId());
        BlockStorage.addBlockInfo(cloneBlock, Keys.SEED_GROWTH_STAGE, "0");
        BlockStorage.addBlockInfo(cloneBlock, Keys.BLOCK_OWNER, getOwner(motherLocation).toString());
        breedSuccess(cloneBlock.getLocation());
    }

    @Nonnull
    public UUID getOwner(@Nonnull Location location) {
        UUID uuid = ownerCache.get(location);
        // Owner cannot be null if called correctly
        Preconditions.checkNotNull(uuid, "Owner is null, has this been called correctly");
        return uuid;
    }

    public void updateGrowthStage(@Nonnull Block block, int growthStage) {
        if (BlockUtils.isSkullBlock(block)) {
            final SeedSkin nextTexture = getGrowthStages().get(growthStage - 1);
            PlayerHead.setSkin(block, nextTexture.getPlayerSkin(), false);
            PaperLib.getBlockState(block, false).getState().update(true, false);
            BlockStorage.addBlockInfo(block, Keys.SEED_GROWTH_STAGE, String.valueOf(growthStage));
            growthDisplay(block.getLocation());
        }
    }

    private void finalGrowthDisplay(@Nonnull Location location) {
        ParticleUtils.displayParticleRandomly(WorldUtils.centre(location), Particle.WAX_ON, 0.5, 4);
    }

    private void breedSuccess(@Nonnull Location location) {
        ParticleUtils.displayParticleRandomly(WorldUtils.centre(location), Particle.SLIME, 0.5, 4);
    }

    private void growthDisplay(@Nonnull Location location) {
        ParticleUtils.displayParticleRandomly(WorldUtils.centre(location), 0.5, 4, getTheme().getDustOptions(1f));
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

    @Nonnull
    @Override
    public GrowthStages getGrowthStages() {
        return growth.getStages();
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
                final String owner = BlockStorage.getLocationInfo(block.getLocation(), Keys.BLOCK_OWNER);
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

    public boolean isMature(@Nonnull Block block) {
        return isMature(block.getLocation());
    }

    public boolean isMature(@Nonnull Location location) {
        final String stage = BlockStorage.getLocationInfo(location, Keys.SEED_GROWTH_STAGE);
        if (stage == null) {
            return false;
        }
        final int growthStage = Integer.parseInt(stage);
        return growthStage >= getGrowthStages().stages();
    }

    public void updateGrowthStage(@Nonnull Location location, int growthStage) {
        updateGrowthStage(location.getBlock(), growthStage);
    }

    /**
     * This method is fired when the block is placed
     * see {@link CustomPlacementListener}
     *
     * @param event The {@link BlockPlaceEvent} triggered from the block placement
     */
    public void whenPlaced(@Nonnull BlockPlaceEvent event) {
        final Block block = event.getBlock();
        final Block blockBelow = block.getRelative(BlockFace.DOWN);
        final Location location = block.getLocation();

        if (getPlacements().contains(blockBelow.getType())) {
            final UUID uuid = event.getPlayer().getUniqueId();
            BlockStorage.addBlockInfo(location, Keys.SEED_GROWTH_STAGE, "0");
            BlockStorage.addBlockInfo(location, Keys.BLOCK_OWNER, uuid.toString());
            ownerCache.put(location, uuid);
            return;
        }
        // Can't be placed here so cancel the event
        event.setCancelled(true);
    }

    /**
     * Sets the {@link Growth} of the plant
     *
     * @param growth The required {@link Growth}
     */
    @Nonnull
    public CultivationSeed setGrowth(@Nonnull Growth growth) {
        this.growth = growth;
        String[] lore = new String[0];
        if (this.getItem().getItemMeta().hasLore()) {
            lore = this.getItem().getItemMeta().getLore().toArray(lore);
        }
        this.displayPlant = new CustomItemStack(
            this.growth.getFullyGrownPlant(),
            this.getItemName(),
            lore
        );
        return this;
    }

    /**
     * Adds a possible BreedingPair that will result in this seed as a child.
     * Can have multiple pairs resulting in the same child.
     *
     * @param mother       The ID of the potential Mother
     * @param father       The ID of the potential Mother
     * @param breedChance  The chance for the breed to return this seed
     * @param spreadChance The chance that the Mother will spread
     * @return Returns self
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public CultivationSeed addBreedingPair(String mother, String father, double breedChance, double spreadChance) {
        this.breedingPairs.add(new BreedingPair(this, mother, father, breedChance, spreadChance));
        return this;
    }

    /**
     * Gets all the possible ways this plant can be bred
     *
     * @return The {@link Set} of {@link BreedingPair}s this plant can be bred from
     */
    @Nonnull
    public Set<BreedingPair> getBreedingPairs() {
        return this.breedingPairs;
    }

    /**
     * Tries to register the seed (if it passes validation) first into the Registry, then its
     * breeding pairs and finally with Slimefun.
     *
     * @param addon The addon registering this Seed
     */
    public void tryRegister(@Nonnull SlimefunAddon addon) {
        if (validateSeed()) {
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
    protected abstract boolean validateSeed();

    @Nullable
    public ItemStack getDisplayPlant() {
        return displayPlant;
    }
}
