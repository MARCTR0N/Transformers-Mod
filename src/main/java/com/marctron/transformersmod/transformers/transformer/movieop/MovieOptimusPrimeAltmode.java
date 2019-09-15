package com.marctron.transformersmod.transformers.transformer.movieop;

import java.util.List;

import javax.annotation.Nullable;

import com.marctron.transformersmod.proxy.ClientProxy;
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

public class MovieOptimusPrimeAltmode extends ItemArmor {
	

	

public MovieOptimusPrimeAltmode(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
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
		player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0, bFull3D, false));

		player.dropItem(true);
		
		player.cameraPitch = 0F;
		player.cameraYaw = 0F;
		if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown())
		{
			if (player.onGround){
			player.moveRelative(0F, 0F, 0.017F, 3F);
			}
		}
		
		
						
				
				

			
			
				if (world.isRemote) {
					

					
					
					
					
					
				
					if (ClientProxy.ROBOT_MODE.isKeyDown()) {
						
						
				
						

						
						
								
								

								
							
								
								if (world.isRemote)
								{
								
										
									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_BOOTS) {
										
									player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BOOTS));
										
									}
									
									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_LEGGINGS) {
										
									player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_LEGGINGS));
										
									}
									
									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_CHESTPLATE) {
										
									player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_CHESTPLATE));
										
									}
									
									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_HELMET) {
										
									player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_HELMET));
									}
									
									
									
											
								
								}
								
						
						
						
						
						
			
						
						
					}
				}
			} 
			
			
			
			
		
	
	
	
	


	

	
	@Override
	@SideOnly(Side.CLIENT)
	public final ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
	
		if(!itemStack.isEmpty())
		{
			
			
			if(itemStack.getItem() instanceof ItemArmor) 
				{
					
					
					
				
					
			
					ArmorTypes.modelMovieOptimusPrimeAltmode.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
					ArmorTypes.modelMovieOptimusPrimeAltmode.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
					ArmorTypes.modelMovieOptimusPrimeAltmode.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
					ArmorTypes.modelMovieOptimusPrimeAltmode.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
					ArmorTypes.modelMovieOptimusPrimeAltmode.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
					ArmorTypes.modelMovieOptimusPrimeAltmode.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
					ArmorTypes.modelMovieOptimusPrimeAltmode.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

					ArmorTypes.modelMovieOptimusPrimeAltmode.isSneak = _default.isSneak;
					ArmorTypes.modelMovieOptimusPrimeAltmode.isRiding = _default.isRiding;
					ArmorTypes.modelMovieOptimusPrimeAltmode.isChild = _default.isChild;
					ArmorTypes.modelMovieOptimusPrimeAltmode.rightArmPose = _default.rightArmPose;
					ArmorTypes.modelMovieOptimusPrimeAltmode.leftArmPose = _default.leftArmPose;

					return ArmorTypes.modelMovieOptimusPrimeAltmode;
				}
			}
			
			return null;
		}
	}
	
	


	



