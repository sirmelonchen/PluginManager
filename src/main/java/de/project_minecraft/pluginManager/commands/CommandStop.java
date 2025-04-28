package de.project_minecraft.pluginManager.commands;

import de.project_minecraft.pluginManager.PluginManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class CommandStop implements CommandExecutor {
    private final PluginManager plugin;
    public CommandStop(PluginManager plugin){this.plugin = plugin;}

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {

        return true;
    }
}
