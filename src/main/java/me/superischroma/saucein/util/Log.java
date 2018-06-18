package me.superischroma.saucein.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Log
{
    private static final Logger log = Logger.getLogger("Minecraft");
    private static final String tag = "[SauceIn]";
    public static void info(String string)
    {
        log.log(Level.INFO, "{0} {1}", new Object[]
        {
            tag, string
        });
    }
    public static void warning(String string)
    {
        log.log(Level.WARNING, "{0} {1}", new Object[]
        {
            tag, string
        });
    }
    public static void severe(String string)
    {
        log.log(Level.SEVERE, "{0} {1}", new Object[]
        {
            tag, string
        });
    }
}
