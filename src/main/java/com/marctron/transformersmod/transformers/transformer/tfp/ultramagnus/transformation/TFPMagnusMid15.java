package com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation;




import java.util.List;

import javax.annotation.Nullable;

import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.TFPMagnusArmorTypes;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TFPMagnusMid15 extends ItemArmorTransformer{
	
	public TFPMagnusMid15(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(null);
		setMaxStackSize(1);
		
	}
	
	
	public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
		list.add(TextFormatting.GRAY + I18n.format(TextFormatting.BOLD + I18n.format("WFC")));
	}
	
	@Override
	public final void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
			if(player.onGround){
					player.motionX=player.motionX * 1.06F;
					player.motionZ=player.motionZ * 1.06F;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public final ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
	
		if(!itemStack.isEmpty())
		{
			
			
			if(itemStack.getItem() instanceof ItemArmor) 
				{
					
					
					
				
					
			
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid15_A.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid15_A.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid15_A.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid15_A.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid15_A.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid15_A.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid15_A.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

				TFPMagnusArmorTypes.modelTFPUltraMagnusMid15_A.isSneak = _default.isSneak;
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid15_A.isRiding = _default.isRiding;
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid15_A.isChild = _default.isChild;
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid15_A.rightArmPose = _default.rightArmPose;
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid15_A.leftArmPose = _default.leftArmPose;

					return TFPMagnusArmorTypes.modelTFPUltraMagnusMid15_A;
				}
			}
			
			return null;
		}

}
