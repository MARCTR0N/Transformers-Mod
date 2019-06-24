package com.marctron.transformersmod.transformers.transformer.starscream;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.init.ModItems;
import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.models.starscream.ModelStarscreamMid1;
import com.marctron.transformersmod.transformers.models.starscream.ModelStarscreamMid2;
import com.marctron.transformersmod.util.handlers.SoundsHandler;
import com.marctron.transformersmod.util.interfaces.IHasModel;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StarscreamMid2 extends ItemArmor implements IHasModel {
	

	

	public StarscreamMid2(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(null);
		setMaxStackSize(1);
		ModItems.ITEMS.add(this);
		
	}
	
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	
	
	
	
	@Override
	
	
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
			((EntityLivingBase) player).addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0));
			player.fallDistance = 0;

	//Starscream
			if (itemStack.getItem() == ModItems.STARSCREAM_MID2_BOOTS) {
				if (world.isRemote)
				{
			player.inventory.armorInventory.set(0, new ItemStack(ModItems.STARSCREAM_MID3_BOOTS));
				}
			}
			
			if (itemStack.getItem() == ModItems.STARSCREAM_MID2_LEGGINGS) {
				if (world.isRemote)
				{
			player.inventory.armorInventory.set(1, new ItemStack(ModItems.STARSCREAM_MID3_LEGGINGS));
				}
			}
			
			if (itemStack.getItem() == ModItems.STARSCREAM_MID2_CHESTPLATE) {
				if (world.isRemote)
				{
			player.inventory.armorInventory.set(2, new ItemStack(ModItems.STARSCREAM_MID3_CHESTPLATE));
				}
			}
			
			if (itemStack.getItem() == ModItems.STARSCREAM_MID2_HELMET) {
				if (world.isRemote)
				{
			player.inventory.armorInventory.set(3, new ItemStack(ModItems.STARSCREAM_MID3_HELMET));
				}
			}
			
	//Skywarp
			if (itemStack.getItem() == ModItems.SKYWARP_MID2_BOOTS) {
				if (world.isRemote)
				{
			player.inventory.armorInventory.set(0, new ItemStack(ModItems.SKYWARP_MID3_BOOTS));
				}
			}
			
			if (itemStack.getItem() == ModItems.SKYWARP_MID2_LEGGINGS) {
				if (world.isRemote)
				{
			player.inventory.armorInventory.set(1, new ItemStack(ModItems.SKYWARP_MID3_LEGGINGS));
				}
			}
			
			if (itemStack.getItem() == ModItems.SKYWARP_MID2_CHESTPLATE) {
				if (world.isRemote)
				{
			player.inventory.armorInventory.set(2, new ItemStack(ModItems.SKYWARP_MID3_CHESTPLATE));
				}
			}
			
			if (itemStack.getItem() == ModItems.SKYWARP_MID2_HELMET) {
				if (world.isRemote)
				{
			player.inventory.armorInventory.set(3, new ItemStack(ModItems.SKYWARP_MID3_HELMET));
				}
			}
	//THUNDERCRACKER
			if (itemStack.getItem() == ModItems.THUNDERCRACKER_MID2_BOOTS) {
				if (world.isRemote)
				{
			player.inventory.armorInventory.set(0, new ItemStack(ModItems.THUNDERCRACKER_MID3_BOOTS));
				}
			}
			
			if (itemStack.getItem() == ModItems.THUNDERCRACKER_MID2_LEGGINGS) {
				if (world.isRemote)
				{
			player.inventory.armorInventory.set(1, new ItemStack(ModItems.THUNDERCRACKER_MID3_LEGGINGS));
				}
			}
			
			if (itemStack.getItem() == ModItems.THUNDERCRACKER_MID2_CHESTPLATE) {
				if (world.isRemote)
				{
			player.inventory.armorInventory.set(2, new ItemStack(ModItems.THUNDERCRACKER_MID3_CHESTPLATE));
				}
			}
			
			if (itemStack.getItem() == ModItems.THUNDERCRACKER_MID2_HELMET) {
				if (world.isRemote)
				{
			player.inventory.armorInventory.set(3, new ItemStack(ModItems.THUNDERCRACKER_MID3_HELMET));
				}
			}
			
			
				if (world.isRemote) {
					
//					if(player.onGround)	{
//						world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX + 0.5, player.posY, player.posZ, 1, 0, 1);
//					}
					if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown()) {
						//player.limbSwing = 0F;
						//player.limbSwingAmount = 20F;
						player.resetPositionToBB();
						
						player.eyeHeight = 1.9F;
										
					
						
						player.motionY += 0.1F;
						player.motionY = Math.min(0.25F, player.motionY);
						if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown())
					{
						player.setSprinting(false);
						player.moveRelative(0F, 0F, 0.015F, 3F);
					}
						
						//player.motionX *= 1.1;
						//player.motionX = Math.min(3, player.motionX);
						//player.motionZ *= 1.1;
						//player.motionZ = Math.min(3, player.motionZ);
						
						
						
						
						//world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, player.posX, player.posY, player.posZ, 0., -0.3, 0);
//						world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, player.posX, player.posY, player.posZ, 0, -0.3, 0);
//						world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, player.posX + 0.2, player.posY, player.posZ, 0, -0.3, 0);
//						world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, player.posX - 0.2, player.posY, player.posZ, 0, -0.3, 0);
//						world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, player.posX, player.posY, player.posZ + 0.2, 0, -0.3, 0);
//						world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, player.posX, player.posY, player.posZ - 0.2, 0, -0.3, 0);
						
						world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX, player.posY + 0.15, player.posZ, 0.6D, 0.D, 0.85D);
						world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX + 0.2, player.posY + 0.15, player.posZ, 0.6D, 0.0D, 0.85D);
						world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX - 0.2, player.posY + 0.15, player.posZ, 0.6D, 0.0D, 0.85D);
						world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX, player.posY + 0.15, player.posZ + 0.2, 0.6D, 0.0D, 0.85D);
						world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX, player.posY + 0.15, player.posZ - 0.2, 0.6D, 0.0D, 0.85D);
						
						world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, player.posX, player.posY, player.posZ, 0., -0.1, 0);
						//world.spawnParticle(EnumParticleTypes.FLAME, player.posX, player.posY, player.posZ, 0, -0.1, 0);
					
						
						}
					
				}
			} 
			
			
			
			
		
	
	
	
	


	private void setSize(float f, float f1) {
		f = 0.6f;
		f1 = 2.9f;
		
	}

	@SideOnly(Side.CLIENT)
	private static ModelStarscreamMid2 model = new ModelStarscreamMid2();


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
	
	


	


