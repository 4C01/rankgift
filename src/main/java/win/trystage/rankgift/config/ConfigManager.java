package win.trystage.rankgift.config;


import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ConfigManager {
    private final JavaPlugin plugin;
    private final String fileName;
    private File configFile;
    private YamlConfiguration config;

    public ConfigManager(JavaPlugin plugin, String fileName) {
        this.plugin = plugin;
        this.fileName = fileName;
        this.configFile = new File(plugin.getDataFolder(), fileName);
        loadConfig();
    }
    public void loadConfig() {
        if (!configFile.exists()) {
            plugin.saveResource(fileName, false);
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }





    public int getInt(String path){
        return config.getInt(path);
    }

    public String getString(String path){
        return config.getString(path);
    }
    public boolean getBoolean(String path){
        return config.getBoolean(path);
    }
    public double getDouble(String path){
        return config.getDouble(path);
    }
    public List<String> getStringList(String path){
        return config.getStringList(path);
    }
    public List<String> getSection(String path){
        return new ArrayList<>(config.getConfigurationSection(path).getKeys(false));
    }
}
