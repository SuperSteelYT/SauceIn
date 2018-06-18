package me.superischroma.saucein.util;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SauceInPlus
{
    CommandSender sender;
    public static final String consoleException = ChatColor.RED + "You cannot execute this command from console!";
    public static final String playerNotFoundException = ChatColor.GRAY + "Player not found!";
    public static final String noPermissionException = ChatColor.RED + "No permission.";
    public static final String giveOperatorAction = ChatColor.DARK_PURPLE + "You are now an operator!";
    public static final Integer commandSize = 7;
    protected void msg(String message)
    {
        sender.sendMessage(ChatColor.GRAY + message);
    }
    protected void msg(String message, ChatColor color)
    {
        sender.sendMessage(color + message);
    }
    protected void msg(Player player, String message)
    {
        player.sendMessage(message);
    }
}
