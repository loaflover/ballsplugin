package me.btelnyy.lifesteal.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerDropItemEvent;

import me.btelnyy.lifesteal.constants.Globals;

public class EventListener implements Listener {
    @EventHandler
    public void PlayerDropItemEvent(PlayerDropItemEvent event){
        
        Player die = event.getPlayer();
        die.kickPlayer("you stupid little bitch how dare you litter on my perfect minecraft server");
    }
}
