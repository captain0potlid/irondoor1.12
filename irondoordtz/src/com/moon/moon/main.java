package com.moon.moon;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {

	public static HashMap<UUID, Integer> ct = new HashMap<UUID, Integer>(); //cooltime
	
	@Override
	public void onEnable() {

		ConsoleCommandSender consol = Bukkit.getConsoleSender();

		consol.sendMessage(ChatColor.AQUA + "---------------------------------------------------------------------------------------------");
		consol.sendMessage(ChatColor.AQUA + "");
		consol.sendMessage(ChatColor.AQUA + "[	*	*	*	PrivDoorDTZ Started!	*	*	*	]");
		consol.sendMessage(ChatColor.AQUA + "");
		consol.sendMessage(ChatColor.AQUA + "---------------------------------------------------------------------------------------------");
		
		getServer().getPluginManager().registerEvents(this, this);
		this.getServer().getPluginManager().registerEvents(new irondoorListener(), this);
	}

	@EventHandler
	public void join(PlayerJoinEvent e) {
		//join event
		
		Player p = e.getPlayer();
		
		main.ct.put(p.getUniqueId(), 1);
		int a = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
				
				@Override
				public void run() {
					
					int local = ct.get(p.getUniqueId());
					
					if(local == 0) {
						return;
					}
					if(local == 1) {
						ct.put(p.getUniqueId(), 0);
						return;
					}
					
					String www = local + "";
					p.sendMessage(www);
					
				}
			}, 0L, 5L);
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		//quit event
	}
	
}

