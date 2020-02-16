package com.marctron.transformersmod.transformers.models;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.TextureOffset;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;

public class AdvancedModelBiped extends ModelBiped {
	private float movementScale = 1.0F;
    private final Map<String, TextureOffset> modelTextureMap = Maps.newHashMap();
    
    protected void setTextureOffset(String partName, int x, int y) {
        this.modelTextureMap.put(partName, new TextureOffset(x, y));
    }

    public TextureOffset getTextureOffset(String partName) {
        return this.modelTextureMap.get(partName);
    }
    

    /**
     * Sets the default pose to the current pose of this model
     */
    public void updateDefaultPose() {
        this.boxList.stream().filter(modelRenderer -> modelRenderer instanceof AdvancedModelBipedRenderer).forEach(modelRenderer -> {
        	AdvancedModelBipedRenderer advancedModelRenderer = (AdvancedModelBipedRenderer) modelRenderer;
            advancedModelRenderer.updateDefaultPose();
        });
    }

    /**
     * Sets the current pose to the previously set default pose
     */
    public void resetToDefaultPose() {
        this.boxList.stream().filter(modelRenderer -> modelRenderer instanceof AdvancedModelBipedRenderer).forEach(modelRenderer -> {
        	AdvancedModelBipedRenderer advancedModelRenderer = (AdvancedModelBipedRenderer) modelRenderer;
            advancedModelRenderer.resetToDefaultPose();
        });
    }

    /**
     * Rotates the given boxes to face a given target
     *
     * @param yaw             the yaw to face
     * @param pitch           the pitch to face
     * @param rotationDivisor the amount to divide the rotation angles by
     * @param boxes           the boxes to face the given target
     */
    public void faceTarget(float yaw, float pitch, float rotationDivisor, AdvancedModelBipedRenderer... boxes) {
        float actualRotationDivisor = rotationDivisor * boxes.length;
        float yawAmount = yaw / (180.0F / (float) Math.PI) / actualRotationDivisor;
        float pitchAmount = pitch / (180.0F / (float) Math.PI) / actualRotationDivisor;
        for (AdvancedModelBipedRenderer box : boxes) {
            box.rotateAngleY += yawAmount;
            box.rotateAngleX += pitchAmount;
        }
    }

    /**
     * Swings (rotates on the Y axis) the given model parts in a chain-like manner.
     *
     * @param boxes       the boxes to swing
     * @param speed       the speed to swing this at
     * @param degree      the amount to rotate this by
     * @param rootOffset  the root rotation offset
     * @param swing       the swing rotation
     * @param swingAmount the swing amount
     */
    public void chainSwing(AdvancedModelBipedRenderer[] boxes, float speed, float degree, double rootOffset, float swing, float swingAmount) {
        float offset = this.calculateChainOffset(rootOffset, boxes);
        for (int index = 0; index < boxes.length; index++) {
            boxes[index].rotateAngleY += this.calculateChainRotation(speed, degree, swing, swingAmount, offset, index);
        }
    }

    /**
     * Waves (rotates on the X axis) the given model parts in a chain-like manner.
     *
     * @param boxes       the boxes to wave
     * @param speed       the speed to wave this at
     * @param degree      the amount to rotate this by
     * @param rootOffset  the root rotation offset
     * @param swing       the swing rotation
     * @param swingAmount the swing amount
     */
    public void chainWave(AdvancedModelBipedRenderer[] boxes, float speed, float degree, double rootOffset, float swing, float swingAmount) {
        float offset = this.calculateChainOffset(rootOffset, boxes);
        for (int index = 0; index < boxes.length; index++) {
            boxes[index].rotateAngleX += this.calculateChainRotation(speed, degree, swing, swingAmount, offset, index);
        }
    }

