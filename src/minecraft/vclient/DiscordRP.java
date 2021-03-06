package vclient;

import net.arikia.dev.drpc.*;
import net.arikia.dev.drpc.DiscordRichPresence.Builder;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

public class DiscordRP {
	
	private boolean running = true;
	private long created = 0;
	
	public void start() {
		
		this.created = System.currentTimeMillis();
		
		DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(new ReadyCallback() {

			@Override
			public void apply(DiscordUser user) {
				System.out.println("Welcome, " + user.username + "#" + user.discriminator + "!");
				update("Launching", "");
				
			}
			
		}).build();
		
		DiscordRPC.discordInitialize("886146407319363636", handlers, true);
		
		new Thread("Discord RPC Callbacks") {
			
			@Override
			public void run() {
				while(running) {
					DiscordRPC.discordRunCallbacks();
				}
			}
			
			
		}.start();
		
	}
	
	public void shutdown() {
		running  = false;
		DiscordRPC.discordShutdown();
	}
	
	public void update(String firstLine, String secondLine) {
		DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(secondLine);
		b.setBigImage("vclient-logo", "Vex Client");
		b.setDetails(firstLine);
		b.setStartTimestamps(created);
		
		DiscordRPC.discordUpdatePresence(b.build());
	}
	
}
