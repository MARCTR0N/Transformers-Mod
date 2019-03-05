package com.marctron.transformersmod.items.models;

import com.marctron.transformersmod.items.models.altmodes.AJModelAlt;



import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class AJModel extends ModelBiped {
    public ModelRenderer Right_Arm;
    public ModelRenderer Right_Leg;
    public ModelRenderer Head;
    public ModelRenderer Chest;
    public ModelRenderer Left_Arm;
    public ModelRenderer Left_Leg;

    public AJModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.Left_Arm = new ModelRenderer(this, 32, 32);
        this.Left_Arm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Left_Arm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.Left_Leg = new ModelRenderer(this, 16, 48);
        this.Left_Leg.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Left_Leg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.Right_Leg = new ModelRenderer(this, 0, 16);
        this.Right_Leg.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Right_Leg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.Chest = new ModelRenderer(this, 16, 16);
        this.Chest.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Chest.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.Right_Arm = new ModelRenderer(this, 48, 32);
        this.Right_Arm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Right_Arm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        
        this.bipedHead.addChild(Head);

        this.bipedBody.addChild(Chest);
        
        this.bipedLeftArm.addChild(Left_Arm);

        this.bipedLeftLeg.addChild(Left_Leg);

        this.bipedRightArm.addChild(Right_Arm);

        this.bipedRightLeg.addChild(Right_Leg);

    }
    
      
   
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
    { 
    	super.render(entity, f, f1, f2, f3, f4, f5);
    	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }

    @Override
   	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
   		// this prevents helmets from always facing south, and the armor "breathing" on the stand
   		if (entityIn instanceof EntityArmorStand) {
   			EntityArmorStand entityarmorstand = (EntityArmorStand) entityIn;
   			this.bipedHead.rotateAngleX = 0.017453292F * entityarmorstand.getHeadRotation().getX();
   			this.bipedHead.rotateAngleY = 0.017453292F * entityarmorstand.getHeadRotation().getY();
   			this.bipedHead.rotateAngleZ = 0.017453292F * entityarmorstand.getHeadRotation().getZ();
   			this.bipedHead.setRotationPoint(0.0F, 1.0F, 0.0F);
   			
   			this.bipedBody.rotateAngleX = 0.017453292F * entityarmorstand.getBodyRotation().getX();
   			this.bipedBody.rotateAngleY = 0.017453292F * entityarmorstand.getBodyRotation().getY();
   			this.bipedBody.rotateAngleZ = 0.017453292F * entityarmorstand.getBodyRotation().getZ();
   			
   			this.bipedLeftArm.rotateAngleX = 0.017453292F * entityarmorstand.getLeftArmRotation().getX();
   			this.bipedLeftArm.rotateAngleY = 0.017453292F * entityarmorstand.getLeftArmRotation().getY();
   			this.bipedLeftArm.rotateAngleZ = 0.017453292F * entityarmorstand.getLeftArmRotation().getZ();
   			
   			this.bipedRightArm.rotateAngleX = 0.017453292F * entityarmorstand.getRightArmRotation().getX();
   			this.bipedRightArm.rotateAngleY = 0.017453292F * entityarmorstand.getRightArmRotation().getY();
   			this.bipedRightArm.rotateAngleZ = 0.017453292F * entityarmorstand.getRightArmRotation().getZ();
   			
   			this.bipedLeftLeg.rotateAngleX = 0.017453292F * entityarmorstand.getLeftLegRotation().getX();
   			this.bipedLeftLeg.rotateAngleY = 0.017453292F * entityarmorstand.getLeftLegRotation().getY();
   			this.bipedLeftLeg.rotateAngleZ = 0.017453292F * entityarmorstand.getLeftLegRotation().getZ();
   			this.bipedLeftLeg.setRotationPoint(1.9F, 11.0F, 0.0F);
   			
   			this.bipedRightLeg.rotateAngleX = 0.017453292F * entityarmorstand.getRightLegRotation().getX();
   			this.bipedRightLeg.rotateAngleY = 0.017453292F * entityarmorstand.getRightLegRotation().getY();
   			this.bipedRightLeg.rotateAngleZ = 0.017453292F * entityarmorstand.getRightLegRotation().getZ();
   			this.bipedRightLeg.setRotationPoint(-1.9F, 11.0F, 0.0F);
   			copyModelAngles(this.bipedHead, this.bipedHeadwear);
   		} else super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
   	}
    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
        
        //transfomation
    }
    public void doTransformationAnimations(EntityPlayer player, float progress, float limbSwing, float limbSwingAmount, float ticks, float rotationYaw, float rotationPitch, boolean wearingHead, boolean wearingChest, boolean wearingLegs, boolean wearingFeet)
    {
        {
            float f = 1 - progress;
            
           
            
            setRotateAngle(Head, 0, 0, 0);
            setRotateAngle(Chest, 0, 0, 0);
            setRotateAngle(Left_Leg, 0, 0, 0);
            setRotateAngle(Right_Leg, 0, 0, 0);
            setRotateAngle(Left_Arm, 0, 0, 0);
            setRotateAngle(Right_Arm, 0, 0, 0);
            
            Left_Leg.rotateAngleX = 0.24434609527920614F + (3.14159265359F - 0.24434609527920614F) * progress;
            Right_Leg.rotateAngleX = 0.24434609527920614F + (3.14159265359F - 0.24434609527920614F) * progress;
            Left_Leg.setRotationPoint(-1 + progress / -3.0F, 6.0F + 2.5F * progress, -1 + 2.5F * progress);
            Right_Leg.setRotationPoint(1 - progress / 3.0F, 6.0F + 2.5F * progress, -1 + 2.5F * progress);
            
            Left_Arm.rotateAngleX = 0.24434609527920614F + (3.14159265359F - 0.24434609527920614F) * progress;
            Right_Arm.rotateAngleX = 0.24434609527920614F + (3.14159265359F - 0.24434609527920614F) * progress;
            Left_Arm.setRotationPoint(-1 + progress / -4.0F, 6.0F + 2.5F * progress, -1 + 2.5F * progress);
            Right_Arm.setRotationPoint(1 - progress / 4.0F, 6.0F + 2.5F * progress, -1 + 2.5F * progress);
            
            Chest.rotateAngleX = 0.24434609527920614F + (3.14159265359F - 0.24434609527920614F) * progress;
            Chest.setRotationPoint(1 - progress / 0.0F, 0.0F + 2.5F * progress, -1 + 2.5F * progress);
            
            Head.rotateAngleX = 0.24434609527920614F + (3.14159265359F - 0.24434609527920614F) * progress;
            Head.setRotationPoint(1 - progress / 0.0F, 8.0F + 2.5F * progress, -1 + 2.5F * progress);
            
            
           
            
            
        }
    }



	

    
}