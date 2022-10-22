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

public class DeopCommand extends CommandBase {

	public DeopCommand() {
		super("deop", EssentialPermissionsLang.OP);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		if(args.length == 0) {
			sender.sendMessage(EssentialLang.DE_OP_USAGE);
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

				target.setOp(false);

				if(target.isOnline()) {
					target.getPlayer().sendMessage(EssentialLang.DE_OPED);
				}

				PlayerModule.getInstance().getOnlinePlayers().forEach(pp -> {
					if(pp.isOp()) {
						pp.sendMessage(EssentialLang.deopedPlayer(profile.getName()));
					}
				});
			} else {
				sender.sendMessage(Lang.PLAYER_NOT_FOUND);
			}

		}, args[0]);
	}
}