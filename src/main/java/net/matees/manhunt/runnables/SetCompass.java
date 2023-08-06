package net.matees.manhunt.runnables;

import net.matees.manhunt.Manhunt;
import net.matees.manhunt.items.TrackerCompass;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class SetCompass extends BukkitRunnable {

    @Override
    public void run() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            Player target = Manhunt.getPlugin().getGame().getSpeedrunner();

            player.setCompassTarget(target.getLocation());
        }
    }
}
