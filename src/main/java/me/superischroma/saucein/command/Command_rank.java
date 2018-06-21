package me.superischroma.saucein.command;

import me.superischroma.saucein.rank.Rank;
import me.superischroma.saucein.util.SauceInPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_rank extends SauceInPlus implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("rank"))
        {
            if (sender.isOp())
            {
                if (args.length == 0)
                {
                    if (plugin.getConfig().getStringList("sauce_admins").contains(sender.getName()))
                    {
                        sender.sendMessage(ChatColor.GREEN + sender.getName() + " is a " + ChatColor.RED + "Sauce Admin");
                        return true;
                    }
                    else if (plugin.getConfig().getStringList("senior_sauce_admins").contains(sender.getName()))
                    {
                        sender.sendMessage(ChatColor.GREEN + sender.getName() + " is a " + ChatColor.DARK_AQUA + "Senior Sauce Admin");
                        return true;
                    }
                    else if (plugin.getConfig().getStringList("developers").contains(sender.getName()))
                    {
                        sender.sendMessage(ChatColor.GREEN + sender.getName() + " is a " + ChatColor.LIGHT_PURPLE + "Developer");
                        return true;
                    }
                    else if (plugin.getConfig().getStringList("owners").contains(sender.getName()))
                    {
                        sender.sendMessage(ChatColor.GREEN + sender.getName() + " is the " + ChatColor.GREEN + "Owner");
                        return true;
                    }
                    else if (!plugin.getConfig().getStringList("sauce_admins").contains(sender.getName())
                        && !plugin.getConfig().getStringList("senior_sauce_admins").contains(sender.getName())
                        && !plugin.getConfig().getStringList("developers").contains(sender.getName())
                        && !plugin.getConfig().getStringList("owners").contains(sender.getName())
                        && sender.isOp())
                    {
                        sender.sendMessage(ChatColor.GREEN + sender.getName() + " is an " + ChatColor.GOLD + "Op");
                        return true;
                    }
                    else
                    {
                        sender.sendMessage(ChatColor.GREEN + sender.getName() + " is a " + ChatColor.BLUE + "Non-Op");
                        return true;
                    }
                }
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null)
                {
                    sender.sendMessage(playerNotFoundException);
                    return true;
                }
                if (plugin.getConfig().getStringList("sauce_admins").contains(sender.getName()))
                {
                    sender.sendMessage(ChatColor.GREEN + target.getName() + " is a " + ChatColor.RED + "Sauce Admin");
                    return true;
                }
                else if (plugin.getConfig().getStringList("senior_sauce_admins").contains(sender.getName()))
                {
                    sender.sendMessage(ChatColor.GREEN + target.getName() + " is a " + ChatColor.DARK_AQUA + "Senior Sauce Admin");
                    return true;
                }
                else if (plugin.getConfig().getStringList("developers").contains(sender.getName()))
                {
                    sender.sendMessage(ChatColor.GREEN + target.getName() + " is a " + ChatColor.LIGHT_PURPLE + "Developer");
                    return true;
                }
                else if (plugin.getConfig().getStringList("owners").contains(sender.getName()))
                {
                    sender.sendMessage(ChatColor.GREEN + target.getName() + " is the Owner");
                    return true;
                }
                else if (!plugin.getConfig().getStringList("sauce_admins").contains(target.getName())
                        && !plugin.getConfig().getStringList("senior_sauce_admins").contains(target.getName())
                        && !plugin.getConfig().getStringList("developers").contains(target.getName())
                        && !plugin.getConfig().getStringList("owners").contains(target.getName())
                        && target.isOp())
                {
                    sender.sendMessage(ChatColor.GREEN + target.getName() + " is an " + ChatColor.GOLD + "Op");
                    return true;
                }
                else
                {
                    sender.sendMessage(ChatColor.GREEN + target.getName() + " is a " + ChatColor.BLUE + "Non-Op");
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


