//package com.marctron.transformersmod.transformers.transformer.ironhide;
//
//import java.util.List;
//
//import javax.annotation.Nullable;
//
//import com.marctron.transformersmod.Main;
//import com.marctron.transformersmod.init.ModItems;
//import com.marctron.transformersmod.proxy.ClientProxy;
//import com.marctron.transformersmod.transformers.models.ironhide.G1Ironhide;
//import com.marctron.transformersmod.transformers.models.sideswipe.SideswipeModel;
//import com.marctron.transformersmod.util.handlers.SoundsHandler;
//import com.marctron.transformersmod.util.interfaces.IHasModel;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.model.ModelBiped;
//import net.minecraft.client.util.ITooltipFlag;
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
//public class Ironhide extends ItemArmor implements IHasModel {
//
//	public Ironhide(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
//		super(materialIn, renderIndexIn, equipmentSlotIn);
//		setUnlocalizedName(name);
//		setRegistryName(name);
//		setCreativeTab(Main.tabAutobot);
//		setMaxStackSize(1);
//		ModItems.ITEMS.add(this);
//		
//	}
//
//	public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
//		list.add("§7§lG1");
//	}
//	
//	
//	@Override
//	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
//	{
//			((EntityLivingBase) player).addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 20, 0));
//			
//	
//			player.eyeHeight = 1.65F;
//			
//			if (itemStack.getItem() == ModItems.IRONHIDE_HELMET) {
//				if (world.isRemote) 
//				{
//					if (ClientProxy.MY_KEYBINDING.isKeyDown()) 
//					{
//						//player.inventory.armorInventory.set(3, new ItemStack(ModItems.TARN_HELMET));
//						player.inventory.armorInventory.set(3, new ItemStack(ModItems.IRONHIDE_ALTMODE_HELMET));
//						Minecraft.getMinecraft().player.playSound(SoundsHandler.TRANSFORMTWO, 0.3F, 1.85F);
//						//player.playSound(SoundsHandler.TRANSFORMONE, 1F, 1F);
//				
//					}
//				}
//			} 
//			if (itemStack.getItem() == ModItems.IRONHIDE_CHESTPLATE) {
//				if (world.isRemote) 
//				{
//					if (ClientProxy.MY_KEYBINDING.isKeyDown()) 
//					{
//						player.inventory.armorInventory.set(2, new ItemStack(ModItems.IRONHIDE_ALTMODE_CHESTPLATE));
//						//player.inventory.armorInventory.set(2, new ItemStack(ModItems.VEHICON_ALTMODE_CHESTPLATE));
//				
//					}
//				}
//			} 
//			if (itemStack.getItem() == ModItems.IRONHIDE_LEGGINGS) {
//				if (world.isRemote) 
//				{
//					if (ClientProxy.MY_KEYBINDING.isKeyDown()) 
//					{
//						player.inventory.armorInventory.set(1, new ItemStack(ModItems.IRONHIDE_ALTMODE_LEGGINGS));
//						//player.inventory.armorInventory.set(1, new ItemStack(ModItems.VEHICON_ALTMODE_LEGGINGS));
//				
//					}
//				}
//			} 
//			if (itemStack.getItem() == ModItems.IRONHIDE_BOOTS) {
//				if (world.isRemote) 
//				{
//					if (ClientProxy.MY_KEYBINDING.isKeyDown()) 
//					{
//						player.inventory.armorInventory.set(0, new ItemStack(ModItems.IRONHIDE_ALTMODE_BOOTS));
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
//	private static G1Ironhide model = new G1Ironhide();
//
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
