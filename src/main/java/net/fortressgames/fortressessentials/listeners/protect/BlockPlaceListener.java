package net.fortressgames.fortressessentials.listeners.protect;

import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

	@EventHandler
	public void placeEvent(BlockPlaceEvent e) {
		Player player = e.getPlayer();

		if(!player.hasPermission(EssentialPermissionsLang.PROTECT_BLOCK_PLACE)) {
			e.setCancelled(true);
		}
	}
}