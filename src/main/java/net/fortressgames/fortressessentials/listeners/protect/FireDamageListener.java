package net.fortressgames.fortressessentials.listeners.protect;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.block.BlockSpreadEvent;

public class FireDamageListener implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void fire(BlockBurnEvent e) {
		e.setCancelled(true);
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void fire2(BlockSpreadEvent e) {
		if(e.getSource().getType() != Material.GRASS_BLOCK) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void fire3(BlockFadeEvent e) {
		if (
				e.getBlock().getType() != Material.ICE &&
				e.getBlock().getType() != Material.SNOW &&
				e.getBlock().getType() != Material.SNOW_BLOCK &&
				e.getBlock().getType() != Material.TURTLE_EGG &&
				e.getBlock().getType() != Material.SCAFFOLDING &&
				e.getBlock().getType() != Material.FIRE &&
				e.getBlock().getType() != Material.GRASS_BLOCK &&
				!e.getBlock().getType().name().contains("CORAL")
		) {
			e.setCancelled(true);
		}
	}
}