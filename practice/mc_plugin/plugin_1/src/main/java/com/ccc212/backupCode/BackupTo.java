package com.ccc212.backupCode;

import org.bukkit.Bukkit;

import java.io.File;
import java.util.Arrays;

public class BackupTo {
    public BackupTo(int num) {
        File[] files = new File("./backup").listFiles();

        Arrays.sort(files);

        try {
            Bukkit.broadcastMessage("正在回档");
            new File("./backup/temp").mkdir();
            File backupFile = files[num];


        }catch (Exception e){
            Bukkit.broadcastMessage("回档失败");
            e.printStackTrace();
        }

    }
}
