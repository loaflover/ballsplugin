package com.loaf.morepvp.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.bukkit.command.Command;


import org.bukkit.Bukkit;


//DO NOT DELETE, USE AS EXAMPLE



public class die implements CommandExecutor{
    public boolean onCommand(CommandSender sender, Command command, String arg, String[] args){
        Player player = Bukkit.getPlayer(args[0]);
        for (int i = 0; i < 500; i++) {
            player.getWorld().strikeLightning(player.getLocation());
            
          }
          Bukkit.broadcastMessage(player.getName() + " kermited a dying");
        
        // if (player.getInventory().getItemInMainHand().getType().equals(Material.AIR)){
        //     player.sendMessage("hold a damn item");
        //     return true;
        // }
        // AttributeModifier modifier = new AttributeModifier(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3"), "generic.health", 1000000.0, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        // ItemStack item = player.getInventory().getItemInMainHand();
        // ItemMeta meta = item.getItemMeta();

        // meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);

        //BT ITS UR JOB TO FIX PLZ

        return true;
    }
}

