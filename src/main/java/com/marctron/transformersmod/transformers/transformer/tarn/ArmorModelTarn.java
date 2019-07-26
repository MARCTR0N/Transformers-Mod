package com.marctron.transformersmod.transformers.transformer.tarn;

import java.util.List;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.init.ModItems;
import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.models.TarnModel;
import com.marctron.transformersmod.transformers.models.tarn.ModelTarn2;
import com.marctron.transformersmod.transformers.models.tarn.TarnChest;
import com.marctron.transformersmod.transformers.models.vehicon.ModelCustomArmor;
import com.marctron.transformersmod.transformers.models.vehicon.ModelVehiconMid;
import com.marctron.transformersmod.util.handlers.SoundsHandler;
import com.marctron.transformersmod.util.interfaces.IHasModel;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
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
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ArmorModelTarn extends ItemArmor implements IHasModel {

	public ArmorModelTarn(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
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
			((EntityLivingBase) player).addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0));
			super.onArmorTick(world, player, itemStack);
			
			 
			if (itemStack.getItem() == ModItems.TARN_CHESTPLATE) {
				if (world.isRemote) 
				{
					if (ClientProxy.MY_KEYBINDING.isKeyDown()) 
					{
						player.inventory.armorInventory.set(2, new ItemStack(ModItems.TARN_MID1_CHESTPLATE));
						//player.inventory.armorInventory.set(2, new ItemStack(ModItems.VEHICON_ALTMODE_CHESTPLATE));
				
					}
				}
			 
			} 
		}
	
	@SideOnly(Side.CLIENT)
	private static TarnChest model = new TarnChest();
	
	
	
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
	
	


	


