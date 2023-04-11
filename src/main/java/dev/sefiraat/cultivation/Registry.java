package dev.sefiraat.cultivation;

import com.google.common.base.Preconditions;
import dev.sefiraat.cultivation.api.slimefun.items.bushes.CultivationBush;
import dev.sefiraat.cultivation.api.slimefun.items.plants.CultivationPlant;
import dev.sefiraat.cultivation.api.slimefun.items.produce.ByProduct;
import dev.sefiraat.cultivation.api.slimefun.items.trees.CultivationTree;
import dev.sefiraat.cultivation.api.slimefun.plant.BreedResult;
import dev.sefiraat.cultivation.api.slimefun.plant.BreedResultType;
import dev.sefiraat.cultivation.api.slimefun.plant.BreedingPair;
import io.github.bakedlibs.dough.blocks.BlockPosition;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Registry {
    private static Registry instance;

    @Nonnull
    private final List<CultivationPlant> registeredPlants = new ArrayList<>();
    @Nonnull
    private final List<CultivationBush> registeredBushes = new ArrayList<>();
    @Nonnull
    private final List<CultivationTree> registeredTrees = new ArrayList<>();
    @Nonnull
    private final List<ByProduct> registeredByProducts = new ArrayList<>();
    @Nonnull
    private final List<BreedingPair> plantBreedingPairs = new ArrayList<>();

    @Nonnull
    private final Map<UUID, BlockPosition> storedPositionOne = new HashMap<>();

    @Nonnull
    private final Map<UUID, BlockPosition> storedPositionTwo = new HashMap<>();

    public Registry() {
        Preconditions.checkArgument(instance == null, "Cannot create a new instance of the Registry");
        instance = this;
    }

    public void addPlant(@Nonnull CultivationPlant cultivationPlant) {
        this.registeredPlants.add(cultivationPlant);
        this.plantBreedingPairs.addAll(cultivationPlant.getBreedingPairs());

    }

    public void addBush(@Nonnull CultivationBush cultivationBush) {
        this.registeredBushes.add(cultivationBush);
    }

    public void addTree(@Nonnull CultivationTree cultivationTree) {
        this.registeredTrees.add(cultivationTree);
    }

    public void addByProduct(@Nonnull ByProduct byProduct) {
        this.registeredByProducts.add(byProduct);
    }

    @Nonnull
    public BreedResult getBreedResult(@Nonnull String seed1, @Nonnull String seed2) {
        int matches = 0;
        for (BreedingPair pair : plantBreedingPairs) {
            BreedResultType result = pair.testBreed(seed1, seed2);
            if (result != BreedResultType.NOT_PAIR) {
                if (result != BreedResultType.FAIL) {
                    return new BreedResult(pair, result);
                } else {
                    matches++;
                }
            }
        }
        if (matches == 0) {
            if (seed1.equals(seed2)) {
                return new BreedResult(plantBreedingPairs.get(0), BreedResultType.SPREAD_MUTATE);
            } else {
                return new BreedResult(plantBreedingPairs.get(0), BreedResultType.NO_PAIRS);
            }
        } else {
            return new BreedResult(plantBreedingPairs.get(0), BreedResultType.FAIL);
        }
    }

    @Nonnull
    public List<CultivationPlant> getRegisteredPlants() {
        return Collections.unmodifiableList(registeredPlants);
    }

    @Nonnull
    public List<CultivationBush> getRegisteredBushes() {
        return Collections.unmodifiableList(registeredBushes);
    }

    @Nonnull
    public List<ByProduct> getRegisteredByProducts() {
        return registeredByProducts;
    }

    @Nonnull
    public List<CultivationTree> getRegisteredTrees() {
        return registeredTrees;
    }

    @Nonnull
    public List<BreedingPair> getPlantBreedingPairs() {
        return Collections.unmodifiableList(plantBreedingPairs);
    }

    public void addPositionOne(@Nonnull Player player) {
        UUID uuid = player.getUniqueId();
        storedPositionOne.put(uuid, new BlockPosition(player.getLocation()));
    }

    public void addPositionTwo(@Nonnull Player player) {
        UUID uuid = player.getUniqueId();
        storedPositionTwo.put(uuid, new BlockPosition(player.getLocation()));
    }

    @Nullable
    public BlockPosition getPositionOne(@Nonnull Player player) {
        return storedPositionOne.get(player.getUniqueId());
    }

    @Nullable
    public BlockPosition getPositionTwo(@Nonnull Player player) {
        return storedPositionTwo.get(player.getUniqueId());
    }

    public static Registry getInstance() {
        return instance;
    }
}
