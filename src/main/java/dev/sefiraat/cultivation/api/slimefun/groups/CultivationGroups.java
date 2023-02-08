package dev.sefiraat.cultivation.api.slimefun.groups;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.utils.CultivationThemes;
import dev.sefiraat.cultivation.implementation.utils.Keys;
import dev.sefiraat.sefilib.slimefun.itemgroup.DummyItemGroup;
import dev.sefiraat.sefilib.slimefun.itemgroup.SimpleFlexGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * This class is used to store the ItemGroups used in this addon
 */
public final class CultivationGroups {

    private CultivationGroups() {
        throw new IllegalStateException("Utility class");
    }

    public static final SimpleFlexGroup MAIN = new SimpleFlexGroup(
        Cultivation.getInstance(),
        "Cultivation",
        Keys.newKey("main"),
        new CustomItemStack(
            new ItemStack(Material.AZURE_BLUET),
            CultivationThemes.MAIN.color("Cultivation")
        )
    );

    public static final DummyItemGroup CRAFTING = new DummyItemGroup(
        Keys.newKey("crafting"),
        new CustomItemStack(
            new ItemStack(Material.STICK),
            CultivationThemes.MAIN.color("Crafting Items")
        )
    );

    public static final DummyItemGroup TOOLS = new DummyItemGroup(
        Keys.newKey("tools"),
        new CustomItemStack(
            new ItemStack(Material.COMPASS),
            CultivationThemes.MAIN.color("Tools")
        )
    );

    public static final DummyItemGroup SEEDS = new DummyItemGroup(
        Keys.newKey("seeds"),
        new CustomItemStack(
            new ItemStack(Material.MELON_SEEDS),
            CultivationThemes.MAIN.color("Seeds")
        )
    );

    static {
        final Cultivation plugin = Cultivation.getInstance();

        SEEDS.setCrossAddonItemGroup(true);

        // Slimefun Registry
        MAIN.register(plugin);
        CRAFTING.register(plugin);
        TOOLS.register(plugin);
        SEEDS.register(plugin);
    }
}
