package com.marctron.transformersmod.entity.ai;

import com.marctron.transformersmod.entity.EntityDecepticon;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;

public class AnimationActivateAI<T extends EntityDecepticon & IAnimatedEntity> extends AnimationAI<T> {
    public AnimationActivateAI(T entity, Animation animation) {
        super(entity, animation);
    }

    @Override
    public void resetTask() {
        super.resetTask();
        entity.active = true;
    }
}