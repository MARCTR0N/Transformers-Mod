package com.marctron.transformersmod.transformers.transformer.starscream;

import com.marctron.transformersmod.Main;

import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.models.starscream.ModelStarscream;
import com.marctron.transformersmod.transformers.transformer.ArmorTypes;
import com.marctron.transformersmod.util.handlers.RegistryHandler;
import com.marctron.transformersmod.util.handlers.SoundsHandler;
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
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class Starscream extends ItemArmor {


    


    public Starscream(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tabDecepticon);
        setMaxStackSize(1);
       

    }

    public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
        list.add(TextFormatting.GRAY + I18n.format(TextFormatting.BOLD + I18n.format("G1")));
    }

    @Override
    @SubscribeEvent
    public final void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0, bFull3D, false));
        player.fallDistance = 0;
        //player.capabilities.allowFlying = true;


        if (world.isRemote) {


            if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown()) {
                //player.limbSwing = 0F;
                //player.limbSwingAmount = 20F;
                player.resetPositionToBB();


                player.motionY += 0.1F;
                player.motionY = Math.min(0.25F, player.motionY);
                if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown()) {
                    player.setSprinting(false);
                    player.moveRelative(0F, 0F, 0.0099F, 3F);
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
            if (ClientProxy.ALT_MODE.isKeyDown()) {


                //Starscream


//						Timer timer = new Timer();
//						timer.schedule(new TimerTask() {
//
//							@Override
//							public void run() {


                if (itemStack.getItem() == RegistryHandler.ModItems.STARSCREAM_BOOTS) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.STARSCREAM_MID1_BOOTS));
                        Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMTWO, 0.3F, 1.85F);
                    }
                }

                if (itemStack.getItem() == RegistryHandler.ModItems.STARSCREAM_LEGGINGS) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.STARSCREAM_MID1_LEGGINGS));
                    }
                }

                if (itemStack.getItem() == RegistryHandler.ModItems.STARSCREAM_CHESTPLATE) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.STARSCREAM_MID1_CHESTPLATE));
                    }
                }

                if (itemStack.getItem() == RegistryHandler.ModItems.STARSCREAM_HELMET) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.STARSCREAM_MID1_HELMET));
                    }
                }


                //Skywarp
                if (itemStack.getItem() == RegistryHandler.ModItems.SKYWARP_BOOTS) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.SKYWARP_MID1_BOOTS));
                        Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMTWO, 0.3F, 1.85F);
                    }
                }

                if (itemStack.getItem() == RegistryHandler.ModItems.SKYWARP_LEGGINGS) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.SKYWARP_MID1_LEGGINGS));
                    }
                }

                if (itemStack.getItem() == RegistryHandler.ModItems.SKYWARP_CHESTPLATE) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.SKYWARP_MID1_CHESTPLATE));
                    }
                }

                if (itemStack.getItem() == RegistryHandler.ModItems.SKYWARP_HELMET) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.SKYWARP_MID1_HELMET));
                    }
                }

                //Thundercracker
                if (itemStack.getItem() == RegistryHandler.ModItems.THUNDERCRACKER_BOOTS) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.THUNDERCRACKER_MID1_BOOTS));
                        Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMTWO, 0.3F, 1.85F);
                    }
                }

                if (itemStack.getItem() == RegistryHandler.ModItems.THUNDERCRACKER_LEGGINGS) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.THUNDERCRACKER_MID1_LEGGINGS));
                    }
                }

                if (itemStack.getItem() == RegistryHandler.ModItems.THUNDERCRACKER_CHESTPLATE) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.THUNDERCRACKER_MID1_CHESTPLATE));
                    }
                }

                if (itemStack.getItem() == RegistryHandler.ModItems.THUNDERCRACKER_HELMET) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.THUNDERCRACKER_MID1_HELMET));
                    }
                }


//							}

//						}, 60);


//
//					if (world.isRemote)
//					{
//
//					if (world.getWorldTime() % 20 !=0) {
//
//						if (itemStack.getItem() == ModItems.STARSCREAM_BOOTS) {
//
//						player.inventory.armorInventory.set(0, new ItemStack(ModItems.STARSCREAM_MID1_BOOTS));
//						Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMTWO, 0.3F, 1.85F);
//
//						}
//
//						if (itemStack.getItem() == ModItems.STARSCREAM_LEGGINGS) {
//
//						player.inventory.armorInventory.set(1, new ItemStack(ModItems.STARSCREAM_MID1_LEGGINGS));
//
//						}
//
//						if (itemStack.getItem() == ModItems.STARSCREAM_CHESTPLATE) {
//
//						player.inventory.armorInventory.set(2, new ItemStack(ModItems.STARSCREAM_MID1_CHESTPLATE));
//
//						}
//
//						if (itemStack.getItem() == ModItems.STARSCREAM_HELMET) {
//
//						player.inventory.armorInventory.set(3, new ItemStack(ModItems.STARSCREAM_MID1_HELMET));
//						}
//
//					}
//					}


            }
        }
    }

    private void setSize(float f, float f1) {
        f = 0.6f;
        f1 = 2.9f;

    }

    @SideOnly(Side.CLIENT)
    @Nullable
    @Override
    public final ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {

        if (!itemStack.isEmpty()) {


            if (itemStack.getItem() instanceof ItemArmor) {


                ArmorTypes.modelStarscream.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
                ArmorTypes.modelStarscream.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
                ArmorTypes.modelStarscream.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
                ArmorTypes.modelStarscream.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                ArmorTypes.modelStarscream.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                ArmorTypes.modelStarscream.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
                ArmorTypes.modelStarscream.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

                ArmorTypes.modelStarscream.isSneak = _default.isSneak;
                ArmorTypes.modelStarscream.isRiding = _default.isRiding;
                ArmorTypes.modelStarscream.isChild = _default.isChild;
                ArmorTypes.modelStarscream.rightArmPose = _default.rightArmPose;
                ArmorTypes.modelStarscream.leftArmPose = _default.leftArmPose;

                return ArmorTypes.modelStarscream;
            }
        }

        return null;
    }
}
	
	


	


