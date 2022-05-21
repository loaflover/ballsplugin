package com.loaf.morepvp;


import java.util.UUID;

import com.loaf.morepvp.EventListiner.InteractListiner;
import com.loaf.morepvp.commands.CommandSetHealth;
import com.loaf.morepvp.commands.boomboom;
import com.loaf.morepvp.commands.die;
import com.loaf.morepvp.commands.swap;
import com.loaf.morepvp.commands.zappywand;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

/*
USE THE SPIGOT DEPENDENCY, PAPER IS GOOD FOR PEOPLE WHO KNOW HOW TO WRITE JAVA
COPY FROM MY GITHUB
-btelnyy
*/


public final class MorePvp extends JavaPlugin {

    @Override
    public void onEnable() {
        registerCommandExecutor("zappywand", new zappywand());
        registerCommandExecutor("CommandSetHealth", new CommandSetHealth());
        //registerCommandExecutor("die", new die());
        registerCommandExecutor("swap", new swap());
        registerCommandExecutor("boomboom", new boomboom());
        Bukkit.getPluginManager().registerEvents(new InteractListiner(), this);
       
    }

  

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        //usually nothing, unless youve got save data
    }
    private void registerCommandExecutor(String commandName, CommandExecutor commandExecutor) {
        PluginCommand command = this.getCommand(commandName);
        if (command == null)
            throw new NullPointerException(String.format("\"%s\" is not registered in the plugin.yml", commandName));
        command.setExecutor(commandExecutor);
    }
    


    

    
}
