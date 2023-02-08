package dev.sefiraat.cultivation.managers;

import dev.sefiraat.cultivation.Cultivation;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * This class is used to create and manage/save custom configuration files
 */
public class ConfigManager {

    // Player exp
    private final FileConfiguration exp;

    public ConfigManager() {
        setupDefaultConfig();
        this.exp = getConfig("exp.yml");
    }

    private void setupDefaultConfig() {
        final Cultivation plugin = Cultivation.getInstance();
        final InputStream inputStream = plugin.getResource("config.yml");

        if (inputStream == null) {
            // Not sure how? Regardless cannot copy over new keys
            return;
        }

        final File existingFile = new File(plugin.getDataFolder(), "config.yml");
        final Reader reader = new InputStreamReader(inputStream);
        final FileConfiguration resourceConfig = YamlConfiguration.loadConfiguration(reader);
        final FileConfiguration existingConfig = YamlConfiguration.loadConfiguration(existingFile);

        for (String key : resourceConfig.getKeys(false)) {
            checkKey(existingConfig, resourceConfig, key);
        }

        try {
            existingConfig.save(existingFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ParametersAreNonnullByDefault
    private void checkKey(FileConfiguration existingConfig, FileConfiguration resourceConfig, String key) {
        final Object currentValue = existingConfig.get(key);
        final Object newValue = resourceConfig.get(key);
        if (newValue instanceof ConfigurationSection section) {
            for (String sectionKey : section.getKeys(false)) {
                checkKey(existingConfig, resourceConfig, key + "." + sectionKey);
            }
        } else if (currentValue == null) {
            existingConfig.set(key, newValue);
        }
    }

    @Nonnull
    @SuppressWarnings("ResultOfMethodCallIgnored")
    private FileConfiguration getConfig(@Nonnull String fileName) {
        final Cultivation plugin = Cultivation.getInstance();
        final File file = new File(plugin.getDataFolder(), fileName);

        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return YamlConfiguration.loadConfiguration(file);
    }

    public void saveAll() {
        Cultivation.getInstance().getLogger().info("Netheopoiesis saving data.");
        saveExp();
    }

    private void saveExp() {
        File file = new File(Cultivation.getInstance().getDataFolder(), "exp.yml");
        try {
            exp.save(file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public FileConfiguration getExp() {
        return exp;
    }

    public boolean isAutoUpdate() {
        return Cultivation.getInstance().getConfig().getBoolean("auto-update");
    }

    public boolean isDebugMessages() {
        return Cultivation.getInstance().getConfig().getBoolean("debug-messages");
    }

}
