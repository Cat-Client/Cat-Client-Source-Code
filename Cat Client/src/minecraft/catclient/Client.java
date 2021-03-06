package catclient;

import catclient.discord.DiscordRP;
import catclient.event.EventManager;
import catclient.event.EventTarget;
import catclient.event.impl.ClientTickEvent;
import catclient.gui.SplashProgress;
import catclient.gui.hud.HUDManager;
import catclient.mods.ModInstances;
import catclient.util.SessionChanger;
import net.minecraft.client.Minecraft;

public class Client {

	private static final Client INSTANCE = new Client();
	public static final Client getInstance() { return INSTANCE; }

	private DiscordRP discordRP = new DiscordRP();
	private HUDManager hudManager;
	
	public void init() {
		SplashProgress.setProgress(1, "Starting Minecraft");
		discordRP.start();
		EventManager.register(this);
	}
	
	public void start() {
		SessionChanger.getInstance().setUser("harry.printz@gmail.com", "Pythag0ra5");
		
		hudManager = HUDManager.getInstance();
		ModInstances.register(hudManager);
	}
	 
	public void shutdown() {
		discordRP.shutdown();
	}
	
	public DiscordRP getDiscordRP() {
		return discordRP;
	}
	
	@EventTarget
	public void onTick(ClientTickEvent e) {
		if (Minecraft.getMinecraft().gameSettings.CLIENT_GUI_MOD_POS.isPressed()) {
			hudManager.openConfigScreen();
		}
	}
	
}
