package com.ccc212;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class MyListener implements Listener {
    @EventHandler   //处理事件
    public void playerJoin(PlayerJoinEvent playerJoinEvent){
        playerJoinEvent.setJoinMessage(
                Plugin_1.instance.getConfig().getString("joinMessage").replace("player",playerJoinEvent.getPlayer().getName()));
    }
}
