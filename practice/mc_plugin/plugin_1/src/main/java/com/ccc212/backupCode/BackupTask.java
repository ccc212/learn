package com.ccc212.backupCode;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class BackupTask extends BukkitRunnable {

    @Override
    public void run() {
        // 执行备份操作
        Bukkit.broadcastMessage("开始备份");
        new BackupManager().backupGame();
    }
}
