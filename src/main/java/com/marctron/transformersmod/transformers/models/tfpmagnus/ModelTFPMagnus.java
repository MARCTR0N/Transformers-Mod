package com.marctron.transformersmod.transformers.models.tfpmagnus;

import com.marctron.transformersmod.items.gun.IGun;
import com.marctron.transformersmod.items.gun.ItemGunBase;
import com.marctron.transformersmod.transformers.models.AdvancedModelBipedRenderer;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ModelTFPMagnus extends ModelTFPUltraMagnuspart3{

//	public AdvancedModelBipedRenderer LEFT_HAND1;
//	public AdvancedModelBipedRenderer RIGHT_HAND1;
	
	
	public ModelTFPMagnus(){
//		 LEFT_HAND = new AdvancedModelBipedRenderer(this, "LEFT_HAND").setTextureOffset(0, 457);
//	     LEFT_HAND.mirror = true;
//	     LEFT_HAND.setRotationPoint(-1.0F, 3.5F, -0.5F);
//	     LEFT_HAND.addBox(0.0F, 0.0F, -1.9F, 3, 2, 3, 0.0F);
	     
//	     LEFT_HAND1 = new AdvancedModelBipedRenderer(this, "LEFT_HAND1").setTextureOffset(0, 457);
//	     LEFT_HAND1.mirror = true;
//	     LEFT_HAND1.setRotationPoint(-2.0F, 16.5F, 1.0F);
//	     LEFT_HAND1.addBox(0.0F, 0.0F, -1.9F, 3, 2, 3, 0.0F);
	     
//	     RIGHT_HAND = new AdvancedModelBipedRenderer(this, "RIGHT_HAND").setTextureOffset(0, 457);
//	     RIGHT_HAND.mirror = true;
//	     RIGHT_HAND.setRotationPoint(1.5F, 4.0F, -0.5F);
//	     RIGHT_HAND.addBox(0.0F, 0.0F, -1.9F, 3, 2, 3, 0.0F);
	     
//	     RIGHT_HAND1 = new AdvancedModelBipedRenderer(this, "RIGHT_HAND1").setTextureOffset(0, 457);
//	     RIGHT_HAND1.mirror = true;
//	     RIGHT_HAND1.setRotationPoint(-1.0F, 16.5F, 1.0F);
//	     RIGHT_HAND1.addBox(0.0F, 0.0F, -1.9F, 3, 2, 3, 0.0F);
//	     
//	     Left_Lower_Arm.addChild(LEFT_HAND1);
//	     Right_Lower_Arm.addChild(RIGHT_HAND1);
		
//		Croach.addChild(Head);
		Croach.addChild(Left_Leg);
		Croach.addChild(Right_Leg);
	} 
	
	
	
	@Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
		((ModelBiped)((ItemArmorTransformer)entity.getArmorInventoryList().iterator().next().getItem()).getRenderer().getMainModel()).bipedLeftArm = this.LEFT_HAND1;
    	((ModelBiped)((ItemArmorTransformer)entity.getArmorInventoryList().iterator().next().getItem()).getRenderer().getMainModel()).bipedRightArm = this.RIGHT_HAND1;
    	if (!bipedLeftLeg.isHidden && !bipedRightLeg.isHidden && !bipedLeftArm.isHidden && !bipedRightArm.isHidden
				&& !bipedBody.isHidden && !bipedHead.isHidden) {
			bipedLeftLeg.isHidden = true;
			bipedRightLeg.isHidden = true;
			bipedLeftArm.isHidden = true;
			bipedRightArm.isHidden = true;
			bipedBody.isHidden = true;
			bipedHead.isHidden = true;
		}
//		Left_Leg.render(f5);
//		Right_Leg.render(f5);
//		Head.render(f5);
		Croach.render(f5);
//		 GlStateManager.scale(0.4F, 0.4F, 0.4F);
    }
	
	 public void setRotateAngle(ModelRenderer ModelRenderer, float x, float y, float z)
	    {
	    	ModelRenderer.rotateAngleX = x;
	        ModelRenderer.rotateAngleY = y;
	        ModelRenderer.rotateAngleZ = z;
	    }
	 @Override
	 public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		 
		 GlStateManager.scale(0.4F, 0.4F, 0.4F);
	     GlStateManager.translate(0.0F, -14.50F * f5, -0.35F);
		 resetToDefaultPose();
	
		 Head.rotationPointY=-80;
		 
		 Left_Leg.rotationPointY=40;
		 Right_Leg.rotationPointY=40;
		 
		 float upwardPose = (float) (1 / (1 + Math.exp(-10 * (entity.motionY + 0.2))));
	        float downwardPose = (float) (1 / (1 + Math.exp(10 * (entity.motionY + 0.2))));
	        int backwardInverter = 1;
	        
	        resetToDefaultPose();
	        
	        this.RIGHT_HAND1.offsetX=-2*f5;
	        this.RIGHT_HAND1.offsetY=-2*f5;
	        Head.rotateAngleY= (f3) / (180F / 3.14f);
	        Head.rotateAngleX= (f4) / (180F / 3.14f);
	        
	        
	        float globalSpeed = 0.3F;
	        float globalDegree = 0.5F ;
	        float height = 3.F;
	        
	  
	        //walking
	        walk(Right_Leg, 1f* globalSpeed, 1.5F* globalDegree, false, 1.8f, -0.1f, f, f1);
	        walk(Left_Leg, 1f* globalSpeed, 1.5F* globalDegree, true, 1.8f, 0.1f, f, f1);
	          
	        walk(Right_Lower_Leg, 1f * globalSpeed,  -.7F * globalDegree, true, 0F, -0.5F, f, f1);     
	        walk(Right_Foot, 1f * globalSpeed,  -0.6F * globalDegree, false, -2F, 0.2F, f, f1);
	        
	        walk(Left_Lower_Leg, 1f * globalSpeed,  -.7F * globalDegree, false, 0F, 0.5F, f, f1);     
	        walk(Left_Foot, 1f * globalSpeed,  -0.6F * globalDegree, true, -2F, -0.2F, f, f1);
	        
	        walk(Right_Arm, 1f* globalSpeed, 1F* globalDegree, false, 2, -0.2f, f, f1);
	        walk(Left_Arm, 1f* globalSpeed, 1F* globalDegree, true, 2, 0.2f, f, f1);
	        
	        walk(Right_Lower_Arm, 1f* globalSpeed, 0.8F* globalDegree, true, 5, 0.5f, f, f1);
	        walk(Left_Lower_Arm, 1f* globalSpeed, 0.8F* globalDegree, false, 5, -0.5f, f, f1);
	        
	        swing(Torso, 1f* globalSpeed, 0.4f*globalDegree, true, 0, 0, f, f1);
	        walk(Croach, 2f* globalSpeed, 0.05f*globalDegree, true, 0, -0.05f, f, f1);
	        
	        swing(Head, 1f* globalSpeed, 0.4f*globalDegree, false, 0, 0, f, f1);
	        walk(Head, 2f* globalSpeed, 0.05f*globalDegree, false, 0, -0.1f, f, f1);
	        
