package net.fortressgames.fortressessentials.listeners.protect;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.LingeringPotionSplashEvent;

public class LingeringPotionSplashListener implements Listener {

	@EventHandler
	public void pot(LingeringPotionSplashEvent e) {
		e.setCancelled(true);
	}
}