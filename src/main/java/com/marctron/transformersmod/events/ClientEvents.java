package com.marctron.transformersmod.events;

import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;
import com.marctron.transformersmod.transformers.transformer.sideswipe.ArmorModelSideswipe;
import com.marctron.transformersmod.util.handlers.SoundsHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

import java.util.Timer;
import java.util.TimerTask;

public class ClientEvents {

    @SubscribeEvent
    public void onKeyInput(KeyInputEvent event) {
        if (ClientProxy.ALT_MODE.isKeyDown()) {
            //Minecraft.getMinecraft().player.sendMessage(new TextComponentString ("*Transformation*") );
            //Minecraft.getMinecraft().player.playSound(SoundEvents.ENTITY_BLAZE_HURT, 0.6F, 3F);
            //Minecraft.getMinecraft().player.playSound(SoundEvents.ENTITY_SHULKER_HURT_CLOSED, 1F, 3F);
            //Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMONE, 0.3F, 1.8F);
}


           
        
        if (ClientProxy.ROBOT_MODE.isKeyDown()) {
            //Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMTWO, 0.3F, 1.8F);
            //Minecraft.getMinecraft().player.sendMessage(new TextComponentString ("*Transformation*") );
            //Minecraft.getMinecraft().player.playSound(SoundEvents.ENTITY_BLAZE_HURT, 0.6F, 2F);
            //Minecraft.getMinecraft().player.playSound(SoundEvents.ENTITY_SHULKER_HURT_CLOSED, 1F, 1F);
            //Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMTWO, 1F, 1F);
        }
    }
    
    @SubscribeEvent
    public void onlivingRender(RenderLivingEvent.Pre event) {
    	//System.out.println("Player Render Event");
    	if (event.getEntity() instanceof AbstractClientPlayer) {
    		AbstractClientPlayer player = (AbstractClientPlayer) event.getEntity();
    		AbstractClientPlayer renderingPlayer = Minecraft.getMinecraft().player;
    		boolean flag = false;
    		for (ItemStack stack : player.getArmorInventoryList()) {
    			if (stack.getItem() instanceof ItemArmorTransformer) {
    				if (!flag) {
    					double dx, dy, dz;
    					if (player.equals(renderingPlayer)) {
    						dx = dy = dz = 0;
    					}
    					else {
    						double x1 = (player.posX - player.prevPosX) * event.getPartialRenderTick() + player.prevPosX;
    						double y1 = (player.posY - player.prevPosY) * event.getPartialRenderTick() + player.prevPosY;
    						double z1 = (player.posZ - player.prevPosZ) * event.getPartialRenderTick() + player.prevPosZ;
    						
    						double x2 = (renderingPlayer.posX - renderingPlayer.prevPosX) * event.getPartialRenderTick() + renderingPlayer.prevPosX;
    						double y2 = (renderingPlayer.posY - renderingPlayer.prevPosY) * event.getPartialRenderTick() + renderingPlayer.prevPosY;
    						double z2 = (renderingPlayer.posZ - renderingPlayer.prevPosZ) * event.getPartialRenderTick() + renderingPlayer.prevPosZ;
    						
    						dx = x1 - x2;
    						dy = y1 - y2;
    						dz = z1 - z2;
    					}
    					((ItemArmorTransformer)stack.getItem()).getRenderer().doRender(player, dx, dy, dz, player.getRotationYawHead(), event.getPartialRenderTick());
        				flag = true;
    				}
    			}
    		}
    		if (flag) {
    			event.setCanceled(true);
    		}
    	}
    }

}
