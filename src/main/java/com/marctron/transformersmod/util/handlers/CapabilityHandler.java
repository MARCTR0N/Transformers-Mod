package com.marctron.transformersmod.util.handlers;

import com.marctron.transformersmod.capabilities.DefaultEntityAnimator;
import com.marctron.transformersmod.capabilities.EntityAnimatorProvider;
import com.marctron.transformersmod.util.Reference;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class CapabilityHandler {

	public static final Animation PUNCH_ANIMATION = null;

	 private static final Animation[] ANIMATIONS = {
			 PUNCH_ANIMATION
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
		
		if (entity.hasCapability(EntityAnimatorProvider.ANIMATED_ENTITY_CAP, null)) {
			IAnimatedEntity animator = entity.getCapability(EntityAnimatorProvider.ANIMATED_ENTITY_CAP, null);
			animator.setAnimationTick(animator.getAnimationTick() + 1);
		}
		
		//set animations here I guess, or you could move this event to a new class.
		Animation PUNCH_ANIMATION = Animation.create(130);
		
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
			public void readNBT(Capability<IAnimatedEntity> capability, IAnimatedEntity instance, EnumFacing side, NBTBase nbt) {}
		}, DefaultEntityAnimator::new);
	}

	
	
}
