package com.loaf.morepvp.EventListiner;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.UUID;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.entity.Bee;
import org.bukkit.entity.Entity;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import org.bukkit.event.block.Action;

public class InteractListiner implements Listener{
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player user = (Player) event.getPlayer();
        String weaponname = user.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
        if(!(event.getAction().equals(Action.RIGHT_CLICK_AIR)||event.getAction().equals(Action.RIGHT_CLICK_BLOCK))){
            return;
        }
        
        switch(weaponname){
            case "bomb on a stick":
                Entity goat = user.getWorld().spawnEntity(user.getLocation(), EntityType.GOAT);
                goat.setVelocity(user.getLocation().getDirection().multiply(2));
                goat.setCustomName("bullet"); 
                new BukkitRunnable(){
                    public void run(){
                        if(goat.isDead()){
                            return;
                        }
                        goat.getWorld().createExplosion(goat, 5,false,false);
                        ((LivingEntity) goat).damage(100);
                    }
                }.runTaskLater(Bukkit.getPluginManager().getPlugin("morepvp"), 100);
                break;
            case "buzzbuzz":
            Bee bee = (Bee) event.getPlayer().getWorld().spawnEntity(event.getPlayer().getLocation(), EntityType.BEE);
            bee.setCustomName("buzzyBullet");
            bee.setCustomNameVisible(true);
            //bee.setTarget(event.getPlayer()); add a way to find target player here
            bee.setAnger(100000);
            break;

        }
        if(weaponname.equals("")){
            
                
               
            
            
        
        }
        
    }
    

    
    
    
    @EventHandler(priority = EventPriority.LOWEST)
    public void entityDamage(EntityDamageByEntityEvent event)
    {
        if(!(event.getDamager() instanceof Player) ||  !(event.getEntity() instanceof Player)){
            return;
        }
        Player hitter = (Player) event.getDamager();
        String weaponname = hitter.getInventory().getItemInMainHand().getItemMeta().getDisplayName();

        switch(weaponname) {
            case "Magic Wand":
                new BukkitRunnable(){public void run(){event.getEntity().setVelocity(new Vector(0, 1, 0));}}.runTaskLater(Bukkit.getPluginManager().getPlugin("morepvp"), 1);
              break;
            case "bomb on a stick":
                Location loc = event.getEntity().getLocation();
                if(event.getCause().equals(DamageCause.ENTITY_ATTACK)){
                
                    new BukkitRunnable(){public void run(){event.getEntity().getWorld().createExplosion(hitter,5 ,false,false);}}.runTaskLater(Bukkit.getPluginManager().getPlugin("morepvp"), 1);
                }
              break;
              case "zappy":
              event.getEntity().getWorld().strikeLightning(event.getEntity().getLocation());
              break;
              case "":
              // code block
              break;
              case "g":
              // code block
              break;
            default:
              // code block
          }
          
        
        
    }
    

}

