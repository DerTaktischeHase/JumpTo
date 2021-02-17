package de.teampresidency.jumpto.commands;

import de.teampresidency.jumpto.Main;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * User: Timo
 * Date: 08.02.2021
 * Time: 00:55
 */
public class JumpToCommand extends Command {


    public JumpToCommand(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            if(player.hasPermission("jumpto.use")) {
                if(args.length == 1) {
                    ProxiedPlayer target = BungeeCord.getInstance().getPlayer(args[0]);
                    if(target != null) {
                        if(!player.getServer().getInfo().equals(target.getServer().getInfo())) {
                            player.connect(target.getServer().getInfo());
                            player.sendMessage(Main.PREFIX + ChatColor.GREEN + "Du bist zu " + ChatColor.YELLOW + target.getName() + ChatColor.GREEN + " gesprungen");
                        } else
                            player.sendMessage(Main.PREFIX + ChatColor.RED + "Du bist bereits auf dem Server");
                    } else
                        player.sendMessage(Main.PREFIX + ChatColor.RED + "Der Spieler ist nicht online");
                } else
                    player.sendMessage(Main.PREFIX + ChatColor.RED + "Benutze /jumpto <Spieler>");
            } else
                player.sendMessage(Main.PREFIX + ChatColor.RED + "Dafür hast du keine Rechte");
        }
    }
}
