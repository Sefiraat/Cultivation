package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.items.bushes.HarvestableBush;
import dev.sefiraat.cultivation.api.slimefun.plant.CommonPlacements;
import dev.sefiraat.cultivation.api.slimefun.plant.Growth;
import dev.sefiraat.cultivation.api.slimefun.plant.PlantTheme;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;

public final class CultivationBushes {

    private CultivationBushes() {
        throw new IllegalStateException("Utility class");
    }

    public static void setup(Cultivation addon) {

        new HarvestableBush(CultivationStacks.BUSH_GRAPE, new Growth(
            PlantTheme.PURPLE,
            CommonPlacements.COMMON_OVERWORLD,
            0.01
        ))
            .addHarvestingResult(CultivationStacks.PRODUCE_GRAPE)
            .tryRegister(addon);

    }
}
