package com.marctron.transformersmod.transformers;

import net.ilexiconn.llibrary.server.animation.Animation;

public interface IAnimatedArmor {
	/**
     * An empty animation container.
     */
    Animation NO_ANIMATION = Animation.create(0);

    /**
     * @return the current animation tick
     */
    int getAnimationTick();

    /**
     * Sets the current animation tick to the given value.
     *
     * @param tick the new tick
     */
    void setAnimationTick(int tick);

    /**
     * @return the current playing animation
     */
    Animation getAnimation();

    /**
     * Sets the currently playing animation.
     *
     * @param animation the new animation
     */
    void setAnimation(Animation animation);

    /**
     * @return an array of all the Animations this entity can play
     */
    Animation[] getAnimations();
}
