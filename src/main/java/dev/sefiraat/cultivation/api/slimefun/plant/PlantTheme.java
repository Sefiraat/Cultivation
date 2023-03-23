package dev.sefiraat.cultivation.api.slimefun.plant;

import dev.sefiraat.cultivation.api.utils.CultivationThemes;
import dev.sefiraat.sefilib.string.Theme;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * This class is used to define the CultivationPlant for a plant as well as the textures to be used
 * as the plant grows. It also contains the static instances of PlantTheme used in the addon
 */
public class PlantTheme {

    public static final PlantTheme RED = new PlantTheme(
        CultivationThemes.SEED_RED,
        PlantSkin.SEED_RED
    );

    public static final PlantTheme ORANGE = new PlantTheme(
        CultivationThemes.SEED_ORANGE,
        PlantSkin.SEED_ORANGE
    );

    public static final PlantTheme YELLOW = new PlantTheme(
        CultivationThemes.SEED_YELLOW,
        PlantSkin.SEED_YELLOW
    );

    public static final PlantTheme GREEN = new PlantTheme(
        CultivationThemes.SEED_GREEN,
        PlantSkin.SEED_GREEN
    );

    public static final PlantTheme BLUE = new PlantTheme(
        CultivationThemes.SEED_BLUE,
        PlantSkin.SEED_BLUE
    );

    public static final PlantTheme CYAN = new PlantTheme(
        CultivationThemes.SEED_CYAN,
        PlantSkin.SEED_CYAN
    );

    public static final PlantTheme PURPLE = new PlantTheme(
        CultivationThemes.SEED_PURPLE,
        PlantSkin.SEED_PURPLE
    );

    @Nonnull
    private final Theme theme;
    @Nonnull
    private final PlantSkin seed;

    /**
     * This class is used to store the possible seed of growth a plant can go through
     * starting with a seed to its final step.
     *
     * @param theme  The {@link Theme} that will be used for particle effects and other appropriate needs
     * @param stages The {@link List} of PlantSkin that will be used as textures for each stage
     */
    public PlantTheme(@Nonnull Theme theme, @Nonnull PlantSkin stages) {
        this.theme = theme;
        this.seed = stages;
    }

    @Nonnull
    public Theme getTheme() {
        return theme;
    }

    @Nonnull
    public PlantSkin getSeed() {
        return seed;
    }
}
