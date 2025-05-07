package win.trystage.rankgift.currency;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static win.trystage.rankgift.RankGift.configManager;

public class Vault extends Currency{
    private Economy economy;
    public Vault(){
        this.economy = Bukkit.getServicesManager().getRegistration(Economy.class).getProvider();
    }
    @Override
    public boolean has(Player player, double amount) {
        return economy.has(player,amount);
    }

    @Override
    public boolean take(Player player, double amount) {
        return economy.withdrawPlayer(player,amount).transactionSuccess();
    }

    @Override
    public String getCurrencyName() {
        return configManager.getString("rank.settings.economy");
    }

    @Override
    public double getBalance(Player player) {
        return economy.getBalance(player);
    }
}