    /**
     * Flaps (rotates on the Z axis) the given model parts in a chain-like manner.
     *
     * @param boxes       the boxes to flap
     * @param speed       the speed to flap this at
     * @param degree      the amount to rotate this by
     * @param rootOffset  the root rotation offset
     * @param swing       the swing rotation
     * @param swingAmount the swing amount
     */
    public void chainFlap(AdvancedModelBipedRenderer[] boxes, float speed, float degree, double rootOffset, float swing, float swingAmount) {
        float offset = this.calculateChainOffset(rootOffset, boxes);
        for (int index = 0; index < boxes.length; index++) {
            boxes[index].rotateAngleZ += this.calculateChainRotation(speed, degree, swing, swingAmount, offset, index);
        }
    }

    private float calculateChainRotation(float speed, float degree, float swing, float swingAmount, float offset, int boxIndex) {
        return MathHelper.cos(swing * (speed * this.movementScale) + offset * boxIndex) * swingAmount * (degree * this.movementScale);
    }

    private float calculateChainOffset(double rootOffset, AdvancedModelBipedRenderer... boxes) {
        return (float) ((rootOffset * Math.PI) / (2 * boxes.length));
    }

    /**
     * @return the current movement scale
     */
    public float getMovementScale() {
        return this.movementScale;
    }

    /**
     * Multiplies all rotation and position changes by this value
     *
     * @param movementScale the movement scale
     */
    public void setMovementScale(float movementScale) {
        this.movementScale = movementScale;
    }

    /**
     * Rotates this box back and forth (rotateAngleX). Useful for arms and legs.
     *
     * @param box        the box to animate
     * @param speed      is how fast the animation runs
     * @param degree     is how far the box will rotate;
     * @param invert     will invert the rotation
     * @param offset     will offset the timing of the animation
     * @param weight     will make the animation favor one direction more based on how fast the mob is moving
     * @param walk       is the walked distance
     * @param walkAmount is the walk speed
     */
    public void walk(AdvancedModelBipedRenderer box, float speed, float degree, boolean invert, float offset, float weight, float walk, float walkAmount) {
        box.walk(speed, degree, invert, offset, weight, walk, walkAmount);
    }

    /**
     * Rotates this box up and down (rotateAngleZ). Useful for wing and ears.
     *
     * @param box        the box to animate
     * @param speed      is how fast the animation runs
     * @param degree     is how far the box will rotate;
     * @param invert     will invert the rotation
     * @param offset     will offset the timing of the animation
     * @param weight     will make the animation favor one direction more based on how fast the mob is moving
     * @param flap       is the flapped distance
     * @param flapAmount is the flap speed
     */
    public void flap(AdvancedModelBipedRenderer box, float speed, float degree, boolean invert, float offset, float weight, float flap, float flapAmount) {
        box.flap(speed, degree, invert, offset, weight, flap, flapAmount);
    }

    /**
     * Rotates this box side to side (rotateAngleY).
     *
     * @param box         the box to animate
     * @param speed       is how fast the animation runs
     * @param degree      is how far the box will rotate;
     * @param invert      will invert the rotation
     * @param offset      will offset the timing of the animation
     * @param weight      will make the animation favor one direction more based on how fast the mob is moving
     * @param swing       is the swung distance
     * @param swingAmount is the swing speed
     */
    public void swing(AdvancedModelBipedRenderer box, float speed, float degree, boolean invert, float offset, float weight, float swing, float swingAmount) {
        box.swing(speed, degree, invert, offset, weight, swing, swingAmount);
    }

    /**
     * Moves this box up and down (rotationPointY). Useful for bodies.
     *
     * @param box    the box to animate
     * @param speed  is how fast the animation runs;
     * @param degree is how far the box will move;
     * @param bounce will make the box bounce;
     * @param f      is the walked distance;
     * @param f1     is the walk speed.
     */
    public void bob(AdvancedModelBipedRenderer box, float speed, float degree, boolean bounce, float f, float f1) {
        box.bob(speed, degree, bounce, f, f1);
    }

