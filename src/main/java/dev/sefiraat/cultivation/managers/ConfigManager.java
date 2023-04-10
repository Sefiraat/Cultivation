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

    public static final String FILE_NAME_EXP = "exp.yml";
    public static final String FILE_NAME_CODEX = "codex.yml";

    // Player exp
    private final FileConfiguration exp;
    private final FileConfiguration codex;

    public ConfigManager() {
        setupDefaultConfig();
        this.exp = getConfig(FILE_NAME_EXP);
        this.codex = getConfig(FILE_NAME_CODEX);
    }

    private void setupDefaultConfig() {
        Cultivation plugin = Cultivation.getInstance();
        InputStream inputStream = plugin.getResource("config.yml");

        if (inputStream == null) {
            // Not sure how? Regardless cannot copy over new keys
            return;
        }

        File existingFile = new File(plugin.getDataFolder(), "config.yml");
        Reader reader = new InputStreamReader(inputStream);
        FileConfiguration resourceConfig = YamlConfiguration.loadConfiguration(reader);
        FileConfiguration existingConfig = YamlConfiguration.loadConfiguration(existingFile);

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
        Object currentValue = existingConfig.get(key);
        Object newValue = resourceConfig.get(key);
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
        Cultivation plugin = Cultivation.getInstance();
        File file = new File(plugin.getDataFolder(), fileName);

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
        Cultivation.getInstance().getLogger().info("Cultivation saving data.");
        save(exp, FILE_NAME_EXP);
        save(codex, FILE_NAME_CODEX);
    }

    private void save(@Nonnull FileConfiguration config, @Nonnull String fileName) {
        File file = new File(Cultivation.getInstance().getDataFolder(), fileName);
        try {
            config.save(file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public FileConfiguration getExp() {
        return exp;
    }

    public FileConfiguration getCodex() {
        return codex;
    }

    public boolean isAutoUpdate() {
        return Cultivation.getInstance().getConfig().getBoolean("auto-update");
    }

    public boolean isDebugMessages() {
        return Cultivation.getInstance().getConfig().getBoolean("debug-messages");
    }

}
