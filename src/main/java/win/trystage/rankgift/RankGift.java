package win.trystage.rankgift;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import win.trystage.rankgift.config.ConfigManager;
import win.trystage.rankgift.currency.Points;
import win.trystage.rankgift.currency.Vault;

public class RankGift extends JavaPlugin {
    public static ConfigManager configManager;
    public static Points points;
    public static Vault vault;

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
        if(Bukkit.getPluginManager().getPlugin("PlayerPoints") != null && Bukkit.getPluginManager().getPlugin("PlayerPoints").isEnabled()){
            points = new Points();
            getLogger().info("Hooked into player points support!");
        }
        else {
            getLogger().info("Cannot find player points plugin,skip");
        }
        if(Bukkit.getPluginManager().getPlugin("Vault") != null && Bukkit.getPluginManager().getPlugin("Vault").isEnabled()){
            vault = new Vault();
            getLogger().info("Hooked into vault economy support!");
        }
        else {
            getLogger().info("Cannot find vault plugin,skip");
        }
        if(points == null && vault == null){
            getLogger().info("Theres no Vault and no Player Points!Are you sure?!");
        }
    }
}
