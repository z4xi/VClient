package vclient.mod.impl;

import vclient.event.EventTarget;
import vclient.event.impl.EventUpdate;
import vclient.mod.Category;
import vclient.mod.Mod;

public class ToggleSprint extends Mod {
	
	public ToggleSprint() {
		super("ToggleSprint", "Toggle your sprinting status", Category.MOVEMENT);
	}
	
	@EventTarget
	public void onUpdate(EventUpdate event) {
		if(this.isEnabled() 
				&& !mc.thePlayer.isBlocking() 
				&& !mc.thePlayer.isSneaking() 
				&& (mc.thePlayer.motionX != 0 && mc.thePlayer.motionZ != 0) ) {
			mc.thePlayer.setSprinting(true);
		}
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
		
		mc.thePlayer.setSprinting(false);
	}
	
}
