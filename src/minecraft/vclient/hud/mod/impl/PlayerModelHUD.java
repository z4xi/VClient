package vclient.hud.mod.impl;

import java.awt.Color;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiInventory;
import vclient.hud.mod.HudMod;

public class PlayerModelHUD extends HudMod{

	public PlayerModelHUD() {
		super("testMod", 5, 5);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw() {
		renderPlayer();
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		fr.drawString(name, getX(), getY(), -1);
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		
		GuiInventory.drawEntityOnScreen(10, 10, 10, 10, 10, mc.thePlayer);
		
		fr.drawString(name, getX(), getY(), -1);
		
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return fr.getStringWidth(name);
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}
	
	public void renderPlayer() {
		GuiInventory.drawEntityOnScreen(10, 10, 10, 10, 10, mc.thePlayer);
	}

}
