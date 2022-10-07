package net.fortressgames.fortressessentials.listeners.protect;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.LeavesDecayEvent;

public class LeaveDecayListener implements Listener {

	@EventHandler
	public void decay(LeavesDecayEvent e) {
		e.setCancelled(true);
	}
}