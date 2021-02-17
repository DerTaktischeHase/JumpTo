package de.teampresidency.jumpto;

import de.teampresidency.jumpto.commands.JumpToCommand;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * User: Timo
 * Date: 08.02.2021
 * Time: 00:54
 */
public class Main extends Plugin {
    public static String PREFIX = "§7[§6JumpTo§7]§r ";
    public static Main instance;
    @Override
    public void onEnable() {
    instance = this;
    }

    @Override
    public void onLoad() {
        BungeeCord.getInstance().getPluginManager().registerCommand(this, new JumpToCommand("jumpto"));
    }

    @Override
    public void onDisable() {

    }
}
