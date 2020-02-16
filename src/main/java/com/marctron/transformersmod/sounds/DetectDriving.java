//package com.marctron.transformersmod.sounds;
//
//import com.marctron.transformersmod.Main;
//import com.marctron.transformersmod.network.packets.PacketDrivingSound;
//import com.marctron.transformersmod.network.packets.tf.TFNetworkManager;
//import com.marctron.transformersmod.util.handlers.SoundsHandler;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.init.SoundEvents;
//import net.minecraft.util.SoundCategory;
//import net.minecraft.util.SoundEvent;
//import net.minecraft.util.math.MathHelper;
//import net.minecraftforge.fml.client.FMLClientHandler;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//import net.minecraftforge.fml.common.gameevent.TickEvent;
//import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
//@SideOnly(Side.CLIENT)
//public class DetectDriving {
//
//    public static final SoundEvent bhopSoundEvent = SoundsHandler.CARDRIVE;
////    		SoundEvents.ENTITY_MINECART_RIDING;
////    		SoundEvents.BLOCK_DISPENSER_FAIL;
////    		new SoundEvent(new ResourceLocation(Reference.MOD_ID, "bhopsong"));
//    public static boolean isDriving = false;
//    public static boolean isPlayingSound = false;
////    private static final EntityPlayer client = new EntityPlayer();
//
//    private long lastPress = 0;
//	private long cooldownTime = 1000; // 1000 milliseconds	
//	private long time;
//
//    public final Minecraft mc = Minecraft.getMinecraft();
//
//    public static boolean modEnabled = true;
//
//    private static double getSpeed(EntityPlayer player)
//	{
//		return MathHelper.sqrt(player.motionX * player.motionX + player.motionZ * player.motionZ);
//	}
//    
//    @SubscribeEvent
//    public void doEveryTick(PlayerTickEvent event) {
//
////    	if (event.phase == TickEvent.Phase.END && modEnabled) {
//
//        if (player() == null || player().isElytraFlying() || player().isSpectator() || player().isInWater()) {
//            return;
//        }
//
//        double yeetThreshold = 0.35f;
//
//        if (getSpeed(player()) > yeetThreshold && !isDriving) {
//
//            Main.logger.info("Player has started bunnyhopping");
//            isDriving = true;
////            if (!isPlayingSound) {
////        		mc.getSoundHandler().playSound(new DrivingSound(player()));
////        	}
//
//        } else if (getSpeed(player()) < yeetThreshold - 0.06f && isDriving) {
//
//            Main.logger.info("Player has stopped bunnyhopping");
//            isDriving = false;
////            if (isPlayingSound) {
////        		mc.getSoundHandler().stopSound(new DrivingSound(player()));
////        	}
//        }
//        	if (isDriving && !isPlayingSound) {
//        		mc.getSoundHandler().playSound(new DrivingSound(player()));
//        	}
////    	}
//        
////        if(mc.gameSettings.keyBindForward.isPressed()){
////        	System.out.println("gagagugu");
////        	if(!isPlayingSound){
////        	mc.getSoundHandler().playSound(new DrivingSound(player()));
////        	}
////        }
//        
//    }
//
//
//
//    public static EntityPlayer player() {
//        return FMLClientHandler.instance().getClientPlayerEntity();
//    }
//
//
//
//}