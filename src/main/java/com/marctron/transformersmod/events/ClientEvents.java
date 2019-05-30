package com.marctron.transformersmod.events;

import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.util.Reference;
import com.marctron.transformersmod.util.handlers.SoundsHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class ClientEvents {
	
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event) 
	{
		if (ClientProxy.MY_KEYBINDING.isKeyDown() )
		{
			//Minecraft.getMinecraft().player.sendMessage(new TextComponentString ("*Transformation*") );
			//Minecraft.getMinecraft().player.playSound(SoundEvents.ENTITY_BLAZE_HURT, 0.6F, 3F);
			//Minecraft.getMinecraft().player.playSound(SoundEvents.ENTITY_SHULKER_HURT_CLOSED, 1F, 3F);
			//Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMONE, 0.3F, 1.8F);
			
		}
		if (ClientProxy.ROBOT_MODE.isKeyDown() ) 
		{
			//Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMTWO, 0.3F, 1.8F);	
			//Minecraft.getMinecraft().player.sendMessage(new TextComponentString ("*Transformation*") );
			//Minecraft.getMinecraft().player.playSound(SoundEvents.ENTITY_BLAZE_HURT, 0.6F, 2F);
			//Minecraft.getMinecraft().player.playSound(SoundEvents.ENTITY_SHULKER_HURT_CLOSED, 1F, 1F);
			//Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMTWO, 1F, 1F);
		}
	}

}
