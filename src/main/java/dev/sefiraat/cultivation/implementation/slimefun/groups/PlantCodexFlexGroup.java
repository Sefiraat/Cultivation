package dev.sefiraat.cultivation.implementation.slimefun.groups;

import dev.sefiraat.cultivation.Registry;
import dev.sefiraat.cultivation.api.slimefun.groups.CultivationGroups;
import dev.sefiraat.cultivation.api.slimefun.items.plants.CultivationPlant;
import dev.sefiraat.cultivation.api.slimefun.items.plants.HarvestablePlant;
import dev.sefiraat.cultivation.api.slimefun.plant.BreedingPair;
import dev.sefiraat.cultivation.api.utils.CultivationThemes;
import dev.sefiraat.cultivation.api.utils.StatisticUtils;
import dev.sefiraat.sefilib.string.Theme;
import io.github.bakedlibs.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.groups.FlexItemGroup;
import io.github.thebusybiscuit.slimefun4.api.player.PlayerProfile;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuide;
import io.github.thebusybiscuit.slimefun4.core.guide.SlimefunGuideMode;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.CSCoreLibPlugin.general.Inventory.ChestMenu;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This flex group is used to display breeding information to the player.
 * Information is locked until the player has bred the appropriate plant at least once
 */
public class PlantCodexFlexGroup extends FlexItemGroup {

    private static final int PAGE_SIZE = 36;

    private static final int GUIDE_BACK = 1;

    private static final int PAGE_PREVIOUS = 46;
    private static final int PAGE_NEXT = 52;

    private static final int[] HEADER = new int[]{
        0, 1, 2, 3, 4, 5, 6, 7, 8
    };
    private static final int[] FOOTER = new int[]{
        45, 46, 47, 48, 49, 50, 51, 52, 53
    };

    private static final int CHILD_SLOT = 22;
    private static final int[] CHILD_INFO_SLOT = new int[]{
        13, 31
    };

    private static final int MOTHER_SLOT = 21;
    private static final int[] MOTHER_INFO_SLOT = new int[]{
        12, 30
    };

    private static final int FATHER_SLOT = 23;
    private static final int[] FATHER_INFO_SLOT = new int[]{
        14, 32
    };

    private static final int GROWTH_RATE_SLOT = 37;
    private static final int[] HELD_SLOTS = new int[]{
        38, 39, 40, 41, 42, 43
    };

    private static final ItemStack MOTHER_INFO = CustomItemStack.create(
        Material.LIGHT_BLUE_STAINED_GLASS_PANE,
        Theme.PASSIVE + "'Mother' Plant"
    );

    private static final ItemStack FATHER_INFO = CustomItemStack.create(
        Material.LIGHT_BLUE_STAINED_GLASS_PANE,
        Theme.PASSIVE + "'Father' Plant"
    );

    private static final ItemStack CHILD_INFO = CustomItemStack.create(
        Material.LIGHT_BLUE_STAINED_GLASS_PANE,
        Theme.PASSIVE + "'Child' Plant"
    );

    private static final ItemStack HELD_SLOT = CustomItemStack.create(
        Material.BLACK_STAINED_GLASS_PANE,
        " "
    );

    private static final DecimalFormat FORMAT = new DecimalFormat("#,###.##");

