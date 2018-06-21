package me.superischroma.saucein;

import me.superischroma.saucein.util.Log;
import me.superischroma.saucein.command.*;
import me.superischroma.saucein.rank.Rank;
import me.superischroma.saucein.util.SauceInPlus;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SauceIn extends JavaPlugin
{
    private static SauceIn instance;
    public static SauceIn getInstance()
    {
        return instance;
    }
    // Register listeners
    private void registerListeners()
    {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new Rank(this), this);
        pm.registerEvents(new ChatManagement(this), this);
    }
    private void registerConfig()
    {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
    // Register all commands
    private void registerCommands()
    {
        this.getCommand("creative").setExecutor(new Command_creative());
        this.getCommand("survival").setExecutor(new Command_survival());
        this.getCommand("totalfreedom").setExecutor(new Command_totalfreedom());
        this.getCommand("opall").setExecutor(new Command_opall());
        this.getCommand("deopall").setExecutor(new Command_deopall());
        this.getCommand("op").setExecutor(new Command_op());
        this.getCommand("deop").setExecutor(new Command_deop());
        this.getCommand("opme").setExecutor(new Command_opme());
        this.getCommand("list").setExecutor(new Command_list());
        this.getCommand("rank").setExecutor(new Command_rank());
        this.getCommand("adminchat").setExecutor(new Command_adminchat());
        this.getCommand("saucein").setExecutor(new Command_saucein());
    }
    @Override
    public void onEnable()
    {
        registerCommands();
        Log.info("Loaded " + SauceInPlus.commandSize + " commands.");
        instance = this;
        registerListeners();
        Log.info("Loaded all events.");
        registerConfig();
        Log.info("Loaded configuration file.");
        Log.info("Enabled.");
    }
    @Override
    public void onDisable()
    {
        Log.info("Disabled.");
        instance = null;
    }
}
