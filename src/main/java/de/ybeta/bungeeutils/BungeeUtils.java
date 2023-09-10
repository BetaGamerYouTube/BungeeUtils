package de.ybeta.bungeeutils;

import de.ybeta.bungeeutils.commands.*;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

public final class BungeeUtils extends Plugin {

    @Override
    public void onEnable() {
        PluginManager pluginManager = getProxy().getPluginManager();
        pluginManager.registerCommand(this, new PingCommand());
        pluginManager.registerCommand(this, new StaffChatCommand());
        pluginManager.registerCommand(this, new WhereAmICommand());
        pluginManager.registerCommand(this, new ClearChatCommand());
        pluginManager.registerCommand(this, new JumpToCommand());
        pluginManager.registerCommand(this, new PullCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
