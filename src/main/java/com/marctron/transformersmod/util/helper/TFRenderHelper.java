package com.marctron.transformersmod.util.helper;

import java.util.Map;
import java.util.WeakHashMap;

import com.marctron.transformersmod.util.handlers.ClientTickHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class TFRenderHelper {

	private static Minecraft mc = Minecraft.getMinecraft();
	private static final Map<EntityPlayer, Double> previousMotionY = new WeakHashMap<EntityPlayer, Double>();
	
	 public static double getMotionY(EntityPlayer player)
	    {
	        double current = player == mc.player ? player.motionY : player.posY - player.prevPosY;
	        double previous = previousMotionY.containsKey(player) ? previousMotionY.get(player) : 0.0;

	        return TFHelper.median(current, previous, ClientTickHandler.renderTick);
	    }
	 
//	 public static boolean shouldOverrideView(EntityPlayer player)
//	    {
//	        return TFHelper.getHeight(player) != 1.8F || TFHelper.getScale(player) != 1;
//	    }
}
