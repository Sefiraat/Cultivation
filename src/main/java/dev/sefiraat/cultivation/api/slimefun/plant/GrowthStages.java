package dev.sefiraat.cultivation.api.slimefun.plant;

import dev.sefiraat.cultivation.api.utils.CultivationThemes;
import dev.sefiraat.sefilib.string.Theme;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * This class is used to define the CultivationPlant for a plant as well as the textures to be used
 * as the plant grows. It also contains the static instances of GrowthStages used in the addon
 */
public class GrowthStages {

    public static final GrowthStages VINEY_RED = new GrowthStages(
        CultivationThemes.SEED_RED,
        List.of(
            PlantSkin.SEED_RED,
            PlantSkin.VINEY_RED_1,
            PlantSkin.VINEY_RED_2,
            PlantSkin.VINEY_RED_3,
            PlantSkin.VINEY_RED_4,
            PlantSkin.VINEY_RED_5
        )
    );

    public static final GrowthStages VINEY_ORANGE = new GrowthStages(
        CultivationThemes.SEED_ORANGE,
        List.of(
            PlantSkin.SEED_ORANGE,
            PlantSkin.VINEY_ORANGE_1,
            PlantSkin.VINEY_ORANGE_2,
            PlantSkin.VINEY_ORANGE_3,
            PlantSkin.VINEY_ORANGE_4,
            PlantSkin.VINEY_ORANGE_5
        )
    );

    public static final GrowthStages VINEY_YELLOW = new GrowthStages(
        CultivationThemes.SEED_YELLOW,
        List.of(
            PlantSkin.SEED_YELLOW,
            PlantSkin.VINEY_YELLOW_1,
            PlantSkin.VINEY_YELLOW_2,
            PlantSkin.VINEY_YELLOW_3,
            PlantSkin.VINEY_YELLOW_4,
            PlantSkin.VINEY_YELLOW_5
        )
    );

    public static final GrowthStages VINEY_GREEN = new GrowthStages(
        CultivationThemes.SEED_GREEN,
        List.of(
            PlantSkin.SEED_GREEN,
            PlantSkin.VINEY_GREEN_1,
            PlantSkin.VINEY_GREEN_2,
            PlantSkin.VINEY_GREEN_3,
            PlantSkin.VINEY_GREEN_4,
            PlantSkin.VINEY_GREEN_5
        )
    );

    public static final GrowthStages VINEY_BLUE = new GrowthStages(
        CultivationThemes.SEED_BLUE,
        List.of(
            PlantSkin.SEED_BLUE,
            PlantSkin.VINEY_BLUE_1,
            PlantSkin.VINEY_BLUE_2,
            PlantSkin.VINEY_BLUE_3,
            PlantSkin.VINEY_BLUE_4,
            PlantSkin.VINEY_BLUE_5
        )
    );

    public static final GrowthStages VINEY_CYAN = new GrowthStages(
        CultivationThemes.SEED_CYAN,
        List.of(
            PlantSkin.SEED_CYAN,
            PlantSkin.VINEY_CYAN_1,
            PlantSkin.VINEY_CYAN_2,
            PlantSkin.VINEY_CYAN_3,
            PlantSkin.VINEY_CYAN_4,
            PlantSkin.VINEY_CYAN_5
        )
    );

    public static final GrowthStages VINEY_PURPLE = new GrowthStages(
        CultivationThemes.SEED_PURPLE,
        List.of(
            PlantSkin.SEED_PURPLE,
            PlantSkin.VINEY_PURPLE_1,
            PlantSkin.VINEY_PURPLE_2,
            PlantSkin.VINEY_PURPLE_3,
            PlantSkin.VINEY_PURPLE_4,
            PlantSkin.VINEY_PURPLE_5
        )
    );

    public static final GrowthStages SPAWNING_RED = new GrowthStages(
        CultivationThemes.SEED_RED,
        List.of(
            PlantSkin.SEED_RED,
            PlantSkin.SPAWNING_RED_1,
            PlantSkin.SPAWNING_RED_2,
            PlantSkin.SPAWNING_RED_3,
            PlantSkin.SPAWNING_RED_4,
            PlantSkin.SPAWNING_RED_5
        )
    );

    public static final GrowthStages SPAWNING_ORANGE = new GrowthStages(
        CultivationThemes.SEED_ORANGE,
        List.of(
            PlantSkin.SEED_ORANGE,
            PlantSkin.SPAWNING_ORANGE_1,
            PlantSkin.SPAWNING_ORANGE_2,
            PlantSkin.SPAWNING_ORANGE_3,
            PlantSkin.SPAWNING_ORANGE_4,
            PlantSkin.SPAWNING_ORANGE_5
        )
    );

    public static final GrowthStages SPAWNING_YELLOW = new GrowthStages(
        CultivationThemes.SEED_YELLOW,
        List.of(
            PlantSkin.SEED_YELLOW,
            PlantSkin.SPAWNING_YELLOW_1,
            PlantSkin.SPAWNING_YELLOW_2,
            PlantSkin.SPAWNING_YELLOW_3,
            PlantSkin.SPAWNING_YELLOW_4,
            PlantSkin.SPAWNING_YELLOW_5
        )
    );

