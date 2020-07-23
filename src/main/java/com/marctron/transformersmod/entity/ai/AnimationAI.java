package com.marctron.transformersmod.entity.ai;

import com.marctron.transformersmod.entity.EntityDecepticon;
import com.marctron.transformersmod.entity.EntityDecepticonVehiconBrute;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;

public class AnimationAI <T extends EntityDecepticon & IAnimatedEntity> extends net.ilexiconn.llibrary.server.animation.AnimationAI<T> {
    protected Animation animation;

    public AnimationAI(T entity, Animation animation) {
        super(entity);
        this.animation = animation;
    }

    public AnimationAI(T entity, Animation animation, boolean interruptsAI) {
        super(entity);
        this.animation = animation;
        if (!interruptsAI) {
            setMutexBits(8);
        }
    }

    public AnimationAI(EntityDecepticonVehiconBrute entity, Animation animation) {
    	super((T) entity);
        this.animation = animation;
	}

	@Override
    public Animation getAnimation() {
        return animation;
    }

    @Override
    public boolean isAutomatic() {
        return true;
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
        entity.currentAnim = this;
    }

    @Override
    public void resetTask() {
        super.resetTask();
        entity.currentAnim = null;
    }
}