package dev.sefiraat.cultivation.api.slimefun.items.plants;

import dev.sefiraat.cultivation.Registry;
import dev.sefiraat.cultivation.api.interfaces.CultivationFlora;
import dev.sefiraat.cultivation.api.interfaces.CustomPlacementBlock;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.api.slimefun.items.CultivationFloraItem;
import dev.sefiraat.cultivation.api.slimefun.plant.BreedResult;
import dev.sefiraat.cultivation.api.slimefun.plant.BreedResultType;
import dev.sefiraat.cultivation.api.slimefun.plant.BreedingPair;
import dev.sefiraat.cultivation.api.slimefun.plant.Growth;
import dev.sefiraat.cultivation.api.slimefun.plant.GrowthStages;
import dev.sefiraat.cultivation.api.slimefun.plant.PlantSkin;
import dev.sefiraat.cultivation.api.utils.LevelType;
import dev.sefiraat.cultivation.api.utils.StatisticUtils;
import dev.sefiraat.cultivation.implementation.utils.Keys;
import dev.sefiraat.sefilib.block.BlockUtils;
import dev.sefiraat.sefilib.misc.ParticleUtils;
import dev.sefiraat.sefilib.world.LocationUtils;
import io.github.bakedlibs.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.papermc.lib.PaperLib;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class is used to define a CultivationPlant that will grow as a {@link CultivationFlora}
 */
public abstract class CultivationPlant extends CultivationFloraItem<CultivationPlant>
    implements CultivationFlora, CustomPlacementBlock {

    @Nonnull
    public static final Set<BlockFace> BREEDING_DIRECTIONS = Set.of(
        BlockFace.NORTH,
        BlockFace.SOUTH,
        BlockFace.EAST,
        BlockFace.WEST
    );

    @Nonnull
    protected Set<BreedingPair> breedingPairs = new HashSet<>();

    @ParametersAreNonnullByDefault
    protected CultivationPlant(SlimefunItemStack item, Growth growth) {
        this(item, RecipeTypes.PLANT_BREEDING, new ItemStack[0], growth);
    }

    @ParametersAreNonnullByDefault
    protected CultivationPlant(SlimefunItemStack item,
                               RecipeType recipeType,
                               ItemStack[] recipe,
                               Growth growth
    ) {
        this(item, recipeType, recipe, growth, null);
    }

    @ParametersAreNonnullByDefault
    protected CultivationPlant(SlimefunItemStack item,
                               RecipeType recipeType,
                               ItemStack[] recipe,
                               Growth growth,
                               @Nullable ItemStack recipeOutput
    ) {
        super(CultivationGroups.PLANTS, item, recipeType, recipe, recipeOutput, growth);
    }

    @Override
    protected void tryBreed(@Nonnull Block motherBlock, @Nonnull CultivationPlant plant) {
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

            if (mateItem instanceof CultivationPlant mate) {
                testBreed(plant, mate, middleBlock, motherBlock);
            }
        }
    }

    @Override
    public void updateGrowthStage(@Nonnull Block block, int growthStage) {
        if (BlockUtils.isSkullBlock(block)) {
            final PlantSkin nextTexture = getGrowthStages().get(growthStage - 1);
            PlayerHead.setSkin(block, nextTexture.getPlayerSkin(), false);
            PaperLib.getBlockState(block, false).getState().update(true, false);
            BlockStorage.addBlockInfo(block, Keys.FLORA_GROWTH_STAGE, String.valueOf(growthStage));
            growthDisplay(block.getLocation());
        }
    }

    @Override
    public int getMaxGrowthStages() {
        if (growth.getStages() == null) {
            return 0;
        }
        return growth.getStages().stages();
    }

    /**
     * Defines the possible growth stages for this plant.
     *
     * @return The list of {@link GrowthStages} of valid growth stages (including the Seed)
     */
    @Nonnull
    public GrowthStages getGrowthStages() {
        if (growth.getStages() == null) {
            return GrowthStages.FUNGAL_BLUE;
        }
        return growth.getStages();
    }

    @ParametersAreNonnullByDefault
    private void testBreed(CultivationPlant mother, CultivationPlant mate, Block middleBlock, Block motherBlock) {
        final BreedResult result = Registry.getInstance().getBreedResult(mother.getId(), mate.getId());

        if (result.getResultType() == BreedResultType.NO_PAIRS) {
            // No matching breeding pairs, lets feedback to the player then move to the next direction
            breedInvalidDisplay(middleBlock.getLocation());
        } else if (result.getResultType() == BreedResultType.SUCCESS) {
            // Breed was a success - spawn child, log discovery
            final CultivationPlant child = result.getMatchedPair().getChild();
            trySetChildSeed(motherBlock.getLocation(), middleBlock, child);
            StatisticUtils.incrementExp(getOwner(motherBlock.getLocation()), LevelType.HORTICULTURALIST, 1);
        } else if (result.getResultType() == BreedResultType.SPREAD) {
            // Breed failed, spread success - spawn copy of mother
            trySetChildSeed(motherBlock.getLocation(), middleBlock, mother);
        }
    }

    private void breedInvalidDisplay(@Nonnull Location location) {
        ParticleUtils.displayParticleRandomly(
            LocationUtils.centre(location),
            0.5,
            2,
            new Particle.DustOptions(Color.BLACK, 1)
        );
    }

    @ParametersAreNonnullByDefault
    private void trySetChildSeed(Location motherLocation, Block cloneBlock, CultivationPlant childSeed) {
        cloneBlock.setType(Material.PLAYER_HEAD);
        PlayerHead.setSkin(cloneBlock, childSeed.getGrowthStages().get(0).getPlayerSkin(), false);
        PaperLib.getBlockState(cloneBlock, false).getState().update(true, false);
        BlockStorage.store(cloneBlock, childSeed.getId());
        BlockStorage.addBlockInfo(cloneBlock, Keys.FLORA_GROWTH_STAGE, "0");
        BlockStorage.addBlockInfo(cloneBlock, Keys.FLORA_OWNER, getOwner(motherLocation).toString());
        breedSuccess(cloneBlock.getLocation());
    }

    protected void breedSuccess(@Nonnull Location location) {
        ParticleUtils.displayParticleRandomly(LocationUtils.centre(location), Particle.SLIME, 0.5, 4);
    }

    /**
     * Adds a possible BreedingPair that will result in this seed as a child.
     * Can have multiple pairs resulting in the same child.
     *
     * @param mother       The ID of the potential Mother
     * @param father       The ID of the potential Mother
     * @param breedChance  The chance for the breed to return this plant
     * @param spreadChance The chance that the Mother will spread
     * @return Returns self
     */
    @Nonnull
    @ParametersAreNonnullByDefault
    public CultivationPlant addBreedingPair(String mother, String father, double breedChance, double spreadChance) {
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
}
