package com.marctron.transformersmod.transformers.transformer.g1.optimusprime;

import java.util.List;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.network.packets.breakdown.PacketBreakdown;
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

public class G1OptimusPrime extends ItemArmorTransformer{

	private long lastPress = 0;
	private long cooldownTime = 100; // 2000 milliseconds	
	private long time;
	
	private long lastPressTransform = 0;
	private long cooldownTimeTransform = 3000; // 2000 milliseconds	
	private long timeTransform;
	
	public G1OptimusPrime(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabAutobot);
		setMaxStackSize(1);
		
	}
	
	
	public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
		list.add(TextFormatting.GRAY + I18n.format(TextFormatting.BOLD + I18n.format("G1")));
	}
	
	@Override
	public final void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
			if(player.onGround){
					player.motionX=player.motionX * 1.04F;
					player.motionZ=player.motionZ * 1.04F;
//					Altmode(false);
				
		}
//			player.eyeHeight= 1.55F;
			if (world.isRemote)
			{
				

				
				
				
				long timeTransform = System.currentTimeMillis();	
				if (timeTransform > lastPressTransform + cooldownTimeTransform) {
		
				if (ClientProxy.ROBOT_MODE.isKeyDown()) {
		 			
					
			
					
					{
						TFNetworkManager.networkWrapper.sendToServer(new PacketBreakdown());
						long time = System.currentTimeMillis();	
						if (time > lastPress + cooldownTime) {
							
							 if (itemStack.getItem() == RegistryHandler.ModItems.BREAKDOWN_BOOTS) {
						            if (world.isRemote) {
						            	player.playSound(SoundsHandler.TFPTRANSFORM, 01F, 1F);	
						            }
						        }
//								player.playSound(SoundsHandler.WFCPRIMEVEHICLE, 0.8F, 1.0F);	
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
				ArmorTypes.modelG1OptimusPrime.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				ArmorTypes.modelG1OptimusPrime.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				ArmorTypes.modelG1OptimusPrime.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
				ArmorTypes.modelG1OptimusPrime.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				ArmorTypes.modelG1OptimusPrime.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				ArmorTypes.modelG1OptimusPrime.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
				ArmorTypes.modelG1OptimusPrime.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

				ArmorTypes.modelG1OptimusPrime.isSneak = _default.isSneak;
				ArmorTypes.modelG1OptimusPrime.isRiding = _default.isRiding;
				ArmorTypes.modelG1OptimusPrime.isChild = _default.isChild;
				ArmorTypes.modelG1OptimusPrime.rightArmPose = _default.rightArmPose;
				ArmorTypes.modelG1OptimusPrime.leftArmPose = _default.leftArmPose;

					return ArmorTypes.modelG1OptimusPrime;
				}
			}
			
			return null;
		}

}
