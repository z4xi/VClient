package vclient;

import vclient.gui.SplashProgress;

public class Client {
	
	private static final Client INSTANCE = new Client();
	public static final Client getInstance() { 
		return INSTANCE; 
	}
	
	private DiscordRP discordRP = new DiscordRP();
	
	public void init() {
		SplashProgress.setProgress(1, "Vex Client - Discord RP");
		discordRP.start();
	}
	
	public void shutdown() {
		discordRP.shutdown();
	}
	
	public DiscordRP getDiscordRP() {
		return discordRP;
	}
	
}
