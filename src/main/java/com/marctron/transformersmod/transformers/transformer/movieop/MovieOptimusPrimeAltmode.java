package com.marctron.transformersmod.transformers.transformer.movieop;

import java.util.List;

import javax.annotation.Nullable;

import com.marctron.transformersmod.network.packets.PacketInventory;
import com.marctron.transformersmod.network.packets.tf.TFNetworkManager;
import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.transformer.ArmorTypes;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;
import com.marctron.transformersmod.util.handlers.RegistryHandler;
import com.marctron.transformersmod.util.handlers.SoundsHandler;

import cjminecraft.core.network.PacketHandler;
import cjminecraft.core.util.NetworkUtils;
import net.ilexiconn.llibrary.server.network.NetworkHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.NetworkSystem;
import net.minecraft.network.Packet;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MovieOptimusPrimeAltmode extends ItemArmorTransformer {
	

	


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
		player.getCollisionBorderSize();
		player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 0.7F, player.getEntityBoundingBox().minZ + 0.6F));

		player.width = 0.6F; 
		player.height = 0.8F;
		
		
//		player.inventory.getTimesChanged();
//		
//		player.inventory.getItemStack();
//		player.inventory.getStackInSlot(36);
//		if (world.isRemote){
		if (Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown())
		{
			TFNetworkManager.sendToServer(new PacketInventory(1));
			
			
//			player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK1_BOOTS));
			
//			player.inventory.setInventorySlotContents(36, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK1_BOOTS));
			
//			player.inventory.getStackInSlot(36);
//		}
		}
//		player.inventory.markDirty();
//		player.inventoryContainer.detectAndSendChanges();
	        
	        
	           
//		 ((EntityPlayerMP)this.player).connection.sendPacket(new SPacketSetSlot(-2, i, this.getStackInSlot(i)));
		
//	        ((EntityPlayerMP)this.player).connection.sendPacket(new SPacketHeldItemChange());
//	        ((EntityPlayerMP)this.player).connection.sendPacket(new SPacketSoundEffect(SoundsHandler.WFCPRIMEVEHICLE, null, player.posX, player.posY, player.posZ, 1, 1));
		
		player.cameraPitch = 0F;
		player.cameraYaw = 0F;
		 if (world.isRemote) {
		if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown())
		{
			if (player.onGround){
			player.moveRelative(0F, 0F, 0.017F, 3F);
			}
		}
		}
		 
		 
						
				
				

			
			
				if (world.isRemote) 
				{
					

					
				

//			        if (player instanceof AbstractClientPlayer) {
			        
//			            EntityPlayer player = (EntityPlayer) entity;
					
					 
					
				
					if (ClientProxy.ROBOT_MODE.isKeyDown()) {
//						player.playSound(SoundsHandler.WFCPRIMEVEHICLE, 1F, 1.0F);	
						
						if (world.isRemote && !(world.isRemote))
						player.world.getEntityByID(4);

						
						
								
								

								
							
								
								if (world.isRemote)
								{
									if ((player instanceof EntityPlayer )) {
//										player.world.getPlayerEntityByName(getUnlocalizedName());
									
									if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_HELMET&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_CHESTPLATE&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() ==  RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_LEGGINGS&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() ==  RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_BOOTS) { 
//										((EntityPlayerMP)this.player).connection.sendPacket(new SPacketSetSlot(-2, i, this.getStackInSlot(i)));
//										(EntityPlayerMP.connection.sendPacket(new SPacketCollectItem());
									
									player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK1_BOOTS));

//										player.inventory.setInventorySlotContents(36, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK1_BOOTS));
										
									player.inventory.armorInventory.set(1, new ItemStack(Items.AIR));
									player.inventory.armorInventory.set(2, new ItemStack(Items.AIR));
									player.inventory.armorInventory.set(3, new ItemStack(Items.AIR));
									player.playSound(SoundsHandler.WFCPRIMEVEHICLE, 1F, 1.0F);	
//									player.inventory.markDirty();
//									player.inventoryContainer.detectAndSendChanges();
//									player.inventoryContainer.sendContainerToPlayer()
							
									
//									player.inventoryContainer.inventorySlots.notifyAll();
									
											
										}
									
//									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_LEGGINGS) {
//										
//									player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_LEGGINGS));
//										
//									}
//									
//									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_CHESTPLATE) {
//										
//									player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_CHESTPLATE));
//										
//									}
//									
//									if (itemStack.getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_HELMET) {
//										
//									player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_HELMET));
//									}
									
									
									
											
								
								}
								
						
						
						
						
								}
			
					}
						
					}
				}
//			} 
			
			
			
			
		
	
	
	
	


	

	
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
	
	


	



