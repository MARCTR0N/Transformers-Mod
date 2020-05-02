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

public class TFPMagnusMid5 extends ItemArmorTransformer{
	
	public TFPMagnusMid5(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
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
					
					
					
				
					
			
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid5_A.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid5_A.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid5_A.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid5_A.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid5_A.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid5_A.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid5_A.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

				TFPMagnusArmorTypes.modelTFPUltraMagnusMid5_A.isSneak = _default.isSneak;
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid5_A.isRiding = _default.isRiding;
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid5_A.isChild = _default.isChild;
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid5_A.rightArmPose = _default.rightArmPose;
				TFPMagnusArmorTypes.modelTFPUltraMagnusMid5_A.leftArmPose = _default.leftArmPose;

					return TFPMagnusArmorTypes.modelTFPUltraMagnusMid5_A;
				}
			}
			
			return null;
		}

}