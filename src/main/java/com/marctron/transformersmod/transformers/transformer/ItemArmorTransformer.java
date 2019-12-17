package com.marctron.transformersmod.transformers.transformer;

import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemArmorTransformer extends ItemArmor {

	@SideOnly(Side.CLIENT)
    private RenderLivingBase renderer;
	
	public ItemArmorTransformer(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
	}
	
    @SideOnly(Side.CLIENT)
    public RenderLivingBase getRenderer() {
    	return renderer;
    }
    
    @SideOnly(Side.CLIENT)
    public void setRenderer(RenderLivingBase renderer) {
    	this.renderer = renderer;
    }

}
