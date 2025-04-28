package de.project_minecraft.pluginManager;

import de.project_minecraft.pluginManager.commands.CommandPluginManager;
import de.project_minecraft.pluginManager.commands.PluginManagerTabCompleter;
import de.project_minecraft.pluginManager.utils.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public final class PluginManager extends JavaPlugin {

    private static PluginManager instance;

    @Override
    public void onEnable() {
        instance = this;
        boolean bStatsEnabled = getConfig().getBoolean("bstats-enabled", true);

        getCommand("pluginmanager").setExecutor(new CommandPluginManager(this));
        getCommand("pluginmanager").setTabCompleter(new PluginManagerTabCompleter(this));  // TabCompleter für /discord und Unterbefehle
        saveDefaultConfig();
        if (bStatsEnabled) {
            // bStats initialisieren, falls die Einstellung aktiviert ist
            int pluginId = 25657; // Ersetze dies mit deiner eigenen Plugin-ID von bStats
            Metrics metrics = new Metrics(this, pluginId);
        } else {
            // bStats deaktivieren (bei Bedarf, aber in den meisten Fällen wird das automatisch durch bStats gehandhabt)
            getLogger().warning("bStats wurde vom Nutzer deaktiviert.");
        }
        getLogger().info("Plugin aktiviert!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin Deaktiviert!");
    }
    public static PluginManager getInstance(){
        return instance;
    }
}
