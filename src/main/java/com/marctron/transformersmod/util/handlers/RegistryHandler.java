package com.marctron.transformersmod.util.handlers;

import java.util.ArrayList;
import java.util.List;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.blocks.BlockBase;
import com.marctron.transformersmod.blocks.BlockEnergonCrate;
import com.marctron.transformersmod.blocks.BlockGlassBase;
import com.marctron.transformersmod.blocks.BlueEnergonoreBlock;
import com.marctron.transformersmod.blocks.DarkEnergonoreBlock;
import com.marctron.transformersmod.blocks.EnergoncubeBlock;
import com.marctron.transformersmod.blocks.EnergonoreBlock;
import com.marctron.transformersmod.blocks.ItemSpawner;
import com.marctron.transformersmod.blocks.RedEnergonoreBlock;
import com.marctron.transformersmod.blocks.TransformiumoreBlock;
import com.marctron.transformersmod.entity.EntityBullet;
import com.marctron.transformersmod.entity.EntityLargeRocket;
import com.marctron.transformersmod.entity.EntitySwindle;
import com.marctron.transformersmod.entity.EntityVehicon;
import com.marctron.transformersmod.items.ItemBase;
import com.marctron.transformersmod.items.ItemEnergonMug;
import com.marctron.transformersmod.items.ItemEnergonMugDark;
import com.marctron.transformersmod.items.ItemEnergonMugRed;
import com.marctron.transformersmod.items.ItemEnergonMugSynthetic;
import com.marctron.transformersmod.items.ItemMedkit;
import com.marctron.transformersmod.items.ItemPhaseShifter;
import com.marctron.transformersmod.items.ItemStarSaber;
import com.marctron.transformersmod.items.gun.AmmoClip;
import com.marctron.transformersmod.items.gun.EMPShotgun;
import com.marctron.transformersmod.items.gun.EnergonBattlePistol;
import com.marctron.transformersmod.items.gun.NeutronRepeater;
import com.marctron.transformersmod.items.gun.RocketLauncher;
import com.marctron.transformersmod.items.gun.ScatterBlaster;
import com.marctron.transformersmod.items.gun.Scrapper;
import com.marctron.transformersmod.transformers.Vurp;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeAltmode;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeAltmode2;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeMid1;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeMid2;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeMid3;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeMid4;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeMid5;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeMid6;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeMid7;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeMid8;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeMid9;
import com.marctron.transformersmod.transformers.transformer.sideswipe.ArmorModelSideswipe;
import com.marctron.transformersmod.transformers.transformer.sideswipe.SideswipeAltmode;
import com.marctron.transformersmod.transformers.transformer.sideswipe.SideswipeMid;
import com.marctron.transformersmod.transformers.transformer.sideswipe.SideswipeMid2;
import com.marctron.transformersmod.transformers.transformer.sideswipe.SideswipeMid3;
import com.marctron.transformersmod.transformers.transformer.sideswipe.SideswipeMid4;
import com.marctron.transformersmod.transformers.transformer.starscream.Starscream;
import com.marctron.transformersmod.transformers.transformer.starscream.StarscreamAltmode;
import com.marctron.transformersmod.transformers.transformer.starscream.StarscreamMid1;
import com.marctron.transformersmod.transformers.transformer.starscream.StarscreamMid2;
import com.marctron.transformersmod.transformers.transformer.starscream.StarscreamMid3;
import com.marctron.transformersmod.transformers.transformer.starscream.StarscreamMid4;
import com.marctron.transformersmod.transformers.transformer.starscream.StarscreamMid5;
import com.marctron.transformersmod.transformers.transformer.starscream.StarscreamMid6;
import com.marctron.transformersmod.transformers.transformer.tarn.ArmorModelTarn;
import com.marctron.transformersmod.transformers.transformer.tarn.Tarn2;
import com.marctron.transformersmod.transformers.transformer.tarn.TarnAltmode;
import com.marctron.transformersmod.transformers.transformer.tarn.TarnMid1;
import com.marctron.transformersmod.transformers.transformer.tarn.TarnMid2;
import com.marctron.transformersmod.transformers.transformer.tarn.TarnMid3;
import com.marctron.transformersmod.transformers.transformer.tarn.TarnMid4;
import com.marctron.transformersmod.transformers.transformer.tarn.TarnMid5;
import com.marctron.transformersmod.transformers.transformer.tarn.TarnMid6;
import com.marctron.transformersmod.transformers.transformer.tarn.TarnMid7;
import com.marctron.transformersmod.transformers.transformer.tarn.TarnMid8;
import com.marctron.transformersmod.transformers.transformer.vehicon.ArmorModelVehicon;
import com.marctron.transformersmod.transformers.transformer.vehicon.VehiconAltmode;
import com.marctron.transformersmod.transformers.transformer.vehicon.VehiconMid;
import com.marctron.transformersmod.transformers.transformer.vehicon.VehiconMid2;
import com.marctron.transformersmod.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class RegistryHandler {
	
	
	
	
	
	//Tools
    public static final ToolMaterial GUN_MATERIAL = EnumHelper.addToolMaterial("gun", 0, 1000, 2.0F, 0, 0);
    public static final ToolMaterial SWORD_MATERIAL = EnumHelper.addToolMaterial("sword", 0, 1000, 2.0F, 4, 0);

    //Armor
    public static final ArmorMaterial CUSTOM_MODEL_MATERIAL = EnumHelper.addArmorMaterial("custom_model", Reference.MOD_ID + ":custom_model", 10, new int[]{3, 3, 3, 3}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);

    public static final ArmorMaterial VURP_MATERIAL = EnumHelper.addArmorMaterial("vurp_model", Reference.MOD_ID + ":vurp_model", 10, new int[]{3, 3, 3, 3}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);
    
    public static final ArmorMaterial TARN_MODEL_MATERIAL = EnumHelper.addArmorMaterial("tarn_model", Reference.MOD_ID + ":tarn_model", 20, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);
    public static final ArmorMaterial TARN2_MODEL_MATERIAL = EnumHelper.addArmorMaterial("tarn2_model", Reference.MOD_ID + ":tarn2_model", 20, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);
    public static final ArmorMaterial TARN_ALTMODE_MATERIAL = EnumHelper.addArmorMaterial("tarn_altmode_model", Reference.MOD_ID + ":tarn_altmode_model", 20, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);


    public static final ArmorMaterial STARSCREAM_MODEL_MATERIAL = EnumHelper.addArmorMaterial("starscream_model", Reference.MOD_ID + ":starscream_model", 20, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);

    public static final ArmorMaterial MOVIE_OPTIMUS_PRIME_MATERIAL = EnumHelper.addArmorMaterial("movie_optimus_prime_model", Reference.MOD_ID + ":movie_optimus_prime_model", 1000, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);


    public static final ArmorMaterial SKYWARP_MODEL_MATERIAL = EnumHelper.addArmorMaterial("skywarp_model", Reference.MOD_ID + ":skywarp_model", 20, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);

    public static final ArmorMaterial THUNDERCRACKER_MODEL_MATERIAL = EnumHelper.addArmorMaterial("thundercracker_model", Reference.MOD_ID + ":thundercracker_model", 20, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);

    public static final ArmorMaterial SIDESWIPE_MODEL_MATERIAL = EnumHelper.addArmorMaterial("sideswipe_model", Reference.MOD_ID + ":sideswipe_model", 20, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);

    public static final ArmorMaterial IRONHIDE_MATERIAL = EnumHelper.addArmorMaterial("ironhide_model", Reference.MOD_ID + ":ironhide_model", 20, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);


    //Armor Altmode
    public static final ArmorMaterial VEHICON_ALTMODE_MATERIAL = EnumHelper.addArmorMaterial("vehicon_altmode_model", Reference.MOD_ID + ":vehicon_altmode_model", 20, new int[]{5, 5, 5, 5}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);

    public static final ArmorMaterial SIDESWIPE_ALTMODE_MATERIAL = EnumHelper.addArmorMaterial("sideswipe_altmode_model", Reference.MOD_ID + ":sideswipe_altmode_model", 20, new int[]{5, 5, 5, 5}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);

    public static final ArmorMaterial SKYWARP_ALTMODE_MATERIAL = EnumHelper.addArmorMaterial("skywarp_altmode_model", Reference.MOD_ID + ":skywarp_altmode_model", 20, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);
	
	
	

    @GameRegistry.ObjectHolder(Reference.MOD_ID)
    public static final class ModItems {
      //Relics
    	public static final Item PHASE_SHIFTER = null;
    	public static final Item STAR_SABER = null;
    	
      //TabIcons
    	public static final Item AMMO = null;
    	
      //Consumables
        public static final Item MEDKIT = null;
    	
      //Recipe Components
        public static final Item PROTOFORM = null;
        public static final Item PROTOFORM_HEAD = null;
        public static final Item PROTOFORM_CHEST = null;
        public static final Item PROTOFORM_LEGS = null;
        public static final Item PROTOFORM_FEET = null;
        public static final Item SPARK = null;
        public static final Item OPTICS = null;
        public static final Item VOICEBOX = null;
        public static final Item BRAIN = null;
        public static final Item HAND = null;
        public static final Item LIMB = null;
        public static final Item SPARK_CHAMBER = null;
        public static final Item TRANSFORMATION_COG = null;
        public static final Item A_INSGINIA = null;
        public static final Item D_INSGINIA = null;
        public static final Item ADVANCED_CIRCUIT = null;
        public static final Item BASIC_CIRCUIT = null;
        public static final Item ALLOY = null;
        public static final Item COCKPIT = null;
        public static final Item WING = null;
        public static final Item TREAD = null;
        public static final Item TIRE = null;
        public static final Item WHEEL = null;
        public static final Item HUBCAP = null;
        public static final Item THRUSTER = null;
        public static final Item CREDIT1 = null;
        public static final Item CREDIT5 = null;
        public static final Item CREDIT10 = null;
        public static final Item CREDIT50 = null;
        public static final Item CREDIT100 = null;
        public static final Item CREDIT500 = null;
        public static final Item BOTCOIN = null;
    	
      //Guns
        public static final EnergonBattlePistol Energon_Battle_Pistol = null;
        public static final AmmoClip Energon_Battle_Pistol_Clip = null;
        public static final Scrapper Scrapper = null;
        public static final AmmoClip Scrapper_Clip = null;
        public static final EMPShotgun EMPShotgun = null;
        public static final AmmoClip EMP_Shotgun_Shell = null;
        public static final ScatterBlaster ScatterBlaster = null;
        public static final AmmoClip Scatter_Blaster_Shell = null;
        public static final NeutronRepeater NeutronRepeater = null;
        public static final AmmoClip Neutron_Repeater_Clip = null;
        public static final RocketLauncher RocketLauncher = null;
        public static final AmmoClip Rocket_Clip = null;
    	
      //Items
        public static final Item ENERGON_SHARD = null;
        public static final Item BLUE_ENERGON_SHARD = null;
        public static final Item RED_ENERGON_SHARD = null;
        public static final Item DARK_ENERGON_SHARD = null;
        public static final Item SYNTHETIC_ENERGON_SHARD = null;

        public static final Item MUG = null;
        public static final Item ENERGON_MUG = null;
        public static final Item RED_ENERGON_MUG = null;
        public static final Item DARK_ENERGON_MUG = null;
        public static final Item SYNTHETIC_ENERGON_MUG = null;

        public static final Item TRANSFORMIUM = null;
        public static final Item SILICON = null;

      //Dyes
        public static final Item PALE_GREEN_DYE = null;
        public static final Item PALE_BROWN_DYE = null;
        public static final Item DARK_RED_DYE = null;
        public static final Item DARK_GRAY_DYE = null;
        public static final Item BEIGE_DYE = null;
    	
      //Vurp
        public static final Item VURP_HELMET = null;
        public static final Item VURP_CHESTPLATE = null;
        public static final Item VURP_LEGGINGS = null;
        public static final Item VURP_BOOTS = null;
        
      //Sideswipe
        public static final Item SIDESWIPE_HELMET = null;
        public static final Item SIDESWIPE_CHESTPLATE = null;
        public static final Item SIDESWIPE_LEGGINGS = null;
        public static final Item SIDESWIPE_BOOTS = null;

        public static final Item SIDESWIPE_MID_HELMET = null;
        public static final Item SIDESWIPE_MID_CHESTPLATE = null;
        public static final Item SIDESWIPE_MID_LEGGINGS = null;
        public static final Item SIDESWIPE_MID_BOOTS = null;
        
        public static final Item SIDESWIPE_MID2_HELMET = null;
        public static final Item SIDESWIPE_MID2_CHESTPLATE = null;
        public static final Item SIDESWIPE_MID2_LEGGINGS = null;
        public static final Item SIDESWIPE_MID2_BOOTS = null;

        public static final Item SIDESWIPE_MID3_HELMET = null;
        public static final Item SIDESWIPE_MID3_CHESTPLATE = null;
        public static final Item SIDESWIPE_MID3_LEGGINGS = null;
        public static final Item SIDESWIPE_MID3_BOOTS = null;

        public static final Item SIDESWIPE_MID4_HELMET = null;
        public static final Item SIDESWIPE_MID4_CHESTPLATE = null;
        public static final Item SIDESWIPE_MID4_LEGGINGS = null;
        public static final Item SIDESWIPE_MID4_BOOTS = null;

        public static final Item SIDESWIPE_ALTMODE_HELMET = null;
        public static final Item SIDESWIPE_ALTMODE_CHESTPLATE = null;
        public static final Item SIDESWIPE_ALTMODE_LEGGINGS = null;
        public static final Item SIDESWIPE_ALTMODE_BOOTS = null;
        
      //Movie Optimus Prime
        public static final MovieOptimusPrimeAltmode2 MOVIE_OPTIMUS_PRIME_HELMET = null;
        public static final MovieOptimusPrimeAltmode2 MOVIE_OPTIMUS_PRIME_CHESTPLATE = null;
        public static final MovieOptimusPrimeAltmode2 MOVIE_OPTIMUS_PRIME_LEGGINGS = null;
        public static final MovieOptimusPrimeAltmode2 MOVIE_OPTIMUS_PRIME_BOOTS = null;
        
        public static final MovieOptimusPrimeAltmode MOVIE_OPTIMUS_PRIME_ALTMODE_HELMET = null;
        public static final MovieOptimusPrimeAltmode MOVIE_OPTIMUS_PRIME_ALTMODE_CHESTPLATE = null;
        public static final MovieOptimusPrimeAltmode MOVIE_OPTIMUS_PRIME_ALTMODE_LEGGINGS = null;
        public static final MovieOptimusPrimeAltmode MOVIE_OPTIMUS_PRIME_ALTMODE_BOOTS = null;
        
        public static final MovieOptimusPrimeMid1 MOVIE_OPTIMUS_PRIME_MID1_HELMET = null;
        public static final MovieOptimusPrimeMid1 MOVIE_OPTIMUS_PRIME_MID1_CHESTPLATE = null;
        public static final MovieOptimusPrimeMid1 MOVIE_OPTIMUS_PRIME_MID1_LEGGINGS = null;
        public static final MovieOptimusPrimeMid1 MOVIE_OPTIMUS_PRIME_MID1_BOOTS = null;
        
        public static final MovieOptimusPrimeMid2 MOVIE_OPTIMUS_PRIME_MID2_HELMET = null;
        public static final MovieOptimusPrimeMid2 MOVIE_OPTIMUS_PRIME_MID2_CHESTPLATE = null;
        public static final MovieOptimusPrimeMid2 MOVIE_OPTIMUS_PRIME_MID2_LEGGINGS = null;
        public static final MovieOptimusPrimeMid2 MOVIE_OPTIMUS_PRIME_MID2_BOOTS = null;
        
        public static final MovieOptimusPrimeMid3 MOVIE_OPTIMUS_PRIME_MID3_HELMET = null;
        public static final MovieOptimusPrimeMid3 MOVIE_OPTIMUS_PRIME_MID3_CHESTPLATE = null;
        public static final MovieOptimusPrimeMid3 MOVIE_OPTIMUS_PRIME_MID3_LEGGINGS = null;
        public static final MovieOptimusPrimeMid3 MOVIE_OPTIMUS_PRIME_MID3_BOOTS = null;
        
        public static final MovieOptimusPrimeMid4 MOVIE_OPTIMUS_PRIME_MID4_HELMET = null;
        public static final MovieOptimusPrimeMid4 MOVIE_OPTIMUS_PRIME_MID4_CHESTPLATE = null;
        public static final MovieOptimusPrimeMid4 MOVIE_OPTIMUS_PRIME_MID4_LEGGINGS = null;
        public static final MovieOptimusPrimeMid4 MOVIE_OPTIMUS_PRIME_MID4_BOOTS = null;    
        
        public static final MovieOptimusPrimeMid5 MOVIE_OPTIMUS_PRIME_MID5_HELMET = null;
        public static final MovieOptimusPrimeMid5 MOVIE_OPTIMUS_PRIME_MID5_CHESTPLATE = null;
        public static final MovieOptimusPrimeMid5 MOVIE_OPTIMUS_PRIME_MID5_LEGGINGS = null;
        public static final MovieOptimusPrimeMid5 MOVIE_OPTIMUS_PRIME_MID5_BOOTS = null;
        
        public static final MovieOptimusPrimeMid6 MOVIE_OPTIMUS_PRIME_MID6_HELMET = null;
        public static final MovieOptimusPrimeMid6 MOVIE_OPTIMUS_PRIME_MID6_CHESTPLATE = null;
        public static final MovieOptimusPrimeMid6 MOVIE_OPTIMUS_PRIME_MID6_LEGGINGS = null;
        public static final MovieOptimusPrimeMid6 MOVIE_OPTIMUS_PRIME_MID6_BOOTS = null;
        
        public static final MovieOptimusPrimeMid7 MOVIE_OPTIMUS_PRIME_MID7_HELMET = null;
        public static final MovieOptimusPrimeMid7 MOVIE_OPTIMUS_PRIME_MID7_CHESTPLATE = null;
        public static final MovieOptimusPrimeMid7 MOVIE_OPTIMUS_PRIME_MID7_LEGGINGS = null;
        public static final MovieOptimusPrimeMid7 MOVIE_OPTIMUS_PRIME_MID7_BOOTS = null;
        
        public static final MovieOptimusPrimeMid8 MOVIE_OPTIMUS_PRIME_MID8_HELMET = null;
        public static final MovieOptimusPrimeMid8 MOVIE_OPTIMUS_PRIME_MID8_CHESTPLATE = null;
        public static final MovieOptimusPrimeMid8 MOVIE_OPTIMUS_PRIME_MID8_LEGGINGS = null;
        public static final MovieOptimusPrimeMid8 MOVIE_OPTIMUS_PRIME_MID8_BOOTS = null;
        
        public static final MovieOptimusPrimeMid9 MOVIE_OPTIMUS_PRIME_MID9_HELMET = null;
        public static final MovieOptimusPrimeMid9 MOVIE_OPTIMUS_PRIME_MID9_CHESTPLATE = null;
        public static final MovieOptimusPrimeMid9 MOVIE_OPTIMUS_PRIME_MID9_LEGGINGS = null;
        public static final MovieOptimusPrimeMid9 MOVIE_OPTIMUS_PRIME_MID9_BOOTS = null;
        
      //Starscream
        public static final Starscream STARSCREAM_HELMET = null;
        public static final Starscream STARSCREAM_CHESTPLATE = null;
        public static final Starscream STARSCREAM_LEGGINGS = null;
        public static final Starscream STARSCREAM_BOOTS = null;

        public static final StarscreamAltmode STARSCREAM_ALTMODE_HELMET = null;
        public static final StarscreamAltmode STARSCREAM_ALTMODE_CHESTPLATE = null;
        public static final StarscreamAltmode STARSCREAM_ALTMODE_LEGGINGS = null;
        public static final StarscreamAltmode STARSCREAM_ALTMODE_BOOTS = null;
        
        public static final StarscreamMid1 STARSCREAM_MID1_HELMET = null;
        public static final StarscreamMid1 STARSCREAM_MID1_CHESTPLATE = null;
        public static final StarscreamMid1 STARSCREAM_MID1_LEGGINGS = null;
        public static final StarscreamMid1 STARSCREAM_MID1_BOOTS = null;

        public static final StarscreamMid2 STARSCREAM_MID2_HELMET = null;
        public static final StarscreamMid2 STARSCREAM_MID2_CHESTPLATE = null;
        public static final StarscreamMid2 STARSCREAM_MID2_LEGGINGS = null;
        public static final StarscreamMid2 STARSCREAM_MID2_BOOTS = null;

        public static final StarscreamMid3 STARSCREAM_MID3_HELMET = null;
        public static final StarscreamMid3 STARSCREAM_MID3_CHESTPLATE = null;
        public static final StarscreamMid3 STARSCREAM_MID3_LEGGINGS = null;
        public static final StarscreamMid3 STARSCREAM_MID3_BOOTS = null;

        public static final StarscreamMid4 STARSCREAM_MID4_HELMET = null;
        public static final StarscreamMid4 STARSCREAM_MID4_CHESTPLATE = null;
        public static final StarscreamMid4 STARSCREAM_MID4_LEGGINGS = null;
        public static final StarscreamMid4 STARSCREAM_MID4_BOOTS = null;

        public static final StarscreamMid5 STARSCREAM_MID5_HELMET = null;
        public static final StarscreamMid5 STARSCREAM_MID5_CHESTPLATE = null;
        public static final StarscreamMid5 STARSCREAM_MID5_LEGGINGS = null;
        public static final StarscreamMid5 STARSCREAM_MID5_BOOTS = null;

        public static final StarscreamMid6 STARSCREAM_MID6_HELMET = null;
        public static final StarscreamMid6 STARSCREAM_MID6_CHESTPLATE = null;
        public static final StarscreamMid6 STARSCREAM_MID6_LEGGINGS = null;
        public static final StarscreamMid6 STARSCREAM_MID6_BOOTS = null;
        
      //Skywarp
        public static final Starscream SKYWARP_HELMET = null;
        public static final Starscream SKYWARP_CHESTPLATE = null;
        public static final Starscream SKYWARP_LEGGINGS = null;
        public static final Starscream SKYWARP_BOOTS = null;

        public static final StarscreamAltmode SKYWARP_ALTMODE_HELMET = null;
        public static final StarscreamAltmode SKYWARP_ALTMODE_CHESTPLATE = null;
        public static final StarscreamAltmode SKYWARP_ALTMODE_LEGGINGS = null;
        public static final StarscreamAltmode SKYWARP_ALTMODE_BOOTS = null;
        
        public static final StarscreamMid1 SKYWARP_MID1_HELMET = null;
        public static final StarscreamMid1 SKYWARP_MID1_CHESTPLATE = null;
        public static final StarscreamMid1 SKYWARP_MID1_LEGGINGS = null;
        public static final StarscreamMid1 SKYWARP_MID1_BOOTS = null;

        public static final StarscreamMid2 SKYWARP_MID2_HELMET = null;
        public static final StarscreamMid2 SKYWARP_MID2_CHESTPLATE = null;
        public static final StarscreamMid2 SKYWARP_MID2_LEGGINGS = null;
        public static final StarscreamMid2 SKYWARP_MID2_BOOTS = null;

        public static final StarscreamMid3 SKYWARP_MID3_HELMET = null;
        public static final StarscreamMid3 SKYWARP_MID3_CHESTPLATE = null;
        public static final StarscreamMid3 SKYWARP_MID3_LEGGINGS = null;
        public static final StarscreamMid3 SKYWARP_MID3_BOOTS = null;

        public static final StarscreamMid4 SKYWARP_MID4_HELMET = null;
        public static final StarscreamMid4 SKYWARP_MID4_CHESTPLATE = null;
        public static final StarscreamMid4 SKYWARP_MID4_LEGGINGS = null;
        public static final StarscreamMid4 SKYWARP_MID4_BOOTS = null;

        public static final StarscreamMid5 SKYWARP_MID5_HELMET = null;
        public static final StarscreamMid5 SKYWARP_MID5_CHESTPLATE = null;
        public static final StarscreamMid5 SKYWARP_MID5_LEGGINGS = null;
        public static final StarscreamMid5 SKYWARP_MID5_BOOTS = null;

        public static final StarscreamMid6 SKYWARP_MID6_HELMET = null;
        public static final StarscreamMid6 SKYWARP_MID6_CHESTPLATE = null;
        public static final StarscreamMid6 SKYWARP_MID6_LEGGINGS = null;
        public static final StarscreamMid6 SKYWARP_MID6_BOOTS = null;
        
      //Thundercracker
        public static final Starscream THUNDERCRACKER_HELMET = null;
        public static final Starscream THUNDERCRACKER_CHESTPLATE = null;
        public static final Starscream THUNDERCRACKER_LEGGINGS = null;
        public static final Starscream THUNDERCRACKER_BOOTS = null;

        public static final StarscreamAltmode THUNDERCRACKER_ALTMODE_HELMET = null;
        public static final StarscreamAltmode THUNDERCRACKER_ALTMODE_CHESTPLATE = null;
        public static final StarscreamAltmode THUNDERCRACKER_ALTMODE_LEGGINGS = null;
        public static final StarscreamAltmode THUNDERCRACKER_ALTMODE_BOOTS = null;
        
        public static final StarscreamMid1 THUNDERCRACKER_MID1_HELMET = null;
        public static final StarscreamMid1 THUNDERCRACKER_MID1_CHESTPLATE = null;
        public static final StarscreamMid1 THUNDERCRACKER_MID1_LEGGINGS = null;
        public static final StarscreamMid1 THUNDERCRACKER_MID1_BOOTS = null;

        public static final StarscreamMid2 THUNDERCRACKER_MID2_HELMET = null;
        public static final StarscreamMid2 THUNDERCRACKER_MID2_CHESTPLATE = null;
        public static final StarscreamMid2 THUNDERCRACKER_MID2_LEGGINGS = null;
        public static final StarscreamMid2 THUNDERCRACKER_MID2_BOOTS = null;

        public static final StarscreamMid3 THUNDERCRACKER_MID3_HELMET = null;
        public static final StarscreamMid3 THUNDERCRACKER_MID3_CHESTPLATE = null;
        public static final StarscreamMid3 THUNDERCRACKER_MID3_LEGGINGS = null;
        public static final StarscreamMid3 THUNDERCRACKER_MID3_BOOTS = null;

        public static final StarscreamMid4 THUNDERCRACKER_MID4_HELMET = null;
        public static final StarscreamMid4 THUNDERCRACKER_MID4_CHESTPLATE = null;
        public static final StarscreamMid4 THUNDERCRACKER_MID4_LEGGINGS = null;
        public static final StarscreamMid4 THUNDERCRACKER_MID4_BOOTS = null;

        public static final StarscreamMid5 THUNDERCRACKER_MID5_HELMET = null;
        public static final StarscreamMid5 THUNDERCRACKER_MID5_CHESTPLATE = null;
        public static final StarscreamMid5 THUNDERCRACKER_MID5_LEGGINGS = null;
        public static final StarscreamMid5 THUNDERCRACKER_MID5_BOOTS = null;

        public static final StarscreamMid6 THUNDERCRACKER_MID6_HELMET = null;
        public static final StarscreamMid6 THUNDERCRACKER_MID6_CHESTPLATE = null;
        public static final StarscreamMid6 THUNDERCRACKER_MID6_LEGGINGS = null;
        public static final StarscreamMid6 THUNDERCRACKER_MID6_BOOTS = null;
        
   	 //Vehicon
	    public static final Item CUSTOM_HELMET = null;
	    public static final Item CUSTOM_CHESTPLATE = null;
	    public static final Item CUSTOM_LEGGINGS = null;
	    public static final Item CUSTOM_BOOTS = null;

	    public static final Item VEHICON_MID_HELMET = null;
	    public static final Item VEHICON_MID_CHESTPLATE = null;
	    public static final Item VEHICON_MID_LEGGINGS = null;
	    public static final Item VEHICON_MID_BOOTS = null;
	    
	    public static final Item VEHICON_MID_2_HELMET = null;
	    public static final Item VEHICON_MID_2_CHESTPLATE = null;
	    public static final Item VEHICON_MID_2_LEGGINGS = null;
	    public static final Item VEHICON_MID_2_BOOTS = null;

	    public static final Item VEHICON_ALTMODE_HELMET = null;
	    public static final Item VEHICON_ALTMODE_CHESTPLATE = null;
	    public static final Item VEHICON_ALTMODE_LEGGINGS = null;
	    public static final Item VEHICON_ALTMODE_BOOTS = null;
	    
	  //Tarn
	    public static final Item TARN_HELMET = null;
	    public static final Item TARN_CHESTPLATE = null;
	    public static final Item TARN_LEGGINGS = null;
	    public static final Item TARN_BOOTS = null;

	    public static final Item TARN_MID1_HELMET = null;
	    public static final Item TARN_MID1_CHESTPLATE = null;
	    public static final Item TARN_MID1_LEGGINGS = null;
	    public static final Item TARN_MID1_BOOTS = null;

	    public static final Item TARN_MID2_HELMET = null;
	    public static final Item TARN_MID2_CHESTPLATE = null;
	    public static final Item TARN_MID2_LEGGINGS = null;
	    public static final Item TARN_MID2_BOOTS = null;

	    public static final Item TARN_MID3_HELMET = null;
	    public static final Item TARN_MID3_CHESTPLATE = null;
	    public static final Item TARN_MID3_LEGGINGS = null;
	    public static final Item TARN_MID3_BOOTS = null;
	    
	    public static final Item TARN_MID4_HELMET = null;
	    public static final Item TARN_MID4_CHESTPLATE = null;
	    public static final Item TARN_MID4_LEGGINGS = null;
	    public static final Item TARN_MID4_BOOTS = null;

	    public static final Item TARN_ALTMODE_HELMET = null;
	    public static final Item TARN_ALTMODE_CHESTPLATE = null;
	    public static final Item TARN_ALTMODE_LEGGINGS = null;
	    public static final Item TARN_ALTMODE_BOOTS = null;

	    public static final Item TARN_MID5_HELMET = null;
	    public static final Item TARN_MID5_CHESTPLATE = null;
	    public static final Item TARN_MID5_LEGGINGS = null;
	    public static final Item TARN_MID5_BOOTS = null;

	    public static final Item TARN_MID6_HELMET = null;
	    public static final Item TARN_MID6_CHESTPLATE = null;
	    public static final Item TARN_MID6_LEGGINGS = null;
	    public static final Item TARN_MID6_BOOTS = null;

	    public static final Item TARN_MID7_HELMET = null;
	    public static final Item TARN_MID7_CHESTPLATE = null;
	    public static final Item TARN_MID7_LEGGINGS = null;
	    public static final Item TARN_MID7_BOOTS = null;

	    public static final Item TARN_MID8_HELMET = null;
	    public static final Item TARN_MID8_CHESTPLATE = null;
	    public static final Item TARN_MID8_LEGGINGS = null;
	    public static final Item TARN_MID8_BOOTS = null;
    }

    @GameRegistry.ObjectHolder(Reference.MOD_ID)
    public static final class ModBlocks {

    	public static final Block ITEM_SPAWNER = null;
    	public static final Block ENERGON_CUBE_BLOCK = null;
        public static final Block RED_ENERGON_CUBE_BLOCK = null;
        public static final Block BLUE_ENERGON_CUBE_BLOCK = null;
        public static final Block DARK_ENERGON_CUBE_BLOCK = null;
        public static final Block SYNTHETIC_ENERGON_CUBE_BLOCK = null;
        
        public static final Block ENERGON_ORE_BLOCK = null;
        public static final Block RED_ENERGON_ORE_BLOCK = null;
        public static final Block BLUE_ENERGON_ORE_BLOCK = null;
        public static final Block DARK_ENERGON_ORE_BLOCK = null;
        public static final Block RED_ENERGON_ORE_BLOCK_NETHERRACK = null;
        public static final Block DARK_ENERGON_ORE_BLOCK_END_STONE = null;

        public static final Block TRANSFORMIUM_BLOCK = null;
        public static final Block TRANSFORMIUM_ORE_BLOCK = null;

        public static final Block ENERGON_CRATE_BLOCK = null;
        
        public static final Block SPACE_BRIDGE_BLOCK = null;

        //Machinery
//        public static final Block ENERGON_ENGINE = null;
//        public static final Block ENERGON_STORAGE = null;
//        public static final Block CREATIVE_GENERATOR = null;

        //Dyed Stuff

        //Wool
        public static final Block WOOL_PALE_GREEN = null;
        public static final Block WOOL_PALE_BROWN = null;
        public static final Block WOOL_DARK_RED = null;
        public static final Block WOOL_DARK_GRAY = null;
        public static final Block WOOL_BEIGE = null;

        //Glass
        public static final Block STAINED_GLASS_PALE_GREEN = null;
        public static final Block STAINED_GLASS_PALE_BROWN = null;
        public static final Block STAINED_GLASS_DARK_RED = null;
        public static final Block STAINED_GLASS_DARK_GRAY = null;
        public static final Block STAINED_GLASS_BEIGE = null;

        //Clay
        public static final Block STAINED_HARDENED_CLAY_PALE_GREEN = null;
        public static final Block STAINED_HARDENED_CLAY_PALE_BROWN = null;
        public static final Block STAINED_HARDENED_CLAY_DARK_RED = null;
        public static final Block STAINED_HARDENED_CLAY_DARK_GRAY = null;
        public static final Block STAINED_HARDENED_CLAY_BEIGE = null;
    	
    }

    @Mod.EventBusSubscriber
    public static class Registry {
    	private static int entityID = -1;
    	private static List<ItemBlock> ITEM_BLOCKS = new ArrayList<>();
    	
        @SubscribeEvent
        public static void onItemRegister(RegistryEvent.Register<Item> event) {
            final Item[] items = {
            	  //Relics
            		new ItemStarSaber("star_saber", 200, SWORD_MATERIAL),
            		new ItemPhaseShifter("phase_shifter"),
            		
            	  //TabIcons
            		new ItemBase("ammo"),
            		
            	  //Consumables
            	    new ItemMedkit("medkit", 3, 10, 100),
            		
            	  //Recipe Components
            	    new ItemBase("protoform"),
            	    new ItemBase("protoform_head"),
            	    new ItemBase("protoform_chest"),
            	    new ItemBase("protoform_legs"),
            	    new ItemBase("protoform_feet"),
            	    new ItemBase("spark"),
            	    new ItemBase("optics"),
            	    new ItemBase("voicebox"),
            	    new ItemBase("brain"),
            	    new ItemBase("hand"),
            	    new ItemBase("limb"),
            	    new ItemBase("spark_chamber"),
            	    new ItemBase("transformation_cog"),
            	    new ItemBase("autobot_insignia"),
            	    new ItemBase("decepticon_insignia"),
            	    new ItemBase("advanced_circuit"),
            	    new ItemBase("basic_circuit"),
            	    new ItemBase("alloy"),
            	    new ItemBase("cockpit"),
            	    new ItemBase("wing"),
            	    new ItemBase("tread"),
            	    new ItemBase("tire"),
            	    new ItemBase("wheel"),
            	    new ItemBase("hubcap"),
            	    new ItemBase("thruster"),
            	    new ItemBase("credit1"),
            	    new ItemBase("credit5"),
            	    new ItemBase("credit10"),
            	    new ItemBase("credit50"),
            	    new ItemBase("credit100"),
            	    new ItemBase("credit500"),
            	    new ItemBase("botcoin"),
            		
            	  //Guns
            	    new EnergonBattlePistol(15),
            	    new AmmoClip("Energon_Battle_Pistol_Clip", 10),
            	    new Scrapper(),
            	    new AmmoClip("Scrapper_Clip", 60),
            	    new EMPShotgun(10),
            	    new AmmoClip("EMP_Shotgun_Shell", 2),
            	    new ScatterBlaster(5),
            	    new AmmoClip("Scatter_Blaster_Shell", 6),
            	    new NeutronRepeater(2),
            	    new AmmoClip("Neutron_Repeater_Clip", 224),
            	    new RocketLauncher(50),
            	    new AmmoClip("Rocket_Clip", 4),
            		
            	  //Items
            	    new ItemBase("energon_shard"),
            	    new ItemBase("blue_energon_shard"),
            	    new ItemBase("red_energon_shard"),
            	    new ItemBase("dark_energon_shard"),
            	    new ItemBase("synthetic_energon_shard"),

            	    new ItemBase("mug"),
            	    new ItemEnergonMug("energon_mug", 4, false),
            	    new ItemEnergonMugRed("red_energon_mug", 4, false),
            	    new ItemEnergonMugDark("dark_energon_mug", 4, false),
            	    new ItemEnergonMugSynthetic("synthetic_energon_mug", 4, false),

            	    new ItemBase("transformium"),
            	    new ItemBase("silicon"),

            	 //Dyes
            	    new ItemBase("pale_green_dye"),
            	    new ItemBase("pale_brown_dye"),
            	    new ItemBase("dark_red_dye"),
            	    new ItemBase("dark_gray_dye"),
            	    new ItemBase("beige_dye"),
            	    
            	  //Tarn
            	    new Tarn2("tarn_helmet", TARN2_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new ArmorModelTarn("tarn_chestplate", TARN2_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new Tarn2("tarn_leggings", TARN2_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new Tarn2("tarn_boots", TARN2_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

            	    new TarnMid1("tarn_mid1_helmet", TARN2_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new TarnMid1("tarn_mid1_chestplate", TARN2_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new TarnMid1("tarn_mid1_leggings", TARN2_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new TarnMid1("tarn_mid1_boots", TARN2_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

            	    new TarnMid2("tarn_mid2_helmet", TARN2_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new TarnMid2("tarn_mid2_chestplate", TARN2_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new TarnMid2("tarn_mid2_leggings", TARN2_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new TarnMid2("tarn_mid2_boots", TARN2_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

            	    new TarnMid3("tarn_mid3_helmet", TARN_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new TarnMid3("tarn_mid3_chestplate", TARN_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new TarnMid3("tarn_mid3_leggings", TARN_ALTMODE_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new TarnMid3("tarn_mid3_boots", TARN_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.FEET),

            	    new TarnMid4("tarn_mid4_helmet", TARN_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new TarnMid4("tarn_mid4_chestplate", TARN_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new TarnMid4("tarn_mid4_leggings", TARN_ALTMODE_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new TarnMid4("tarn_mid4_boots", TARN_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.FEET),

            	    new TarnAltmode("tarn_altmode_helmet", 3000, TARN_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new TarnAltmode("tarn_altmode_chestplate", 3000, TARN_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new TarnAltmode("tarn_altmode_leggings", 3000, TARN_ALTMODE_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new TarnAltmode("tarn_altmode_boots", 3000, TARN_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.FEET),

            	    new TarnMid5("tarn_mid5_helmet", TARN_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new TarnMid5("tarn_mid5_chestplate", TARN_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new TarnMid5("tarn_mid5_leggings", TARN_ALTMODE_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new TarnMid5("tarn_mid5_boots", TARN_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.FEET),

            	    new TarnMid6("tarn_mid6_helmet", TARN_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new TarnMid6("tarn_mid6_chestplate", TARN_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new TarnMid6("tarn_mid6_leggings", TARN_ALTMODE_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new TarnMid6("tarn_mid6_boots", TARN_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.FEET),

            	    new TarnMid7("tarn_mid7_helmet", TARN2_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new TarnMid7("tarn_mid7_chestplate", TARN2_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new TarnMid7("tarn_mid7_leggings", TARN2_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new TarnMid7("tarn_mid7_boots", TARN2_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

            	    new TarnMid8("tarn_mid8_helmet",  TARN2_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new TarnMid8("tarn_mid8_chestplate",  TARN2_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new TarnMid8("tarn_mid8_leggings",  TARN2_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new TarnMid8("tarn_mid8_boots",  TARN2_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	   
            	  //Vehicon
            	    new ArmorModelVehicon("custom_helmet",  CUSTOM_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new ArmorModelVehicon("custom_chestplate",  CUSTOM_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new ArmorModelVehicon("custom_leggings",  CUSTOM_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new ArmorModelVehicon("custom_boots",  CUSTOM_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

            	    new VehiconMid("vehicon_mid_helmet",  VEHICON_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new VehiconMid("vehicon_mid_chestplate",  VEHICON_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new VehiconMid("vehicon_mid_leggings",  VEHICON_ALTMODE_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new VehiconMid("vehicon_mid_boots",  VEHICON_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.FEET),

            	    new VehiconMid2("vehicon_mid_2_helmet",  VEHICON_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new VehiconMid2("vehicon_mid_2_chestplate",  VEHICON_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new VehiconMid2("vehicon_mid_2_leggings",  VEHICON_ALTMODE_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new VehiconMid2("vehicon_mid_2_boots",  VEHICON_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.FEET),

            	    new VehiconAltmode("vehicon_altmode_helmet",  VEHICON_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new VehiconAltmode("vehicon_altmode_chestplate",  VEHICON_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new VehiconAltmode("vehicon_altmode_leggings",  VEHICON_ALTMODE_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new VehiconAltmode("vehicon_altmode_boots",  VEHICON_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.FEET),
            		
            	  //Sideswipe
            	    new ArmorModelSideswipe("sideswipe_helmet",  SIDESWIPE_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new ArmorModelSideswipe("sideswipe_chestplate",  SIDESWIPE_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new ArmorModelSideswipe("sideswipe_leggings",  SIDESWIPE_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new ArmorModelSideswipe("sideswipe_boots",  SIDESWIPE_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

            	    new SideswipeMid("sideswipe_mid_helmet",  SIDESWIPE_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new SideswipeMid("sideswipe_mid_chestplate",  SIDESWIPE_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new SideswipeMid("sideswipe_mid_leggings",  SIDESWIPE_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new SideswipeMid("sideswipe_mid_boots",  SIDESWIPE_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

            	    new SideswipeMid2("sideswipe_mid2_helmet",  SIDESWIPE_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new SideswipeMid2("sideswipe_mid2_chestplate",  SIDESWIPE_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new SideswipeMid2("sideswipe_mid2_leggings",  SIDESWIPE_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new SideswipeMid2("sideswipe_mid2_boots",  SIDESWIPE_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

            	    new SideswipeMid3("sideswipe_mid3_helmet",  SIDESWIPE_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new SideswipeMid3("sideswipe_mid3_chestplate",  SIDESWIPE_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new SideswipeMid3("sideswipe_mid3_leggings",  SIDESWIPE_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new SideswipeMid3("sideswipe_mid3_boots",  SIDESWIPE_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

            	    new SideswipeMid4("sideswipe_mid4_helmet",  SIDESWIPE_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new SideswipeMid4("sideswipe_mid4_chestplate",  SIDESWIPE_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new SideswipeMid4("sideswipe_mid4_leggings",  SIDESWIPE_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new SideswipeMid4("sideswipe_mid4_boots",  SIDESWIPE_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

            	    new SideswipeAltmode("sideswipe_altmode_helmet",  SIDESWIPE_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new SideswipeAltmode("sideswipe_altmode_chestplate",  SIDESWIPE_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new SideswipeAltmode("sideswipe_altmode_leggings",  SIDESWIPE_ALTMODE_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new SideswipeAltmode("sideswipe_altmode_boots",  SIDESWIPE_ALTMODE_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    
            	  //Movie Optimus Prime
                    new MovieOptimusPrimeAltmode2("movie_optimus_prime_helmet",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new MovieOptimusPrimeAltmode2("movie_optimus_prime_chestplate",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new MovieOptimusPrimeAltmode2("movie_optimus_prime_leggings",  MOVIE_OPTIMUS_PRIME_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new MovieOptimusPrimeAltmode2("movie_optimus_prime_boots",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    
                    new MovieOptimusPrimeAltmode("movie_optimus_prime_altmode_helmet",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new MovieOptimusPrimeAltmode("movie_optimus_prime_altmode_chestplate",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new MovieOptimusPrimeAltmode("movie_optimus_prime_altmode_leggings",  MOVIE_OPTIMUS_PRIME_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new MovieOptimusPrimeAltmode("movie_optimus_prime_altmode_boots",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    
                    new MovieOptimusPrimeMid1("movie_optimus_prime_mid1_helmet",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new MovieOptimusPrimeMid1("movie_optimus_prime_mid1_chestplate",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new MovieOptimusPrimeMid1("movie_optimus_prime_mid1_leggings",  MOVIE_OPTIMUS_PRIME_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new MovieOptimusPrimeMid1("movie_optimus_prime_mid1_boots",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    
                    new MovieOptimusPrimeMid2("movie_optimus_prime_mid2_helmet",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new MovieOptimusPrimeMid2("movie_optimus_prime_mid2_chestplate",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new MovieOptimusPrimeMid2("movie_optimus_prime_mid2_leggings",  MOVIE_OPTIMUS_PRIME_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new MovieOptimusPrimeMid2("movie_optimus_prime_mid2_boots",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    
                    new MovieOptimusPrimeMid3("movie_optimus_prime_mid3_helmet",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new MovieOptimusPrimeMid3("movie_optimus_prime_mid3_chestplate",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new MovieOptimusPrimeMid3("movie_optimus_prime_mid3_leggings",  MOVIE_OPTIMUS_PRIME_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new MovieOptimusPrimeMid3("movie_optimus_prime_mid3_boots",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    
                    new MovieOptimusPrimeMid4("movie_optimus_prime_mid4_helmet",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new MovieOptimusPrimeMid4("movie_optimus_prime_mid4_chestplate",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new MovieOptimusPrimeMid4("movie_optimus_prime_mid4_leggings",  MOVIE_OPTIMUS_PRIME_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new MovieOptimusPrimeMid4("movie_optimus_prime_mid4_boots",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    
                    new MovieOptimusPrimeMid5("movie_optimus_prime_mid5_helmet",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new MovieOptimusPrimeMid5("movie_optimus_prime_mid5_chestplate",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new MovieOptimusPrimeMid5("movie_optimus_prime_mid5_leggings",  MOVIE_OPTIMUS_PRIME_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new MovieOptimusPrimeMid5("movie_optimus_prime_mid5_boots",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    
                    new MovieOptimusPrimeMid6("movie_optimus_prime_mid6_helmet",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new MovieOptimusPrimeMid6("movie_optimus_prime_mid6_chestplate",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new MovieOptimusPrimeMid6("movie_optimus_prime_mid6_leggings",  MOVIE_OPTIMUS_PRIME_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new MovieOptimusPrimeMid6("movie_optimus_prime_mid6_boots",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    
                    new MovieOptimusPrimeMid7("movie_optimus_prime_mid7_helmet",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new MovieOptimusPrimeMid7("movie_optimus_prime_mid7_chestplate",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new MovieOptimusPrimeMid7("movie_optimus_prime_mid7_leggings",  MOVIE_OPTIMUS_PRIME_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new MovieOptimusPrimeMid7("movie_optimus_prime_mid7_boots",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    
                    new MovieOptimusPrimeMid8("movie_optimus_prime_mid8_helmet",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new MovieOptimusPrimeMid8("movie_optimus_prime_mid8_chestplate",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new MovieOptimusPrimeMid8("movie_optimus_prime_mid8_leggings",  MOVIE_OPTIMUS_PRIME_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new MovieOptimusPrimeMid8("movie_optimus_prime_mid8_boots",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    
                    new MovieOptimusPrimeMid9("movie_optimus_prime_mid9_helmet",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new MovieOptimusPrimeMid9("movie_optimus_prime_mid9_chestplate",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new MovieOptimusPrimeMid9("movie_optimus_prime_mid9_leggings",  MOVIE_OPTIMUS_PRIME_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new MovieOptimusPrimeMid9("movie_optimus_prime_mid9_boots",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    
                 //Starscream
                    new Starscream("starscream_helmet",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new Starscream("starscream_chestplate",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new Starscream("starscream_leggings",  STARSCREAM_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new Starscream("starscream_boots",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

                    new StarscreamMid1("starscream_mid1_helmet",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new StarscreamMid1("starscream_mid1_chestplate",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new StarscreamMid1("starscream_mid1_leggings",  STARSCREAM_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new StarscreamMid1("starscream_mid1_boots",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

                    new StarscreamMid2("starscream_mid2_helmet",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new StarscreamMid2("starscream_mid2_chestplate",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new StarscreamMid2("starscream_mid2_leggings",  STARSCREAM_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new StarscreamMid2("starscream_mid2_boots",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

                    new StarscreamMid3("starscream_mid3_helmet",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new StarscreamMid3("starscream_mid3_chestplate",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new StarscreamMid3("starscream_mid3_leggings",  STARSCREAM_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new StarscreamMid3("starscream_mid3_boots",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

                    new StarscreamAltmode("starscream_altmode_helmet",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new StarscreamAltmode("starscream_altmode_chestplate",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new StarscreamAltmode("starscream_altmode_leggings",  STARSCREAM_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new StarscreamAltmode("starscream_altmode_boots",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

                    new StarscreamMid4("starscream_mid4_helmet",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new StarscreamMid4("starscream_mid4_chestplate",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new StarscreamMid4("starscream_mid4_leggings",  STARSCREAM_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new StarscreamMid4("starscream_mid4_boots",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

                    new StarscreamMid5("starscream_mid5_helmet",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new StarscreamMid5("starscream_mid5_chestplate",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new StarscreamMid5("starscream_mid5_leggings",  STARSCREAM_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new StarscreamMid5("starscream_mid5_boots",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

                    new StarscreamMid6("starscream_mid6_helmet",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new StarscreamMid6("starscream_mid6_chestplate",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new StarscreamMid6("starscream_mid6_leggings",  STARSCREAM_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new StarscreamMid6("starscream_mid6_boots",  STARSCREAM_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    
                  //Skywarp
                    new Starscream("skywarp_helmet",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new Starscream("skywarp_chestplate",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new Starscream("skywarp_leggings",  SKYWARP_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new Starscream("skywarp_boots",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

                    new StarscreamMid1("skywarp_mid1_helmet",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new StarscreamMid1("skywarp_mid1_chestplate",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new StarscreamMid1("skywarp_mid1_leggings",  SKYWARP_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new StarscreamMid1("skywarp_mid1_boots",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

                    new StarscreamMid2("skywarp_mid2_helmet",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new StarscreamMid2("skywarp_mid2_chestplate",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new StarscreamMid2("skywarp_mid2_leggings",  SKYWARP_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new StarscreamMid2("skywarp_mid2_boots",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

                    new StarscreamMid3("skywarp_mid3_helmet",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new StarscreamMid3("skywarp_mid3_chestplate",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new StarscreamMid3("skywarp_mid3_leggings",  SKYWARP_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new StarscreamMid3("skywarp_mid3_boots",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

                    new StarscreamAltmode("skywarp_altmode_helmet",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new StarscreamAltmode("skywarp_altmode_chestplate",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new StarscreamAltmode("skywarp_altmode_leggings",  SKYWARP_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new StarscreamAltmode("skywarp_altmode_boots",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

                    new StarscreamMid4("skywarp_mid4_helmet",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new StarscreamMid4("skywarp_mid4_chestplate",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new StarscreamMid4("skywarp_mid4_leggings",  SKYWARP_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new StarscreamMid4("skywarp_mid4_boots",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

                    new StarscreamMid5("skywarp_mid5_helmet",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new StarscreamMid5("skywarp_mid5_chestplate",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new StarscreamMid5("skywarp_mid5_leggings",  SKYWARP_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new StarscreamMid5("skywarp_mid5_boots",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

                    new StarscreamMid6("skywarp_mid6_helmet",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new StarscreamMid6("skywarp_mid6_chestplate",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new StarscreamMid6("skywarp_mid6_leggings",  SKYWARP_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new StarscreamMid6("skywarp_mid6_boots",  SKYWARP_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    
                  //Thundercraker
                    new Starscream("thundercracker_helmet",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new Starscream("thundercracker_chestplate",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new Starscream("thundercracker_leggings",  THUNDERCRACKER_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new Starscream("thundercracker_boots",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

                    new StarscreamMid1("thundercracker_mid1_helmet",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new StarscreamMid1("thundercracker_mid1_chestplate",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new StarscreamMid1("thundercracker_mid1_leggings",  THUNDERCRACKER_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new StarscreamMid1("thundercracker_mid1_boots",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

                    new StarscreamMid2("thundercracker_mid2_helmet",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new StarscreamMid2("thundercracker_mid2_chestplate",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new StarscreamMid2("thundercracker_mid2_leggings",  THUNDERCRACKER_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new StarscreamMid2("thundercracker_mid2_boots",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

                    new StarscreamMid3("thundercracker_mid3_helmet",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new StarscreamMid3("thundercracker_mid3_chestplate",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new StarscreamMid3("thundercracker_mid3_leggings",  THUNDERCRACKER_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new StarscreamMid3("thundercracker_mid3_boots",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

                    new StarscreamAltmode("thundercracker_altmode_helmet",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new StarscreamAltmode("thundercracker_altmode_chestplate",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new StarscreamAltmode("thundercracker_altmode_leggings",  THUNDERCRACKER_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new StarscreamAltmode("thundercracker_altmode_boots",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

                    new StarscreamMid4("thundercracker_mid4_helmet",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new StarscreamMid4("thundercracker_mid4_chestplate",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new StarscreamMid4("thundercracker_mid4_leggings",  THUNDERCRACKER_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new StarscreamMid4("thundercracker_mid4_boots",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

                    new StarscreamMid5("thundercracker_mid5_helmet",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new StarscreamMid5("thundercracker_mid5_chestplate",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new StarscreamMid5("thundercracker_mid5_leggings",  THUNDERCRACKER_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new StarscreamMid5("thundercracker_mid5_boots",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),

                    new StarscreamMid6("thundercracker_mid6_helmet",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new StarscreamMid6("thundercracker_mid6_chestplate",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new StarscreamMid6("thundercracker_mid6_leggings",  THUNDERCRACKER_MODEL_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new StarscreamMid6("thundercracker_mid6_boots",  THUNDERCRACKER_MODEL_MATERIAL, 1, EntityEquipmentSlot.FEET),  
                    
                  //Vurp
                    new Vurp("vurp_helmet", VURP_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new Vurp("vurp_chestplate", VURP_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new Vurp("vurp_leggings", VURP_MATERIAL, 1, EntityEquipmentSlot.LEGS),
                    new Vurp("vurp_boots", VURP_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    
            };
            event.getRegistry().registerAll(items);
            event.getRegistry().registerAll(ITEM_BLOCKS.toArray(new ItemBlock[ITEM_BLOCKS.size()]));
           
            ITEM_BLOCKS = null;

//            event.getRegistry().registerAll(com.marctron.transformersmod.init.ModItems.ITEMS.toArray(new Item[0]));
        }

        @SubscribeEvent
        public static void onBlockRegister(RegistryEvent.Register<Block> event) {
            final Block[] blocks = {
            		new ItemSpawner("item_spawner", Material.IRON, SoundType.METAL, MapColor.BLUE),
            		
            		new EnergoncubeBlock("energon_cube_block", Material.IRON).setHardness(3),
            	    new EnergoncubeBlock("red_energon_cube_block", Material.IRON).setHardness(3),
            	    new EnergoncubeBlock("blue_energon_cube_block", Material.IRON).setHardness(3),
            	    new EnergoncubeBlock("dark_energon_cube_block", Material.IRON).setHardness(3),
            	    new EnergoncubeBlock("synthetic_energon_cube_block", Material.IRON).setHardness(3),
            	    
            	    new EnergonoreBlock("energon_ore_block", Material.IRON, true).setHardness(3),
            	    new RedEnergonoreBlock("red_energon_ore_block", Material.IRON, true).setHardness(3),
            	    new BlueEnergonoreBlock("blue_energon_ore_block", Material.IRON, true).setHardness(3),
            	    new DarkEnergonoreBlock("dark_energon_ore_block", Material.IRON, true).setHardness(3),
            	    new RedEnergonoreBlock("red_energon_ore_block_netherrack", Material.IRON, true).setHardness(3),
            	    new DarkEnergonoreBlock("dark_energon_ore_block_end_stone", Material.IRON, true).setHardness(3),

            	    new BlockBase("transformium_block", Material.IRON).setHardness(3).setHardness(3),
            	    new TransformiumoreBlock("transformium_ore_block", Material.IRON).setHardness(3),

            	    new BlockEnergonCrate("energon_crate_block").setHardness(3),
            	    
            	   new BlockBase("space_bridge_block", Material.IRON).setHardness(3),

            	    //Machinery 
//            	    new BlockEnergonEngine("energon_engine", Material.IRON).setHardness(3),
//            	    new BlockEnergonStorage("energon_storage", Material.IRON).setHardness(3),
//            	    new BlockCreativeGenerator("creative_engine", Material.IRON).setHardness(3),

            	//Dyed Stuff

            	    //Wool
            	    new BlockBase("wool_pale_green", Material.CLOTH).setHardness(3),
            	    new BlockBase("wool_pale_brown", Material.CLOTH).setHardness(3),
            	    new BlockBase("wool_dark_red", Material.CLOTH).setHardness(3),
            	    new BlockBase("wool_dark_gray", Material.CLOTH).setHardness(3),
            	    new BlockBase("wool_beige", Material.CLOTH).setHardness(3),

            	    //Glass
            	    new BlockGlassBase("stained_glass_pale_green", Material.GLASS, false).setHardness(3),
            	    new BlockGlassBase("stained_glass_pale_brown", Material.GLASS, false).setHardness(3),
            	    new BlockGlassBase("stained_glass_dark_red", Material.GLASS, false).setHardness(3),
            	    new BlockGlassBase("stained_glass_dark_gray", Material.GLASS, false).setHardness(3),
            	    new BlockGlassBase("stained_glass_beige", Material.GLASS, false).setHardness(3),

            	    //Clay
            	    new BlockBase("stained_hardened_clay_pale_green", Material.CLAY).setHardness(3),
            	    new BlockBase("stained_hardened_clay_pale_brown", Material.CLAY).setHardness(3),
            	    new BlockBase("stained_hardened_clay_dark_red", Material.CLAY).setHardness(3),
            	    new BlockBase("stained_hardened_clay_dark_gray", Material.CLAY).setHardness(3),
            	    new BlockBase("stained_hardened_clay_beige", Material.CLAY).setHardness(3),
            		
            		
            };
            
            event.getRegistry().registerAll(blocks);
//            event.getRegistry().registerAll(com.marctron.transformersmod.init.ModBlocks.BLOCKS.toArray(new Block[0]));
            TileEntityHandler.registerTileEntities();
        }
        
        

        @SubscribeEvent
        public static void entityRegistry(RegistryEvent.Register<EntityEntry> e) {
            final EntityEntry[] entry = {
            		registerProjectile("rocket", EntityLargeRocket.class, Reference.ENTITY_LARGE_ROCKET),
                    registerProjectile("bullet", EntityBullet.class, Reference.ENTITY_BULLET),
            		registerEntity("vehicon", EntityVehicon.class, Reference.ENTITY_VEHICON, 1, true, 000000, 660066),
            		registerEntity("swindle", EntitySwindle.class, Reference.ENTITY_SWINDLE, 1, true, 8983288, 16043109),
                    
            };
            // use
            e.getRegistry().registerAll(entry);
        }
        
        public static void registerItemBlock(Block block) {
            ItemBlock itemBlock = new ItemBlock(block);
            itemBlock.setRegistryName(block.getRegistryName());
            try {
                ITEM_BLOCKS.add(itemBlock);
            } catch (NullPointerException e) {
                Main.logger.fatal("Attempted to register itemblock for {} after PMC registration was complete!", block.getRegistryName());
            }
        }
        
        public static EntityEntry registerProjectile(String name, Class<? extends Entity> entity, int id) {
			return createEntityBuilder(name).entity(entity).build();
//            EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, 64, 1, true);
        }
        
        private static EntityEntry registerEntity(String name, Class<? extends Entity> cl, int trackRange, int frequency, boolean velocityUpdates) {
            return createEntityBuilder(name).entity(cl).tracker(trackRange, frequency, velocityUpdates).build();
        }

        private static EntityEntry registerEntity(String name, Class<? extends Entity> entityClass, int trackingRange, int updateFrequency, boolean sendVelocityUpdates, int eggPrimary, int eggSecondary) {
            return createEntityBuilder(name).entity(entityClass).tracker(trackingRange, updateFrequency, sendVelocityUpdates).egg(eggPrimary, eggSecondary).build();
        }
    
        private static <E extends Entity> EntityEntryBuilder<E> createEntityBuilder(String name) {
        	EntityEntryBuilder<E> builder = EntityEntryBuilder.create();
        	ResourceLocation regName = new ResourceLocation(Reference.MOD_ID, name);
        	return builder.id(regName, ID()).name(regName.toString());
    	}
    
    	private static int ID() {
        	++entityID;
        	return entityID;
    	}
    }

    
    
    
    
    @Mod.EventBusSubscriber(Side.CLIENT)
    public static class ModelRegistry {
        @SubscribeEvent
        public static void onModelRegister(ModelRegistryEvent event) {
            ForgeRegistries.BLOCKS.getValuesCollection().stream().filter(block -> block.getRegistryName().getResourceDomain().equals(Reference.MOD_ID))
                    .forEach(block -> {
                        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
                    });

            ForgeRegistries.ITEMS.getValuesCollection().stream().filter(item -> item.getRegistryName().getResourceDomain().equals(Reference.MOD_ID))
                    .forEach(item -> {
                        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
                    });
        }
    }
}