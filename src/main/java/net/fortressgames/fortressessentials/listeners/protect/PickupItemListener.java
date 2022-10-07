package net.fortressgames.fortressessentials.listeners.protect;

import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class PickupItemListener implements Listener {

	@EventHandler
	public void pickUp(EntityPickupItemEvent e) {
		if(e.getEntity() instanceof Player) {
			if(!e.getEntity().hasPermission(EssentialPermissionsLang.PROTECT_PICKUP_ITEM)) {
				e.setCancelled(true);
			}
		}
	}
}