package com.moon.moon;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Door;
import org.bukkit.material.Gate;

public class irondoorListener implements Listener{

	public static int local; //cooltime
	
	@EventHandler
	public void onPlayerInteract (PlayerInteractEvent event) {
		
		if(event.getClickedBlock() == null || event.getClickedBlock().getType() ==null|| event.getAction() == Action.LEFT_CLICK_AIR|| event.getAction() == Action.LEFT_CLICK_BLOCK) return;
		
		Player player = event.getPlayer();
        ItemStack held = player.getItemInHand();
        Action action = event.getAction();
        Block clicked = event.getClickedBlock();
        
        if (clicked.getType() == Material.IRON_DOOR_BLOCK) {
            if (action == Action.RIGHT_CLICK_BLOCK) {
                if (held.getType() == Material.AIR) {
                	
                	if(!event.getPlayer().isOp()) return; //OP ¾Æ´Ï¸é return
                	
                    BlockState state = clicked.getState();
                    Door door = (Door) state.getData();
                    if (door.isTopHalf()){
                    	Block set = clicked.getRelative(BlockFace.DOWN);
                    	BlockState state2 = set.getState();
                    	Door setDoor = (Door) state2.getData();
                        if (setDoor.isOpen() == false) {
                        	if(voids.cando(event.getPlayer()) == false) return;
                        	setDoor.setOpen(true);
                            //event.getPlayer().sendMessage("Open");
                            state2.update();
                            state.update();
                            return;
                        } else {
                        	if(voids.cando(event.getPlayer()) == false) return;
                        	setDoor.setOpen(false);
                            //event.getPlayer().sendMessage("Closed");
                            state2.update();
                            state.update();
                            return;
                        }
                    	
                    } else {
                    	if (door.isOpen() == false) {
                        	if(voids.cando(event.getPlayer()) == false) return;
                    		door.setOpen(true);
                    		//event.getPlayer().sendMessage("Open");
                    		state.update();
                            state.update();
                    		return;
                    	} else {
                        	if(voids.cando(event.getPlayer()) == false) return;
                    		door.setOpen(false);
                    		//event.getPlayer().sendMessage("Closed");
                    		state.update();
                            state.update();
                    		return;
                    	}
                   
                    }
                } else {
                	return;
                }
            } else {
            	return;
            }
        
        } else {
        	return;
        }
	}
}