//	        bob(Left_Arm,3f* globalSpeed, 0.8f*height, true, f, f1);
//	        bob(Right_Arm,3f* globalSpeed, 0.8f*height, true, f, f1);
	        bob(Croach,2f* globalSpeed, 0.8f*height, false, f, f1);
	        walk(Torso, 2f* globalSpeed, 0.05f*globalDegree, false, 0, 0.15f, f, f1);
	        
//	        walk(Right_Leg, 3f* globalSpeed, 0.05f*globalDegree, true, 0, 0.05f, f, f1);
//	        walk(Left_Leg, 3f* globalSpeed, 0.05f*globalDegree, true, 0, 0.05f, f, f1);
	        
//	        
//	        
//	       //idle
	        flap(Right_Arm, 0.08F, 0.05F, true, 0, 0.01f, f2, 1);
	        flap(Left_Arm, 0.08F, 0.05F, false, 0, 0.01f, f2, 1);
	        walk(Croach, 0.08F, 0.03F, false, 0, 0.03f, f2, 1);
	       
	        
	        walk(Right_Arm, 0.08F, 0.1F, false, 0, 0.f, f2, 1);
	        walk(Left_Arm, 0.08F, 0.1F, false, 0, 0.f, f2, 1);
	        walk(Right_Lower_Arm, 0.08F, 0.2F, true, 0, 0.25f, f2, 1);
	        walk(Left_Lower_Arm, 0.08F, 0.2F, true, 0, 0.25f, f2, 1);
	        swing(Right_Lower_Arm, 0.08F, 0.08F, true, 0, 0.1f, f2, 1);
	        swing(Left_Lower_Arm, 0.08F, 0.08F, false, 0, 0.1f, f2, 1);
	        
	        
	        if(!isSneak){
	        walk(Torso, 0.08F, 0.05F, false, 0, 0.f, f2, 1);
	        walk(Right_Leg, 0.08F, 0.1F, true, 0, 0.f, f2, 1);
	        walk(Left_Leg, 0.08F, 0.1F, true, 0, 0.f, f2, 1);
	        walk(Right_Lower_Leg, 0.08F, 0.1F, false, 0, 0.f, f2, 1);
	        walk(Left_Lower_Leg, 0.08F, 0.1F, false, 0, 0.f, f2, 1);
	        walk(Right_Foot, 0.08F, 0.05F, true, 0, 0.f, f2, 1);
	        walk(Left_Foot, 0.08F, 0.05F, true, 0, 0.f, f2, 1);
	        bob(Torso, 0.08F, 0.01F, false, f2, 1);}
