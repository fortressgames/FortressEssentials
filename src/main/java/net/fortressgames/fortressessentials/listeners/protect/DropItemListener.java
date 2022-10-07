package net.fortressgames.fortressessentials.listeners.protect;

import net.fortressgames.fortressessentials.EssentialLang;
import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropItemListener implements Listener {

	@EventHandler
	public void dropItems(PlayerDropItemEvent e) {
		Player player = e.getPlayer();

		if(!player.hasPermission(EssentialPermissionsLang.PROTECT_DROP_ITEM)) {
			e.setCancelled(true);
			player.sendMessage(EssentialLang.DROP_ITEMS);
		}
	}
}