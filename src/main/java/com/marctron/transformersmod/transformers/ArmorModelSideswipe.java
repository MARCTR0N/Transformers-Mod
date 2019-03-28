package com.marctron.transformersmod.transformers;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.init.ModItems;

import com.marctron.transformersmod.transformers.models.SideswipeModel;
import com.marctron.transformersmod.util.interfaces.IHasModel;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ArmorModelSideswipe extends ItemArmor implements IHasModel {

	public ArmorModelSideswipe(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabTransformers);
		setMaxStackSize(1);
		ModItems.ITEMS.add(this);
		
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
			((EntityLivingBase) player).addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 20, 0));
			((EntityLivingBase) player).addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 20, 0));
			
			if (itemStack.getItem() == ModItems.SIDESWIPE_CHESTPLATE) 
			{
				if (world.isRemote) 
				{
			
			player.width = 0.6F; 
			player.height = 1.5F;
			player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 1.5F, player.getEntityBoundingBox().minZ + 0.6F));
		
				}
			} 
	}
				
	
	@Override
	public void registerModels() 
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
					
					
					SideswipeModel model = new SideswipeModel();
					
			
					model.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
					model.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
					model.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST);
					model.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
					model.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
					model.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.FEET);
					model.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.FEET);
							
			
					
					model.isSneak = _default.isSneak;
					model.isRiding = _default.isRiding;
					model.isChild = _default.isChild;
					model.rightArmPose = _default.rightArmPose;
					model.leftArmPose = _default.leftArmPose;
					
					

					
					
					return model;
				}
		}
		return null;
	}
	
	


	

}
