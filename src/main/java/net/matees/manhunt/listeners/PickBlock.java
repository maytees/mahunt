package net.matees.manhunt.listeners;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class PickBlock implements Listener {

    @EventHandler
    public void playerInteract(PlayerInteractEvent event) {
        if(!event.getPlayer().getDisplayName().equals("Matees")) return;

        Action action = event.getAction();
        if(action == Action.RIGHT_CLICK_BLOCK) {
            Block targetBlock = event.getClickedBlock();
            event.getPlayer().getInventory().addItem(new ItemStack(targetBlock.getType()));
        }
    }
}
