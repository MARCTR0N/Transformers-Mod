package com.marctron.transformersmod.transformers.models.wfc.stunticons.breakdown;

import com.marctron.transformersmod.items.gun.IGun;
import com.marctron.transformersmod.items.gun.ItemGunBase;
import com.marctron.transformersmod.transformers.models.AdvancedModelBipedRenderer;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ModelBreakdown extends ModelBreakdownBody{

	 public AdvancedModelBipedRenderer LEFT_HAND;
	 public AdvancedModelBipedRenderer RIGHT_HAND;
	
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
	        
	        float globalSpeed = 0.4F;
	        float globalDegree = 0.5F ;
	        float height = 2.F;
	        
	 	    walk(Left_Arm, 1 * globalSpeed,  -1.F * globalDegree, true, 0.6F, 0.F, f, f1);
	        
	        walk(Left_Lower_Arm, 1 * globalSpeed,  -.9F * globalDegree, true, -.6F, 0.6F, f, f1);
	        
	        walk(Right_Arm, 1 * globalSpeed,  1.F * globalDegree, true, 0.6F, 0.F, f, f1);
	        
	        walk(Right_Lower_Arm, 1 * globalSpeed,  .9F * globalDegree, true, -.6F, 0.6F, f, f1);
	        
	        
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
//	                	}
	                }
	        	}
	        	
	        	if (stack.getItem() instanceof ItemGunBase) {
	                IGun nbt = ((IGun) stack.getItem());
	                if (nbt.getBoolean("Gun")) {
	        		
//	                	if (CapabilityHandler.isReloading){
	                		this.Right_Arm.rotateAngleY = this.Head.rotateAngleY;
	                		this.Right_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX + 0.4F;
	                		swing(Right_Lower_Arm, 0.08F, 0.1F, true, 0, -0.1f, f2, 1);
	                		walk(Right_Arm, 0.08F, 0.1F, true, 0, 0.f, f2, 1);
	                		this.Right_Lower_Arm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX + 1.3F;
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
