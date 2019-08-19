package com.matmatt.xpstorage;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/*Handles the left click of a player.
* In other words this class handles the reading + giving back of xp if a player left clicks with an emerald on a
* XPStorage sign, which is his own.*/
public class LeftClickSignEventListener implements Listener {

    @EventHandler
    public void onPlayerLeftClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();


        if (event.getAction() == Action.LEFT_CLICK_BLOCK && event.getClickedBlock() != null) {
            if (player.getInventory().getItemInMainHand().getType() == Material.EMERALD) {
                if (event.getClickedBlock().getType() == Material.BIRCH_WALL_SIGN
                        || event.getClickedBlock().getType() == Material.BIRCH_SIGN) {

                    Sign theSign = (Sign) event.getClickedBlock().getState();

                    if (theSign.getLine(0).toLowerCase().equalsIgnoreCase(StringResources.XP_STORAGE)) {
                        if (theSign.getLine(1).equals(StringResources.playerBrackets(player.getPlayerListName()))) {
                            try {
                                int storedXP = Integer.parseInt(theSign.getLine(2).trim());
                                player.giveExpLevels(storedXP);
                                theSign.setLine(2, "");
                                theSign.update(true);
                                player.sendMessage(StringResources.XP_BACK);
                            } catch (NumberFormatException e) {
                                if (!theSign.getLine(2).trim().equals(""))
                                    player.sendMessage(StringResources.NO_XP_BACK);
                            }
                        } else
                            player.sendMessage(StringResources.NOT_YOUR_XP);
                    }

                }
            }
        }
    }
}
