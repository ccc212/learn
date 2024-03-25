package com.ccc212.backupCode;

import com.ccc212.FolderUtils;
import com.ccc212.Plugin_1;
import com.ccc212.ZipUtil;
import org.bukkit.Bukkit;

import java.io.File;
import java.util.Arrays;
import java.util.logging.Logger;

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
            ZipUtil.UnZip(new File("/backup/" + files[num - 1].getName()),new File("./"));
//            restartServer();
        }catch (Exception e){
            Bukkit.broadcastMessage("回档失败");
            e.printStackTrace();
        }

    }

//    private void restartServer() {
//        // 检查是否存在start.bat或start.sh文件
//        File startBat = new File("./start.bat");
//        File startSh = new File("./start.sh");
//
//        if (startBat.exists()) {
//            executeCommand("cmd /c start.bat");
//        } else if (startSh.exists()) {
//            executeCommand("sh start.sh");
//        } else {
//            System.out.println("未找到启动脚本文件 (start.bat 或 start.sh).无法重启服务器.");//后改为日志
//        }
//
//    }
//
//    private void executeCommand(String command) {
//        try {
//            Runtime.getRuntime().exec(command);
//        } catch (Exception e) {
//            System.out.println("执行命令时出现错误：" + e.getMessage());//后改为日志
//        }
//    }
}
