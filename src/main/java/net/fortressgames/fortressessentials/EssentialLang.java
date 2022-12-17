package net.fortressgames.fortressessentials;

import net.fortressgames.fortressapi.Lang;
import org.bukkit.ChatColor;
import org.bukkit.World;

public class EssentialLang {

	public static final String NO_SELECTOR = Lang.RED + "Unknown selector!";

	public static final String ME_USAGE = Lang.BLUE + "Usage: /me [message]";
	public static final String DIFFICULTY_USAGE = Lang.BLUE + "Usage: /difficulty <difficulty>";
	public static final String GAMEMODE_USAGE = Lang.BLUE + "Usage: /gamemode <type>";
	public static final String WEATHER_USAGE = Lang.BLUE + "Usage: /weather <clear | rain | thunder>";
	public static final String TIME_USAGE = Lang.BLUE + "Usage: /time <add | query | set | day | night>";
	public static final String SAY_USAGE = Lang.BLUE + "Usage: /say [message]";

	public static final String UNKNOWN_GAMEMODE = Lang.RED + "Unknown gamemode!";
	public static final String GAMEMODE_UPDATE = Lang.GREEN + "Your gamemode has been updated!";
	public static final String CLEAR_INV = Lang.GREEN + "Inventory cleared!";
	public static final String CLEAR_INV_ADMIN = Lang.GREEN + "Your inventory has been cleared by an admin!";
	public static final String DIFFICULTY_UNKNOWN = Lang.RED + "Unknown difficulty!";
	public static final String DIFFICULTY_SET = Lang.GREEN + "Difficulty changed!";
	public static final String DIFFICULTY_SET_ALL = Lang.GREEN + "Difficulty changed in all worlds!";
	public static final String TIME_VALUE_ERROR = Lang.RED + "Unknown time!";
	public static final String DROP_ITEMS = Lang.RED + "You cannot drop items!";
	public static final String SPAWN_TP = Lang.GREEN + "Teleporting to spawn!";

	public static String whitelistQuery(String value) {
		return Lang.GREEN + "Whitelist is: " + ChatColor.WHITE + value;
	}
	public static final String WHITE_LIST_ON = Lang.GREEN + "Whitelist on!";
	public static final String WHITE_LIST_OFF = Lang.GREEN + "Whitelist off!";
	public static final String WHITE_LIST_ADD = Lang.GREEN + "Player has been added to the whitelist!";
	public static final String WHITE_LIST_REMOVE = Lang.GREEN + "Player has been removed from the whitelist!";

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
	public static String say(String player, String message) {
		return ChatColor.WHITE + "[" + player + "] " + message;
	}
	public static String difficulty(String difficulty) {
		return Lang.GREEN + "Difficulty: " + ChatColor.WHITE + difficulty;
	}
	public static String updatedGamemode(String target) {
		return Lang.GREEN + "You updated " + target + " gamemode!";
	}
	public static String updateWeather(String type) {
		return Lang.GREEN + "Weather updated to " + type + "!";
	}
	public static String updateTime(String type) {
		return Lang.GREEN + "Time updated to " + type + "!";
	}
	public static String time(World world) {
		return Lang.GREEN + "The time is " + world.getTime() + "!";
	}
}