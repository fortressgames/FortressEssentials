package net.fortressgames.fortressessentials.commands;

import net.fortressgames.fortressapi.Lang;
import net.fortressgames.fortressapi.commands.CommandBase;
import net.fortressgames.fortressapi.players.PlayerModule;
import net.fortressgames.fortressapi.utils.MojangAPIUtils;
import net.fortressgames.fortressessentials.EssentialLang;
import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class OpCommand extends CommandBase {

	public OpCommand() {
		super("op", EssentialPermissionsLang.OP);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		if(args.length == 0) {
			sender.sendMessage(EssentialLang.OP_USAGE);
			return;
		}

		MojangAPIUtils.getUUID((successful, result, exception) -> {

			if(successful) {
				if(result.isEmpty()) {
					sender.sendMessage(Lang.PLAYER_NOT_FOUND);
					return;
				}

				MojangAPIUtils.Profile profile = new ArrayList<>(result.values()).get(0);
				OfflinePlayer target = Bukkit.getOfflinePlayer(profile.uuid());

				if(target.isOp()) {
					sender.sendMessage(EssentialLang.ALREADY_OP);
					return;
				}

				target.setOp(true);

				if(target.isOnline()) {
					target.getPlayer().sendMessage(EssentialLang.OPED);
				}

				PlayerModule.getInstance().getOnlinePlayers().forEach(pp -> {
					if(pp.isOp()) {
						pp.sendMessage(EssentialLang.opedPlayer(profile.getName()));
					}
				});

			} else {
				sender.sendMessage(Lang.PLAYER_NOT_FOUND);
			}

		}, args[0]);
	}
}