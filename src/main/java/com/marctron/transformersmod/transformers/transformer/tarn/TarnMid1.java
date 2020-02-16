package com.marctron.transformersmod.transformers.transformer.tarn;

import com.marctron.transformersmod.Main;

import com.marctron.transformersmod.transformers.models.tarn.ModelTarn2Mid1;
import com.marctron.transformersmod.transformers.transformer.ArmorTypes;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;
import com.marctron.transformersmod.util.handlers.RegistryHandler;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TarnMid1 extends ItemArmorTransformer {

    

    public TarnMid1(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
       
        setRegistryName(name);
        setCreativeTab(null);
        setMaxStackSize(1);
       

    }

    public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
        list.add(TextFormatting.GRAY + I18n.format(TextFormatting.BOLD + I18n.format("IDW")));
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0, bFull3D, false));
        super.onArmorTick(world, player, itemStack);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {


//                if (itemStack.getItem() == RegistryHandler.ModItems.TARN_MID1_HELMET) {
//                    if (world.isRemote) {
//
                        player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.TARN_MID2_HELMET));
                        player.inventory.armorInventory.set(2, new ItemStack(Items.AIR));
                        player.inventory.armorInventory.set(1, new ItemStack(Items.AIR));
                        player.inventory.armorInventory.set(0, new ItemStack(Items.AIR));
//                        //player.inventory.armorInventory.set(3, new ItemStack(ModItems.VEHICON_ALTMODE_HELMET));
//
//
//                    }
//                }
//
//                if (itemStack.getItem() == RegistryHandler.ModItems.TARN_MID1_CHESTPLATE) {
//                    if (world.isRemote) {
//
//                        player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.TARN_MID2_CHESTPLATE));
//                        //player.inventory.armorInventory.set(3, new ItemStack(ModItems.VEHICON_ALTMODE_HELMET));
//
//
//                    }
//                }
//
//
//                if (itemStack.getItem() == RegistryHandler.ModItems.TARN_MID1_LEGGINGS) {
//                    if (world.isRemote) {
//
//                        player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.TARN_MID2_LEGGINGS));
//                        //player.inventory.armorInventory.set(1, new ItemStack(ModItems.VEHICON_ALTMODE_LEGGINGS));
//
//
//                    }
//                }
//                if (itemStack.getItem() == RegistryHandler.ModItems.TARN_MID1_BOOTS) {
//                    if (world.isRemote) {
//
//                        player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.TARN_MID2_BOOTS));
//                        //player.inventory.armorInventory.set(0, new ItemStack(ModItems.VEHICON_ALTMODE_BOOTS));
//
//
//                    }
//                }
            }

        }, 80);
    }

    @SideOnly(Side.CLIENT)
    @Nullable
    @Override
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {

        if (!itemStack.isEmpty()) {


            if (itemStack.getItem() instanceof ItemArmor) {


            	ArmorTypes.modelTarn2Mid1.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
            	ArmorTypes.modelTarn2Mid1.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
            	ArmorTypes.modelTarn2Mid1.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
            	ArmorTypes.modelTarn2Mid1.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
            	ArmorTypes.modelTarn2Mid1.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
            	ArmorTypes.modelTarn2Mid1.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
            	ArmorTypes.modelTarn2Mid1.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

            	ArmorTypes.modelTarn2Mid1.isSneak = _default.isSneak;
            	ArmorTypes.modelTarn2Mid1.isRiding = _default.isRiding;
            	ArmorTypes.modelTarn2Mid1.isChild = _default.isChild;
            	ArmorTypes.modelTarn2Mid1.rightArmPose = _default.rightArmPose;
            	ArmorTypes.modelTarn2Mid1.leftArmPose = _default.leftArmPose;

                return ArmorTypes.modelTarn2Mid1;
            }
        }

        return null;
    }
}
	
	


	


