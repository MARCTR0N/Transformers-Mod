package com.marctron.transformersmod.transformers.models.tfpmegatron;

import com.marctron.transformersmod.capabilities.EntityAnimatorProvider;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;
import com.marctron.transformersmod.util.handlers.CapabilityHandler;

import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModelMegatron extends ModelMegatron3{
	
	private ModelAnimator animator = ModelAnimator.create();
	
	@Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
		((ModelBiped)((ItemArmorTransformer)entity.getArmorInventoryList().iterator().next().getItem()).getRenderer().getMainModel()).bipedLeftArm = this.RightHand;
    	((ModelBiped)((ItemArmorTransformer)entity.getArmorInventoryList().iterator().next().getItem()).getRenderer().getMainModel()).bipedRightArm = this.RightHand_2;
//        Left_Shoulder.render(f5);
//        Right_Shoulder.render(f5);
    	if (!bipedLeftLeg.isHidden && !bipedRightLeg.isHidden && !bipedLeftArm.isHidden && !bipedRightArm.isHidden
				&& !bipedBody.isHidden && !bipedHead.isHidden) {
			bipedLeftLeg.isHidden = true;
			bipedRightLeg.isHidden = true;
			bipedLeftArm.isHidden = true;
			bipedRightArm.isHidden = true;
			bipedBody.isHidden = true;
			bipedHead.isHidden = true;
		}
    	Megatron.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    
    @Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
    	
    	if (this.bipedBody.showModel && entitylivingbaseIn.hasCapability(EntityAnimatorProvider.ANIMATED_ENTITY_CAP, null)) {
    		
    		IAnimatedEntity animationState = entitylivingbaseIn.getCapability(EntityAnimatorProvider.ANIMATED_ENTITY_CAP, null);
    		this.animator.update(animationState);
        	
        	//do stuff with the animation info
    		
    		if (this.animator.setAnimation(CapabilityHandler.RELOAD_ANIMATION)) {
    			//swing1
    			this.animator.startKeyframe(5);
    			this.animator.rotate(Right_Arm, -.4f, 0, 0.7f);

    			this.animator.rotate(Left_Arm, -1.2f, 0, 0.2f);
    			this.animator.rotate(RightLowerArm, -0.4f, 0, 0.2f);
    			
    			this.animator.endKeyframe();
    			
    			//hold1
    			this.animator.startKeyframe(5);
    			this.animator.rotate(Right_Arm, -.4f, 0, 0.7f);
    			this.animator.rotate(Left_Arm, -0.9f, 0, 0.2f);
    			this.animator.rotate(RightLowerArm, -0.1f, 0.2f, 0.2f);
    			this.animator.endKeyframe();
    			
    			//hold1
    			this.animator.startKeyframe(5);
    			this.animator.rotate(Right_Arm, -.4f, 0, 0.7f);
    			this.animator.rotate(Left_Arm, -0.9f, 0, 0.2f);
    			this.animator.rotate(RightLowerArm, -0.1f, 0, 0.2f);
    			this.animator.endKeyframe();
    			
    			//End
    			this.animator.startKeyframe(10);
    			this.animator.rotate(Right_Arm, 0f, 0, 0f);
    			this.animator.endKeyframe();
    		}
    		
        	if (this.animator.setAnimation(CapabilityHandler.PUNCH_ANIMATION)) {
        		//swing
	        	this.animator.startKeyframe(3);
	        	this.animator.rotate(Right_Arm, -1.4f, 0, 0.3f);
	        	this.animator.rotate(Right_Lower_Arm, -1.4f, 0.1f, 0);
	        	
	        	this.animator.rotate(Left_Arm, 0.4f, 0, -0.1f);
	        	this.animator.rotate(RightLowerArm, -0.8f, -0.1f, 0);
	        	
	        	this.animator.rotate(Chest, 0, -0.5f, 0);
	        	this.animator.rotate(Head, 0, 0.4f, 0);
	        	
	        	this.animator.endKeyframe();
	        	//hold
	        	this.animator.startKeyframe(2);
	        	this.animator.rotate(Right_Arm, -1.4f, 0, 0.3f);
	        	this.animator.rotate(Right_Lower_Arm, -1.4f, 0.1f, 0);
	        	
	        	this.animator.rotate(Left_Arm, 0.4f, 0, -0.1f);
	        	this.animator.rotate(RightLowerArm, -0.8f, -0.1f, 0);
	        	
	        	this.animator.rotate(Chest, 0, -0.5f, 0);
	        	this.animator.rotate(Head, 0, 0.4f, 0);
	        	
	        	this.animator.endKeyframe();
	        	//END
	        	this.animator.startKeyframe(5);
	        	this.animator.rotate(Right_Arm, 0, 0, 0);
	        	this.animator.rotate(Right_Lower_Arm, 0, 0, 0);
	        	this.animator.endKeyframe();
	        	
        	}
        	
        	if (this.animator.setAnimation(CapabilityHandler.AXE_REVERSE_ANIMATION)) {
        		//swing1
	        	this.animator.startKeyframe(5);
	        	this.animator.rotate(Right_Arm, 1, 0, 0);
	        	this.animator.rotate(Right_Lower_Arm, 0.1f, 0, 0);
	        	
	        	
	        	
	        	this.animator.rotate(Chest, -0.1f, 0.3f, 0);
	        	this.animator.rotate(Head, -0.1f, -0.2f, 0);
	        	this.animator.endKeyframe();
	        	//hold1
	        	this.animator.startKeyframe(3);
	           	this.animator.rotate(Right_Arm, 1, 0, 0);
	        	this.animator.rotate(Right_Lower_Arm, 0.1f, 0, 0);
	        	
	        	
	        	
	        	this.animator.rotate(Chest, -0.1f, 0.3f, 0);
	        	this.animator.rotate(Head, -0.1f, -0.2f, 0);
	        	this.animator.endKeyframe();
	        	
	        	//swing2
	        	this.animator.startKeyframe(3);
	           	this.animator.rotate(Right_Arm, -1, 0, 0);
	        	this.animator.rotate(Right_Lower_Arm, -0.6f, 0, 0);
	        	
	        	this.animator.rotate(Chest, -0.1f, -0.3f, 0);
	        	this.animator.rotate(Head, -0.1f, -0.2f, 0);
	        	this.animator.endKeyframe();
	        	
	        	//hold2
	        	this.animator.startKeyframe(3);
	        	this.animator.rotate(Right_Arm, -1, 0, 0);
	        	this.animator.rotate(Right_Lower_Arm, -0.6f, 0, 0);
	        	
	        	this.animator.rotate(Chest, -0.1f, -0.3f, 0);
	        	this.animator.rotate(Head, -0.1f, -0.2f, 0);
	        	this.animator.endKeyframe();
	        	
	        	//END
	        	this.animator.startKeyframe(6);
	        	this.animator.rotate(Right_Arm, -0f, 0, 0);
	        	this.animator.rotate(Right_Lower_Arm, -0f, 0, 0);
	        	
	        	this.animator.rotate(Left_Arm, 0, 0, 0);
	        	this.animator.rotate(RightLowerArm, 0, 0, 0);
	        	this.animator.endKeyframe();
	        	
        	}
        	
        	if (this.animator.setAnimation(CapabilityHandler.AXE_ANIMATION)) {
        		//swing1
	        	this.animator.startKeyframe(5);
	        	this.animator.rotate(Right_Arm, -2, 0, 0);
	        	this.animator.rotate(Right_Lower_Arm, -1f, 0, 0);
	        	
	        	this.animator.rotate(Left_Arm, -1, 0, -1);
	        	this.animator.rotate(RightLowerArm, -1f, 0, 0);
	        	
	        	this.animator.rotate(Chest, -0.1f, 0.7f, 0);
	        	this.animator.rotate(Head, -0.1f, -0.3f, 0);
	        	this.animator.endKeyframe();
	        	//hold1
	        	this.animator.startKeyframe(3);
	        	this.animator.rotate(Right_Arm, -2, 0, 0);
	        	this.animator.rotate(Right_Lower_Arm, -0.5f, 0, 0);
	        	
	        	this.animator.rotate(Left_Arm, -1, 0, -1);
	        	this.animator.rotate(RightLowerArm, -1f, 0, 0);
	        	this.animator.endKeyframe();
	        	
	        	//swing2
	        	this.animator.startKeyframe(3);
	        	this.animator.rotate(Right_Arm, -0.2f, 0, 0);
	        	this.animator.rotate(Right_Lower_Arm, -0.1f, 0, 0);
	        	
	        	this.animator.rotate(Left_Arm, 0, 0, 0);
	        	this.animator.rotate(RightLowerArm, 0, 0, 0);
	        	this.animator.endKeyframe();
	        	
	        	//hold2
	        	this.animator.startKeyframe(1);
	        	this.animator.rotate(Right_Arm, -0.2f, 0, 0);
	        	this.animator.rotate(Right_Lower_Arm, -0.1f, 0, 0);
	        	
	        	this.animator.rotate(Left_Arm, 0, 0, 0);
	        	this.animator.rotate(RightLowerArm, 0, 0, 0);
	        	this.animator.endKeyframe();
	        	
	        	//END
	        	this.animator.startKeyframe(3);
	        	this.animator.rotate(Right_Arm, -0f, 0, 0);
	        	this.animator.rotate(Right_Lower_Arm, -0f, 0, 0);
	        	
	        	this.animator.rotate(Left_Arm, 0, 0, 0);
	        	this.animator.rotate(RightLowerArm, 0, 0, 0);
	        	this.animator.endKeyframe();
	        	
        	}
        	
        	if (this.animator.setAnimation(CapabilityHandler.SWORD_REVERSE_ANIMATION)) {
        		//swing1
	        	this.animator.startKeyframe(4);
	        	this.animator.rotate(Right_Arm, 0.5f, 0, 1.3f);
	        	
//	        	this.animator.rotate(RIGHT_HAND, 2f, 0, 0);
//	        	this.animator.move(RIGHT_HAND, 0, 16, -7);
	        	
	        	this.animator.rotate(Left_Arm, 0.5f, 0, -0.7f);
	        	this.animator.rotate(RightLowerArm, -0.5f, 0, 0);
	        	
	        	this.animator.rotate(Chest, 0.1f, 0.4f, 0);
	        	this.animator.rotate(Head, 0, 0, 0);
	        	
	        	
	        	
	        	this.animator.endKeyframe();
	        	
	        	//swing2
	        	this.animator.startKeyframe(4);
	        	
//	        	this.animator.rotate(RIGHT_HAND, 2f, 0, 0);
//	        	this.animator.move(RIGHT_HAND, 0, 16, -7);
	        	
	        	this.animator.rotate(Right_Arm, -1, 0, 1.3f);
	        	this.animator.rotate(Right_Lower_Arm, -0.4f, 0, 0);
	        	
	        	this.animator.rotate(Left_Arm, -0.6f, 0, -1.f);
	        	this.animator.rotate(RightLowerArm, -1.6f, 0, 0);
	        	this.animator.rotate(Chest, 0.1f, -1, 0);
	        	this.animator.rotate(Head, 0, 0.6f, 0);
	        	
	        	this.animator.move(Torso, 0, -8, 0);
	        	
	        	
	        	this.animator.rotate(Right_Leg, -1, 0, 0);
	        	this.animator.rotate(Right_Lower_Leg, 1.3f, 0, 0);
	        	
	        	this.animator.rotate(Left_Leg, -0.5f, 0, 0);
	        	this.animator.rotate(Left_Lower_Leg, 1.f, 0, 0);
	        	
	        	this.animator.endKeyframe();
	        	
	        	//hold1
	        	this.animator.startKeyframe(2);
	        	
//	        	this.animator.rotate(RIGHT_HAND, 2f, 0, 0);
//	        	this.animator.move(RIGHT_HAND, 0, 16, -7);
	        	
	        	this.animator.rotate(Right_Arm, -1, 0, 1.3f);
	        	this.animator.rotate(Right_Lower_Arm, -0.4f, 0, 0);
	        	
	        	this.animator.rotate(Left_Arm, -0.6f, 0, -1.f);
	        	this.animator.rotate(RightLowerArm, -1.6f, 0, 0);
	        	this.animator.rotate(Chest, 0.1f, -1, 0);
	        	this.animator.rotate(Head, 0, 0.6f, 0);
	        	
	        	this.animator.rotate(Right_Leg, -1, 0, 0);
	        	this.animator.rotate(Right_Lower_Leg, 1.3f, 0, 0);
	        	
	        	this.animator.rotate(Left_Leg, -0.5f, 0, 0);
	        	this.animator.rotate(Left_Lower_Leg, 1.f, 0, 0);
	        	this.animator.move(Torso, 0, -3, 0);
	        	
	        	this.animator.endKeyframe();
	        	
	        	//Land
	        	this.animator.startKeyframe(5);

	        	
	        	this.animator.endKeyframe();
	        	
	        	//hold2
	           	this.animator.startKeyframe(2);

	        	
	        	this.animator.endKeyframe();
	        	
	        	//END
	        	this.animator.startKeyframe(5);
	        	this.animator.rotate(Right_Arm, 0, 0, 0);
	        	this.animator.rotate(Chest, 0, 0, 0);
	        	
	        	this.animator.rotate(Left_Arm, 0, 0, 0);
	        	this.animator.rotate(RightLowerArm, 0, 0, 0);
	        	this.animator.endKeyframe();
	        	
        	}
        	
        	if (this.animator.setAnimation(CapabilityHandler.SWORD_ANIMATION)) {
        		//swing1
	        	this.animator.startKeyframe(4);
	        	this.animator.rotate(Right_Arm, -1, 0, 1.3f);
	        	this.animator.rotate(Right_Lower_Arm, -0.4f, 0, 0);
	        	
	        	this.animator.rotate(Left_Arm, -0.6f, 0, -1.f);
	        	this.animator.rotate(RightLowerArm, -1.6f, 0, 0);
	        	this.animator.rotate(Chest, 0.1f, -1, 0);
	        	this.animator.rotate(Head, 0, 0.6f, 0);
	        	
	        	this.animator.endKeyframe();
	        	
	        	//swing2
	        	this.animator.startKeyframe(4);
	        	this.animator.rotate(Right_Arm, 0.5f, 0, 1.3f);
	        	
	        	this.animator.rotate(Left_Arm, 0.5f, 0, -0.7f);
	        	this.animator.rotate(RightLowerArm, -0.5f, 0, 0);
	        	
	        	this.animator.rotate(Chest, 0, 0, 0);
	        	this.animator.rotate(Head, 0, 0, 0);
	        	
	        	this.animator.move(Torso, 0, -8, 0);
	        	
	        	
	        	this.animator.rotate(Right_Leg, -1, 0, 0);
	        	this.animator.rotate(Right_Lower_Leg, 1.3f, 0, 0);
	        	
	        	this.animator.rotate(Left_Leg, -0.5f, 0, 0);
	        	this.animator.rotate(Left_Lower_Leg, 1.f, 0, 0);
	        	
	        	this.animator.endKeyframe();
	        	
	        	//hold1
	        	this.animator.startKeyframe(2);
	        	this.animator.rotate(Right_Arm, 0.5f, 0, 1.3f);
	        	
	        	
	        	
	        	this.animator.rotate(Left_Arm, 0.5f, 0, -0.7f);
	        	this.animator.rotate(RightLowerArm, -0.5f, 0, 0);
	        	
	        	this.animator.rotate(Chest, 0, 0, 0);
	        	this.animator.rotate(Head, 0, 0, 0);
	        	
	        	this.animator.rotate(Right_Leg, -1, 0, 0);
	        	this.animator.rotate(Right_Lower_Leg, 1.3f, 0, 0);
	        	
	        	this.animator.rotate(Left_Leg, -0.5f, 0, 0);
	        	this.animator.rotate(Left_Lower_Leg, 1.f, 0, 0);
	        	this.animator.move(Torso, 0, -3, 0);
	        	this.animator.endKeyframe();
	        	
	        	//Land
	        	this.animator.startKeyframe(5);

	        	
	        	this.animator.endKeyframe();
	        	
	        	//hold2
	           	this.animator.startKeyframe(2);

	        	
	        	this.animator.endKeyframe();
	        	
	        	//END
	        	this.animator.startKeyframe(5);
	        	this.animator.rotate(Right_Arm, 0, 0, 0);
	        	this.animator.rotate(Chest, 0, 0, 0);
	        	
	        	this.animator.rotate(Left_Arm, 0, 0, 0);
	        	this.animator.rotate(RightLowerArm, 0, 0, 0);
	        	this.animator.endKeyframe();
	        	
        	}
    	}
    }
    
    
    
    
    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
    	GlStateManager.scale(0.52F, 0.52F, 0.52F);
	    GlStateManager.translate(0.0F, 0.50F * f5, -0.35F);
		resetToDefaultPose();
		
	    float upwardPose = (float) (1 / (1 + Math.exp(-10 * (entity.motionY + 0.2))));
        float downwardPose = (float) (1 / (1 + Math.exp(10 * (entity.motionY + 0.2))));
        int backwardInverter = 1;
        
        //fun stuff
