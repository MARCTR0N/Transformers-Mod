package com.marctron.transformersmod.transformers.transformer.sideswipe;


import java.util.Timer;
import java.util.TimerTask;

import com.marctron.transformersmod.transformers.transformer.ArmorTypes;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;
import com.marctron.transformersmod.util.handlers.RegistryHandler;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SideswipeMid extends ItemArmorTransformer {



    public SideswipeMid(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
    	super(materialIn, renderIndexIn, equipmentSlotIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(null);
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
        //player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0, bFull3D, false));


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {


                player.eyeHeight = 1.25F;

                if (itemStack.getItem() == RegistryHandler.ModItems.SIDESWIPE_MID_HELMET) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.SIDESWIPE_MID2_HELMET));
                    }
                }
                if (itemStack.getItem() == RegistryHandler.ModItems.SIDESWIPE_MID_CHESTPLATE) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.SIDESWIPE_MID2_CHESTPLATE));
                    }
                }
                if (itemStack.getItem() == RegistryHandler.ModItems.SIDESWIPE_MID_LEGGINGS) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.SIDESWIPE_MID2_LEGGINGS));
                    }
                }
                if (itemStack.getItem() == RegistryHandler.ModItems.SIDESWIPE_MID_BOOTS) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.SIDESWIPE_MID2_BOOTS));
                    }
                }
            }


        }, 60);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {

        if (!itemStack.isEmpty()) {


            if (itemStack.getItem() instanceof ItemArmor) {


            	ArmorTypes.modelSideswipeMid.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
            	ArmorTypes.modelSideswipeMid.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
            	ArmorTypes.modelSideswipeMid.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST);
            	ArmorTypes.modelSideswipeMid.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
            	ArmorTypes.modelSideswipeMid.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
            	ArmorTypes.modelSideswipeMid.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.FEET);
            	ArmorTypes.modelSideswipeMid.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.FEET);


            	ArmorTypes.modelSideswipeMid.isSneak = _default.isSneak;
            	ArmorTypes.modelSideswipeMid.isRiding = _default.isRiding;
            	ArmorTypes.modelSideswipeMid.isChild = _default.isChild;
            	ArmorTypes.modelSideswipeMid.rightArmPose = _default.rightArmPose;
            	ArmorTypes.modelSideswipeMid.leftArmPose = _default.leftArmPose;


                return ArmorTypes.modelSideswipeMid;
            }
        }
        return null;
    }


}
