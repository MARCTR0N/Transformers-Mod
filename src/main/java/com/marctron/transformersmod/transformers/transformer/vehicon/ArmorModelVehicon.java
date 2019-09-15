package com.marctron.transformersmod.transformers.transformer.vehicon;

import com.marctron.transformersmod.Main;

import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.models.AdvancedModelBiped;
import com.marctron.transformersmod.transformers.models.vehicon.ModelCustomArmor;
import com.marctron.transformersmod.transformers.transformer.ArmorTypes;
import com.marctron.transformersmod.util.handlers.RegistryHandler;
import com.marctron.transformersmod.util.handlers.SoundsHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
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
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ArmorModelVehicon extends ItemArmor {

    


    public ArmorModelVehicon(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tabDecepticon);
        setMaxStackSize(1);
        

    }

    public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
        list.add(TextFormatting.GRAY + I18n.format(TextFormatting.BOLD + I18n.format("War for Cybertron")));
    }

    @Override
    public final void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0, bFull3D, false));


        //player.fallDistance = 0;
        //player.capabilities.setPlayerWalkSpeed(0.15F);
        player.eyeHeight = 1.65F;
        //player.width = 0.6F;
        //player.height = 1.8F;
        //player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 1.8F, player.getEntityBoundingBox().minZ + 0.6F));


        if (itemStack.getItem() == RegistryHandler.ModItems.CUSTOM_HELMET) {
            if (world.isRemote) {
                if (ClientProxy.ALT_MODE.isKeyDown()) {
                    player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.VEHICON_MID_HELMET));
                    //player.inventory.armorInventory.set(3, new ItemStack(ModItems.VEHICON_ALTMODE_HELMET));
                    Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMTWO, 0.3F, 1.85F);
                }
            }
        }
        if (itemStack.getItem() == RegistryHandler.ModItems.CUSTOM_CHESTPLATE) {
            if (world.isRemote) {
                if (ClientProxy.ALT_MODE.isKeyDown()) {
                    player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.VEHICON_MID_CHESTPLATE));
                    //player.inventory.armorInventory.set(2, new ItemStack(ModItems.VEHICON_ALTMODE_CHESTPLATE));

                }
            }
        }
        if (itemStack.getItem() == RegistryHandler.ModItems.CUSTOM_LEGGINGS) {
            if (world.isRemote) {
                if (ClientProxy.ALT_MODE.isKeyDown()) {
                    player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.VEHICON_MID_LEGGINGS));
                    //player.inventory.armorInventory.set(1, new ItemStack(ModItems.VEHICON_ALTMODE_LEGGINGS));

                }
            }
        }
        if (itemStack.getItem() == RegistryHandler.ModItems.CUSTOM_BOOTS) {
            if (world.isRemote) {
                if (ClientProxy.ALT_MODE.isKeyDown()) {
                    player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.VEHICON_MID_BOOTS));
                    //player.inventory.armorInventory.set(0, new ItemStack(ModItems.VEHICON_ALTMODE_BOOTS));

                }
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public final AdvancedModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {

        if (!itemStack.isEmpty()) {


            if (itemStack.getItem() instanceof ItemArmor) {


                ArmorTypes.modelCustomArmor.Torso.showModel = armorSlot == EntityEquipmentSlot.HEAD;
//                ArmorTypes.modelCustomArmor.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
                ArmorTypes.modelCustomArmor.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST);
                ArmorTypes.modelCustomArmor.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                ArmorTypes.modelCustomArmor.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                ArmorTypes.modelCustomArmor.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.FEET);
                ArmorTypes.modelCustomArmor.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.FEET);


                ArmorTypes.modelCustomArmor.isSneak = _default.isSneak;
                ArmorTypes.modelCustomArmor.isRiding = _default.isRiding;
                ArmorTypes.modelCustomArmor.isChild = _default.isChild;
                ArmorTypes.modelCustomArmor.rightArmPose = _default.rightArmPose;
                ArmorTypes.modelCustomArmor.leftArmPose = _default.leftArmPose;


                return ArmorTypes.modelCustomArmor;
            }
        }
        return null;
    }


}
