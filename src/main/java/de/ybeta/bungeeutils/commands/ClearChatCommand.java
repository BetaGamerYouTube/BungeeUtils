package de.ybeta.bungeeutils.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class ClearChatCommand extends Command {

    public ClearChatCommand() {
        super("clearchat", "bu.clearchat", "cc");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        ProxyServer.getInstance().getPlayers().forEach(player -> {
            if (!player.hasPermission("bu.clearchat")) {
                for (int i = 0; i < 100; i++) {
                    player.sendMessage(new TextComponent("§7 "));
                }
            }
            player.sendMessage(new TextComponent("§7 "));
            player.sendMessage(new TextComponent("§7The chat has been cleared by §c" + sender.getName()));
        });
    }

}
