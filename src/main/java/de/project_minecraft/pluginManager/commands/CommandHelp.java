package de.project_minecraft.pluginManager.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class CommandHelp implements CommandExecutor {
    private final JavaPlugin plugin;
    public CommandHelp(JavaPlugin plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        Player player = (Player) sender;
        String version = plugin.getPluginMeta().getVersion();
        String website = "https://github.com/sirmelonchen/PluginManager";

        assert website != null;
        TextComponent message = Component.text("=== ")
                .color(TextColor.color(0xFFD700)) // Gold
                .append(Component.text("Plugin Manager")
                        .color(TextColor.color(0xFFFF00))) // Gelb
                .append(Component.text(" ===\n"))
                .append(Component.text("Version: ")
                        .color(TextColor.color(0x808080))) // Grau
                .append(Component.text(version)
                        .color(TextColor.color(0xFFFFFF))) // Weiß
                .append(Component.text("\n"))
                .append(Component.text("Autor: ")
                        .color(TextColor.color(0x808080))) // Grau
                .append(Component.text("sir_melonchen")
                        .color(TextColor.color(0xFFFFFF))) // Weiß
                .append(Component.text("\n\n"))
                .append(Component.text("Befehle:\n")
                        .color(TextColor.color(0xFFFF00))) // Gelb
                .append(Component.text("/pluginmanager reload")
                        .color(TextColor.color(0x00FFFF))) // Aqua
                .append(Component.text(" - Lädt ein Plugin neu")
                        .color(TextColor.color(0x808080))) // Grau
                .append(Component.text("\n"))
                .append(Component.text("/discord set <key> <value>")
                        .color(TextColor.color(0x00FFFF))) // Aqua
                .append(Component.text(" - Setzt die Config")
                        .color(TextColor.color(0x808080))) // Grau
                .append(Component.text("\n"))
                .append(Component.text("/discord help")
                        .color(TextColor.color(0x00FFFF))) // Aqua
                .append(Component.text(" - Zeigt diese Hilfe an")
                        .color(TextColor.color(0x808080))) // Grau
                .append(Component.text("\n\n"))
                .append(Component.text("Weitere Infos:\n")
                        .color(TextColor.color(0xFFFF00))) // Gelb
                .append(Component.text("Website: ")
                        .color(TextColor.color(0x808080))) // Grau
                .append(Component.text(website)
                        .hoverEvent(HoverEvent.showText(Component.text("Klicke hier für die Website!")
                                .color(NamedTextColor.DARK_RED)
                                .decorate(TextDecoration.BOLD)))
                        .clickEvent(ClickEvent.openUrl(website))
                        .color(TextColor.color(0x00FFFF))); // Aqua
        player.sendMessage(message);

        return true;
    }
}
