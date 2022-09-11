package net.fortressgames.fortressessentials;

import net.fortressgames.fortressapi.Lang;
import org.bukkit.ChatColor;

public class EssentialLang {

	public static final String NO_SELECTOR = Lang.RED + "Unknown selector!";

	public static final String ME_USAGE = Lang.BLUE + "Usage: /me [message]";
	public static final String OP_USAGE = Lang.BLUE + "usage: /op <player>";
	public static final String DE_OP_USAGE = Lang.BLUE + "usage: /deop <player>";
	public static final String DIFFICULTY = Lang.BLUE + "usage: /difficulty <difficulty>";

	public static final String CLEAR_INV = Lang.GREEN + "Inventory cleared!";
	public static final String CLEAR_INV_ADMIN = Lang.GREEN + "Your inventory has been cleared by an admin!";
	public static final String ALREADY_OP = Lang.RED + "Player is already a server operator!";
	public static final String OPED = Lang.YELLOW + "You have been made a server operator!";
	public static final String DE_OPED = Lang.YELLOW + "You are no longer a server operator!";
	public static final String DIFFICULTY_UNKNOWN = Lang.RED + "Unknown difficulty!";
	public static final String DIFFICULTY_SET = Lang.GREEN + "Difficulty changed!";
	public static final String DIFFICULTY_SET_ALL = Lang.GREEN + "Difficulty changed in all worlds!";

	public static String opedPlayer(String target) {
		return ChatColor.GRAY + "[" + target + " is now a server operator]";
	}
	public static String deopedPlayer(String target) {
		return ChatColor.GRAY + "[" + target + " is no longer a server operator]";
	}
	public static String clearOther(String target) {
		return Lang.YELLOW + "You cleared " + target + " inventory!";
	}
	public static String seed(long seed) {
		return Lang.GREEN + "Seed: " + ChatColor.WHITE + seed;
	}
	public static String me(String player, String message) {
		return Lang.GREEN + ChatColor.WHITE + "* " + player + " " + message;
	}
	public static String difficulty(String difficulty) {
		return Lang.GREEN + "Difficulty: " + ChatColor.WHITE + difficulty;
	}
}