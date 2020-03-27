package com.github.fluffycop.dragonegg;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EnderDragon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EnderDragonChangePhaseEvent;

public class DragonListener implements Listener {
    DragonEggPlugin pl;

    public DragonListener(DragonEggPlugin pl) {
        this.pl = pl;
    }

    @EventHandler
    public void onDragonDeath(EnderDragonChangePhaseEvent e) {
        if(e.getNewPhase() == EnderDragon.Phase.DYING) {
            EnderDragon dragon = e.getEntity();
            if(chanceOf(pl.getCfg().dropChance)) {
                Block egg = dragon.getWorld().getBlockAt(0, dragon.getLocation().getBlockY(), 0);
                egg.setType(Material.DRAGON_EGG);
                egg.getState().update();
            }
        }
    }

    private boolean chanceOf(double d) {
        return Math.random() < d;
    }
}
