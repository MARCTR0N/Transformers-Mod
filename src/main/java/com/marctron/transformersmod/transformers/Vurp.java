package com.marctron.transformersmod.transformers;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.models.sideswipe.ModelSideswipeAltmode;
import com.marctron.transformersmod.transformers.transformer.ArmorTypes;
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


	
    

    public Vurp(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tabDecepticon);
        setMaxStackSize(1);
        
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0, bFull3D, false));
    }


    @SideOnly(Side.CLIENT)
    @Nullable
    @Override
    public final ModelVurp getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {

        if (!itemStack.isEmpty()) {


            if (itemStack.getItem() instanceof ItemArmor) {


                ArmorTypes.modelVurp.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
                ArmorTypes.modelVurp.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
                ArmorTypes.modelVurp.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST);
                ArmorTypes.modelVurp.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                ArmorTypes.modelVurp.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                ArmorTypes.modelVurp.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.FEET);
                ArmorTypes.modelVurp.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.FEET);


                ArmorTypes.modelVurp.isSneak = _default.isSneak;
                ArmorTypes.modelVurp.isRiding = _default.isRiding;
                ArmorTypes.modelVurp.isChild = _default.isChild;
                ArmorTypes.modelVurp.rightArmPose = _default.rightArmPose;
                ArmorTypes.modelVurp.leftArmPose = _default.leftArmPose;


                return ArmorTypes.modelVurp;
            }
        }
        return null;
    }

}