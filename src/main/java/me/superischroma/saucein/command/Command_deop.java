package me.superischroma.saucein.command;

import me.superischroma.saucein.rank.Rank;
import me.superischroma.saucein.util.SauceInPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_deop extends SauceInPlus implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (cmd.getName().equalsIgnoreCase("deop"))
        {
            if (plugin.getConfig().getStringList("sauce_admins").contains(sender.getName())
                    || plugin.getConfig().getStringList("senior_sauce_admins").contains(sender.getName())
                    || plugin.getConfig().getStringList("developers").contains(sender.getName())
                    || plugin.getConfig().getStringList("owners").contains(sender.getName()))
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
                target.setOp(false);
                Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + sender.getName() + " * Revoking operator from " + target.getName());
                target.sendMessage(revokeOperatorAction);
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