    public static final GrowthStages SPAWNING_GREEN = new GrowthStages(
        CultivationThemes.SEED_GREEN,
        List.of(
            PlantSkin.SEED_GREEN,
            PlantSkin.SPAWNING_GREEN_1,
            PlantSkin.SPAWNING_GREEN_2,
            PlantSkin.SPAWNING_GREEN_3,
            PlantSkin.SPAWNING_GREEN_4,
            PlantSkin.SPAWNING_GREEN_5
        )
    );

    public static final GrowthStages SPAWNING_BLUE = new GrowthStages(
        CultivationThemes.SEED_BLUE,
        List.of(
            PlantSkin.SEED_BLUE,
            PlantSkin.SPAWNING_BLUE_1,
            PlantSkin.SPAWNING_BLUE_2,
            PlantSkin.SPAWNING_BLUE_3,
            PlantSkin.SPAWNING_BLUE_4,
            PlantSkin.SPAWNING_BLUE_5
        )
    );

    public static final GrowthStages SPAWNING_CYAN = new GrowthStages(
        CultivationThemes.SEED_CYAN,
        List.of(
            PlantSkin.SEED_CYAN,
            PlantSkin.SPAWNING_CYAN_1,
            PlantSkin.SPAWNING_CYAN_2,
            PlantSkin.SPAWNING_CYAN_3,
            PlantSkin.SPAWNING_CYAN_4,
            PlantSkin.SPAWNING_CYAN_5
        )
    );

    public static final GrowthStages SPAWNING_PURPLE = new GrowthStages(
        CultivationThemes.SEED_PURPLE,
        List.of(
            PlantSkin.SEED_PURPLE,
            PlantSkin.SPAWNING_PURPLE_1,
            PlantSkin.SPAWNING_PURPLE_2,
            PlantSkin.SPAWNING_PURPLE_3,
            PlantSkin.SPAWNING_PURPLE_4,
            PlantSkin.SPAWNING_PURPLE_5
        )
    );

    public static final GrowthStages SPIKEY_RED = new GrowthStages(
        CultivationThemes.SEED_RED,
        List.of(
            PlantSkin.SEED_RED,
            PlantSkin.SPIKEY_RED_1,
            PlantSkin.SPIKEY_RED_2,
            PlantSkin.SPIKEY_RED_3,
            PlantSkin.SPIKEY_RED_4,
            PlantSkin.SPIKEY_RED_5
        )
    );

    public static final GrowthStages SPIKEY_ORANGE = new GrowthStages(
        CultivationThemes.SEED_ORANGE,
        List.of(
            PlantSkin.SEED_ORANGE,
            PlantSkin.SPIKEY_ORANGE_1,
            PlantSkin.SPIKEY_ORANGE_2,
            PlantSkin.SPIKEY_ORANGE_3,
            PlantSkin.SPIKEY_ORANGE_4,
            PlantSkin.SPIKEY_ORANGE_5
        )
    );

    public static final GrowthStages SPIKEY_YELLOW = new GrowthStages(
        CultivationThemes.SEED_YELLOW,
        List.of(
            PlantSkin.SEED_YELLOW,
            PlantSkin.SPIKEY_YELLOW_1,
            PlantSkin.SPIKEY_YELLOW_2,
            PlantSkin.SPIKEY_YELLOW_3,
            PlantSkin.SPIKEY_YELLOW_4,
            PlantSkin.SPIKEY_YELLOW_5
        )
    );

    public static final GrowthStages SPIKEY_GREEN = new GrowthStages(
        CultivationThemes.SEED_GREEN,
        List.of(
            PlantSkin.SEED_GREEN,
            PlantSkin.SPIKEY_GREEN_1,
            PlantSkin.SPIKEY_GREEN_2,
            PlantSkin.SPIKEY_GREEN_3,
            PlantSkin.SPIKEY_GREEN_4,
            PlantSkin.SPIKEY_GREEN_5
        )
    );

    public static final GrowthStages SPIKEY_BLUE = new GrowthStages(
        CultivationThemes.SEED_BLUE,
        List.of(
            PlantSkin.SEED_BLUE,
            PlantSkin.SPIKEY_BLUE_1,
            PlantSkin.SPIKEY_BLUE_2,
            PlantSkin.SPIKEY_BLUE_3,
            PlantSkin.SPIKEY_BLUE_4,
            PlantSkin.SPIKEY_BLUE_5
        )
    );

    public static final GrowthStages SPIKEY_CYAN = new GrowthStages(
        CultivationThemes.SEED_CYAN,
        List.of(
            PlantSkin.SEED_CYAN,
            PlantSkin.SPIKEY_CYAN_1,
            PlantSkin.SPIKEY_CYAN_2,
            PlantSkin.SPIKEY_CYAN_3,
            PlantSkin.SPIKEY_CYAN_4,
            PlantSkin.SPIKEY_CYAN_5
        )
    );

