package net.fortressgames.fortressessentials.commands;

import net.fortressgames.fortressapi.Lang;
import net.fortressgames.fortressapi.commands.CommandBase;
import net.fortressgames.fortressapi.utils.MojangAPIUtils;
import net.fortressgames.fortressessentials.EssentialLang;
import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WhitelistCommand extends CommandBase {

	public WhitelistCommand() {
		super("whitelist", EssentialPermissionsLang.WHITE_LIST);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		if(args.length == 0) {
			list(sender);
			return;
		}

		if(args[0].equalsIgnoreCase("clear")) {
			Bukkit.getWhitelistedPlayers().forEach(offlinePlayer -> offlinePlayer.setWhitelisted(false));
			return;
		}

		if(args[0].equalsIgnoreCase("on")) {
			Bukkit.setWhitelist(true);
			sender.sendMessage(EssentialLang.WHITE_LIST_ON);
			return;
		}

		if(args[0].equalsIgnoreCase("off")) {
			Bukkit.setWhitelist(false);
			sender.sendMessage(EssentialLang.WHITE_LIST_OFF);
			return;
		}

		if(args[0].equalsIgnoreCase("list")) {
			list(sender);
			return;
		}

		if(args[0].equalsIgnoreCase("query")) {
			if(Bukkit.hasWhitelist()) {
				sender.sendMessage(EssentialLang.whitelistQuery("ON"));
			} else {
				sender.sendMessage(EssentialLang.whitelistQuery("OFF"));
			}
			return;
		}

		if(args.length == 2) {
			MojangAPIUtils.getUUID((successful, result, exception) -> {

				if(result.isEmpty()) {
					sender.sendMessage(Lang.PLAYER_NOT_FOUND);
					return;
				}

				MojangAPIUtils.Profile profile = new ArrayList<>(result.values()).get(0);
				OfflinePlayer target = Bukkit.getOfflinePlayer(profile.uuid());

				if(args[0].equalsIgnoreCase("add")) {
					target.setWhitelisted(true);
					sender.sendMessage(EssentialLang.WHITE_LIST_ADD);
					return;
				}

				if(args[0].equalsIgnoreCase("remove")) {
					target.setWhitelisted(false);
					sender.sendMessage(EssentialLang.WHITE_LIST_REMOVE);
				}

			}, args[1]);
		}
	}

	private void list(CommandSender sender) {
		sender.sendMessage(Lang.LINE);
		sender.sendMessage(ChatColor.YELLOW + ChatColor.BOLD.toString() + "Whitelist: " + ChatColor.GRAY + "(" + Bukkit.getWhitelistedPlayers().size() + ")");

		List<String> players = new ArrayList<>();
		for(OfflinePlayer pp : Bukkit.getWhitelistedPlayers()) {
			players.add(pp.getName());
		}

		sender.sendMessage(players.toString()
				.replace(",", ChatColor.BLUE + "," + ChatColor.WHITE)
				.replace("[", ChatColor.GRAY + "[" + ChatColor.WHITE)
				.replace("]", ChatColor.GRAY + "]" + ChatColor.WHITE)
		);
		sender.sendMessage(Lang.LINE);
	}

	@Override
	public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
		if(args.length == 1) {
			return Arrays.asList("add", "remove", "on", "off", "list", "clear", "query");
		}

		return super.tabComplete(sender, alias, args);
	}
}