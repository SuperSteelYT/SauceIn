package me.superischroma.saucein.util;

import me.superischroma.saucein.SauceIn;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

public class SauceInPlus
{
    public static final String consoleException = ChatColor.RED + "You cannot execute this command from console!";
    public static final String playerNotFoundException = ChatColor.GRAY + "Player not found!";
    public static final String noPermissionException = ChatColor.RED + "No permission.";
    public static final String giveOperatorAction = ChatColor.DARK_PURPLE + "You are now an operator!";
    public static final String revokeOperatorAction = ChatColor.DARK_PURPLE + "You are no longer an operator!";
    public static final Integer commandSize = 10;
    public static final Plugin plugin = SauceIn.getPlugin(SauceIn.class);
}
