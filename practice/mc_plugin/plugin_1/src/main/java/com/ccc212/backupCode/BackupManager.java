package com.ccc212.backupCode;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

import com.ccc212.Plugin_1;
import com.ccc212.ZipUtil;
import org.bukkit.Bukkit;

public class BackupManager {
    private int backupMaxFiles = 5;

    public void backupGame() {
        try {
            backupMaxFiles = Plugin_1.instance.getConfig().getInt("backupMaxFiles");
        } catch (Exception e) {
            Bukkit.broadcastMessage("配置文件中最大备份文件数量配置有误");
        }

        // 生成时间戳
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp = dateFormat.format(new Date());

        // 备份文件夹路径
        File backupFolder = new File("./backup");
        backupFolder.mkdir();

        File[] files = backupFolder.listFiles();
        if(files != null && files.length >= backupMaxFiles){
            Arrays.sort(files);
            for(int i = 0; i <= files.length - backupMaxFiles; i++){
                files[i].delete();
            }
        }

        Arrays.sort(files);

        try {
            ZipUtil.toZip(new File("./world"),new File("./backup/" + timestamp + ".zip"));
            Bukkit.broadcastMessage("备份成功");
        }catch (Exception e){
            Bukkit.broadcastMessage("备份失败");
            e.printStackTrace();
        }

    }
}
