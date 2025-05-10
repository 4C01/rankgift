package win.trystage.rankgift.menu;

import org.bukkit.entity.Player;
import win.trystage.rankgift.RankGift;

import static win.trystage.rankgift.RankGift.*;
import static win.trystage.rankgift.util.Placeholder.translateGift;

public class RankSelect extends Menu{
    public Player target;
    int[] layer;
    public RankSelect(Player player, Player target) {
        super(player, configManager.getInt("menu.gift.size"), translateGift(configManager.getString("menu.gift.title"),player, target)); // 动态标题
        this.target = target;
        setupItems();
    }
    @Override
    protected void setupItems() {

    }



    private void setLayer(){

        // 54 slots
        switch (configManager.getSection("rank.ranks").size()) {
            default:
                layer = new int[]{};
                break;
            case 2:
                layer = new int[]{30, 32};
                break;
            case 3:
                layer = new int[]{29, 31, 33};
                break;
            case 4:
                layer = new int[]{28, 30, 32, 34};
                break;
            case 5:
                layer = new int[]{27, 29, 31, 33, 35};
                break;
            case 6:
                layer = new int[]{29, 31, 33, 38, 40, 42};
                break;
            case 7:
                layer = new int[]{28, 29, 30, 31, 32, 33, 34};
                break;
            case 8:
                layer = new int[]{28, 30, 32, 34, 37, 39, 41, 43};
                break;
            case 9:
                layer = new int[]{27, 28, 29, 30, 31, 32, 33, 34, 35};
                break;
            case 10:
                layer = new int[]{27, 29, 31, 33, 35, 36, 38, 40, 42, 44};
                break;
        }
    }

}