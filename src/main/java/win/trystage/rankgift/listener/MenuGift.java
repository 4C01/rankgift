package win.trystage.rankgift.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import win.trystage.rankgift.menu.GiftMenu;
import win.trystage.rankgift.menu.Menu;

public class MenuGift implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        // 只处理菜单点击
        if (!(e.getInventory().getHolder() instanceof Menu)) return;
        if (!(e.getWhoClicked() instanceof Player)) return;

        // 阻止玩家移动物品
        e.setCancelled(true);

        // 获取菜单实例
        Menu menu = (Menu) e.getInventory().getHolder();
        Player player = (Player) e.getWhoClicked();

        // 路由到具体菜单处理
        if (menu instanceof GiftMenu) {
            ((GiftMenu) menu).onClick(e.getRawSlot());
        }
    }
}
