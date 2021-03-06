package vclient.util.config;

import java.io.File;
import java.io.IOException;

import vclient.VClient;
import vclient.hud.mod.HudMod;

public class Config {
	
	public File configFolder = new File("VClient");
	public File modsFolder = new File("VClient/Mods");
	
	public Configuration config, configToSave = ConfigurationAPI.newConfiguration(new File("VClient/Mods/ModConfiguration.vclient"));
	
	public void saveModConfig() {
		
		if(!configFolder.exists()) {
			configFolder.mkdirs();
		}
		
		if(!modsFolder.exists()) {
			modsFolder.mkdirs();
		}
		
		System.out.println("Saving Mod Config");
		
		for(HudMod m : VClient.INSTANCE.hudManager.hudMods) {
			configToSave.set(m.name.toLowerCase() + " x", m.getX());
			configToSave.set(m.name.toLowerCase() + " y", m.getY());
			configToSave.set(m.name.toLowerCase() + " enabled", m.isEnabled());
			
		}
		
		try {
			configToSave.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void loadModConfig() {
		
		System.out.println("Loading mod config");
		
		try {
			config = ConfigurationAPI.loadExistingConfiguration(new File("VClient/Mods/ModConfiguration.vclient"));
			System.out.println("Mod config loaded successfully!");
		} catch (IOException e) {
			System.out.println("Loading mod config failed. Stack trace below.");
			e.printStackTrace();
		}
	}

}
