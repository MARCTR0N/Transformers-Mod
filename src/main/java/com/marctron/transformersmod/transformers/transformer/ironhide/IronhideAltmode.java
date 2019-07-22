//package com.marctron.transformersmod.transformers.transformer.ironhide;
//
//import com.marctron.transformersmod.Main;
//import com.marctron.transformersmod.init.ModItems;
//import com.marctron.transformersmod.proxy.ClientProxy;
//import com.marctron.transformersmod.transformers.models.ironhide.G1IronhideAltmode;
//import com.marctron.transformersmod.transformers.models.sideswipe.ModelSideswipeAltmode;
//import com.marctron.transformersmod.util.handlers.SoundsHandler;
//import com.marctron.transformersmod.util.interfaces.IHasModel;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.model.ModelBiped;
//import net.minecraft.entity.EntityLivingBase;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.init.MobEffects;
//import net.minecraft.inventory.EntityEquipmentSlot;
//import net.minecraft.item.ItemArmor;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.ItemArmor.ArmorMaterial;
//import net.minecraft.potion.PotionEffect;
//import net.minecraft.world.World;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
//public class IronhideAltmode extends ItemArmor implements IHasModel {
//
//	public IronhideAltmode(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
//		super(materialIn, renderIndexIn, equipmentSlotIn);
//		setUnlocalizedName(name);
//		setRegistryName(name);
//		setCreativeTab(null);
//		setMaxStackSize(1);
//		ModItems.ITEMS.add(this);
//		
//	}
//
//		 
//	@Override
//	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
//	{
//			((EntityLivingBase) player).addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 10, 0));
//
//			
//			
//			player.dropItem(true);
//			
//			player.cameraPitch = 0F;
//			player.cameraYaw = 0F;
//			//player.moveRelative(0F, -1F, 0.F, 0F);
//			player.eyeHeight = 0.4F;
//			if (Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown())
//			{
//				//player.setSprinting(true);
//				player.moveRelative(0F, -0.05F, 0.035F, 3F);
//			}
//			
////			if (world.isRemote){ 
////			player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 0.01F, player.getEntityBoundingBox().minZ + 0.6F));
////			player.width = 0F; 
////			player.height = 0F;
////			}
//			
//			
//			
//	   
//		    
//			if (itemStack.getItem() == ModItems.IRONHIDE_ALTMODE_HELMET) {
//				if (world.isRemote) 
//				{
//					if (ClientProxy.ROBOT_MODE.isKeyDown()) 
//					{
//						player.inventory.armorInventory.set(3, new ItemStack(ModItems.IRONHIDE_HELMET));
//						//player.inventory.armorInventory.set(3, new ItemStack(ModItems.VEHICON_ALTMODE_HELMET));
//						Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMONE, 0.3F, 1.9F);	
//					}
//				}
//			} 
//			if (itemStack.getItem() == ModItems.IRONHIDE_ALTMODE_CHESTPLATE) {
//				if (world.isRemote) 
//				{
//					if (ClientProxy.ROBOT_MODE.isKeyDown()) 
//					{
//						player.inventory.armorInventory.set(2, new ItemStack(ModItems.IRONHIDE_CHESTPLATE));
//						//player.inventory.armorInventory.set(2, new ItemStack(ModItems.VEHICON_ALTMODE_CHESTPLATE));
//				
//					}
//				}
//			} 
//			if (itemStack.getItem() == ModItems.IRONHIDE_ALTMODE_LEGGINGS) {
//				if (world.isRemote) 
//				{
//					if (ClientProxy.ROBOT_MODE.isKeyDown()) 
//					{
//						player.inventory.armorInventory.set(1, new ItemStack(ModItems.IRONHIDE_LEGGINGS));
//						//player.inventory.armorInventory.set(1, new ItemStack(ModItems.VEHICON_ALTMODE_LEGGINGS));
//				
//					}
//				}
//			} 
//			if (itemStack.getItem() == ModItems.IRONHIDE_ALTMODE_BOOTS) {
//				if (world.isRemote) 
//				{
//					if (ClientProxy.ROBOT_MODE.isKeyDown()) 
//					{
//						player.inventory.armorInventory.set(0, new ItemStack(ModItems.IRONHIDE_BOOTS));
//						//player.inventory.armorInventory.set(0, new ItemStack(ModItems.VEHICON_ALTMODE_BOOTS));
//				
//					}
//				}
//			} 
//		}
//			
////			if (itemStack.getItem() == ModItems.SIDESWIPE_CHESTPLATE) 
////			{
////				if (world.isRemote) 
////				{
////			
////			player.width = 0.6F; 
////			player.height = 1.5F;
////			player.setEntityBoundingBox(new AxisAlignedBB(player.getEntityBoundingBox().minX, player.getEntityBoundingBox().minY, player.getEntityBoundingBox().minZ, player.getEntityBoundingBox().minX + 0.6F, player.getEntityBoundingBox().minY + 1.5F, player.getEntityBoundingBox().minZ + 0.6F));
////		
////				}
////			} 
//	
//				
//	
//	@Override
//	public void registerModels() 
//	{
//		Main.proxy.registerItemRenderer(this, 0, "inventory");
//	}
//	
//	
//	@SideOnly(Side.CLIENT)
//	private static G1IronhideAltmode model = new G1IronhideAltmode();
//	
//	@Override
//	@SideOnly(Side.CLIENT)
//	public final ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
//	
//		if(!itemStack.isEmpty())
//		{
//			
//			
//			if(itemStack.getItem() instanceof ItemArmor) 
//				{
//					
//					
//					
//					
//			
//					model.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
//					model.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
//					model.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST);
//					model.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
//					model.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
//					model.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.FEET);
//					model.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.FEET);
//							
//			
//					
//					model.isSneak = _default.isSneak;
//					model.isRiding = _default.isRiding;
//					model.isChild = _default.isChild;
//					model.rightArmPose = _default.rightArmPose;
//					model.leftArmPose = _default.leftArmPose;
//					
//					
//
//					
//					
//					return model;
//				}
//		}
//		return null;
//	}
//	
//	
//
//
//	
//
//}
