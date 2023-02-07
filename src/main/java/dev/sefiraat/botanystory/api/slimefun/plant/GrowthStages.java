package dev.sefiraat.botanystory.api.slimefun.plant;

import dev.sefiraat.botanystory.api.utils.BotanyThemes;
import dev.sefiraat.sefilib.string.Theme;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * This class is used to define the seed item for a plant as well as the textures to be used
 * as the plant grows. It also contains the static instances of GrowthStages used in the addon
 */
public class GrowthStages {

    public static final GrowthStages VINEY_RED = new GrowthStages(
        BotanyThemes.SEED_RED,
        List.of(
            SeedSkin.SEED_RED,
            SeedSkin.VINEY_RED_1,
            SeedSkin.VINEY_RED_2,
            SeedSkin.VINEY_RED_3,
            SeedSkin.VINEY_RED_4,
            SeedSkin.VINEY_RED_5
        )
    );

    public static final GrowthStages VINEY_ORANGE = new GrowthStages(
        BotanyThemes.SEED_ORANGE,
        List.of(
            SeedSkin.SEED_ORANGE,
            SeedSkin.VINEY_ORANGE_1,
            SeedSkin.VINEY_ORANGE_2,
            SeedSkin.VINEY_ORANGE_3,
            SeedSkin.VINEY_ORANGE_4,
            SeedSkin.VINEY_ORANGE_5
        )
    );

    public static final GrowthStages VINEY_YELLOW = new GrowthStages(
        BotanyThemes.SEED_YELLOW,
        List.of(
            SeedSkin.SEED_YELLOW,
            SeedSkin.VINEY_YELLOW_1,
            SeedSkin.VINEY_YELLOW_2,
            SeedSkin.VINEY_YELLOW_3,
            SeedSkin.VINEY_YELLOW_4,
            SeedSkin.VINEY_YELLOW_5
        )
    );

    public static final GrowthStages VINEY_GREEN = new GrowthStages(
        BotanyThemes.SEED_GREEN,
        List.of(
            SeedSkin.SEED_GREEN,
            SeedSkin.VINEY_GREEN_1,
            SeedSkin.VINEY_GREEN_2,
            SeedSkin.VINEY_GREEN_3,
            SeedSkin.VINEY_GREEN_4,
            SeedSkin.VINEY_GREEN_5
        )
    );

    public static final GrowthStages VINEY_BLUE = new GrowthStages(
        BotanyThemes.SEED_BLUE,
        List.of(
            SeedSkin.SEED_BLUE,
            SeedSkin.VINEY_BLUE_1,
            SeedSkin.VINEY_BLUE_2,
            SeedSkin.VINEY_BLUE_3,
            SeedSkin.VINEY_BLUE_4,
            SeedSkin.VINEY_BLUE_5
        )
    );

    public static final GrowthStages VINEY_CYAN = new GrowthStages(
        BotanyThemes.SEED_CYAN,
        List.of(
            SeedSkin.SEED_CYAN,
            SeedSkin.VINEY_CYAN_1,
            SeedSkin.VINEY_CYAN_2,
            SeedSkin.VINEY_CYAN_3,
            SeedSkin.VINEY_CYAN_4,
            SeedSkin.VINEY_CYAN_5
        )
    );

    public static final GrowthStages VINEY_PURPLE = new GrowthStages(
        BotanyThemes.SEED_PURPLE,
        List.of(
            SeedSkin.SEED_PURPLE,
            SeedSkin.VINEY_PURPLE_1,
            SeedSkin.VINEY_PURPLE_2,
            SeedSkin.VINEY_PURPLE_3,
            SeedSkin.VINEY_PURPLE_4,
            SeedSkin.VINEY_PURPLE_5
        )
    );

    public static final GrowthStages SPAWNING_RED = new GrowthStages(
        BotanyThemes.SEED_RED,
        List.of(
            SeedSkin.SEED_RED,
            SeedSkin.SPAWNING_RED_1,
            SeedSkin.SPAWNING_RED_2,
            SeedSkin.SPAWNING_RED_3,
            SeedSkin.SPAWNING_RED_4,
            SeedSkin.SPAWNING_RED_5
        )
    );

    public static final GrowthStages SPAWNING_ORANGE = new GrowthStages(
        BotanyThemes.SEED_ORANGE,
        List.of(
            SeedSkin.SEED_ORANGE,
            SeedSkin.SPAWNING_ORANGE_1,
            SeedSkin.SPAWNING_ORANGE_2,
            SeedSkin.SPAWNING_ORANGE_3,
            SeedSkin.SPAWNING_ORANGE_4,
            SeedSkin.SPAWNING_ORANGE_5
        )
    );

    public static final GrowthStages SPAWNING_YELLOW = new GrowthStages(
        BotanyThemes.SEED_YELLOW,
        List.of(
            SeedSkin.SEED_YELLOW,
            SeedSkin.SPAWNING_YELLOW_1,
            SeedSkin.SPAWNING_YELLOW_2,
            SeedSkin.SPAWNING_YELLOW_3,
            SeedSkin.SPAWNING_YELLOW_4,
            SeedSkin.SPAWNING_YELLOW_5
        )
    );

