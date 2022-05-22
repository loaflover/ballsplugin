package me.loaf.morepvp.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

public class zappywand implements CommandExecutor{
    public boolean onCommand(CommandSender sender, Command command, String arg, String[] args){
        Player user = (Player)sender;
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Magic Wand");
        /*
        Paper API Stuff
        ArrayList<Component> lore = new ArrayList<Component>();
        Component c = Component.text("big balls");
        lore.add(c);
        meta.lore().add(c);
        */
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("big balls");
        meta.setLore(lore);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, new AttributeModifier("attack damsssage: ", 100.0, Operation.ADD_NUMBER));
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, new AttributeModifier("attack damage: ", 2.0, Operation.ADD_NUMBER));
        item.setItemMeta(meta);
        user.getInventory().addItem(item);
        return true;
    }
}
