package com.loaf.morepvp.commands;

import java.util.Collection;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class swap implements CommandExecutor{
        public boolean onCommand(CommandSender sender, Command command, String arg, String[] args){
            
            List<Player> players = (List<Player>) Bukkit.getOnlinePlayers();
            if(players.size() != 2){
                Bukkit.broadcastMessage("there has to be 2 players online!");
                return true;
            }
            Player player1 = players.get(0);
            Player player2 = players.get(1);
            
            Location locP1 = player1.getLocation();
            player1.teleport(player2);
            player2.teleport(locP1);
            return true;
        
    }
      
}
