package com.marctron.transformersmod.transformers.transformer.movieop;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;

import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.models.movieop.ModelMovieOptimusPrimeMid8;
import com.marctron.transformersmod.transformers.transformer.ArmorTypes;
import com.marctron.transformersmod.util.handlers.RegistryHandler;


import net.minecraft.client.Minecraft;
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
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MovieOptimusPrimeMid8 extends ItemArmor {
	

	

public MovieOptimusPrimeMid8(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
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
		player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0, bFull3D, false));
//			player.fallDistance = 0;
			//player.capabilities.allowFlying = true;
			
//			player.noClip = true;

			
			
				if (world.isRemote) {
					

					
					
					
				
						
						
				
						

						
						Timer timer = new Timer();
						timer.schedule(new TimerTask() {
							
							@Override
							public void run() {
								
								

								
							
								
								if (world.isRemote)
								{
								
										
									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID8_BOOTS) {
										
									player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID9_BOOTS));
										
									}
									
									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID8_LEGGINGS) {
										
									player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID9_LEGGINGS));
										
									}
									
									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID8_CHESTPLATE) {
										
									player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID9_CHESTPLATE));
										
									}
									
									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID8_HELMET) {
										
									player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID9_HELMET));
									}
									
									
									
											
								
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
					
					
					
				
					
			
				ArmorTypes.modelMovieOptimusPrimeMid8.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				ArmorTypes.modelMovieOptimusPrimeMid8.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				ArmorTypes.modelMovieOptimusPrimeMid8.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
				ArmorTypes.modelMovieOptimusPrimeMid8.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				ArmorTypes.modelMovieOptimusPrimeMid8.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				ArmorTypes.modelMovieOptimusPrimeMid8.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
				ArmorTypes.modelMovieOptimusPrimeMid8.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

				ArmorTypes.modelMovieOptimusPrimeMid8.isSneak = _default.isSneak;
				ArmorTypes.modelMovieOptimusPrimeMid8.isRiding = _default.isRiding;
				ArmorTypes.modelMovieOptimusPrimeMid8.isChild = _default.isChild;
				ArmorTypes.modelMovieOptimusPrimeMid8.rightArmPose = _default.rightArmPose;
				ArmorTypes.modelMovieOptimusPrimeMid8.leftArmPose = _default.leftArmPose;

					return ArmorTypes.modelMovieOptimusPrimeMid8;
				}
			}
			
			return null;
		}
	}
	
	


	