    public PlantCodexFlexGroup(NamespacedKey key, ItemStack item) {
        super(key, item);
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean isVisible(Player player, PlayerProfile playerProfile, SlimefunGuideMode guideMode) {
        return true;
    }

    @Override
    @ParametersAreNonnullByDefault
    public void open(Player p, PlayerProfile profile, SlimefunGuideMode mode) {
        ChestMenu chestMenu = new ChestMenu(CultivationThemes.MAIN.getColor() + "Plant Codex");

        for (int slot : HEADER) {
            chestMenu.addItem(slot, ChestMenuUtils.getBackground(), (player1, i1, itemStack, clickAction) -> false);
        }

        for (int slot : FOOTER) {
            chestMenu.addItem(slot, ChestMenuUtils.getBackground(), (player1, i1, itemStack, clickAction) -> false);
        }

        chestMenu.setEmptySlotsClickable(false);
        setupPage(p, profile, mode, chestMenu, 1);
        chestMenu.open(p);
    }

    @ParametersAreNonnullByDefault
    private void setupPage(Player player, PlayerProfile profile, SlimefunGuideMode mode, ChestMenu menu, int page) {
        List<BreedingPair> breedingPairs = new ArrayList<>(Registry.getInstance().getPlantBreedingPairs());
        int amount = breedingPairs.size();
        int totalPages = (int) Math.ceil(amount / (double) PAGE_SIZE);
        int start = (page - 1) * PAGE_SIZE;
        int end = Math.min(start + PAGE_SIZE, breedingPairs.size());

        breedingPairs.sort(Comparator.comparing(pair -> pair.getChild().getId()));

        List<BreedingPair> pairSubList = breedingPairs.subList(start, end);

        reapplyFooter(player, profile, mode, menu, page, totalPages);

        // Back
        menu.replaceExistingItem(
            GUIDE_BACK,
            ChestMenuUtils.getBackButton(
                player,
                Slimefun.getLocalization().getMessage("guide.back.guide")
            )
        );
        menu.addMenuClickHandler(GUIDE_BACK, (player1, slot, itemStack, clickAction) -> {
            SlimefunGuide.openItemGroup(profile, CultivationGroups.MAIN, mode, 1);
            return false;
        });

        for (int i = 0; i < 36; i++) {
            int slot = i + 9;

            if (i + 1 <= pairSubList.size()) {
                BreedingPair pair = pairSubList.get(i);
                CultivationPlant child = pair.getChild();
                boolean researched = StatisticUtils.isDiscovered(player, child.getId());

                if (mode == SlimefunGuideMode.CHEAT_MODE || researched) {
                    ItemStack itemStack = new ItemStack(child.getItem().clone());
                    if (child instanceof HarvestablePlant harvestablePlant) {
                        ItemStack possibleStack = harvestablePlant.getHarvestingResults().getRandom();
                        if (possibleStack != null) {
                            itemStack.setType(possibleStack.getType());
                        }
                    }
                    menu.replaceExistingItem(slot, itemStack);
                    menu.addMenuClickHandler(slot, (player1, i1, itemStack1, clickAction) -> {
                        displayDetail(player1, profile, mode, menu, page, pair);
                        return false;
                    });
                } else {
                    menu.replaceExistingItem(slot, getUndiscovered(child));
                    menu.addMenuClickHandler(slot, ChestMenuUtils.getEmptyClickHandler());
                }
            } else {
                menu.replaceExistingItem(slot, null);
                menu.addMenuClickHandler(slot, ChestMenuUtils.getEmptyClickHandler());
            }
        }
    }

    @ParametersAreNonnullByDefault
    private void displayDetail(Player p,
                               PlayerProfile profile,
                               SlimefunGuideMode mode,
                               ChestMenu menu,
                               int returnPage,
                               BreedingPair pair
    ) {
        // Back Button
        menu.replaceExistingItem(
            GUIDE_BACK,
            ChestMenuUtils.getBackButton(
                p,
                Slimefun.getLocalization().getMessage("guide.back.guide")
            )
        );
        menu.addMenuClickHandler(GUIDE_BACK, (player1, slot, itemStack, clickAction) -> {
            setupPage(player1, profile, mode, menu, returnPage);
            return false;
        });

        clearDisplay(menu);

        CultivationPlant child = pair.getChild();
        CultivationPlant mother = (CultivationPlant) SlimefunItem.getById(pair.getMotherId());
        CultivationPlant father = (CultivationPlant) SlimefunItem.getById(pair.getFatherId());

        // Child
        menu.replaceExistingItem(CHILD_SLOT, child.getItem().clone());
        menu.addMenuClickHandler(CHILD_SLOT, ChestMenuUtils.getEmptyClickHandler());
        for (int i : CHILD_INFO_SLOT) {
            menu.replaceExistingItem(i, CHILD_INFO);
            menu.addMenuClickHandler(i, ChestMenuUtils.getEmptyClickHandler());
        }

        // Mother
        menu.replaceExistingItem(MOTHER_SLOT, mother.getItem().clone());
        menu.addMenuClickHandler(MOTHER_SLOT, ChestMenuUtils.getEmptyClickHandler());
        for (int i : MOTHER_INFO_SLOT) {
            menu.replaceExistingItem(i, MOTHER_INFO);
            menu.addMenuClickHandler(i, ChestMenuUtils.getEmptyClickHandler());
        }

        // Father
        menu.replaceExistingItem(FATHER_SLOT, father.getItem().clone());
        menu.addMenuClickHandler(FATHER_SLOT, ChestMenuUtils.getEmptyClickHandler());
        for (int i : FATHER_INFO_SLOT) {
            menu.replaceExistingItem(i, FATHER_INFO);
            menu.addMenuClickHandler(i, ChestMenuUtils.getEmptyClickHandler());
        }

        // Growth Rate
        menu.replaceExistingItem(GROWTH_RATE_SLOT, getGrowthRate(child));
        menu.addMenuClickHandler(GROWTH_RATE_SLOT, ChestMenuUtils.getEmptyClickHandler());

        // Held slots (for adding possible future plant information)
        for (int i : HELD_SLOTS) {
            menu.replaceExistingItem(i, HELD_SLOT);
            menu.addMenuClickHandler(i, ChestMenuUtils.getEmptyClickHandler());
        }
    }

    @ParametersAreNonnullByDefault
    private void clearDisplay(ChestMenu menu) {
        for (int i = 0; i < 45; i++) {
            int slot = i + 9;
            menu.replaceExistingItem(slot, null);
            menu.addMenuClickHandler(slot, (player1, i1, itemStack1, clickAction) -> false);
        }
    }

    @ParametersAreNonnullByDefault
    private void reapplyFooter(Player p,
                               PlayerProfile profile,
                               SlimefunGuideMode mode,
                               ChestMenu menu,
                               int page,
                               int totalPages
    ) {
        for (int slot : FOOTER) {
            menu.replaceExistingItem(slot, ChestMenuUtils.getBackground());
            menu.addMenuClickHandler(slot, ChestMenuUtils.getEmptyClickHandler());
        }

        menu.replaceExistingItem(PAGE_PREVIOUS, ChestMenuUtils.getPreviousButton(p, page, totalPages));
        menu.addMenuClickHandler(PAGE_PREVIOUS, (player1, slot, itemStack, clickAction) -> {
            int previousPage = page - 1;
            if (previousPage >= 1) {
                setupPage(player1, profile, mode, menu, previousPage);
            }
            return false;
        });

        menu.replaceExistingItem(PAGE_NEXT, ChestMenuUtils.getNextButton(p, page, totalPages));
        menu.addMenuClickHandler(PAGE_NEXT, (player1, slot, itemStack, clickAction) -> {
            int nextPage = page + 1;
            if (nextPage <= totalPages) {
                setupPage(player1, profile, mode, menu, nextPage);
            }
            return false;
        });
    }

    @Nonnull
    public static ItemStack getUndiscovered(@Nonnull CultivationPlant seed) {
        return Theme.themedItemStack(
            Material.BARRIER,
            CultivationThemes.DISCOVEREY,
            seed.getItemName(),
            List.of(
                Theme.ERROR + "Not Discovered",
                "You have not yet discovered how",
                "to breed this plant!"
            )
        );
    }

    @Nonnull
    public static ItemStack getGrowthRate(@Nonnull CultivationPlant seed) {
        return CustomItemStack.create(
            Material.WHEAT_SEEDS,
            Theme.CLICK_INFO.asTitle("Growth Rate", FORMAT.format(seed.getDefaultGrowthRate()))
        );
    }
}
