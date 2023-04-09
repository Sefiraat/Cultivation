package dev.sefiraat.cultivation.api.slimefun.items.produce;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.utils.CultivationThemes;
import dev.sefiraat.cultivation.implementation.slimefun.items.CultivationMachines;
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

public class CultivationProduceCore extends SlimefunItem {
    private CultivationByProduct chopped;
    private CultivationByProduct mashed;
    private CultivationByProduct sliced;
    private CultivationByProduct ground;
    private CultivationByProduct blended;
    private CultivationByProduct baked;
    private CultivationByProduct fried;
    private CultivationByProduct grilled;

    public CultivationProduceCore(ItemGroup itemGroup,
                                  SlimefunItemStack item,
                                  RecipeType recipeType
    ) {
        super(itemGroup, item, recipeType, new ItemStack[0]);
    }

    @Nonnull
    public CultivationByProduct getChopped() {
        return chopped;
    }

    @Nonnull
    public CultivationByProduct getMashed() {
        return mashed;
    }

    @Nonnull
    public CultivationByProduct getSliced() {
        return sliced;
    }

    @Nonnull
    public CultivationByProduct getGround() {
        return ground;
    }

    @Nonnull
    public CultivationByProduct getBlended() {
        return blended;
    }

    @Nonnull
    public CultivationByProduct getBaked() {
        return baked;
    }

    @Nonnull
    public CultivationByProduct getFried() {
        return fried;
    }

    @Nonnull
    public CultivationByProduct getGrilled() {
        return grilled;
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
        this.baked = registerByProduct("Baked", RecipeTypes.BAKED, Material.DRIED_KELP);
        this.fried = registerByProduct("Fried", RecipeTypes.FRIED, Material.RED_DYE);
        this.grilled = registerByProduct("Grilled", RecipeTypes.GRILLED, Material.COOKED_PORKCHOP);
    }

    @ParametersAreNonnullByDefault
    private CultivationByProduct registerByProduct(String name, RecipeType recipeType, Material material) {
        CultivationByProduct byProduct = new CultivationByProduct(
            Theme.themedSlimefunItemStack(
                "CLT_" + name.toUpperCase(Locale.ROOT) + "_" + this.getId().substring(4),
                material,
                CultivationThemes.BY_PRODUCT,
                name + " " + this.getItemName()
            ),
            recipeType,
            this.getItem()
        );
        byProduct.register(Cultivation.getInstance());

        if (recipeType == RecipeTypes.CHOPPED) {
            CultivationMachines.COUNTER_CHOPPING.addRecipe(this.getId(), byProduct.getItem());
        }

        if (recipeType == RecipeTypes.BLENDED) {
            CultivationMachines.COUNTER_BLENDER.addRecipe(this.getId(), byProduct.getItem());
        }

        if (recipeType == RecipeTypes.MASHED) {
            CultivationMachines.COUNTER_MASHER.addRecipe(this.getId(), byProduct.getItem());
        }

        if (recipeType == RecipeTypes.GROUND) {
            CultivationMachines.COUNTER_GRINDER.addRecipe(this.getId(), byProduct.getItem());
        }

        if (recipeType == RecipeTypes.SLICED) {
            CultivationMachines.COUNTER_SLICING.addRecipe(this.getId(), byProduct.getItem());
        }

        if (recipeType == RecipeTypes.BAKED) {
            CultivationMachines.COUNTER_OVEN.addRecipe(this.getId(), byProduct.getItem());
        }

        if (recipeType == RecipeTypes.FRIED) {
            CultivationMachines.COUNTER_FRYER.addRecipe(this.getId(), byProduct.getItem());
        }

        if (recipeType == RecipeTypes.GRILLED) {
            CultivationMachines.COUNTER_GRILL.addRecipe(this.getId(), byProduct.getItem());
        }

        return byProduct;
    }

    public CultivationProduceCore buildRegister(@Nonnull SlimefunAddon addon) {
        this.register(addon);
        return this;
    }
}
