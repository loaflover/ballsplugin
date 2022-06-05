package me.loaf.morepvp.commands;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class buzzy implements CommandExecutor{
    public boolean onCommand(CommandSender sender, Command command, String arg, String[] args){
        
        
        
        Player user = (Player)sender;
        ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Buzzy Shirt");
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
        item.setItemMeta(meta);
        user.getInventory().addItem(item);
        return true;
    }

    
}
