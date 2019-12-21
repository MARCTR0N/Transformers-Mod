package com.marctron.transformersmod.transformers.transformer.movieop;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;

import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.models.movieop.ModelMovieOptimusPrimeMid1;
import com.marctron.transformersmod.transformers.models.movieop.ModelMovieOptimusPrimeMid5;

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

public class MovieOptimusPrimeBack5 extends ItemArmorTransformer {
	

	

public MovieOptimusPrimeBack5(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(null);
		setMaxStackSize(1);
		
	}






//	public MovieOptimusPrime(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
//		super(materialIn, renderIndexIn, equipmentSlotIn);
//		setUnlocalizedName(name);
//		setRegistryName(name);
//		setCreativeTab(Main.tabTransformers);
//		setMaxStackSize(1);
//		ModItems.ITEMS.add(this);
//		
//	}
	

	
	
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
								
										
									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK5_BOOTS) {
										
									player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK6_BOOTS));
										
									}
									
//									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID5_LEGGINGS) {
//										
//									player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID6_LEGGINGS));
//										
//									}
//									
//									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID5_CHESTPLATE) {
//										
//									player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID6_CHESTPLATE));
//										
//									}
//									
//									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID5_HELMET) {
//										
//									player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID6_HELMET));
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
					
					
					
				
					
			
				ArmorTypes.modelMovieOptimusPrimeMid5.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				ArmorTypes.modelMovieOptimusPrimeMid5.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				ArmorTypes.modelMovieOptimusPrimeMid5.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
				ArmorTypes.modelMovieOptimusPrimeMid5.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				ArmorTypes.modelMovieOptimusPrimeMid5.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				ArmorTypes.modelMovieOptimusPrimeMid5.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
				ArmorTypes.modelMovieOptimusPrimeMid5.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

				ArmorTypes.modelMovieOptimusPrimeMid5.isSneak = _default.isSneak;
				ArmorTypes.modelMovieOptimusPrimeMid5.isRiding = _default.isRiding;
				ArmorTypes.modelMovieOptimusPrimeMid5.isChild = _default.isChild;
				ArmorTypes.modelMovieOptimusPrimeMid5.rightArmPose = _default.rightArmPose;
				ArmorTypes.modelMovieOptimusPrimeMid5.leftArmPose = _default.leftArmPose;

					return ArmorTypes.modelMovieOptimusPrimeMid5;
				}
			}
			
			return null;
		}
	}
	
	


	



