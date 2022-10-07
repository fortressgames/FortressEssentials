package net.fortressgames.fortressessentials.commands;

import net.fortressgames.fortressapi.commands.CommandBase;
import net.fortressgames.fortressessentials.EssentialLang;
import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class DifficultyCommand extends CommandBase {

	public DifficultyCommand() {
		super("difficulty", EssentialPermissionsLang.DIFFICULTY);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		if(sender instanceof Player player) {

			if(args.length == 0) {
				sender.sendMessage(EssentialLang.difficulty(player.getWorld().getDifficulty().name()));
				return;
			}

			try {
				player.getWorld().setDifficulty(Difficulty.valueOf(args[0].toUpperCase()));
				player.sendMessage(EssentialLang.DIFFICULTY_SET);
				return;

			} catch (IllegalArgumentException e) {
				player.sendMessage(EssentialLang.DIFFICULTY_UNKNOWN);
				return;
			}
		}

		if(args.length == 0) {
			sender.sendMessage(EssentialLang.DIFFICULTY_USAGE);
			return;
		}

		try {
			Bukkit.getServer().getWorlds().forEach(world -> world.setDifficulty(Difficulty.valueOf(args[0].toUpperCase())));
			sender.sendMessage(EssentialLang.DIFFICULTY_SET_ALL);

		} catch (IllegalArgumentException e) {
			sender.sendMessage(EssentialLang.DIFFICULTY_UNKNOWN);
		}
	}

	@Override
	public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
		return Arrays.asList("peaceful", "easy", "normal", "hard");
	}
}