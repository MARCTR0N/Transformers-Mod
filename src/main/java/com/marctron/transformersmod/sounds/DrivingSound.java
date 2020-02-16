//package com.marctron.transformersmod.sounds;
//
//import net.minecraft.client.audio.ISound;
//import net.minecraft.client.audio.MovingSound;
//import net.minecraft.entity.item.EntityMinecart;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.init.SoundEvents;
//import net.minecraft.util.SoundCategory;
//import net.minecraft.util.math.MathHelper;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
//@SideOnly(Side.CLIENT)
//public class DrivingSound extends MovingSound {
////    private final EntityPlayer player;
////   
//	private final EntityPlayer player;
//    private float distance = 0.0F; 
//    public static boolean isPlayingSound = false;
////
//    public DrivingSound(EntityPlayer player) {
//        super(DetectDriving.bhopSoundEvent, SoundCategory.BLOCKS);
//        this.attenuationType = ISound.AttenuationType.NONE;
//        this.repeat = true;
//        this.repeatDelay = 0;
//        this.player = player;
//    }
////
//    public void update() {
//        DetectDriving.isPlayingSound = !this.isDonePlaying();
//        if (DetectDriving.isDriving) {
//            this.volume = 0.5f;
//            this.pitch = 1.0f;
//            this.xPosF = (float) this.player.posX;
//            this.yPosF = (float) this.player.posY;
//            this.zPosF = (float) this.player.posZ;
//        } else {
//            this.donePlaying = true;
//        }
//
//    }
//    
//   
//
////    public DrivingSound(EntityPlayer player)
////    {
////        super(DetectDriving.bhopSoundEvent, SoundCategory.NEUTRAL);
////        this.player = player;
////        this.repeat = true;
////        this.repeatDelay = 0;
////        
////    }
//
//    /**
//     * Like the old updateEntity(), except more generic.
//     */
////    public void update()
////    {
////        if (this.minecart.isDead)
////        {
////            this.donePlaying = true;
////        }
////        else
////    	DetectDriving.isPlayingSound = !this.isDonePlaying();
////    	if (DetectDriving.isDriving) 
////        {
////    		this.volume = 1F;
////            this.xPosF = (float)this.player.posX;
////            this.yPosF = (float)this.player.posY;
////            this.zPosF = (float)this.player.posZ;
////            float f = MathHelper.sqrt(this.player.motionX * this.player.motionX + this.player.motionZ * this.player.motionZ);
////
////            if ((double)f >= 0.01D)
////            {
////                this.distance = MathHelper.clamp(this.distance + 0.0025F, 0.0F, 1.0F);
////                this.volume = 0.0F + MathHelper.clamp(f, 0.0F, 0.5F) * 0.7F;
////            }
////            else
////            {
////                this.distance = 0.0F;
////                this.volume = 0.0F;
////                this.donePlaying = true;
////            }
////        }
////    	DetectDriving.isPlayingSound = !this.isDonePlaying();
////      if (DetectDriving.isDriving) {
////          this.volume = 0.5f;
////          this.pitch = 1.0f;
////          this.xPosF = (float) this.player.posX;
////          this.yPosF = (float) this.player.posY;
////          this.zPosF = (float) this.player.posZ;
////      } else {
////          this.donePlaying = true;
////      }
////    }
//
//}
