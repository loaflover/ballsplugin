package me.loaflover.ballsplugin;
import me.loaflover.ballsplugin.Enchants.Zap;
import me.loaflover.ballsplugin.commands.*;
import me.loaflover.ballsplugin.listener.EventListener;
import me.loaflover.ballsplugin.service.ConfigLoaderService;

import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.NamespacedKey;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.logging.Level;

public class BallsPlugin extends JavaPlugin implements Listener {
    public Zap ench = new Zap(new NamespacedKey("test", "yo"));
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



        //custom enchants 
        LoadEnchantments();
        this.getServer().getPluginManager().registerEvents(this, this);



        //commands
        /*
        registerCommandExecutor("sethealth", new CommandSetHealth());
        registerCommandExecutor("givehealth", new CommandGiveHearts());
        keeping these files for "teaching"
        */
        registerCommandExecutor("zappywand", new zappywand());
        registerCommandExecutor("CommandSetHealth", new CommandSetHealth());
        //event handle
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        //github
        getLogger().log(Level.INFO, "Check out the project on GitHub!: https://github.com/BTELNYY/btelnyy-lifesteal");
        /*
        If you are looking for your code, its in listener/EventListener.java
        your code wouldnt work here cuz this isnt registered as a listener class
        -btelnyy
        */
    }
    
    // @SuppressWarnings("unchecked")
    // public void onDisable(){
    //    try{
    //        Field byID = Enchantment.class.getDeclaredField("byid");
    //        Field byName = Enchantment.class.getDeclaredField("byname");

    //        byID.setAccessible(true);
    //        byName.setAccessible(true);
    //     HashMap<Integer,Enchantment> byid = (HashMap<Integer, Enchantment>) byID.get(null);
    //     HashMap<Integer,Enchantment> byname = (HashMap<Integer, Enchantment>) byName.get(null);

    //     if(byid.containsKey(ench.getId())){
    //        byid.remove(ench.getId());
    //     }
    //     if(byname.containsKey(ench.getId())){
    //         byname.remove(ench.getName());
    //     }
    //    } catch(Exception ignored){

    //    }
    // }

    private void LoadEnchantments() {
        try{
            try{
                Field f = Enchantment.class.getDeclaredField("acceptingNew");
                f.setAccessible(true);
                f.set(null, true);
            }catch(Exception e){
                e.printStackTrace();
            }
            try{
                Enchantment.registerEnchantment(ench);
            }catch (IllegalArgumentException e){
                e.printStackTrace();
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }





    private void registerCommandExecutor(String commandName, CommandExecutor commandExecutor) {
        PluginCommand command = this.getCommand(commandName);
        if (command == null)
            throw new NullPointerException(String.format("\"%s\" is not registered in the plugin.yml", commandName));
        command.setExecutor(commandExecutor);
    }
    
    
}
