package net.fortressgames.fortressessentials.commands;

import net.fortressgames.fortressapi.Lang;
import net.fortressgames.fortressapi.commands.CommandBase;
import net.fortressgames.fortressapi.players.PlayerModule;
import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ListCommand extends CommandBase {

	public ListCommand() {
		super("list", EssentialPermissionsLang.LIST);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		sender.sendMessage(Lang.LINE);
		sender.sendMessage(ChatColor.YELLOW + ChatColor.BOLD.toString() + "Online players: " + ChatColor.GRAY + "(There are " +
				PlayerModule.getInstance().getOnlinePlayers().size() + " of " + Bukkit.getMaxPlayers() + " players online)");

		List<String> players = new ArrayList<>();
		for(Player pp : PlayerModule.getInstance().getOnlinePlayers()) {
			players.add(pp.getName());
		}

		sender.sendMessage(players.toString()
				.replace(",", ChatColor.BLUE + "," + ChatColor.WHITE)
				.replace("[", ChatColor.GRAY + "[" + ChatColor.WHITE)
				.replace("]", ChatColor.GRAY + "]" + ChatColor.WHITE)
		);
		sender.sendMessage(Lang.LINE);
	}
}
