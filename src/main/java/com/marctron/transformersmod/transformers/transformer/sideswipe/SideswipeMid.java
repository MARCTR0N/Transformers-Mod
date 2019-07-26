package com.marctron.transformersmod.transformers.transformer.sideswipe;

import com.marctron.transformersmod.init.ModItems;
import com.marctron.transformersmod.transformers.models.sideswipe.ModelSideswipeMid;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Timer;
import java.util.TimerTask;

public class SideswipeMid extends ItemArmor {

    @SideOnly(Side.CLIENT)
    private static ModelSideswipeMid model = new ModelSideswipeMid();

    public SideswipeMid(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(null);
        setMaxStackSize(1);
        ModItems.ITEMS.add(this);

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


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {


                player.eyeHeight = 1.25F;

                if (itemStack.getItem() == ModItems.SIDESWIPE_MID_HELMET) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(3, new ItemStack(ModItems.SIDESWIPE_MID2_HELMET));
                    }
                }
                if (itemStack.getItem() == ModItems.SIDESWIPE_MID_CHESTPLATE) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(2, new ItemStack(ModItems.SIDESWIPE_MID2_CHESTPLATE));
                    }
                }
                if (itemStack.getItem() == ModItems.SIDESWIPE_MID_LEGGINGS) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(1, new ItemStack(ModItems.SIDESWIPE_MID2_LEGGINGS));
                    }
                }
                if (itemStack.getItem() == ModItems.SIDESWIPE_MID_BOOTS) {
                    if (world.isRemote) {
                        player.inventory.armorInventory.set(0, new ItemStack(ModItems.SIDESWIPE_MID2_BOOTS));
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