//	        
//	     
//	        
//	        //Jump and Falling 
//	        if (entity instanceof EntityPlayer){
//				EntityPlayer player = (EntityPlayer) entity;
//				if (!player.onGround  && !player.capabilities.isFlying){
//						Right_Leg.rotateAngleX += 0.2 * upwardPose;
//						Left_Leg.rotateAngleX -= 0.8 * upwardPose;
//						Right_Lower_Leg.rotateAngleX += 0.3 * upwardPose;
//						Left_Lower_Leg.rotateAngleX += 1.5 * upwardPose;
//			
//						walk(Right_Leg, 0.5F * globalSpeed, 0.2F * globalDegree * downwardPose, false, 0, 0, f1, 1);
//						walk(Left_Leg, 0.5F * globalSpeed, 0.2F * globalDegree * downwardPose, true, 0, 0, f1, 1);
//						walk(Right_Lower_Leg, 0.5F * globalSpeed, 0.2F * globalDegree * downwardPose, false, -2.2F * backwardInverter, 0F, f1, 1);
//						walk(Left_Lower_Leg, 0.5F * globalSpeed, 0.2F * globalDegree * downwardPose, true, -2.2F * backwardInverter, 0F, f1, 1);
//	        
//						Right_Leg.rotateAngleX -= 1.2 * downwardPose;
//						Left_Leg.rotateAngleX += 0.7 * downwardPose;
//						Right_Lower_Leg.rotateAngleX += 2 * downwardPose;
//						Left_Lower_Leg.rotateAngleX += 0.5 * downwardPose;
//	        
//						this.Right_Leg.rotateAngleX -= .5F *downwardPose;
//						this.Left_Leg.rotateAngleX -= .5F *downwardPose;
//
//	        
//						this.Croach.rotateAngleX = 0.6F *downwardPose;
//						this.Torso.rotateAngleX = -.2F *downwardPose;
//	        
//	      	
//						Right_Arm.rotateAngleX = 0.6F*downwardPose;
//						Left_Arm.rotateAngleX = 0.6F*downwardPose;
//	      	
//						Right_Arm.rotateAngleZ = 0.4F *downwardPose;
//						Left_Arm.rotateAngleZ = -0.4F *downwardPose;
//	    
//						Right_Lower_Arm.rotateAngleX = -1.1F *downwardPose;
//						Left_Lower_Arm.rotateAngleX = -1.1F *downwardPose;
//	    
//						Right_Lower_Arm.rotateAngleY = -0.2F *downwardPose;
//						Left_Lower_Arm.rotateAngleY = 0.2F *downwardPose;
//					}
//				}
//	        
//	        //items,guns, etc.
//	        
//	        switch (this.leftArmPose)
//	        {
//	            case EMPTY:
//	                this.Left_Arm.rotateAngleY = 0.0F;
//	                break;
//	            case BLOCK:
//	            	 this.Left_Arm.rotateAngleX = this.Left_Arm.rotateAngleX * 0.5F - 0.9424779F + 0.4F;
//		                this.Left_Arm.rotateAngleY = 0.5235988F;
//		                this.Left_Lower_Arm.rotateAngleY = 0.4F;
//		                this.Left_Lower_Arm.rotateAngleX = -1F;
//		                this.LEFT_HAND1.rotateAngleZ= -0.3F;
//		                this.LEFT_HAND1.rotateAngleX= 0.8F;
//		                this.LEFT_HAND1.rotateAngleY= -0.3F;
//		                this.LEFT_HAND1.rotationPointX=-2F;	
//		                this.LEFT_HAND1.rotationPointY=7F;	                
//		                this.LEFT_HAND1.rotationPointZ=-8F;
//		                this.LEFT_HAND1.setScale(0.1F, 0.1F, 0.1F);
//	                break;
//	            case ITEM:
//	                this.Left_Arm.rotateAngleX = this.Left_Arm.rotateAngleX * 0.5F - ((float)Math.PI / 10F);
//	                this.Left_Arm.rotateAngleY = 0.0F;
//	                this.Left_Lower_Arm.rotateAngleX = this.Left_Lower_Arm.rotateAngleX * 0.5F - ((float)Math.PI / 10F);
//			default:
//				break;
//	        }
//
//	        switch (this.rightArmPose)
//	        {
//	            case EMPTY:
//	                this.Right_Arm.rotateAngleY = 0.0F;
//	                break;
//	            case BLOCK:
//	                this.Right_Arm.rotateAngleX = this.Right_Arm.rotateAngleX * 0.5F - 0.9424779F + 0.4F;
//	                this.Right_Arm.rotateAngleY = -0.5235988F;
//	                this.Right_Lower_Arm.rotateAngleY = -0.4F;
//	                this.Right_Lower_Arm.rotateAngleX = -1F;
//	                this.RIGHT_HAND1.rotateAngleZ= 0.3F;
//	                this.RIGHT_HAND1.rotateAngleX= 0.8F;
//	                this.RIGHT_HAND1.rotateAngleY= 0.3F;
//	                this.RIGHT_HAND1.rotationPointX=3F;	
//	                this.RIGHT_HAND1.rotationPointY=8F;	                
//	                this.RIGHT_HAND1.rotationPointZ=-7F;
//	                this.RIGHT_HAND1.setScale(0.1F, 0.1F, 0.1F);
//	                
//	                break;
//	            case ITEM:
//	                this.Right_Arm.rotateAngleX = this.Right_Arm.rotateAngleX * 0.7F - ((float)Math.PI / 10F);
//	                this.Right_Arm.rotateAngleY = 0.0F;
//	                this.Right_Lower_Arm.rotateAngleX = this.Right_Lower_Arm.rotateAngleX * 0.7F - ((float)Math.PI / 10F);
//			default:
//				break;
//	        }
//	        
//	        if (this.rightArmPose == ModelBiped.ArmPose.BOW_AND_ARROW)
//	        {
//	            this.Right_Arm.rotateAngleY = -0.1F + this.Head.rotateAngleY;
//	            this.Right_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX;
//	        }
//	        
//	        if (entity instanceof EntityPlayer)
//	        {
//	        	ItemStack stack = ((EntityPlayer) entity).getHeldItemMainhand();
//	        	if (stack.getItem() instanceof com.marctron.transformersmod.items.gun.Scrapper) {
//	                IGun nbt = ((IGun) stack.getItem());
//	                if (nbt.getBoolean("Gun")) {
//	        		
//	            this.Right_Arm.rotateAngleY = this.Head.rotateAngleY;
//	            this.Right_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX*0.5F + 0.4F;
//	            swing(Right_Lower_Arm, 0.08F, 0.1F, true, 0, -0.1f, f2, 1);
//	            walk(Right_Arm, 0.08F, 0.1F, true, 0, 0.f, f2, 1);
//	            this.Right_Lower_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX*0.5F + 1F;
//
//	                }
//	        	}
//	        	
//	        	if (stack.getItem() instanceof ItemGunBase) {
//	                IGun nbt = ((IGun) stack.getItem());
//	                if (nbt.getBoolean("Gun")) {
//	        		
//	            this.Right_Arm.rotateAngleY = this.Head.rotateAngleY;
//	            this.Right_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX + 0.4F;
//	            swing(Right_Lower_Arm, 0.08F, 0.1F, true, 0, -0.1f, f2, 1);
//	            walk(Right_Arm, 0.08F, 0.1F, true, 0, 0.f, f2, 1);
//	            this.Right_Lower_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX + 1F;
//	                }
//	        	}
//	        }
//	        
//	        else if (this.leftArmPose == ModelBiped.ArmPose.BOW_AND_ARROW)
//	        {
//	            this.Left_Arm.rotateAngleY = 0.1F + this.Head.rotateAngleY;
//	            this.Left_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX;
//	        }
	        
	        Left_Leg.rotationPointY=20;
			Right_Leg.rotationPointY=20;
	    
		     if (entity instanceof EntityArmorStand) {
	                EntityArmorStand entityarmorstand = (EntityArmorStand) entity;
	                resetToDefaultPose();
	                GlStateManager.scale(0.6F, 0.6F, 0.6F);
	                GlStateManager.translate(0.0F, 10.5F * f5, -0.25F);
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
	            }
	 }
}
