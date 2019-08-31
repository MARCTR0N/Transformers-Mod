package com.marctron.transformersmod.transformers;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.models.sideswipe.ModelSideswipeAltmode;
import com.marctron.transformersmod.util.handlers.RegistryHandler;
import com.marctron.transformersmod.util.handlers.SoundsHandler;

import net.ilexiconn.llibrary.server.animation.Animation;
import net.ilexiconn.llibrary.server.animation.IAnimatedEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Vurp extends ItemArmor {

//    @SideOnly(Side.CLIENT)
//    private static ModelSideswipeAltmode model = new ModelSideswipeAltmode();

	@SideOnly(Side.CLIENT)
    private static ModelVurp model = new ModelVurp();
    

    public Vurp(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tabDecepticon);
        setMaxStackSize(1);
        

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
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0, bFull3D, false));
    }

//        player.dropItem(true);
//
//        player.cameraPitch = 0F;
//        player.cameraYaw = 0F;
//        //player.moveRelative(0F, -1F, 0.F, 0F);
//        player.eyeHeight = 0.4F;
//        if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown()) {
//            if (player.onGround) {
//                player.moveRelative(0F, 0F, 0.035F, 3F);
//            }
//        }

//			if (world.isRemote){
//			player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 0.01F, player.getEntityBoundingBox().minZ + 0.6F));
//			player.width = 0F;
//			player.height = 0F;
//			}


//        if (itemStack.getItem() == RegistryHandler.ModItems.SIDESWIPE_ALTMODE_HELMET) {
//            if (world.isRemote) {
//                if (ClientProxy.ROBOT_MODE.isKeyDown()) {
//                    player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.SIDESWIPE_MID4_HELMET));
//                    //player.inventory.armorInventory.set(3, new ItemStack(ModItems.VEHICON_ALTMODE_HELMET));
//                    Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMONE, 0.3F, 1.9F);
//                }
//            }
//        }
//        if (itemStack.getItem() == RegistryHandler.ModItems.SIDESWIPE_ALTMODE_CHESTPLATE) {
//            if (world.isRemote) {
//                if (ClientProxy.ROBOT_MODE.isKeyDown()) {
//                    player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.SIDESWIPE_MID4_CHESTPLATE));
//                    //player.inventory.armorInventory.set(2, new ItemStack(ModItems.VEHICON_ALTMODE_CHESTPLATE));
//
//                }
//            }
//        }
//        if (itemStack.getItem() == RegistryHandler.ModItems.SIDESWIPE_ALTMODE_LEGGINGS) {
//            if (world.isRemote) {
//                if (ClientProxy.ROBOT_MODE.isKeyDown()) {
//                    player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.SIDESWIPE_MID4_LEGGINGS));
//                    //player.inventory.armorInventory.set(1, new ItemStack(ModItems.VEHICON_ALTMODE_LEGGINGS));
//
//                }
//            }
//        }
//        if (itemStack.getItem() == RegistryHandler.ModItems.SIDESWIPE_ALTMODE_BOOTS) {
//            if (world.isRemote) {
//                if (ClientProxy.ROBOT_MODE.isKeyDown()) {
//                    player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.SIDESWIPE_MID4_BOOTS));
//                    //player.inventory.armorInventory.set(0, new ItemStack(ModItems.VEHICON_ALTMODE_BOOTS));
//
//                }
//            }
//        }
//    }

    @Override
    @SideOnly(Side.CLIENT)
    public final ModelVurp getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {

        if (!itemStack.isEmpty()) {


            if (itemStack.getItem() instanceof ItemArmor) {


                model.Head.showModel = armorSlot == EntityEquipmentSlot.HEAD;
                model.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
                model.CHEST.showModel = (armorSlot == EntityEquipmentSlot.CHEST);
                model.RightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                model.RightArm_1.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                model.RightLeg.showModel = (armorSlot == EntityEquipmentSlot.FEET);
                model.RightLeg_1.showModel = (armorSlot == EntityEquipmentSlot.FEET);


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