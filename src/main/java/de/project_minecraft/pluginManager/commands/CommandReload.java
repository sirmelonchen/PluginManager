package de.project_minecraft.pluginManager.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class CommandReload implements CommandExecutor {
    private final JavaPlugin plugin;
    public CommandReload(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length < 1) {
            sender.sendMessage(ChatColor.RED + "Please specify a plugin name.");
            return false;
        }

        String pluginName = args[0]; // args[0], nicht args[1]
        Plugin targetPlugin = Bukkit.getPluginManager().getPlugin(pluginName);

        if (targetPlugin == null) {
            sender.sendMessage(ChatColor.RED + "Plugin not found: " + pluginName);
            return true;
        }

        sender.sendMessage(ChatColor.YELLOW + "Disabling plugin: " + pluginName);
        Bukkit.getPluginManager().disablePlugin(targetPlugin);

        File pluginFile = new File("plugins", pluginName + ".jar");

        if (!pluginFile.exists()) {
            sender.sendMessage(ChatColor.RED + "Plugin file not found: " + pluginFile.getPath());
            return true;
        }

        try {
            Plugin reloadedPlugin = Bukkit.getPluginManager().loadPlugin(pluginFile);
            Bukkit.getPluginManager().enablePlugin(reloadedPlugin);
            sender.sendMessage(ChatColor.GREEN + "Plugin reloaded: " + pluginName);
        } catch (InvalidPluginException | InvalidDescriptionException e) {
            e.printStackTrace();
            sender.sendMessage(ChatColor.RED + "Failed to reload plugin: " + pluginName);
        }
        return true;
    }
}
