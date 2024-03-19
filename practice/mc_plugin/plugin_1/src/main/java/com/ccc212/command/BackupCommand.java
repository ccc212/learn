package com.ccc212.command;

import com.ccc212.FolderUtils;
import com.ccc212.MyListener;
import com.ccc212.backupCode.BackupManager;
import com.ccc212.backupCode.BackupShow;
import com.ccc212.backupCode.BackupTask;
import com.ccc212.backupCode.BackupTo;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.File;

public class BackupCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length == 1 && strings[0].equals("help")){
            Bukkit.broadcastMessage("------------------------");
            Bukkit.broadcastMessage("backup --- help");
            Bukkit.broadcastMessage("/backup 或 /b   --- 备份");
            Bukkit.broadcastMessage("/b show    --- 展示备份文件");
            Bukkit.broadcastMessage("/b to [数字]   --- 回到指定档");
            Bukkit.broadcastMessage("------------------------");
            return true;
        }

        if (strings.length == 0 && command.getName().equalsIgnoreCase("backup")) {
            // 执行备份操作
            new BackupTask().run();

            return true;
        }

        if (strings.length == 1 && strings[0].equals("show")){
            new BackupShow();
            return true;
        }

        if(strings.length == 2 && strings[0].equals("to")){
            if(!FolderUtils.isFolderEmpty(new File("./backup"))){
                Bukkit.broadcastMessage("备份文件夹为空");
            }

            try {
                int num = Integer.parseInt(strings[1]);
                new BackupTo(num);
            } catch (NumberFormatException e) {
                Bukkit.broadcastMessage("输入数字来回到对应的档");
                return true;
            }
        }

        return false;
    }
}
