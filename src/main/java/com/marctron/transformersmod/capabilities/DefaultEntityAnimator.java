package com.marctron.transformersmod.capabilities;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;

public class DefaultEntityAnimator implements IAnimatedEntity {
	
	Animation currentAnimation = IAnimatedEntity.NO_ANIMATION;
	int tick = 0;

	@Override
	public int getAnimationTick() {
		return tick;
	}

	@Override
	public void setAnimationTick(int tick) {
		if (currentAnimation != IAnimatedEntity.NO_ANIMATION) {
			this.tick = tick;
			if (tick > currentAnimation.getDuration()) {
				this.tick = 0;
				this.currentAnimation = IAnimatedEntity.NO_ANIMATION;
			}
		}
	}

	@Override
	public Animation getAnimation() {
		return currentAnimation;
	}

	@Override
	public void setAnimation(Animation animation) {
		currentAnimation = animation;
	}

	@Override
	public Animation[] getAnimations() {
		return null;
	}

}
