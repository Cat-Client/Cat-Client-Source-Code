package catclient.mods.impl.keystrokes;

import net.minecraft.client.Minecraft;

public enum KeystrokesMode {
	WASD(Key.W, Key.A, Key.S, Key.D),
	WASD_MOUSE(Key.W, Key.A, Key.S, Key.D, Key.LMB, Key.RMB),
	WASD_SPRINT(Key.W, Key.A, Key.S, Key.D, new Key("Sprint", Minecraft.getMinecraft().gameSettings.keyBindInventory, 1, 41, 58, 18)),
	WASD_SPRINT_MOUSE(Key.W, Key.A, Key.S, Key.D, new Key("Sprint", Minecraft.getMinecraft().gameSettings.keyBindInventory, 1, 41, 58, 18), Key.LMB, Key.RMB)
	;
	
	private final Key[] keys;
	private int width = 0;
	private int height = 0;
	
	private KeystrokesMode(Key... keys) {
		 this.keys = keys;
		
		for (Key key : keys) {
			this.width = Math.max(this.width, key.getX() + key.getWidth());
			this.height = Math.max(this.width, key.getY() + key.getHeight());
		}
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public Key[] getKeys() {
		return keys;
	}
}
