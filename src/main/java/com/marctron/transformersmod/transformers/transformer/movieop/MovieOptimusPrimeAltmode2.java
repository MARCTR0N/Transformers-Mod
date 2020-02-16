package com.marctron.transformersmod.transformers.transformer.movieop;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;
//import com.marctron.transformersmod.entity.AdvancedEntityPlayer;
import com.marctron.transformersmod.network.packets.movieop.PacketMovieOptimusPrime;
import com.marctron.transformersmod.network.packets.tf.TFNetworkManager;
import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.models.movieop.ModelMovieOptimusPrimeAltmode;
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
import net.minecraft.init.Items;
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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.internal.NetworkModHolder.NetworkChecker;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MovieOptimusPrimeAltmode2 extends ItemArmorTransformer {
	

	

	


	private long lastPress = 0;
	private long cooldownTime = 100; // 2000 milliseconds	
	private long time;
	
	private long lastPressTransform = 0;
	private long cooldownTimeTransform = 3000; // 2000 milliseconds	
	private long timeTransform;











	public MovieOptimusPrimeAltmode2(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabAutobot);
		setMaxStackSize(1);
		
	}

	
	public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
		list.add(TextFormatting.GRAY + I18n.format(TextFormatting.BOLD + I18n.format("MOVIE")));
	}
	
	
	
	public void cooldown() {
	    long time = System.currentTimeMillis();
	    if (time > lastPress + cooldownTime) {
	    	
	    	lastPress = time;
	    } 
	} 
	
	@Override
	public final void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		
		
//		player.noClip= true;
//		player.setNoGravity(true);
//		player.motionY = 0;
		
//		player.height= 2.6F;
//		player.width= 0.6F;
		player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 1.8F, player.getEntityBoundingBox().minZ + 0.6F));

//		AdvancedEntityPlayer advancedPlayer = (AdvancedEntityPlayer) player;
		
		player.stepHeight=1.5F;
//		if(!player.isAirBorne && player.onGround){
		
		
		
//		if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_HELMET&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_CHESTPLATE&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() ==  RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_LEGGINGS&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() ==  RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BOOTS) { 
//			
//				System.out.println("oof");
//		}
			player.eyeHeight=2.4F;
			
				if (world.isRemote)
				{
					

					
					
					
					long timeTransform = System.currentTimeMillis();	
					if (timeTransform > lastPressTransform + cooldownTimeTransform) {
			
					if (ClientProxy.ROBOT_MODE.isKeyDown()) {
						
						
				
						
						{
							TFNetworkManager.networkWrapper.sendToServer(new PacketMovieOptimusPrime());
							long time = System.currentTimeMillis();	
							if (time > lastPress + cooldownTime) {
								
									player.playSound(SoundsHandler.WFCPRIMEROBOT, 0.8F, 1.0F);	
//									System.out.println("ouch");
						    	lastPress = time;
						    } 
						}
						
					}
								
								

		 						
							
								
//								if (world.isRemote)
//								{
//								
//										
////									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_HELMET ) {
//									
//									if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_HELMET&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_CHESTPLATE&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() ==  RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_LEGGINGS&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() ==  RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BOOTS) { 
//
////										System.out.println("Fuck");
////										if ( player.inventoryContainer.inventorySlots.contains(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_HELMET)){
//									player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID1_BOOTS));
//								
//									Minecraft.getMinecraft().player.playSound(SoundsHandler.WFCPRIMEROBOT, 1.F, 1.0F);	
//									player.inventory.armorInventory.set(1, new ItemStack(Items.AIR));
//									player.inventory.armorInventory.set(2, new ItemStack(Items.AIR));
//									player.inventory.armorInventory.set(3, new ItemStack(Items.AIR));
////									player.inventoryContainer.inventorySlots.get(1);
//									}
//									
////									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_LEGGINGS) {
////										
////									player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID1_LEGGINGS));
////										
////									}
////									
////									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_CHESTPLATE) {
////										
////									player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID1_CHESTPLATE));
////										
////									}
////									
////									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_HELMET) {
////										
////									player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID1_HELMET));
////									}
//									
//									
//									
//											
//								
//								}
//								
						
						
						
						
						
			
					
						
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
					
					
					
				
					
			
				ArmorTypes.modelMovieOptimusPrime.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				ArmorTypes.modelMovieOptimusPrime.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				ArmorTypes.modelMovieOptimusPrime.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
				ArmorTypes.modelMovieOptimusPrime.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				ArmorTypes.modelMovieOptimusPrime.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				ArmorTypes.modelMovieOptimusPrime.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
				ArmorTypes.modelMovieOptimusPrime.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

				ArmorTypes.modelMovieOptimusPrime.isSneak = _default.isSneak;
				ArmorTypes.modelMovieOptimusPrime.isRiding = _default.isRiding;
				ArmorTypes.modelMovieOptimusPrime.isChild = _default.isChild;
				ArmorTypes.modelMovieOptimusPrime.rightArmPose = _default.rightArmPose;
				ArmorTypes.modelMovieOptimusPrime.leftArmPose = _default.leftArmPose;

					return ArmorTypes.modelMovieOptimusPrime;
				}
			}
			
			return null;
		}
	}
	
	


	



