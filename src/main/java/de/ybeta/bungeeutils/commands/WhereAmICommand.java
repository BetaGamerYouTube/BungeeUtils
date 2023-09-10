package de.ybeta.bungeeutils.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class WhereAmICommand extends Command {

    public WhereAmICommand() {
        super("whereami", "bu.whereami", "whereis", "find");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 0 && sender instanceof ProxiedPlayer) {
            ProxiedPlayer player = (ProxiedPlayer) sender;
            ServerInfo info = player.getServer().getInfo();
            player.sendMessage(new TextComponent("§7You are currently on §b" + info.getName()));
        } else if (args.length == 1) {
            ProxiedPlayer player = ProxyServer.getInstance().getPlayer(args[0]);
            if (player != null) {
                ServerInfo info = player.getServer().getInfo();
                sender.sendMessage(new TextComponent("§7" + player.getName() + " is currently on §b" + info.getName()));
            } else {
                sender.sendMessage(new TextComponent("§cERROR: Player not found!"));
            }
        } else {
            sender.sendMessage(new TextComponent("§cUsage: /whereami (Player)"));
        }
    }
}
