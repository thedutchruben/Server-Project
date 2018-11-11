package nl.thedutchruben.bungeecord;

import net.md_5.bungee.api.plugin.Plugin;
import nl.thedutchruben.bungeecord.motd.MotdModule;
import nl.thedutchruben.bungeecord.utils.Config;

public final class Bungeecord extends Plugin {
    private MotdModule motdModule;
    private static Bungeecord instance;
    private Config serverconfig;
    private Settings settings;
    @Override
    public void onEnable() {
        // Plugin startup logic

        instance = this;

        serverconfig = new Config(this,"config.yml");

        settings =  new Settings();

        //startdatabase

        //loadmotd

        motdModule = new MotdModule(this);

        serverconfig.save();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public Config getServerconfig() {
        return serverconfig;
    }

    public static Bungeecord getInstance() {
        return instance;
    }

    public MotdModule getMotdModule() {
        return motdModule;
    }

    public Settings getSettings() {
        return settings;
    }
}
