package dev.sefiraat.cultivation;

import com.google.common.base.Preconditions;
import dev.sefiraat.cultivation.api.interfaces.CultivationFlora;
import dev.sefiraat.cultivation.api.slimefun.items.plants.CultivationPlant;
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
    private final List<CultivationFlora> registeredFlora = new ArrayList<>();
    @Nonnull
    private final List<BreedingPair> breedingPairs = new ArrayList<>();

    @Nonnull
    private final Map<UUID, BlockPosition> storedPositionOne = new HashMap<>();

    @Nonnull
    private final Map<UUID, BlockPosition> storedPositionTwo = new HashMap<>();

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
    public List<CultivationFlora> getRegisteredFlora() {
        return Collections.unmodifiableList(registeredFlora);
    }

    @Nonnull
    public List<BreedingPair> getBreedingPairs() {
        return Collections.unmodifiableList(breedingPairs);
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
