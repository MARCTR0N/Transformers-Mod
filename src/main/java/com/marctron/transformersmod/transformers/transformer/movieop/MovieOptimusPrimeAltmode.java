package com.marctron.transformersmod.transformers.transformer.movieop;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.init.ModItems;
import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.models.movieop.ModelMovieOptimusPrimeAltmode;
import com.marctron.transformersmod.transformers.models.movieop.ModelMovieOptimusPrimeMid1;
import com.marctron.transformersmod.transformers.models.movieop.MovieOptimusPrimeModel;
import com.marctron.transformersmod.transformers.models.starscream.ModelStarscream;
import com.marctron.transformersmod.util.handlers.SoundsHandler;
import com.marctron.transformersmod.util.interfaces.IHasModel;

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

public class MovieOptimusPrimeAltmode extends ItemArmor implements IHasModel {
	

	

public MovieOptimusPrimeAltmode(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(null);
		setMaxStackSize(1);
		ModItems.ITEMS.add(this);
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
	
	
	@Override
	public final void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
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
		
		
			if (!Minecraft.getMinecraft().gameSettings.keyBindUseItem.isKeyDown())
			{
				if (!player.isCreative()){
				player.capabilities.isFlying = false;
				}
				
			}
	
			
				
			
				ItemStack heldItem = player.inventory.getCurrentItem();//(EnumHand.MAIN_HAND);
				if (heldItem != null)
				{
				if (heldItem.getItem() == ModItems.PHASE_SHIFTER)
				{
					
					
					if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown())
					{
						
//						player.moveRelative(0F, -0.02F, 0.01F, 3F);
						player.motionY -= 0.014F;
						player.motionY = Math.min(0.25F, player.motionY);
						
					}
					
					if (Minecraft.getMinecraft().gameSettings.keyBindUseItem.isKeyDown())
					{
					player.attackedAtYaw = 0F;
					player.noClip = true;
					player.setSprinting(true);
					player.isImmuneToFire();
					player.isImmuneToExplosions();
					player.canBreatheUnderwater();
					player.hurtResistantTime = 20;
					
					
					
					
					if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown())
					{
						
						player.motionY -= 0.0015F;
						player.motionY = Math.min(0.25F, player.motionY);
					}
					
					
					
					
					
					
					
						if (!Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown())
						{
						
							player.capabilities.isFlying = true;
						
						}				
					}
				}				
				
				
				
//				
//				if (player.getHeldItem(EnumHand.MAIN_HAND) != itemStack){
//					if (itemStack.getItem() == ModItems.PHASE_SHIFTER){
//						player.noClip = true;
//					}
//				
//				}
			}
			
			
				if (world.isRemote) {
					

					
					
					
					
					
					if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown()) 
						{
						//player.limbSwing = 0F;
						//player.limbSwingAmount = 20F;
						
						
						
										

						}
					if (ClientProxy.ROBOT_MODE.isKeyDown()) {
						
						
				
						

						
						
								
								

								
							
								
								if (world.isRemote)
								{
								
										
									if (itemStack.getItem() == ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_BOOTS) {
										
									player.inventory.armorInventory.set(0, new ItemStack(ModItems.MOVIE_OPTIMUS_PRIME_BOOTS));
										
									}
									
									if (itemStack.getItem() == ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_LEGGINGS) {
										
									player.inventory.armorInventory.set(1, new ItemStack(ModItems.MOVIE_OPTIMUS_PRIME_LEGGINGS));
										
									}
									
									if (itemStack.getItem() == ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_CHESTPLATE) {
										
									player.inventory.armorInventory.set(2, new ItemStack(ModItems.MOVIE_OPTIMUS_PRIME_CHESTPLATE));
										
									}
									
									if (itemStack.getItem() == ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_HELMET) {
										
									player.inventory.armorInventory.set(3, new ItemStack(ModItems.MOVIE_OPTIMUS_PRIME_HELMET));
									}
									
									
									
											
								
								}
								
						
						
						
						
						
			
						
						
					}
				}
			} 
			
			
			
			
		
	
	
	
	


	

	@SideOnly(Side.CLIENT)
	private static ModelMovieOptimusPrimeAltmode model = new ModelMovieOptimusPrimeAltmode();
	
	@Override
	@SideOnly(Side.CLIENT)
	public final ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
	
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
	
	


	



