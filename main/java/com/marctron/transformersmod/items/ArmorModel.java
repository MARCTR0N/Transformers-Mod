package com.marctron.transformersmod.items;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.init.ModItems;
import com.marctron.transformersmod.items.models.ModelCustomArmor;
import com.marctron.transformersmod.util.IHasModel;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ArmorModel extends ItemArmor implements IHasModel {

	public ArmorModel(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabTransformers);
		setMaxStackSize(1);
		ModItems.ITEMS.add(this);
		
	}
	
	@Override
	public void registerModel() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
	
		if(!itemStack.isEmpty())
		{
			
			
			if(itemStack.getItem() instanceof ItemArmor) 
				{
					
					
					ModelCustomArmor model = new ModelCustomArmor(1.0f);
					ModelCustomArmor modelLegs = new ModelCustomArmor(0.5f);
			
					model.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
					model.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
					model.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST)
							|| (armorSlot == EntityEquipmentSlot.LEGS);
					model.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
					model.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
					modelLegs.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.FEET)
							|| (armorSlot == EntityEquipmentSlot.LEGS);
					modelLegs.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.FEET)
							|| (armorSlot == EntityEquipmentSlot.LEGS);
			
					
					model.isSneak = _default.isSneak;
					model.isRiding = _default.isRiding;
					model.isChild = _default.isChild;
					model.rightArmPose = _default.rightArmPose;
					model.leftArmPose = _default.leftArmPose;
					
					modelLegs.isSneak = _default.isSneak;
					modelLegs.isRiding = _default.isRiding;
					modelLegs.isChild = _default.isChild;
					modelLegs.rightArmPose = _default.rightArmPose;
					modelLegs.leftArmPose = _default.leftArmPose;

					
					
					return model;
				}
		}
		return null;
	}
	
	


	

}
