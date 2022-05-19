package me.btelnyy.lifesteal;
import me.btelnyy.lifesteal.commands.*;
import me.btelnyy.lifesteal.listener.EventListener;
import me.btelnyy.lifesteal.service.ConfigLoaderService;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Level;

public class LifeSteal extends JavaPlugin {

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
        registerCommandExecutor("sethealth", new CommandSetHealth());
        registerCommandExecutor("givehealth", new CommandGiveHearts());
        registerCommandExecutor("zappywand", new zappywand());
        //event handle
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        //github
        getLogger().log(Level.INFO, "Check out the project on GitHub!: https://github.com/BTELNYY/btelnyy-lifesteal");
    }

    private void registerCommandExecutor(String commandName, CommandExecutor commandExecutor) {
        PluginCommand command = this.getCommand(commandName);
        if (command == null)
            throw new NullPointerException(String.format("\"%s\" is not registered in the plugin.yml", commandName));
        command.setExecutor(commandExecutor);
    }
    public void onPlayerClick(EntityDamageByEntityEvent event){
        Entity damager = event.getDamager();
        //add a function to check if a player is a damager
        Entity damaged = event.getEntity();
        ItemStack inHand = ((HumanEntity)damager).getItemInUse();
        damaged.sendMessage("hi");
        //ALSO FIGURE OUT WHY THIS SHIT DOESNT WORK
    }
}
