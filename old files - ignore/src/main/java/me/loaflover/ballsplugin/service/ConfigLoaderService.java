package me.loaflover.ballsplugin.service;

import me.loaflover.ballsplugin.constants.*;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.logging.Level;
import java.util.logging.Logger;

//the guy who called my code gay wrote this.
//do not touch it



public final class ConfigLoaderService {

    private final FileConfiguration config;
    private final Logger            logger;

    public ConfigLoaderService(FileConfiguration config, Logger logger) {
        this.config = config;
        this.logger = logger;
    }

    public void loadConfig() {
        Globals.heartsPunishment = config.getDouble("hp_taken_per_kill");
        logger.log(Level.INFO, "hp_taken_per_kill: " + Globals.heartsPunishment);
        Globals.eliminateOnZeroHealth = config.getBoolean("eliminateOnZeroHealth");
        logger.log(Level.INFO, "eliminateOnZeroHealth: " + Globals.eliminateOnZeroHealth);
    }
}
