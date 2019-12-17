package com.marctron.transformersmod.transformers.transformer.wfc.stunticons;

import java.util.List;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.transformer.ArmorTypes;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;
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
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BreakdownLeftArm extends ItemArmorTransformer {

    

    public BreakdownLeftArm(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tabDecepticon);
        setMaxStackSize(1);
       

    }

    public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
        list.add(TextFormatting.GRAY + I18n.format(TextFormatting.BOLD + I18n.format("IDW")));
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
//			((EntityLivingBase) player).addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0 ));
        player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0, bFull3D, false));
        super.onArmorTick(world, player, itemStack);
//        
//      
//        
//
//        if (itemStack.getItem() == RegistryHandler.ModItems.TARN_HELMET) {
//            if (world.isRemote) {
//                if (ClientProxy.ALT_MODE.isKeyDown()) {
//                    player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.TARN_MID1_HELMET));
//                    //player.inventory.armorInventory.set(3, new ItemStack(ModItems.VEHICON_ALTMODE_HELMET));
//                    Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMTWO, 0.3F, 1.9F);
//                }
//            }
//        }
//
//
//        if (itemStack.getItem() == RegistryHandler.ModItems.TARN_LEGGINGS) {
//            if (world.isRemote) {
//                if (ClientProxy.ALT_MODE.isKeyDown()) {
//                    player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.TARN_MID1_LEGGINGS));
//                    //player.inventory.armorInventory.set(1, new ItemStack(ModItems.VEHICON_ALTMODE_LEGGINGS));
//
//                }
//            }
//        }
//        if (itemStack.getItem() == RegistryHandler.ModItems.TARN_BOOTS) {
//            if (world.isRemote) {
//                if (ClientProxy.ALT_MODE.isKeyDown()) {
//                    player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.TARN_MID1_BOOTS));
//                    //player.inventory.armorInventory.set(0, new ItemStack(ModItems.VEHICON_ALTMODE_BOOTS));
//
//                }
//            }
//        }
    }

    @SideOnly(Side.CLIENT)
    @Nullable
    @Override
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {

        if (!itemStack.isEmpty()) {


            if (itemStack.getItem() instanceof ItemArmor) {


//            	ArmorTypes.modelBreakdownLeftArm.Left_Arm.showModel = armorSlot == EntityEquipmentSlot.HEAD;
//                ArmorTypes.modelBreakdownLeftArm.Left_Arm.showModel = armorSlot == EntityEquipmentSlot.HEAD;
//                ArmorTypes.modelBreakdownLeftArm.Left_Arm.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
//                ArmorTypes.modelBreakdownLeftArm.Left_Arm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
//                ArmorTypes.modelBreakdownLeftArm.Left_Arm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                ArmorTypes.modelBreakdownLeftArm.Left_Arm.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
                ArmorTypes.modelBreakdownLeftArm.Left_Arm.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

                ArmorTypes.modelBreakdownLeftArm.isSneak = _default.isSneak;
                ArmorTypes.modelBreakdownLeftArm.isRiding = _default.isRiding;
                ArmorTypes.modelBreakdownLeftArm.isChild = _default.isChild;
                ArmorTypes.modelBreakdownLeftArm.rightArmPose = _default.rightArmPose;
                ArmorTypes.modelBreakdownLeftArm.leftArmPose = _default.leftArmPose;

                return ArmorTypes.modelBreakdownLeftArm;
            }
        }

        return null;
    }
}
	