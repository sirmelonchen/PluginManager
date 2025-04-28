package de.project_minecraft.pluginManager.commands;

import de.project_minecraft.pluginManager.PluginManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PluginManagerTabCompleter implements TabCompleter {
    private final PluginManager plugin;
    public  PluginManagerTabCompleter(PluginManager plugin){this.plugin = plugin;}

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        List<String> completions = new ArrayList<>();
        if (args.length == 1){
            if (sender.hasPermission("pluginmanager.use")){
                if ("reload".startsWith(args[0].toLowerCase())) {
                    completions.add("edit");
                }
                if ("stop".startsWith(args[0].toLowerCase())) {
                    completions.add("reload");
                }
                if ("help".startsWith(args[0].toLowerCase())) {
                    completions.add("help");
                }
            }
        }else if (args.length == 2 && args[0].equalsIgnoreCase("reload")) {
            Plugin[] plugins = Bukkit.getPluginManager().getPlugins();
            for (Plugin plugin : plugins) {
                String key = plugin.getName();
                if (key.toLowerCase().startsWith(args[1].toLowerCase())) {
                    completions.add(key);
                }
            }
        }

        return completions;
    }
}