//        this.Right_Shoulder.setScale(1.F, 1.F, 1.F);
//        Right_Shoulder.scaleChildren=true;
//        this.Left_Shoulder.setScale(1.F, 1.F, 1.F);
//        Left_Shoulder.scaleChildren=true;
//        
//        this.Head.setScale(1.F, 1.F, 1.F);
//        Head.scaleChildren=true;
        
//        this.RIGHT_HAND.offsetX=-2*f5;
//        this.RIGHT_HAND.offsetY=-2*f5;
        Head.rotateAngleY= (f3) / (180F / 3.14f);
        Head.rotateAngleX= (f4) / (180F / 3.14f);
        
        
        float globalSpeed = 0.3F;
        float globalDegree = 0.5F ;
        float height = 2.F;
        
      //Sneaking
        if (isSneak){
        	Right_Arm.rotateAngleX = 0.3F;
			Left_Arm.rotateAngleX = 0.3F;
	
			Right_Arm.rotateAngleZ = 0.4F;
			Left_Arm.rotateAngleZ = -0.4F;

			Right_Lower_Arm.rotateAngleX = -1.1F;
			RightLowerArm.rotateAngleX = -1.1F;

			Right_Lower_Arm.rotateAngleY = -0.2F;
			RightLowerArm.rotateAngleY = 0.2F;
			
			Chest.rotateAngleX= 0.3F;
			Torso.rotateAngleX= 0.1F;
			Head.rotateAngleX= -0.2F;
			
			Right_Leg.rotateAngleX= -1;
			Left_Leg.rotateAngleX= -1;
			
			Right_Leg.rotateAngleY= 0.2F;
			Left_Leg.rotateAngleY= -0.2F;
			
			Right_Foot.rotateAngleX= -0.3F;
			Left_Foot.rotateAngleX= -0.3F;
			
			Right_Lower_Leg.rotateAngleX= 1.2F;
			Left_Lower_Leg.rotateAngleX= 1.2F;
			
			Megatron.rotationPointY= -35F;
			
        }
        
      //idle
        flap(Right_Arm, 0.08F, 0.02F, true, 0, -0.05f, f2, 1);
        flap(Left_Arm, 0.08F, 0.02F, false, 0, -0.05f, f2, 1);
        flap(Right_Shoulder, 0.08F, 0.02F, true, 0, 0.f, f2, 1);
        flap(Left_Shoulder, 0.08F, 0.02F, false, 0, 0.f, f2, 1);
        walk(Chest, 0.08F, 0.05F, false, 0, 0.1f, f2, 1);
       
        
        walk(Right_Arm, 0.08F, 0.1F, true, 0, 0.f, f2, 1);
        walk(Left_Arm, 0.08F, 0.1F, true, 0, 0.f, f2, 1);
        walk(Right_Lower_Arm, 0.08F, -0.05F, false, 0, -0.3f, f2, 1);
        walk(RightLowerArm, 0.08F, -0.005F, false, 0, -0.3f, f2, 1);
        swing(Right_Lower_Arm, 0.08F, 0.05F, true, 0, 0.1f, f2, 1);
        swing(RightLowerArm, 0.08F, 0.05F, false, 0, 0.1f, f2, 1);
        
        
        if(!isSneak){
        walk(Torso, 0.08F, 0.05F, false, 0, 0.f, f2, 1);
        walk(Right_Leg, 0.08F, 0.1F, true, 0, 0.f, f2, 1);
        walk(Left_Leg, 0.08F, 0.1F, true, 0, 0.f, f2, 1);
        walk(Right_Lower_Leg, 0.08F, 0.1F, false, 0, 0.f, f2, 1);
        walk(Left_Lower_Leg, 0.08F, 0.1F, false, 0, 0.f, f2, 1);
        walk(Right_Foot, 0.08F, 0.05F, true, 0, 0.f, f2, 1);
        walk(Left_Foot, 0.08F, 0.05F, true, 0, 0.f, f2, 1);
        bob(Torso, 0.08F, 0.01F, false, f2, 1);}
        
        //walking
        walk(Right_Leg, 1f* globalSpeed, 1F* globalDegree, true, 2, 0.1f, f, f1);
        walk(Left_Leg, 1f* globalSpeed, 1F* globalDegree, false, 2, 0.1f, f, f1);
          
        walk(Right_Lower_Leg, 1f * globalSpeed,  -.8F * globalDegree, false, 0F, 0.5F, f, f1);     
        walk(Right_Foot, 1f * globalSpeed,  -.8F * globalDegree, true, -2.5F, -0.25F, f, f1);
        
        walk(Left_Lower_Leg, 1f * globalSpeed,  -.8F * globalDegree, true, 0F, -0.5F, f, f1);     
        walk(Left_Foot, 1f * globalSpeed,  -.8F * globalDegree, false, -2.5F, 0.25F, f, f1);
        
        walk(Right_Arm, 1f* globalSpeed, 0.3F* globalDegree, false, 2, -0.05f, f, f1);
        walk(Left_Arm, 1f* globalSpeed, 0.3F* globalDegree, true, 2, 0.05f, f, f1);
        walk(Right_Shoulder, 1f* globalSpeed, 0.4F* globalDegree, false, 2, -0.2f, f, f1);
        walk(Left_Shoulder, 1f* globalSpeed, 0.4F* globalDegree, true, 2, 0.2f, f, f1);
        
        walk(Right_Lower_Arm, 1f* globalSpeed, 0.05F* globalDegree, true, 5, 0.2f, f, f1);
        walk(RightLowerArm, 1f* globalSpeed, 0.05F* globalDegree, false, 5, -0.2f, f, f1);
        
        swing(Right_Arm, 1f* globalSpeed, 0.3f*globalDegree, false, 0, 0, f, f1);
        swing(Left_Arm, 1f* globalSpeed, 0.3f*globalDegree, false, 0, 0, f, f1);
        
        swing(Chest, 1f* globalSpeed, 0.3f*globalDegree, true, 0, 0, f, f1);
