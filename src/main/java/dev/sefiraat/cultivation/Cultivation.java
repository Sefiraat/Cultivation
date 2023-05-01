package dev.sefiraat.cultivation;

import dev.sefiraat.cultivation.implementation.slimefun.items.Bushes;
import dev.sefiraat.cultivation.implementation.slimefun.items.Crafting;
import dev.sefiraat.cultivation.implementation.slimefun.items.Foods;
import dev.sefiraat.cultivation.implementation.slimefun.items.Ingredients;
import dev.sefiraat.cultivation.implementation.slimefun.items.Machines;
import dev.sefiraat.cultivation.implementation.slimefun.items.Plants;
import dev.sefiraat.cultivation.implementation.slimefun.items.Products;
import dev.sefiraat.cultivation.implementation.slimefun.items.Tools;
import dev.sefiraat.cultivation.implementation.slimefun.items.Trees;
import dev.sefiraat.cultivation.managers.ConfigManager;
import dev.sefiraat.cultivation.managers.DispatchManager;
import dev.sefiraat.cultivation.managers.ListenerManager;
import dev.sefiraat.cultivation.managers.SupportedPluginManager;
import dev.sefiraat.cultivation.managers.TaskManager;
import dev.sefiraat.sefilib.entity.display.DisplayGroupManager;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.updater.GitHubBuildsUpdater;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.text.MessageFormat;

public class Cultivation extends JavaPlugin implements SlimefunAddon {
    private static Cultivation instance;
    private final String username;
    private final String repo;
    private final String branch;

    private ConfigManager configManager;
    private SupportedPluginManager supportedPluginManager;
    private ListenerManager listenerManager;
    private TaskManager taskManager;
    private DispatchManager dispatchManager;
    private DisplayGroupManager displayGroupManager;
    private Registry registry;

    public Cultivation() {
        this.username = "Sefiraat";
        this.repo = "Cultivation";
        this.branch = "main";
    }

    @Override
    public void onEnable() {
        instance = this;

        getLogger().info("########################################");
        getLogger().info("               Cultivation              ");
        getLogger().info("         By Sefiraat and J3fftw         ");
        getLogger().info("########################################");

        saveDefaultConfig();
        this.configManager = new ConfigManager();
        tryUpdate();

        this.supportedPluginManager = new SupportedPluginManager();
        this.listenerManager = new ListenerManager();
        this.taskManager = new TaskManager();
        this.dispatchManager = new DispatchManager(this);
        this.displayGroupManager = new DisplayGroupManager(this);
        this.registry = new Registry();

        setupItems();
        setupStats();
    }

    private void setupItems() {
        Bushes.setup(this);
        Crafting.setup(this);
        Tools.setup(this);
        Machines.setup(this);
        Plants.setup(this);
        Trees.setup(this);
        Products.setup(this);
        Ingredients.setup(this);
        Foods.setup(this);
    }

    @Override
    public void onDisable() {
        this.configManager.saveAll();
    }

    public void tryUpdate() {
        if (configManager.isAutoUpdate() && getDescription().getVersion().startsWith("DEV")) {
            String updateLocation = MessageFormat.format("{0}/{1}/{2}", this.username, this.repo, this.branch);
            GitHubBuildsUpdater updater = new GitHubBuildsUpdater(this, getFile(), updateLocation);
            updater.start();
        }
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Nullable
    @Override
    public String getBugTrackerURL() {
        return MessageFormat.format("https://github.com/{0}/{1}/issues/", this.username, this.repo);
    }

    private void setupStats() {
        Metrics metrics = new Metrics(this, 18184);
    }

    public static Cultivation getInstance() {
        return Cultivation.instance;
    }

    public static void logError(@Nonnull String string) {
        instance.getLogger().severe(string);
    }

    public static void logWarning(@Nonnull String string) {
        instance.getLogger().warning(string);
    }

    public static void logInfo(@Nonnull String string) {
        instance.getLogger().info(string);
    }

    @Nonnull
    public static PluginManager getPluginManager() {
        return Cultivation.getInstance().getServer().getPluginManager();
    }

    public static ConfigManager getConfigManager() {
        return Cultivation.getInstance().configManager;
    }

    public static SupportedPluginManager getSupportedPluginManager() {
        return Cultivation.getInstance().supportedPluginManager;
    }

    public static ListenerManager getListenerManager() {
        return Cultivation.getInstance().listenerManager;
    }

    public static TaskManager getRunnableManager() {
        return Cultivation.getInstance().taskManager;
    }

    public static Registry getPlantRegistry() {
        return Cultivation.getInstance().registry;
    }

    public DispatchManager getDispatchManager() {
        return dispatchManager;
    }
}
