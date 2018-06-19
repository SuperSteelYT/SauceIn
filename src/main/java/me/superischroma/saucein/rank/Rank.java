package me.superischroma.saucein.rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.superischroma.saucein.SauceIn;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
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
    // Sauce Admin list
    public static final List<String> sauceAdminList = Arrays.asList
    (
        "Emliei"
    );
    // Senior Sauce Admin list
    public static final List<String> seniorSauceAdminList = Arrays.asList
    (
        "Shadowsynth"
    );
    // Developer list
    public static final List<String> developerList = Arrays.asList
    (
        "Super_"
    );
    // Owner list
    public static final List<String> owners = Arrays.asList
    (
        "Telnet_"
    );
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
        if (sauceAdminList.contains(eplayername))
        {
            Bukkit.broadcastMessage(sauceadminlm);
        }
        // Senior Sauce Admin Login
        else if (seniorSauceAdminList.contains(eplayername))
        {
            Bukkit.broadcastMessage(seniorsauceadminlm);
        }
        // Developer Login
        else if (developerList.contains(eplayername))
        {
            Bukkit.broadcastMessage(developerlm);
        }
        // Owner(s) Login
        else if (owners.contains(eplayername))
        {
            Bukkit.broadcastMessage(ownerlm);
        }
        // OP Login
        else if (!sauceAdminList.contains(eplayername) 
                && !seniorSauceAdminList.contains(eplayername) 
                && !developerList.contains(eplayername)
                && !owners.contains(eplayername)
                && event.getPlayer().isOp())
        {
            Bukkit.broadcastMessage(operatorlm);
        }
    }
}
