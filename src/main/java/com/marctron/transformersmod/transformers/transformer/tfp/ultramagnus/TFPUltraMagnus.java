package com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus;

import java.util.List;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.network.packets.motormaster.PacketMotormaster;
import com.marctron.transformersmod.network.packets.tf.TFNetworkManager;
import com.marctron.transformersmod.network.packets.tfp.magnus.PacketTFPMagnus;
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

public class TFPUltraMagnus extends ItemArmorTransformer {

	private long lastPress = 0;
	private long cooldownTime = 100; // 2000 milliseconds	
	private long time;
	
	private long lastPressTransform = 0;
	private long cooldownTimeTransform = 3000; // 2000 milliseconds	
	private long timeTransform;

    public TFPUltraMagnus(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
    	
        super(materialIn, renderIndexIn, equipmentSlotIn);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tabAutobot);
        setMaxStackSize(1);
       

    }

    public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
        list.add(TextFormatting.GRAY + I18n.format(TextFormatting.BOLD + I18n.format("TFP")));
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
    	Altmode(false);
    	player.eyeHeight=2.25f;
//			((EntityLivingBase) player).addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0 ));
//        player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0, bFull3D, false));
        super.onArmorTick(world, player, itemStack);
        
      
        if (world.isRemote)
		{
			

			
			
			
			long timeTransform = System.currentTimeMillis();	
			if (timeTransform > lastPressTransform + cooldownTimeTransform) {
	
			if (ClientProxy.ROBOT_MODE.isKeyDown()) {
	 			
				
		
				
				{
					TFNetworkManager.networkWrapper.sendToServer(new PacketTFPMagnus());
					long time = System.currentTimeMillis();	
					if (time > lastPress + cooldownTime) {

				        if (itemStack.getItem() == RegistryHandler.ModItems.ULTRA_MAGNUS_BOOTS) {
				            if (world.isRemote) {
				            	player.playSound(SoundsHandler.TFPTRANSFORM, 0.8F, 1.0F);	
				            }
				        }
							
//							System.out.println("ouch");
				    	lastPress = time;
				    } 
				}
				
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


            	ArmorTypes.modelTFPMagnus.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
                ArmorTypes.modelTFPMagnus.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
                ArmorTypes.modelTFPMagnus.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
                ArmorTypes.modelTFPMagnus.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                ArmorTypes.modelTFPMagnus.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                ArmorTypes.modelTFPMagnus.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
                ArmorTypes.modelTFPMagnus.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

                ArmorTypes.modelTFPMagnus.isSneak = _default.isSneak;
                ArmorTypes.modelTFPMagnus.isRiding = _default.isRiding;
                ArmorTypes.modelTFPMagnus.isChild = _default.isChild;
                ArmorTypes.modelTFPMagnus.rightArmPose = _default.rightArmPose;
                ArmorTypes.modelTFPMagnus.leftArmPose = _default.leftArmPose;

                return ArmorTypes.modelTFPMagnus;
            }
        }

        return null;
    }
}
	
	


	


