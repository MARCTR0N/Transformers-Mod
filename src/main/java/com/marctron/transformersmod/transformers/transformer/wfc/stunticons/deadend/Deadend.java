package com.marctron.transformersmod.transformers.transformer.wfc.stunticons.deadend;

import java.util.List;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.network.packets.PacketShootRocket;
import com.marctron.transformersmod.network.packets.tf.TFNetworkManager;
import com.marctron.transformersmod.transformers.models.wfc.stunticons.deadend.ModelDeadendpartB;
import com.marctron.transformersmod.transformers.models.wfc.stunticons.motormaster.ModelMotormasterpartB;
import com.marctron.transformersmod.transformers.transformer.ArmorTypes;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;

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
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Deadend extends ItemArmorTransformer{
	
	private long lastPressAttack = 0;
	private long cooldownTimeAttack = 2000; //milliseconds	
	private long timeAttack;
	
	public Deadend(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabDecepticon);
		setMaxStackSize(1);
		
	}
	
	
	public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
		list.add(TextFormatting.GRAY + I18n.format(TextFormatting.BOLD + I18n.format("WFC")));
	}
	
	
	public void cooldown(EntityPlayer player) {
	    long time = System.currentTimeMillis();
	    if (time > lastPressAttack + cooldownTimeAttack) {
	    	
	    	lastPressAttack = time;
	    } 
	} 
	
	@Override
	public final void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
			if(player.onGround){
					player.motionX=player.motionX * 1.05F;
					player.motionZ=player.motionZ * 1.05F;
		}
			player.eyeHeight= 1.4F;
//			if (Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown()){
//				ModelDeadendpartB.attackTimer = 10;
//			}
			
			
			 if (ModelDeadendpartB.attackTimer > 0)
		        {
		            --ModelDeadendpartB.attackTimer;
		            System.out.println("yeet");
		        }
			 
			 
			 long timeShoot = System.currentTimeMillis();	
				if (timeShoot > lastPressAttack + cooldownTimeAttack) 
				{
				if (Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown())
					
				{
					lastPressAttack = timeAttack;
//					ModelDeadendpartB.attackTimer = 10;
							}	
//						
//				
				}
			 
	}
	
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public final ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
	
		if(!itemStack.isEmpty())
		{
			
			
			if(itemStack.getItem() instanceof ItemArmor) 
				{
					
					
					
				
					
			
				ArmorTypes.modelDeadend.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				ArmorTypes.modelDeadend.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				ArmorTypes.modelDeadend.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
				ArmorTypes.modelDeadend.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				ArmorTypes.modelDeadend.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				ArmorTypes.modelDeadend.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
				ArmorTypes.modelDeadend.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

				ArmorTypes.modelDeadend.isSneak = _default.isSneak;
				ArmorTypes.modelDeadend.isRiding = _default.isRiding;
				ArmorTypes.modelDeadend.isChild = _default.isChild;
				ArmorTypes.modelDeadend.rightArmPose = _default.rightArmPose;
				ArmorTypes.modelDeadend.leftArmPose = _default.leftArmPose;

					return ArmorTypes.modelDeadend;
				}
			}
			
			return null;
		}
	
	

}
