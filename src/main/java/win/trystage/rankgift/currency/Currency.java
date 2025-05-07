package win.trystage.rankgift.currency;

import org.bukkit.entity.Player;

public abstract class Currency {
    public abstract boolean has(Player player, double amount);
    public abstract boolean take(Player player, double amount);
    public abstract String getCurrencyName();
    public abstract double getBalance(Player player);
}
