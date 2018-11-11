package nl.thedutchruben.bungeecord;

import nl.thedutchruben.bungeecord.utils.Config;

public class Settings {
    Config config = Bungeecord.getInstance().getServerconfig();
    private String prefix;

    private String motd;

    public String getMotd() {
        return motd;
    }

    public void setMotd(String motd) {
        this.motd = motd;
    }

    //Database
    private boolean database;
    private String databasehostname;
    private int port;
    private String username;
    private String password;

    public Settings(){
        prefix = getString("Server.Prefix","[SERVERCORE]");
        motd = getString("Server.motd","SERVER-PROJECT");
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
}
