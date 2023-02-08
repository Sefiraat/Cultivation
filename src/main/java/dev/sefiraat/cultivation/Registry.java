package dev.sefiraat.cultivation;

import com.google.common.base.Preconditions;
import dev.sefiraat.cultivation.api.slimefun.items.CultivationSeed;
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
    private final List<CultivationSeed> registeredPlants = new ArrayList<>();
    @Nonnull
    private final List<BreedingPair> breedingPairs = new ArrayList<>();

    public Registry() {
        Preconditions.checkArgument(instance == null, "Cannot create a new instance of the Registry");
        instance = this;
    }

    public void addPlant(@Nonnull CultivationSeed cultivationSeed) {
        this.registeredPlants.add(cultivationSeed);
        this.breedingPairs.addAll(cultivationSeed.getBreedingPairs());
    }

    @Nonnull
    public BreedResult getBreedResult(@Nonnull String seed1, @Nonnull String seed2) {
        int matches = 0;
        for (BreedingPair pair : breedingPairs) {
            final BreedResultType result = pair.testBreed(seed1, seed2);
            if (result != BreedResultType.NOT_PAIR) {
                if (result != BreedResultType.FAIL) {
                    return new BreedResult(pair, result);
                } else {
                    matches++;
                }
            }
        }
        return new BreedResult(breedingPairs.get(0), matches == 0 ? BreedResultType.NO_PAIRS : BreedResultType.FAIL);
    }

    @Nonnull
    public List<CultivationSeed> getRegisteredPlants() {
        return Collections.unmodifiableList(registeredPlants);
    }

    @Nonnull
    public List<BreedingPair> getBreedingPairs() {
        return Collections.unmodifiableList(breedingPairs);
    }

    public static Registry getInstance() {
        return instance;
    }
}
