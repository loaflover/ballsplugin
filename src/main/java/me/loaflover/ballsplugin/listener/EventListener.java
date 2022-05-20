package me.loaflover.ballsplugin.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.server.BroadcastMessageEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class EventListener implements Listener {
    @EventHandler
    public void PlayerDropItemEvent(PlayerDropItemEvent event){
        
        Player die = event.getPlayer();
        die.kickPlayer("BOZO you stupid little bitch how dare you litter on my perfect minecraft server");
    }


    @EventHandler
    public void PlayerInteractEntityEvent(Player who, Entity clickedEntity, Vector position, EquipmentSlot hand){
        who.kickPlayer("message");
    }




    @EventHandler
    public void onDamageTaken(EntityDamageByEntityEvent e) {
        if(e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
        if(e.getDamage()>0.1) {
            Player damager = (Player) e.getDamager();
            damager.damage(600.0);
        }
        }
    }
    @EventHandler
    public void ProjectileHitEvent(Projectile projectile) {
        projectile.getWorld().spawnEntity(projectile.getLocation(),EntityType.PRIMED_TNT);
        
    }
}
