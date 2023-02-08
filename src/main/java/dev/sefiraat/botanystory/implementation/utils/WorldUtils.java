package dev.sefiraat.botanystory.implementation.utils;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

import javax.annotation.Nonnull;
import java.util.concurrent.ThreadLocalRandom;

public final class WorldUtils {

    private WorldUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Checks if the world is provided is NORMAL
     *
     * @param entity The {@link Entity} who's world will be checked
     * @return true if the {@link World.Environment} is NORMAL
     */
    public static boolean inOverworld(@Nonnull Entity entity) {
        return inOverworld(entity.getWorld());
    }

    /**
     * Checks if the world is provided is NORMAL
     *
     * @param world The {@link World} to check the environment of
     * @return true if the {@link World.Environment} is NORMAL
     */
    public static boolean inOverworld(@Nonnull World world) {
        return world.getEnvironment() == World.Environment.NORMAL;
    }

    /**
     * Checks if the world is provided is NETHER
     *
     * @param entity The {@link Entity} who's world will be checked
     * @return true if the {@link World.Environment} is NETHER
     */
    public static boolean inNether(@Nonnull Entity entity) {
        return inNether(entity.getWorld());
    }

    /**
     * Checks if the world is provided is NETHER
     *
     * @param world The {@link World} to check the environment of
     * @return true if the {@link World.Environment} is NETHER
     */
    public static boolean inNether(@Nonnull World world) {
        return world.getEnvironment() == World.Environment.NETHER;
    }

    /**
     * Checks if the world is provided is END
     *
     * @param entity The {@link Entity} who's world will be checked
     * @return true if the {@link World.Environment} is END
     */
    public static boolean inEnd(@Nonnull Entity entity) {
        return inEnd(entity.getWorld());
    }

    /**
     * Checks if the world is provided is END
     *
     * @param world The {@link World} to check the environment of
     * @return true if the {@link World.Environment} is END
     */
    public static boolean inEnd(@Nonnull World world) {
        return world.getEnvironment() == World.Environment.THE_END;
    }

    /**
     * Picks a random location within a given range around a point
     *
     * @param centreLocation The {@link Location} which acts as the centre of the random check
     * @param range          The range in blocks in which to spread out from
     * @return The {@link Location} randomly selected
     */
    @Nonnull
    public static Location randomLocation(@Nonnull Location centreLocation, int range) {
        return randomLocation(centreLocation, range, range, range);
    }

    /**
     * Picks a random location within a given range around a point
     *
     * @param centreLocation The {@link Location} which acts as the centre of the random check
     * @param rangeX         The range in blocks in which to spread out from on the X axis
     * @param rangeY         The range in blocks in which to spread out from on the Y axis
     * @param rangeZ         The range in blocks in which to spread out from on the Z axis
     * @return The {@link Location} randomly selected
     */
    @Nonnull
    public static Location randomLocation(@Nonnull Location centreLocation, int rangeX, int rangeY, int rangeZ) {
        final double randomX = ThreadLocalRandom.current().nextInt(-rangeX, rangeX + 1);
        final double randomY = ThreadLocalRandom.current().nextInt(-rangeY, rangeY + 1);
        final double randomZ = ThreadLocalRandom.current().nextInt(-rangeZ, rangeZ + 1);
        return centreLocation.clone().add(randomX, randomY, randomZ);
    }

    /**
     * Gets a location in the middle of a block
     *
     * @param location The starting location
     * @return A clone of the given location centered to the middle of the block
     */
    @Nonnull
    public static Location centre(@Nonnull Location location) {
        return location.clone().add(0.5, 0.5, 0.5);
    }
}
