package com.marctron.transformersmod.util.handlers;

import com.marctron.transformersmod.util.helper.TFRenderHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent;

public class ClientTickHandler {
	
	

    private Minecraft mc = Minecraft.getMinecraft();

    private EntityRenderer renderer, prevRenderer;
    public static float renderTick;
	
	@SubscribeEvent
    public void onRenderTick(RenderTickEvent event)
    {
        World world = mc.world;
        renderTick = event.renderTickTime;

        if (world != null)
        {
            if (event.phase == event.phase.START)
            {
                EntityPlayer player = mc.player;

//                if (TFRenderHelper.shouldOverrideView(player))
//                {
//                    if (renderer == null)
//                    {
//                        renderer = new EntityRendererTF(mc);
//                    }
//
//                    if (mc.entityRenderer != renderer)
//                    {
//                        prevRenderer = mc.entityRenderer;
//                        mc.entityRenderer = renderer;
//                    }
//                }
//                else 
                	if (prevRenderer != null && mc.entityRenderer == renderer)
                {
                    mc.entityRenderer = prevRenderer;
                }
            }

//            if (mc.thePlayer != null)
//            {
//                EntityPlayer player = mc.thePlayer;
//                Transformer transformer = TFHelper.getTransformer(player);
//
//                if (TFRenderHelper.shouldOverrideThirdPersonDistance(player))
//                {
//                    if (transformer != null)
//                    {
//                        float thirdPersonDistance = 4 - TFHelper.getTransformationTimer(player) * 2;
//                        int altMode = TFData.ALT_MODE.get(player);
//
//                        if (transformer != null && transformer.canZoom(player) && TFHelper.isFullyTransformed(player) && TFKeyBinds.keyBindingZoom.getIsKeyPressed() && !TFKeyBinds.keyBindingViewFront.getIsKeyPressed())
//                        {
//                            thirdPersonDistance = transformer.getZoomAmount(player, altMode);
//                        }
//                        else if (transformer != null)
//                        {
//                            thirdPersonDistance = transformer.getThirdPersonDistance(player, altMode);
//                        }
//
//                        TFReflection.setField(TFReflection.thirdPersonDistanceField, mc.entityRenderer, thirdPersonDistance);
//                    }
//                }
//            }
        }
    }

}
