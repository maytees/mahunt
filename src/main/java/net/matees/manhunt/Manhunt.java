package net.matees.manhunt;

import me.kodysimpson.simpapi.command.CommandManager;
import net.matees.manhunt.commands.SetRunnerCommand;
import net.matees.manhunt.listeners.DeathListener;
import net.matees.manhunt.listeners.FireCompass;
import net.matees.manhunt.listeners.PickBlock;
import net.matees.manhunt.listeners.PlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Manhunt extends JavaPlugin {

    private static Manhunt plugin;
    private Game game;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        game = new Game();
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new FireCompass(), this);
        getServer().getPluginManager().registerEvents(new PickBlock(), this);
        getServer().getPluginManager().registerEvents(new DeathListener(), this);

        try {
            CommandManager.createCoreCommand(this, "manhunt", "Manhunt plugin", "/manhunt", null, SetRunnerCommand.class);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Manhunt getPlugin() {
        return plugin;
    }

    public Game getGame(){
       return this.game;
    }
}
