package com.matmatt.xpstorage;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

/*Blocks players from breaking the XP signs of others.*/
public class BlockSignDestruction implements Listener {

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {

        Block block = event.getBlock();

        if (block.getType() == Material.BIRCH_WALL_SIGN || block.getType() == Material.BIRCH_SIGN) {
            Sign sign = (Sign) block.getState();
            String line0 = sign.getLine(0);
            if (line0.toLowerCase().equalsIgnoreCase(StringResources.XP_STORAGE)) {
                Player player = event.getPlayer();
                //Block breaking if the sign is owned by someone else and has xp on it
                if (!sign.getLine(1).equals(StringResources.playerBrackets(player.getPlayerListName())) && !sign.getLine(2).equals("")) {
                    player.sendMessage(StringResources.NO_BREAK_OTHERS_SIGNS);
                    event.setCancelled(true);
                }
            }
        }

    }

}
