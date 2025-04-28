package de.project_minecraft.pluginManager.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
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
    public CommandReload(JavaPlugin plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, @NotNull Command command, @NotNull String label, String @NotNull [] args) {
        String pluginName = args[1];
        Plugin plugin = Bukkit.getPluginManager().getPlugin(pluginName);
        if (plugin != null) {
            File pluginFile = new File("plugins", pluginName + ".jar");

            if (pluginFile.exists()) {
                Bukkit.getPluginManager().disablePlugin(plugin);
                try {
                    // Plugin neu laden
                    Plugin reloadedPlugin = Bukkit.getPluginManager().loadPlugin(pluginFile);
                    Bukkit.getPluginManager().enablePlugin(reloadedPlugin);
                } catch (InvalidPluginException | InvalidDescriptionException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