    public static final GrowthStages SPAWNING_GREEN = new GrowthStages(
        BotanyThemes.SEED_GREEN,
        List.of(
            SeedSkin.SEED_GREEN,
            SeedSkin.SPAWNING_GREEN_1,
            SeedSkin.SPAWNING_GREEN_2,
            SeedSkin.SPAWNING_GREEN_3,
            SeedSkin.SPAWNING_GREEN_4,
            SeedSkin.SPAWNING_GREEN_5
        )
    );

    public static final GrowthStages SPAWNING_BLUE = new GrowthStages(
        BotanyThemes.SEED_BLUE,
        List.of(
            SeedSkin.SEED_BLUE,
            SeedSkin.SPAWNING_BLUE_1,
            SeedSkin.SPAWNING_BLUE_2,
            SeedSkin.SPAWNING_BLUE_3,
            SeedSkin.SPAWNING_BLUE_4,
            SeedSkin.SPAWNING_BLUE_5
        )
    );

    public static final GrowthStages SPAWNING_CYAN = new GrowthStages(
        BotanyThemes.SEED_CYAN,
        List.of(
            SeedSkin.SEED_CYAN,
            SeedSkin.SPAWNING_CYAN_1,
            SeedSkin.SPAWNING_CYAN_2,
            SeedSkin.SPAWNING_CYAN_3,
            SeedSkin.SPAWNING_CYAN_4,
            SeedSkin.SPAWNING_CYAN_5
        )
    );

    public static final GrowthStages SPAWNING_PURPLE = new GrowthStages(
        BotanyThemes.SEED_PURPLE,
        List.of(
            SeedSkin.SEED_PURPLE,
            SeedSkin.SPAWNING_PURPLE_1,
            SeedSkin.SPAWNING_PURPLE_2,
            SeedSkin.SPAWNING_PURPLE_3,
            SeedSkin.SPAWNING_PURPLE_4,
            SeedSkin.SPAWNING_PURPLE_5
        )
    );

    public static final GrowthStages SPIKEY_RED = new GrowthStages(
        BotanyThemes.SEED_RED,
        List.of(
            SeedSkin.SEED_RED,
            SeedSkin.SPIKEY_RED_1,
            SeedSkin.SPIKEY_RED_2,
            SeedSkin.SPIKEY_RED_3,
            SeedSkin.SPIKEY_RED_4,
            SeedSkin.SPIKEY_RED_5
        )
    );

    public static final GrowthStages SPIKEY_ORANGE = new GrowthStages(
        BotanyThemes.SEED_ORANGE,
        List.of(
            SeedSkin.SEED_ORANGE,
            SeedSkin.SPIKEY_ORANGE_1,
            SeedSkin.SPIKEY_ORANGE_2,
            SeedSkin.SPIKEY_ORANGE_3,
            SeedSkin.SPIKEY_ORANGE_4,
            SeedSkin.SPIKEY_ORANGE_5
        )
    );

    public static final GrowthStages SPIKEY_YELLOW = new GrowthStages(
        BotanyThemes.SEED_YELLOW,
        List.of(
            SeedSkin.SEED_YELLOW,
            SeedSkin.SPIKEY_YELLOW_1,
            SeedSkin.SPIKEY_YELLOW_2,
            SeedSkin.SPIKEY_YELLOW_3,
            SeedSkin.SPIKEY_YELLOW_4,
            SeedSkin.SPIKEY_YELLOW_5
        )
    );

    public static final GrowthStages SPIKEY_GREEN = new GrowthStages(
        BotanyThemes.SEED_GREEN,
        List.of(
            SeedSkin.SEED_GREEN,
            SeedSkin.SPIKEY_GREEN_1,
            SeedSkin.SPIKEY_GREEN_2,
            SeedSkin.SPIKEY_GREEN_3,
            SeedSkin.SPIKEY_GREEN_4,
            SeedSkin.SPIKEY_GREEN_5
        )
    );

    public static final GrowthStages SPIKEY_BLUE = new GrowthStages(
        BotanyThemes.SEED_BLUE,
        List.of(
            SeedSkin.SEED_BLUE,
            SeedSkin.SPIKEY_BLUE_1,
            SeedSkin.SPIKEY_BLUE_2,
            SeedSkin.SPIKEY_BLUE_3,
            SeedSkin.SPIKEY_BLUE_4,
            SeedSkin.SPIKEY_BLUE_5
        )
    );

    public static final GrowthStages SPIKEY_CYAN = new GrowthStages(
        BotanyThemes.SEED_CYAN,
        List.of(
            SeedSkin.SEED_CYAN,
            SeedSkin.SPIKEY_CYAN_1,
            SeedSkin.SPIKEY_CYAN_2,
            SeedSkin.SPIKEY_CYAN_3,
            SeedSkin.SPIKEY_CYAN_4,
            SeedSkin.SPIKEY_CYAN_5
        )
    );

