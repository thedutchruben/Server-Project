package nl.thedutchruben.bungeecord.motd.listeners;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import nl.thedutchruben.bungeecord.Bungeecord;
import nl.thedutchruben.bungeecord.Settings;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProxyPingListener implements Listener {

    @EventHandler
    public void onPing(ProxyPingEvent event) {
       ServerPing ping = event.getResponse();
        ServerPing.Players players = ping.getPlayers();
        ServerPing.Protocol version = ping.getVersion();
        version.setName("1.0 -1.13.1");
        version.setProtocol(version.getProtocol());

        players.setOnline(0);
        players.setMax(0);
        List<ServerPing.PlayerInfo> playerInfos = new ArrayList<>();
        Bungeecord.getInstance().getSettings().getPlayers().forEach(s -> {
            playerInfos.add(new ServerPing.PlayerInfo(s,UUID.randomUUID()));
        });


        players.setSample(playerInfos.toArray());

        ping.setPlayers(players);
        ping.setVersion(version);
        ping.setDescriptionComponent(new TextComponent(ChatColor.translateAlternateColorCodes('&',
                Bungeecord.getInstance().getSettings().getMotd()).replace("%n", "\n")));

        event.setResponse(ping);
    }
}
