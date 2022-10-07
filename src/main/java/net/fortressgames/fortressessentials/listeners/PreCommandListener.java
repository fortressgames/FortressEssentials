package net.fortressgames.fortressessentials.listeners;

import net.fortressgames.fortressapi.Lang;
import net.fortressgames.fortressapi.players.FortressPlayer;
import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import net.fortressgames.fortressessentials.FortressEssentials;
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

		FortressPlayer fortressPlayer = FortressPlayer.getPlayer(e.getPlayer());

		if(cmd[0].equalsIgnoreCase("pl") || cmd[0].equalsIgnoreCase("plugins")) {
			e.setCancelled(true);
			fortressPlayer.getPlayer().performCommand("plugin");
			return;
		}

		if(!fortressPlayer.getPlayer().hasPermission(EssentialPermissionsLang.PROTECT_COMMAND_STOP)) {

			if(FortressEssentials.getInstance().getConfig().getStringList("BlockedCommands").contains(cmd[0])) {
				e.setCancelled(true);
				fortressPlayer.sendMessage(Lang.NO_PERMISSION);
			}
		}
	}
}