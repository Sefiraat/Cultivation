package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
import dev.sefiraat.cultivation.implementation.slimefun.machines.GardenCloche;
import dev.sefiraat.cultivation.implementation.slimefun.machines.KitchenMachine;
import dev.sefiraat.cultivation.implementation.utils.DisplayUtils;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class CultivationMachines {

    private CultivationMachines() {
        throw new IllegalStateException("Utility class");
    }

    public static final GardenCloche GARDEN_CLOCHE = new GardenCloche(
        CultivationGroups.MACHINES,
        CultivationStacks.GARDEN_CLOCHE,
        RecipeType.ENHANCED_CRAFTING_TABLE,
        new ItemStack[]{
            null, SlimefunItems.HARDENED_GLASS, null,
            null, SlimefunItems.CROP_GROWTH_ACCELERATOR, null,
            null, SlimefunItems.GOLD_24K_BLOCK, null
        }
    );

    public static final KitchenMachine COUNTER_CHOPPING = new KitchenMachine(
        CultivationGroups.MACHINES,
        CultivationStacks.COUNTER_CHOPPING,
        RecipeType.ENHANCED_CRAFTING_TABLE,
        new ItemStack[]{
            null, new ItemStack(Material.IRON_SWORD), null,
            new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.POLISHED_BLACKSTONE), new ItemStack(Material.IRON_BLOCK),
            new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG)
        },
        DisplayUtils::generateChoppingCounter
    );

    public static final KitchenMachine COUNTER_SLICING = new KitchenMachine(
        CultivationGroups.MACHINES,
        CultivationStacks.COUNTER_SLICING,
        RecipeType.ENHANCED_CRAFTING_TABLE,
        new ItemStack[]{
            null, new ItemStack(Material.SHEARS), null,
            new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.LAPIS_BLOCK), new ItemStack(Material.IRON_BLOCK),
            new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG)
        },
        DisplayUtils::generateSlicingCounter
    );

    public static final KitchenMachine COUNTER_MASHER = new KitchenMachine(
        CultivationGroups.MACHINES,
        CultivationStacks.COUNTER_MASHER,
        RecipeType.ENHANCED_CRAFTING_TABLE,
        new ItemStack[]{
            null, new ItemStack(Material.NETHERITE_HOE), null,
            new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.COMPOSTER), new ItemStack(Material.IRON_BLOCK),
            new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG)
        },
        DisplayUtils::generateMashingCounter
    );

    public static final KitchenMachine COUNTER_GRINDER = new KitchenMachine(
        CultivationGroups.MACHINES,
        CultivationStacks.COUNTER_GRINDER,
        RecipeType.ENHANCED_CRAFTING_TABLE,
        new ItemStack[]{
            null, new ItemStack(Material.BONE), null,
            new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.CAULDRON), new ItemStack(Material.IRON_BLOCK),
            new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG)
        },
        DisplayUtils::generateGrindingCounter
    );

    public static final KitchenMachine COUNTER_BLENDER = new KitchenMachine(
        CultivationGroups.MACHINES,
        CultivationStacks.COUNTER_BLENDER,
        RecipeType.ENHANCED_CRAFTING_TABLE,
        new ItemStack[]{
            null, new ItemStack(Material.GLASS), null,
            new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.QUARTZ_BLOCK), new ItemStack(Material.IRON_BLOCK),
            new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG)
        },
        DisplayUtils::generateBlenderCounter
    );

    public static void setup(Cultivation addon) {
        GARDEN_CLOCHE.register(addon);
        COUNTER_CHOPPING.register(addon);
        COUNTER_BLENDER.register(addon);
        COUNTER_SLICING.register(addon);
        COUNTER_GRINDER.register(addon);
        COUNTER_MASHER.register(addon);
    }
}
