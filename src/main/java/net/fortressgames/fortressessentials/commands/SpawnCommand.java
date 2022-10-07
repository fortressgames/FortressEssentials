package net.fortressgames.fortressessentials.commands;

import net.fortressgames.fortressapi.commands.CommandBase;
import net.fortressgames.fortressessentials.EssentialLang;
import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import net.fortressgames.fortressessentials.FortressEssentials;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SpawnCommand extends CommandBase {

	public SpawnCommand() {
		super("spawn", EssentialPermissionsLang.SPAWN);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		if(sender instanceof Player player) {

			FileConfiguration config = FortressEssentials.getInstance().getConfig();

			player.teleport(new Location(
					Bukkit.getWorld(config.getString("Spawn.World")),
					config.getDouble("Spawn.X"),
					config.getDouble("Spawn.Y"),
					config.getDouble("Spawn.Z"),
					config.getInt("Spawn.Yaw"),
					config.getInt("Spawn.Pitch")));
			player.sendMessage(EssentialLang.SPAWN_TP);
		}
	}
}