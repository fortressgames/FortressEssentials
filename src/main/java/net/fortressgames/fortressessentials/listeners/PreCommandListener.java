package net.fortressgames.fortressessentials.listeners;

import net.fortressgames.fortressapi.Lang;
import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import net.fortressgames.fortressessentials.FortressEssentials;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PreCommandListener implements Listener {

	@EventHandler
	public void command(PlayerCommandPreprocessEvent e) {
		String[] cmd = e.getMessage()
				.replace("minecraft:", "")
				.replace("bukkit:", "")
				.replace("/", "")
				.toLowerCase().split(" ");

		Player player = e.getPlayer();

		if(cmd[0].equalsIgnoreCase("pl") || cmd[0].equalsIgnoreCase("plugins")) {
			e.setCancelled(true);
			player.performCommand("plugin");
			return;
		}

		if(!player.hasPermission(EssentialPermissionsLang.PROTECT_COMMAND_STOP)) {

			if(FortressEssentials.getInstance().getConfig().getStringList("BlockedCommands").contains(cmd[0])) {
				e.setCancelled(true);
				player.sendMessage(Lang.NO_PERMISSION);
			}
		}
	}
}