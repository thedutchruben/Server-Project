package nl.thedutchruben.bungeecord.utils;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {
    private Configuration configuration;
    private File file;

    public Config(Plugin plugin, String fileName) {
        try {
            if (!(plugin.getDataFolder().exists())) {
                plugin.getDataFolder().mkdir();
            }
            this.file = new File(plugin.getDataFolder(), fileName);
            if (!(this.file.exists())) {
                this.file.createNewFile();
            }
            this.configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(this.file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void save() {
        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(this.configuration, this.file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public File getFile() {
        return file;
    }

}
