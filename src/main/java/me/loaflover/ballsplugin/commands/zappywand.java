package me.loaflover.ballsplugin.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;;

public class zappywand implements CommandExecutor{
    public boolean onCommand(CommandSender sender, Command command, String arg, String[] args){
        Player user = (Player)sender;
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "Magic Wand");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("big balls");
        meta.setLore(lore);
        item.setItemMeta(meta);
        user.getInventory().addItem(item);
        return true;
    }
}
