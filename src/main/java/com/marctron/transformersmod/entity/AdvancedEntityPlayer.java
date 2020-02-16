//package com.marctron.transformersmod.entity;
//
//import com.mojang.authlib.GameProfile;
//
//import net.ilexiconn.llibrary.server.animation.Animation;
//import net.ilexiconn.llibrary.server.animation.AnimationHandler;
//import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.entity.EntityPlayerSP;
//import net.minecraft.client.network.NetHandlerPlayClient;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.init.MobEffects;
//import net.minecraft.init.SoundEvents;
//import net.minecraft.potion.PotionEffect;
//import net.minecraft.stats.RecipeBook;
//import net.minecraft.stats.StatisticsManager;
//import net.minecraft.util.math.MathHelper;
//import net.minecraft.world.World;
//
//public class AdvancedEntityPlayer extends EntityPlayerSP implements IAnimatedEntity{
//
//	 public AdvancedEntityPlayer(Minecraft p_i47378_1_, World p_i47378_2_, NetHandlerPlayClient p_i47378_3_,
//			StatisticsManager p_i47378_4_, RecipeBook p_i47378_5_) {
//		super(p_i47378_1_, p_i47378_2_, p_i47378_3_, p_i47378_4_, p_i47378_5_);
//		// TODO Auto-generated constructor stub
//	}
//
//	public static final Animation ATTACK_ANIMATION = Animation.create(50);
//	 
//	 private static final Animation[] ANIMATIONS = {		        
//		        ATTACK_ANIMATION,		     
//		    };
//	
//	
//	
//	
//	
//	 @Override
//   public void onUpdate() {
//       super.onUpdate();
//       
//       if(Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown()){
//    	   AnimationHandler.INSTANCE.sendAnimationMessage(this, ATTACK_ANIMATION);
//       }
//       
//	 }
//	 
//	 
////    @Override
////    public void onUpdate() {
////        super.onUpdate();
////
//////        if (getAnimation() == NO_ANIMATION) {
//////            setActive(true);
//////            swingDirection = false;
//////            AnimationHandler.INSTANCE.sendAnimationMessage(this, ATTACK_THRICE_ANIMATION);
//////        }
////
////        if (getAttackTarget() != null && (getAttackTarget().isDead || getAttackTarget().getHealth() <= 0)) setAttackTarget(null);
////
////        if (!world.isRemote) {
////            if (getAnimation() == NO_ANIMATION && !isAIDisabled()) {
////                if (isActive()) {
////                    if (getAttackTarget() == null && moveForward == 0 && isAtRestPos()) {
////                        AnimationHandler.INSTANCE.sendAnimationMessage(this, DEACTIVATE_ANIMATION);
////                        setActive(false);
////                    }
////                } else if (getAttackTarget() != null && targetDistance <= 5) {
////                    AnimationHandler.INSTANCE.sendAnimationMessage(this, ACTIVATE_ANIMATION);
////                    setActive(true);
////                }
////            }
////            ticksSinceLastStomp++;
////        }
////
//////        if (!isActive()) {
//////            posX = prevPosX;
//////            posZ = prevPosZ;
//////            rotationYaw = prevRotationYaw;
//////        }
////        else if (world.isRemote) {
//////            MMParticle.ORB.spawn(world, leftEyePos.x, leftEyePos.y, leftEyePos.z, ParticleFactory.ParticleArgs.get().withData(0d, 0d, 0d, 247d / 256d, 94d / 256d, 74d / 256d, 1d, 25));
//////            MMParticle.ORB.spawn(world, rightEyePos.x, rightEyePos.y, rightEyePos.z, ParticleFactory.ParticleArgs.get().withData(0d, 0d, 0d, 247d / 256d, 94d / 256d, 74d / 256d, 1d, 25));
////        }
////        renderYawOffset = rotationYaw;
////
////        
////           
////           
////                                    {
////                        
////                            AnimationHandler.INSTANCE.sendAnimationMessage(this, ATTACK_ANIMATION);
////                           
////                        
////                    
////                
////            }
////                 
////    }
//
//
//	@Override
//	public boolean isSpectator() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isCreative() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	
//	@Override
//	public int getAnimationTick() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public void setAnimationTick(int tick) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Animation getAnimation() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void setAnimation(Animation animation) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Animation[] getAnimations() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
