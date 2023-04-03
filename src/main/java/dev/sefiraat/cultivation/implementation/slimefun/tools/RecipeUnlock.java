package dev.sefiraat.cultivation.implementation.slimefun.tools;

import com.google.common.base.Preconditions;
import dev.sefiraat.cultivation.Registry;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.api.slimefun.plant.BreedingPair;
import dev.sefiraat.cultivation.api.utils.StatisticUtils;
import dev.sefiraat.cultivation.implementation.slimefun.CultivationStacks;
import dev.sefiraat.cultivation.implementation.utils.Keys;
import dev.sefiraat.sefilib.string.Theme;
import io.github.bakedlibs.dough.data.persistent.PersistentDataAPI;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RecipeUnlock extends SlimefunItem {
    public RecipeUnlock() {
        super(CultivationGroups.HIDDEN_CONTENT, CultivationStacks.RECIPE_UNLOCK, RecipeType.NULL, new ItemStack[0]);
    }

    @Override
    public void preRegister() {
        addItemHandler(getItemHandler());
    }

    @Nonnull
    public ItemUseHandler getItemHandler() {
        return playerRightClickEvent -> {
            Player player = playerRightClickEvent.getPlayer();
            ItemStack itemStack = player.getInventory().getItemInMainHand();
            String possibleId = getRecipeUnlockId(itemStack);
            if (possibleId == null) {
                return;
            }
            SlimefunItem slimefunItem = SlimefunItem.getById(possibleId);
            if (slimefunItem == null) {
                return;
            }
            StatisticUtils.unlockDiscovery(player, possibleId);
            String message = "You have successfully learned how to breed: " + slimefunItem.getItemName();
            itemStack.setAmount(0);
            player.sendMessage(Theme.SUCCESS.apply(message));
        };
    }

    public ItemStack generateRandomRecipeUnlock() {
        int randomUpper = Registry.getInstance().getPlantBreedingPairs().size();
        int random = ThreadLocalRandom.current().nextInt(randomUpper);
        BreedingPair pair = Registry.getInstance().getPlantBreedingPairs().get(random);
        String childId = pair.getChild().getId();
        ItemStack itemStack = getItem().clone();
        ItemMeta itemMeta = itemStack.getItemMeta();

        Preconditions.checkArgument(itemMeta != null, "Shouldn't be possible, but ItemMeta is null.");

        setLore(itemMeta, pair.getChild().getItemName());
        setPersistence(itemMeta, childId);

        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    private void setLore(@Nonnull ItemMeta itemMeta, @Nonnull String childName) {
        // Setup the lore
        List<String> lore = itemMeta.getLore();
        List<String> newLore = new ArrayList<>();

        Preconditions.checkArgument(lore != null, "Shouldn't be possible, but lore is null.");

        for (String string : lore) {
            newLore.add(string.replace("{0}", childName));
        }

        itemMeta.setLore(newLore);
    }

    private void setPersistence(@Nonnull ItemMeta itemMeta, @Nonnull String id) {
        PersistentDataAPI.set(itemMeta, Keys.RECIPE_ID, PersistentDataType.STRING, id);
    }

    @Nullable
    private String getRecipeUnlockId(@Nonnull ItemStack itemStack) {
        ItemMeta itemMeta = itemStack.getItemMeta();

        Preconditions.checkArgument(itemMeta != null, "Shouldn't be possible, but ItemMeta is null.");
        return PersistentDataAPI.getString(itemMeta, Keys.RECIPE_ID);
    }
}
