package dev.sefiraat.cultivation.api.slimefun.items.produce;

import dev.sefiraat.cultivation.Cultivation;
import dev.sefiraat.cultivation.api.slimefun.RecipeTypes;
import dev.sefiraat.cultivation.api.utils.CultivationThemes;
import dev.sefiraat.sefilib.string.Theme;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Locale;

public class CultivationProduce extends UnplaceableBlock {
    public static final String PRODUCTION_METHODS_TITLE = "Can be:";
    private boolean canChop;
    private boolean canMash;
    private boolean canSlice;
    private boolean canGrind;
    private boolean canBlend;

    public CultivationProduce(ItemGroup itemGroup,
                              SlimefunItemStack item,
                              RecipeType recipeType,
                              ItemStack[] recipe
    ) {
        super(itemGroup, item, recipeType, recipe);
    }

    public boolean isCanChop() {
        return canChop;
    }

    public CultivationProduce setCanChop(boolean canChop) {
        this.canChop = canChop;
        return this;
    }

    public boolean isCanMash() {
        return canMash;
    }

    public CultivationProduce setCanMash(boolean canMash) {
        this.canMash = canMash;
        return this;
    }

    public boolean isCanSlice() {
        return canSlice;
    }

    public CultivationProduce setCanSlice(boolean canSlice) {
        this.canSlice = canSlice;
        return this;
    }

    public boolean isCanGrind() {
        return canGrind;
    }

    public CultivationProduce setCanGrind(boolean canGrind) {
        this.canGrind = canGrind;
        return this;
    }

    public boolean isCanBlend() {
        return canBlend;
    }

    public CultivationProduce setCanBlend(boolean canBlend) {
        this.canBlend = canBlend;
        return this;
    }

    @Override
    public void register(@NotNull SlimefunAddon addon) {
        createByProducts();
        super.register(addon);
    }

    private void createByProducts() {
        if (canChop) {
            registerByProduct("Chopped", RecipeTypes.CHOPPED, Material.BEETROOT_SEEDS);
        }
        if (canMash) {
            registerByProduct("Mashed", RecipeTypes.MASHED, Material.BEETROOT_SEEDS);
        }
        if (canSlice) {
            registerByProduct("Sliced", RecipeTypes.SLICED, Material.KELP);
        }
        if (canGrind) {
            registerByProduct("Ground", RecipeTypes.GROUND, Material.BROWN_DYE);
        }
        if (canBlend) {
            registerByProduct("Blended", RecipeTypes.BLENDED, Material.WATER_BUCKET);
        }
    }

    @ParametersAreNonnullByDefault
    private void registerByProduct(String name, RecipeType recipeType, Material material) {
        new CultivationByProduct(
            Theme.themedSlimefunItemStack(
                "CLT_" + name.toUpperCase(Locale.ROOT) + "_" + this.getId().substring(4),
                material,
                CultivationThemes.BY_PRODUCT,
                name + " " + this.getItemName()
            ),
            recipeType,
            this.getItem()
        ).register(Cultivation.getInstance());
        ItemMeta itemMeta = this.getItem().getItemMeta();
        List<String> lore = itemMeta.getLore();
        if (lore.stream().noneMatch(s -> ChatColor.stripColor(s).equals(PRODUCTION_METHODS_TITLE))) {
            lore.add("");
            lore.add(Theme.applyThemeToString(Theme.CLICK_INFO, PRODUCTION_METHODS_TITLE));
        }
        lore.add(Theme.applyThemeToString(Theme.PASSIVE, name));
        itemMeta.setLore(lore);
        this.getItem().setItemMeta(itemMeta);
    }
}
