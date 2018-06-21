package me.superischroma.saucein.command;

import me.superischroma.saucein.util.Log;
import me.superischroma.saucein.util.SauceInPlus;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Command_saucein extends SauceInPlus implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("saucein"))
        {
            if (args.length == 0)
            {
                sender.sendMessage(ChatColor.GRAY + "// WORK IN PROGRESS //");
                return true;
            }
            if (args.length == 1)
            {
                if (args[0].equalsIgnoreCase("reload"))
                {
                    if (!plugin.getConfig().getStringList("sauce_admins").contains(sender.getName())
                    && !plugin.getConfig().getStringList("senior_sauce_admins").contains(sender.getName())
                    && !plugin.getConfig().getStringList("developers").contains(sender.getName())
                    && !plugin.getConfig().getStringList("owners").contains(sender.getName()))
                    {
                        sender.sendMessage(noPermissionException);
                        return true;
                    }
                    else
                    {
                        plugin.reloadConfig();
                        sender.sendMessage(ChatColor.GRAY + "SauceIn has been reloaded.");
                        Log.info(sender.getName() + " has reloaded the plugin.");
                        return true;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
