package com.matmatt.xpstorage;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

/*Blocks players from manually creating birch signs with XP.
In other words: No cheating the system.*/
public class BlockManualXPSign implements Listener {

    @EventHandler
    public void onSignChangedEvent(SignChangeEvent event) {
        Material signMaterial = event.getBlock().getType();
        if (signMaterial == Material.BIRCH_SIGN || signMaterial == Material.BIRCH_WALL_SIGN) {
            String line0 = event.getLine(0);
            if (line0 != null) {
                if (line0.toLowerCase().equalsIgnoreCase(StringResources.XP_STORAGE)) {
                    event.getPlayer().sendMessage(StringResources.NO_MANUAL_CREATION);
                    event.setCancelled(true);
                }

            }

        }


    }
}
