package win.trystage.rankgift;

import org.bukkit.plugin.java.JavaPlugin;
import win.trystage.rankgift.config.ConfigManager;

public class RankGift extends JavaPlugin {
    public static ConfigManager configManager;
    @Override
    public void onEnable(){
        System.out.println("[RankGift] Plugin Loaded");
        init();
    }
    @Override
    public void onDisable(){
        System.out.println("[RankGift] Plugin Disabled");
    }

    public void init(){
        this.saveDefaultConfig();
        configManager = new ConfigManager(this,"config.yml");
    }
}
