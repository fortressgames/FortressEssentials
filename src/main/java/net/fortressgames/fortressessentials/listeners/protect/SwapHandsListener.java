package net.fortressgames.fortressessentials.listeners.protect;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class SwapHandsListener implements Listener {

	@EventHandler
	public void swapHands(PlayerSwapHandItemsEvent e) {
		e.setCancelled(true);
	}
}