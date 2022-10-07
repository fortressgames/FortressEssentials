package net.fortressgames.fortressessentials.listeners;

import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import net.fortressgames.fortressessentials.FortressEssentials;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class UseBlocksListener implements Listener {

	@EventHandler
	public void useBlock(PlayerInteractEvent e) {
		Player player = e.getPlayer();

		if(e.getHand() != null && e.getHand().equals(EquipmentSlot.OFF_HAND)) return;
		if(e.getClickedBlock() == null) return;
		if(player.isOp() || player.hasPermission(EssentialPermissionsLang.PROTECT_USE)) return;

		if(e.getAction() == Action.PHYSICAL) {
			e.setCancelled(true);
		}

		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {

			if(FortressEssentials.getInstance().getConfig().getStringList("BlockIntractableBlocks").contains(e.getClickedBlock().getType().name())) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void useItem(PlayerInteractEntityEvent e) {
		if(e.getPlayer().hasPermission(EssentialPermissionsLang.PROTECT_USE)) return;
		if(e.getHand() == EquipmentSlot.OFF_HAND) return;

		System.out.println(e.getRightClicked().getType().name());

		if(FortressEssentials.getInstance().getConfig().getStringList("BlockIntractableItems").contains(e.getRightClicked().getType().name())) {
			e.setCancelled(true);
		}
	}
}