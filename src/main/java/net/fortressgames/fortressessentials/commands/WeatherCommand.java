package net.fortressgames.fortressessentials.commands;

import net.fortressgames.fortressapi.commands.CommandBase;
import net.fortressgames.fortressessentials.EssentialLang;
import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class WeatherCommand extends CommandBase {

	public WeatherCommand() {
		super("weather", EssentialPermissionsLang.WEATHER);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		if(sender instanceof Player player) {
			World world = player.getWorld();

			if(args.length == 0) {
				player.sendMessage(EssentialLang.WEATHER_USAGE);
				return;
			}

			switch (args[0].toLowerCase()) {
				case "clear" -> {
					world.setStorm(false);

					player.sendMessage(EssentialLang.updateWeather(args[0]));
				}
				case "rain" -> {
					world.setStorm(true);

					player.sendMessage(EssentialLang.updateWeather(args[0]));
				}
				case "thunder" -> {
					world.setStorm(true);
					world.setThundering(true);

					player.sendMessage(EssentialLang.updateWeather(args[0]));
				}
			}
		}
	}

	@Override
	public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
		return Arrays.asList("clear", "rain", "thunder");
	}
}