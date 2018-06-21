package me.superischroma.saucein;

import me.superischroma.saucein.util.SauceInPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import java.util.ArrayList;
import me.superischroma.saucein.rank.Rank;
import me.superischroma.saucein.util.Log;

public class ChatManagement extends SauceInPlus implements Listener
{
    public static ArrayList<Player> publicchat = new ArrayList<Player>();
    public static ArrayList<Player> adminchat = new ArrayList<Player>();
    public static boolean adminchattoggle = false;
    SauceIn plugin;
    public ChatManagement(SauceIn instance)
    {
        this.plugin = instance;
    }
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event)
    {
        Player p = event.getPlayer();

        if (publicchat.contains(p))
        {
            event.setCancelled(true);
            adminchattoggle = false;
                if (plugin.getConfig().getStringList("sauce_admins").contains(p.getName()))
                {
                    Bukkit.broadcastMessage(ChatColor.RED + "[Sauce Admin] " + p.getDisplayName() + ": " + event.getMessage());
                }
                else if (plugin.getConfig().getStringList("senior_sauce_admins").contains(p.getName()))
                {
                    Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "[Sr. Sauce Admin] " + p.getDisplayName() + ": " + event.getMessage());
                }
                else if (plugin.getConfig().getStringList("developers").contains(p.getName()))
                {
                    Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "[Developer] " + p.getDisplayName() + ": " + event.getMessage());
                }
                else if (plugin.getConfig().getStringList("owners").contains(p.getName()))
                {
                    Bukkit.broadcastMessage(ChatColor.GREEN + "[Owner] " + p.getDisplayName() + ": " + event.getMessage());
                }
                else if (!plugin.getConfig().getStringList("sauce_admins").contains(p.getName())
                        && !plugin.getConfig().getStringList("senior_sauce_admins").contains(p.getName())
                        && !plugin.getConfig().getStringList("developers").contains(p.getName())
                        && !plugin.getConfig().getStringList("owners").contains(p.getName())
                        && p.isOp())
                {
                    Bukkit.broadcastMessage(p.getDisplayName() + ": " + event.getMessage());
                }
                else
                {
                    Bukkit.broadcastMessage(p.getDisplayName() + ": " + event.getMessage());
                }
        }
        else if (adminchat.contains(p))
        {
            event.setCancelled(true);
            adminchattoggle = true;
            if (plugin.getConfig().getStringList("sauce_admins").contains(p.getName())
                && plugin.getConfig().getStringList("senior_sauce_admins").contains(p.getName())
                && plugin.getConfig().getStringList("developers").contains(p.getName())
                && plugin.getConfig().getStringList("owners").contains(p.getName())
                && p.isOp())
            {
                for (Player player : Bukkit.getOnlinePlayers())
                {
                    player.sendMessage(ChatColor.RED + "[SAUCEADMIN] " + ChatColor.GOLD + p.getName() + ChatColor.RESET + ": " + ChatColor.AQUA + event.getMessage());
                    Log.info("[SAUCEADMIN] " + p.getName() + ": " + event.getMessage());
                }
            }
        }
    }
}
