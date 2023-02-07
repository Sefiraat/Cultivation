package dev.sefiraat.botanystory.api.slimefun.plant;

import dev.sefiraat.botanystory.api.slimefun.items.BotanySeed;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Defines how a plant can/will breed
 */
public class BreedingPair {

    @Nonnull
    private final BotanySeed childId;
    @Nonnull
    private final String motherId;
    @Nonnull
    private final String fatherId;
    private final double breedChance;
    private final double spreadChance;

    /**
     * This class defines a possible breeding pair, the chance of success or spread
     *
     * @param childId      The {@link BotanySeed} that will grow as a result of a successful breed
     * @param motherId     The {@link BotanySeed}'s ID representing one of the parents (the one initiating the breed)
     * @param fatherId     The {@link BotanySeed}'s ID representing the other parent
     * @param breedChance  The chance for the breed to be successful (spawning a child)
     * @param spreadChance The chance that, should a true breed fail, a spread can occur (spawning a copy of the mother)
     */
    @ParametersAreNonnullByDefault
    public BreedingPair(BotanySeed childId,
                        String motherId,
                        String fatherId,
                        double breedChance,
                        double spreadChance
    ) {
        this.childId = childId;
        this.motherId = motherId;
        this.fatherId = fatherId;
        this.breedChance = breedChance;
        this.spreadChance = spreadChance;
    }

    @Nonnull
    public BotanySeed getChild() {
        return childId;
    }

    @Nonnull
    public String getMotherId() {
        return motherId;
    }

    @Nonnull
    public String getFatherId() {
        return fatherId;
    }

    /**
     * Checks if the two given seeds can breed regardless of chance.
     * No need to call this if you will also be rolling
     *
     * @param seed1 The first {@link BotanySeed}'s ID to check for breeding
     * @param seed2 The partner {@link BotanySeed}'s ID to check against the first.
     * @return True if the plants can breed
     */
    public boolean isBreedPossible(@Nonnull String seed1, @Nonnull String seed2) {
        if (seed1.equals(motherId)) {
            return seed2.equals(fatherId);
        } else if (seed1.equals(fatherId)) {
            return seed2.equals(motherId);
        }
        return false;
    }

    /**
     * Checks if the two given seeds can breed and, if so, tests against the
     * chances to get the breed result
     *
     * @param seed1 The first {@link BotanySeed} to check for breeding
     * @param seed2 The partner {@link BotanySeed} to check against the first.
     * @return The {@link BreedResultType} of the breed attampt
     */
    @Nonnull
    public BreedResultType testBreed(@Nonnull String seed1, @Nonnull String seed2) {
        if (isBreedPossible(seed1, seed2)) {
            final double chance = ThreadLocalRandom.current().nextDouble();
            if (chance <= getBreedChance()) {
                return BreedResultType.SUCCESS;
            } else if (chance <= getSpreadBreedChance()) {
                return BreedResultType.SPREAD;
            }
        } else {
            return BreedResultType.NOT_PAIR;
        }
        return BreedResultType.FAIL;
    }

    public double getBreedChance() {
        return breedChance;
    }

    public double getSpreadBreedChance() {
        return spreadChance;
    }
}
