package net.fortressgames.fortressessentials.commands;

import net.fortressgames.fortressapi.Lang;
import net.fortressgames.fortressapi.commands.CommandBase;
import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class OpListCommand extends CommandBase {

	public OpListCommand() {
		super("oplist", EssentialPermissionsLang.OP);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		sender.sendMessage(Lang.LINE);
		sender.sendMessage(ChatColor.YELLOW + ChatColor.BOLD.toString() + "Op's:");

		List<String> ops = new ArrayList<>();
		for(OfflinePlayer operator : Bukkit.getOperators()) {
			ops.add(operator.getName());
		}

		sender.sendMessage(ops.toString()
				.replace(",", ChatColor.BLUE + "," + ChatColor.WHITE)
				.replace("[", ChatColor.GRAY + "[" + ChatColor.WHITE)
				.replace("]", ChatColor.GRAY + "]" + ChatColor.WHITE)
		);
		sender.sendMessage(Lang.LINE);
	}
}