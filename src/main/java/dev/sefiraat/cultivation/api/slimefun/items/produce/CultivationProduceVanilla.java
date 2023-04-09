package dev.sefiraat.cultivation.api.slimefun.items.produce;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.utils.CultivationThemes;
import dev.sefiraat.cultivation.implementation.slimefun.items.CultivationMachines;
import dev.sefiraat.sefilib.string.Theme;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Locale;

public class CultivationProduceVanilla {
    private CultivationByProduct chopped;
    private CultivationByProduct mashed;
    private CultivationByProduct sliced;
    private CultivationByProduct ground;
    private CultivationByProduct blended;
    private CultivationByProduct baked;
    private CultivationByProduct fried;
    private CultivationByProduct grilled;
    private final ItemStack itemStack;

    public CultivationProduceVanilla(@Nonnull Material material) {
        this.itemStack = new ItemStack(material);
        createByProducts();
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
        String materialName = this.itemStack.getType().name();
        String friendlyName = materialName.replaceAll("_", " ").toLowerCase(Locale.ROOT);
        CultivationByProduct byProduct = new CultivationByProduct(
            Theme.themedSlimefunItemStack(
                "CLT_" + name.toUpperCase(Locale.ROOT) + "_" + materialName.toUpperCase(Locale.ROOT),
                material,
                CultivationThemes.BY_PRODUCT,
                name + " " + friendlyName
            ),
            recipeType,
            this.itemStack
        );
        byProduct.register(Cultivation.getInstance());

        if (recipeType == RecipeTypes.CHOPPED) {
            CultivationMachines.COUNTER_CHOPPING.addRecipe(materialName, byProduct.getItem());
        }

        if (recipeType == RecipeTypes.BLENDED) {
            CultivationMachines.COUNTER_BLENDER.addRecipe(materialName, byProduct.getItem());
        }

        if (recipeType == RecipeTypes.MASHED) {
            CultivationMachines.COUNTER_MASHER.addRecipe(materialName, byProduct.getItem());
        }

        if (recipeType == RecipeTypes.GROUND) {
            CultivationMachines.COUNTER_GRINDER.addRecipe(materialName, byProduct.getItem());
        }

        if (recipeType == RecipeTypes.SLICED) {
            CultivationMachines.COUNTER_SLICING.addRecipe(materialName, byProduct.getItem());
        }

        if (recipeType == RecipeTypes.BAKED) {
            CultivationMachines.COUNTER_OVEN.addRecipe(materialName, byProduct.getItem());
        }

        if (recipeType == RecipeTypes.FRIED) {
            CultivationMachines.COUNTER_FRYER.addRecipe(materialName, byProduct.getItem());
        }

        if (recipeType == RecipeTypes.GRILLED) {
            CultivationMachines.COUNTER_GRILL.addRecipe(materialName, byProduct.getItem());
        }

        return byProduct;
    }
}
