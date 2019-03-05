package com.marctron.transformersmod.events;

import com.marctron.transformersmod.proxy.ClientProxy;


import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class ClientEvents {
	
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) {
		if (ClientProxy.MY_KEYBINDING.isKeyDown() ) {
			Minecraft.getMinecraft().player.sendMessage(new TextComponentString ("*Transformation*") );
			
			
			
			
			
		
		}
	}

}
