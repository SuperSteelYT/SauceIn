package me.superischroma.saucein.command;

import me.superischroma.saucein.ChatManagement;
import me.superischroma.saucein.SauceIn;
import me.superischroma.saucein.util.SauceInPlus;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_adminchat extends SauceInPlus implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        Player playerSender = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("adminchat"))
        {
            if (sender.hasPermission("saucein.accessadminchat"))
            {
                if (args.length == 0)
                {
                    if (!ChatManagement.adminchattoggle)
                    {
                        sender.sendMessage(ChatColor.GRAY + "AdminChat enabled.");
                        ChatManagement.adminchat.add(playerSender);
                        return true;
                    }
                    else
                    {
                        sender.sendMessage(ChatColor.GRAY + "AdminChat disabled.");
                        ChatManagement.publicchat.add(playerSender);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
