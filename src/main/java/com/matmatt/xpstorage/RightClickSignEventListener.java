package com.matmatt.xpstorage;

import org.bukkit.Material;

import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/*Handles creating the XPStorage sign or updating XPStorage signs.
* When a player right clicks with an emerald in his hand, all his XP levels will be transfered to the sig*/
public class RightClickSignEventListener implements Listener {

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getClickedBlock() != null) {
            if (player.getInventory().getItemInMainHand().getType() == Material.EMERALD) {
                if (event.getClickedBlock().getType() == Material.BIRCH_WALL_SIGN
                        || event.getClickedBlock().getType() == Material.BIRCH_SIGN) {

                    Sign theSign = (Sign) event.getClickedBlock().getState();

                    if (theSign.getLine(0).toLowerCase().equalsIgnoreCase((StringResources.XP_STORAGE))) {
                        if (theSign.getLine(1).equals(StringResources.playerBrackets(player.getDisplayName()))) {
                            int storedLevels = 0;
                            int playerLevels = player.getLevel();
                            if (playerLevels > 0) {
                                try {
                                    storedLevels = Integer.parseInt(theSign.getLine(2));

                                } catch (NumberFormatException ignored) {
                                }
                                theSign.setLine(2, String.valueOf(storedLevels + playerLevels));
                                theSign.update(true);
                                player.giveExpLevels(-playerLevels);
                                player.sendMessage(StringResources.XP_STORED);
                            } else
                                player.sendMessage(StringResources.MORE_XP_NEEDED);
                        } else
                            player.sendMessage(StringResources.NOT_YOUR_XP);
                    } else if (signIsEmpty(theSign)) {
                        int playerLevels = player.getLevel();
                        if (playerLevels > 0) {
                            theSign.setLine(0, StringResources.XP_STORAGE);
                            theSign.setLine(1, StringResources.playerBrackets(player.getDisplayName()));
                            theSign.setLine(2, String.valueOf(playerLevels));
                            theSign.update(true);
                            player.giveExpLevels(-player.getLevel());
                            player.sendMessage(StringResources.XP_STORED);
                        }
                        else
                            player.sendMessage(StringResources.MORE_XP_NEEDED);


                    }
                }
            }
        }



    }

    private boolean signIsEmpty(Sign sign) {
        for (String s : sign.getLines()) {
            if (!s.trim().equals(""))
                return false;
        }
        return true;
    }

}
