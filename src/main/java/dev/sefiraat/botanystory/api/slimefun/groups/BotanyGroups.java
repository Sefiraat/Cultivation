package dev.sefiraat.botanystory.api.slimefun.groups;

import dev.sefiraat.botanystory.BotanyStory;
import dev.sefiraat.botanystory.api.utils.BotanyThemes;
import dev.sefiraat.botanystory.implementation.utils.Keys;
import dev.sefiraat.sefilib.slimefun.itemgroup.DummyItemGroup;
import dev.sefiraat.sefilib.slimefun.itemgroup.SimpleFlexGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * Final class used to store the ItemGroups used in this addon
 */
public final class BotanyGroups {

    private BotanyGroups() {
        throw new IllegalStateException("Utility class");
    }

    public static final SimpleFlexGroup MAIN = new SimpleFlexGroup(
        BotanyStory.getInstance(),
        "BotanyStory",
        Keys.newKey("main"),
        new CustomItemStack(
            new ItemStack(Material.AZURE_BLUET),
            BotanyThemes.MAIN.color("BotanyStory")
        )
    );

    public static final DummyItemGroup CRAFTING = new DummyItemGroup(
        Keys.newKey("crafting"),
        new CustomItemStack(
            new ItemStack(Material.STICK),
            BotanyThemes.MAIN.color("Crafting Items")
        )
    );

    public static final DummyItemGroup TOOLS = new DummyItemGroup(
        Keys.newKey("tools"),
        new CustomItemStack(
            new ItemStack(Material.COMPASS),
            BotanyThemes.MAIN.color("Tools")
        )
    );

    public static final DummyItemGroup SEEDS = new DummyItemGroup(
        Keys.newKey("seeds"),
        new CustomItemStack(
            new ItemStack(Material.MELON_SEEDS),
            BotanyThemes.MAIN.color("Seeds")
        )
    );

    static {
        final BotanyStory plugin = BotanyStory.getInstance();

        SEEDS.setCrossAddonItemGroup(true);

        // Slimefun Registry
        MAIN.register(plugin);
        CRAFTING.register(plugin);
        TOOLS.register(plugin);
        SEEDS.register(plugin);
    }
}
