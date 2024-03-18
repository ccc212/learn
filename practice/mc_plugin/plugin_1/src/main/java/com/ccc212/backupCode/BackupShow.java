package com.ccc212.backupCode;

import org.bukkit.Bukkit;

import java.io.File;
import java.util.Arrays;

public class BackupShow {
    public BackupShow(){
        File[] files = new File("./backup").listFiles();

        Arrays.sort(files);

        Bukkit.broadcastMessage("------------------------");
        Bukkit.broadcastMessage("备份:");
        for (int i = 0; i < files.length; i++) {
            Bukkit.broadcastMessage((i+1) + ":  " + files[i].getName());
        }
        Bukkit.broadcastMessage("------------------------");
    }
}
