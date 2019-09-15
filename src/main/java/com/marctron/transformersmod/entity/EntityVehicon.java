package com.marctron.transformersmod.entity;

import com.marctron.transformersmod.util.handlers.LootTableHandler;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityVehicon extends EntitySkeleton  {

    public EntityVehicon(World worldIn) {
        super(worldIn);

    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4);

    }

    public EntitySkeleton createChild(EntityAgeable ageable) {
        return new EntityVehicon(world);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableHandler.VEHICON;
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

}
