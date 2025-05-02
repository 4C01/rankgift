package win.trystage.rankgift.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public abstract class Menu implements InventoryHolder {
    protected Inventory menu;
    protected Player player;
    protected String title;

    public Menu(Player player, int size, String title) {
        this.player = player;
        this.title = title;
        this.menu = Bukkit.createInventory(this, size, title);
        setupItems(); // 初始化菜单物品
    }

    public Inventory getInventory() {
        return menu;
    }

    protected abstract void setupItems();

}
