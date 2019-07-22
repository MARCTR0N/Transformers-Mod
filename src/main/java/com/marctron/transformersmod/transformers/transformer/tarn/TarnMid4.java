package com.marctron.transformersmod.transformers.transformer.tarn;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.init.ModItems;
import com.marctron.transformersmod.transformers.models.tarn.ModelTarn2Mid3;
import com.marctron.transformersmod.transformers.models.tarn.ModelTarn2Mid4;
import com.marctron.transformersmod.util.interfaces.IHasModel;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TarnMid4 extends ItemArmor implements IHasModel {

	public TarnMid4(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabDecepticon);
		setMaxStackSize(1);
		ModItems.ITEMS.add(this);
		
	}

	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
		list.add(TextFormatting.GRAY + I18n.format(TextFormatting.BOLD + I18n.format("IDW")));
	}
	 
		
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0, bFull3D, false));
			super.onArmorTick(world, player, itemStack);
			
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
			
			
			if (itemStack.getItem() == ModItems.TARN_MID4_HELMET) {
				if (world.isRemote) 
				{
					
						player.inventory.armorInventory.set(3, new ItemStack(ModItems.TARN_ALTMODE_HELMET));
						//player.inventory.armorInventory.set(3, new ItemStack(ModItems.VEHICON_ALTMODE_HELMET));
						
					
				}
			}
			
			if (itemStack.getItem() == ModItems.TARN_MID4_CHESTPLATE) {
				if (world.isRemote) 
				{
					
						player.inventory.armorInventory.set(2, new ItemStack(ModItems.TARN_ALTMODE_CHESTPLATE));
						//player.inventory.armorInventory.set(3, new ItemStack(ModItems.VEHICON_ALTMODE_HELMET));
							
					
				}
			}
			
			
			if (itemStack.getItem() == ModItems.TARN_MID4_LEGGINGS) {
				if (world.isRemote) 
				{
					
						player.inventory.armorInventory.set(1, new ItemStack(ModItems.TARN_ALTMODE_LEGGINGS));
						//player.inventory.armorInventory.set(1, new ItemStack(ModItems.VEHICON_ALTMODE_LEGGINGS));
				
					
				}
			} 
			if (itemStack.getItem() == ModItems.TARN_MID4_BOOTS) {
				if (world.isRemote) 
				{
					
						player.inventory.armorInventory.set(0, new ItemStack(ModItems.TARN_ALTMODE_BOOTS));
						//player.inventory.armorInventory.set(0, new ItemStack(ModItems.VEHICON_ALTMODE_BOOTS));
				
					
				}
			}
				}
				
			}, 100);
		}
				
	
	@SideOnly(Side.CLIENT)
	private static ModelTarn2Mid4 model = new ModelTarn2Mid4();
	
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
	
		if(!itemStack.isEmpty())
		{
			
			
			if(itemStack.getItem() instanceof ItemArmor) 
				{
					
					
					
				
					
			
					model.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
					model.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
					model.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
					model.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
					model.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
					model.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
					model.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

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
	
	


	


