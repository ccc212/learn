package com.ccc212.command;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TimeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (s.equalsIgnoreCase("setTimeRate")) {
            if (strings.length == 1) {
                try {
                    double multiplier = Double.parseDouble(strings[0]);
                    setTimeRate(multiplier);
                    commandSender.sendMessage("时间倍率已设置为 " + multiplier + " 倍");
                } catch (Exception e) {
                    commandSender.sendMessage("无效的倍率值！");
                }
            } else {
                commandSender.sendMessage("用法: /setTimeRate <倍率>");
            }
            return true;
        }
        return false;
    }

    public static void setTimeRate(double multiplier) {
        double timeMultiplier = multiplier;
        for (World world : Bukkit.getWorlds()) {
            world.setGameRuleValue("randomTickSpeed", String.valueOf((int) (3 * timeMultiplier)));
        }
    }
}
