package dev.sefiraat.cultivation.api.slimefun.items.produce;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.utils.CultivationThemes;
import dev.sefiraat.cultivation.implementation.slimefun.items.Machines;
import dev.sefiraat.sefilib.string.Theme;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Locale;

public class ProduceCore extends SlimefunItem {
    private ByProduct chopped;
    private ByProduct mashed;
    private ByProduct sliced;
    private ByProduct ground;
    private ByProduct blended;
    private ByProduct boiled;
    private ByProduct fried;
    private ByProduct grilled;

    public ProduceCore(ItemGroup itemGroup,
                       SlimefunItemStack item,
                       RecipeType recipeType
    ) {
        super(itemGroup, item, recipeType, new ItemStack[0]);
    }

    @Nonnull
    public ByProduct getChopped() {
        return chopped;
    }

    @Nonnull
    public ByProduct getMashed() {
        return mashed;
    }

    @Nonnull
    public ByProduct getSliced() {
        return sliced;
    }

    @Nonnull
    public ByProduct getGround() {
        return ground;
    }

    @Nonnull
    public ByProduct getBlended() {
        return blended;
    }

    @Nonnull
    public ByProduct getBoiled() {
        return boiled;
    }

    @Nonnull
    public ByProduct getFried() {
        return fried;
    }

    @Nonnull
    public ByProduct getGrilled() {
        return grilled;
    }

    @Nonnull
    public ItemStack getChoppedItem() {
        return chopped.getItem();
    }

    @Nonnull
    public ItemStack getMashedItem() {
        return mashed.getItem();
    }

    @Nonnull
    public ItemStack getSlicedItem() {
        return sliced.getItem();
    }

    @Nonnull
    public ItemStack getGroundItem() {
        return ground.getItem();
    }

    @Nonnull
    public ItemStack getBlendedItem() {
        return blended.getItem();
    }

    @Nonnull
    public ItemStack getBoiledItem() {
        return boiled.getItem();
    }

    @Nonnull
    public ItemStack getFriedItem() {
        return fried.getItem();
    }

    @Nonnull
    public ItemStack getGrilledItem() {
        return grilled.getItem();
    }

    @Override
    public void register(@NotNull SlimefunAddon addon) {
        createByProducts();
        super.register(addon);
    }

    private void createByProducts() {
        this.chopped = registerByProduct("Chopped", RecipeTypes.CHOPPED, Material.BEETROOT_SEEDS);
        this.mashed = registerByProduct("Mashed", RecipeTypes.MASHED, Material.SUSPICIOUS_STEW);
        this.sliced = registerByProduct("Sliced", RecipeTypes.SLICED, Material.KELP);
        this.ground = registerByProduct("Ground", RecipeTypes.GROUND, Material.BROWN_DYE);
        this.blended = registerByProduct("Blended", RecipeTypes.BLENDED, Material.WATER_BUCKET);
        this.boiled = registerByProduct("Boiled", RecipeTypes.BOILED, Material.CAULDRON);
        this.fried = registerByProduct("Fried", RecipeTypes.FRIED, Material.RED_DYE);
        this.grilled = registerByProduct("Grilled", RecipeTypes.GRILLED, Material.COOKED_PORKCHOP);
    }

    @ParametersAreNonnullByDefault
    private ByProduct registerByProduct(String name, RecipeType recipeType, Material material) {
        ByProduct byProduct = new ByProduct(
            Theme.themedSlimefunItemStack(
                "CLT_" + name.toUpperCase(Locale.ROOT) + "_" + this.getId().substring(4),
                material,
                CultivationThemes.BY_PRODUCT,
                name + " " + this.getItemName()
            ),
            recipeType,
            this.getItem()
        );

        if (recipeType == RecipeTypes.CHOPPED) {
            Machines.COUNTER_CHOPPING.addRecipe(this.getId(), byProduct.getItem());
        }

        if (recipeType == RecipeTypes.BLENDED) {
            Machines.COUNTER_BLENDER.addRecipe(this.getId(), byProduct.getItem());
        }

        if (recipeType == RecipeTypes.MASHED) {
            Machines.COUNTER_MASHER.addRecipe(this.getId(), byProduct.getItem());
        }

        if (recipeType == RecipeTypes.GROUND) {
            Machines.COUNTER_GRINDER.addRecipe(this.getId(), byProduct.getItem());
        }

        if (recipeType == RecipeTypes.SLICED) {
            Machines.COUNTER_SLICING.addRecipe(this.getId(), byProduct.getItem());
        }

        if (recipeType == RecipeTypes.BOILED) {
            Machines.COUNTER_BOILING.addRecipe(this.getId(), byProduct.getItem());
        }

        if (recipeType == RecipeTypes.FRIED) {
            Machines.COUNTER_FRYER.addRecipe(this.getId(), byProduct.getItem());
        }

        if (recipeType == RecipeTypes.GRILLED) {
            Machines.COUNTER_GRILL.addRecipe(this.getId(), byProduct.getItem());
        }

        return byProduct.buildRegister(Cultivation.getInstance());
    }

    public ProduceCore buildRegister(@Nonnull SlimefunAddon addon) {
        this.register(addon);
        return this;
    }
}
