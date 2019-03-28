package com.marctron.transformersmod.transformers;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.init.ModItems;
import com.marctron.transformersmod.transformers.models.AJModel;
import com.marctron.transformersmod.transformers.models.TarnModel;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ArmorModelAJ extends ItemArmor implements IHasModel {
	

	private static final float f1 = 2.9f;
	private static final float f = 0.6f;


	public ArmorModelAJ(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabTransformers);
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
			((EntityLivingBase) player).addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 160, 0));
			player.fallDistance = 0;
			//player.capabilities.allowFlying = true;
			
			player.width = 0.6F; 
			player.height = 2.8F;
			player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 2.8F, player.getEntityBoundingBox().minZ + 0.6F));
		    
			
			if (itemStack.getItem() == ModItems.AJ_CHESTPLATE) {
				if (world.isRemote) {
					if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown()) {
						player.limbSwing = 0F;
						player.limbSwingAmount = 0F;
						player.eyeHeight = 1.9F;
												
						player.motionY += 0.065;
						player.motionY = Math.min(1, player.motionY);
						
						player.motionX *= 1.1;
						player.motionX = Math.min(3, player.motionX);
						player.motionZ *= 1.1;
						player.motionZ = Math.min(3, player.motionZ);
						
					
						world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, player.posX, player.posY, player.posZ, 0, 0, 0);
						world.spawnParticle(EnumParticleTypes.FLAME, player.posX, player.posY, player.posZ, 0, 0, 0);
						world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, player.posX, player.posY, player.posZ, 0, 0, 0);
						world.spawnParticle(EnumParticleTypes.FLAME, player.posX, player.posY, player.posZ, 0, 0, 0);
						
						
				
					}
				}
			} 
			
			
			
			
		}
	
	
	
	


	private void setSize(float f, float f1) {
		f = 0.6f;
		f1 = 2.9f;
		
	}


	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
	
		if(!itemStack.isEmpty())
		{
			
			
			if(itemStack.getItem() instanceof ItemArmor) 
				{
					
					
					AJModel model = new AJModel();
				
					
			
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
	
	


	


