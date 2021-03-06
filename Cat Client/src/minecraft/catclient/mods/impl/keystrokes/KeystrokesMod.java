package catclient.mods.impl.keystrokes;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import catclient.gui.hud.ScreenPosition;
import catclient.mods.ModDraggable;
import net.minecraft.client.gui.Gui;

public class KeystrokesMod extends ModDraggable {
	
	private ScreenPosition pos;
	private KeystrokesMode mode = KeystrokesMode.WASD_MOUSE;
	
	public void setMode(KeystrokesMode mode) {
		this.mode = mode;
	}
	
	@Override
	public int getWidth() {
		return mode.getWidth();
	}

	@Override
	public int getHeight() {
		return mode.getHeight();
	}

	@Override
	public void render(ScreenPosition pos) {
		GL11.glPushMatrix();
		
		boolean blend = GL11.glIsEnabled(GL11.GL_BLEND);
		
		GL11.glDisable(GL11.GL_BLEND);
		
		for (Key key: mode.getKeys()) {
			int textWidth = font.getStringWidth(key.getName());
			Gui.drawRect(
					pos.getAbsoluteX() + key.getX(), 
					pos.getAbsoluteY() + key.getY(), 
					pos.getAbsoluteX() + key.getX() + key.getWidth(),
					pos.getAbsoluteY() + key.getY() + key.getHeight(),
					key.isDown() ? new Color(255, 255, 255, 102).getRGB(): new Color(0, 0, 0, 102).getRGB());
			
			font.drawString(
					key.getName(), 
					pos.getAbsoluteX() + key.getX() + key.getWidth() / 2 - textWidth / 2, 
					pos.getAbsoluteY() + key.getY() + key.getHeight() / 2 - 4, 
					key.isDown() ? Color.black.getRGB() : Color.white.getRGB());
		}
		
		if (blend) {
			GL11.glEnable(GL11.GL_BLEND);
		}
		
		GL11.glPopMatrix();
	}

	@Override
	public void save(ScreenPosition pos) {
		this.pos = pos;
	}

	@Override
	public ScreenPosition load() {
		return pos;
	}

}
