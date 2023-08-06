package net.matees.manhunt;

import net.matees.manhunt.runnables.SetCompass;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class Game {

    public Player speedrunner;
    public List<Player> hunters;

    public Game() {
    }

    public Player getSpeedrunner() {
        return speedrunner;
    }

    public void setSpeedrunner(Player speedrunner) {
        this.speedrunner = speedrunner;

        new SetCompass().runTaskTimer(Manhunt.getPlugin(), 0L, 2L);
    }

    public List<Player> getHunters() {
        return hunters;
    }

    public void addHunter(Player hunter) {
        this.hunters.add(hunter);
    }
}
