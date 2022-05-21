package com.loaf.morepvp.EventListiner;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InteractListiner implements Listener{
    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event){
       
        Player p = event.getPlayer();
        if(event.getHand() == EquipmentSlot.OFF_HAND){
            return; 
        } 
        ItemStack item = p.getActiveItem();
        String itemName = item.getItemMeta().getDisplayName();
        event.getPlayer().sendMessage(itemName);
        
        if(item.getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Magic Wand")){
            
        } 
        
    }

    
    
    @EventHandler
    public void PlayerDropItemEvent(PlayerDropItemEvent event){
        
        Player die = event.getPlayer();
        die.kickPlayer("BOZO you stupid little bitch how dare you litter on my perfect minecraft server");
    }
    public void PlayerToggleSneakEvent(Player player, boolean isSneaking) {
        player.banPlayer("balls");
        if (player.getInventory().getItemInMainHand().getType().equals(Material.AIR)){
            player.sendMessage("hold a damn item");
            return;
        }
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 100.0, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();

        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
    }
}

