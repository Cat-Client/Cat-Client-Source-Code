package catclient.mods;

import catclient.gui.SplashProgress;
import catclient.gui.hud.HUDManager;
import catclient.mods.impl.armorstatus.ArmorStatusMod;
import catclient.mods.impl.fps.FPSMod;
import catclient.mods.impl.keystrokes.KeystrokesMod;
import catclient.mods.impl.togglesprint.ToggleSprintMod;

public class ModInstances {
	private static ToggleSprintMod toggleSprintMod;
	private static ArmorStatusMod armorStatusMod;
	private static FPSMod fpsMod;
	private static KeystrokesMod keystrokesMod;
	
	public static void register(HUDManager api) {
		toggleSprintMod = new ToggleSprintMod();
		api.register(toggleSprintMod);
		
		armorStatusMod = new ArmorStatusMod();
		api.register(armorStatusMod);
		
		fpsMod = new FPSMod();
		api.register(fpsMod);
		
		keystrokesMod = new KeystrokesMod();
		api.register(keystrokesMod);
	}
}
