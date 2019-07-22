package com.marctron.transformersmod.transformers.transformer.tarn;

import java.util.Timer;
import java.util.TimerTask;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.entity.EntityBullet;
import com.marctron.transformersmod.entity.EntityLargeRocket;
import com.marctron.transformersmod.init.ModItems;
import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.models.sideswipe.ModelSideswipeAltmode;
import com.marctron.transformersmod.transformers.models.tarn.ModelTarnAltmode;
import com.marctron.transformersmod.util.handlers.SoundsHandler;
import com.marctron.transformersmod.util.interfaces.IHasModel;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TarnAltmode extends ItemArmor implements IHasModel
{
	
	
	long cooldownTime2 = 200000000; // 2000 milliseconds
	long lastAttack2 = 0;
	
	long cooldownTime = 900; // 2000 milliseconds
	long lastAttack = 0;
	int Cooldown;
	
	public TarnAltmode(String name, int cooldown, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(null);
		setMaxStackSize(1);
		ModItems.ITEMS.add(this);
		
		Cooldown = cooldown;
		
	}

		 
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
//			((EntityLivingBase) player).addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0));
		player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0, bFull3D, false));
			player.limbSwingAmount= 0f;
			
			player.dropItem(true);
			
			player.cameraPitch = 0F;
			player.cameraYaw = 0F;
			//player.moveRelative(0F, -1F, 0.F, 0F);
			player.eyeHeight = 1.6F;
			if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown())
			{
				if (player.onGround){
				player.moveRelative(0F, 0F, 0.03F, 1F);
				}
			}
			
			

			
//			if (!world.isRemote){
//				
//				if (Minecraft.getMinecraft().gameSettings.keyBindUseItem.isKeyDown())
//				{
//									ItemStack itemstack = player.getHeldItem(EnumHand.MAIN_HAND);
//									Vec3d aim = player.getLookVec();
//									EntityLargeRocket fireball = new EntityLargeRocket(world, player, 1, 1, 1);
//				
//									long time = System.currentTimeMillis();
//								    if (time > lastAttack + cooldownTime) {
//								        // Do something
//								        lastAttack = time;
//								        fireball.explosionPower = 2;
//								        world.spawnEntity(fireball);
//								        
//								        if (fireball.isDead){
//											
//											world.newExplosion(fireball,player.posX + aim.x *1.5D, player.posY + aim.y + 1 *1.1D, player.posZ + aim.z *1.5D, 1f, false, true);
//
//								       
//									    }
//								        fireball.setPosition(player.posX + aim.x *1.5D, player.posY + aim.y + 1 *1.1D, player.posZ + aim.z *1.5D);
//										fireball.accelerationX = aim.x *0.05; fireball.accelerationY = aim.y *0.05; fireball.accelerationZ = aim.z *0.05;
//										
//								    }
//								    
//
//			
//				}
//			
//			}
//			
		    
		    
			if (itemStack.getItem() == ModItems.TARN_ALTMODE_HELMET) {
				if (world.isRemote) 
				{
					if (ClientProxy.ROBOT_MODE.isKeyDown()) 
					{
						player.inventory.armorInventory.set(3, new ItemStack(ModItems.TARN_MID5_HELMET));
						//player.inventory.armorInventory.set(3, new ItemStack(ModItems.VEHICON_ALTMODE_HELMET));
						Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMONE, 0.3F, 1.9F);	
					}
				}
			} 
			if (itemStack.getItem() == ModItems.TARN_ALTMODE_CHESTPLATE) {
				if (world.isRemote) 
				{
					if (ClientProxy.ROBOT_MODE.isKeyDown()) 
					{
						player.inventory.armorInventory.set(2, new ItemStack(ModItems.TARN_MID5_CHESTPLATE));
						//player.inventory.armorInventory.set(2, new ItemStack(ModItems.VEHICON_ALTMODE_CHESTPLATE));
				
					}
				}
			} 
			if (itemStack.getItem() == ModItems.TARN_ALTMODE_LEGGINGS) {
				if (world.isRemote) 
				{
					if (ClientProxy.ROBOT_MODE.isKeyDown()) 
					{
						player.inventory.armorInventory.set(1, new ItemStack(ModItems.TARN_MID5_LEGGINGS));
						//player.inventory.armorInventory.set(1, new ItemStack(ModItems.VEHICON_ALTMODE_LEGGINGS));
				
					}
				}
			} 
			if (itemStack.getItem() == ModItems.TARN_ALTMODE_BOOTS) {
				if (world.isRemote) 
				{
					if (ClientProxy.ROBOT_MODE.isKeyDown()) 
					{
						player.inventory.armorInventory.set(0, new ItemStack(ModItems.TARN_MID5_BOOTS));
						//player.inventory.armorInventory.set(0, new ItemStack(ModItems.VEHICON_ALTMODE_BOOTS));
				
					}
				}
			}
			
		}
			
//			if (itemStack.getItem() == ModItems.SIDESWIPE_CHESTPLATE) 
//			{
//				if (world.isRemote) 
//				{
//			
//			player.width = 0.6F; 
//			player.height = 1.5F;
//			player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 1.5F, player.getEntityBoundingBox().minZ + 0.6F));
//		
//				}
//			} 
	
				
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	
	@SideOnly(Side.CLIENT)
	private static ModelTarnAltmode model = new ModelTarnAltmode();
	
	@Override
	@SideOnly(Side.CLIENT)
	public final ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
	
		if(!itemStack.isEmpty())
		{
			
			
			if(itemStack.getItem() instanceof ItemArmor) 
				{
					
					
					
					
			
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
