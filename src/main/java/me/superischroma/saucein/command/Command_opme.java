package me.superischroma.saucein.command;

import me.superischroma.saucein.util.SauceInPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_opme extends SauceInPlus implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("opme"))
        {
            if (sender.hasPermission("saucein.opme"))
            {
                if (args.length > 0)
                {
                    return false;
                }
                sender.setOp(true);
                Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + sender.getName() + " * Giving operator to themselves");
                return true;
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
