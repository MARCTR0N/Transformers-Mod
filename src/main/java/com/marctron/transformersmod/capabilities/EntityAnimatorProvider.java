package com.marctron.transformersmod.capabilities;

import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class EntityAnimatorProvider implements ICapabilityProvider {

	@CapabilityInject(IAnimatedEntity.class)
	public static final Capability<IAnimatedEntity> ANIMATED_ENTITY_CAP = null;
	
	private IAnimatedEntity instance;
	
	public EntityAnimatorProvider(Entity entity) {
		if (entity instanceof EntityPlayer) {
			instance = new DefaultEntityAnimator();
		}
		else {
			instance = new DefaultEntityAnimator();
		}
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == ANIMATED_ENTITY_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return hasCapability(capability, facing) ? ANIMATED_ENTITY_CAP.cast(instance) : null;
	}

}
