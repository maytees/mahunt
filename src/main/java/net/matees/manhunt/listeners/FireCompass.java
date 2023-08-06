package net.matees.manhunt.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.matees.manhunt.Manhunt;
import net.matees.manhunt.items.TrackerCompass;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class FireCompass implements Listener {
    private Map<Player, Long> cooldowns = new HashMap<>();
    private long cooldownDuration = 5000;

    @EventHandler
    public void compassFire(PlayerInteractEvent event) {
        Player player = event.getPlayer();


        Action action = event.getAction();
        ItemStack compass = TrackerCompass.newTrackerCompass();

        if(((action == Action.RIGHT_CLICK_AIR) || (action == Action.RIGHT_CLICK_BLOCK)) && event.getItem().isSimilar(compass)) {
            if(isOnCooldown(player)) {

                long currentTime = System.currentTimeMillis();
                long lastUseTime = cooldowns.get(player);

                long time = Math.round(currentTime - lastUseTime);

                player.sendMessage(Component.text("You are on cooldown: " + time/1000  + "/5 seconds", NamedTextColor.RED));
                return;
            }

            Player tracked = Manhunt.getPlugin().getGame().speedrunner;
            player.setCompassTarget(tracked.getLocation());

            if(!tracked.getWorld().getEnvironment().name().equals(player.getWorld().getEnvironment().name())) {
                player.sendMessage(Component.text("Player is not in your dimension!", NamedTextColor.LIGHT_PURPLE));
            }

            player.sendMessage(Component.text(tracked.getDisplayName(), NamedTextColor.AQUA).append(Component.text(" is " + Math.round(player.getLocation().distance(tracked.getLocation())) + "m away.", NamedTextColor.YELLOW)));
            startCooldown(player);
        }
    }

    public boolean isOnCooldown(Player player) {
        if(!cooldowns.containsKey(player))
            return false;

        long currentTime = System.currentTimeMillis();
        long lastUseTime = cooldowns.get(player);

        return currentTime - lastUseTime < cooldownDuration;
    }

    public void startCooldown(Player player) {
        cooldowns.put(player, System.currentTimeMillis());
        new BukkitRunnable() {
            @Override
            public void run() {
                cooldowns.remove(player);
            }
        }.runTaskLater(Manhunt.getPlugin(), cooldownDuration / 50); // Convert to ticks
    }
}
