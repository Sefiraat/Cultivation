package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.slimefun.items.bushes.HarvestableBush;
import dev.sefiraat.cultivation.api.slimefun.plant.CommonPlacements;
import dev.sefiraat.cultivation.api.slimefun.plant.Growth;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class CultivationBushes {

    private CultivationBushes() {
        throw new IllegalStateException("Utility class");
    }

    public static void setup(Cultivation addon) {

        new HarvestableBush(
            CultivationStacks.BERRY_BUSH,
            RecipeTypes.BUSH_TRIMMING,
            new ItemStack[0],
            new Growth(
                null,
                CommonPlacements.COMMON_OVERWORLD,
                0.1
            )
        ).addHarvestingResult(new ItemStack(Material.SWEET_BERRIES))
            .tryRegister(addon);
    }
}
