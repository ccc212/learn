package com.ccc212;

import com.ccc212.backupCode.BackupTask;
import com.ccc212.command.TimeCommand;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitTask;

public class MyListener implements Listener {
    private BukkitTask backupTask;

    @EventHandler   //处理事件
    public void playerJoin(PlayerJoinEvent playerJoinEvent){
        if (backupTask == null) {
            TimeCommand.setTimeRate(1);
            startBackupTask();
        }

        playerJoinEvent.setJoinMessage(
                Plugin_1.instance.getConfig().getString("joinMessage").replace("%player%",
                        playerJoinEvent.getPlayer().getName()));

        int onlinePlayers = Plugin_1.instance.getServer().getOnlinePlayers().size();
        playerJoinEvent.getPlayer().sendMessage("当前服务器有 " + onlinePlayers + " 位玩家在线");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Bukkit.getScheduler().runTaskLater(Plugin_1.instance, () -> {
            // 在玩家离开后广播消息
            Bukkit.broadcastMessage(event.getPlayer().getName() + " 离开了服务器");
            Bukkit.broadcastMessage("当前服务器有 " + Plugin_1.instance.getServer().getOnlinePlayers().size() + " 位玩家在线");

            // 当玩家下线时检查是否还有其他玩家在线
            if (Plugin_1.instance.getServer().getOnlinePlayers().size() == 0) { // 在线玩家数量为1，即只剩下本身
                stopBackupTask();
                new BackupTask().run();
                TimeCommand.setTimeRate(0);
            }
        }, 20L); // 延迟一秒发送消息，以确保玩家完全离开服务器
    }

    private void startBackupTask() {
        int interval = 20 * 60 * Plugin_1.instance.getConfig().getInt("backupGap");
        // 在异步线程中执行备份任务
        backupTask = Bukkit.getScheduler().runTaskTimerAsynchronously(Plugin_1.instance, new BackupTask(), 0, interval);
    }

    private void stopBackupTask() {
        if (backupTask != null) {
            backupTask.cancel();
        }
    }
}
