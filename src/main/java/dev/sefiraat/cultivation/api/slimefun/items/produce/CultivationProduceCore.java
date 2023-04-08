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
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
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
    public static final String PRODUCTION_METHODS_TITLE = "Can be:";
    private boolean canChop;
    private boolean canMash;
    private boolean canSlice;
    private boolean canGrind;
    private boolean canBlend;
    private boolean canBake;
    private boolean canFry;
    private boolean canGrill;

    public CultivationProduceCore(ItemGroup itemGroup,
                                  SlimefunItemStack item,
                                  RecipeType recipeType
    ) {
        super(itemGroup, item, recipeType, new ItemStack[0]);
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

    public CultivationProduceCore setChoppable(boolean canChop) {
        this.canChop = canChop;
        return this;
    }

    public boolean isMashable() {
        return canMash;
    }

    public CultivationProduceCore setMashable(boolean canMash) {
        this.canMash = canMash;
        return this;
    }

    public boolean isSliceable() {
        return canSlice;
    }

    public CultivationProduceCore setSliceable(boolean canSlice) {
        this.canSlice = canSlice;
        return this;
    }

    public boolean isGrindable() {
        return canGrind;
    }

    public CultivationProduceCore setGrindable(boolean canGrind) {
        this.canGrind = canGrind;
        return this;
    }

    public boolean isBlendable() {
        return canBlend;
    }

    public CultivationProduceCore setBlendable(boolean canBlend) {
        this.canBlend = canBlend;
        return this;
    }

    public boolean isBakeable() {
        return canBake;
    }

    public CultivationProduceCore setBakeable(boolean canBake) {
        this.canBake = canBake;
        return this;
    }

    public boolean isFryable() {
        return canFry;
    }

    public CultivationProduceCore setFryable(boolean canFry) {
        this.canFry = canFry;
        return this;
    }

    public boolean isGrillable() {
        return canGrill;
    }

    public CultivationProduceCore setGrillable(boolean canGrill) {
        this.canGrill = canGrill;
        return this;
    }

    @Override
    public void register(@NotNull SlimefunAddon addon) {
        createByProducts();
        super.register(addon);
    }

    private void createByProducts() {
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

        ItemMeta itemMeta = this.getItem().getItemMeta();
        List<String> lore = itemMeta.getLore();
        if (lore.stream().noneMatch(s -> ChatColor.stripColor(s).equals(PRODUCTION_METHODS_TITLE))) {
            lore.add("");
            lore.add(Theme.applyThemeToString(Theme.CLICK_INFO, PRODUCTION_METHODS_TITLE));
        }
        lore.add(Theme.applyThemeToString(Theme.PASSIVE, name));
        itemMeta.setLore(lore);
        this.getItem().setItemMeta(itemMeta);
        return byProduct;
    }
}
