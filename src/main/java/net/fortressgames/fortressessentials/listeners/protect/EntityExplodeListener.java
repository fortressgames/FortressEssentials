package net.fortressgames.fortressessentials.listeners.protect;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class EntityExplodeListener implements Listener {

	@EventHandler
	public void tnt(EntityExplodeEvent e) {
		e.setCancelled(true);
	}
}