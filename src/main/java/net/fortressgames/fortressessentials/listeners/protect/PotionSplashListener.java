package net.fortressgames.fortressessentials.listeners.protect;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PotionSplashEvent;

public class PotionSplashListener implements Listener {

	@EventHandler
	public void pot(PotionSplashEvent e) {
		e.setCancelled(true);
	}
}