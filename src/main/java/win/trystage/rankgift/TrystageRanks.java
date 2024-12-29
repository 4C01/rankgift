package win.trystage.rankgift;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class TrystageRanks extends JavaPlugin {
    static YamlConfiguration yml;
    public FileConfiguration config = this.getConfig();
    File configfile = new File("plugins/" + this + "/config.yml");
    public static YamlConfiguration getYml() {
        return yml;
    }
    @Override
    public void onEnable(){
        System.out.println("[Trystage RankGift] Plugin Loaded");
        this.saveDefaultConfig();
        yml = YamlConfiguration.loadConfiguration(configfile);
    }
    @Override
    public void onDisable(){
        System.out.println("[Trystage RankGift] Plugin Disabled");
    }
}