    public static final GrowthStages SPIKEY_PURPLE = new GrowthStages(
        CultivationThemes.SEED_PURPLE,
        List.of(
            PlantSkin.SEED_PURPLE,
            PlantSkin.SPIKEY_PURPLE_1,
            PlantSkin.SPIKEY_PURPLE_2,
            PlantSkin.SPIKEY_PURPLE_3,
            PlantSkin.SPIKEY_PURPLE_4,
            PlantSkin.SPIKEY_PURPLE_5
        )
    );


    public static final GrowthStages FUNGAL_RED = new GrowthStages(
        CultivationThemes.SEED_RED,
        List.of(
            PlantSkin.SEED_RED,
            PlantSkin.FUNGAL_RED_1,
            PlantSkin.FUNGAL_RED_2,
            PlantSkin.FUNGAL_RED_3,
            PlantSkin.FUNGAL_RED_4,
            PlantSkin.FUNGAL_RED_5
        )
    );

    public static final GrowthStages FUNGAL_ORANGE = new GrowthStages(
        CultivationThemes.SEED_ORANGE,
        List.of(
            PlantSkin.SEED_ORANGE,
            PlantSkin.FUNGAL_ORANGE_1,
            PlantSkin.FUNGAL_ORANGE_2,
            PlantSkin.FUNGAL_ORANGE_3,
            PlantSkin.FUNGAL_ORANGE_4,
            PlantSkin.FUNGAL_ORANGE_5
        )
    );

    public static final GrowthStages FUNGAL_YELLOW = new GrowthStages(
        CultivationThemes.SEED_YELLOW,
        List.of(
            PlantSkin.SEED_YELLOW,
            PlantSkin.FUNGAL_YELLOW_1,
            PlantSkin.FUNGAL_YELLOW_2,
            PlantSkin.FUNGAL_YELLOW_3,
            PlantSkin.FUNGAL_YELLOW_4,
            PlantSkin.FUNGAL_YELLOW_5
        )
    );

    public static final GrowthStages FUNGAL_GREEN = new GrowthStages(
        CultivationThemes.SEED_GREEN,
        List.of(
            PlantSkin.SEED_GREEN,
            PlantSkin.FUNGAL_GREEN_1,
            PlantSkin.FUNGAL_GREEN_2,
            PlantSkin.FUNGAL_GREEN_3,
            PlantSkin.FUNGAL_GREEN_4,
            PlantSkin.FUNGAL_GREEN_5
        )
    );

    public static final GrowthStages FUNGAL_BLUE = new GrowthStages(
        CultivationThemes.SEED_BLUE,
        List.of(
            PlantSkin.SEED_BLUE,
            PlantSkin.FUNGAL_BLUE_1,
            PlantSkin.FUNGAL_BLUE_2,
            PlantSkin.FUNGAL_BLUE_3,
            PlantSkin.FUNGAL_BLUE_4,
            PlantSkin.FUNGAL_BLUE_5
        )
    );

    public static final GrowthStages FUNGAL_CYAN = new GrowthStages(
        CultivationThemes.SEED_CYAN,
        List.of(
            PlantSkin.SEED_CYAN,
            PlantSkin.FUNGAL_CYAN_1,
            PlantSkin.FUNGAL_CYAN_2,
            PlantSkin.FUNGAL_CYAN_3,
            PlantSkin.FUNGAL_CYAN_4,
            PlantSkin.FUNGAL_CYAN_5
        )
    );

    public static final GrowthStages FUNGAL_PURPLE = new GrowthStages(
        CultivationThemes.SEED_PURPLE,
        List.of(
            PlantSkin.SEED_PURPLE,
            PlantSkin.FUNGAL_PURPLE_1,
            PlantSkin.FUNGAL_PURPLE_2,
            PlantSkin.FUNGAL_PURPLE_3,
            PlantSkin.FUNGAL_PURPLE_4,
            PlantSkin.FUNGAL_PURPLE_5
        )
    );

    @Nonnull
    private final Theme theme;
    @Nonnull
    private final List<PlantSkin> stages;

    /**
     * This class is used to store the possible stages of growth a plant can go through
     * starting with a seed to its final step.
     *
     * @param theme  The {@link Theme} that will be used for particle effects and other appropriate needs
     * @param stages The {@link List} of PlantSkin that will be used as textures for each stage
     */
    public GrowthStages(@Nonnull Theme theme, @Nonnull List<PlantSkin> stages) {
        this.theme = theme;
        this.stages = stages;
    }

    @Nonnull
    public Theme getTheme() {
        return theme;
    }

    @Nonnull
    public List<PlantSkin> getStages() {
        return stages;
    }

    public int stages() {
        return stages.size();
    }

    @Nonnull
    public PlantSkin get(int index) {
        return stages.get(index);
    }
}
