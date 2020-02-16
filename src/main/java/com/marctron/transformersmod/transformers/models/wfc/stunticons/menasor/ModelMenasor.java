package com.marctron.transformersmod.transformers.models.wfc.stunticons.menasor;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.opengl.GL13;

import com.marctron.transformersmod.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class ModelMenasor extends ModelMenasorTorso2 {
	
	public ModelMenasor(){
		Right_Leg.addChild(Right_Lower_Leg);
		
		Left_Leg.addChild(Left_Lower_Leg);
		
		Left_Lower_Leg.addChild(Left_Foot);
	}
	
	@Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
//        Right_Lower_Leg.render(f5);
        Torso.render(f5);
//		Left_Lower_Leg.render(f5);
//        GlStateManager.bindTexture(Reference.MENASOR);
//        GL11.glBindTexture(GL11.GL_TEXTURE_2D, Reference.MENASOR);
//        Right_Lower_Leg.textureOffsetX= 512;
//        Minecraft.getMinecraft().getTextureManager().getTexture(new ResourceLocation(Reference.MOD_ID, "textures/models/armor/menasor_model_layer_1.png"));
        if (!bipedLeftLeg.isHidden && !bipedRightLeg.isHidden && !bipedLeftArm.isHidden && !bipedRightArm.isHidden
				&& !bipedBody.isHidden && !bipedHead.isHidden) {
			bipedLeftLeg.isHidden = true;
			bipedRightLeg.isHidden = true;
			bipedLeftArm.isHidden = true;
			bipedRightArm.isHidden = true;
			bipedBody.isHidden = true;
			bipedHead.isHidden = true;
		}
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	GlStateManager.scale(0.6F, 0.6F, 0.6F);
        GlStateManager.translate(0.0F, 10.5F * f5, -0.25F);
        
        resetToDefaultPose();
        
        Left_Foot.rotationPointY=34.0F ;
        Left_Foot.rotationPointX=1.5F ;
        
        float globalSpeed = 0.175F;
        float globalDegree = 0.5F ;
        float globalHeight = 4F ;
        
        float upwardPose = (float) (1 / (1 + Math.exp(-8 * (entity.motionY + 0.2))));
        float downwardPose = (float) (1 / (1 + Math.exp(8 * (entity.motionY + 0.2))));
        int backwardInverter = 1;
        
        //walking
        	walk(Left_Leg, 1* globalSpeed, 1* globalDegree, false, 0, 0, f, f1);
        	walk(Right_Leg, 1* globalSpeed, 1* globalDegree, true, 0, 0, f, f1);
        	
        	walk(Left_Foot, 1* globalSpeed, 0.5f* globalDegree, false, -.1f, 0, f, f1);
        	walk(Right_Foot, 1* globalSpeed, 0.5f* globalDegree, true, -.1f, 0, f, f1);
        	
        	bob(Torso, 2* globalSpeed, globalHeight, false, f, f1);
        	
        	swing(Torso, globalSpeed, 0.5f*globalDegree, false, 0, 0, f, f1);
        	swing(Left_Leg, globalSpeed, 0.5f*globalDegree, true, 0, 0, f, f1);
        	swing(Right_Leg, globalSpeed, 0.5f *globalDegree, true, 0, 0, f, f1);
        	walk(Torso, globalSpeed, 0.1f*globalDegree, false, 0, 0.1f, f, f1);
        	
        	
        	walk(Left_Lower_Leg, 1* globalSpeed, 1* globalDegree, true, 2, -0.7f, f, f1);
        	walk(Right_Lower_Leg, 1* globalSpeed, 1* globalDegree, false, 2, 0.7f, f, f1);
        
        	
        	
        	
        	//Jump and Falling 
            if (entity instanceof EntityPlayer){
    			EntityPlayer player = (EntityPlayer) entity;
    			if (!player.onGround  && !player.capabilities.isFlying){
    					Right_Leg.rotateAngleX += 0.2 * upwardPose;
    					Left_Leg.rotateAngleX -= 0.8 * upwardPose;
    					Right_Lower_Leg.rotateAngleX += 0.3 * upwardPose;
    					Left_Lower_Leg.rotateAngleX += 1.5 * upwardPose;
    		
    					walk(Right_Leg, 0.5F * globalSpeed, 0.2F * globalDegree * downwardPose, false, 0, 0, f1, 1);
    					walk(Left_Leg, 0.5F * globalSpeed, 0.2F * globalDegree * downwardPose, true, 0, 0, f1, 1);
    					walk(Right_Lower_Leg, 0.5F * globalSpeed, 0.2F * globalDegree * downwardPose, false, -2.2F * backwardInverter, 0F, f1, 1);
    					walk(Left_Lower_Leg, 0.5F * globalSpeed, 0.2F * globalDegree * downwardPose, true, -2.2F * backwardInverter, 0F, f1, 1);
            
    					Right_Leg.rotateAngleX -= 1.2 * downwardPose;
    					Left_Leg.rotateAngleX += 0.7 * downwardPose;
    					Right_Lower_Leg.rotateAngleX += 2 * downwardPose;
    					Left_Lower_Leg.rotateAngleX += 0.5 * downwardPose;
            
    					this.Right_Leg.rotateAngleX -= .5F *downwardPose;
    					this.Left_Leg.rotateAngleX -= .5F *downwardPose;

            
//    					this.Chest.rotateAngleX = 0.6F *downwardPose;
    					this.Torso.rotateAngleX = .2F *downwardPose;
            
          	
//    					Right_Arm.rotateAngleX = 0.6F*downwardPose;
//    					Left_Arm.rotateAngleX = 0.6F*downwardPose;
//          	
//    					Right_Arm.rotateAngleZ = 0.4F *downwardPose;
//    					Left_Arm.rotateAngleZ = -0.4F *downwardPose;
//        
//    					Right_Lower_Arm.rotateAngleX = -1.1F *downwardPose;
//    					Left_Lower_Arm.rotateAngleX = -1.1F *downwardPose;
//        
//    					Right_Lower_Arm.rotateAngleY = -0.2F *downwardPose;
//    					Left_Lower_Arm.rotateAngleY = 0.2F *downwardPose;
    				}
    			}	
       
//        StringBuilder.append("        this." + field + " = new ModelRenderer(this, " + cube.txOffset[0] + ", " + cube.txOffset[1] + ");\n");

    }

}
