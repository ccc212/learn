package com.ccc212;
import com.ccc212.backupCode.BackupTask;
import com.ccc212.command.MyCommand;
import com.ccc212.command.TimeCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class Plugin_1 extends JavaPlugin {
    public static Plugin_1 instance;

    @Override
    public void onEnable() {
        instance = this;

        Bukkit.getPluginCommand("ccc212").setExecutor(new MyCommand());
        Bukkit.getPluginManager().registerEvents(new MyListener(),this);

        // 注册备份命令
        Bukkit.getPluginCommand("backup").setExecutor(new com.ccc212.command.BackupCommand());

        Bukkit.getPluginCommand("setTimeRate").setExecutor(new TimeCommand());

        //生成配置文件
        saveDefaultConfig();

        reloadConfig();
    }

    public static void main(String[] args) {

    }

    @Override
    public void onDisable() {
        // 插件关闭逻辑
    }
}
