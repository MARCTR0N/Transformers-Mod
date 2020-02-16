package com.marctron.transformersmod.transformers.transformer.starscream;


import com.marctron.transformersmod.transformers.models.starscream.ModelStarscreamMid1;
import com.marctron.transformersmod.transformers.transformer.ArmorTypes;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;
import com.marctron.transformersmod.util.handlers.RegistryHandler;

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
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Timer;
import java.util.TimerTask;

public class StarscreamMid6 extends ItemArmorTransformer {



    public StarscreamMid6(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
       
        setRegistryName(name);
        setCreativeTab(null);
        setMaxStackSize(1);
       

    }

    @Override


    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0, bFull3D, false));
        player.fallDistance = 0;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                //Starscream
                if (itemStack.getItem() == RegistryHandler.ModItems.STARSCREAM_MID6_BOOTS) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.STARSCREAM_BOOTS));
                    }
                }

                if (itemStack.getItem() == RegistryHandler.ModItems.STARSCREAM_MID6_LEGGINGS) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.STARSCREAM_LEGGINGS));
                    }
                }

                if (itemStack.getItem() == RegistryHandler.ModItems.STARSCREAM_MID6_CHESTPLATE) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.STARSCREAM_CHESTPLATE));
                    }
                }

                if (itemStack.getItem() == RegistryHandler.ModItems.STARSCREAM_MID6_HELMET) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.STARSCREAM_HELMET));
                    }
                }

                //Skywarp
                if (itemStack.getItem() == RegistryHandler.ModItems.SKYWARP_MID6_BOOTS) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.SKYWARP_BOOTS));
                    }
                }

                if (itemStack.getItem() == RegistryHandler.ModItems.SKYWARP_MID6_LEGGINGS) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.SKYWARP_LEGGINGS));
                    }
                }

                if (itemStack.getItem() == RegistryHandler.ModItems.SKYWARP_MID6_CHESTPLATE) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.SKYWARP_CHESTPLATE));
                    }
                }

                if (itemStack.getItem() == RegistryHandler.ModItems.SKYWARP_MID6_HELMET) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.SKYWARP_HELMET));
                    }
                }
                //THUNDERCRACKER
                if (itemStack.getItem() == RegistryHandler.ModItems.THUNDERCRACKER_MID6_BOOTS) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.THUNDERCRACKER_BOOTS));
                    }
                }

                if (itemStack.getItem() == RegistryHandler.ModItems.THUNDERCRACKER_MID6_LEGGINGS) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.THUNDERCRACKER_LEGGINGS));
                    }
                }

                if (itemStack.getItem() == RegistryHandler.ModItems.THUNDERCRACKER_MID6_CHESTPLATE) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.THUNDERCRACKER_CHESTPLATE));
                    }
                }

                if (itemStack.getItem() == RegistryHandler.ModItems.THUNDERCRACKER_MID6_HELMET) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.THUNDERCRACKER_HELMET));
                    }
                }

            }

        }, 70);
        if (world.isRemote) {

//					if(player.onGround)	{
//						world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX + 0.5, player.posY, player.posZ, 1, 0, 1);
//					}
            if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown()) {
                //player.limbSwing = 0F;
                //player.limbSwingAmount = 20F;
                player.resetPositionToBB();


                player.motionY += 0.1F;
                player.motionY = Math.min(0.25F, player.motionY);
                if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown()) {
                    player.setSprinting(false);
                    player.moveRelative(0F, 0F, 0.015F, 3F);
                }

                //player.motionX *= 1.1;
                //player.motionX = Math.min(3, player.motionX);
                //player.motionZ *= 1.1;
                //player.motionZ = Math.min(3, player.motionZ);


                //world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, player.posX, player.posY, player.posZ, 0., -0.3, 0);
//						world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, player.posX, player.posY, player.posZ, 0, -0.3, 0);
//						world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, player.posX + 0.2, player.posY, player.posZ, 0, -0.3, 0);
//						world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, player.posX - 0.2, player.posY, player.posZ, 0, -0.3, 0);
//						world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, player.posX, player.posY, player.posZ + 0.2, 0, -0.3, 0);
//						world.spawnParticle(EnumParticleTypes.DRAGON_BREATH, player.posX, player.posY, player.posZ - 0.2, 0, -0.3, 0);

                world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX, player.posY + 0.15, player.posZ, 0.6D, 0.D, 0.85D);
                world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX + 0.2, player.posY + 0.15, player.posZ, 0.6D, 0.0D, 0.85D);
                world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX - 0.2, player.posY + 0.15, player.posZ, 0.6D, 0.0D, 0.85D);
                world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX, player.posY + 0.15, player.posZ + 0.2, 0.6D, 0.0D, 0.85D);
                world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX, player.posY + 0.15, player.posZ - 0.2, 0.6D, 0.0D, 0.85D);

                world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, player.posX, player.posY, player.posZ, 0., -0.1, 0);
                //world.spawnParticle(EnumParticleTypes.FLAME, player.posX, player.posY, player.posZ, 0, -0.1, 0);


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

        if (!itemStack.isEmpty()) {


            if (itemStack.getItem() instanceof ItemArmor) {


            	ArmorTypes.modelStarscreamMid1.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
            	ArmorTypes.modelStarscreamMid1.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
            	ArmorTypes.modelStarscreamMid1.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
            	ArmorTypes.modelStarscreamMid1.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
            	ArmorTypes.modelStarscreamMid1.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
            	ArmorTypes.modelStarscreamMid1.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
            	ArmorTypes.modelStarscreamMid1.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

            	ArmorTypes.modelStarscreamMid1.isSneak = _default.isSneak;
            	ArmorTypes.modelStarscreamMid1.isRiding = _default.isRiding;
            	ArmorTypes.modelStarscreamMid1.isChild = _default.isChild;
            	ArmorTypes.modelStarscreamMid1.rightArmPose = _default.rightArmPose;
            	ArmorTypes.modelStarscreamMid1.leftArmPose = _default.leftArmPose;

                return ArmorTypes.modelStarscreamMid1;
            }
        }

        return null;
    }
}
	
	


	


