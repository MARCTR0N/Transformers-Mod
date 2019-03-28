package com.marctron.transformersmod.init;

import java.util.ArrayList;
import java.util.List;

import com.marctron.transformersmod.items.gun.AmmoClip;
import com.marctron.transformersmod.items.gun.EMPShotgun;
import com.marctron.transformersmod.items.gun.EnergonBattlePistol;
import com.marctron.transformersmod.items.gun.IShootable;
import com.marctron.transformersmod.items.gun.Scrapper;
import com.marctron.transformersmod.transformers.ArmorModelAJ;
import com.marctron.transformersmod.transformers.ArmorModelSideswipe;
import com.marctron.transformersmod.transformers.ArmorModelTarn;
import com.marctron.transformersmod.transformers.ArmorModelVehicon;
import com.marctron.transformersmod.util.Reference;
import com.marctron.transformersmod.items.*;
import com.marctron.transformersmod.items.gun.*;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
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
	public static final Item RED_ENERGON_SHARD = new ItemBase("red_energon_shard");
	public static final Item DARK_ENERGON_SHARD = new ItemBase("dark_energon_shard");
	public static final Item SYNTHETIC_ENERGON_SHARD = new ItemBase("synthetic_energon_shard");
	
	public static final Item MUG = new ItemBase("mug");
	public static final Item ENERGON_MUG = new ItemCustomFood("energon_mug", 4, false);
	public static final Item RED_ENERGON_MUG = new ItemCustomFood("red_energon_mug", 4, false, new PotionEffect(Potion.getPotionById(1), 2400, 10), new PotionEffect(Potion.getPotionById(3), 2400, 2));
	public static final Item DARK_ENERGON_MUG = new ItemCustomFood("dark_energon_mug", 4, false);
	public static final Item SYNTHETIC_ENERGON_MUG = new ItemCustomFood("synthetic_energon_mug", 4, false);
	
	public static final Item TRANSFORMIUM = new ItemBase("transformium");
	public static final Item SILICON = new ItemBase("silicon");
	
	
	//Tools
	public static final ToolMaterial GUN_MATERIAL = EnumHelper.addToolMaterial("gun", 0, 1000, 2.0F, 0, 0);
	
	//Armor
	public static final ArmorMaterial CUSTOM_MODEL_MATERIAL = EnumHelper.addArmorMaterial("custom_model", Reference.MOD_ID + ":custom_model", 20, new int[] {7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);
	
	public static final ArmorMaterial TARN_MODEL_MATERIAL = EnumHelper.addArmorMaterial("tarn_model", Reference.MOD_ID + ":tarn_model", 20, new int[] {7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);
	
	public static final ArmorMaterial AJ_MODEL_MATERIAL = EnumHelper.addArmorMaterial("aj_model", Reference.MOD_ID + ":aj_model", 20, new int[] {7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);
	
	public static final ArmorMaterial SIDESWIPE_MODEL_MATERIAL = EnumHelper.addArmorMaterial("sideswipe_model", Reference.MOD_ID + ":sideswipe_model", 20, new int[] {7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);
	
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
	
	//Sideswipe
	public static final Item SIDESWIPE_HELMET = new ArmorModelSideswipe("sideswipe_helmet", SIDESWIPE_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD);
	public static final Item SIDESWIPE_CHESTPLATE = new ArmorModelSideswipe("sideswipe_chestplate", SIDESWIPE_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST);
	public static final Item SIDESWIPE_LEGGINGS = new ArmorModelSideswipe("sideswipe_leggings", SIDESWIPE_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS);
	public static final Item SIDESWIPE_BOOTS = new ArmorModelSideswipe("sideswipe_boots", SIDESWIPE_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET);
	
	
	
	public static Item ItemBase = new ItemBasicMeta("basic", EItemBasic.allNames);
	
	//Guns
	public static final Item PHOTON_BURST_RIFLE = new ModdedBow("modded_bow");
	public static final Item Energon_Battle_Pistol = new EnergonBattlePistol();
	public static final IGun Scrapper = new Scrapper();
	public static final Item EMPShotgun = new EMPShotgun();
	public static final Item ScatterBlaster = new ScatterBlaster();
	public static final Item NeutronRepeater = new NeutronRepeater();
	
	//Ammo
	public static final Item PRIMARY_AMMO = new PrimaryAmmo();
	
	public static final IShootable Energon_Battle_Pistol_Clip = new AmmoClip("Energon_Battle_Pistol_Clip", 10);
	public static final IShootable Scrapper_Clip = new AmmoClip("Scrapper_Clip", 100);
	public static final IShootable EMP_Shotgun_Shell = new AmmoClip("EMP_Shotgun_Shell", 16);
	public static final IShootable Scatter_Blaster_Shell = new AmmoClip("Scatter_Blaster_Shell", 16);
	public static final IShootable Neutron_Repeater_Clip = new AmmoClip("Neutron_Repeater_Clip", 100);
	
	//Recipe Components
	public static final Item PROTOFORM = new ItemBase("protoform");
	public static final Item PROTOFORM_HEAD = new ItemBase("protoform_head");
	public static final Item PROTOFORM_CHEST = new ItemBase("protoform_chest");
	public static final Item PROTOFORM_LEGS = new ItemBase("protoform_legs");
	public static final Item PROTOFORM_FEET = new ItemBase("protoform_feet");
	
	public static final Item SPARK = new ItemBase("spark");
	public static final Item OPTICS = new ItemBase("optics");
	public static final Item VOICEBOX = new ItemBase("voicebox");
	public static final Item BRAIN = new ItemBase("brain");
	public static final Item HAND = new ItemBase("hand");
	public static final Item LIMB = new ItemBase("limb");
	public static final Item SPARK_CHAMBER = new ItemBase("spark_chamber");
	public static final Item TRANSFORMATION_COG = new ItemBase("transformation_cog");
	
	
	public static final Item AUTOBOT_INSGINIA = new ItemBase("autobot_insignia");
	public static final Item DECEPTICON_INSGINIA = new ItemBase("decepticon_insignia");
	
	
	public static final Item WING = new ItemBase("wing");
	public static final Item TREAD = new ItemBase("tread");
	public static final Item TIRE = new ItemBase("tire");
	public static final Item WHEEL = new ItemBase("wheel");
	public static final Item HUBCAP = new ItemBase("hubcap");
	public static final Item THRUSTER = new ItemBase("thruster");
	
	public static final Item CREDIT1 = new ItemBase("credit1");
	public static final Item CREDIT5 = new ItemBase("credit5");
	public static final Item CREDIT10 = new ItemBase("credit10");
	public static final Item CREDIT50 = new ItemBase("credit50");
	public static final Item CREDIT100 = new ItemBase("credit100");
	public static final Item CREDIT500 = new ItemBase("credit500");
	public static final Item BOTCOIN = new ItemBase("botcoin");
	
	
	public static ItemStack getBasicItem(EItemBasic basicName)
    {
        return getBasicItem(basicName, 1);
    }
    
    public static ItemStack getBasicItem(EItemBasic basicName, int stackSize)
    {
        return new ItemStack(ItemBase, stackSize, basicName.ordinal());
    }
    /*
    public static ItemStack getBaseItem(IShootable basicName)
    {
        return getBaseItem(basicName);
    }
    /*
    public static ItemStack getBaseItem(ItemBase basicName, int stackSize)
    {
        return new ItemStack(ItemBase, stackSize, basicName.);
    }
    */

	

	
}
