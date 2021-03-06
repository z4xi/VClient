package vclient.ui.clickgui;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import vclient.VClient;
import vclient.ui.clickgui.comp.ModButton;

public class ClickGUI extends GuiScreen {
	
	ArrayList<ModButton> modButtons = new ArrayList<>();
	
	@Override
	public void initGui() {
		this.modButtons.add(new ModButton(270, 60, 55, mc.fontRendererObj.FONT_HEIGHT + 5, VClient.INSTANCE.hudManager.targetHud));
		this.modButtons.add(new ModButton(350, 60, 66, mc.fontRendererObj.FONT_HEIGHT + 5, VClient.INSTANCE.hudManager.fps));
		this.modButtons.add(new ModButton(420, 60, 88, mc.fontRendererObj.FONT_HEIGHT + 5, VClient.INSTANCE.hudManager.keystrokes));
		super.initGui();
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ScaledResolution sr = new ScaledResolution(mc);
		super.drawScreen(mouseX, mouseY, partialTicks);
		
		this.drawDefaultBackground();
		
		for(ModButton m : modButtons) {
			m.draw();
		}
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		for(ModButton m : modButtons) {
			m.onClick(mouseX, mouseY, mouseButton);
		}
	}

}
