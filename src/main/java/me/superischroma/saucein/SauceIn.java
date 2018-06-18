package me.superischroma.saucein;

import me.superischroma.saucein.util.Log;
import me.superischroma.saucein.command.*;
import me.superischroma.saucein.util.SauceInPlus;
import net.pravian.aero.plugin.AeroPlugin;

public class SauceIn extends AeroPlugin<SauceIn>
{
    @Override
    public void enable()
    {
        // Commands
        this.getCommand("creative").setExecutor(new Command_creative());
        this.getCommand("survival").setExecutor(new Command_survival());
        this.getCommand("totalfreedom").setExecutor(new Command_totalfreedom());
        this.getCommand("opall").setExecutor(new Command_opall());
        this.getCommand("op").setExecutor(new Command_op());
        this.getCommand("opme").setExecutor(new Command_opme());
        this.getCommand("list").setExecutor(new Command_list());
        Log.info("Loaded " + SauceInPlus.commandSize + " commands.");
        Log.info("Enabled.");
    }
    @Override
    public void disable()
    {
        Log.info("Disabled.");
    }
}
