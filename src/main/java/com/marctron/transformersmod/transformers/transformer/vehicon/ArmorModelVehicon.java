package com.marctron.transformersmod.transformers.transformer.vehicon;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.init.ModItems;
import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.models.vehicon.ModelCustomArmor;
import com.marctron.transformersmod.transformers.models.vehicon.ModelVehiconAltmode;
import com.marctron.transformersmod.util.handlers.SoundsHandler;
import com.marctron.transformersmod.util.interfaces.IHasModel;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ArmorModelVehicon extends ItemArmor implements IHasModel {

	public ArmorModelVehicon(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabTransformers);
		setMaxStackSize(1);
		ModItems.ITEMS.add(this);
		
	}

	@Override
	public final void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
			((EntityLivingBase) player).addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 160, 0));
			
			
			
			//player.fallDistance = 0;
			//player.capabilities.setPlayerWalkSpeed(0.15F);
			player.eyeHeight = 1.65F;
			//player.width = 0.6F; 
			//player.height = 1.8F;
			//player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 1.8F, player.getEntityBoundingBox().minZ + 0.6F));
			
			
			if (itemStack.getItem() == ModItems.CUSTOM_HELMET) {
				if (world.isRemote) 
				{
					if (ClientProxy.MY_KEYBINDING.isKeyDown()) 
					{
						player.inventory.armorInventory.set(3, new ItemStack(ModItems.VEHICON_MID_HELMET));
						//player.inventory.armorInventory.set(3, new ItemStack(ModItems.VEHICON_ALTMODE_HELMET));
						Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMTWO, 0.3F, 1.85F);
					}
				}
			} 
			if (itemStack.getItem() == ModItems.CUSTOM_CHESTPLATE) {
				if (world.isRemote) 
				{
					if (ClientProxy.MY_KEYBINDING.isKeyDown()) 
					{
						player.inventory.armorInventory.set(2, new ItemStack(ModItems.VEHICON_MID_CHESTPLATE));
						//player.inventory.armorInventory.set(2, new ItemStack(ModItems.VEHICON_ALTMODE_CHESTPLATE));
				
					}
				}
			} 
			if (itemStack.getItem() == ModItems.CUSTOM_LEGGINGS) {
				if (world.isRemote) 
				{
					if (ClientProxy.MY_KEYBINDING.isKeyDown()) 
					{
						player.inventory.armorInventory.set(1, new ItemStack(ModItems.VEHICON_MID_LEGGINGS));
						//player.inventory.armorInventory.set(1, new ItemStack(ModItems.VEHICON_ALTMODE_LEGGINGS));
				
					}
				}
			} 
			if (itemStack.getItem() == ModItems.CUSTOM_BOOTS) {
				if (world.isRemote) 
				{
					if (ClientProxy.MY_KEYBINDING.isKeyDown()) 
					{
						player.inventory.armorInventory.set(0, new ItemStack(ModItems.VEHICON_MID_BOOTS));
						//player.inventory.armorInventory.set(0, new ItemStack(ModItems.VEHICON_ALTMODE_BOOTS));
				
					}
				}
			} 
		}
	
	@Override
	public final void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	
	@SideOnly(Side.CLIENT)
	private static ModelCustomArmor model = new ModelCustomArmor();
	
	@Override
	@SideOnly(Side.CLIENT)
	public final ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
	
		if(!itemStack.isEmpty())
		{
			
			
			if(itemStack.getItem() instanceof ItemArmor) 
				{
					
					
					
					
			
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
