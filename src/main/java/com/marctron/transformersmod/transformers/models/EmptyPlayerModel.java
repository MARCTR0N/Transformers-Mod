package com.marctron.transformersmod.transformers.models;

import java.util.List;

import com.marctron.transformersmod.transformers.renderers.RenderLivingBaseNoEvent;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.layers.LayerArmorBase;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;

public class EmptyPlayerModel extends ModelPlayer {

	public EmptyPlayerModel(float modelSize, boolean smallArmsIn) {
		super(modelSize, smallArmsIn);
	    bipedLeftArmwear.cubeList.clear();
	    bipedRightArmwear.cubeList.clear();
	    bipedLeftLegwear.cubeList.clear();
	    bipedRightLegwear.cubeList.clear();
	    bipedBodyWear.cubeList.clear();
	    bipedHead.cubeList.clear();
	    bipedHeadwear.cubeList.clear();
	    bipedBody.cubeList.clear();
	    bipedRightArm.cubeList.clear();
	    bipedLeftArm.cubeList.clear();
	    bipedRightLeg.cubeList.clear();
	    bipedLeftLeg.cubeList.clear();
	}
	
	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {

	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		if (entityIn instanceof EntityLivingBase) {
			boolean flag = false;
			for (ItemStack stack : entityIn.getArmorInventoryList()) {
				if (stack.getItem() instanceof ItemArmorTransformer) {
					ItemArmorTransformer item = (ItemArmorTransformer) stack.getItem();
					ModelBiped model = item.getArmorModel((EntityLivingBase) entityIn, stack, EntityEquipmentSlot.CHEST, this);
					if ( model != null) {
						if (flag) {
							model.setVisible(false);
						}
						else {
							model.setVisible(true);
							model.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
							flag = true;
						}
					}
				}
			}
		}
		//super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
	}
	    
    @Override
    public void postRenderArm(float scale, EnumHandSide side) {
		ModelRenderer renderer = this.getArmForSide(side);
		if (renderer instanceof AdvancedModelBipedRenderer) {
			((AdvancedModelBipedRenderer) renderer).parentedPostRender(scale);
		}
		else {
			renderer.isHidden = false;
			renderer.showModel = true;
			renderer.postRender(scale);
		}
    }

}
