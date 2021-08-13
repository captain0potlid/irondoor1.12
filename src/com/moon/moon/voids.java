package com.moon.moon;

import org.bukkit.entity.Player;

public class voids {
	public static boolean cando(Player p) {
		if(!main.ct.containsKey(p.getUniqueId())) {
			main.ct.put(p.getUniqueId(), 0);
			return true;
		}
		if(main.ct.get(p.getUniqueId()) == 0) {
			main.ct.put(p.getUniqueId(), 1);
			return true;
		} else {
			//1이라면(시간안됨)
			return false;
		}
	}
}
