package com.ccc212.backupCode;

import com.ccc212.FolderUtils;
import com.ccc212.ZipUtil;
import org.bukkit.Bukkit;

import java.io.File;
import java.util.Arrays;

public class BackupTo {
    public BackupTo(int num) {
        File[] files = new File("./backup").listFiles();

        if(num > files.length){
            Bukkit.broadcastMessage("没有该备份文件");
            return;
        }

        try {
            Bukkit.broadcastMessage("正在回档");
            Bukkit.getServer().shutdown();
//            File file = new File("./world");
//            if(!FolderUtils.isFolderEmpty(file)){
//                FolderUtils.deleteFolder(file);
//            }
            ZipUtil.UnZip(new File("./backup/" + files[num - 1].getName()),new File("./"));
        }catch (Exception e){
            Bukkit.broadcastMessage("回档失败");
            e.printStackTrace();
        }

    }
}
