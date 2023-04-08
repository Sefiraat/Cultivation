package dev.sefiraat.cultivation;

import com.google.common.base.Preconditions;
import dev.sefiraat.cultivation.api.slimefun.items.bushes.CultivationBush;
import dev.sefiraat.cultivation.api.slimefun.items.plants.CultivationPlant;
import dev.sefiraat.cultivation.api.slimefun.plant.BreedResult;
import dev.sefiraat.cultivation.api.slimefun.plant.BreedResultType;
import dev.sefiraat.cultivation.api.slimefun.plant.BreedingPair;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Registry {
    private static Registry instance;

    @Nonnull
    private final List<CultivationPlant> registeredPlants = new ArrayList<>();
    @Nonnull
    private final List<CultivationBush> registeredBushes = new ArrayList<>();
    @Nonnull
    private final List<BreedingPair> plantBreedingPairs = new ArrayList<>();

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
    public List<BreedingPair> getPlantBreedingPairs() {
        return Collections.unmodifiableList(plantBreedingPairs);
    }

    public static Registry getInstance() {
        return instance;
    }
}
