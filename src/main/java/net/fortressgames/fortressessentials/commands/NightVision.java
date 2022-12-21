package net.fortressgames.fortressessentials.commands;

import net.fortressgames.fortressapi.commands.CommandBase;
import net.fortressgames.fortressessentials.EssentialLang;
import net.fortressgames.fortressessentials.EssentialPermissionsLang;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NightVision extends CommandBase {

	public NightVision() {
		super("nightvision", EssentialPermissionsLang.NV, "nv");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		if(sender instanceof Player player) {

			if(player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
				player.removePotionEffect(PotionEffectType.NIGHT_VISION);
				sender.sendMessage(EssentialLang.NIGHT_VISION_REMOVED);
				return;
			}

			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 9999999, 10));
			sender.sendMessage(EssentialLang.NIGHT_VISION_ADDED);

		}
	}
}