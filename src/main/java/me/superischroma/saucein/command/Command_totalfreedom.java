package me.superischroma.saucein.command;

import me.superischroma.saucein.util.SauceInPlus;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Command_totalfreedom extends SauceInPlus implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("totalfreedom"))
        {
            if (sender.isOp())
            {
                sender.sendMessage(ChatColor.GREEN + "Origins of SauceIn's name comes from a server named TotalFreedom");
                sender.sendMessage(ChatColor.GREEN + "TotalFreedom's original IP was tf.sauc.in, which inspired Super_ " +
                        "to create the SauceIn plugin.");
                sender.sendMessage(ChatColor.DARK_GREEN + "TotalFreedom boards: " + ChatColor.GREEN + "https://totalfreedom.boards.net");
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
