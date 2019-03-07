package com.marctron.transformersmod.init;

import java.util.ArrayList;
import java.util.List;

import com.marctron.transformersmod.items.ArmorModelAJ;
import com.marctron.transformersmod.items.ArmorModelTarn;
import com.marctron.transformersmod.items.ArmorModelVehicon;
import com.marctron.transformersmod.items.ItemBase;
import com.marctron.transformersmod.items.ItemBasicMeta;
import com.marctron.transformersmod.items.ItemCustomFood;
import com.marctron.transformersmod.items.ModdedBow;
import com.marctron.transformersmod.items.PrimaryAmmo;
import com.marctron.transformersmod.items.gun.AmmoClip;
import com.marctron.transformersmod.items.gun.EMPShotgun;
import com.marctron.transformersmod.items.gun.EnergonBattlePistol;
import com.marctron.transformersmod.items.gun.IShootable;
import com.marctron.transformersmod.items.gun.Scrapper;
import com.marctron.transformersmod.util.Reference;
import com.marctron.transformersmod.items.ItemBase;
import com.marctron.transformersmod.items.*;
import com.marctron.transformersmod.items.gun.*;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBow;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems 
{

	
	
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	//Items
	public static final Item ENERGON_SHARD = new ItemBase("energon_shard");
	public static final Item MUG = new ItemBase("mug");
	public static final Item ENERGON_MUG = new ItemCustomFood("energon_mug", 4, false);
	public static final Item TRANSFORMIUM = new ItemBase("transformium");
	
	//Tools
	public static final ToolMaterial GUN_MATERIAL = EnumHelper.addToolMaterial("gun", 0, 1000, 2.0F, 0, 0);
	
	//Armor
	public static final ArmorMaterial CUSTOM_MODEL_MATERIAL = EnumHelper.addArmorMaterial("custom_model", Reference.MOD_ID + ":custom_model", 20, new int[] {7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);
	
	public static final ArmorMaterial TARN_MODEL_MATERIAL = EnumHelper.addArmorMaterial("tarn_model", Reference.MOD_ID + ":tarn_model", 20, new int[] {7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);
	
	public static final ArmorMaterial AJ_MODEL_MATERIAL = EnumHelper.addArmorMaterial("aj_model", Reference.MOD_ID + ":aj_model", 20, new int[] {7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);
	
	//Vehicon
	public static final Item CUSTOM_HELMET = new ArmorModelVehicon("custom_helmet", CUSTOM_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD);
	public static final Item CUSTOM_CHESTPLATE = new ArmorModelVehicon("custom_chestplate", CUSTOM_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST);
	public static final Item CUSTOM_LEGGINGS = new ArmorModelVehicon("custom_leggings", CUSTOM_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS);
	public static final Item CUSTOM_BOOTS = new ArmorModelVehicon("custom_boots", CUSTOM_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET);
	
	
	//Tarn
	public static final Item TARN_HELMET = new ArmorModelTarn("tarn_helmet", TARN_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD);
	public static final Item TARN_CHESTPLATE = new ArmorModelTarn("tarn_chestplate", TARN_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST);
	public static final Item TARN_LEGGINGS = new ArmorModelTarn("tarn_leggings", TARN_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS);
	public static final Item TARN_BOOTS = new ArmorModelTarn("tarn_boots", TARN_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET);
	
	//Autobot Johnson
	public static final Item AJ_HELMET = new ArmorModelAJ("aj_helmet", AJ_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD);
	public static final Item AJ_CHESTPLATE = new ArmorModelAJ("aj_chestplate", AJ_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST);
	public static final Item AJ_LEGGINGS = new ArmorModelAJ("aj_leggings", AJ_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS);
	public static final Item AJ_BOOTS = new ArmorModelAJ("aj_boots", AJ_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET);
	
	//public static  ItemBase = new ItemBaseMeta("basic", EItemBasic.allNames);
	
	//Guns
	public static final Item PHOTON_BURST_RIFLE = new ModdedBow("modded_bow");
	public static final Item Energon_Battle_Pistol = new EnergonBattlePistol();
	public static final IGun Scrapper = new Scrapper();
	public static final Item EMPShotgun = new EMPShotgun();
	
	//Ammo
	public static final Item PRIMARY_AMMO = new PrimaryAmmo();
	
	public static final IShootable Energon_Battle_Pistol_CLip = new AmmoClip("Energon_Battle_Pistol_Clip", 10);
	public static final IShootable Scrapper_Clip = new AmmoClip("Scrapper_Clip", 100);
	public static final IShootable EMP_Shotgun_Shell = new AmmoClip("EMP_Shotgun_Shell", 16);
	
	
	
	
	//public static ItemStack getBasicItem(EItemBasic basicName)
    {
      //  return getBasicItem(basicName, 1);
    }
    
    //public static ItemStack getBasicItem(EItemBasic basicName, int stackSize)
    {
     //   return new ItemStack(ItemBase, stackSize, basicName.ordinal());
    }
}
