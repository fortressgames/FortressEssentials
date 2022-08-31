package net.fortressgames.fortressessentials;

import lombok.Getter;
import net.fortressgames.fortressapi.commands.CommandModule;
import net.fortressgames.fortressapi.utils.ConsoleMessage;
import net.fortressgames.fortressessentials.commands.MeCommand;
import net.fortressgames.fortressessentials.commands.SeedCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class FortressEssentials extends JavaPlugin {

	@Getter private static FortressEssentials instance;

	/**
	 * Called when plugin first loads by spigot and is called before onEnable
	 */
	@Override
	public void onLoad() {
		if(!getDataFolder().exists()) {
			getDataFolder().mkdir();
		}
	}

	/**
	 * Called when the plugin is first loaded by Spigot
	 */
	@Override
	public void onEnable() {
		instance = this;

		// Commands
		CommandModule.registerCommand(new SeedCommand());
		CommandModule.registerCommand(new MeCommand());

		getLogger().info(ConsoleMessage.GREEN + "Version: " + getDescription().getVersion() + " Enabled!" + ConsoleMessage.RESET);
	}

	/**
	 * Called when the server is restarted or stopped
	 */
	@Override
	public void onDisable() {
		getLogger().info(ConsoleMessage.RED + "Version: " + getDescription().getVersion() + " Disabled!" + ConsoleMessage.RESET);
	}
}

//todo
// clear, ic
// deop, op
// difficulty
// gamemode, gm, gmc, gms, gma, gmsp
// kill
// list
// say
// time
// weather
// whitelist

//todo
// kit
// gamesetting (protection rules, use block rules)
// spawn (with cancelable event)

//todo maybe some sort of custom command to teleport to location with cancelable events (would be used for /mine and /market)

