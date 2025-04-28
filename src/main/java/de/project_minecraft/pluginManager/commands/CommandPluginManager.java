package de.project_minecraft.pluginManager.commands;

import de.project_minecraft.pluginManager.PluginManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CommandPluginManager implements CommandExecutor {
    private final PluginManager plugin;
    public CommandPluginManager(PluginManager plugin){this.plugin = plugin;}

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {


        // Unterbefehl "reload"
        if (args[0].equalsIgnoreCase("reload")) {
            return new CommandReload(plugin).onCommand(sender, command, label, args);
        }
        if (args[0].equalsIgnoreCase("edit")) {
            return new CommandStop(plugin).onCommand(sender, command, label, args);
        }
        if (args[0].equalsIgnoreCase("help")) {
            return new CommandHelp(plugin).onCommand(sender, command, label, args);
        }
        return true;
    }
}
