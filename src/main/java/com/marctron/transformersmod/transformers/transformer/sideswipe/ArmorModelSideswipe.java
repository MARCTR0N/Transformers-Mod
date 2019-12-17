package com.marctron.transformersmod.transformers.transformer.sideswipe;

import com.marctron.transformersmod.Main;

import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.models.sideswipe.SideswipeModel;
import com.marctron.transformersmod.transformers.renderers.RenderArmor;
import com.marctron.transformersmod.transformers.transformer.ArmorTypes;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;
import com.marctron.transformersmod.util.handlers.RegistryHandler;
import com.marctron.transformersmod.util.handlers.SoundsHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderPlayer;
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

public class ArmorModelSideswipe extends ItemArmorTransformer {

    public ArmorModelSideswipe(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tabAutobot);
        setMaxStackSize(1);
    }

    public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
        list.add(TextFormatting.GRAY + I18n.format(TextFormatting.BOLD + I18n.format("G1")));
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


        player.eyeHeight = 1.65F;

        if (itemStack.getItem() == RegistryHandler.ModItems.SIDESWIPE_HELMET) {
            if (world.isRemote) {
                if (ClientProxy.ALT_MODE.isKeyDown()) {
                    //player.inventory.armorInventory.set(3, new ItemStack(ModItems.TARN_HELMET));
                    player.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.SIDESWIPE_MID_HELMET));
                    Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMTWO, 0.3F, 1.85F);
                    //player.playSound(SoundsHandler.TRANSFORMONE, 1F, 1F);

                }
            }
        }
        if (itemStack.getItem() == RegistryHandler.ModItems.SIDESWIPE_CHESTPLATE) {
            if (world.isRemote) {
                if (ClientProxy.ALT_MODE.isKeyDown()) {
                    player.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.SIDESWIPE_MID_CHESTPLATE));
                    //player.inventory.armorInventory.set(2, new ItemStack(ModItems.VEHICON_ALTMODE_CHESTPLATE));

                }
            }
        }
        if (itemStack.getItem() == RegistryHandler.ModItems.SIDESWIPE_LEGGINGS) {
            if (world.isRemote) {
                if (ClientProxy.ALT_MODE.isKeyDown()) {
                    player.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.SIDESWIPE_MID_LEGGINGS));
                    //player.inventory.armorInventory.set(1, new ItemStack(ModItems.VEHICON_ALTMODE_LEGGINGS));

                }
            }
        }
        if (itemStack.getItem() == RegistryHandler.ModItems.SIDESWIPE_BOOTS) {
            if (world.isRemote) {
                if (ClientProxy.ALT_MODE.isKeyDown()) {
                    player.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.SIDESWIPE_MID_BOOTS));
                    //player.inventory.armorInventory.set(0, new ItemStack(ModItems.VEHICON_ALTMODE_BOOTS));

                }
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {

        if (!itemStack.isEmpty()) {


            if (itemStack.getItem() instanceof ItemArmor) {


            	ArmorTypes.modelSideswipe.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
            	ArmorTypes.modelSideswipe.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
            	ArmorTypes.modelSideswipe.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST);
            	ArmorTypes.modelSideswipe.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
            	ArmorTypes.modelSideswipe.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
            	ArmorTypes.modelSideswipe.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.FEET);
            	ArmorTypes.modelSideswipe.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.FEET);


            	ArmorTypes.modelSideswipe.isSneak = _default.isSneak;
            	ArmorTypes.modelSideswipe.isRiding = _default.isRiding;
            	ArmorTypes.modelSideswipe.isChild = _default.isChild;
                ArmorTypes.modelSideswipe.rightArmPose = _default.rightArmPose;
                ArmorTypes.modelSideswipe.leftArmPose = _default.leftArmPose;


                return ArmorTypes.modelSideswipe;
            }
        }
        return null;
    }


}
