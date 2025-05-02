package win.trystage.rankgift.menu;

import com.cryptomorin.xseries.SkullUtils;
import com.cryptomorin.xseries.XMaterial;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import win.trystage.rankgift.listener.RankSelect;


import static win.trystage.rankgift.RankGift.*;
import static win.trystage.rankgift.util.MenuUtil.exitItem;
import static win.trystage.rankgift.util.Placeholder.*;

public class GiftMenu extends Menu{
    public Player target;
    public GiftMenu(Player player, String targetName) {
        super(player, configManager.getInt("menu.gift.size"), translateGift(configManager.getString("menu.gift.title"),player,Bukkit.getPlayer(targetName))); // 动态标题
        target = Bukkit.getPlayer(targetName);
        setupItems();
    }

    @Override
    protected void setupItems() {

        // 创建 Rank 礼物物品
        ItemStack rankItem = createGiftItem(
                configManager.getString("menu.gift.item.rank.material"),
                configManager.getString("menu.gift.item.rank.name"),
                configManager.getString("menu.gift.item.rank.lore")
        );
        menu.setItem(configManager.getInt("menu.gift.item.rank.slot"), rankItem);

        // 创建 MysteryBox 礼物物品
        ItemStack mysteryBoxItem = createGiftItem(
                configManager.getString("menu.gift.item.mysterybox.material"),
                configManager.getString("menu.gift.item.mysterybox.name"),
                configManager.getString("menu.gift.item.mysterybox.lore")
        );
        menu.setItem(configManager.getInt("menu.gift.item.mysterybox.slot"), mysteryBoxItem);

        // 退出(自动在最后一行中间)
        menu.setItem(configManager.getInt("menu.gift.size") - 5, exitItem());
    }

    private ItemStack createGiftItem(String materialPath, String namePath, String lorePath) {
        String materialConfig = configManager.getString(materialPath);
        ItemStack item;
        // 处理 Base64 头颅
        if (materialConfig.startsWith("basehead-")) {
            String base64 = materialConfig.replaceFirst("basehead-", "");
            item = XMaterial.PLAYER_HEAD.parseItem(); // 获取玩家头颅 Material
            SkullMeta meta = (SkullMeta) item.getItemMeta();
            meta = SkullUtils.applySkin(meta, base64); // 设置 Base64
            item.setItemMeta(meta);
        } else {
            // 处理普通材质
            Material material = Material.getMaterial(materialConfig.toUpperCase());
            if (material == null) {
                material = Material.STONE; // 默认材质（可自定义）
                Bukkit.getLogger().warning("未知材质: " + materialConfig);
            }
            item = new ItemStack(material);
        }

        // 设置物品显示名称和描述
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(translateGift(configManager.getString(namePath), player, target));
            meta.setLore(translateGiftLore(configManager.getStringList(lorePath), player, target));
            item.setItemMeta(meta);
        }

        return item;
    }

    // 处理点击事件（由监听器调用）
    public void onClick(int slot) {
        if (slot == 12) {
            player.sendMessage(ChatColor.GREEN + "你点击了赠送按钮!");
            // 打开下级菜单
            MenuManager.openMenu(player, new RankSelect(player,target));
        }
    }


}
