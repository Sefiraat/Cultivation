package dev.sefiraat.botanystory.api.slimefun.plant;

public enum BreedResultType {
    /**
     * Matching pair, but breed has failed, no changes
     */
    FAIL,
    /**
     * Breed triggered a spread of the original plant
     */
    SPREAD,
    /**
     * Breed successful resulting in child plant
     */
    SUCCESS,
    /**
     * Not a pair
     */
    NOT_PAIR,
    /**
     * No pairs
     */
    NO_PAIRS
}
