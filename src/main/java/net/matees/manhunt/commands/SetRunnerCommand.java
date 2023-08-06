package net.matees.manhunt.commands;

import me.kodysimpson.simpapi.command.SubCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.matees.manhunt.Manhunt;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class SetRunnerCommand extends SubCommand {

    @Override
    public String getName() {
        return "setrunner";
    }

    @Override
    public List<String> getAliases() {
        return null;
    }

    @Override
    public String getDescription() {
        return "Set the speedrunner for the manhunt";
    }

    @Override
    public String getSyntax() {
        return "/manhunt setrunner {player}";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if(sender instanceof Player player) {
            if(args.length != 2) {
                player.sendMessage(Component.text("Please provide someone to set!", NamedTextColor.RED));
            } else {
                Player target = Bukkit.getServer().getPlayerExact(args[1]);
                if(target == null) {
                    player.sendMessage(Component.text("Player is not online! (or does not exist)", NamedTextColor.RED));
                }

                Manhunt.getPlugin().getGame().setSpeedrunner(target);

                player.sendMessage(Component.text(target.getDisplayName(), NamedTextColor.GREEN).append(Component.text(" is now the runner!", NamedTextColor.AQUA)));
            }
        }
    }

    @Override
    public List<String> getSubcommandArguments(Player player, String[] strings) {
        return null;
    }
}
