package nl.thedutchruben.bungeecord.motd;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import nl.thedutchruben.bungeecord.motd.listeners.ProxyPingListener;

public class MotdModule {
    public MotdModule(Plugin plugin) {
        plugin.getProxy().getPluginManager().registerListener(plugin,new ProxyPingListener());
    }
}
