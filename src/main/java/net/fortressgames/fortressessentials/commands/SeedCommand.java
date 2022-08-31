package net.fortressgames.fortressessentials.commands;

import net.fortressgames.fortressapi.Lang;
import net.fortressgames.fortressapi.commands.CommandBase;
import net.fortressgames.fortressessentials.EssentialLang;
import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SeedCommand extends CommandBase {

	public SeedCommand() {
		super("seed", EssentialPermissionsLang.SEED);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		if(sender instanceof Player player) {
			sender.sendMessage(EssentialLang.seed(player.getWorld().getSeed()));

		} else {
			sender.sendMessage(Lang.PLAYERS_ONLY);
		}
	}
}