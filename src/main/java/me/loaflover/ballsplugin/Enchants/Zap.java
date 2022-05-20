package me.loaflover.ballsplugin.Enchants;

import java.net.http.WebSocket.Listener;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class Zap extends Enchantment implements org.bukkit.event.Listener{
    public Zap (NamespacedKey id){
        super(id);
    }


    
    public int getId() {
        // TODO Auto-generated method stub
        return 101;
    }


    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "zapzap";
    }

    @Override
    public int getMaxLevel() {
        // TODO Auto-generated method stub
        return 2;
    }

    @Override
    public int getStartLevel() {
        // TODO Auto-generated method stub
        return 1;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isTreasure() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isCursed() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment other) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        // TODO Auto-generated method stub
        return true;
    }
}