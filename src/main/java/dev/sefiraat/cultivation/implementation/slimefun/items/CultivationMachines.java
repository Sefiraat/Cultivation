package dev.sefiraat.cultivation.implementation.slimefun.items;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
import dev.sefiraat.cultivation.implementation.slimefun.machines.CraftingKitchenMachine;
import dev.sefiraat.cultivation.implementation.slimefun.machines.DoNothingKitchenObject;
import dev.sefiraat.cultivation.implementation.slimefun.machines.GardenCloche;
import dev.sefiraat.cultivation.implementation.slimefun.machines.PoweredKitchenMachineComplex;
import dev.sefiraat.cultivation.implementation.slimefun.machines.PoweredKitchenMachineSimple;
import dev.sefiraat.cultivation.implementation.slimefun.machines.RightClickKitchenMachine;
import dev.sefiraat.cultivation.implementation.utils.DisplayGroupGenerators;
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

    public static final DoNothingKitchenObject COUNTER_NOTHING = new DoNothingKitchenObject(
        CultivationGroups.MACHINES,
        CultivationStacks.COUNTER_NOTHING,
        RecipeType.ENHANCED_CRAFTING_TABLE,
        new ItemStack[]{
            null, null, null,
            new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.IRON_BLOCK),
            new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG)
        },
        DisplayGroupGenerators::generateBaseCounter
    );

    public static final RightClickKitchenMachine COUNTER_CHOPPING = new RightClickKitchenMachine(
        CultivationGroups.MACHINES,
        CultivationStacks.COUNTER_CHOPPING,
        RecipeType.ENHANCED_CRAFTING_TABLE,
        new ItemStack[]{
            null, new ItemStack(Material.IRON_SWORD), null,
            new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.POLISHED_BLACKSTONE), new ItemStack(Material.IRON_BLOCK),
            new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG)
        },
        DisplayGroupGenerators::generateChoppingCounter
    );

    public static final RightClickKitchenMachine COUNTER_SLICING = new RightClickKitchenMachine(
        CultivationGroups.MACHINES,
        CultivationStacks.COUNTER_SLICING,
        RecipeType.ENHANCED_CRAFTING_TABLE,
        new ItemStack[]{
            null, new ItemStack(Material.SHEARS), null,
            new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.LAPIS_BLOCK), new ItemStack(Material.IRON_BLOCK),
            new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG)
        },
        DisplayGroupGenerators::generateSlicingCounter
    );

    public static final RightClickKitchenMachine COUNTER_MASHER = new RightClickKitchenMachine(
        CultivationGroups.MACHINES,
        CultivationStacks.COUNTER_MASHER,
        RecipeType.ENHANCED_CRAFTING_TABLE,
        new ItemStack[]{
            null, new ItemStack(Material.NETHERITE_HOE), null,
            new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.COMPOSTER), new ItemStack(Material.IRON_BLOCK),
            new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG)
        },
        DisplayGroupGenerators::generateMashingCounter
    );

    public static final RightClickKitchenMachine COUNTER_GRINDER = new RightClickKitchenMachine(
        CultivationGroups.MACHINES,
        CultivationStacks.COUNTER_GRINDER,
        RecipeType.ENHANCED_CRAFTING_TABLE,
        new ItemStack[]{
            null, new ItemStack(Material.BONE), null,
            new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.CAULDRON), new ItemStack(Material.IRON_BLOCK),
            new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG)
        },
        DisplayGroupGenerators::generateGrindingCounter
    );

    public static final RightClickKitchenMachine COUNTER_BLENDER = new RightClickKitchenMachine(
        CultivationGroups.MACHINES,
        CultivationStacks.COUNTER_BLENDER,
        RecipeType.ENHANCED_CRAFTING_TABLE,
        new ItemStack[]{
            null, new ItemStack(Material.GLASS), null,
            new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.QUARTZ_BLOCK), new ItemStack(Material.IRON_BLOCK),
            new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG), new ItemStack(Material.DARK_OAK_LOG)
        },
        DisplayGroupGenerators::generateBlenderCounter
    );

    public static final RightClickKitchenMachine COUNTER_BOILING = new RightClickKitchenMachine(
        CultivationGroups.MACHINES,
        CultivationStacks.COUNTER_BOILING,
        RecipeType.ENHANCED_CRAFTING_TABLE,
        new ItemStack[]{
            null, new ItemStack(Material.TINTED_GLASS), new ItemStack(Material.CAULDRON),
            new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.CAMPFIRE), new ItemStack(Material.IRON_BLOCK),
            new ItemStack(Material.DARK_OAK_LOG), SlimefunItems.ENHANCED_FURNACE, new ItemStack(Material.DARK_OAK_LOG)
        },
        DisplayGroupGenerators::generateBoilingCounter
    );

    public static final PoweredKitchenMachineComplex COUNTER_OVEN = new PoweredKitchenMachineComplex(
        CultivationGroups.MACHINES,
        CultivationStacks.COUNTER_OVEN,
        RecipeType.ENHANCED_CRAFTING_TABLE,
        new ItemStack[]{
            null, new ItemStack(Material.IRON_BLOCK), null,
            new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.POLISHED_BLACKSTONE), new ItemStack(Material.IRON_BLOCK),
            new ItemStack(Material.DARK_OAK_LOG), SlimefunItems.CARBONADO_EDGED_FURNACE, new ItemStack(Material.DARK_OAK_LOG)
        },
        DisplayGroupGenerators::generateOvenCounter,
        200
    );

    public static final PoweredKitchenMachineSimple COUNTER_FRYER = new PoweredKitchenMachineSimple(
        CultivationGroups.MACHINES,
        CultivationStacks.COUNTER_FRYER,
        RecipeType.ENHANCED_CRAFTING_TABLE,
        new ItemStack[]{
            null, new ItemStack(Material.TINTED_GLASS), null,
            new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.CAMPFIRE), new ItemStack(Material.IRON_BLOCK),
            new ItemStack(Material.DARK_OAK_LOG), SlimefunItems.CARBONADO_EDGED_FURNACE, new ItemStack(Material.DARK_OAK_LOG)
        },
        DisplayGroupGenerators::generateFryingCounter,
        100
    );

    public static final PoweredKitchenMachineSimple COUNTER_GRILL = new PoweredKitchenMachineSimple(
        CultivationGroups.MACHINES,
        CultivationStacks.COUNTER_GRILL,
        RecipeType.ENHANCED_CRAFTING_TABLE,
        new ItemStack[]{
            null, new ItemStack(Material.IRON_BLOCK), null,
            new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.CHISELED_POLISHED_BLACKSTONE), new ItemStack(Material.IRON_BLOCK),
            new ItemStack(Material.DARK_OAK_LOG), SlimefunItems.ELECTRIC_MOTOR, new ItemStack(Material.DARK_OAK_LOG)
        },
        DisplayGroupGenerators::generateGrillingCounter,
        150
    );

    public static final CraftingKitchenMachine COUNTER_FINISHING = new CraftingKitchenMachine(
        CultivationGroups.MACHINES,
        CultivationStacks.COUNTER_FINISHING,
        RecipeType.ENHANCED_CRAFTING_TABLE,
        new ItemStack[]{
            null, null, null,
            new ItemStack(Material.IRON_BLOCK), new ItemStack(Material.POLISHED_DIORITE), new ItemStack(Material.IRON_BLOCK),
            new ItemStack(Material.DARK_OAK_LOG), SlimefunItems.CRAFTING_MOTOR, new ItemStack(Material.DARK_OAK_LOG)
        },
        DisplayGroupGenerators::generateFinishingCounter
    );

    public static void setup(Cultivation addon) {
        GARDEN_CLOCHE.register(addon);
        COUNTER_NOTHING.register(addon);
        COUNTER_CHOPPING.register(addon);
        COUNTER_BLENDER.register(addon);
        COUNTER_SLICING.register(addon);
        COUNTER_GRINDER.register(addon);
        COUNTER_MASHER.register(addon);
        COUNTER_BOILING.register(addon);
        COUNTER_OVEN.register(addon);
        COUNTER_FRYER.register(addon);
        COUNTER_GRILL.register(addon);
        COUNTER_FINISHING.register(addon);
    }
}
