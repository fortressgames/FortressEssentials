package net.fortressgames.fortressessentials.listeners.protect;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockExplodeEvent;

public class BlockExplodeListener implements Listener {

	@EventHandler
	public void block(BlockExplodeEvent e) {
		e.setCancelled(true);
	}
}