package win.trystage.rankgift.menu;

import org.bukkit.entity.Player;

import static win.trystage.rankgift.RankGift.configManager;
import static win.trystage.rankgift.util.Placeholder.translateGift;

public class RankSelect extends Menu{
    public Player target;
    public RankSelect(Player player, Player target) {
        super(player, configManager.getInt("menu.gift.size"), translateGift(configManager.getString("menu.gift.title"),player, target)); // 动态标题
        this.target = target;
        setupItems();
    }
    @Override
    protected void setupItems() {

    }

}