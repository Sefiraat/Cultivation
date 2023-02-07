package dev.sefiraat.botanystory;

import dev.sefiraat.botanystory.managers.ConfigManager;
import dev.sefiraat.botanystory.managers.DispatchManager;
import dev.sefiraat.botanystory.managers.ListenerManager;
import dev.sefiraat.botanystory.managers.SupportedPluginManager;
import dev.sefiraat.botanystory.managers.TaskManager;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.updater.GitHubBuildsUpdater;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.text.MessageFormat;

public class BotanyStory extends JavaPlugin implements SlimefunAddon {
    private static BotanyStory instance;
    private final String username;
    private final String repo;
    private final String branch;

    private ConfigManager configManager;
    private SupportedPluginManager supportedPluginManager;
    private ListenerManager listenerManager;
    private TaskManager taskManager;
    private DispatchManager dispatchManager;
    private Registry registry;

    public BotanyStory() {
        this.username = "Sefiraat";
        this.repo = "BotanyStory";
        this.branch = "master";
    }

    @Override
    public void onEnable() {
        instance = this;

        getLogger().info("########################################");
        getLogger().info("     BotanyStory by Sefiraat, J3fftw    ");
        getLogger().info("########################################");

        saveDefaultConfig();
        this.configManager = new ConfigManager();
        tryUpdate();

        this.supportedPluginManager = new SupportedPluginManager();
        this.listenerManager = new ListenerManager();
        this.taskManager = new TaskManager();
        this.dispatchManager = new DispatchManager(this);
        this.registry = new Registry();

        // Items.setup(this);

        setupStats();
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
        Metrics metrics = new Metrics(this, 15374);
    }

    public static BotanyStory getInstance() {
        return BotanyStory.instance;
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
        return BotanyStory.getInstance().getServer().getPluginManager();
    }

    public static ConfigManager getConfigManager() {
        return BotanyStory.getInstance().configManager;
    }

    public static SupportedPluginManager getSupportedPluginManager() {
        return BotanyStory.getInstance().supportedPluginManager;
    }

    public static ListenerManager getListenerManager() {
        return BotanyStory.getInstance().listenerManager;
    }

    public static TaskManager getRunnableManager() {
        return BotanyStory.getInstance().taskManager;
    }

    public static Registry getPlantRegistry() {
        return BotanyStory.getInstance().registry;
    }

    public DispatchManager getDispatchManager() {
        return dispatchManager;
    }
}
