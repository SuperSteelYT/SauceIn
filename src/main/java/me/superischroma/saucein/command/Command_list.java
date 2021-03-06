package me.superischroma.saucein.command;

import me.superischroma.saucein.rank.Rank;
import me.superischroma.saucein.util.SauceInPlus;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.List;
import static me.superischroma.saucein.rank.Rank.*;

public class Command_list extends SauceInPlus implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        List<String> pnames = new ArrayList<String>();
        StringBuilder stats = new StringBuilder();
        StringBuilder players = new StringBuilder();
        stats.append(ChatColor.AQUA)
                .append("There are ")
                .append(ChatColor.DARK_AQUA)
                .append(Bukkit.getOnlinePlayers().size())
                .append(ChatColor.AQUA)
                .append(" out of a maximum ")
                .append(ChatColor.DARK_AQUA)
                .append(Bukkit.getMaxPlayers())
                .append(ChatColor.AQUA)
                .append(" online currently.");
        for (Player all : Bukkit.getOnlinePlayers())
        {
            String tag;
            if (plugin.getConfig().getStringList("senior_sauce_admins").contains(sender.getName()))
            {
                tag = (ChatColor.DARK_AQUA + "[SrSA]");
            }
            else if (plugin.getConfig().getStringList("senior_sauce_admins").contains(sender.getName()))
            {
                tag = (ChatColor.RED + "[SA]");
            }
            else if (plugin.getConfig().getStringList("developers").contains(sender.getName()))
            {
                tag = (ChatColor.LIGHT_PURPLE + "[Dev]");
            }
            else if (plugin.getConfig().getStringList("owners").contains(sender.getName()))
            {
                tag = (ChatColor.GREEN + "[Owner]");
            }
            else if (!plugin.getConfig().getStringList("sauce_admins").contains(sender.getName())
                        && !plugin.getConfig().getStringList("senior_sauce_admins").contains(sender.getName())
                        && !plugin.getConfig().getStringList("developers").contains(sender.getName())
                        && !plugin.getConfig().getStringList("owners").contains(sender.getName())
                        && sender.isOp())
            {
                tag = (ChatColor.GOLD + "[Op]");
            }
            else
            {
                tag = (ChatColor.BLUE + "[Non-Op]");
            }
            pnames.add(tag + " " + all.getName() + ChatColor.RESET);
        }
        players.append(ChatColor.DARK_AQUA)
                .append("Connected users: ")
                .append(StringUtils.join(pnames, ", "));
        if (cmd.getName().equalsIgnoreCase("list"))
        {
            sender.sendMessage(stats.toString());
            sender.sendMessage(players.toString());
            return true;
        }
        return false;
    }
}
