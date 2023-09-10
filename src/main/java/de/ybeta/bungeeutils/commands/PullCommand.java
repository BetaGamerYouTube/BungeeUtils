package de.ybeta.bungeeutils.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PullCommand extends Command {

    public PullCommand() {
        super("pull", "bu.pull");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent("§cERROR: You must be a player to use this command."));
            return;
        }
        if (args.length != 1) {
            sender.sendMessage(new TextComponent("§cUsage: /pull <player>"));
            return;
        }

        ProxiedPlayer targetPlayer = ProxyServer.getInstance().getPlayer(args[0]);
        if (targetPlayer == null) {
            sender.sendMessage(new TextComponent("§cERRPR: Player not found."));
            return;
        }

        ProxiedPlayer player = (ProxiedPlayer) sender;
        targetPlayer.connect(player.getServer().getInfo());
        sender.sendMessage(new TextComponent("§7You have pulled " + targetPlayer.getName() + " to your server (" + player.getServer().getInfo().getName() + ")."));
        targetPlayer.sendMessage(new TextComponent("§7You have been pulled to " + player.getName() + "'s server (" + player.getServer().getInfo().getName() + ")."));
    }

}