    public static final GrowthStages SPIKEY_PURPLE = new GrowthStages(
        BotanyThemes.SEED_PURPLE,
        List.of(
            SeedSkin.SEED_PURPLE,
            SeedSkin.SPIKEY_PURPLE_1,
            SeedSkin.SPIKEY_PURPLE_2,
            SeedSkin.SPIKEY_PURPLE_3,
            SeedSkin.SPIKEY_PURPLE_4,
            SeedSkin.SPIKEY_PURPLE_5
        )
    );


    public static final GrowthStages FUNGAL_RED = new GrowthStages(
        BotanyThemes.SEED_RED,
        List.of(
            SeedSkin.SEED_RED,
            SeedSkin.FUNGAL_RED_1,
            SeedSkin.FUNGAL_RED_2,
            SeedSkin.FUNGAL_RED_3,
            SeedSkin.FUNGAL_RED_4,
            SeedSkin.FUNGAL_RED_5
        )
    );

    public static final GrowthStages FUNGAL_ORANGE = new GrowthStages(
        BotanyThemes.SEED_ORANGE,
        List.of(
            SeedSkin.SEED_ORANGE,
            SeedSkin.FUNGAL_ORANGE_1,
            SeedSkin.FUNGAL_ORANGE_2,
            SeedSkin.FUNGAL_ORANGE_3,
            SeedSkin.FUNGAL_ORANGE_4,
            SeedSkin.FUNGAL_ORANGE_5
        )
    );

    public static final GrowthStages FUNGAL_YELLOW = new GrowthStages(
        BotanyThemes.SEED_YELLOW,
        List.of(
            SeedSkin.SEED_YELLOW,
            SeedSkin.FUNGAL_YELLOW_1,
            SeedSkin.FUNGAL_YELLOW_2,
            SeedSkin.FUNGAL_YELLOW_3,
            SeedSkin.FUNGAL_YELLOW_4,
            SeedSkin.FUNGAL_YELLOW_5
        )
    );

    public static final GrowthStages FUNGAL_GREEN = new GrowthStages(
        BotanyThemes.SEED_GREEN,
        List.of(
            SeedSkin.SEED_GREEN,
            SeedSkin.FUNGAL_GREEN_1,
            SeedSkin.FUNGAL_GREEN_2,
            SeedSkin.FUNGAL_GREEN_3,
            SeedSkin.FUNGAL_GREEN_4,
            SeedSkin.FUNGAL_GREEN_5
        )
    );

    public static final GrowthStages FUNGAL_BLUE = new GrowthStages(
        BotanyThemes.SEED_BLUE,
        List.of(
            SeedSkin.SEED_BLUE,
            SeedSkin.FUNGAL_BLUE_1,
            SeedSkin.FUNGAL_BLUE_2,
            SeedSkin.FUNGAL_BLUE_3,
            SeedSkin.FUNGAL_BLUE_4,
            SeedSkin.FUNGAL_BLUE_5
        )
    );

    public static final GrowthStages FUNGAL_CYAN = new GrowthStages(
        BotanyThemes.SEED_CYAN,
        List.of(
            SeedSkin.SEED_CYAN,
            SeedSkin.FUNGAL_CYAN_1,
            SeedSkin.FUNGAL_CYAN_2,
            SeedSkin.FUNGAL_CYAN_3,
            SeedSkin.FUNGAL_CYAN_4,
            SeedSkin.FUNGAL_CYAN_5
        )
    );

    public static final GrowthStages FUNGAL_PURPLE = new GrowthStages(
        BotanyThemes.SEED_PURPLE,
        List.of(
            SeedSkin.SEED_PURPLE,
            SeedSkin.FUNGAL_PURPLE_1,
            SeedSkin.FUNGAL_PURPLE_2,
            SeedSkin.FUNGAL_PURPLE_3,
            SeedSkin.FUNGAL_PURPLE_4,
            SeedSkin.FUNGAL_PURPLE_5
        )
    );

    @Nonnull
    private final Theme theme;
    @Nonnull
    private final List<SeedSkin> stages;

    /**
     * This class is used to store the possible stages of growth a plant can go through
     * starting with a seed to its final step.
     *
     * @param theme  The {@link Theme} that will be used for particle effects and other appropriate needs
     * @param stages The {@link List} of SeedSkin that will be used as textures for each stage
     */
    public GrowthStages(@Nonnull Theme theme, @Nonnull List<SeedSkin> stages) {
        this.theme = theme;
        this.stages = stages;
    }

    @Nonnull
    public Theme getTheme() {
        return theme;
    }

    @Nonnull
    public List<SeedSkin> getStages() {
        return stages;
    }

    public int stages() {
        return stages.size();
    }

    @Nonnull
    public SeedSkin get(int index) {
        return stages.get(index);
    }
}
