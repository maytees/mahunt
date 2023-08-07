package net.matees.manhunt.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.matees.manhunt.Game;
import net.matees.manhunt.Manhunt;
import net.matees.manhunt.items.TrackerCompass;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.w3c.dom.Text;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)  {
        Player player = event.getPlayer();
        ItemStack compass = TrackerCompass.newTrackerCompass();
        if (player.getInventory().contains(compass)) return;
        player.getInventory().addItem(compass);
        player.sendMessage(Component.text("You have been given a compass, type ", NamedTextColor.GREEN).append(Component.text("/track {name}", NamedTextColor.RED).append(Component.text(" to track a player.", NamedTextColor.GREEN))));
    }

}
