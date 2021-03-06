package catclient.mods;

import catclient.gui.hud.IRenderer;
import catclient.gui.hud.ScreenPosition;

public abstract class ModDraggable extends Mod implements IRenderer {

	public final int getLineOffset(ScreenPosition pos, int lineNumber) {
		return pos.getAbsoluteY() + getLineOffset(lineNumber);
	}

	private int getLineOffset(int lineNumber) {
		return (font.FONT_HEIGHT + 3) * lineNumber;
	}
	
}
