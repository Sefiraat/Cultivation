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
import javax.annotation.Nullable;
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
    private boolean canChop;
    private boolean canMash;
    private boolean canSlice;
    private boolean canGrind;
    private boolean canBlend;
    private boolean canBake;
    private boolean canFry;
    private boolean canGrill;
    private final ItemStack itemStack;
    public CultivationProduceVanilla(@Nonnull Material material) {
        this.itemStack = new ItemStack(material);
    }

    @Nullable
    public CultivationByProduct getChopped() {
        return chopped;
    }

    @Nullable
    public CultivationByProduct getMashed() {
        return mashed;
    }

    @Nullable
    public CultivationByProduct getSliced() {
        return sliced;
    }

    @Nullable
    public CultivationByProduct getGround() {
        return ground;
    }

    @Nullable
    public CultivationByProduct getBlended() {
        return blended;
    }

    @Nullable
    public CultivationByProduct getBaked() {
        return baked;
    }

    @Nullable
    public CultivationByProduct getFried() {
        return fried;
    }

    @Nullable
    public CultivationByProduct getGrilled() {
        return grilled;
    }

    public boolean isChoppable() {
        return canChop;
    }

    public CultivationProduceVanilla setCoppable(boolean canChop) {
        this.canChop = canChop;
        return this;
    }

    public boolean isMashable() {
        return canMash;
    }

    public CultivationProduceVanilla setMashable(boolean canMash) {
        this.canMash = canMash;
        return this;
    }

    public boolean isSliceable() {
        return canSlice;
    }

    public CultivationProduceVanilla setSliceable(boolean canSlice) {
        this.canSlice = canSlice;
        return this;
    }

    public boolean isGrindable() {
        return canGrind;
    }

    public CultivationProduceVanilla setGrindable(boolean canGrind) {
        this.canGrind = canGrind;
        return this;
    }

    public boolean isBlendable() {
        return canBlend;
    }

    public CultivationProduceVanilla setBlendable(boolean canBlend) {
        this.canBlend = canBlend;
        return this;
    }

    public boolean isBakeable() {
        return canBake;
    }

    public CultivationProduceVanilla setBakeable(boolean canBake) {
        this.canBake = canBake;
        return this;
    }

    public boolean isFryable() {
        return canFry;
    }

    public CultivationProduceVanilla setFryable(boolean canFry) {
        this.canFry = canFry;
        return this;
    }

    public boolean isGrillable() {
        return canGrill;
    }

    public CultivationProduceVanilla setGrillable(boolean canGrill) {
        this.canGrill = canGrill;
        return this;
    }

    public CultivationProduceVanilla createByProducts() {
        if (canChop) {
            this.chopped = registerByProduct("Chopped", RecipeTypes.CHOPPED, Material.BEETROOT_SEEDS);
        }
        if (canMash) {
            this.mashed = registerByProduct("Mashed", RecipeTypes.MASHED, Material.SUSPICIOUS_STEW);
        }
        if (canSlice) {
            this.sliced = registerByProduct("Sliced", RecipeTypes.SLICED, Material.KELP);
        }
        if (canGrind) {
            this.ground = registerByProduct("Ground", RecipeTypes.GROUND, Material.BROWN_DYE);
        }
        if (canBlend) {
            this.blended = registerByProduct("Blended", RecipeTypes.BLENDED, Material.WATER_BUCKET);
        }
        if (canBake) {
            this.baked = registerByProduct("Baked", RecipeTypes.BAKED, Material.DRIED_KELP);
        }
        if (canFry) {
            this.fried = registerByProduct("Fried", RecipeTypes.FRIED, Material.RED_DYE);
        }
        if (canGrill) {
            this.grilled = registerByProduct("Grilled", RecipeTypes.GRILLED, Material.COOKED_PORKCHOP);
        }
        return this;
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
