package net.fortressgames.fortressessentials.commands;

import net.fortressgames.fortressapi.Lang;
import net.fortressgames.fortressapi.commands.CommandBase;
import net.fortressgames.fortressessentials.EssentialLang;
import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class GameModeCommand extends CommandBase {

	public GameModeCommand() {
		super("gamemode", EssentialPermissionsLang.GAMEMODE, "gm");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		if(args.length == 0) {
			sender.sendMessage(EssentialLang.GAMEMODE_USAGE);
			return;
		}

		GameMode gameMode = null;

		switch (args[0].toUpperCase()) {
			case "SURVIVAL", "S"-> gameMode = GameMode.SURVIVAL;
			case "CREATIVE", "C"-> gameMode = GameMode.CREATIVE;
			case "ADVENTURE", "A"-> gameMode = GameMode.ADVENTURE;
			case "SPECTATOR", "SPE"-> gameMode = GameMode.SPECTATOR;
		}

		if(gameMode == null) {
			sender.sendMessage(EssentialLang.UNKNOWN_GAMEMODE);
			return;
		}

		if(args.length == 1 && sender instanceof Player player) {
			player.setGameMode(gameMode);
			player.sendMessage(EssentialLang.GAMEMODE_UPDATE);
			return;
		}

		Player target = Bukkit.getPlayer(args[1]);

		if(target == null) {
			sender.sendMessage(Lang.PLAYER_NOT_FOUND);
			return;
		}

		target.setGameMode(gameMode);
		target.sendMessage(EssentialLang.GAMEMODE_UPDATE);
		sender.sendMessage(EssentialLang.updatedGamemode(target.getName()));
	}

	@Override
	public @NotNull List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, String[] args) {
		return Arrays.asList("survival", "creative", "adventure", "spectator", "s", "c", "a", "spe");
	}
}