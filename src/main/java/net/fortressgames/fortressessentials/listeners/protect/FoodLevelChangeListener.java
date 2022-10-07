package net.fortressgames.fortressessentials.listeners.protect;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChangeListener implements Listener {

	@EventHandler
	public void hunger(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}
}