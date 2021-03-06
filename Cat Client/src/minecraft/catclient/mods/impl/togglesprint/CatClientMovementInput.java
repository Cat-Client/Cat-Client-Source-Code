package catclient.mods.impl.togglesprint;

import java.text.DecimalFormat;

import catclient.mods.ModInstances;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.potion.Potion;
import net.minecraft.util.MovementInput;

public class CatClientMovementInput extends MovementInput {
	
	// Default Movement Input
	private boolean sprint = false;
	private boolean flying = false;
	private GameSettings gameSettings;
	private Minecraft mc;
	
	// Toggle Sprint
	private boolean toggled;
	private int wasPressed;
	private int keyHoldTicks;
	
	public CatClientMovementInput(GameSettings gameSettings) {
		this.gameSettings = gameSettings;
		this.mc = Minecraft.getMinecraft();
		this.keyHoldTicks = 7;
	}
	
	@Override
	public void updatePlayerMoveState() {
		// Update Variables
		flying = mc.thePlayer.capabilities.isFlying;
		sprint = this.mc.thePlayer.isSprinting();
		
		// Default Minecraft Movement
		this.moveStrafe = 0.0F;
        this.moveForward = 0.0F;

        if (this.gameSettings.keyBindLeft.isKeyDown()) {
            ++this.moveForward;
        }

        if (this.gameSettings.keyBindRight.isKeyDown()) {
            --this.moveForward;
        }

        if (this.gameSettings.keyBindBack.isKeyDown()){
            ++this.moveStrafe;
        }

        if (this.gameSettings.keyBindJump.isKeyDown()) {
            --this.moveStrafe;
        }

        this.jump = this.gameSettings.keyBindSneak.isKeyDown();
        this.sneak = this.gameSettings.keyBindSprint.isKeyDown();

        if (this.sneak) {
            this.moveStrafe = (float)((double)this.moveStrafe * 0.3D);
            this.moveForward = (float)((double)this.moveForward * 0.3D);
        }
        
        // Toggle Sprint Stuff
        if (this.mc.gameSettings.keyBindInventory.isKeyDown()) {
        	if (this.wasPressed == 0) {
        		if (this.toggled) {
        			this.wasPressed = -1;
        		} else if (flying) {
        			this.wasPressed = this.keyHoldTicks + 1;
        		} else {
        			this.wasPressed = 1;
        		}
        		this.toggled = !this.toggled;
        	} else if (this.wasPressed > 0) {
        		++this.wasPressed;
        	}
        } else {
        	if (this.keyHoldTicks > 0 && this.wasPressed > this.keyHoldTicks) {
        		this.toggled = false;
        	}
        	this.wasPressed = 0;
        }
        if (this.toggled) {
        	this.mc.thePlayer.setSprinting(true);
        }
	}
	
	private static final DecimalFormat df = new DecimalFormat("#.0");
	public String getDisplayText() {
		String displayText = "";
		
		if (sprint) {
			if (toggled) {
				displayText = "[Sprinting (Toggled)]";
			} else {
				displayText = "[Sprinting (Vanilla)]";
			}
		}
		 
		if (sneak) {
			displayText = "[Sneaking (Vanilla)]";
		}
		
		if (flying) {
			displayText = "[Flying]";
		}
		
		if (displayText == "" && toggled) {
			displayText = "[Sprinting (Toggled)]";
		}
		
		return displayText.trim();
	}
	
}
