package de.tamion.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Speed implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        Player t;
        try {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                switch (args.length) {
                    case 1:
                        p.setWalkSpeed(Float.parseFloat(args[0])/10);
                        p.setFlySpeed(Float.parseFloat(args[0])/10);
                        p.sendMessage("Speed set to " + args[0]);
                        break;
                    case 2:
                        switch (args[0].toLowerCase()) {
                            case "fly":
                                p.setFlySpeed(Float.parseFloat(args[1])/10);
                                break;
                            case "walk":
                                p.setWalkSpeed(Float.parseFloat(args[1])/10);
                                break;
                            default:
                                t = Bukkit.getPlayer(args[0]);
                                if(t == null) {
                                    p.sendMessage("Player not online");
                                    return false;
                                }
                                t.setWalkSpeed(Float.parseFloat(args[1])/10);
                                t.setFlySpeed(Float.parseFloat(args[1])/10);
                                t.sendMessage("Speed set to " + args[1]);
                        }
                        p.sendMessage("Speed set to " + args[1]);
                        break;
                    case 3:
                        t = Bukkit.getPlayer(args[0]);
                        if(t == null) {
                            p.sendMessage("Player not online");
                            return false;
                        }
                        switch (args[1].toLowerCase()) {
                            case "fly":
                                t.setFlySpeed(Float.parseFloat(args[2]) / 10);
                                break;
                            case "walk":
                                t.setWalkSpeed(Float.parseFloat(args[2]) / 10);
                                break;
                        }
                        t.sendMessage("Speed set to " + args[0]);
                        p.sendMessage("Speed set to " + args[0]);
                        break;
                    default:
                        p.sendMessage("Invalid Args: /speed Optional:[Player] Optional:[Walk/Fly] [Speed]");
                }
            } else {
                switch (args.length) {
                    case 2:
                        t = Bukkit.getPlayer(args[0]);
                        if(t == null) {
                            sender.sendMessage("Player not online");
                            return false;
                        }
                        t.setWalkSpeed(Float.parseFloat(args[1])/10);
                        t.setFlySpeed(Float.parseFloat(args[1])/10);
                        t.sendMessage("Speed set to " + args[1]);
                        sender.sendMessage("Speed set to " + args[1]);
                        break;
                    case 3:
                        t = Bukkit.getPlayer(args[0]);
                        if(t == null) {
                            sender.sendMessage("Player not online");
                            return false;
                        }
                        switch (args[1].toLowerCase()) {
                            case "fly":
                                t.setFlySpeed(Float.parseFloat(args[2]) / 10);
                                break;
                            case "walk":
                                t.setWalkSpeed(Float.parseFloat(args[2]) / 10);
                                break;
                        }
                        t.sendMessage("Speed set to " + args[0]);
                        sender.sendMessage("Speed set to " + args[0]);
                        break;
                    default:
                        sender.sendMessage("Invalid Args: /speed [Player] Optional:[Walk/Fly] [Speed]");
                }
            }
        } catch (NumberFormatException e) {
            sender.sendMessage("Invalid Speed. Please select a value between -10 and 10");
        }
        return false;
    }
}
