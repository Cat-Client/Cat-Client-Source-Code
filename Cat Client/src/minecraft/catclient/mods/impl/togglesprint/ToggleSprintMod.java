package catclient.mods.impl.togglesprint;

import catclient.gui.hud.ScreenPosition;
import catclient.mods.ModDraggable;

public class ToggleSprintMod extends ModDraggable {

		private ScreenPosition pos = new ScreenPosition(0.75, 0.95);
		
		// settings
		public boolean flyBoost = true;
		public float flyBoostFactor = 4;
		public int keyHoldTicks = 7;

		@Override
		public int getWidth() {
			return font.getStringWidth(mc.thePlayer.movementInput.getDisplayText());
		}

		@Override
		public int getHeight() {
			return font.FONT_HEIGHT;
		}

		@Override
		public void render(ScreenPosition pos) {
			font.drawString(mc.thePlayer.movementInput.getDisplayText(), pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
		}
		
		@Override
		public void renderDummy(ScreenPosition pos) {
			font.drawString("[Sprinting (Toggled)]", pos.getAbsoluteX(), pos.getAbsoluteY(), -1);
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
