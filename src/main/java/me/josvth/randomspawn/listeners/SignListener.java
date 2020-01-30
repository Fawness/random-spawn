package me.josvth.randomspawn.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import me.josvth.randomspawn.RandomSpawn;

public class SignListener implements Listener {
	RandomSpawn plugin;

	public SignListener(RandomSpawn instance) {
		plugin = instance;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onPlayerSignInteract(PlayerInteractEvent event){
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
			
		}
	}

	@EventHandler
	public void onPlayerSignPlace(SignChangeEvent event){
		if (event.getLine(0).equalsIgnoreCase( plugin.yamlHandler.config.getString("rs-sign-text","[RandomSpawn]") ) ){
			Player player = event.getPlayer();
			if (player.hasPermission("RandomSpawn.placesign")){
				this.plugin.playerInfo(player, "Random Spawn Sign created!");
			}else{
				event.setLine(0, "");
				this.plugin.playerInfo(player, "You don't have the permission to place a Random Spawn Sign!");
			}
		}
	}

}
