package com.marctron.transformersmod.transformers.models.wfc.autobots.sideswipe;

import com.marctron.transformersmod.items.gun.IGun;
import com.marctron.transformersmod.items.gun.RocketLauncher;
import com.marctron.transformersmod.transformers.models.AdvancedModelBipedRenderer;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;

import net.ilexiconn.llibrary.client.model.ModelAnimator;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ModelWFCSideswipe extends ModelWFCSideswipeA{
	
	 public AdvancedModelBipedRenderer LEFT_HAND;
	 public AdvancedModelBipedRenderer RIGHT_HAND;
	 
	 private ModelAnimator animator = ModelAnimator.create();
	 
	public ModelWFCSideswipe()
	{
	 	LEFT_HAND = new AdvancedModelBipedRenderer(this, "LEFT_HAND").setTextureOffset(0, 457);
        LEFT_HAND.mirror = true;
        LEFT_HAND.setRotationPoint(0.0F, 0F, 0F);
        LEFT_HAND.addBox(0.0F, 0.0F, -1.9F, 3, 2, 3, 0.0F);
        
        RIGHT_HAND = new AdvancedModelBipedRenderer(this, "RIGHT_HAND").setTextureOffset(0, 457);
        RIGHT_HAND.mirror = true;
        RIGHT_HAND.setRotationPoint(-2.0F, 2.0F, -30F);
        RIGHT_HAND.addBox(0.0F, 0.0F, 0F, 3, 2, 3, 0.0F);
	
        Right_Lower_Arm_1.addChild(LEFT_HAND);
        Right_Lower_Arm.addChild(RIGHT_HAND);
        
        updateDefaultPose();
	}
	
	@Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
	 	((ModelBiped)((ItemArmorTransformer)entity.getArmorInventoryList().iterator().next().getItem()).getRenderer().getMainModel()).bipedLeftArm = this.LEFT_HAND;
    	((ModelBiped)((ItemArmorTransformer)entity.getArmorInventoryList().iterator().next().getItem()).getRenderer().getMainModel()).bipedRightArm = this.RIGHT_HAND;
        
       
        Waist.render(f5);
    }
	
	 @Override
	 public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) 
	 {
		 super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		 
		 GlStateManager.scale(0.32F, 0.32F, 0.32F);
	     GlStateManager.translate(0F * f5, 12.5F * f5, 4 * f5);  
	     
	     resetToDefaultPose();
	     
	     float upwardPose = (float) (1 / (1 + Math.exp(-20 * (entity.motionY + 0.01))));
	     float downwardPose = (float) (1 / (1 + Math.exp(10 * (entity.motionY + 0.2))));
	     int backwardInverter = 1;
	        
	     float globalSpeed = 0.4F;
	     float globalDegree = 0.35F ;
	     float height = 4.0F;
	     
//	     f = f2;
//	     f1 = 0.5F;
	     
	     RIGHT_HAND.rotationPointX=0;
	     RIGHT_HAND.rotationPointZ=-3;
	     RIGHT_HAND.rotationPointY=8;
	     
	     LEFT_HAND.rotationPointX=0;
	     LEFT_HAND.rotationPointZ=-3;
	     LEFT_HAND.rotationPointY=8;
	     
	     Head.rotateAngleX=bipedHead.rotateAngleX;
	     Head.rotateAngleY=bipedHead.rotateAngleY;
	     
	     //walking
	     	bob(Waist, 2*globalSpeed, height, false, f, f1);
	     	swing(Chest, globalSpeed, 0.75F * globalDegree, false, 0, 0, f, f1);
	     	walk(Chest, 2*globalSpeed, 0.2F * globalDegree, false, 0, 0.25F, f, f1);
	     	swing(Head, globalSpeed, 0.75F * globalDegree, true, 0, 0, f, f1);
	     	swing(Torso, 1.F*globalSpeed, 0.25F * globalDegree, false, 0, 0, f, f1);
	     	swing(Waist, 1.F*globalSpeed, 0.25F * globalDegree, true, 0, 0, f, f1);
	     
	     	walk(Right_Arm, globalSpeed, 1.5F*globalDegree, false, 0, 0, f, f1);
	     	swing(Right_Arm, globalSpeed, globalDegree, false, 0, 0, f, f1);
	     	flap(Right_Arm, globalSpeed, 0.2F*globalDegree, false, 0, 0, f, f1);
	     	
	     	walk(Right_Lower_Arm, globalSpeed, 1.5F*globalDegree, false, 0, -0.5F, f, f1);
	     	
	     	walk(Right_Arm_1, globalSpeed, 1.5F*globalDegree, true, 0, 0, f, f1);
	     	swing(Right_Arm_1, globalSpeed, globalDegree, false, 0, 0, f, f1);
	     	flap(Right_Arm_1, globalSpeed, 0.2F*globalDegree, false, 0, 0, f, f1);
	     	
	     	walk(Right_Lower_Arm_1, globalSpeed, 1.5F*globalDegree, true, 0, 0.5F, f, f1);
	     	
	     	walk(leg, globalSpeed, 1.5F*globalDegree, true, 1, 0.25F, f, f1);
	     	walk(Right_Lower_Leg, globalSpeed, 1.5F*globalDegree, true, 0, -1.F, f, f1);
	     	walk(Right_Foot, globalSpeed, 1.F*globalDegree, true, -0.5F, -0.25F, f, f1);
	     	
	     	walk(leg_1, globalSpeed, 1.5F*globalDegree, false, 1, -0.25F, f, f1);
	     	walk(Right_Lower_Leg_1, globalSpeed, 1.5F*globalDegree, false, 0, 1.F, f, f1);
	     	walk(Right_Foot_1, globalSpeed, 1.F*globalDegree, false, -0.5F, 0.25F, f, f1);
	     	
	    //idle
	     	flap(Right_Arm, 0.08F, 0.05F, false, 0, 0, f2, 1);
	     	swing(Right_Lower_Arm, 0.08F, 0.1F, true, 0, 0.2F, f2, 1);
	     	walk(Right_Lower_Arm, 0.08F, 0.1F, true, 0, 0.1F, f2, 1);
	     	
	     	flap(Right_Arm_1, 0.08F, 0.05F, true, 0, 0, f2, 1);
	     	swing(Right_Lower_Arm_1, 0.08F, 0.1F, false, 0, 0.2F, f2, 1);
	     	walk(Right_Lower_Arm_1, 0.08F, 0.1F, true, 0, 0.1F, f2, 1);
	     	
	     	bob(Chest, 0.08F, -0.5F, false, f2, 1);
	     	bob(Waist, 0.08F, -0.4F, false, f2, 1);
	     	
	     	
	     	if (!isSneak){
	     		bob(Torso, 0.08F, 0.4F, false, f2, 1);
	     		walk(leg, 0.08F, 0.1F, false, 0, -0.1F, f2, 1);
	     		walk(leg_1, 0.08F, 0.1F, false, 0, -0.1F, f2, 1);
	     		walk(Right_Lower_Leg, 0.08F, 0.2F, true, 0, -0.1F, f2, 1);
	     		walk(Right_Lower_Leg_1, 0.08F, 0.2F, true, 0, -0.1F, f2, 1);
	     		walk(Right_Foot, 0.08F, 0.1F, false, 0, 0.0F, f2, 1);
	     		walk(Right_Foot_1, 0.08F, 0.1F, false, 0, 0.0F, f2, 1);
	     	}
	     	
	     //Sneak
	     	if (isSneak){
	     		leg.rotateAngleX=-1;
	     		leg_1.rotateAngleX=-1;
	     		leg.rotateAngleY=0.15F;
	     		leg_1.rotateAngleY=-0.15F;
	     		leg.rotateAngleZ=0.25F;
	     		leg_1.rotateAngleZ=-0.25F;
	     		Right_Lower_Leg.rotateAngleX=1.5F;
	     		Right_Lower_Leg_1.rotateAngleX=1.5F;
	     		Right_Foot.rotateAngleX=-0.5F;
	     		Right_Foot_1.rotateAngleX=-0.5F;
	     		Right_Foot.rotateAngleZ=-0.25F;
	     		Right_Foot_1.rotateAngleZ=0.25F;
	     		Waist.rotationPointY=22.5F;
	     		Torso.rotateAngleX=0.1F;
	     		Chest.rotateAngleX=0.1F;
	     		Right_Lower_Arm.rotateAngleX=-1.5F;
	     		Right_Lower_Arm_1.rotateAngleX=-1.5F;
	     	}
	     	
	     	
	     //jumping & falling
	     	  if (entity instanceof EntityPlayer)
	     	  {
					EntityPlayer player = (EntityPlayer) entity;
					if (!player.onGround  && !player.capabilities.isFlying)
					{
						leg.rotateAngleX += 0.2 * upwardPose;
						leg_1.rotateAngleX -= 0.8 * upwardPose;
						Right_Lower_Leg.rotateAngleX += 0.3 * upwardPose;
						Right_Lower_Leg_1.rotateAngleX += 1.5 * upwardPose;
			
						walk(leg, 0.5F * globalSpeed, 0.2F * globalDegree * downwardPose, false, 0, 0, f1, 1);
						walk(leg_1, 0.5F * globalSpeed, 0.2F * globalDegree * downwardPose, true, 0, 0, f1, 1);
						walk(Right_Lower_Leg, 0.5F * globalSpeed, 0.2F * globalDegree * downwardPose, false, -2.2F * backwardInverter, 0F, f1, 1);
						walk(Right_Lower_Leg_1, 0.5F * globalSpeed, 0.2F * globalDegree * downwardPose, true, -2.2F * backwardInverter, 0F, f1, 1);
						
						leg.rotateAngleX -= 1.2 * downwardPose;
						leg_1.rotateAngleX += 0.7 * downwardPose;
						Right_Lower_Leg.rotateAngleX += 2 * downwardPose;
						Right_Lower_Leg_1.rotateAngleX += 0.5 * downwardPose;
	        
						this.leg.rotateAngleX -= .5F *downwardPose;
						this.leg_1.rotateAngleX -= .5F *downwardPose;
						
						this.Chest.rotateAngleX = 0.4F *downwardPose;
						this.Torso.rotateAngleX = -.2F *downwardPose;
//						this.Torso2.rotateAngleX = 0.2F *downwardPose;
	        
	      	
						Right_Arm.rotateAngleX = 0.6F*downwardPose;
						Right_Arm_1.rotateAngleX = 0.6F*downwardPose;
	      	
						Right_Arm.rotateAngleZ = 0.1F *downwardPose;
						Right_Arm_1.rotateAngleZ = -0.1F *downwardPose;
	    
						Right_Lower_Arm.rotateAngleX = -1.1F *downwardPose;
						Right_Lower_Arm_1.rotateAngleX = -1.1F *downwardPose;
	    
						Right_Lower_Arm.rotateAngleY = -0.2F *downwardPose;
						Right_Lower_Arm_1.rotateAngleY = 0.2F *downwardPose;
					}					
	     	  }
	     	  
	     	 if (entity instanceof EntityPlayer)
		        {
		        	ItemStack stack = ((EntityPlayer) entity).getHeldItemMainhand();
		        
		        	
		        	
		        	if (stack.getItem() instanceof com.marctron.transformersmod.items.gun.Scrapper) {
		                IGun nbt = ((IGun) stack.getItem());
		                if (nbt.getBoolean("Gun")) {
//		                	if (CapabilityHandler.isReloading){
		                	flap(Right_Arm, 0.08F, 0.05F, true, 0, 0, f2, 1);
		                	swing(Right_Lower_Arm, 0.08F, 0.1F, false, 0, 0.2F, f2, 1);
		        	     	walk(Right_Lower_Arm, 0.08F, 0.1F, false, 0, 0.1F, f2, 1);
		        	     	Right_Lower_Arm.rotateAngleY=-0.F;
		        	     	Right_Arm.rotateAngleZ=-Head.rotateAngleX*0.4F;
		        	     	
		                		this.Right_Arm.rotateAngleY = this.Head.rotateAngleY -0.4F;
		                		this.Right_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX *1.2F + 0.5F;
		                		swing(Right_Lower_Arm, 0.08F, 0.1F, true, 0, -0.1f, f2, 1);
		                		walk(Right_Arm, 0.08F, 0.1F, true, 0, 0.f, f2, 1);
		                		this.Right_Lower_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX*0.8F + 1.3F;
		                		this.Right_Lower_Arm.scaleChildren=true;
		                		this.Right_Lower_Arm.setScale(0.1F, 0.1F, 0.1F);
		                		RIGHT_HAND.rotationPointY=-10;
		                		RIGHT_HAND.rotationPointZ=2;
		                		if (isSneak){
		                			RIGHT_HAND.rotationPointZ=-2;
		                			RIGHT_HAND.rotationPointX=-0.5F;
		                			this.Right_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX *1.2F + 0.F;
		                			this.Right_Arm.rotateAngleZ=-0.1F;
		                			this.Right_Arm.rotateAngleY = this.Head.rotateAngleY - 0.5F;
		                			Right_Lower_Arm.rotateAngleZ=-0.F;
				        	     	Right_Lower_Arm.rotateAngleY=-0.F;
				        	     	Right_Arm_1.rotateAngleZ=-0.2F;
				        	     	leg.rotateAngleY=1;
				        	     	leg.rotateAngleZ=0.35F;
				        	     	leg.rotateAngleX=-0.7F;
				        	     	leg.rotationPointY=1;
				        	     	
				        	     	leg_1.rotateAngleX=-1;
				        	     	leg_1.rotateAngleZ=-0.5F;
				        	     	leg_1.rotationPointZ=-2;
				        	     	leg_1.rotationPointX=8;
				        	     	Right_Lower_Leg_1.rotateAngleX=0.5F;
				        	     	Right_Foot_1.rotateAngleX=0.5F;
				        	     	Right_Foot_1.rotateAngleZ=0.5F;
		                		}
//		                	}
		                }
		        	}
		        	
		        	if (stack.getItem() instanceof IGun && !(stack.getItem() instanceof RocketLauncher)) {
		        		
		                IGun nbt = ((IGun) stack.getItem());
		                if (nbt.getBoolean("Gun")) {
		        		
//		                	if (CapabilityHandler.isReloading){
		                	flap(Right_Arm, 0.08F, 0.05F, true, 0, 0, f2, 1);
		                	swing(Right_Lower_Arm, 0.08F, 0.1F, false, 0, 0.2F, f2, 1);
		        	     	walk(Right_Lower_Arm, 0.08F, 0.1F, false, 0, 0.1F, f2, 1);
		        	     	Right_Lower_Arm.rotateAngleZ=-0.F;
		        	     	Right_Lower_Arm.rotateAngleY=-0.F;
		        	     	Right_Arm.rotateAngleZ=-Head.rotateAngleX*0.4F;
		        	     	
		                		this.Right_Arm.rotateAngleY = this.Head.rotateAngleY -0.4F;
		                		this.Right_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX *1.2F + 0.5F;
		                		swing(Right_Lower_Arm, 0.08F, 0.1F, true, 0, -0.1f, f2, 1);
		                		walk(Right_Arm, 0.08F, 0.1F, true, 0, 0.f, f2, 1);
		                		this.Right_Lower_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX*0.8F + 1.3F;
		                		this.Right_Lower_Arm.scaleChildren=true;
		                		this.Right_Lower_Arm.setScale(0.1F, 0.1F, 0.1F);
		                		RIGHT_HAND.rotationPointY=-10;
		                		RIGHT_HAND.rotationPointZ=2;
		                		if (isSneak){
		                			RIGHT_HAND.rotationPointZ=-2;
		                			RIGHT_HAND.rotationPointX=-0.5F;
		                			this.Right_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX *1.2F + 0.F;
		                			this.Right_Arm.rotateAngleZ=-0.1F;
		                			this.Right_Arm.rotateAngleY = this.Head.rotateAngleY - 0.5F;
		                			Right_Lower_Arm.rotateAngleZ=-0.F;
				        	     	Right_Lower_Arm.rotateAngleY=-0.F;
				        	     	Right_Arm_1.rotateAngleZ=-0.2F;
				        	     	leg.rotateAngleY=1;
				        	     	leg.rotateAngleZ=0.35F;
				        	     	leg.rotateAngleX=-0.7F;
				        	     	leg.rotationPointY=1;
				        	     	
				        	     	leg_1.rotateAngleX=-1;
				        	     	leg_1.rotateAngleZ=-0.5F;
				        	     	leg_1.rotationPointZ=-2;
				        	     	leg_1.rotationPointX=8;
				        	     	Right_Lower_Leg_1.rotateAngleX=0.5F;
				        	     	Right_Foot_1.rotateAngleX=0.5F;
				        	     	Right_Foot_1.rotateAngleZ=0.5F;
		                		}
//		                	}
		                }
		                
		        	}
		        	
		        	else if (stack.getItem() instanceof com.marctron.transformersmod.items.gun.RocketLauncher) {
		                IGun nbt = ((IGun) stack.getItem());
		                if (nbt.getBoolean("Gun")) {
		        		
//		                	if (CapabilityHandler.isReloading){
		                	flap(Right_Arm, 0.08F, 0.05F, true, 0, 0, f2, 1);
		                	swing(Right_Lower_Arm, 0.08F, 0.1F, false, 0, 0.2F, f2, 1);
		        	     	walk(Right_Lower_Arm, 0.08F, 0.1F, false, 0, 0.1F, f2, 1);
		                		this.Right_Arm.rotateAngleY = this.Head.rotateAngleY;
		                		this.Right_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX *1.2F + 0.9F;
		                		swing(Right_Lower_Arm, 0.08F, 0.1F, true, 0, -0.1f, f2, 1);
		                		walk(Right_Arm, 0.08F, 0.1F, true, 0, 0.f, f2, 1);
		                		this.Right_Lower_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX*0.2F + 1.0F;
		                		this.Right_Lower_Arm.scaleChildren=true;
		                		this.Right_Lower_Arm.setScale(0.1F, 0.1F, 0.1F);
		                		RIGHT_HAND.rotationPointY=-10;
		                		RIGHT_HAND.rotationPointZ=2;
		                		if (isSneak){
		                			RIGHT_HAND.rotationPointZ=-2;
		                			RIGHT_HAND.rotationPointX=-0.5F;
		                			this.Right_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX *1.2F + 0.F;
		                			this.Right_Arm.rotateAngleZ=-0.1F;
		                			this.Right_Arm.rotateAngleY = this.Head.rotateAngleY - 0.5F;
		                			Right_Lower_Arm.rotateAngleZ=-0.F;
				        	     	Right_Lower_Arm.rotateAngleY=-0.F;
				        	     	Right_Arm_1.rotateAngleZ=-0.2F;
				        	     	leg.rotateAngleY=1;
				        	     	leg.rotateAngleZ=0.35F;
				        	     	leg.rotateAngleX=-0.7F;
				        	     	leg.rotationPointY=1;
				        	     	
				        	     	leg_1.rotateAngleX=-1;
				        	     	leg_1.rotateAngleZ=-0.5F;
				        	     	leg_1.rotationPointZ=-2;
				        	     	leg_1.rotationPointX=8;
				        	     	Right_Lower_Leg_1.rotateAngleX=0.5F;
				        	     	Right_Foot_1.rotateAngleX=0.5F;
				        	     	Right_Foot_1.rotateAngleZ=0.5F;
		                		}
//		                	}
		                }
		                
		        	}
		        	else
//		            	this.Right_Lower_Arm.scaleChildren=false;
		    			this.Right_Lower_Arm.setScale(1F, 1F, 1F);
		        }
	 }

}
