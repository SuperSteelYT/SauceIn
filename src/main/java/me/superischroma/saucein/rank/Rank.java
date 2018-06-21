package me.superischroma.saucein.rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.superischroma.saucein.ChatManagement;
import me.superischroma.saucein.SauceIn;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class Rank implements Listener
{
    // Some variables
    private final Plugin plug = SauceIn.getPlugin(SauceIn.class);
    SauceIn plugin;
    
    public Rank(SauceIn instance)
    {
        this.plugin = instance;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        // Some more variables
        Player eplayer = event.getPlayer();
        String eplayername = eplayer.getName();
        String eplayerdname = eplayer.getDisplayName();
        // Login messages
        String operatorlm = ChatColor.GREEN + eplayername + " is an " + ChatColor.GOLD + "Op";
        String sauceadminlm = ChatColor.GREEN + eplayername + " is a " + ChatColor.RED + "Sauce Admin";
        String seniorsauceadminlm = ChatColor.GREEN + eplayername + " is a " + ChatColor.DARK_AQUA + "Senior Sauce Admin";
        String developerlm = ChatColor.GREEN + eplayername + " is a " + ChatColor.LIGHT_PURPLE + "Developer";
        String ownerlm = ChatColor.GREEN + eplayername + " is the Owner";
        // Sauce Admin Login
        if (plugin.getConfig().getStringList("sauce_admins").contains(eplayername))
        {
            Bukkit.broadcastMessage(sauceadminlm);
            ChatManagement.publicchat.add(eplayer);
            eplayer.setOp(true);
        }
        // Senior Sauce Admin Login
        else if (plugin.getConfig().getStringList("senior_sauce_admins").contains(eplayername))
        {
            Bukkit.broadcastMessage(seniorsauceadminlm);
            ChatManagement.publicchat.add(eplayer);
            eplayer.setOp(true);
        }
        // Developer Login
        else if (plugin.getConfig().getStringList("developers").contains(eplayername))
        {
            Bukkit.broadcastMessage(developerlm);
            ChatManagement.publicchat.add(eplayer);
            eplayer.setOp(true);
        }
        // Owner(s) Login
        else if (plugin.getConfig().getStringList("owners").contains(eplayername))
        {
            Bukkit.broadcastMessage(ownerlm);
            ChatManagement.publicchat.add(eplayer);
            eplayer.setOp(true);
        }
        // OP Login
        else if (!plugin.getConfig().getStringList("sauce_admins").contains(eplayername)
                && !plugin.getConfig().getStringList("senior_sauce_admins").contains(eplayername)
                && !plugin.getConfig().getStringList("developers").contains(eplayername)
                && !plugin.getConfig().getStringList("owners").contains(eplayername)
                && event.getPlayer().isOp())
        {
            Bukkit.broadcastMessage(operatorlm);
            ChatManagement.publicchat.add(eplayer);
            eplayer.setOp(true);
        }
        // Just gives the player op incase of a new player
        else
        {
            eplayer.setOp(true);
        }
    }
}
