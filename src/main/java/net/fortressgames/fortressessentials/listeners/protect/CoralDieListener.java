package net.fortressgames.fortressessentials.listeners.protect;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

public class CoralDieListener implements Listener {

	@EventHandler
	public void die(BlockFadeEvent e) {
		if(e.getBlock().getType().name().contains("CORAL")) {
			e.setCancelled(true);
		}
	}
}