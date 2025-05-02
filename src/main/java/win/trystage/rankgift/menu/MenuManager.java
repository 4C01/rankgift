package win.trystage.rankgift.menu;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class MenuManager {
    private static final Map<Player,Menu> menus = new HashMap<>();

    public static void openMenu(Player player,Menu menu){
        menus.put(player,menu);
        player.openInventory(menu.getInventory());
    }

    public static Menu getOpenMenu(Player player){
        return menus.get(player);
    }

    public static void closeMenu(Player player){
        menus.remove(player);
    }
}
