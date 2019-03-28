package com.marctron.transformersmod.transformers.models.altmodes;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelPlayer - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class AJModelAlt extends ModelBiped {
    public ModelRenderer Right_Arm;
    public ModelRenderer Right_Leg;
    public ModelRenderer Head;
    public ModelRenderer Chest;
    public ModelRenderer Left_Arm;
    public ModelRenderer Left_Leg;

    public AJModelAlt() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.Left_Leg = new ModelRenderer(this, 16, 48);
        this.Left_Leg.setRotationPoint(-3.0F, 6.0F, 0.0F);
        this.Left_Leg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(Left_Leg, -1.5707963267948966F, 0.0F, 0.0F);
        this.Left_Arm = new ModelRenderer(this, 32, 32);
        this.Left_Arm.setRotationPoint(-4.0F, 6.0F, 0.0F);
        this.Left_Arm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(Left_Arm, 1.5707963267948966F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.Chest = new ModelRenderer(this, 16, 16);
        this.Chest.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Chest.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.Right_Arm = new ModelRenderer(this, 48, 32);
        this.Right_Arm.setRotationPoint(4.0F, 6.0F, 0.0F);
        this.Right_Arm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(Right_Arm, 1.5707963267948966F, 0.0F, 0.0F);
        this.Right_Leg = new ModelRenderer(this, 0, 16);
        this.Right_Leg.setRotationPoint(3.0F, 6.0F, 0.0F);
        this.Right_Leg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        
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

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
