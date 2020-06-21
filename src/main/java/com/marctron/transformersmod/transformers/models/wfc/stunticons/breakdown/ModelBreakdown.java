package com.marctron.transformersmod.transformers.models.wfc.stunticons.breakdown;

import com.marctron.transformersmod.capabilities.EntityAnimatorProvider;
import com.marctron.transformersmod.items.gun.IGun;
import com.marctron.transformersmod.items.gun.ItemGunBase;
import com.marctron.transformersmod.transformers.models.AdvancedModelBipedRenderer;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;
import com.marctron.transformersmod.util.handlers.CapabilityHandler;

import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ModelBreakdown extends ModelBreakdownBody{

	 public AdvancedModelBipedRenderer LEFT_HAND;
	 public AdvancedModelBipedRenderer RIGHT_HAND;
	 
	 private ModelAnimator animator = ModelAnimator.create();
	
	public ModelBreakdown()
    {
		 	LEFT_HAND = new AdvancedModelBipedRenderer(this, "LEFT_HAND").setTextureOffset(0, 457);
	        LEFT_HAND.mirror = true;
	        LEFT_HAND.setRotationPoint(0.0F, 0F, 0F);
	        LEFT_HAND.addBox(0.0F, 0.0F, -1.9F, 3, 2, 3, 0.0F);
	        
	        RIGHT_HAND = new AdvancedModelBipedRenderer(this, "RIGHT_HAND").setTextureOffset(0, 457);
	        RIGHT_HAND.mirror = true;
	        RIGHT_HAND.setRotationPoint(-2.0F, 2.0F, -30F);
	        RIGHT_HAND.addBox(0.0F, 0.0F, 0F, 3, 2, 3, 0.0F);
		

		Chest.addChild(Left_Arm);
		Chest.addChild(Right_Arm);
		
		Left_Lower_Arm.addChild(LEFT_HAND);
		Right_Lower_Arm.addChild(RIGHT_HAND);
		
    }
	
	 @Override
	    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	    {
		 	((ModelBiped)((ItemArmorTransformer)entity.getArmorInventoryList().iterator().next().getItem()).getRenderer().getMainModel()).bipedLeftArm = this.LEFT_HAND;
	    	((ModelBiped)((ItemArmorTransformer)entity.getArmorInventoryList().iterator().next().getItem()).getRenderer().getMainModel()).bipedRightArm = this.RIGHT_HAND;
//	    	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	        
	       
	        Torso.render(f5);
	        Chest.render(f5);  
	        
	  
	    }
	 
	 @Override
	    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
	    	
	    	if (this.bipedBody.showModel && entitylivingbaseIn.hasCapability(EntityAnimatorProvider.ANIMATED_ENTITY_CAP, null)) {
	    		
	    		IAnimatedEntity animationState = entitylivingbaseIn.getCapability(EntityAnimatorProvider.ANIMATED_ENTITY_CAP, null);
	    		this.animator.update(animationState);
	        	
	        	//do stuff with the animation info
	    		
	    		if (this.animator.setAnimation(CapabilityHandler.RELOAD_ANIMATION)) {
	    			this.animator.startKeyframe(3);
	    			this.animator.rotate(Right_Arm, -.90f, -0.7f, 0.4f);
	    			this.animator.rotate(Right_Lower_Arm, -.60f, 0, 0);
	    			this.animator.endKeyframe();
	    			//swing1
	    			this.animator.startKeyframe(4);
	    			this.animator.rotate(Right_Arm, -.90f, -0.7f, 0.4f);
	    			this.animator.rotate(Right_Lower_Arm, -.60f, 0, 0);

	    			this.animator.rotate(Left_Arm, -1.2f, 0, 0.2f);
	    			this.animator.rotate(Left_Lower_Arm, -0.4f, 0, 0.2f);
	    			
	    			this.animator.endKeyframe();
	    			
	    			//hold1
	    			this.animator.startKeyframe(5);
	    			this.animator.rotate(Right_Arm, -.90f, -0.7f, 0.4f);
	    			this.animator.rotate(Right_Lower_Arm, -.60f, 0, 0);
	    			this.animator.rotate(Left_Arm, -0.9f, 0, 0.2f);
	    			this.animator.rotate(Left_Lower_Arm, -0.1f, 0.2f, 0.2f);
	    			this.animator.endKeyframe();
	    			
	    			//hold1
	    			this.animator.startKeyframe(5);
	    			this.animator.rotate(Right_Arm, -.90f, -0.7f, 0.4f);
	    			this.animator.rotate(Right_Lower_Arm, -.60f, 0, 0);
	    			this.animator.rotate(Left_Arm, -0.9f, 0, 0.2f);
	    			this.animator.rotate(Left_Lower_Arm, -0.1f, 0, 0.2f);
	    			this.animator.endKeyframe();
	    			
	    			//End
	    			this.animator.startKeyframe(10);
	    			this.animator.rotate(Right_Arm, 0f, 0, 0f);
	    			this.animator.rotate(Right_Lower_Arm, -.0f, 0, 0);
	    			this.animator.endKeyframe();
	    		}
	    		
	        	if (this.animator.setAnimation(CapabilityHandler.PUNCH_ANIMATION)) {
	        		//swing
		        	this.animator.startKeyframe(3);
		        	this.animator.rotate(Right_Arm, -1.4f, 0, 0.3f);
		        	this.animator.rotate(Right_Lower_Arm, -1.4f, 0.1f, 0);
		        	
		        	this.animator.rotate(Left_Arm, 0.4f, 0, -0.1f);
		        	this.animator.rotate(Left_Lower_Arm, -0.8f, -0.1f, 0);
		        	
		        	this.animator.rotate(Chest, 0, -0.5f, 0);
		        	this.animator.rotate(Head, 0, 0.4f, 0);
		        	
		        	this.animator.endKeyframe();
		        	//hold
		        	this.animator.startKeyframe(2);
		        	this.animator.rotate(Right_Arm, -1.4f, 0, 0.3f);
		        	this.animator.rotate(Right_Lower_Arm, -1.4f, 0.1f, 0);
		        	
		        	this.animator.rotate(Left_Arm, 0.4f, 0, -0.1f);
		        	this.animator.rotate(Left_Lower_Arm, -0.8f, -0.1f, 0);
		        	
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
		        	this.animator.rotate(Left_Lower_Arm, 0, 0, 0);
		        	this.animator.endKeyframe();
		        	
	        	}
	        	
	        	if (this.animator.setAnimation(CapabilityHandler.AXE_ANIMATION)) {
	        		//swing1
		        	this.animator.startKeyframe(5);
		        	this.animator.rotate(Right_Arm, -2, 0, 0);
		        	this.animator.rotate(Right_Lower_Arm, -1f, 0, 0);
		        	
		        	this.animator.rotate(Left_Arm, -1, 0, -1);
		        	this.animator.rotate(Left_Lower_Arm, -1f, 0, 0);
		        	
		        	this.animator.rotate(Chest, -0.1f, 0.7f, 0);
		        	this.animator.rotate(Head, -0.1f, -0.3f, 0);
		        	this.animator.endKeyframe();
		        	//hold1
		        	this.animator.startKeyframe(3);
		        	this.animator.rotate(Right_Arm, -2, 0, 0);
		        	this.animator.rotate(Right_Lower_Arm, -0.5f, 0, 0);
		        	
		        	this.animator.rotate(Left_Arm, -1, 0, -1);
		        	this.animator.rotate(Left_Lower_Arm, -1f, 0, 0);
		        	this.animator.endKeyframe();
		        	
		        	//swing2
		        	this.animator.startKeyframe(3);
		        	this.animator.rotate(Right_Arm, -0.2f, 0, 0);
		        	this.animator.rotate(Right_Lower_Arm, -0.1f, 0, 0);
		        	
		        	this.animator.rotate(Left_Arm, 0, 0, 0);
		        	this.animator.rotate(Left_Lower_Arm, 0, 0, 0);
		        	this.animator.endKeyframe();
		        	
		        	//hold2
		        	this.animator.startKeyframe(1);
		        	this.animator.rotate(Right_Arm, -0.2f, 0, 0);
		        	this.animator.rotate(Right_Lower_Arm, -0.1f, 0, 0);
		        	
		        	this.animator.rotate(Left_Arm, 0, 0, 0);
		        	this.animator.rotate(Left_Lower_Arm, 0, 0, 0);
		        	this.animator.endKeyframe();
		        	
		        	//END
		        	this.animator.startKeyframe(3);
		        	this.animator.rotate(Right_Arm, -0f, 0, 0);
		        	this.animator.rotate(Right_Lower_Arm, -0f, 0, 0);
		        	
		        	this.animator.rotate(Left_Arm, 0, 0, 0);
		        	this.animator.rotate(Left_Lower_Arm, 0, 0, 0);
		        	this.animator.endKeyframe();
		        	
	        	}
	        	
	        	if (this.animator.setAnimation(CapabilityHandler.SWORD_REVERSE_ANIMATION)) {
	        		//swing1
		        	this.animator.startKeyframe(4);
		        	this.animator.rotate(Right_Arm, 0.5f, 0, 1.3f);
		        	
		        	this.animator.rotate(RIGHT_HAND, 2f, 0, 0);
		        	this.animator.move(RIGHT_HAND, 0, 16, -7);
		        	
		        	this.animator.rotate(Left_Arm, 0.5f, 0, -0.7f);
		        	this.animator.rotate(Left_Lower_Arm, -0.5f, 0, 0);
		        	
		        	this.animator.rotate(Chest, 0.1f, 0.4f, 0);
		        	this.animator.rotate(Head, 0, 0, 0);
		        	
		        	
		        	
		        	this.animator.endKeyframe();
		        	
		        	//swing2
		        	this.animator.startKeyframe(4);
		        	
		        	this.animator.rotate(RIGHT_HAND, 2f, 0, 0);
		        	this.animator.move(RIGHT_HAND, 0, 16, -7);
		        	
		        	this.animator.rotate(Right_Arm, -1, 0, 1.3f);
		        	this.animator.rotate(Right_Lower_Arm, -0.4f, 0, 0);
		        	
		        	this.animator.rotate(Left_Arm, -0.6f, 0, -1.f);
		        	this.animator.rotate(Left_Lower_Arm, -1.6f, 0, 0);
		        	this.animator.rotate(Chest, 0.1f, -1, 0);
		        	this.animator.rotate(Head, 0, 0.6f, 0);
		        	
		        	this.animator.move(Torso, 0, -8, 0);
		        	this.animator.move(Chest, 0, -8, 0);
		        	
		        	
		        	
		        	this.animator.rotate(Right_Leg, -1, 0, 0);
		        	this.animator.rotate(Right_Lower_Leg, 1.3f, 0, 0);
		        	
		        	this.animator.rotate(Left_Leg, -0.5f, 0, 0);
		        	this.animator.rotate(Left_Lower_Leg, 1.f, 0, 0);
		        	
		        	this.animator.endKeyframe();
		        	
		        	//hold1
		        	this.animator.startKeyframe(2);
		        	
		        	this.animator.rotate(RIGHT_HAND, 2f, 0, 0);
		        	this.animator.move(RIGHT_HAND, 0, 16, -7);
		        	this.RIGHT_HAND.setScale(0.001f, 0.001f, 0.001f);
		        	
		        	this.animator.rotate(Right_Arm, -1, 0, 1.3f);
		        	this.animator.rotate(Right_Lower_Arm, -0.4f, 0, 0);
		        	
		        	this.animator.rotate(Left_Arm, -0.6f, 0, -1.f);
		        	this.animator.rotate(Left_Lower_Arm, -1.6f, 0, 0);
		        	this.animator.rotate(Chest, 0.1f, -1, 0);
		        	this.animator.rotate(Head, 0, 0.6f, 0);
		        	
		        	this.animator.rotate(Right_Leg, -1, 0, 0);
		        	this.animator.rotate(Right_Lower_Leg, 1.3f, 0, 0);
		        	
		        	this.animator.rotate(Left_Leg, -0.5f, 0, 0);
		        	this.animator.rotate(Left_Lower_Leg, 1.f, 0, 0);
		        	this.animator.move(Torso, 0, -3, 0);
		        	this.animator.move(Chest, 0, -3, 0);
		        	
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
		        	this.animator.rotate(Left_Lower_Arm, 0, 0, 0);
		        	this.animator.endKeyframe();
		        	
	        	}
	        	
	        	if (this.animator.setAnimation(CapabilityHandler.SWORD_ANIMATION)) {
	        		//swing1
		        	this.animator.startKeyframe(4);
		        	this.animator.rotate(Right_Arm, -1, 0, 1.3f);
		        	this.animator.rotate(Right_Lower_Arm, -0.4f, 0, 0);
		        	
		        	this.animator.rotate(Left_Arm, -0.6f, 0, -1.f);
		        	this.animator.rotate(Left_Lower_Arm, -1.6f, 0, 0);
		        	this.animator.rotate(Chest, 0.1f, -1, 0);
		        	this.animator.rotate(Head, 0, 0.6f, 0);
		        	
		        	this.animator.endKeyframe();
		        	
		        	//swing2
		        	this.animator.startKeyframe(4);
		        	this.animator.rotate(Right_Arm, 0.5f, 0, 1.3f);
		        	
		        	this.animator.rotate(Left_Arm, 0.5f, 0, -0.7f);
		        	this.animator.rotate(Left_Lower_Arm, -0.5f, 0, 0);
		        	
		        	this.animator.rotate(Chest, 0, 0, 0);
		        	this.animator.rotate(Head, 0, 0, 0);
		        	
		        	this.animator.move(Torso, 0, -8, 0);
		        	this.animator.move(Chest, 0, -8, 0);
		        	
		        	
		        	this.animator.rotate(Right_Leg, -1, 0, 0);
		        	this.animator.rotate(Right_Lower_Leg, 1.3f, 0, 0);
		        	
		        	this.animator.rotate(Left_Leg, -0.5f, 0, 0);
		        	this.animator.rotate(Left_Lower_Leg, 1.f, 0, 0);
		        	
		        	this.animator.endKeyframe();
		        	
		        	//hold1
		        	this.animator.startKeyframe(2);
		        	this.animator.rotate(Right_Arm, 0.5f, 0, 1.3f);
		        	
		        	
		        	
		        	this.animator.rotate(Left_Arm, 0.5f, 0, -0.7f);
		        	this.animator.rotate(Left_Lower_Arm, -0.5f, 0, 0);
		        	
		        	this.animator.rotate(Chest, 0, 0, 0);
		        	this.animator.rotate(Head, 0, 0, 0);
		        	
		        	this.animator.rotate(Right_Leg, -1, 0, 0);
		        	this.animator.rotate(Right_Lower_Leg, 1.3f, 0, 0);
		        	
		        	this.animator.rotate(Left_Leg, -0.5f, 0, 0);
		        	this.animator.rotate(Left_Lower_Leg, 1.f, 0, 0);
		        	this.animator.move(Torso, 0, -3, 0);
		        	this.animator.move(Chest, 0, -3, 0);
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
		        	this.animator.rotate(Left_Lower_Arm, 0, 0, 0);
		        	this.animator.endKeyframe();
		        	
	        	}
	    	}
	    }
	 
	 @Override
	    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
	        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);


	        Left_Arm.rotationPointZ=50*f5;
	        Left_Arm.rotationPointY=-3*f5;
	        
	        Right_Arm.rotationPointZ=50*f5;
	        Right_Arm.rotationPointY=-3*f5;
	        
	        RIGHT_HAND.rotationPointY=4;
	        RIGHT_HAND.rotationPointX=1;
	        
	        LEFT_HAND.rotationPointY=4;
	        LEFT_HAND.rotationPointX=-1;
	        
	        
	        GlStateManager.scale(0.45F, 0.45F, 0.45F);
	        GlStateManager.translate(-2.0F * f5, -1F * f5, -1);  
	        

            float upwardPose = (float) (1 / (1 + Math.exp(-20 * (entity.motionY + 0.01))));
    		float downwardPose = (float) (1 / (1 + Math.exp(10 * (entity.motionY + 0.2))));
    		int backwardInverter = 1;
	        
	        float globalSpeed = 0.4F;
	        float globalDegree = 0.5F ;
	        float height = 2.F;
	        
	 	    walk(Left_Arm, 1 * globalSpeed,  -1.F * globalDegree, true, 0.6F, 0.F, f, f1);
	        
	        walk(Left_Lower_Arm, 1 * globalSpeed,  -.9F * globalDegree, true, -.6F, 0.6F, f, f1);
	        
	        walk(Right_Arm, 1 * globalSpeed,  1.F * globalDegree, true, 0.6F, 0.F, f, f1);
	        
	        walk(Right_Lower_Arm, 1 * globalSpeed,  .9F * globalDegree, true, -.6F, 0.6F, f, f1);
	        
	        //sneak
	        if (isSneak){
	        	RIGHT_HAND.rotationPointY=1;
	        	Right_Arm.rotateAngleX = 0.3F;
				Left_Arm.rotateAngleX = 0.3F;
		
				Right_Arm.rotateAngleZ = 0.4F;
				Left_Arm.rotateAngleZ = -0.4F;

				Right_Lower_Arm.rotateAngleX = -1.1F;
				Left_Lower_Arm.rotateAngleX = -1.1F;

				Right_Lower_Arm.rotateAngleY = -0.2F;
				Left_Lower_Arm.rotateAngleY = 0.2F;
				
				Chest.rotationPointZ= 8F;
				Chest.rotationPointY= 7F;
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
				
				Torso.rotationPointY= 25F;
				
	        }
	        
	        //idle
	        flap(Right_Arm, 0.08F, 0.05F, true, 0, 0.f, f2, 1);
	        flap(Left_Arm, 0.08F, 0.05F, false, 0, 0.f, f2, 1);
	        walk(Chest, 0.08F, 0.05F, false, 0, 0.1f, f2, 1);
	       
	        
	        walk(Right_Arm, 0.08F, 0.1F, true, 0, 0.f, f2, 1);
	        walk(Left_Arm, 0.08F, 0.1F, true, 0, 0.f, f2, 1);
	        walk(Right_Lower_Arm, 0.08F, 0.2F, false, 0, -0.1f, f2, 1);
	        walk(Left_Lower_Arm, 0.08F, 0.2F, false, 0, -0.1f, f2, 1);
	        swing(Right_Lower_Arm, 0.08F, 0.1F, false, 0, -0.1f, f2, 1);
	        swing(Left_Lower_Arm, 0.08F, 0.1F, true, 0, -0.1f, f2, 1);
	        
	        
	        if(!isSneak){
	        walk(Torso, 0.08F, 0.05F, false, 0, 0.f, f2, 1);
	        walk(Right_Leg, 0.08F, 0.1F, true, 0, 0.f, f2, 1);
	        walk(Left_Leg, 0.08F, 0.1F, true, 0, 0.f, f2, 1);
	        walk(Right_Lower_Leg, 0.08F, 0.1F, false, 0, 0.f, f2, 1);
	        walk(Left_Lower_Leg, 0.08F, 0.1F, false, 0, 0.f, f2, 1);
	        walk(Right_Foot, 0.08F, 0.05F, true, 0, 0.f, f2, 1);
	        walk(Left_Foot, 0.08F, 0.05F, true, 0, 0.f, f2, 1);
	        bob(Torso, 0.08F, 0.01F, false, f2, 1);}
	        
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
//						this.Torso2.rotateAngleX = 0.2F *downwardPose;
	        
	      	
						Right_Arm.rotateAngleX = 0.6F*downwardPose;
						Left_Arm.rotateAngleX = 0.6F*downwardPose;
	      	
						Right_Arm.rotateAngleZ = 0.4F *downwardPose;
						Left_Arm.rotateAngleZ = -0.4F *downwardPose;
	    
						Right_Lower_Arm.rotateAngleX = -1.1F *downwardPose;
						Left_Lower_Arm.rotateAngleX = -1.1F *downwardPose;
	    
						Right_Lower_Arm.rotateAngleY = -0.2F *downwardPose;
						Left_Lower_Arm.rotateAngleY = 0.2F *downwardPose;
					}
				}
	        
	        
	        if (entity instanceof EntityPlayer)
	        {
	        	ItemStack stack = ((EntityPlayer) entity).getHeldItemMainhand();
	        
	        	
	        	
	        	if (stack.getItem() instanceof com.marctron.transformersmod.items.gun.Scrapper) {
	                IGun nbt = ((IGun) stack.getItem());
	                if (nbt.getBoolean("Gun")) {
//	                	if (CapabilityHandler.isReloading){
	                			this.Right_Arm.rotateAngleY = this.Head.rotateAngleY;
	                			this.Right_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX*0.5F + 0.4F;
	                			swing(Right_Lower_Arm, 0.08F, 0.1F, true, 0, -0.1f, f2, 1);
	                			walk(Right_Arm, 0.08F, 0.1F, true, 0, 0.f, f2, 1);
	                			this.Right_Lower_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX*0.5F + 1F;
	                			this.Right_Lower_Arm.scaleChildren=true;
		                		this.Right_Lower_Arm.setScale(0.1F, 0.1F, 0.1F);
		                		RIGHT_HAND.rotationPointY=-10;
		                		if (isSneak){
		                			RIGHT_HAND.rotationPointZ=-2;
		                			RIGHT_HAND.rotationPointX=-0.5F;
		                		}
//	                	}
	                }
	        	}
	        	
	        	if (stack.getItem() instanceof com.marctron.transformersmod.items.gun.EnergonBattlePistol) {
	                IGun nbt = ((IGun) stack.getItem());
	                if (nbt.getBoolean("Gun")) {
	        		
//	                	if (CapabilityHandler.isReloading){
	                		this.Right_Arm.rotateAngleY = this.Head.rotateAngleY;
	                		this.Right_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX *1.2F + 0.5F;
	                		swing(Right_Lower_Arm, 0.08F, 0.1F, true, 0, -0.1f, f2, 1);
	                		walk(Right_Arm, 0.08F, 0.1F, true, 0, 0.f, f2, 1);
	                		this.Right_Lower_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX*0.8F + 1.3F;
	                		this.Right_Lower_Arm.scaleChildren=true;
	                		this.Right_Lower_Arm.setScale(0.1F, 0.1F, 0.1F);
	                		RIGHT_HAND.rotationPointY=-10;
	                		if (isSneak){
	                			RIGHT_HAND.rotationPointZ=-2;
	                			RIGHT_HAND.rotationPointX=-0.5F;
	                		}
//	                	}
	                }
	                
	        	}
	        	
	        	else if (stack.getItem() instanceof com.marctron.transformersmod.items.gun.RocketLauncher) {
	                IGun nbt = ((IGun) stack.getItem());
	                if (nbt.getBoolean("Gun")) {
	        		
//	                	if (CapabilityHandler.isReloading){
	                		this.Right_Arm.rotateAngleY = this.Head.rotateAngleY;
	                		this.Right_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX *1.2F + 0.9F;
	                		swing(Right_Lower_Arm, 0.08F, 0.1F, true, 0, -0.1f, f2, 1);
	                		walk(Right_Arm, 0.08F, 0.1F, true, 0, 0.f, f2, 1);
	                		this.Right_Lower_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX*0.2F + 1.0F;
	                		this.Right_Lower_Arm.scaleChildren=true;
	                		this.Right_Lower_Arm.setScale(0.1F, 0.1F, 0.1F);
	                		RIGHT_HAND.rotationPointY=-10;
	                		if (isSneak){
	                			RIGHT_HAND.rotationPointZ=-2;
	                			RIGHT_HAND.rotationPointX=-0.5F;
	                		}
//	                	}
	                }
	                
	        	}
	        	else
//	            	this.Right_Lower_Arm.scaleChildren=false;
	    			this.Right_Lower_Arm.setScale(1F, 1F, 1F);
	        }
	 }
}
