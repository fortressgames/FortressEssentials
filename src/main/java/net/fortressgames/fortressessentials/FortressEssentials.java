package net.fortressgames.fortressessentials;

import lombok.Getter;
import net.fortressgames.fortressapi.commands.CommandModule;
import net.fortressgames.fortressapi.utils.ConsoleMessage;
import net.fortressgames.fortressessentials.commands.*;
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
		CommandModule.registerCommand(new ClearCommand());
		CommandModule.registerCommand(new OpCommand());
		CommandModule.registerCommand(new DeopCommand());
		CommandModule.registerCommand(new DifficultyCommand());

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

//todo bugs
// op offline

//todo
// gamemode, gm, gmc, gms, gma, gmsp
// list
// say ??
// time
// weather
// whitelist

//todo
// kit
// gamesetting (protection rules, use block rules)
// spawn (with cancelable event)

//todo maybe some sort of custom command to teleport to location with cancelable events (would be used for /mine and /market)

