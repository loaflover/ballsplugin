package me.loaflover.ballsplugin;
import me.loaflover.ballsplugin.commands.*;
import me.loaflover.ballsplugin.listener.EventListener;
import me.loaflover.ballsplugin.service.ConfigLoaderService;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;

public class BallsPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // config
        File configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            try {
                saveDefaultConfig();
            } catch (Exception e) {
                getLogger().log(Level.SEVERE, "Config.yml could not be created. Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
        ConfigLoaderService configLoaderService = new ConfigLoaderService(getConfig(), getLogger());
        configLoaderService.loadConfig();
        //commands
        /*
        registerCommandExecutor("sethealth", new CommandSetHealth());
        registerCommandExecutor("givehealth", new CommandGiveHearts());
        keeping these files for "teaching"
        */
        registerCommandExecutor("zappywand", new zappywand());
        //event handle
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        //github
        getLogger().log(Level.INFO, "Check out the project on GitHub!: https://github.com/BTELNYY/btelnyy-lifesteal");
        /*
        If you are looking for your code, its in listener/EventListener.java
        your code wouldnt work here cuz this isnt registered as a listener class
        */
    }

    private void registerCommandExecutor(String commandName, CommandExecutor commandExecutor) {
        PluginCommand command = this.getCommand(commandName);
        if (command == null)
            throw new NullPointerException(String.format("\"%s\" is not registered in the plugin.yml", commandName));
        command.setExecutor(commandExecutor);
    }
}
