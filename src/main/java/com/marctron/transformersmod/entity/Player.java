package com.marctron.transformersmod.entity;

import com.marctron.transformersmod.items.gun.IGun;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@EventBusSubscriber(Side.CLIENT)
public class Player {


    @SubscribeEvent
    public static void EntityRender(RenderLivingEvent.Pre event) {


        EntityLivingBase entity = event.getEntity();

        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entity;
            if (player.getHeldItemMainhand().getItem() instanceof IGun) {

                RenderLivingBase renderer = event.getRenderer();

                ItemStack stack = event.getEntity().getHeldItemMainhand();

                ModelPlayer model = (ModelPlayer) renderer.getMainModel();

                if (stack.getItem() instanceof IGun) {
                    IGun nbt = ((IGun) stack.getItem());
                    if (nbt.getBoolean("Gun")) {
                        if (player.isSprinting()) {
                            model.rightArmPose = ModelBiped.ArmPose.BLOCK;
                        } else
                            model.leftArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
                        model.rightArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
                    }

                    if (nbt.getBoolean("running")) {
                        if (player.getPrimaryHand() == EnumHandSide.LEFT) {
                            model.leftArmPose = ModelBiped.ArmPose.BLOCK;
                        } else {
                            model.rightArmPose = ModelBiped.ArmPose.BLOCK;
                        }
                    }

                }

//                if(stack.getItem() instanceof StarscreamAltmode)
//        		{
//                	StarscreamAltmode nbt = ((StarscreamAltmode) stack.getItem());
//        			if (nbt.getBoolean("armor")) 
//        			{
//        				if (player.isSprinting()){
//        					model.rightArmPose = null;
//        				} else
//       				model.leftArmPose = null;
//                        model.rightArmPose = null;
//                    }

//        			if(nbt.getBoolean("running"))
//        			{
//        				if(player.getPrimaryHand() == EnumHandSide.LEFT)
//        				{
//        					model.leftArmPose = ModelBiped.ArmPose.BLOCK;
//        				}
//        				else
//        				{
//        					 model.rightArmPose = ModelBiped.ArmPose.BLOCK;
//        				}
//        			}
//        			
//        		}
//        		
//        		if(stack.getItem() instanceof GunAimable)
//        		{
//        			NBTTagCompound nbt2 = ((GunAimable) stack.getItem()).checkNBTTags(stack);
//        			if (nbt2.getBoolean("ADS")) 
//        			{
//        				model.rightArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
//        				model.leftArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
//                    }
//        			
//        			if(nbt2.getBoolean("running"))
//        			{
//        				if(player.getPrimaryHand() == EnumHandSide.LEFT)
//        				{
//        					model.leftArmPose = ModelBiped.ArmPose.BLOCK;
//        				}
//        				else
//        				{
//        					 model.rightArmPose = ModelBiped.ArmPose.BLOCK;
//        				}
//        			}
//        			
//        		}
            }
        }

    }


//	
//	@SubscribeEvent
//    public static void onRenderGameOverlayEvent(RenderGameOverlayEvent event) {
//        EntityPlayer player = Minecraft.getMinecraft().player;
//        if (event.getType() == RenderGameOverlayEvent.ElementType.CROSSHAIRS) {
//            if(player.getHeldItemMainhand().getItem() instanceof GunBase)
//            {
//            	
//            	ItemStack stack = player.getHeldItemMainhand();
//            	
//            	if(stack.getItem() instanceof GunAimableSkin)
//        		{
//        			NBTTagCompound nbt = ((GunAimableSkin) stack.getItem()).checkNBTTags(stack);
//        			if (nbt.getBoolean("ADS")) 
//        			{
//        				event.setCanceled(true);
//                    }
//        		}
//        		
//        		if(stack.getItem() instanceof GunAimable)
//        		{
//        			NBTTagCompound nbt2 = ((GunAimable) stack.getItem()).checkNBTTags(stack);
//        			if (nbt2.getBoolean("ADS")) 
//        			{
//        				event.setCanceled(true);
//                    }
//        		}
//            }
//        	
//        	
//        }
//    }

}