package net.fortressgames.fortressessentials.commands;

import net.fortressgames.fortressapi.Lang;
import net.fortressgames.fortressapi.commands.CommandBase;
import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class PluginCommand extends CommandBase {

	public PluginCommand() {
		super("plugin", EssentialPermissionsLang.PLUGIN);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		sender.sendMessage(Lang.LINE);
		sender.sendMessage(ChatColor.YELLOW + ChatColor.BOLD.toString() + "Plugins: " + ChatColor.GRAY + "(" + Bukkit.getPluginManager().getPlugins().length + ")");

		List<String> plugins = new ArrayList<>();
		for(Plugin pl : Bukkit.getPluginManager().getPlugins()) {
			plugins.add(pl.getName());
		}

		sender.sendMessage(plugins.toString()
				.replace(",", ChatColor.BLUE + "," + ChatColor.WHITE)
				.replace("[", ChatColor.GRAY + "[" + ChatColor.WHITE)
				.replace("]", ChatColor.GRAY + "]" + ChatColor.WHITE)
		);
		sender.sendMessage(Lang.LINE);
	}
}