package me.superischroma.saucein;

import me.superischroma.saucein.util.Log;
import me.superischroma.saucein.command.*;
import me.superischroma.saucein.rank.Rank;
import me.superischroma.saucein.util.SauceInPlus;
import net.pravian.aero.plugin.AeroPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class SauceIn extends AeroPlugin<SauceIn>
{
    private static SauceIn instance;
    public static SauceIn getInstance()
    {
        return instance;
    }
    public void registerListeners()
    {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new Rank(this), this);
    }
    @Override
    public void enable()
    {
        // Commands
        this.getCommand("creative").setExecutor(new Command_creative());
        this.getCommand("survival").setExecutor(new Command_survival());
        this.getCommand("totalfreedom").setExecutor(new Command_totalfreedom());
        this.getCommand("opall").setExecutor(new Command_opall());
        this.getCommand("deopall").setExecutor(new Command_deopall());
        this.getCommand("op").setExecutor(new Command_op());
        this.getCommand("deop").setExecutor(new Command_deop());
        this.getCommand("opme").setExecutor(new Command_opme());
        this.getCommand("list").setExecutor(new Command_list());
        Log.info("Loaded " + SauceInPlus.commandSize + " commands.");
        instance = this;
        registerListeners();
        this.saveDefaultConfig();
        Log.info("Loaded all events.");
        Log.info("Enabled.");
    }
    @Override
    public void disable()
    {
        Log.info("Disabled.");
        instance = null;
    }
}
