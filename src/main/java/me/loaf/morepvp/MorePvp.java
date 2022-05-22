package me.loaf.morepvp;


import me.loaf.morepvp.EventListiner.InteractListiner;
//yes loaf, you can use * to mean wildcard.
import me.loaf.morepvp.commands.*;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

/*
SEE pom.xml TO CHANGE TO PAPER API

For the love of god, please remove unused Imports from the other classes, its a massive pain finding 
actual warnings in a sea of unused imports.

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
