package com.marctron.transformersmod.entity.ai;

import java.util.List;

import com.marctron.transformersmod.entity.EntityDecepticonBrute;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;

public class AnimationBruteVerticalAttackAI extends AnimationAttackAI<EntityDecepticonBrute> {
    private float arc;

    public AnimationBruteVerticalAttackAI(EntityDecepticonBrute entity, Animation animation, SoundEvent sound, float knockback, float range, float arc) {
        super(entity, animation, sound, null, knockback, range, 0, 0);
        this.arc = arc;
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
        entity.playSound(SoundEvents.ENTITY_BAT_TAKEOFF, 1.5F, 1F);
    }

    @Override
    public void updateTask() {
        if (entity.getAnimation() == getAnimation()) {
            entity.motionX = 0;
            entity.motionZ = 0;
            entity.rotationYaw = entity.prevRotationYaw;
            if (entity.getAnimationTick() < 26 && entityTarget != null) {
                entity.getLookHelper().setLookPositionWithEntity(entityTarget, 30F, 30F);
            }

            if (entity.getAnimationTick() == 6) {
                entity.playSound(SoundEvents.ENTITY_BAT_TAKEOFF, 0.5F, 1F);
            } else if (entity.getAnimationTick() == 25) {
                entity.playSound(attackSound, 1.2F, 1);
            } else if (entity.getAnimationTick() == 27) {
                entity.playSound(SoundEvents.ENTITY_BAT_TAKEOFF, 1.5F, 1F);
                List<EntityLivingBase> entitiesHit = entity.getEntityLivingBaseNearby(range, 3, range, range);
                float damage = (float) entity.getAttack();
                for (EntityLivingBase entityHit : entitiesHit) {
                    float entityHitAngle = (float) ((Math.atan2(entityHit.posZ - entity.posZ, entityHit.posX - entity.posX) * (180 / Math.PI) - 90) % 360);
                    float entityAttackingAngle = entity.renderYawOffset % 360;
                    if (entityHitAngle < 0) {
                        entityHitAngle += 360;
                    }
                    if (entityAttackingAngle < 0) {
                        entityAttackingAngle += 360;
                    }
                    float entityRelativeAngle = entityHitAngle - entityAttackingAngle;
                    float entityHitDistance = (float) Math.sqrt((entityHit.posZ - entity.posZ) * (entityHit.posZ - entity.posZ) + (entityHit.posX - entity.posX) * (entityHit.posX - entity.posX));
                    if (entityHitDistance <= range && (entityRelativeAngle <= arc / 2 && entityRelativeAngle >= -arc / 2) || (entityRelativeAngle >= 360 - arc / 2 || entityRelativeAngle <= -360 + arc / 2)) {
                        entityHit.attackEntityFrom(DamageSource.causeMobDamage(entity), damage * 1.5F);
                        if (entityHit.isActiveItemStackBlocking()) entityHit.getActiveItemStack().damageItem(400, entityHit);
                        entityHit.motionX *= knockback;
                        entityHit.motionZ *= knockback;
                    }
                }
            } else if (entity.getAnimationTick() == 28) {
                entity.playSound(SoundEvents.BLOCK_ANVIL_LAND, 1, 0.5F);
            } else if (entity.getAnimationTick() == 43) {
//                entity.playSound(SoundEvents.ENTITY_BAT_TAKEOFF, 1, 1F);
//                entity.playSound(SoundEvents.ENTITY_BAT_TAKEOFF, 0.5F, 1F);
            } else if (entity.getAnimationTick() == 72) {
//                entity.playSound(SoundEvents.ENTITY_BAT_TAKEOFF, 1, 1F);
            } else if (entity.getAnimationTick() == 81) {
//                entity.playSound(SoundEvents.ENTITY_BAT_TAKEOFF, 1, 1F);
            }
            if (entity.getAnimationTick() > 26 && entity.getAnimationTick() < 40) {
                entity.vulnerable = true;
                entity.rotationYaw = entity.prevRotationYaw;
                entity.renderYawOffset = entity.prevRenderYawOffset;
            } else {
                entity.vulnerable = false;
            }
        } else {
            entity.vulnerable = false;
        }
    }
}
