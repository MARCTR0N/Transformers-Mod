package com.marctron.transformersmod.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityVehicon extends EntitySkeleton
{

	public EntityVehicon(World worldIn) {
		super(worldIn);
	
	}
	
	public EntitySkeleton createChild(EntityAgeable ageable)
	{
		return new EntityVehicon(world);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return super.getAmbientSound();
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return super.getHurtSound(source);
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return super.getDeathSound();
	}

}
