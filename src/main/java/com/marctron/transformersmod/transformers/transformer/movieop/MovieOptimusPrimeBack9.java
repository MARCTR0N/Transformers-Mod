package com.marctron.transformersmod.transformers.transformer.movieop;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;

import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.models.movieop.ModelMovieOptimusPrimeMid1;

import com.marctron.transformersmod.transformers.models.starscream.ModelStarscream;
import com.marctron.transformersmod.transformers.transformer.ArmorTypes;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;
import com.marctron.transformersmod.util.handlers.RegistryHandler;
import com.marctron.transformersmod.util.handlers.SoundsHandler;


import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MovieOptimusPrimeBack9 extends ItemArmorTransformer  {
	

	

public MovieOptimusPrimeBack9(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(null);
		setMaxStackSize(1);
		
	}







	
	
	public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
		list.add(TextFormatting.GRAY + I18n.format(TextFormatting.BOLD + I18n.format("MOVIE")));
	}
	
	
	@Override
	@SubscribeEvent
	public final void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
//			player.fallDistance = 0;
			//player.capabilities.allowFlying = true;
			
//			player.noClip = true;

			
			
			
				if (world.isRemote)
				{
					

					
					
					
					
					
				
					
						
						
				
						

						
						Timer timer = new Timer();
						timer.schedule(new TimerTask() {
							
							@Override
							public void run() {
								
								

								
							
								
								if (world.isRemote)
								{
								
										
									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK9_BOOTS) {
										
									player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BOOTS));
									player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_LEGGINGS));
									player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_CHESTPLATE));
									player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_HELMET));
										
									}
									
//									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID1_LEGGINGS) {
//										
//									player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID2_LEGGINGS));
//										
//									}
//									
//									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID1_CHESTPLATE) {
//										
//									player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID2_CHESTPLATE));
//										
//									}
//									
//									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID1_HELMET) {
//										
//									player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID2_HELMET));
//									}
									
									
									
											
								
								}
								
							}
						
						}, 50);
						
						
						
						
			
						
						
					}
				}
			 
			
			
			
			
		
	
	
	
	


	
	@Override
	@SideOnly(Side.CLIENT)
	public final ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
	
		if(!itemStack.isEmpty())
		{
			
			
			if(itemStack.getItem() instanceof ItemArmor) 
				{
					
					
					
				
					
			
				ArmorTypes.modelMovieOptimusPrimeMid1.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				ArmorTypes.modelMovieOptimusPrimeMid1.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				ArmorTypes.modelMovieOptimusPrimeMid1.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
				ArmorTypes.modelMovieOptimusPrimeMid1.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				ArmorTypes.modelMovieOptimusPrimeMid1.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				ArmorTypes.modelMovieOptimusPrimeMid1.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
				ArmorTypes.modelMovieOptimusPrimeMid1.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

				ArmorTypes.modelMovieOptimusPrimeMid1.isSneak = _default.isSneak;
				ArmorTypes.modelMovieOptimusPrimeMid1.isRiding = _default.isRiding;
				ArmorTypes.modelMovieOptimusPrimeMid1.isChild = _default.isChild;
				ArmorTypes.modelMovieOptimusPrimeMid1.rightArmPose = _default.rightArmPose;
				ArmorTypes.modelMovieOptimusPrimeMid1.leftArmPose = _default.leftArmPose;

					return ArmorTypes.modelMovieOptimusPrimeMid1;
				}
			}
			
			return null;
		}
	}
	
	


	



