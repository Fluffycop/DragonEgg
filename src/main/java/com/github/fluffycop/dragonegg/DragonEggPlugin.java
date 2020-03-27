package com.github.fluffycop.dragonegg;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class DragonEggPlugin extends JavaPlugin {
    Config cfg;
    DragonListener listener;

    @Override
    public void onEnable() {
        setupConfig();

        if(!cfg.enabled) {
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        setupListener();
    }

    private void setupConfig() {
        cfg = new Config(this);
        cfg.setup();
        cfg.load();
    }

    private void setupListener() {
        Bukkit.getPluginManager().registerEvents(listener = new DragonListener(this), this);
    }

    public Config getCfg() {
        return cfg;
    }

    public DragonListener getListener() {
        return listener;
    }
}
