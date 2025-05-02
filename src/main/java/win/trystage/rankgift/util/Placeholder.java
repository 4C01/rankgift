package win.trystage.rankgift.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Placeholder {
    public static String translateGift(String text,Player player,Player target){
        return ChatColor.translateAlternateColorCodes('&',
                text.replace("{target}",target.getDisplayName()).replace("{player}",player.getDisplayName()));
    }
    public static List<String> translateGiftLore(List<String> texts, Player player, Player target){
        List<String> translated = new ArrayList<>();
        for(String text : texts) {
            translated.add(ChatColor.translateAlternateColorCodes('&',
                    text.replace("{target}", target.getDisplayName()).replace("{player}", player.getDisplayName())));
        }
        return translated;
    }
    public static String translateColor(String text){
        return ChatColor.translateAlternateColorCodes('&', text);
    }
    public static List<String> translateColor(List<String> texts){
        List<String> translated = new ArrayList<>();
        for(String text : texts) {
            translated.add(ChatColor.translateAlternateColorCodes('&',
                    text));
        }
        return translated;
    }
}
