package net.simpvp.BungeeEventlist;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;


public class BungeeEventlist extends Plugin {

    @Override
    public void onEnable(){
    	ProxyServer.getInstance().getPluginManager().registerCommand(this, new EventlistCommand());
    }
	
	
}
