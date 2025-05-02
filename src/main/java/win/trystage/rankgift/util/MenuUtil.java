package win.trystage.rankgift.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static win.trystage.rankgift.RankGift.*;
import static win.trystage.rankgift.util.Placeholder.*;

public class MenuUtil {

    public static ItemStack exitItem(){
        String materialConfig = configManager.getString("menu.gift.item.exit.material");
        ItemStack item;
        // 处理普通材质
        Material material = Material.getMaterial(materialConfig.toUpperCase());
        if (material == null) {
            material = Material.STONE; // 默认材质（可自定义）
            Bukkit.getLogger().warning("未知材质: " + materialConfig);
        }
        item = new ItemStack(material);

        // 设置物品显示名称和描述
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',configManager.getString(configManager.getString("menu.gift.item.exit.name"))));
            meta.setLore(translateColor(configManager.getStringList(configManager.getString("menu.gift.item.exit.lore"))));
            item.setItemMeta(meta);
        }
        return item;
    }
}
