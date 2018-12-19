package nl.thedutchruben.bungeecord;

import nl.thedutchruben.bungeecord.utils.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Settings {
    Config config = Bungeecord.getInstance().getServerconfig();
    private String prefix;
    private String motd;
    private List<String> players = new ArrayList<>();


    //Database
    private boolean database;
    private String databasehostname;
    private int port;
    private String username;
    private String password;

    public Settings(){
        prefix = getString("Server.Prefix","[SERVERCORE]");
        setMotd(getString("Server.motd","SERVER-PROJECT"));
        List<String> strings = new ArrayList<>();
        strings.add("Welkom to my server!");
        players.addAll(getString("Server.playerlist", strings));
    }

    public String getMotd() {
        return motd;
    }



    public void setMotd(String motd) {
        this.motd = motd;
    }

    public List<String> getPlayers(){
        return players;
    }
    public String getString(String path,String def){
        if(config.getConfiguration().get(path) == null){
            config.getConfiguration().set(path,def);
            config.save();
            return def;
        }else{
            return config.getConfiguration().getString(path);
        }
    }
    public List<String> getString(String path,List<String> def){
        if(config.getConfiguration().get(path) == null){
            config.getConfiguration().set(path,def);
            config.save();
            return def;
        }else{
            return (List<String>)config.getConfiguration().getList(path);
        }
    }
}
