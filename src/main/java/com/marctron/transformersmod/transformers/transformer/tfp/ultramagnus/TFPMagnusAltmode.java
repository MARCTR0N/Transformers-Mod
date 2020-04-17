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
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TFPMagnusAltmode extends ItemArmorTransformer{
	
	private long lastPress = 0;
	private long cooldownTime = 100; // 2000 milliseconds	
	private long time;
	
	private long lastPressTransform = 0;
	private long cooldownTimeTransform = 3000; // 2000 milliseconds	
	private long timeTransform;
	
	public TFPMagnusAltmode(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(null);
		setMaxStackSize(1);
		
	}
	
	
	public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
		list.add(TextFormatting.GRAY + I18n.format(TextFormatting.BOLD + I18n.format("TFP")));
	}
	
	@Override
	public final void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		player.eyeHeight=0.8f;
			if(player.onGround){
					player.motionX=player.motionX * 1.01F;
					player.motionZ=player.motionZ * 1.01F;
					Altmode(true);
					
					if (player.inventory.getCurrentItem().isEmpty())
					{
						
					
						if (Minecraft.getMinecraft().gameSettings.keyBindUseItem.isKeyDown()){
						Vec3d aim = player.getLookVec();

							
						if (player.onGround){
							player.moveRelative(0F, 0F, 0.03F, 3F);
//							world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX, player.posY + 0.15, player.posZ, 0.6D, 0.D, 0.85D);
//							world.spawnParticle(EnumParticleTypes.BLOCK_DUST, player.posX, player.posY + 0.15, player.posZ, 0.0D, 0.D, 0.D);
						} 
					
						}
					}
		}
			if (world.isRemote)
			{
				

				
				
				
				long timeTransform = System.currentTimeMillis();	
				if (timeTransform > lastPressTransform + cooldownTimeTransform) {
		
				if (ClientProxy.ROBOT_MODE.isKeyDown()) {
		 			
					
			
					
					{
						TFNetworkManager.networkWrapper.sendToServer(new PacketTFPMagnus());
						long time = System.currentTimeMillis();	
						if (time > lastPress + cooldownTime) {
							
							 if (itemStack.getItem() == RegistryHandler.ModItems.ULTRA_MAGNUS_BOOTS_ALTMODE) {
						            if (world.isRemote) {
						            	player.playSound(SoundsHandler.TFPTRANSFORM, 1F, 1F);	
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
					
					
					
				
					
			
				TFPMagnusArmorTypes.modelTFPUltraMagnusAltmode.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				TFPMagnusArmorTypes.modelTFPUltraMagnusAltmode.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				TFPMagnusArmorTypes.modelTFPUltraMagnusAltmode.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
				TFPMagnusArmorTypes.modelTFPUltraMagnusAltmode.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				TFPMagnusArmorTypes.modelTFPUltraMagnusAltmode.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				TFPMagnusArmorTypes.modelTFPUltraMagnusAltmode.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
				TFPMagnusArmorTypes.modelTFPUltraMagnusAltmode.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

				TFPMagnusArmorTypes.modelTFPUltraMagnusAltmode.isSneak = _default.isSneak;
				TFPMagnusArmorTypes.modelTFPUltraMagnusAltmode.isRiding = _default.isRiding;
				TFPMagnusArmorTypes.modelTFPUltraMagnusAltmode.isChild = _default.isChild;
				TFPMagnusArmorTypes.modelTFPUltraMagnusAltmode.rightArmPose = _default.rightArmPose;
				TFPMagnusArmorTypes.modelTFPUltraMagnusAltmode.leftArmPose = _default.leftArmPose;

					return TFPMagnusArmorTypes.modelTFPUltraMagnusAltmode;
				}
			}
			
			return null;
		}

}
