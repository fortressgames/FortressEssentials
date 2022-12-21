package net.fortressgames.fortressessentials;

import lombok.Getter;
import net.fortressgames.fortressapi.commands.CommandModule;
import net.fortressgames.fortressapi.utils.ConsoleMessage;
import net.fortressgames.fortressessentials.commands.*;
import net.fortressgames.fortressessentials.listeners.PreCommandListener;
import net.fortressgames.fortressessentials.listeners.UseBlocksListener;
import net.fortressgames.fortressessentials.listeners.protect.*;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class FortressEssentials extends JavaPlugin {

	@Getter private static FortressEssentials instance;

	/**
	 * Called when plugin first loads by spigot and is called before onEnable
	 */
	@Override
	public void onLoad() {
		if(!getDataFolder().exists()) {
			getDataFolder().mkdir();
		}

		getConfig().addDefault("BLOCK_BREAK", false);
		getConfig().addDefault("BLOCK_PLACE", false);
		getConfig().addDefault("DROP_ITEM", false);
		getConfig().addDefault("PICKUP_ITEM", false);
		getConfig().addDefault("ENTITY_EXPLODE", false);
		getConfig().addDefault("BLOCK_EXPLODE", false);
		getConfig().addDefault("FIRE_DAMAGE", false);
		getConfig().addDefault("FOOD_LEVEL_CHANGE", false);
		getConfig().addDefault("ICE_MELT", false);
		getConfig().addDefault("ITEM_DAMAGE", false);
		getConfig().addDefault("LEAVE_DECAY", false);
		getConfig().addDefault("LINGERING_POTION_SPLASH", false);
		getConfig().addDefault("POTION_SPLASH", false);
		getConfig().addDefault("SWAP_HANDS", false);
		getConfig().addDefault("CORAL_DIE", false);

		getConfig().options().copyDefaults(true);
		saveConfig();

		if(!getConfig().contains("Spawn")) {
			getConfig().set("Spawn.World", "world");
			getConfig().set("Spawn.X", 0);
			getConfig().set("Spawn.Y", 0);
			getConfig().set("Spawn.Z", 0);
			getConfig().set("Spawn.Yaw", 0);
			getConfig().set("Spawn.Pitch", 0);
			saveConfig();
		}

		if(!getConfig().contains("BlockedCommands")) {
			getConfig().set("BlockedCommands", new ArrayList<>());
			saveConfig();
		}

		if(!getConfig().contains("BlockIntractableBlocks")) {
			getConfig().set("BlockIntractableBlocks", new ArrayList<>());
			saveConfig();
		}

		if(!getConfig().contains("BlockIntractableItems")) {
			getConfig().set("BlockIntractableItems", new ArrayList<>());
			saveConfig();
		}

		if(!getConfig().contains("Worlds")) {
			getConfig().set("Worlds", new ArrayList<>());
			saveConfig();
		}
	}

	/**
	 * Called when the plugin is first loaded by Spigot
	 */
	@Override
	public void onEnable() {
		instance = this;

		// Load worlds
		getConfig().getStringList("Worlds").forEach(name -> Bukkit.createWorld(new WorldCreator(name)));

		// Commands
		CommandModule.registerCommand(new SeedCommand());
		CommandModule.registerCommand(new MeCommand());
		CommandModule.registerCommand(new ClearCommand());
		CommandModule.registerCommand(new DifficultyCommand());
		CommandModule.registerCommand(new GameModeCommand());
		CommandModule.registerCommand(new OpListCommand());
		CommandModule.registerCommand(new ListCommand());
		CommandModule.registerCommand(new PluginCommand());
		CommandModule.registerCommand(new WhitelistCommand());
		CommandModule.registerCommand(new WeatherCommand());
		CommandModule.registerCommand(new TimeCommand());
		CommandModule.registerCommand(new SayCommand());
		CommandModule.registerCommand(new SpawnCommand());
		CommandModule.registerCommand(new NightVision());
		CommandModule.registerCommand(new WorldCommand());

		// Listeners
		this.getServer().getPluginManager().registerEvents(new PreCommandListener(), this);
		this.getServer().getPluginManager().registerEvents(new UseBlocksListener(), this);
		loadProtectionListeners();

		getLogger().info(ConsoleMessage.GREEN + "Version: " + getDescription().getVersion() + " Enabled!" + ConsoleMessage.RESET);
	}

	/**
	 * Called when the server is restarted or stopped
	 */
	@Override
	public void onDisable() {
		getLogger().info(ConsoleMessage.RED + "Version: " + getDescription().getVersion() + " Disabled!" + ConsoleMessage.RESET);
	}

	public void loadProtectionListeners() {
		if(!getConfig().getBoolean("BLOCK_BREAK")) {
			this.getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);
		}
		if(!getConfig().getBoolean("BLOCK_PLACE")) {
			this.getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
		}
		if(!getConfig().getBoolean("DROP_ITEM")) {
			this.getServer().getPluginManager().registerEvents(new DropItemListener(), this);
		}
		if(!getConfig().getBoolean("PICKUP_ITEM")) {
			this.getServer().getPluginManager().registerEvents(new PickupItemListener(), this);
		}
		if(!getConfig().getBoolean("ENTITY_EXPLODE")) {
			this.getServer().getPluginManager().registerEvents(new EntityExplodeListener(), this);
		}
		if(!getConfig().getBoolean("BLOCK_EXPLODE")) {
			this.getServer().getPluginManager().registerEvents(new BlockExplodeListener(), this);
		}
		if(!getConfig().getBoolean("FIRE_DAMAGE")) {
			this.getServer().getPluginManager().registerEvents(new FireDamageListener(), this);
		}
		if(!getConfig().getBoolean("FOOD_LEVEL_CHANGE")) {
			this.getServer().getPluginManager().registerEvents(new FoodLevelChangeListener(), this);
		}
		if(!getConfig().getBoolean("ICE_MELT")) {
			this.getServer().getPluginManager().registerEvents(new IceMeltListener(), this);
		}
		if(!getConfig().getBoolean("ITEM_DAMAGE")) {
			this.getServer().getPluginManager().registerEvents(new ItemDamageListener(), this);
		}
		if(!getConfig().getBoolean("LEAVE_DECAY")) {
			this.getServer().getPluginManager().registerEvents(new LeaveDecayListener(), this);
		}
		if(!getConfig().getBoolean("LINGERING_POTION_SPLASH")) {
			this.getServer().getPluginManager().registerEvents(new LingeringPotionSplashListener(), this);
		}
		if(!getConfig().getBoolean("POTION_SPLASH")) {
			this.getServer().getPluginManager().registerEvents(new PotionSplashListener(), this);
		}
		if(!getConfig().getBoolean("SWAP_HANDS")) {
			this.getServer().getPluginManager().registerEvents(new SwapHandsListener(), this);
		}
		if(!getConfig().getBoolean("CORAL_DIE")) {
			this.getServer().getPluginManager().registerEvents(new CoralDieListener(), this);
		}
	}
}

