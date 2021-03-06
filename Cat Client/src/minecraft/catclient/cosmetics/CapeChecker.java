package catclient.cosmetics;

import net.minecraft.client.entity.AbstractClientPlayer;

public class CapeChecker {
	
	private static final String[] VALID_NAMES = {"JynxToggled", "CatToggled", "Blendersound", "_terminal__", "VoidSmelt", "Tiger_The_Cat_"};
	private static final String[] CAPE_LOCATIONS = {
			"airclient/airclient", 
			"custom/elliotcape", 
			"custom/bencape", 
			"airclient/cloud", 
			"catclient/catclientdark", 
			"catclient/catclientlight"
	};
	
	public static boolean ownsCape(AbstractClientPlayer entitylivingbaseIn) {
		for (String name : VALID_NAMES) {
			if (entitylivingbaseIn.getName().equals(name)) {
				return true;
			}
		}
		
		return false;
	}

}
