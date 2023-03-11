package dev.sefiraat.cultivation;

import com.google.common.base.Preconditions;
import dev.sefiraat.cultivation.api.interfaces.CultivationFlora;
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
    private final List<CultivationFlora> registeredFlora = new ArrayList<>();
    @Nonnull
    private final List<BreedingPair> breedingPairs = new ArrayList<>();

    public Registry() {
        Preconditions.checkArgument(instance == null, "Cannot create a new instance of the Registry");
        instance = this;
    }

    public void addFlora(@Nonnull CultivationFlora cultivationFlora) {
        // todo Split into different types of flora into other dicts
        this.registeredFlora.add(cultivationFlora);
        if (cultivationFlora instanceof CultivationPlant plant) {
            this.breedingPairs.addAll(plant.getBreedingPairs());
        }
    }

    @Nonnull
    public BreedResult getBreedResult(@Nonnull String seed1, @Nonnull String seed2) {
        int matches = 0;
        for (BreedingPair pair : breedingPairs) {
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
                return new BreedResult(breedingPairs.get(0), BreedResultType.SPREAD_MUTATE);
            } else {
                return new BreedResult(breedingPairs.get(0), BreedResultType.NO_PAIRS);
            }
        } else {
            return new BreedResult(breedingPairs.get(0), BreedResultType.FAIL);
        }
    }

    @Nonnull
    public List<CultivationFlora> getRegisteredFlora() {
        return Collections.unmodifiableList(registeredFlora);
    }

    @Nonnull
    public List<BreedingPair> getBreedingPairs() {
        return Collections.unmodifiableList(breedingPairs);
    }

    public static Registry getInstance() {
        return instance;
    }
}
