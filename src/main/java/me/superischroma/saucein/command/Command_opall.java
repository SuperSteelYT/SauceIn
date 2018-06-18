package me.superischroma.saucein.command;

import me.superischroma.saucein.util.SauceInPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_opall extends SauceInPlus implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("opall"))
        {
            if (sender.hasPermission("saucein.opall"))
            {
                if (args.length == 0)
                {
                    Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + sender.getName() + " * Giving operator to everyone on the server");
                    for (Player p : Bukkit.getOnlinePlayers())
                    {
                        p.setOp(true);
                        p.sendMessage(giveOperatorAction);
                    }
                    return true;
                }
                if (args[0].equalsIgnoreCase("-c"))
                {
                    Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + sender.getName() + " * Giving everyone operator and creative");
                    for (Player p : Bukkit.getOnlinePlayers())
                    {
                        p.setOp(true);
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(giveOperatorAction);
                    }
                    return true;
                }
                if (args[0].equalsIgnoreCase("-s"))
                {
                    Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + sender.getName() + " * Giving everyone operator and survival");
                    for (Player p : Bukkit.getOnlinePlayers())
                    {
                        p.setOp(true);
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(giveOperatorAction);
                    }
                    return true;
                }
                if (args[0].equalsIgnoreCase("-a"))
                {
                    Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + sender.getName() + " * Giving everyone operator and adventure");
                    for (Player p : Bukkit.getOnlinePlayers())
                    {
                        p.setOp(true);
                        p.setGameMode(GameMode.ADVENTURE);
                        p.sendMessage(giveOperatorAction);
                    }
                    return true;
                }
            }
            else
            {
                sender.sendMessage(noPermissionException);
                return true;
            }
        }
        return false;
    }
}
