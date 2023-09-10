package de.ybeta.bungeeutils.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Command;

public class StaffChatCommand extends Command {

    public StaffChatCommand() {
        super("staffchat", "bu.staffchat", "sc", "teamchat", "tc");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(new TextComponent("§cUsage: /staffchat <message>"));
            return;
        }

        StringBuilder builder = new StringBuilder();
        for (String arg : args) {
            builder.append(arg).append(" ");
        }
        String message = builder.toString().trim();

        TextComponent formattedMessage = new TextComponent("§cStaffChat §8• §e" + sender.getName() + " §8| §f" + message);

        ProxyServer.getInstance().getPlayers().stream()
                .filter(player -> player.hasPermission("bu.staffchat"))
                .forEach(player -> player.sendMessage(formattedMessage));

        ProxyServer.getInstance().getConsole().sendMessage(formattedMessage);
    }
}
