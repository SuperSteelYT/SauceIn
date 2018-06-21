package me.superischroma.saucein.command;
import me.superischroma.saucein.rank.Rank;
import me.superischroma.saucein.util.SauceInPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_creative extends SauceInPlus implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender.isOp())
        {
            Player playerSender = (Player) sender;
            if (args.length == 0)
            {
                if (!(sender instanceof Player))
                {
                    sender.sendMessage(consoleException);
                    return true;
                }
                playerSender.setGameMode(GameMode.CREATIVE);
                sender.sendMessage(ChatColor.GRAY + "Gamemode set to creative.");
                return true;
            }
        }
        else
        {
            sender.sendMessage(noPermissionException);
            return true;
        }
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
            Player target = Bukkit.getPlayer(args[0]);
            if (target == null)
            {
                sender.sendMessage(playerNotFoundException);
                return true;
            }
            if (target == sender)
            {
                sender.sendMessage(ChatColor.GRAY + "Correct usage: /creative *or* /gmc");
                return true;
            }
            target.setGameMode(GameMode.CREATIVE);
            sender.sendMessage(ChatColor.GRAY + "Set " + target.getName() + "'s gamemode to creative.");
            target.sendMessage(ChatColor.GRAY + sender.getName() + " set your gamemode to creative.");
            return true;
        }
    }
}
