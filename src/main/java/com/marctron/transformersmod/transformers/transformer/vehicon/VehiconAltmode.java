	package com.marctron.transformersmod.transformers.transformer.vehicon;

	import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.init.ModItems;
import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.models.vehicon.ModelCustomArmor;
import com.marctron.transformersmod.transformers.models.vehicon.ModelVehiconAltmode;
import com.marctron.transformersmod.util.handlers.SoundsHandler;
import com.marctron.transformersmod.util.interfaces.IHasModel;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

	public final class VehiconAltmode extends ItemArmor implements IHasModel {

		public VehiconAltmode(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
			super(materialIn, renderIndexIn, equipmentSlotIn);
			setUnlocalizedName(name);
			setRegistryName(name);
			
			setMaxStackSize(1);
			ModItems.ITEMS.add(this);
			
		}
		
		
		


		@Override
		
		public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
				((EntityLivingBase) player).addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0));
				 //System.out.println("Ooga Booga");
				 
				 
					
				 
				 
				//((EntityLivingBase) player).addPotionEffect(new PotionEffect(MobEffects.SPEED, 80, 15));
				//if (Minecraft.miecraft)
				//player.motionX *= 1.1;
				//player.motionX = Math.min(3, player.motionX);
				//player.motionZ *= 1.1;
				//player.motionZ = Math.min(3, player.motionZ);
				
				//world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, player.posX, player.posY, player.posZ, 0, 0, 0);
				world.spawnParticle(EnumParticleTypes.SUSPENDED_DEPTH, player.posX, player.posY, player.posZ, 0, 0, 0);
				
				player.fallDistance = 0;
				//player.capabilities.allowFlying = true;
			
				player.cameraPitch = 0F;
				player.cameraYaw = 0F;
				
				player.eyeHeight = 0.4F;
				//player.width = 0.6F; 
				//player.height = 0.8F;
				//player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 0.8F, player.getEntityBoundingBox().minZ + 0.6F));
				
				
//				player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 0.01F, player.getEntityBoundingBox().minZ + 0.6F));
//				player.width = 0F; 
//				player.height = 0F;
				
//				player.entityCollisionReduction = 0F ;
				
				if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown())
				{
					
					//player.setInvisible(true);
					
					//player.setSprinting(true);
					player.moveRelative(0F, -1F, 0.025F, 3F);
					//player.jumpMovementFactor = 0.001F;
				}
				
				
				
				if (itemStack.getItem() == ModItems.VEHICON_ALTMODE_HELMET) {
					
					if (world.isRemote) 
					{
						if (ClientProxy.ROBOT_MODE.isKeyDown()) 
						{
							player.inventory.armorInventory.set(3, new ItemStack(ModItems.VEHICON_MID_2_HELMET));
							Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMONE, 0.3F, 1.9F);
						}
					}
				} 
				
				
				if (itemStack.getItem() == ModItems.VEHICON_ALTMODE_CHESTPLATE) {
					if (world.isRemote) 
					{
						if (ClientProxy.ROBOT_MODE.isKeyDown()) 
						{
							player.inventory.armorInventory.set(2, new ItemStack(ModItems.VEHICON_MID_2_CHESTPLATE));
					
						}
					}
				} 
				if (itemStack.getItem() == ModItems.VEHICON_ALTMODE_LEGGINGS) {
					if (world.isRemote) 
					{
						if (ClientProxy.ROBOT_MODE.isKeyDown()) 
						{
							player.inventory.armorInventory.set(1, new ItemStack(ModItems.VEHICON_MID_2_LEGGINGS));
					
						}
					}
				} 
				if (itemStack.getItem() == ModItems.VEHICON_ALTMODE_BOOTS) {
					if (world.isRemote) 
					{
						if (ClientProxy.ROBOT_MODE.isKeyDown()) 
						{
							player.inventory.armorInventory.set(0, new ItemStack(ModItems.VEHICON_MID_2_BOOTS));
					
						}
					}
				}
				
				
				
			}
		
		@Override
		public final void registerModels() 
		{
			Main.proxy.registerItemRenderer(this, 0, "inventory");
		}
		
		
		
		
		@Override
		@SideOnly(Side.CLIENT)
		@Nullable
		public final ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
		
			if(!itemStack.isEmpty())
			{
				
				
				if(itemStack.getItem() instanceof ItemArmor) 
					{
						
						
						final ModelVehiconAltmode model = new ModelVehiconAltmode();
						
				
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

