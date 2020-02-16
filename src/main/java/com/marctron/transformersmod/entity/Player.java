package com.marctron.transformersmod.entity;

import java.util.UUID;

import com.marctron.transformersmod.items.gun.IGun;
import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.deadend.Deadend;

import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@EventBusSubscriber(Side.CLIENT)
public class Player {

	
	
	private static UUID uuidHeight = UUID.fromString("5440b01a-974f-4495-bb9a-c7c87424bca4");
	private static UUID uuidWidth = UUID.fromString("3949d2ed-b6cc-4330-9c13-98777f48ea51");
	private static UUID uuidReach1 = UUID.fromString("854e0004-c218-406c-a9e2-590f1846d80b");
	private static UUID uuidReach2 = UUID.fromString("216080dc-22d3-4eff-a730-190ec0210d5c");
	private static UUID uuidHealth = UUID.fromString("3b901d47-2d30-495c-be45-f0091c0f6fb2");
	private static UUID uuidStrength = UUID.fromString("558f55be-b277-4091-ae9b-056c7bc96e84");
	private static UUID uuidSpeed = UUID.fromString("f2fb5cda-3fbe-4509-a0af-4fc994e6aeca");
	
	float size;
	
	public void PlayerTick(PlayerTickEvent event)
	{
		
		if (ClientProxy.ALT_MODE.isPressed()){
			System.out.println("please work");
		}
		
		
	}
	
	
    @SubscribeEvent
    public static void EntityRender(RenderLivingEvent.Pre event) {


        EntityLivingBase entity = event.getEntity();

        if (entity instanceof EntityPlayer) {
        
            EntityPlayer player = (EntityPlayer) entity;
           
            for (ItemStack stack : player.getArmorInventoryList()) {
    			if (!(stack.getItem() instanceof ItemArmorTransformer)) {
    				player.eyeHeight= 1.62F;
    				player.stepHeight=1;
    			}
    			
    		}
            
        
            if (entity instanceof EntityPlayer) {
                
               
                
                for (ItemStack stack : player.getArmorInventoryList()) {
        			if (stack.getItem() instanceof ItemArmorTransformer) {
        				
        			}
        		}
        	}
            
            
            if (player.getHeldItemMainhand().getItem() instanceof IGun) {

                RenderLivingBase renderer = event.getRenderer();

                ItemStack stack = event.getEntity().getHeldItemMainhand();

                ModelPlayer model = (ModelPlayer) renderer.getMainModel();
//                ModelMovieOptimusPrime advancedmodel =  (ModelMovieOptimusPrime) renderer.getMainModel();

                if (stack.getItem() instanceof IGun) {
//                    IGun nbt = ((IGun) stack.getItem());
//                    if (nbt.getBoolean("Gun")) {
//                        if (player.isSprinting()) {
//                            model.rightArmPose = ModelBiped.ArmPose.BLOCK;
////                          advancedmodel.rightArmPose = ModelBiped.ArmPose.BLOCK;
//                            
//                        } else
//                            model.leftArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
//                        	model.rightArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
////                        	advancedmodel.rightArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
////                        	advancedmodel.leftArmPose = ModelBiped.ArmPose.BOW_AND_ARROW;
//                    }
//
//                    if (nbt.getBoolean("running")) {
//                        if (player.getPrimaryHand() == EnumHandSide.LEFT) {
//                            model.leftArmPose = ModelBiped.ArmPose.BLOCK;
//                        } else {
//                            model.rightArmPose = ModelBiped.ArmPose.BLOCK;
//                        }
//                    }

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