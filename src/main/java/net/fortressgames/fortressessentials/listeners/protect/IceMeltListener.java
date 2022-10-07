package net.fortressgames.fortressessentials.listeners.protect;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

public class IceMeltListener implements Listener {

	@EventHandler
	public void ice(BlockFadeEvent e) {
		if (e.getBlock().getType() == Material.ICE || e.getBlock().getType() == Material.SNOW || e.getBlock().getType() == Material.SNOW_BLOCK) {
			e.setCancelled(true);
		}
	}
}