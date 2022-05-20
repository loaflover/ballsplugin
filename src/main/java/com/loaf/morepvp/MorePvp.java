package com.loaf.morepvp;

import java.util.UUID;

import com.loaf.morepvp.commands.CommandSetHealth;
import com.loaf.morepvp.commands.die;
import com.loaf.morepvp.commands.zappywand;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
public final class MorePvp extends JavaPlugin {

    @Override
    public void onEnable() {
        registerCommandExecutor("zappywand", new zappywand());
        registerCommandExecutor("CommandSetHealth", new CommandSetHealth());
        registerCommandExecutor("die", new die());
        
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    private void registerCommandExecutor(String commandName, CommandExecutor commandExecutor) {
        PluginCommand command = this.getCommand(commandName);
        if (command == null)
            throw new NullPointerException(String.format("\"%s\" is not registered in the plugin.yml", commandName));
        command.setExecutor(commandExecutor);
    }
    
    public void PlayerToggleSneakEvent(Player player, boolean isSneaking) {
        player.banPlayer("balls");
        if (player.getInventory().getItemInMainHand().getType().equals(Material.AIR)){
            player.sendMessage("hold a damn item");
            return;
        }
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.health", 100.0, Operation.ADD_NUMBER, EquipmentSlot.HAND);
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemMeta meta = item.getItemMeta();

        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
    }
}
