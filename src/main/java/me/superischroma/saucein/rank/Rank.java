package me.superischroma.saucein.rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import me.superischroma.saucein.SauceIn;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Rank implements Listener
{
    SauceIn plugin;
    public Rank(SauceIn instance)
    {
        this.plugin = instance;
    }
    // Sauce Admins
    public static final List<String> sauceAdminList = Arrays.asList("");
    // Senior Sauce Admins
    public static final List<String> seniorSauceAdminList = Arrays.asList
    (
        "Telnet_"
    );
    // Developers
    public static final List<String> developerList = Arrays.asList
    (
        "Super_"
    );
    // Owner
    public static final List<String> owners = Arrays.asList("");
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player eplayer = event.getPlayer();
        String eplayername = eplayer.getName();
        String eplayerdname = eplayer.getDisplayName();
        // Ranks
        String sauceadmin = ChatColor.RED + "[Sauce Admin] " + eplayerdname + ChatColor.RESET + "";
        String seniorsauceadmin = ChatColor.DARK_AQUA + "[Senior Sauce Admin] " + eplayerdname + ChatColor.RESET + "";
        String developer = ChatColor.LIGHT_PURPLE + "[Developer] " + eplayerdname + ChatColor.RESET + "";
        String owner = ChatColor.GREEN + "[Owner] " + eplayerdname + ChatColor.RESET + "";

        if (sauceAdminList.contains(eplayername))
        {
            eplayer.setDisplayName(sauceadmin);
        }
        else if (seniorSauceAdminList.contains(eplayername))
        {
            eplayer.setDisplayName(seniorsauceadmin);
        }
        else if (developerList.contains(eplayername))
        {
            eplayer.setDisplayName(developer);
        }
        else if (owners.contains(eplayername))
        {
            eplayer.setDisplayName(owner);
        }
    }
}
