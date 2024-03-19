package com.ccc212.command;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TimeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (s.equalsIgnoreCase("settimemultiplier")) {
            if (strings.length == 1) {
                try {
                    double multiplier = Double.parseDouble(strings[0]);
                    setTimeMultiplier(multiplier);
                    commandSender.sendMessage("时间倍率已设置为 " + multiplier);
                } catch (NumberFormatException e) {
                    commandSender.sendMessage("无效的倍率值！");
                }
            } else {
                commandSender.sendMessage("用法: /settimemultiplier <倍率>");
            }
            return true;
        }
        return false;
    }

    private void setTimeMultiplier(double multiplier) {
        double timeMultiplier = multiplier;
        for (World world : Bukkit.getWorlds()) {
            world.setGameRuleValue("doDaylightCycle", "true");
            world.setGameRuleValue("doWeatherCycle", "true");
            world.setGameRuleValue("doMobSpawning", "true");
            world.setGameRuleValue("doEntityDrops", "true");
            world.setGameRuleValue("doTileDrops", "true");
            world.setGameRuleValue("randomTickSpeed", String.valueOf((int) (3 * timeMultiplier)));
        }
    }
}
