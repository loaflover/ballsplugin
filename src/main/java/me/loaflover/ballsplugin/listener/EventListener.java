package me.loaflover.ballsplugin.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class EventListener implements Listener {
    @EventHandler
    public void PlayerDropItemEvent(PlayerDropItemEvent event){
        
        Player die = event.getPlayer();
        die.kickPlayer("you stupid little bitch how dare you litter on my perfect minecraft server");
    }
    @EventHandler
    public void onPlayerClick(EntityDamageByEntityEvent event){
        /*
        for future note: use a player specific event, Entity events are often to brawd and need
        alot of if statements to work correctly, since they dont garantee that a player is the damaged/damager
        -btelnyy
        */

        Entity damager = event.getDamager();
        //add a function to check if a player is a damager
        //exists, its an enum with .getType() -bt
        if(damager.getType() != EntityType.PLAYER){
            //if the damager is not a player, return
            return;
        }
        Entity damaged = event.getEntity();
        if(damaged.getType() != EntityType.PLAYER){
            //if the damaged is not a player, return
            return;
        }
        ItemStack inHand = ((HumanEntity)damager).getItemInUse();
        /*
        Your code is not working cuz you are sending message to a entity, cast it as a player
        this will not cause errors becuase of the above if statements.
        -btelnyy
        */
        Player p = (Player) damaged;
        p.sendMessage("hi"); //try this
        //ALSO FIGURE OUT WHY THIS SHIT DOESNT WORK
    }
}
