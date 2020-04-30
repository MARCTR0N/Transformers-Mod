package com.marctron.transformersmod.transformers.transformer.wfc.stunticons.breakdown;

import java.util.List;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.network.packets.breakdown.PacketBreakdown;
import com.marctron.transformersmod.network.packets.tf.TFNetworkManager;
import com.marctron.transformersmod.proxy.ClientProxy;
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
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WFCBreakdown extends ItemArmorTransformer{

	private long lastPress = 0;
	private long cooldownTime = 100; // 2000 milliseconds	
	private long time;
	
	private long lastPressTransform = 0;
	private long cooldownTimeTransform = 3000; // 2000 milliseconds	
	private long timeTransform;
	
	public WFCBreakdown(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
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
					
					
					
				
					
			
				BreakdownArmorTypes.modelBreakdown.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				BreakdownArmorTypes.modelBreakdown.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				BreakdownArmorTypes.modelBreakdown.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
				BreakdownArmorTypes.modelBreakdown.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				BreakdownArmorTypes.modelBreakdown.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				BreakdownArmorTypes.modelBreakdown.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
				BreakdownArmorTypes.modelBreakdown.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

				BreakdownArmorTypes.modelBreakdown.isSneak = _default.isSneak;
				BreakdownArmorTypes.modelBreakdown.isRiding = _default.isRiding;
				BreakdownArmorTypes.modelBreakdown.isChild = _default.isChild;
				BreakdownArmorTypes.modelBreakdown.rightArmPose = _default.rightArmPose;
				BreakdownArmorTypes.modelBreakdown.leftArmPose = _default.leftArmPose;

					return BreakdownArmorTypes.modelBreakdown;
				}
			}
			
			return null;
		}

}
