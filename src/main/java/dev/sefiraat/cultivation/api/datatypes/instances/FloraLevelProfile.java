package dev.sefiraat.cultivation.api.datatypes.instances;

import dev.sefiraat.cultivation.api.datatypes.FloraLevelProfileDataType;
import dev.sefiraat.cultivation.api.interfaces.CultivationLevelProfileHolder;
import dev.sefiraat.sefilib.misc.Chance;
import io.github.bakedlibs.dough.data.persistent.PersistentDataAPI;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

public class FloraLevelProfile {

    public static final String BS_KEY_LEVEL = "seed_level";
    public static final String BS_KEY_SPEED = "seed_speed";
    public static final String BS_KEY_STRENGTH = "seed_strength";

    private static final int MAX_LEVEL = 10;
    private static final int MAX_SPEED = 10;
    private static final int MAX_STRENGTH = 10;

    private static final double BASE_MUTATION_RATE = 0.1;

    private int level;
    private int speed;
    private int strength;

    public FloraLevelProfile(int level, int speed, int strength) {
        this.level = level;
        this.speed = speed;
        this.strength = strength;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = Math.max(Math.min(level, MAX_LEVEL), 0);
    }

    public void incrementLevel() {
        setLevel(getLevel() + 1);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = Math.max(Math.min(speed, MAX_SPEED), 0);
    }

    public void incrementSpeed() {
        setSpeed(getSpeed() + 1);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = Math.max(Math.min(strength, MAX_STRENGTH), 0);
    }

    public void incrementStrength() {
        setStrength(getStrength() + 1);
    }

    public static FloraLevelProfile testMutation(FloraLevelProfile profile1, FloraLevelProfile profile2) {
        int combinedLevel = profile1.getLevel() + profile2.getLevel();
        int averageLevel = (int) Math.ceil(combinedLevel / 2.0);

        int combinedSpeed = profile1.getSpeed() + profile2.getSpeed();
        int averageSpeed = (int) Math.ceil(combinedSpeed / 2.0);

        int combinedStrength = profile1.getStrength() + profile2.getStrength();
        int averageStrength = (int) Math.ceil(combinedStrength / 2.0);

        // Divide by 10 for int > double
        double mutateChance = BASE_MUTATION_RATE + (averageStrength / 10.0);

        return new FloraLevelProfile(
            Chance.testChance(mutateChance) ? Math.min(averageLevel + 1, 10) : averageLevel,
            Chance.testChance(mutateChance) ? Math.min(averageSpeed + 1, 10) : averageSpeed,
            Chance.testChance(mutateChance) ? Math.min(averageStrength + 1, 10) : averageStrength
        );
    }

    @Nonnull
    public static FloraLevelProfile fromItemStack(@Nonnull ItemStack itemStack) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        FloraLevelProfile profile = PersistentDataAPI.get(
            itemMeta,
            FloraLevelProfileDataType.KEY,
            FloraLevelProfileDataType.TYPE
        );
        return Objects.requireNonNullElseGet(profile, () -> new FloraLevelProfile(1, 1, 1));
    }

    @Nullable
    public static FloraLevelProfile fromBlockStorage(@Nonnull Block block) {
        return fromBlockStorage(block.getLocation());
    }

    @Nullable
    public static FloraLevelProfile fromBlockStorage(@Nonnull Location location) {
        SlimefunItem slimefunItem = BlockStorage.check(location);
        if (slimefunItem instanceof CultivationLevelProfileHolder holder) {
            return holder.getLevelProfile(location);
        }
        return null;
    }
}
