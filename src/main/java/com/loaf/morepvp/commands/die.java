package com.loaf.morepvp.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.command.Command;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;


//DO NOT DELETE, USE AS EXAMPLE



public class die implements CommandExecutor{
    public boolean onCommand(CommandSender sender, Command command, String arg, String[] args){
        Player player = Bukkit.getPlayer(args[0]);
        for (int i = 0; i < 500; i++) {
            player.getWorld().strikeLightning(player.getLocation());    
        }
          Bukkit.broadcastMessage(player.getName() + " kermited a dying");
        
        if (player.getInventory().getItemInMainHand().getType().equals(Material.AIR)){
            player.sendMessage("hold a damn item");
            return true;
        }
        //yo dumbass forgot the imports
        AttributeModifier modifier = new AttributeModifier(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3"), "generic.health", 1000000.0, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
        return true;
    }
}

