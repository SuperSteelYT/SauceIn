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
            if (sender.hasPermission("saucein.rank"))
            {
                if (args.length == 0)
                {
                    if (Rank.sauceAdminList.contains(sender.getName()))
                    {
                        sender.sendMessage(ChatColor.GREEN + sender.getName() + " is a " + ChatColor.RED + "Sauce Admin");
                        return true;
                    }
                    else if (Rank.seniorSauceAdminList.contains(sender.getName()))
                    {
                        sender.sendMessage(ChatColor.GREEN + sender.getName() + " is a " + ChatColor.DARK_AQUA + "Senior Sauce Admin");
                        return true;
                    }
                    else if (Rank.developerList.contains(sender.getName()))
                    {
                        sender.sendMessage(ChatColor.GREEN + sender.getName() + " is a " + ChatColor.LIGHT_PURPLE + "Developer");
                        return true;
                    }
                    else if (Rank.owners.contains(sender.getName()))
                    {
                        sender.sendMessage(ChatColor.GREEN + sender.getName() + " is the " + ChatColor.GREEN + "Owner");
                        return true;
                    }
                    else if (!Rank.sauceAdminList.contains(sender.getName())
                            && !Rank.seniorSauceAdminList.contains(sender.getName())
                            && !Rank.developerList.contains(sender.getName())
                            && !Rank.owners.contains(sender.getName())
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
                if (Rank.sauceAdminList.contains(target.getName()))
                {
                    sender.sendMessage(ChatColor.GREEN + target.getName() + " is a " + ChatColor.RED + "Sauce Admin");
                    return true;
                }
                else if (Rank.seniorSauceAdminList.contains(target.getName()))
                {
                    sender.sendMessage(ChatColor.GREEN + target.getName() + " is a " + ChatColor.DARK_AQUA + "Senior Sauce Admin");
                    return true;
                }
                else if (Rank.developerList.contains(target.getName()))
                {
                    sender.sendMessage(ChatColor.GREEN + target.getName() + " is a " + ChatColor.LIGHT_PURPLE + "Developer");
                    return true;
                }
                else if (Rank.owners.contains(target.getName()))
                {
                    sender.sendMessage(ChatColor.GREEN + target.getName() + " is the Owner");
                    return true;
                }
                else if (!Rank.sauceAdminList.contains(target.getName())
                        && !Rank.seniorSauceAdminList.contains(target.getName())
                        && !Rank.developerList.contains(target.getName())
                        && !Rank.owners.contains(target.getName())
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
        }
        return false;
    }
}


