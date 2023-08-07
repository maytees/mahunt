package net.matees.manhunt.listeners;

import net.matees.manhunt.Game;
import net.matees.manhunt.Manhunt;
import net.matees.manhunt.items.TrackerCompass;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class DeathListener implements Listener {
    @EventHandler
    public void deathListener(PlayerRespawnEvent event) {
        Game game = Manhunt.getPlugin().getGame();
        if(game.speedrunner.getDisplayName().equals(event.getPlayer().getDisplayName())) return;

        event.getPlayer().getInventory().addItem(TrackerCompass.newTrackerCompass());
    }
}
