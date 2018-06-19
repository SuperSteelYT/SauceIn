package me.superischroma.saucein.command;

import me.superischroma.saucein.util.SauceInPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_op extends SauceInPlus implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("op"))
        {
            if (sender.hasPermission("saucein.op"))
            {
                if (args.length == 0)
                {
                    return false;
                }
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null)
                {
                    sender.sendMessage(playerNotFoundException);
                    return true;
                }
                target.setOp(true);
                Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + sender.getName() + " * Giving operator to " + target.getName());
                target.sendMessage(giveOperatorAction);
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
