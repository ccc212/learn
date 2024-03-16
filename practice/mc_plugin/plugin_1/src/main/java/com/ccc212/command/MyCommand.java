package com.ccc212.command;

import com.ccc212.Plugin_1;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class MyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length == 1 && strings[0].equals("help")){
            Bukkit.broadcastMessage("------------------------");
            Bukkit.broadcastMessage("ccc212 --- help");
            Bukkit.broadcastMessage("/c say + [话]     --- 匿名讲话");
            Bukkit.broadcastMessage("/c open    --- 打开你的箱子");
            Bukkit.broadcastMessage("/c reload    --- 重新加载配置文件");
            Bukkit.broadcastMessage("------------------------");
            return true;
        }

        if(strings.length == 2 && strings[0].equals("say"))
        {
            Bukkit.broadcastMessage(strings[1]);
            return true;
        }

        if(strings.length == 1 && strings[0].equals("open")){
            Inventory inventory = Bukkit.createInventory(null,36, commandSender.getName() +"的箱子");
            Player player = (Player)commandSender;
            player.openInventory(inventory);
            return true;
        }

        if(strings.length == 1 && strings[0].equals("reload")){
            Plugin_1.instance.reloadConfig();
            return true;
        }

        return false;
    }
}
