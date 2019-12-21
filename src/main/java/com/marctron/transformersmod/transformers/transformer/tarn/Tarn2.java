package com.marctron.transformersmod.transformers.transformer.tarn;

import com.marctron.transformersmod.Main;

import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.models.tarn.ModelTarnLegs;
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
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class Tarn2 extends ItemArmorTransformer {

    

    public Tarn2(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
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
//        player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0, bFull3D, false));
        super.onArmorTick(world, player, itemStack);
        
      
        if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.TARN_HELMET&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() ==RegistryHandler.ModItems.TARN_CHESTPLATE&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() ==  RegistryHandler.ModItems.TARN_LEGGINGS&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() ==  RegistryHandler.ModItems.TARN_BOOTS) {

       
            if (world.isRemote) {
                if (ClientProxy.ALT_MODE.isKeyDown()) {
                    player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.TARN_MID1_HELMET));
                    //player.inventory.armorInventory.set(3, new ItemStack(ModItems.VEHICON_ALTMODE_HELMET));
                    Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMTWO, 0.3F, 1.9F);
                }
            }
        


        
            if (world.isRemote) {
                if (ClientProxy.ALT_MODE.isKeyDown()) {
                    player.inventory.armorInventory.set(1, new ItemStack(Items.AIR));
                    //player.inventory.armorInventory.set(1, new ItemStack(ModItems.VEHICON_ALTMODE_LEGGINGS));

                }
            }
        
        
            if (world.isRemote) {
                if (ClientProxy.ALT_MODE.isKeyDown()) {
                    player.inventory.armorInventory.set(0, new ItemStack(Items.AIR));
                    //player.inventory.armorInventory.set(0, new ItemStack(ModItems.VEHICON_ALTMODE_BOOTS));

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


            	ArmorTypes.modelTarnLegs.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
                ArmorTypes.modelTarnLegs.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
                ArmorTypes.modelTarnLegs.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
                ArmorTypes.modelTarnLegs.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                ArmorTypes.modelTarnLegs.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                ArmorTypes.modelTarnLegs.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
                ArmorTypes.modelTarnLegs.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

                ArmorTypes.modelTarnLegs.isSneak = _default.isSneak;
                ArmorTypes.modelTarnLegs.isRiding = _default.isRiding;
                ArmorTypes.modelTarnLegs.isChild = _default.isChild;
                ArmorTypes.modelTarnLegs.rightArmPose = _default.rightArmPose;
                ArmorTypes.modelTarnLegs.leftArmPose = _default.leftArmPose;

                return ArmorTypes.modelTarnLegs;
            }
        }

        return null;
    }
}
	
	


	


