package com.matmatt.xpstorage;

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

        System.out.println("BLOCK BREAK EVENT CALLED");

        if (block instanceof Sign) {
            Sign sign = (Sign) block.getState();
            String line0 = sign.getLine(0);
            if (line0.toLowerCase().equalsIgnoreCase(StringResources.XP_STORAGE)) {
                System.out.println("BLOCK BROKEN IS SIGN");
                Player player = event.getPlayer();
                if (!sign.getLine(1).equals(StringResources.playerBrackets(player.getPlayerListName()))) {
                    player.sendMessage(StringResources.NO_BREAK_OTHERS_SIGNS);
                    event.setCancelled(true);
                }
            }
        }

    }

}
