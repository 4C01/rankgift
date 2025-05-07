package win.trystage.rankgift.currency;

import org.black_ixx.playerpoints.PlayerPoints;
import org.black_ixx.playerpoints.PlayerPointsAPI;
import org.bukkit.entity.Player;

import static win.trystage.rankgift.RankGift.*;

public class Points extends Currency{
    private PlayerPointsAPI api;

    public Points() {
        this.api = PlayerPoints.getInstance().getAPI();
    }

    @Override
    public boolean has(Player player, double amount) {
        return api.look(player.getUniqueId()) >= (int) amount;
    }

    @Override
    public boolean take(Player player, double amount) {
        return api.take(player.getUniqueId(), (int) amount);
    }

    @Override
    public String getCurrencyName() {
        return configManager.getString("rank.settings.points");
    }

    @Override
    public double getBalance(Player player) {
        return api.look(player.getUniqueId());
    }
}
