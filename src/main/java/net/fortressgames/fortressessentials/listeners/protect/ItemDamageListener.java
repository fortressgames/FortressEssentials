package net.fortressgames.fortressessentials.listeners.protect;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;

public class ItemDamageListener implements Listener {

	@EventHandler
	public void itemDamage(PlayerItemDamageEvent e) {
		e.setCancelled(true);
	}
}