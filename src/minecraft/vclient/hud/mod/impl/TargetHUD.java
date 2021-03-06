package vclient.hud.mod.impl;

import java.awt.Color;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLivingBase;
import vclient.hud.mod.HudMod;

public class TargetHUD extends HudMod{
	
	EntityLivingBase target;

	public TargetHUD() {
		super("TargetHUD", 5, 5);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw() {
		renderTargetHud();
		
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		
		Gui.drawRect(getX(), getY(), getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 170).getRGB());
		fr.drawStringWithShadow("Target Name", getX() + 2, getY() + 2, -1);
		fr.drawStringWithShadow(mc.thePlayer.getHealth() + " \u2764", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);
		GuiInventory.drawEntityOnScreen(getX() + fr.getStringWidth("Target Name") + 10, getY() + 40, 20, 50, 0, mc.thePlayer);
		
		
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return 100;
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT * 2 + 25;
	}
	
	private void renderTargetHud() {
		target = (EntityLivingBase) mc.pointedEntity;
		
		if(target != null) {
		fr.drawStringWithShadow(target.getName(), getX() + 2, getY() + 2, -1);
		fr.drawStringWithShadow(target.getHealth() + " \u2764", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);
		GuiInventory.drawEntityOnScreen(getX() + fr.getStringWidth(target.getName()) + 10, getY() + 40, 20, 50, 0, target);
		}
	}

}
