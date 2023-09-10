package de.ybeta.bungeeutils.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PingCommand extends Command {

    public PingCommand() {
        super("ping", "bu.ping");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 0 && sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            int ping = player.getPing();
            sender.sendMessage(new TextComponent("§7Your ping is §b" + ping + "ms"));
        } else if (args.length == 1) {
            ProxiedPlayer player = ProxyServer.getInstance().getPlayer(args[0]);
            if (player != null) {
                int ping = player.getPing();
                sender.sendMessage(new TextComponent("§7" + player.getName() + "'s ping is §b" + ping + "ms"));
            } else {
                sender.sendMessage(new TextComponent("§cERROR: Player not found!"));
            }
        } else {
            sender.sendMessage(new TextComponent("§cUsage: /ping (Player)"));
        }
    }
}
