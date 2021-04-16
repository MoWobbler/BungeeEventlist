package net.simpvp.BungeeEventlist;


import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;


public class EventlistCommand extends Command {
	
    public EventlistCommand() {
        super("eventlist");
   }
	

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		ProxiedPlayer player = null;
		if (sender instanceof ProxiedPlayer){
			player = (ProxiedPlayer) sender;
		}
		
		String players = "";
		int playerAmount = 0;
		
		BungeeCord.getInstance().getServerInfo("EventWorld").getPlayers();
		
		for(ProxiedPlayer p: BungeeCord.getInstance().getServerInfo("EventWorld").getPlayers()){
				players += p.getDisplayName() + ", ";
				playerAmount += 1;
	        }
		
		/* Remove the final ", " */
		if (playerAmount > 0)
			players = players.substring(0, players.length() - 2);

		String message = null;

		/* Only players should get the fancy colors, a console should just get a plain message. */
		if (player != null) {
			message = ChatColor.GOLD + "There are " + ChatColor.AQUA + playerAmount + ChatColor.GOLD +  " players currently on the event server: " + ChatColor.AQUA;	
		} else {
			message = "There are " + playerAmount + " players currently on the event server: ";
		}
		
		/* If there aren't any eventPlayers, don't post a blank empty line */
		if (playerAmount > 0)
			message += "\n" + players;

		if (player != null) {
			player.sendMessage(new ComponentBuilder(message).create());
		} else {
			BungeeCord.getInstance().getLogger().info(message);
		}
		
		
		
		return;
	}

}
