package me.loaf.morepvp.EventListiner;
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
        //this may be better if the event is in the class file, as this would reduce lines here, and
        //improve code visibility
        switch(weaponname){
            case "BoomBoom Wand":
                Entity goat = user.getWorld().spawnEntity(user.getLocation(), EntityType.GOAT);
                goat.setVelocity(user.getLocation().getDirection().multiply(2));
                goat.setCustomName("bullet"); 
                new BukkitRunnable(){
                    public void run(){

                        if(goat.isDead()){
                            return;
                        }
                        goat.getWorld().createExplosion(goat, 5,false,false);
                        //goat.getLocation().createExplosion(5, false, false);
                        ((LivingEntity) goat).damage(100);
                        
                    }
                }.runTaskLater(Bukkit.getPluginManager().getPlugin("morepvp"), 100);
                break;
            case "Buzzy Wand":
            Bee bee = (Bee) event.getPlayer().getWorld().spawnEntity(event.getPlayer().getLocation(), EntityType.BEE);
            bee.setCustomName("buzzyBullet");
            bee.setCustomNameVisible(true);
            //bee.setTarget(event.getPlayer()); add a way to find target player here
            //use attack instead, or try a flying snowball?
            bee.setAnger(100000);
            break;

        }
    }

    @EventHandler
    public void entityDamage(EntityDamageByEntityEvent event)
    {
        Player hitter = (Player) event.getDamager();
        String weaponname = hitter.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
        if(!(event.getDamager() instanceof Player) ||  !(event.getEntity() instanceof Player)){
            return;
        }
        switch(weaponname) {
            case "Testicle Obliterator Wand":
            //change this to multiply by current vector so you still take knockback
                new BukkitRunnable(){public void run(){event.getEntity().setVelocity(new Vector(0, 1, 0));}}.runTaskLater(Bukkit.getPluginManager().getPlugin("morepvp"), 1);
              break;
            case "BoomBoom Wand":
                Location loc = event.getEntity().getLocation();
                if(event.getCause().equals(DamageCause.ENTITY_ATTACK)){
                
                    new BukkitRunnable(){public void run(){event.getEntity().getWorld().createExplosion(hitter,5 ,false,false);}}.runTaskLater(Bukkit.getPluginManager().getPlugin("morepvp"), 1);
                }
              break;
              case "Electric Wand":
              event.getEntity().getWorld().strikeLightning(event.getEntity().getLocation());
              break;
              //were you following a tutorial or is this debug code?
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

