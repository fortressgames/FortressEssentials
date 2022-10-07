package net.fortressgames.fortressessentials.commands;

import net.fortressgames.fortressapi.Lang;
import net.fortressgames.fortressapi.commands.CommandBase;
import net.fortressgames.fortressapi.players.FortressPlayerModule;
import net.fortressgames.fortressessentials.EssentialLang;
import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import net.fortressgames.fortressessentials.utils.TargetSelection;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ClearCommand extends CommandBase {

	public ClearCommand() {
		super("clear", EssentialPermissionsLang.CLEAR, "ci");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		if(sender instanceof Player player) {

			if(args.length == 0) {
				player.getInventory().clear();
				player.sendMessage(EssentialLang.CLEAR_INV);
				return;
			}
		}

		if(sender.hasPermission(EssentialPermissionsLang.CLEAR_OTHER)) {

			List<Entity> targets = TargetSelection.getTargets(args[0], sender);

			if(targets.isEmpty()) {
				sender.sendMessage(EssentialLang.NO_SELECTOR);
				return;
			}

			targets.forEach(entity -> {

				if(entity instanceof Player) {

					((Player)entity).getInventory().clear();
					entity.sendMessage(EssentialLang.CLEAR_INV_ADMIN);

					sender.sendMessage(EssentialLang.clearOther(entity.getName()));
				}
			});

		} else {
			sender.sendMessage(Lang.NO_PERMISSION);
		}
	}

	@Override
	public List<String> tabComplete(CommandSender sender, String alias, String[] args) {

		if(args.length == 1) {
			return new ArrayList<>() {
				{
					add("@a");
					add("@e");
					add("@p");
					add("@r");
					add("@s");

					FortressPlayerModule.getInstance().getOnlinePlayers().forEach(player -> add(player.getName()));
				}
			};
		}

		return super.tabComplete(sender, alias, args);
	}
}