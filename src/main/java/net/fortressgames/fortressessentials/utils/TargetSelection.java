package net.fortressgames.fortressessentials.utils;

import net.fortressgames.fortressapi.players.FortressPlayerModule;
import org.bukkit.Bukkit;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.*;

public enum TargetSelection {

	a,	// Targets all players
	e,	// Targets all entities
	p,	// Targets the nearest player
	r,	// Targets a random player
	s	// Targets the entity that is executing the command (referred to as "yourself")
	;

	public static List<Entity> getTargets(String arg, CommandSender sender) {

		if(arg.contains("@")) {
			return getEntities(TargetSelection.valueOf(arg.toLowerCase().replace("@", "")), sender);
		}

		return new ArrayList<>() {
			{
				if(FortressPlayerModule.getInstance().getPlayer(arg) != null) {
					add(FortressPlayerModule.getInstance().getPlayer(arg));
				}
			}
		};
	}

	private static List<Entity> getEntities(TargetSelection selection, CommandSender sender) {
		List<Entity> entities = new ArrayList<>();

		switch (selection) {
			case a -> entities.addAll(FortressPlayerModule.getInstance().getOnlinePlayers());
			case e -> Bukkit.getWorlds().forEach(world -> entities.addAll(world.getEntities()));
			case p -> {
				if(sender instanceof Entity) {
					entities.add((Entity) sender);
					break;
				}

				if(sender instanceof BlockCommandSender commandBlock) {

					Player target = null;
					for(Player pp : FortressPlayerModule.getInstance().getOnlinePlayers()) {

						if(target == null) {
							target = pp;
							continue;
						}

						if(pp.getLocation().distance(commandBlock.getBlock().getLocation()) <
								target.getLocation().distance(commandBlock.getBlock().getLocation())) {

							target = pp;
						}
					}

					entities.add(target);
				}
			}
			case r -> entities.add(FortressPlayerModule.getInstance().getOnlinePlayers().get(
					new Random().nextInt(FortressPlayerModule.getInstance().getOnlinePlayers().size())
			));
			case s -> {
				if(sender instanceof Entity) entities.add((Entity) sender);
			}
		}

		return entities;
	}
}