package com.marctron.transformersmod.util.handlers;

import java.util.Random;
import java.util.concurrent.Delayed;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.capabilities.DefaultEntityAnimator;
import com.marctron.transformersmod.capabilities.EntityAnimatorProvider;
import com.marctron.transformersmod.items.gun.IGun;
import com.marctron.transformersmod.items.gun.ItemGunBase;
import com.marctron.transformersmod.util.Reference;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationAI;
import net.ilexiconn.llibrary.server.animation.AnimationHandler;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemAir;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import java.util.concurrent.TimeUnit;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class CapabilityHandler {

    public static final Animation PUNCH_ANIMATION = Animation.create(10);
    public static final Animation AXE_ANIMATION = Animation.create(12);
    public static final Animation SWORD_ANIMATION = Animation.create(12);
    public static final Animation AXE_REVERSE_ANIMATION = Animation.create(12);
    public static final Animation SWORD_REVERSE_ANIMATION = Animation.create(12);

    public static final Animation RELOAD_ANIMATION = Animation.create(18);

    public static boolean isReloading;
    public static boolean isAttacking = false;
    public static boolean isAnimDone = false;

    private static int attacks;
    private static int sword;
    protected static Random rand = new Random();


    public static AnimationAI currentAnim = null;

    private static final Animation[] ANIMATIONS = {
            PUNCH_ANIMATION,
            RELOAD_ANIMATION,
            AXE_ANIMATION,
            SWORD_ANIMATION
    };

    @SubscribeEvent
    public static void capAttachEventEntity(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof EntityPlayer) {
            event.addCapability(new ResourceLocation(Reference.MOD_ID, "animator"), new EntityAnimatorProvider(event.getObject()));
        }
    }

    @SubscribeEvent
    public static void onEntityTick(LivingUpdateEvent event) {

        EntityLivingBase entity = event.getEntityLiving();

        IAnimatedEntity animator = null;


        if (entity.world.isRemote && entity instanceof EntityPlayer) {
            if (entity.hasCapability(EntityAnimatorProvider.ANIMATED_ENTITY_CAP, null)) {
                animator = entity.getCapability(EntityAnimatorProvider.ANIMATED_ENTITY_CAP, null);
                animator.setAnimationTick(animator.getAnimationTick() + 1);
            }

//			if (entity.isSwingInProgress && entity.swingProgressInt == 0) {
//				entity.isSwingInProgress = false;

//			isReloading=true;
            boolean playingAnimation = false;

            for (Animation animation : ANIMATIONS) {
                if (animator.getAnimation() == animation) {
                    playingAnimation = true;
                }
            }

            if (!playingAnimation && Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown() && !isAttacking) {
                isAttacking = true;
                ItemStack stack = entity.getHeldItemMainhand();

                //- - - - - - - - -
                if (stack.getItem() instanceof ItemHoe) {
                	if(sword==0) {
                        animator.setAnimation(SWORD_REVERSE_ANIMATION);
                        sword ++;
                    	}else
                        if(sword >0) {
                        animator.setAnimation(SWORD_ANIMATION);
                        sword --;
                        }


                } else {
                    //- - - - - - - - -

                    if (stack.getItem() instanceof ItemSword) {
                    	if(sword==0) {
                        animator.setAnimation(SWORD_REVERSE_ANIMATION);
                        sword ++;
//                        System.out.println("sword = 0");
                    	}else
                        if(sword >0) {
                        animator.setAnimation(SWORD_ANIMATION);
                        sword --;
//                        System.out.println("sword = 1");
                        }
                    } else {

                        if (stack.getItem() instanceof ItemAxe) {
                                animator.setAnimation(AXE_ANIMATION);
//                           
                        } else {

                            if (stack.getItem() instanceof ItemAir) {
                                animator.setAnimation(PUNCH_ANIMATION);
                            }
                        }
                    }


                }


            }

            if (!Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown()){
                isAttacking = false;
            }

            if (Minecraft.getMinecraft().gameSettings.keyBindUseItem.isKeyDown() && Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown()) {
//				ClientProxy.RELOAD.isPressed()
                if (entity instanceof EntityPlayer) {
                    ItemStack stack = ((EntityPlayer) entity).getHeldItemMainhand();


                    if (stack.getItem() instanceof com.marctron.transformersmod.items.gun.Scrapper || stack.getItem() instanceof IGun) {
                        animator.setAnimation(RELOAD_ANIMATION);
                    }


                }


            }


        }

        //set animations here I guess, or you could move this event to a new class.

    }

    public static Animation[] getAnimations() {
        return ANIMATIONS;
    }


    public static void registerCaps() {
        CapabilityManager.INSTANCE.register(IAnimatedEntity.class, new IStorage<IAnimatedEntity>() {
            @Override
            public NBTBase writeNBT(Capability<IAnimatedEntity> capability, IAnimatedEntity instance, EnumFacing side) {
                return null;
            }

            @Override
            public void readNBT(Capability<IAnimatedEntity> capability, IAnimatedEntity instance, EnumFacing side, NBTBase nbt) {
            }
        }, DefaultEntityAnimator::new);
    }


}
