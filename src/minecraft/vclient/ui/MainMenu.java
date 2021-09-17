package vclient.ui;

import java.awt.Color;
import java.io.IOException;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import vclient.VClient;

public class MainMenu extends GuiScreen{
	
	public ResourceLocation logo = new ResourceLocation("vclient/vclient-logo.png");
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		mc.getTextureManager().bindTexture(new ResourceLocation("vclient/main_menu.png"));
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
		
		GlStateManager.pushMatrix();
		GlStateManager.translate(width/2f, height/2f, 0);
		GlStateManager.scale(3, 3, 1);
		GlStateManager.translate(-(width/2f), -(height/2f), 0);
		this.drawCenteredString(mc.fontRendererObj, VClient.INSTANCE.NAME, width/2f, height/2f - mc.fontRendererObj.FONT_HEIGHT/2f, -1);
		GlStateManager.popMatrix();
		super.drawScreen(mouseX, mouseY, partialTicks);
		mc.fontRendererObj.drawStringWithShadow(VClient.INSTANCE.VERSION, width/2f + 80, height/2f - mc.fontRendererObj.FONT_HEIGHT * 2f, -1);
		mc.fontRendererObj.drawStringWithShadow(VClient.INSTANCE.DISCORDURL, width/2f - 65, height/2f + 255- mc.fontRendererObj.FONT_HEIGHT * 2f, -1);
		mc.fontRendererObj.drawStringWithShadow(VClient.INSTANCE.YTURL, width/2f + 120, height/2f + 255- mc.fontRendererObj.FONT_HEIGHT * 2f, -1);
		mc.fontRendererObj.drawStringWithShadow(VClient.INSTANCE.DISCORDS, width/2f - 280, height/2f + 255- mc.fontRendererObj.FONT_HEIGHT * 2f, -1);
		
	}
	
	@Override
	public void initGui() {
		this.buttonList.add(new GuiButton(1, 10, height / 2 - 40, "Test Worlds"));
		this.buttonList.add(new GuiButton(2, 10, height / 2 - 15, "Servers"));
		this.buttonList.add(new GuiButton(3, 10, height / 2 + 10, "Options n' Stuff"));
		this.buttonList.add(new GuiButton(4, 10, height / 2 + 35, "Rage Quit"));
		super.initGui();
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button.id == 1) {
			mc.displayGuiScreen(new GuiSelectWorld(this));
		}
		if(button.id == 2) {
			mc.displayGuiScreen(new GuiMultiplayer(this));
		}
		if(button.id == 3) {
			mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
		}
		if(button.id == 4) {
			mc.shutdown();
		}
		super.actionPerformed(button);
	}
	
}