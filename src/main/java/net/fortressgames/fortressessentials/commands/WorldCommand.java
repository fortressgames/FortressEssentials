package net.fortressgames.fortressessentials.commands;

import net.fortressgames.fortressapi.Lang;
import net.fortressgames.fortressapi.commands.CommandBase;
import net.fortressgames.fortressessentials.EssentialLang;
import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class WorldCommand extends CommandBase {

	public WorldCommand() {
		super("world", EssentialPermissionsLang.WORLD);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		List<String> worlds = new ArrayList<>();
		Bukkit.getWorlds().forEach(world -> worlds.add(world.getName().toLowerCase()));

		if(args.length == 0) {
			sender.sendMessage(Lang.LINE);

			sender.sendMessage(Lang.BLUE + "Worlds: " + worlds);
			sender.sendMessage(Lang.LINE);
			return;
		}

		if(worlds.contains(args[0].toLowerCase()) && sender instanceof Player player) {
			player.teleport(new Location(Bukkit.getWorld(args[0]), 0.5, 25, 334.5, -180, 0));
			return;
		}

		sender.sendMessage(EssentialLang.UNKNOWN_WORLD);
	}
}