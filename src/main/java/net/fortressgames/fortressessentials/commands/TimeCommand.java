package net.fortressgames.fortressessentials.commands;

import net.fortressgames.fortressapi.commands.CommandBase;
import net.fortressgames.fortressessentials.EssentialLang;
import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class TimeCommand extends CommandBase {

	public TimeCommand() {
		super("time", EssentialPermissionsLang.TIME);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		if(sender instanceof Player player) {
			World world = player.getWorld();

			if(args.length == 0) {
				player.sendMessage(EssentialLang.TIME_USAGE);
				return;
			}

			long time = 0;
			if(args.length >= 2) {
				try {
					time = Long.parseLong(args[1]);
				} catch (IllegalArgumentException e) {
					player.sendMessage(EssentialLang.TIME_VALUE_ERROR);
					return;
				}
			}

			switch (args[0].toLowerCase()) {
				case "set" -> {
					world.setTime(time);

					player.sendMessage(EssentialLang.updateTime(String.valueOf(world.getTime())));
				}
				case "add" -> {
					world.setTime(world.getTime() + time);

					player.sendMessage(EssentialLang.updateTime(String.valueOf(world.getTime())));
				}
				case "query" -> player.sendMessage(EssentialLang.time(world));

				case "day" -> {
					world.setTime(1000);

					player.sendMessage(EssentialLang.updateTime(args[0]));
				}
				case "night" -> {
					world.setTime(18000);

					player.sendMessage(EssentialLang.updateTime(args[0]));
				}
			}
		}
	}

	@Override
	public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
		return Arrays.asList("set", "add", "query", "day", "night");
	}
}