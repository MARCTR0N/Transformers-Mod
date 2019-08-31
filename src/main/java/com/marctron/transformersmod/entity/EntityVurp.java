package com.marctron.transformersmod.entity;

import com.marctron.transformersmod.util.handlers.LootTableHandler;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.AnimationAI;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityVurp extends EntitySkeleton implements IAnimatedEntity {

	private Animation animation = NO_ANIMATION;
	private int animationTick;
	
	public static final Animation ANIMATION_WALK = Animation.create(60);
	public static final Animation ANIMATION_ATTACK = Animation.create(120);
	
	private static final Animation[] ANIMATIONS = {ANIMATION_WALK, ANIMATION_ATTACK};
	public AnimationAI currentAnim;
	
	
    public EntityVurp(World worldIn) {
        super(worldIn);

    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(25);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4);

    }

    public EntitySkeleton createChild(EntityAgeable ageable) {
        return new EntityVurp(world);
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

	@Override
	public int getAnimationTick() {
		
		return animationTick;
	}

	@Override
	public void setAnimationTick(int tick) {
		animationTick = tick;
		
	}

	@Override
	public Animation getAnimation() {
		
		return this.animation;
	}

	@Override
	public void setAnimation(Animation animation) {
		if(animation == NO_ANIMATION)
		{
			onAnimationFinish(this.animation);
			setAnimationTick(0);
		}
		this.animation = animation;
	}

	private void onAnimationFinish(Animation animation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Animation[] getAnimations() {
		
		return ANIMATIONS;
	}
	
	

}
