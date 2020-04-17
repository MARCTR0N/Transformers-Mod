package com.marctron.transformersmod.transformers.transformer.wfc.stunticons.motormaster;




import java.util.List;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.network.packets.motormaster.PacketMotormaster;
import com.marctron.transformersmod.network.packets.movieop.PacketMovieOptimusPrime;
import com.marctron.transformersmod.network.packets.tf.TFNetworkManager;
import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.transformers.transformer.ArmorTypes;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;
import com.marctron.transformersmod.util.handlers.RegistryHandler;
import com.marctron.transformersmod.util.handlers.SoundsHandler;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Motormaster extends ItemArmorTransformer{
	
	private long lastPress = 0;
	private long cooldownTime = 100; // 2000 milliseconds	
	private long time;
	
	private long lastPressTransform = 0;
	private long cooldownTimeTransform = 3000; // 2000 milliseconds	
	private long timeTransform;
	
	public Motormaster(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabDecepticon);
		setMaxStackSize(1);
		
	}
	
	
	public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
		list.add(TextFormatting.GRAY + I18n.format(TextFormatting.BOLD + I18n.format("WFC")));
	}
	
	@Override
	public final void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
			if(player.onGround){
					player.motionX=player.motionX * 1.06F;
					player.motionZ=player.motionZ * 1.06F;
					Altmode(false);
				
		}
			if (world.isRemote)
			{
				

				
				
				
				long timeTransform = System.currentTimeMillis();	
				if (timeTransform > lastPressTransform + cooldownTimeTransform) {
		
				if (ClientProxy.ROBOT_MODE.isKeyDown()) {
		 			
					
			
					
					{
						TFNetworkManager.networkWrapper.sendToServer(new PacketMotormaster());
						long time = System.currentTimeMillis();	
						if (time > lastPress + cooldownTime) {
							 if (itemStack.getItem() == RegistryHandler.ModItems.MOTORMASTER_BOOTS) {
						            if (world.isRemote) {
						            	player.playSound(SoundsHandler.WFCPRIMEROBOT, 2F, 1F);	
						            }
						        }
//								player.playSound(SoundsHandler.TFPTRANSFORM, 0.5F, 1.0F);
//								player.playSound(SoundsHandler.WFCPRIMEROBOT, 0.8F, 1.0F);	
//								System.out.println("ouch");
					    	lastPress = time;
					    } 
					}
					
				}
				}
			}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public final ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
	
		if(!itemStack.isEmpty())
		{
			
			
			if(itemStack.getItem() instanceof ItemArmor) 
				{
					
					
					
				
					
			
				ArmorTypes.modelMotormaster.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				ArmorTypes.modelMotormaster.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				ArmorTypes.modelMotormaster.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
				ArmorTypes.modelMotormaster.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				ArmorTypes.modelMotormaster.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				ArmorTypes.modelMotormaster.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
				ArmorTypes.modelMotormaster.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

				ArmorTypes.modelMotormaster.isSneak = _default.isSneak;
				ArmorTypes.modelMotormaster.isRiding = _default.isRiding;
				ArmorTypes.modelMotormaster.isChild = _default.isChild;
				ArmorTypes.modelMotormaster.rightArmPose = _default.rightArmPose;
				ArmorTypes.modelMotormaster.leftArmPose = _default.leftArmPose;

					return ArmorTypes.modelMotormaster;
				}
			}
			
			return null;
		}

}
