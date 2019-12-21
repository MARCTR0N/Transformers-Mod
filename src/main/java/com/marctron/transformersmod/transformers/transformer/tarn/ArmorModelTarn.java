package com.marctron.transformersmod.transformers.transformer.tarn;

import com.marctron.transformersmod.Main;

import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.models.tarn.TarnChest;
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

public class ArmorModelTarn extends ItemArmorTransformer {

    

    public ArmorModelTarn(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tabDecepticon);
        setMaxStackSize(1);
        

    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
        list.add(TextFormatting.GRAY + I18n.format(TextFormatting.BOLD + I18n.format("IDW")));
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
//        ((EntityLivingBase) player).addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0));
        super.onArmorTick(world, player, itemStack);

        if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.TARN_HELMET&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() ==RegistryHandler.ModItems.TARN_CHESTPLATE&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() ==  RegistryHandler.ModItems.TARN_LEGGINGS&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() ==  RegistryHandler.ModItems.TARN_BOOTS) { 

//        if (itemStack.getItem() == RegistryHandler.ModItems.TARN_CHESTPLATE) 
            if (world.isRemote) {
                if (ClientProxy.ALT_MODE.isKeyDown()) {
                    player.inventory.armorInventory.set(2, new ItemStack(Items.AIR));
                    //player.inventory.armorInventory.set(2, new ItemStack(ModItems.VEHICON_ALTMODE_CHESTPLATE));

                }
            }

        }
    }

    @SideOnly(Side.CLIENT)
    @Nullable
    @Override
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {

        if (!itemStack.isEmpty()) {


            if (itemStack.getItem() instanceof ItemArmor) {


                ArmorTypes.modelTarnChest.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
                ArmorTypes.modelTarnChest.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
                ArmorTypes.modelTarnChest.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
                ArmorTypes.modelTarnChest.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                ArmorTypes.modelTarnChest.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                ArmorTypes.modelTarnChest.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
                ArmorTypes.modelTarnChest.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

                ArmorTypes.modelTarnChest.isSneak = _default.isSneak;
                ArmorTypes.modelTarnChest.isRiding = _default.isRiding;
                ArmorTypes.modelTarnChest.isChild = _default.isChild;
                ArmorTypes.modelTarnChest.rightArmPose = _default.rightArmPose;
                ArmorTypes.modelTarnChest.leftArmPose = _default.leftArmPose;

                return ArmorTypes.modelTarnChest;
            }
        }

        return null;
    }
}
	
	


	


