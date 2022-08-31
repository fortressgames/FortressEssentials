package net.fortressgames.fortressessentials;

import net.fortressgames.fortressapi.Lang;
import org.bukkit.ChatColor;

public class EssentialLang {

	public static final String ME_USAGE = Lang.RED + "Usage: /me [message]";

	public static String seed(long seed) {
		return Lang.GREEN + "Seed: " + ChatColor.WHITE + seed;
	}
	public static String me(String player, String message) {
		return Lang.GREEN + ChatColor.WHITE + "* " + player + " " + message;
	}
}