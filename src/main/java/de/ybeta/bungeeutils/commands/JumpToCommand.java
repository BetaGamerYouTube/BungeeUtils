package de.ybeta.bungeeutils.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class JumpToCommand extends Command {

    public JumpToCommand() {
        super("jumpto", "bu.jumpto"); // Command name and permission node
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof ProxiedPlayer)) {
            sender.sendMessage(new TextComponent("§cERROR: You must be a player to use this command."));
            return;
        }
        if (args.length != 1) {
            sender.sendMessage(new TextComponent("§cUsage: /jumpto <player>"));
            return;
        }

        ProxiedPlayer targetPlayer = ProxyServer.getInstance().getPlayer(args[0]);
        if (targetPlayer == null) {
            sender.sendMessage(new TextComponent("§cERROR: Player not found."));
            return;
        }

        ProxiedPlayer player = (ProxiedPlayer) sender;
        player.connect(targetPlayer.getServer().getInfo());
        sender.sendMessage(new TextComponent("§7You have been teleported to " + targetPlayer.getName() + "'s Server (" + targetPlayer.getServer().getInfo().getName() + ")."));
    }

}
