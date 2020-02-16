package com.marctron.transformersmod.transformers.transformer.wfc.stunticons;

import java.util.List;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.transformers.transformer.ArmorTypes;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Menasor extends ItemArmorTransformer{
	
	public Menasor(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabDecepticon);
		setMaxStackSize(1);
		
	}
	
	
	public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
		list.add(TextFormatting.GRAY + I18n.format(TextFormatting.BOLD + I18n.format("WFC")));
	}
	
	@Override
	public final void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
			if(player.onGround){
//					player.motionX=player.motionX * 1.05F;
//					player.motionZ=player.motionZ * 1.05F;
		}
//			player.eyeHeight=5f;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public final ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
	
		if(!itemStack.isEmpty())
		{
			
			
			if(itemStack.getItem() instanceof ItemArmor) 
				{
					
					
					
				
					
		
				ArmorTypes.modelMenasor.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				ArmorTypes.modelMenasor.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				ArmorTypes.modelMenasor.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
				ArmorTypes.modelMenasor.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				ArmorTypes.modelMenasor.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				ArmorTypes.modelMenasor.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
				ArmorTypes.modelMenasor.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

				ArmorTypes.modelMenasor.isSneak = _default.isSneak;
				ArmorTypes.modelMenasor.isRiding = _default.isRiding;
				ArmorTypes.modelMenasor.isChild = _default.isChild;
				ArmorTypes.modelMenasor.rightArmPose = _default.rightArmPose;
				ArmorTypes.modelMenasor.leftArmPose = _default.leftArmPose;

					return ArmorTypes.modelMenasor;
				}
			}
			
			return null;
		}

}
