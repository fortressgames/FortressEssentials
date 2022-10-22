package net.fortressgames.fortressessentials.commands;

import net.fortressgames.fortressapi.commands.CommandBase;
import net.fortressgames.fortressapi.players.PlayerModule;
import net.fortressgames.fortressessentials.EssentialLang;
import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SayCommand extends CommandBase {

	public SayCommand() {
		super("say", EssentialPermissionsLang.SAY);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		if(args.length == 0) {
			sender.sendMessage(EssentialLang.SAY_USAGE);
			return;
		}

		StringBuilder message = new StringBuilder();
		for(int i = 0; i < args.length; i++) {

			if(i == args.length -1) {
				message.append(args[i]);
			} else {
				message.append(args[i]).append(" ");
			}
		}

		if(sender instanceof Player player) {
			PlayerModule.getInstance().getOnlinePlayers().forEach(target -> target.sendMessage(EssentialLang.say(player.getDisplayName(), message.toString())));

		} else {
			PlayerModule.getInstance().getOnlinePlayers().forEach(target -> target.sendMessage(EssentialLang.say("Console", message.toString())));
		}
	}
}