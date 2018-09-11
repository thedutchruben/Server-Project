package nl.thedutchruben;

import org.bukkit.plugin.java.JavaPlugin;

public class ServerCore extends JavaPlugin {
    private static ServerCore instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    public static ServerCore getInstance() {
        return instance;
    }
}
