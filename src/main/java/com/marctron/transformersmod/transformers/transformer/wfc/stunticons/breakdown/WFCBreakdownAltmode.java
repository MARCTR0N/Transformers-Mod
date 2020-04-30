package com.marctron.transformersmod.transformers.transformer.wfc.stunticons.breakdown;

import java.util.List;

import javax.annotation.Nullable;

import com.marctron.transformersmod.network.packets.breakdown.PacketBreakdown;
import com.marctron.transformersmod.network.packets.tf.TFNetworkManager;
import com.marctron.transformersmod.proxy.ClientProxy;
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
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WFCBreakdownAltmode extends ItemArmorTransformer{

	private long lastPress = 0;
	private long cooldownTime = 100; // 2000 milliseconds	
	private long time;
	
	private long lastPressTransform = 0;
	private long cooldownTimeTransform = 3000; // 2000 milliseconds	
	private long timeTransform;
	
	public WFCBreakdownAltmode(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(null);
		setMaxStackSize(1);
		
	}
	
	
	public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
		list.add(TextFormatting.GRAY + I18n.format(TextFormatting.BOLD + I18n.format("WFC")));
	}
	
	@Override
	public final void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		Altmode(true);
		
			
			
			
			
			if (player.inventory.getCurrentItem().isEmpty())
			{
				
			
				if (Minecraft.getMinecraft().gameSettings.keyBindUseItem.isKeyDown()){
				Vec3d aim = player.getLookVec();

//				world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX+0.3F , player.posY + 0.15, player.posZ , 0.6D, 0.D, 0.85D);
//				world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX-0.3F , player.posY + 0.15, player.posZ , 0.6D, 0.D, 0.85D);
				
				Vec3d lookVec = player.getLookVec();
//				for(float i = blahblahblah)
//				{
//				    world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX,  player.posY + 0.2, player.posZ , 0.8D, 0.D, 0.99D);
//				    world.spawnParticle(EnumParticleTypes.WATER_DROP, player.posX,  player.posY + 0.2, player.posZ , 0.5D * -aim.x, 0D, 0.5D *-aim.z);
//				    world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX,  player.posY + 0.2, player.posZ , 0.8D, 0.D, 0.99D);
//				}
					
				if (player.onGround){
					player.motionX=player.motionX * 1.01F;
					player.motionZ=player.motionZ * 1.01F;
					player.moveRelative(0F, 0F, 0.03F, 3F);
//					world.spawnParticle(EnumParticleTypes.REDSTONE, player.posX, player.posY + 0.15, player.posZ, 0.6D, 0.D, 0.85D);
//					world.spawnParticle(EnumParticleTypes.BLOCK_CRACK, player.posX, player.posY + 0.15, player.posZ, 0.0D, 0.D, 0.D);
				} 
			
				}
			
}			if (world.isRemote)
			{
				

				
				
				
				long timeTransform = System.currentTimeMillis();	
				if (timeTransform > lastPressTransform + cooldownTimeTransform) {
		
				if (ClientProxy.ROBOT_MODE.isKeyDown()) {
		 			
					
			
					
					{
						TFNetworkManager.networkWrapper.sendToServer(new PacketBreakdown());
						long time = System.currentTimeMillis();	
						if (time > lastPress + cooldownTime) {
							
							 if (itemStack.getItem() == RegistryHandler.ModItems.BREAKDOWN_BOOTS_ALTMODE) {
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
					
					
					
				
					
			
				BreakdownArmorTypes.modelBreakdownAltmode_A.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				BreakdownArmorTypes.modelBreakdownAltmode_A.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				BreakdownArmorTypes.modelBreakdownAltmode_A.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
				BreakdownArmorTypes.modelBreakdownAltmode_A.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				BreakdownArmorTypes.modelBreakdownAltmode_A.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				BreakdownArmorTypes.modelBreakdownAltmode_A.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);
				BreakdownArmorTypes.modelBreakdownAltmode_A.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS);

				BreakdownArmorTypes.modelBreakdownAltmode_A.isSneak = _default.isSneak;
				BreakdownArmorTypes.modelBreakdownAltmode_A.isRiding = _default.isRiding;
				BreakdownArmorTypes.modelBreakdownAltmode_A.isChild = _default.isChild;
				BreakdownArmorTypes.modelBreakdownAltmode_A.rightArmPose = _default.rightArmPose;
				BreakdownArmorTypes.modelBreakdownAltmode_A.leftArmPose = _default.leftArmPose;

					return BreakdownArmorTypes.modelBreakdownAltmode_A;
				}
			}
			
			return null;
		}

}
