package com.marctron.transformersmod.init;

import java.util.ArrayList;
import java.util.List;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.items.ArmorModel;
import com.marctron.transformersmod.items.ArmorModel2;
import com.marctron.transformersmod.items.ItemBase;
import com.marctron.transformersmod.items.ItemCustomFood;
import com.marctron.transformersmod.util.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems 
{

	
	
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	//Items
	public static final Item ENERGON_SHARD = new ItemBase("energon_shard");
	public static final Item MUG = new ItemBase("mug");
	public static final Item ENERGON_MUG = new ItemCustomFood("energon_mug", 4, false);
	public static final Item TRANSFORMIUM = new ItemBase("transformium");
	//Armor
	public static final ArmorMaterial CUSTOM_MODEL_MATERIAL = EnumHelper.addArmorMaterial("custom_model", Reference.MOD_ID + ":custom_model", 20, new int[] {7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);
	//Vehicon
	public static final Item CUSTOM_HELMET = new ArmorModel("custom_helmet", CUSTOM_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD);
	public static final Item CUSTOM_CHESTPLATE = new ArmorModel("custom_chestplate", CUSTOM_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST);
	public static final Item CUSTOM_LEGGINGS = new ArmorModel("custom_leggings", CUSTOM_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS);
	public static final Item CUSTOM_BOOTS = new ArmorModel("custom_boots", CUSTOM_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET);
	
	public static final ArmorMaterial TARN_MODEL_MATERIAL = EnumHelper.addArmorMaterial("tarn_model", Reference.MOD_ID + ":tarn_model", 20, new int[] {7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);
	//Tarn
	public static final Item TARN_HELMET = new ArmorModel2("tarn_helmet", TARN_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD);
	public static final Item TARN_CHESTPLATE = new ArmorModel2("tarn_chestplate", TARN_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST);
	public static final Item TARN_LEGGINGS = new ArmorModel2("tarn_leggings", TARN_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS);
	public static final Item TARN_BOOTS = new ArmorModel2("tarn_boots", TARN_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET);
	
}
