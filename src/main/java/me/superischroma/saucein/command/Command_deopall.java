package me.superischroma.saucein.command;

import me.superischroma.saucein.util.SauceInPlus;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_deopall extends SauceInPlus implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("deopall"))
        {
            if (sender.hasPermission("saucein.deopall"))
            {
                Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + sender.getName() + " * Revoking operator from everyone on the server");
                for (Player p : Bukkit.getOnlinePlayers())
                {
                    p.setOp(false);
                    p.sendMessage(revokeOperatorAction);
                }
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