//        swing(Torso, 1.5f* globalSpeed, 0.3f*globalDegree, true, 0, 0, f, f1);
        walk(Chest, 2f* globalSpeed, 0.05f*globalDegree, true, 0, -0.1f, f, f1);
        
        swing(Head, 1f* globalSpeed, 0.3f*globalDegree, false, 0, 0, f, f1);
        walk(Head, 2f* globalSpeed, 0.05f*globalDegree, false, 0, -0.1f, f, f1);
        
        bob(Megatron,2f* globalSpeed, 1f*height, false, f, f1);
        walk(Torso, 2f* globalSpeed, 0.05f*globalDegree, false, 0, 0.05f, f, f1);
        
        walk(Right_Leg, 2f* globalSpeed, 0.05f*globalDegree, true, 0, 0.05f, f, f1);
        walk(Left_Leg, 2f* globalSpeed, 0.05f*globalDegree, true, 0, 0.05f, f, f1);
        
        
        
       
        
     
        
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

        
					this.Chest.rotateAngleX = 0.4F *downwardPose;
					this.Torso.rotateAngleX = -.2F *downwardPose;
//					this.Torso2.rotateAngleX = 0.2F *downwardPose;
        
					Right_Shoulder.rotateAngleX = 0.5F*downwardPose;
					Left_Shoulder.rotateAngleX = 0.5F*downwardPose;
      	
					Right_Arm.rotateAngleX = 0.1F*downwardPose;
					Left_Arm.rotateAngleX = 0.1F*downwardPose;
      	
					Right_Shoulder.rotateAngleZ = 0.2F *downwardPose;
					Left_Shoulder.rotateAngleZ = -0.2F *downwardPose;
					
					Right_Arm.rotateAngleZ = 0.2F *downwardPose;
					Left_Arm.rotateAngleZ = -0.2F *downwardPose;
    
					Right_Lower_Arm.rotateAngleX = -1.1F *downwardPose;
					RightLowerArm.rotateAngleX = -1.1F *downwardPose;
    
					Right_Lower_Arm.rotateAngleY = -0.2F *downwardPose;
					RightLowerArm.rotateAngleY = 0.2F *downwardPose;
				}
			}
    }
    
//    @Override
//    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
//        
//        Animation animation = IAnimatedEntity.NO_ANIMATION;
//        float tick = 0;
//        
//        if (entitylivingbaseIn.hasCapability(EntityAnimatorProvider.ANIMATED_ENTITY_CAP, null)) {
//            IAnimatedEntity animator = entitylivingbaseIn.getCapability(EntityAnimatorProvider.ANIMATED_ENTITY_CAP, null);
//            animation = animator.getAnimation();
//            tick = animator.getAnimationTick() + partialTickTime;
//        }
//        
//        //do stuff with the animation info
//    }
//    
//    @SubscribeEvent
//    public static void onEntityTick(LivingUpdateEvent event) {
//        
//        EntityLivingBase entity = event.getEntityLiving();
//        
//        if (entity.hasCapability(EntityAnimatorProvider.ANIMATED_ENTITY_CAP, null)) {
//            IAnimatedEntity animator = entity.getCapability(EntityAnimatorProvider.ANIMATED_ENTITY_CAP, null);
//            animator.setAnimationTick(animator.getAnimationTick() + 1);
//        }
//        
//        //set animations here I guess, or you could move this event to a new class.
//        
//    }

}
