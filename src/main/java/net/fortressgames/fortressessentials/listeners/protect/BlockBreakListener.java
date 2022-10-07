package net.fortressgames.fortressessentials.listeners.protect;

import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

	@EventHandler
	public void breakEvent(BlockBreakEvent e) {
		Player player = e.getPlayer();

		if(!player.hasPermission(EssentialPermissionsLang.PROTECT_BLOCK_BREAK)) {
			e.setCancelled(true);
		}
	}
}