package catclient.servers;

import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.ResourceLocation;

public class ServerFeaturedData extends ServerData {
	
	public static final ResourceLocation ICON = new ResourceLocation("catclient/sponsored.png");

	public ServerFeaturedData(String serverName, String serverIP) {
		super(serverName, serverIP, false);
	}
	
}