    /**
     * Returns a float that can be used to move boxes.
     *
     * @param speed  is how fast the animation runs;
     * @param degree is how far the box will move;
     * @param bounce will make the box bounce;
     * @param f      is the walked distance;
     * @param f1     is the walk speed.
     */
    public float moveBox(float speed, float degree, boolean bounce, float f, float f1) {
        if (bounce) {
            return -MathHelper.abs((MathHelper.sin(f * speed) * f1 * degree));
        } else {
            return MathHelper.sin(f * speed) * f1 * degree - f1 * degree;
        }
    }
    
    public void setRotateAngle(AdvancedModelBipedRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void rotate(ModelAnimator animator, AdvancedModelBipedRenderer model, float x, float y, float z) {
        animator.rotate(model, (float) Math.toRadians(x), (float) Math.toRadians(y), (float) Math.toRadians(z));
    }

    public void rotateMinus(ModelAnimator animator, AdvancedModelBipedRenderer model, float x, float y, float z) {
        animator.rotate(model, (float) Math.toRadians(x) - model.defaultRotationX, (float) Math.toRadians(y) - model.defaultRotationY, (float) Math.toRadians(z) - model.defaultRotationZ);
    }

    public void progressRotation(AdvancedModelBipedRenderer model, float progress, float rotX, float rotY, float rotZ, float divisor) {
        model.rotateAngleX += progress * (rotX - model.defaultRotationX) / divisor;
        model.rotateAngleY += progress * (rotY - model.defaultRotationY) / divisor;
        model.rotateAngleZ += progress * (rotZ - model.defaultRotationZ) / divisor;
    }

    public void progressRotationPrev(AdvancedModelBipedRenderer model, float progress, float rotX, float rotY, float rotZ, float divisor) {
        model.rotateAngleX += progress * (rotX) / divisor;
        model.rotateAngleY += progress * (rotY) / divisor;
        model.rotateAngleZ += progress * (rotZ) / divisor;
    }

    public void progressPosition(AdvancedModelBipedRenderer model, float progress, float x, float y, float z, float divisor) {
        model.rotationPointX += progress * (x - model.defaultPositionX) / divisor;
        model.rotationPointY += progress * (y - model.defaultPositionY) / divisor;
        model.rotationPointZ += progress * (z - model.defaultPositionZ) / divisor;
    }

    public void progressPositionPrev(AdvancedModelBipedRenderer model, float progress, float x, float y, float z, float divisor) {
        model.rotationPointX += progress * x / divisor;
        model.rotationPointY += progress * y / divisor;
        model.rotationPointZ += progress * z / divisor;
    }

    
    protected void rotateTo(AdvancedModelBipedRenderer rotating, AdvancedModelBipedRenderer to, float f)
    {
        float rotXDif = to.rotateAngleX - rotating.rotateAngleX;
        float rotYDif = to.rotateAngleY - rotating.rotateAngleY;
        float rotZDif = to.rotateAngleZ - rotating.rotateAngleZ;

        float posXDif = to.rotationPointX - rotating.rotationPointX;
        float posYDif = to.rotationPointY - rotating.rotationPointY;
        float posZDif = to.rotationPointZ - rotating.rotationPointZ;

        float offsetXDif = to.offsetX - rotating.offsetX;
        float offsetYDif = to.offsetY - rotating.offsetY;
        float offsetZDif = to.offsetZ - rotating.offsetZ;

        rotating.rotateAngleX += rotXDif * f;
        rotating.rotateAngleY += rotYDif * f;
        rotating.rotateAngleZ += rotZDif * f;

        rotating.offsetX += offsetXDif * f;
        rotating.offsetY += offsetYDif * f;
        rotating.offsetZ += offsetZDif * f;

        rotating.rotationPointX += posXDif * f;
        rotating.rotationPointY += posYDif * f;
        rotating.rotationPointZ += posZDif * f;
    }
    
    
 
   
}