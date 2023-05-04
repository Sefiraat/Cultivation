package dev.sefiraat.cultivation.api.slimefun.plant;

public enum BreedResultType {
    /**
     * Matching pair, but breed has failed, no changes
     */
    FAIL,
    /**
     * Breed triggered a spread of one of the original plants. Plants didn't match
     * and will not trigger a mutation
     */
    SPREAD_NO_MUTATE,
    /**
     * Breed triggered a spread of one of the original plants. Plants did match
     * and can now trigger a mutation
     */
    SPREAD_MUTATE,
    /**
     * Breed triggered a spread of one of the original plants. Plants did match
     * and can now trigger a mutation
     */
    SUCCESS_AND_MUTATION,
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
