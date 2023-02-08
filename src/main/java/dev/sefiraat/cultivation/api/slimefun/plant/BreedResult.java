package dev.sefiraat.cultivation.api.slimefun.plant;

import javax.annotation.Nonnull;

public class BreedResult {

    @Nonnull
    private final BreedingPair matchedPair;
    @Nonnull
    private final BreedResultType resultType;

    /**
     * This class represents the result of a breeding attempt including the matched {@link BreedingPair}
     *
     * @param matchedPair The matching {@link BreedingPair} found when testing the possible breeds
     * @param resultType  The {@link BreedResultType} denoting the success type and/or failure
     */
    public BreedResult(@Nonnull BreedingPair matchedPair, @Nonnull BreedResultType resultType) {
        this.matchedPair = matchedPair;
        this.resultType = resultType;
    }

    @Nonnull
    public BreedingPair getMatchedPair() {
        return matchedPair;
    }

    @Nonnull
    public BreedResultType getResultType() {
        return resultType;
    }
}
