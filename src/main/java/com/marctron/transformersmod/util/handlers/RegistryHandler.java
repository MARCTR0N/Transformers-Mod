package com.marctron.transformersmod.util.handlers;

import java.util.ArrayList;
import java.util.List;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.blocks.*;
import com.marctron.transformersmod.blocks.assembler.BlockAssembler;
import com.marctron.transformersmod.client.modelloaders.bbmodel.BBGunLoader;
import com.marctron.transformersmod.entity.EntityBullet;
import com.marctron.transformersmod.entity.EntityDecepticonBrute;
import com.marctron.transformersmod.entity.EntityDecepticonVehiconVariant1;
import com.marctron.transformersmod.entity.EntityDecepticonVehiconVariant2;
import com.marctron.transformersmod.entity.EntityLargeRocket;
import com.marctron.transformersmod.entity.EntitySwindle;
import com.marctron.transformersmod.entity.EntityVehicon;
import com.marctron.transformersmod.init.ModPotionTypes;
import com.marctron.transformersmod.items.ACHILLESA4;
import com.marctron.transformersmod.items.DARKSTARSABER;
import com.marctron.transformersmod.items.ItemBase;
import com.marctron.transformersmod.items.ItemEnergonMug;
import com.marctron.transformersmod.items.ItemEnergonMugDark;
import com.marctron.transformersmod.items.ItemEnergonMugRed;
import com.marctron.transformersmod.items.ItemEnergonMugSynthetic;
import com.marctron.transformersmod.items.ItemHammer;
import com.marctron.transformersmod.items.ItemMedkit;
import com.marctron.transformersmod.items.ItemPhaseShifter;
import com.marctron.transformersmod.items.ItemStarSaber;
import com.marctron.transformersmod.items.M1_GARAND_FULL;
import com.marctron.transformersmod.items.gun.AmmoClip;
import com.marctron.transformersmod.items.gun.EMPShotgun;
import com.marctron.transformersmod.items.gun.EnergonBattlePistol;
import com.marctron.transformersmod.items.gun.NeutronRepeater;
import com.marctron.transformersmod.items.gun.RocketLauncher;
import com.marctron.transformersmod.items.gun.ScatterBlaster;
import com.marctron.transformersmod.items.gun.Scrapper;
import com.marctron.transformersmod.transformers.transformer.ItemArmorTransformer;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeAltmode;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeAltmode2;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeBack1;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeBack2;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeBack3;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeBack4;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeBack5;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeBack6;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeBack7;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeBack8;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeBack9;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeMid1;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeMid2;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeMid3;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeMid4;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeMid5;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeMid6;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeMid7;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeMid8;
import com.marctron.transformersmod.transformers.transformer.movieop.MovieOptimusPrimeMid9;
import com.marctron.transformersmod.transformers.transformer.movieop.stealth.MovieOptimusPrimeAltmodeWeaponized;
import com.marctron.transformersmod.transformers.transformer.movieop.stealth.MovieOptimusPrimeAltmodeWeaponizedMid1;
import com.marctron.transformersmod.transformers.transformer.movieop.stealth.MovieOptimusPrimeAltmodeWeaponizedMid2;
import com.marctron.transformersmod.transformers.transformer.movieop.stealth.MovieOptimusPrimeAltmodeWeaponizedMid3;
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
import com.marctron.transformersmod.transformers.transformer.subwoofer.Subwoofer1;
import com.marctron.transformersmod.transformers.transformer.subwoofer.Subwoofer2;
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
import com.marctron.transformersmod.transformers.transformer.tfp.megatron.TFPMegatron;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.TFPMagnusAltmode;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.TFPUltraMagnus;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid1;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid10;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid11;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid12;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid13;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid14;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid15;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid16;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid17;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid18;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid19;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid2;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid20;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid21;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid22;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid3;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid4;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid5;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid6;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid7;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid8;
import com.marctron.transformersmod.transformers.transformer.tfp.ultramagnus.transformation.TFPMagnusMid9;
import com.marctron.transformersmod.transformers.transformer.vehicon.ArmorModelVehicon;
import com.marctron.transformersmod.transformers.transformer.vehicon.VehiconAltmode;
import com.marctron.transformersmod.transformers.transformer.vehicon.VehiconMid;
import com.marctron.transformersmod.transformers.transformer.vehicon.VehiconMid2;
import com.marctron.transformersmod.transformers.transformer.vurp.Vurp;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.Menasor;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.breakdown.BreakdownBody;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.breakdown.BreakdownLeftArm;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.breakdown.BreakdownRightArm;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.deadend.Deadend;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.dragstrip.Dragstrip;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.motormaster.Motormaster;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.motormaster.MotormasterAltmode;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.motormaster.transformation.MotormasterMid1;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.motormaster.transformation.MotormasterMid10;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.motormaster.transformation.MotormasterMid11;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.motormaster.transformation.MotormasterMid12;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.motormaster.transformation.MotormasterMid13;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.motormaster.transformation.MotormasterMid14;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.motormaster.transformation.MotormasterMid15;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.motormaster.transformation.MotormasterMid2;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.motormaster.transformation.MotormasterMid3;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.motormaster.transformation.MotormasterMid4;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.motormaster.transformation.MotormasterMid5;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.motormaster.transformation.MotormasterMid6;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.motormaster.transformation.MotormasterMid7;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.motormaster.transformation.MotormasterMid8;
import com.marctron.transformersmod.transformers.transformer.wfc.stunticons.motormaster.transformation.MotormasterMid9;
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
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class RegistryHandler {
	
	
	
	
	//Tools
    public static final ToolMaterial GUN_MATERIAL = EnumHelper.addToolMaterial("gun", 0, 1000, 2.0F, 0, 0);
    public static final ToolMaterial SWORD_MATERIAL = EnumHelper.addToolMaterial("sword", 0, 1000, 2.0F, 4, 0);

    //Armor
    
    		//WFC
    		public static final ArmorMaterial BREAKDOWN_MATERIAL = EnumHelper.addArmorMaterial("breakdown_model", Reference.MOD_ID + ":breakdown_model", 10, new int[]{3, 3, 3, 3}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);
    		
    		public static final ArmorMaterial DRAGSTRIP_MATERIAL = EnumHelper.addArmorMaterial("dragstrip_model", Reference.MOD_ID + ":dragstrip_model", 10, new int[]{3, 3, 3, 3}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);

    		public static final ArmorMaterial DEADEND_MATERIAL = EnumHelper.addArmorMaterial("deadend_model", Reference.MOD_ID + ":deadend_model", 10, new int[]{3, 3, 3, 3}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);

    		public static final ArmorMaterial MOTORMASTER_MATERIAL = EnumHelper.addArmorMaterial("motormaster_model", Reference.MOD_ID + ":motormaster_model", 10, new int[]{3, 3, 3, 3}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);

    		public static final ArmorMaterial MENASOR_MATERIAL = EnumHelper.addArmorMaterial("menasor_model", Reference.MOD_ID + ":menasor_model", 10, new int[]{3, 3, 3, 3}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);

    		
    public static final ArmorMaterial CUSTOM_MODEL_MATERIAL = EnumHelper.addArmorMaterial("custom_model", Reference.MOD_ID + ":custom_model", 10, new int[]{3, 3, 3, 3}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);

    public static final ArmorMaterial VURP_MATERIAL = EnumHelper.addArmorMaterial("vurp_model", Reference.MOD_ID + ":vurp_model", 10, new int[]{3, 3, 3, 3}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);
    public static final ArmorMaterial SUBWOOFER_MATERIAL = EnumHelper.addArmorMaterial("subwoofer_model", Reference.MOD_ID + ":subwoofer_model", 10, new int[]{3, 3, 3, 3}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);

    public static final ArmorMaterial TARN_MODEL_MATERIAL = EnumHelper.addArmorMaterial("tarn_model", Reference.MOD_ID + ":tarn_model", 20, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);
    public static final ArmorMaterial TARN2_MODEL_MATERIAL = EnumHelper.addArmorMaterial("tarn2_model", Reference.MOD_ID + ":tarn2_model", 20, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);
    public static final ArmorMaterial TARN_ALTMODE_MATERIAL = EnumHelper.addArmorMaterial("tarn_altmode_model", Reference.MOD_ID + ":tarn_altmode_model", 20, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);


    public static final ArmorMaterial STARSCREAM_MODEL_MATERIAL = EnumHelper.addArmorMaterial("starscream_model", Reference.MOD_ID + ":starscream_model", 20, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);

    public static final ArmorMaterial MOVIE_OPTIMUS_PRIME_MATERIAL = EnumHelper.addArmorMaterial("movie_optimus_prime_model", Reference.MOD_ID + ":movie_optimus_prime_model", 1000, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);


    public static final ArmorMaterial SKYWARP_MODEL_MATERIAL = EnumHelper.addArmorMaterial("skywarp_model", Reference.MOD_ID + ":skywarp_model", 20, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);

    public static final ArmorMaterial THUNDERCRACKER_MODEL_MATERIAL = EnumHelper.addArmorMaterial("thundercracker_model", Reference.MOD_ID + ":thundercracker_model", 20, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);

    public static final ArmorMaterial SIDESWIPE_MODEL_MATERIAL = EnumHelper.addArmorMaterial("sideswipe_model", Reference.MOD_ID + ":sideswipe_model", 20, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);

    public static final ArmorMaterial IRONHIDE_MATERIAL = EnumHelper.addArmorMaterial("ironhide_model", Reference.MOD_ID + ":ironhide_model", 20, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);
    
    public static final ArmorMaterial MAGNUS_MATERIAL = EnumHelper.addArmorMaterial("magnus_model", Reference.MOD_ID + ":magnus_model", 20, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);

    public static final ArmorMaterial MEGATRON_MATERIAL = EnumHelper.addArmorMaterial("megatron_model", Reference.MOD_ID + ":megatron_model", 20, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);


    //Armor Altmode
    public static final ArmorMaterial VEHICON_ALTMODE_MATERIAL = EnumHelper.addArmorMaterial("vehicon_altmode_model", Reference.MOD_ID + ":vehicon_altmode_model", 20, new int[]{5, 5, 5, 5}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);

    public static final ArmorMaterial SIDESWIPE_ALTMODE_MATERIAL = EnumHelper.addArmorMaterial("sideswipe_altmode_model", Reference.MOD_ID + ":sideswipe_altmode_model", 20, new int[]{5, 5, 5, 5}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);

    public static final ArmorMaterial SKYWARP_ALTMODE_MATERIAL = EnumHelper.addArmorMaterial("skywarp_altmode_model", Reference.MOD_ID + ":skywarp_altmode_model", 20, new int[]{7, 8, 8, 9}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F);
	
	
	

    @GameRegistry.ObjectHolder(Reference.MOD_ID)
    public static final class ModItems {
    	
      //BB
    	public static final Item M1_GARAND_FULL =null;
    	
      //Relics
    	public static final Item PHASE_SHIFTER = null;
    	public static final Item STAR_SABER = null;
    	
    	public static final ItemHammer Hammer = null;
    	
      //TabIcons
    	public static final Item AMMO = null;
    	public static final Item ENERGON_CRYSTAL = null;
    	
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
        public static final Item AUTOBOT_INSGINIA = null;
        public static final Item DECEPTICON_INSGINIA = null;
        public static final Item A_I = null;
        public static final Item D_I = null;
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
    	
        
      //TFP Megatron
        public static final ItemArmorTransformer TFPMEGATRON_HELMET = null;
        public static final ItemArmorTransformer TFPMEGATRON_CHESTPLATE = null;
        public static final ItemArmorTransformer TFPMEGATRON_LEGGINGS = null;
        public static final ItemArmorTransformer TFPMEGATRON_BOOTS = null;
        
      //Breakdown
        public static final ItemArmorTransformer BREAKDOWN_HELMET = null;
        public static final ItemArmorTransformer BREAKDOWN_CHESTPLATE = null;
        public static final ItemArmorTransformer BREAKDOWN_LEGGINGS = null;
        public static final ItemArmorTransformer BREAKDOWN_BOOTS = null;
        
      //Dragstrip
        public static final ItemArmorTransformer DRAGSTRIP_HELMET = null;
        public static final ItemArmorTransformer DRAGSTRIP_CHESTPLATE = null;
        public static final ItemArmorTransformer DRAGSTRIP_LEGGINGS = null;
        public static final ItemArmorTransformer DRAGSTRIP_BOOTS = null;
        
      //Deadend
        public static final ItemArmorTransformer DEADEND_HELMET = null;
        public static final ItemArmorTransformer DEADEND_CHESTPLATE = null;
        public static final ItemArmorTransformer DEADEND_LEGGINGS = null;
        public static final ItemArmorTransformer DEADEND_BOOTS = null;
        
      //Motormaster
        public static final ItemArmorTransformer MOTORMASTER_HELMET = null;
        public static final ItemArmorTransformer MOTORMASTER_CHESTPLATE = null;
        public static final ItemArmorTransformer MOTORMASTER_LEGGINGS = null;
        public static final ItemArmorTransformer MOTORMASTER_BOOTS = null;
        
        	//transformation
        	public static final ItemArmorTransformer MOTORMASTER_HELMET_MID1 = null;
        	public static final ItemArmorTransformer MOTORMASTER_CHESTPLATE_MID1 = null;
        	public static final ItemArmorTransformer MOTORMASTER_LEGGINGS_MID1 = null;
        	public static final ItemArmorTransformer MOTORMASTER_BOOTS_MID1 = null;
        	
        	public static final ItemArmorTransformer MOTORMASTER_HELMET_MID2 = null;
        	public static final ItemArmorTransformer MOTORMASTER_CHESTPLATE_MID2 = null;
        	public static final ItemArmorTransformer MOTORMASTER_LEGGINGS_MID2 = null;
        	public static final ItemArmorTransformer MOTORMASTER_BOOTS_MID2 = null;
        	
        	public static final ItemArmorTransformer MOTORMASTER_HELMET_MID3 = null;
        	public static final ItemArmorTransformer MOTORMASTER_CHESTPLATE_MID3 = null;
        	public static final ItemArmorTransformer MOTORMASTER_LEGGINGS_MID3 = null;
        	public static final ItemArmorTransformer MOTORMASTER_BOOTS_MID3 = null;
        	
        	public static final ItemArmorTransformer MOTORMASTER_HELMET_MID4 = null;
        	public static final ItemArmorTransformer MOTORMASTER_CHESTPLATE_MID4 = null;
        	public static final ItemArmorTransformer MOTORMASTER_LEGGINGS_MID4 = null;
        	public static final ItemArmorTransformer MOTORMASTER_BOOTS_MID4 = null;
        	
        	public static final ItemArmorTransformer MOTORMASTER_HELMET_MID5 = null;
        	public static final ItemArmorTransformer MOTORMASTER_CHESTPLATE_MID5 = null;
        	public static final ItemArmorTransformer MOTORMASTER_LEGGINGS_MID5 = null;
        	public static final ItemArmorTransformer MOTORMASTER_BOOTS_MID5 = null;
        	
        	public static final ItemArmorTransformer MOTORMASTER_HELMET_MID6 = null;
        	public static final ItemArmorTransformer MOTORMASTER_CHESTPLATE_MID6 = null;
        	public static final ItemArmorTransformer MOTORMASTER_LEGGINGS_MID6 = null;
        	public static final ItemArmorTransformer MOTORMASTER_BOOTS_MID6 = null;
        	
        	public static final ItemArmorTransformer MOTORMASTER_HELMET_MID7 = null;
        	public static final ItemArmorTransformer MOTORMASTER_CHESTPLATE_MID7 = null;
        	public static final ItemArmorTransformer MOTORMASTER_LEGGINGS_MID7 = null;
        	public static final ItemArmorTransformer MOTORMASTER_BOOTS_MID7 = null;
        	
        	public static final ItemArmorTransformer MOTORMASTER_HELMET_MID8 = null;
        	public static final ItemArmorTransformer MOTORMASTER_CHESTPLATE_MID8 = null;
        	public static final ItemArmorTransformer MOTORMASTER_LEGGINGS_MID8 = null;
        	public static final ItemArmorTransformer MOTORMASTER_BOOTS_MID8 = null;
        	
        	public static final ItemArmorTransformer MOTORMASTER_HELMET_MID9 = null;
        	public static final ItemArmorTransformer MOTORMASTER_CHESTPLATE_MID9 = null;
        	public static final ItemArmorTransformer MOTORMASTER_LEGGINGS_MID9 = null;
        	public static final ItemArmorTransformer MOTORMASTER_BOOTS_MID9 = null;
        	
         	public static final ItemArmorTransformer MOTORMASTER_HELMET_MID10 = null;
        	public static final ItemArmorTransformer MOTORMASTER_CHESTPLATE_MID10 = null;
        	public static final ItemArmorTransformer MOTORMASTER_LEGGINGS_MID10 = null;
        	public static final ItemArmorTransformer MOTORMASTER_BOOTS_MID10 = null;
        	
        	public static final ItemArmorTransformer MOTORMASTER_HELMET_MID11 = null;
        	public static final ItemArmorTransformer MOTORMASTER_CHESTPLATE_MID11 = null;
        	public static final ItemArmorTransformer MOTORMASTER_LEGGINGS_MID11 = null;
        	public static final ItemArmorTransformer MOTORMASTER_BOOTS_MID11 = null;
        	
        	public static final ItemArmorTransformer MOTORMASTER_HELMET_MID12 = null;
        	public static final ItemArmorTransformer MOTORMASTER_CHESTPLATE_MID12 = null;
        	public static final ItemArmorTransformer MOTORMASTER_LEGGINGS_MID12 = null;
        	public static final ItemArmorTransformer MOTORMASTER_BOOTS_MID12 = null;
        	
        	public static final ItemArmorTransformer MOTORMASTER_HELMET_MID13 = null;
        	public static final ItemArmorTransformer MOTORMASTER_CHESTPLATE_MID13 = null;
        	public static final ItemArmorTransformer MOTORMASTER_LEGGINGS_MID13 = null;
        	public static final ItemArmorTransformer MOTORMASTER_BOOTS_MID13 = null;
        	
        	public static final ItemArmorTransformer MOTORMASTER_HELMET_MID14 = null;
        	public static final ItemArmorTransformer MOTORMASTER_CHESTPLATE_MID14 = null;
        	public static final ItemArmorTransformer MOTORMASTER_LEGGINGS_MID14 = null;
        	public static final ItemArmorTransformer MOTORMASTER_BOOTS_MID14 = null;
        	
        	public static final ItemArmorTransformer MOTORMASTER_HELMET_MID15 = null;
        	public static final ItemArmorTransformer MOTORMASTER_CHESTPLATE_MID15 = null;
        	public static final ItemArmorTransformer MOTORMASTER_LEGGINGS_MID15 = null;
        	public static final ItemArmorTransformer MOTORMASTER_BOOTS_MID15 = null;
        	
        	//Altmode
        	public static final ItemArmorTransformer MOTORMASTER_HELMET_ALTMODE = null;
        	public static final ItemArmorTransformer MOTORMASTER_CHESTPLATE_ALTMODE = null;
        	public static final ItemArmorTransformer MOTORMASTER_LEGGINGS_ALTMODE = null;
        	public static final ItemArmorTransformer MOTORMASTER_BOOTS_ALTMODE = null;
        	
        
      //Menasor
        public static final ItemArmorTransformer MENASOR_HELMET = null;
        public static final ItemArmorTransformer MENASOR_CHESTPLATE = null;
        public static final ItemArmorTransformer MENASOR_LEGGINGS = null;
        public static final ItemArmorTransformer MENASOR_BOOTS = null;
        
        
      //Vurp
        public static final ItemArmorTransformer VURP_HELMET = null;
        public static final ItemArmorTransformer VURP_CHESTPLATE = null;
        public static final ItemArmorTransformer VURP_LEGGINGS = null;
        public static final ItemArmorTransformer VURP_BOOTS = null;
        
      //Subwoofer
        public static final ItemArmorTransformer SUBWOOFER_HELMET = null;
        public static final ItemArmorTransformer SUBWOOFER_CHESTPLATE = null;
        public static final ItemArmorTransformer SUBWOOFER_LEGGINGS = null;
        public static final ItemArmorTransformer SUBWOOFER_BOOTS = null;
        
      //TFP Ultra Magnus
        public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET = null;
        public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE = null;
        public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS = null;
        public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS = null;
        	//transformation
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID1 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID1 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID1 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID1 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID2 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID2 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID2 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID2 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID3 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID3 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID3 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID3 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID4 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID4 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID4 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID4 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID5 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID5 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID5 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID5 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID6 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID6 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID6 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID6 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID7 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID7 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID7 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID7 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID8 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID8 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID8 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID8 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID9 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID9 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID9 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID9 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID10 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID10 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID10 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID10 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID11 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID11 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID11 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID11 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID12 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID12 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID12 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID12 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID13 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID13 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID13 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID13 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID14 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID14 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID14 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID14 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID15 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID15 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID15 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID15 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID16 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID16 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID16 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID16 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID17 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID17 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID17 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID17 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID18 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID18 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID18 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID18 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID19 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID19 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID19 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID19 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID20 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID20 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID20 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID20 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID21 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID21 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID21 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID21 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_MID22 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_MID22 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_MID22 = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_MID22 = null;
        		
        		public static final ItemArmorTransformer ULTRA_MAGNUS_HELMET_ALTMODE = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_CHESTPLATE_ALTMODE = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_LEGGINGS_ALTMODE = null;
        		public static final ItemArmorTransformer ULTRA_MAGNUS_BOOTS_ALTMODE = null;
        		
        
      //Sideswipe
        public static final ItemArmorTransformer SIDESWIPE_HELMET = null;
        public static final ItemArmorTransformer SIDESWIPE_CHESTPLATE = null;
        public static final ItemArmorTransformer SIDESWIPE_LEGGINGS = null;
        public static final ItemArmorTransformer SIDESWIPE_BOOTS = null;

        public static final ItemArmorTransformer SIDESWIPE_MID_HELMET = null;
        public static final ItemArmorTransformer SIDESWIPE_MID_CHESTPLATE = null;
        public static final ItemArmorTransformer SIDESWIPE_MID_LEGGINGS = null;
        public static final ItemArmorTransformer SIDESWIPE_MID_BOOTS = null;
        
        public static final ItemArmorTransformer SIDESWIPE_MID2_HELMET = null;
        public static final ItemArmorTransformer SIDESWIPE_MID2_CHESTPLATE = null;
        public static final ItemArmorTransformer SIDESWIPE_MID2_LEGGINGS = null;
        public static final ItemArmorTransformer SIDESWIPE_MID2_BOOTS = null;

        public static final ItemArmorTransformer SIDESWIPE_MID3_HELMET = null;
        public static final ItemArmorTransformer SIDESWIPE_MID3_CHESTPLATE = null;
        public static final ItemArmorTransformer SIDESWIPE_MID3_LEGGINGS = null;
        public static final ItemArmorTransformer SIDESWIPE_MID3_BOOTS = null;

        public static final ItemArmorTransformer SIDESWIPE_MID4_HELMET = null;
        public static final ItemArmorTransformer SIDESWIPE_MID4_CHESTPLATE = null;
        public static final ItemArmorTransformer SIDESWIPE_MID4_LEGGINGS = null;
        public static final ItemArmorTransformer SIDESWIPE_MID4_BOOTS = null;

        public static final ItemArmorTransformer SIDESWIPE_ALTMODE_HELMET = null;
        public static final ItemArmorTransformer SIDESWIPE_ALTMODE_CHESTPLATE = null;
        public static final ItemArmorTransformer SIDESWIPE_ALTMODE_LEGGINGS = null;
        public static final ItemArmorTransformer SIDESWIPE_ALTMODE_BOOTS = null;
        
      //Movie Optimus Prime
        //Stealth
        	public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_HELMET = null;
        	public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_CHESTPLATE = null;
        	public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_LEGGINGS = null;
        	public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_BOOTS = null;
        	
        	public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID1_HELMET = null;
        	public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID1_CHESTPLATE = null;
        	public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID1_LEGGINGS = null;
        	public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID1_BOOTS = null;
        	
        	public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_HELMET = null;
        	public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_CHESTPLATE = null;
        	public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_LEGGINGS = null;
        	public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_BOOTS = null;
        	
        	public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID3_HELMET = null;
        	public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID3_CHESTPLATE = null;
        	public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID3_LEGGINGS = null;
        	public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID3_BOOTS = null;
        
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_HELMET = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_CHESTPLATE = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_LEGGINGS = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_BOOTS = null;
        
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_ALTMODE_HELMET = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_ALTMODE_CHESTPLATE = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_ALTMODE_LEGGINGS = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_ALTMODE_BOOTS = null;
        
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID1_HELMET = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID1_CHESTPLATE = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID1_LEGGINGS = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID1_BOOTS = null;
        
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID2_HELMET = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID2_CHESTPLATE = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID2_LEGGINGS = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID2_BOOTS = null;
        
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID3_HELMET = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID3_CHESTPLATE = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID3_LEGGINGS = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID3_BOOTS = null;
        
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID4_HELMET = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID4_CHESTPLATE = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID4_LEGGINGS = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID4_BOOTS = null;    
        
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID5_HELMET = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID5_CHESTPLATE = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID5_LEGGINGS = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID5_BOOTS = null;
        
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID6_HELMET = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID6_CHESTPLATE = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID6_LEGGINGS = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID6_BOOTS = null;
        
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID7_HELMET = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID7_CHESTPLATE = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID7_LEGGINGS = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID7_BOOTS = null;
        
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID8_HELMET = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID8_CHESTPLATE = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID8_LEGGINGS = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID8_BOOTS = null;
        
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID9_HELMET = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID9_CHESTPLATE = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID9_LEGGINGS = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_MID9_BOOTS = null;
        
        
        
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_BACK1_BOOTS = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_BACK2_BOOTS = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_BACK3_BOOTS = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_BACK4_BOOTS = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_BACK5_BOOTS = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_BACK6_BOOTS = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_BACK7_BOOTS = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_BACK8_BOOTS = null;
        public static final ItemArmorTransformer MOVIE_OPTIMUS_PRIME_BACK9_BOOTS = null;
        
      //Starscream
        public static final ItemArmorTransformer STARSCREAM_HELMET = null;
        public static final ItemArmorTransformer STARSCREAM_CHESTPLATE = null;
        public static final ItemArmorTransformer STARSCREAM_LEGGINGS = null;
        public static final ItemArmorTransformer STARSCREAM_BOOTS = null;

        public static final ItemArmorTransformer STARSCREAM_ALTMODE_HELMET = null;
        public static final ItemArmorTransformer STARSCREAM_ALTMODE_CHESTPLATE = null;
        public static final ItemArmorTransformer STARSCREAM_ALTMODE_LEGGINGS = null;
        public static final ItemArmorTransformer STARSCREAM_ALTMODE_BOOTS = null;
        
        public static final ItemArmorTransformer STARSCREAM_MID1_HELMET = null;
        public static final ItemArmorTransformer STARSCREAM_MID1_CHESTPLATE = null;
        public static final ItemArmorTransformer STARSCREAM_MID1_LEGGINGS = null;
        public static final ItemArmorTransformer STARSCREAM_MID1_BOOTS = null;

        public static final ItemArmorTransformer STARSCREAM_MID2_HELMET = null;
        public static final ItemArmorTransformer STARSCREAM_MID2_CHESTPLATE = null;
        public static final ItemArmorTransformer STARSCREAM_MID2_LEGGINGS = null;
        public static final ItemArmorTransformer STARSCREAM_MID2_BOOTS = null;

        public static final ItemArmorTransformer STARSCREAM_MID3_HELMET = null;
        public static final ItemArmorTransformer STARSCREAM_MID3_CHESTPLATE = null;
        public static final ItemArmorTransformer STARSCREAM_MID3_LEGGINGS = null;
        public static final ItemArmorTransformer STARSCREAM_MID3_BOOTS = null;

        public static final ItemArmorTransformer STARSCREAM_MID4_HELMET = null;
        public static final ItemArmorTransformer STARSCREAM_MID4_CHESTPLATE = null;
        public static final ItemArmorTransformer STARSCREAM_MID4_LEGGINGS = null;
        public static final ItemArmorTransformer STARSCREAM_MID4_BOOTS = null;

        public static final ItemArmorTransformer STARSCREAM_MID5_HELMET = null;
        public static final ItemArmorTransformer STARSCREAM_MID5_CHESTPLATE = null;
        public static final ItemArmorTransformer STARSCREAM_MID5_LEGGINGS = null;
        public static final ItemArmorTransformer STARSCREAM_MID5_BOOTS = null;

        public static final ItemArmorTransformer STARSCREAM_MID6_HELMET = null;
        public static final ItemArmorTransformer STARSCREAM_MID6_CHESTPLATE = null;
        public static final ItemArmorTransformer STARSCREAM_MID6_LEGGINGS = null;
        public static final ItemArmorTransformer STARSCREAM_MID6_BOOTS = null;
        
      //Skywarp
        public static final ItemArmorTransformer SKYWARP_HELMET = null;
        public static final ItemArmorTransformer SKYWARP_CHESTPLATE = null;
        public static final ItemArmorTransformer SKYWARP_LEGGINGS = null;
        public static final ItemArmorTransformer SKYWARP_BOOTS = null;

        public static final ItemArmorTransformer SKYWARP_ALTMODE_HELMET = null;
        public static final ItemArmorTransformer SKYWARP_ALTMODE_CHESTPLATE = null;
        public static final ItemArmorTransformer SKYWARP_ALTMODE_LEGGINGS = null;
        public static final ItemArmorTransformer SKYWARP_ALTMODE_BOOTS = null;
        
        public static final ItemArmorTransformer SKYWARP_MID1_HELMET = null;
        public static final ItemArmorTransformer SKYWARP_MID1_CHESTPLATE = null;
        public static final ItemArmorTransformer SKYWARP_MID1_LEGGINGS = null;
        public static final ItemArmorTransformer SKYWARP_MID1_BOOTS = null;

        public static final ItemArmorTransformer SKYWARP_MID2_HELMET = null;
        public static final ItemArmorTransformer SKYWARP_MID2_CHESTPLATE = null;
        public static final ItemArmorTransformer SKYWARP_MID2_LEGGINGS = null;
        public static final ItemArmorTransformer SKYWARP_MID2_BOOTS = null;

        public static final ItemArmorTransformer SKYWARP_MID3_HELMET = null;
        public static final ItemArmorTransformer SKYWARP_MID3_CHESTPLATE = null;
        public static final ItemArmorTransformer SKYWARP_MID3_LEGGINGS = null;
        public static final ItemArmorTransformer SKYWARP_MID3_BOOTS = null;

        public static final ItemArmorTransformer SKYWARP_MID4_HELMET = null;
        public static final ItemArmorTransformer SKYWARP_MID4_CHESTPLATE = null;
        public static final ItemArmorTransformer SKYWARP_MID4_LEGGINGS = null;
        public static final ItemArmorTransformer SKYWARP_MID4_BOOTS = null;

        public static final ItemArmorTransformer SKYWARP_MID5_HELMET = null;
        public static final ItemArmorTransformer SKYWARP_MID5_CHESTPLATE = null;
        public static final ItemArmorTransformer SKYWARP_MID5_LEGGINGS = null;
        public static final ItemArmorTransformer SKYWARP_MID5_BOOTS = null;

        public static final ItemArmorTransformer SKYWARP_MID6_HELMET = null;
        public static final ItemArmorTransformer SKYWARP_MID6_CHESTPLATE = null;
        public static final ItemArmorTransformer SKYWARP_MID6_LEGGINGS = null;
        public static final ItemArmorTransformer SKYWARP_MID6_BOOTS = null;
        
      //Thundercracker
        public static final ItemArmorTransformer THUNDERCRACKER_HELMET = null;
        public static final ItemArmorTransformer THUNDERCRACKER_CHESTPLATE = null;
        public static final ItemArmorTransformer THUNDERCRACKER_LEGGINGS = null;
        public static final ItemArmorTransformer THUNDERCRACKER_BOOTS = null;

        public static final ItemArmorTransformer THUNDERCRACKER_ALTMODE_HELMET = null;
        public static final ItemArmorTransformer THUNDERCRACKER_ALTMODE_CHESTPLATE = null;
        public static final ItemArmorTransformer THUNDERCRACKER_ALTMODE_LEGGINGS = null;
        public static final ItemArmorTransformer THUNDERCRACKER_ALTMODE_BOOTS = null;
        
        public static final ItemArmorTransformer THUNDERCRACKER_MID1_HELMET = null;
        public static final ItemArmorTransformer THUNDERCRACKER_MID1_CHESTPLATE = null;
        public static final ItemArmorTransformer THUNDERCRACKER_MID1_LEGGINGS = null;
        public static final ItemArmorTransformer THUNDERCRACKER_MID1_BOOTS = null;

        public static final ItemArmorTransformer THUNDERCRACKER_MID2_HELMET = null;
        public static final ItemArmorTransformer THUNDERCRACKER_MID2_CHESTPLATE = null;
        public static final ItemArmorTransformer THUNDERCRACKER_MID2_LEGGINGS = null;
        public static final ItemArmorTransformer THUNDERCRACKER_MID2_BOOTS = null;

        public static final ItemArmorTransformer THUNDERCRACKER_MID3_HELMET = null;
        public static final ItemArmorTransformer THUNDERCRACKER_MID3_CHESTPLATE = null;
        public static final ItemArmorTransformer THUNDERCRACKER_MID3_LEGGINGS = null;
        public static final ItemArmorTransformer THUNDERCRACKER_MID3_BOOTS = null;

        public static final ItemArmorTransformer THUNDERCRACKER_MID4_HELMET = null;
        public static final ItemArmorTransformer THUNDERCRACKER_MID4_CHESTPLATE = null;
        public static final ItemArmorTransformer THUNDERCRACKER_MID4_LEGGINGS = null;
        public static final ItemArmorTransformer THUNDERCRACKER_MID4_BOOTS = null;

        public static final ItemArmorTransformer THUNDERCRACKER_MID5_HELMET = null;
        public static final ItemArmorTransformer THUNDERCRACKER_MID5_CHESTPLATE = null;
        public static final ItemArmorTransformer THUNDERCRACKER_MID5_LEGGINGS = null;
        public static final ItemArmorTransformer THUNDERCRACKER_MID5_BOOTS = null;

        public static final ItemArmorTransformer THUNDERCRACKER_MID6_HELMET = null;
        public static final ItemArmorTransformer THUNDERCRACKER_MID6_CHESTPLATE = null;
        public static final ItemArmorTransformer THUNDERCRACKER_MID6_LEGGINGS = null;
        public static final ItemArmorTransformer THUNDERCRACKER_MID6_BOOTS = null;
        
   	 //Vehicon
	    public static final ItemArmorTransformer CUSTOM_HELMET = null;
	    public static final ItemArmorTransformer CUSTOM_CHESTPLATE = null;
	    public static final ItemArmorTransformer CUSTOM_LEGGINGS = null;
	    public static final ItemArmorTransformer CUSTOM_BOOTS = null;

	    public static final ItemArmorTransformer VEHICON_MID_HELMET = null;
	    public static final ItemArmorTransformer VEHICON_MID_CHESTPLATE = null;
	    public static final ItemArmorTransformer VEHICON_MID_LEGGINGS = null;
	    public static final ItemArmorTransformer VEHICON_MID_BOOTS = null;
	    
	    public static final ItemArmorTransformer VEHICON_MID_2_HELMET = null;
	    public static final ItemArmorTransformer VEHICON_MID_2_CHESTPLATE = null;
	    public static final ItemArmorTransformer VEHICON_MID_2_LEGGINGS = null;
	    public static final ItemArmorTransformer VEHICON_MID_2_BOOTS = null;

	    public static final ItemArmorTransformer VEHICON_ALTMODE_HELMET = null;
	    public static final ItemArmorTransformer VEHICON_ALTMODE_CHESTPLATE = null;
	    public static final ItemArmorTransformer VEHICON_ALTMODE_LEGGINGS = null;
	    public static final ItemArmorTransformer VEHICON_ALTMODE_BOOTS = null;
	    
	  //Tarn
	    public static final ItemArmorTransformer TARN_HELMET = null;
	    public static final ItemArmorTransformer TARN_CHESTPLATE = null;
	    public static final ItemArmorTransformer TARN_LEGGINGS = null;
	    public static final ItemArmorTransformer TARN_BOOTS = null;

	    public static final ItemArmorTransformer TARN_MID1_HELMET = null;
	    public static final ItemArmorTransformer TARN_MID1_CHESTPLATE = null;
	    public static final ItemArmorTransformer TARN_MID1_LEGGINGS = null;
	    public static final ItemArmorTransformer TARN_MID1_BOOTS = null;

	    public static final ItemArmorTransformer TARN_MID2_HELMET = null;
	    public static final ItemArmorTransformer TARN_MID2_CHESTPLATE = null;
	    public static final ItemArmorTransformer TARN_MID2_LEGGINGS = null;
	    public static final ItemArmorTransformer TARN_MID2_BOOTS = null;

	    public static final ItemArmorTransformer TARN_MID3_HELMET = null;
	    public static final ItemArmorTransformer TARN_MID3_CHESTPLATE = null;
	    public static final ItemArmorTransformer TARN_MID3_LEGGINGS = null;
	    public static final ItemArmorTransformer TARN_MID3_BOOTS = null;
	    
	    public static final ItemArmorTransformer TARN_MID4_HELMET = null;
	    public static final ItemArmorTransformer TARN_MID4_CHESTPLATE = null;
	    public static final ItemArmorTransformer TARN_MID4_LEGGINGS = null;
	    public static final ItemArmorTransformer TARN_MID4_BOOTS = null;

	    public static final ItemArmorTransformer TARN_ALTMODE_HELMET = null;
	    public static final ItemArmorTransformer TARN_ALTMODE_CHESTPLATE = null;
	    public static final ItemArmorTransformer TARN_ALTMODE_LEGGINGS = null;
	    public static final ItemArmorTransformer TARN_ALTMODE_BOOTS = null;

	    public static final ItemArmorTransformer TARN_MID5_HELMET = null;
	    public static final ItemArmorTransformer TARN_MID5_CHESTPLATE = null;
	    public static final ItemArmorTransformer TARN_MID5_LEGGINGS = null;
	    public static final ItemArmorTransformer TARN_MID5_BOOTS = null;

	    public static final ItemArmorTransformer TARN_MID6_HELMET = null;
	    public static final ItemArmorTransformer TARN_MID6_CHESTPLATE = null;
	    public static final ItemArmorTransformer TARN_MID6_LEGGINGS = null;
	    public static final ItemArmorTransformer TARN_MID6_BOOTS = null;

	    public static final ItemArmorTransformer TARN_MID7_HELMET = null;
	    public static final ItemArmorTransformer TARN_MID7_CHESTPLATE = null;
	    public static final ItemArmorTransformer TARN_MID7_LEGGINGS = null;
	    public static final ItemArmorTransformer TARN_MID7_BOOTS = null;

	    public static final ItemArmorTransformer TARN_MID8_HELMET = null;
	    public static final ItemArmorTransformer TARN_MID8_CHESTPLATE = null;
	    public static final ItemArmorTransformer TARN_MID8_LEGGINGS = null;
	    public static final ItemArmorTransformer TARN_MID8_BOOTS = null;
	    
	  //Machinery 
	    public static final Item CHIP = null;
	    
	    
	  //OBJ
	    public static final Item ACHILLESA4 = null;
	    public static final Item DARKSTARSABER = null;
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
		public static final Block LOCK_BLOCK = null;
        
        public static final Block ENERGON_ENGINE = null;

        public static final Block ASSEMBLER = null;
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

        		  //OBJ
        			new ACHILLESA4("achillesa4"),
        			new DARKSTARSABER("darkstarsaber"),
        			
        		  //BB
        			new M1_GARAND_FULL("m1_garand_full.bbmodel"),
        			
            		
            	  //Machinery
            		new ItemBase("chip"),
            		
            		
            	  //Relics
            		new ItemStarSaber("star_saber", 200, SWORD_MATERIAL),
            		new ItemPhaseShifter("phase_shifter"),
            		
            		new ItemHammer("hammer", SWORD_MATERIAL, 200),
            		
            	  //TabIcons
            		new ItemBase("ammo"),
            		new ItemBase("energon_crystal"),
            		
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
            	    new ItemBase("a_i"),
            	    new ItemBase("d_i"),
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
            	    
            	    
            	    
            	  //TFP Megatron
            	    new TFPMegatron("tfpmegatron_helmet", MEGATRON_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new TFPMegatron("tfpmegatron_chestplate", MEGATRON_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new TFPMegatron("tfpmegatron_leggings", MEGATRON_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new TFPMegatron("tfpmegatron_boots", MEGATRON_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    
            	    
            	  //Breakdown
            	    new BreakdownBody("breakdown_helmet", BREAKDOWN_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new BreakdownRightArm("breakdown_chestplate", BREAKDOWN_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new BreakdownLeftArm("breakdown_leggings", BREAKDOWN_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new BreakdownBody("breakdown_boots", BREAKDOWN_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    
            	  //Dragstrip
            	    new Dragstrip("dragstrip_helmet", DRAGSTRIP_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new Dragstrip("dragstrip_chestplate", DRAGSTRIP_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new Dragstrip("dragstrip_leggings", DRAGSTRIP_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new Dragstrip("dragstrip_boots", DRAGSTRIP_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    
            	  //Deadend
            	    new Deadend("deadend_helmet", DEADEND_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new Deadend("deadend_chestplate", DEADEND_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new Deadend("deadend_leggings", DEADEND_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new Deadend("deadend_boots", DEADEND_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    
            	  //Menasor
            	    new Menasor("menasor_helmet", MENASOR_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new Menasor("menasor_chestplate", MENASOR_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new Menasor("menasor_leggings", MENASOR_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new Menasor("menasor_boots", MENASOR_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    
            	  //Motormaster
            	    new Motormaster("motormaster_helmet", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new Motormaster("motormaster_chestplate", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new Motormaster("motormaster_leggings", MOTORMASTER_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new Motormaster("motormaster_boots", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    	//transformation
            	    	new MotormasterMid1("motormaster_helmet_mid1", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    	new MotormasterMid1("motormaster_chestplate_mid1", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    	new MotormasterMid1("motormaster_leggings_mid1", MOTORMASTER_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    	new MotormasterMid1("motormaster_boots_mid1", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    	
            	    	new MotormasterMid2("motormaster_helmet_mid2", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    	new MotormasterMid2("motormaster_chestplate_mid2", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    	new MotormasterMid2("motormaster_leggings_mid2", MOTORMASTER_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    	new MotormasterMid2("motormaster_boots_mid2", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    	
            	    	new MotormasterMid3("motormaster_helmet_mid3", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    	new MotormasterMid3("motormaster_chestplate_mid3", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    	new MotormasterMid3("motormaster_leggings_mid3", MOTORMASTER_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    	new MotormasterMid3("motormaster_boots_mid3", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    	
            	    	new MotormasterMid4("motormaster_helmet_mid4", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    	new MotormasterMid4("motormaster_chestplate_mid4", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    	new MotormasterMid4("motormaster_leggings_mid4", MOTORMASTER_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    	new MotormasterMid4("motormaster_boots_mid4", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    	
            	    	new MotormasterMid5("motormaster_helmet_mid5", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    	new MotormasterMid5("motormaster_chestplate_mid5", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    	new MotormasterMid5("motormaster_leggings_mid5", MOTORMASTER_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    	new MotormasterMid5("motormaster_boots_mid5", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    	
            	    	new MotormasterMid6("motormaster_helmet_mid6", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    	new MotormasterMid6("motormaster_chestplate_mid6", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    	new MotormasterMid6("motormaster_leggings_mid6", MOTORMASTER_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    	new MotormasterMid6("motormaster_boots_mid6", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    	
            	    	new MotormasterMid7("motormaster_helmet_mid7", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    	new MotormasterMid7("motormaster_chestplate_mid7", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    	new MotormasterMid7("motormaster_leggings_mid7", MOTORMASTER_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    	new MotormasterMid7("motormaster_boots_mid7", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    	
            	    	new MotormasterMid8("motormaster_helmet_mid8", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    	new MotormasterMid8("motormaster_chestplate_mid8", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    	new MotormasterMid8("motormaster_leggings_mid8", MOTORMASTER_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    	new MotormasterMid8("motormaster_boots_mid8", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    	
            	    	new MotormasterMid9("motormaster_helmet_mid9", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    	new MotormasterMid9("motormaster_chestplate_mid9", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    	new MotormasterMid9("motormaster_leggings_mid9", MOTORMASTER_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    	new MotormasterMid9("motormaster_boots_mid9", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    	
            	    	new MotormasterMid10("motormaster_helmet_mid10", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    	new MotormasterMid10("motormaster_chestplate_mid10", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    	new MotormasterMid10("motormaster_leggings_mid10", MOTORMASTER_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    	new MotormasterMid10("motormaster_boots_mid10", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.FEET),           	    	
            	    	
            	    	new MotormasterMid11("motormaster_helmet_mid11", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    	new MotormasterMid11("motormaster_chestplate_mid11", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    	new MotormasterMid11("motormaster_leggings_mid11", MOTORMASTER_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    	new MotormasterMid11("motormaster_boots_mid11", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    	
            	    	new MotormasterMid12("motormaster_helmet_mid12", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    	new MotormasterMid12("motormaster_chestplate_mid12", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    	new MotormasterMid12("motormaster_leggings_mid12", MOTORMASTER_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    	new MotormasterMid12("motormaster_boots_mid12", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    	
            	    	new MotormasterMid13("motormaster_helmet_mid13", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    	new MotormasterMid13("motormaster_chestplate_mid13", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    	new MotormasterMid13("motormaster_leggings_mid13", MOTORMASTER_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    	new MotormasterMid13("motormaster_boots_mid13", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    	
            	    	new MotormasterMid14("motormaster_helmet_mid14", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    	new MotormasterMid14("motormaster_chestplate_mid14", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    	new MotormasterMid14("motormaster_leggings_mid14", MOTORMASTER_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    	new MotormasterMid14("motormaster_boots_mid14", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    	
            	    	new MotormasterMid15("motormaster_helmet_mid15", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    	new MotormasterMid15("motormaster_chestplate_mid15", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    	new MotormasterMid15("motormaster_leggings_mid15", MOTORMASTER_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    	new MotormasterMid15("motormaster_boots_mid15", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    	//Altmode
            	    	new MotormasterAltmode("motormaster_helmet_altmode", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    	new MotormasterAltmode("motormaster_chestplate_altmode", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    	new MotormasterAltmode("motormaster_leggings_altmode", MOTORMASTER_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    	new MotormasterAltmode("motormaster_boots_altmode", MOTORMASTER_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    	
            	    	
            	    
            	  //TFP Ultra Magnus
            	    new TFPUltraMagnus("ultra_magnus_helmet", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    new TFPUltraMagnus("ultra_magnus_chestplate", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    new TFPUltraMagnus("ultra_magnus_leggings", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    new TFPUltraMagnus("ultra_magnus_boots", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    	//transformation
            	    		new TFPMagnusMid1("ultra_magnus_helmet_mid1", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid1("ultra_magnus_chestplate_mid1", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid1("ultra_magnus_leggings_mid1", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid1("ultra_magnus_boots_mid1", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		
            	    		new TFPMagnusMid2("ultra_magnus_helmet_mid2", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid2("ultra_magnus_chestplate_mid2", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid2("ultra_magnus_leggings_mid2", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid2("ultra_magnus_boots_mid2", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		
            	    		new TFPMagnusMid3("ultra_magnus_helmet_mid3", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid3("ultra_magnus_chestplate_mid3", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid3("ultra_magnus_leggings_mid3", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid3("ultra_magnus_boots_mid3", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		
            	    		new TFPMagnusMid4("ultra_magnus_helmet_mid4", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid4("ultra_magnus_chestplate_mid4", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid4("ultra_magnus_leggings_mid4", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid4("ultra_magnus_boots_mid4", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		
            	    		new TFPMagnusMid5("ultra_magnus_helmet_mid5", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid5("ultra_magnus_chestplate_mid5", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid5("ultra_magnus_leggings_mid5", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid5("ultra_magnus_boots_mid5", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		
            	    		new TFPMagnusMid6("ultra_magnus_helmet_mid6", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid6("ultra_magnus_chestplate_mid6", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid6("ultra_magnus_leggings_mid6", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid6("ultra_magnus_boots_mid6", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		
            	    		new TFPMagnusMid7("ultra_magnus_helmet_mid7", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid7("ultra_magnus_chestplate_mid7", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid7("ultra_magnus_leggings_mid7", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid7("ultra_magnus_boots_mid7", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		
            	    		new TFPMagnusMid8("ultra_magnus_helmet_mid8", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid8("ultra_magnus_chestplate_mid8", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid8("ultra_magnus_leggings_mid8", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid8("ultra_magnus_boots_mid8", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		
            	    		new TFPMagnusMid9("ultra_magnus_helmet_mid9", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid9("ultra_magnus_chestplate_mid9", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid9("ultra_magnus_leggings_mid9", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid9("ultra_magnus_boots_mid9", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		
            	    		new TFPMagnusMid10("ultra_magnus_helmet_mid10", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid10("ultra_magnus_chestplate_mid10", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid10("ultra_magnus_leggings_mid10", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid10("ultra_magnus_boots_mid10", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		
            	    		new TFPMagnusMid11("ultra_magnus_helmet_mid11", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid11("ultra_magnus_chestplate_mid11", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid11("ultra_magnus_leggings_mid11", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid11("ultra_magnus_boots_mid11", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		
            	    		new TFPMagnusMid12("ultra_magnus_helmet_mid12", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid12("ultra_magnus_chestplate_mid12", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid12("ultra_magnus_leggings_mid12", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid12("ultra_magnus_boots_mid12", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		
            	    		new TFPMagnusMid13("ultra_magnus_helmet_mid13", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid13("ultra_magnus_chestplate_mid13", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid13("ultra_magnus_leggings_mid13", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid13("ultra_magnus_boots_mid13", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		
            	    		new TFPMagnusMid14("ultra_magnus_helmet_mid14", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid14("ultra_magnus_chestplate_mid14", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid14("ultra_magnus_leggings_mid14", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid14("ultra_magnus_boots_mid14", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		
            	    		new TFPMagnusMid15("ultra_magnus_helmet_mid15", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid15("ultra_magnus_chestplate_mid15", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid15("ultra_magnus_leggings_mid15", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid15("ultra_magnus_boots_mid15", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		
            	    		new TFPMagnusMid16("ultra_magnus_helmet_mid16", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid16("ultra_magnus_chestplate_mid16", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid16("ultra_magnus_leggings_mid16", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid16("ultra_magnus_boots_mid16", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		
            	    		new TFPMagnusMid17("ultra_magnus_helmet_mid17", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid17("ultra_magnus_chestplate_mid17", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid17("ultra_magnus_leggings_mid17", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid17("ultra_magnus_boots_mid17", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		
            	    		new TFPMagnusMid18("ultra_magnus_helmet_mid18", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid18("ultra_magnus_chestplate_mid18", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid18("ultra_magnus_leggings_mid18", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid18("ultra_magnus_boots_mid18", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		
            	    		new TFPMagnusMid19("ultra_magnus_helmet_mid19", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid19("ultra_magnus_chestplate_mid19", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid19("ultra_magnus_leggings_mid19", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid19("ultra_magnus_boots_mid19", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		
            	    		new TFPMagnusMid20("ultra_magnus_helmet_mid20", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid20("ultra_magnus_chestplate_mid20", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid20("ultra_magnus_leggings_mid20", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid20("ultra_magnus_boots_mid20", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		
            	    		new TFPMagnusMid21("ultra_magnus_helmet_mid21", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid21("ultra_magnus_chestplate_mid21", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid21("ultra_magnus_leggings_mid21", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid21("ultra_magnus_boots_mid21", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		
            	    		new TFPMagnusMid22("ultra_magnus_helmet_mid22", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusMid22("ultra_magnus_chestplate_mid22", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusMid22("ultra_magnus_leggings_mid22", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusMid22("ultra_magnus_boots_mid22", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    		//Altmode
            	    		new TFPMagnusAltmode("ultra_magnus_helmet_altmode", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    		new TFPMagnusAltmode("ultra_magnus_chestplate_altmode", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    		new TFPMagnusAltmode("ultra_magnus_leggings_altmode", MAGNUS_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    		new TFPMagnusAltmode("ultra_magnus_boots_altmode", MAGNUS_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    
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
            	    //Stealth
            	    	new MovieOptimusPrimeAltmodeWeaponized("movie_optimus_prime_altmode_weaponized_helmet",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    	new MovieOptimusPrimeAltmodeWeaponized("movie_optimus_prime_altmode_weaponized_chestplate",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    	new MovieOptimusPrimeAltmodeWeaponized("movie_optimus_prime_altmode_weaponized_leggings",  MOVIE_OPTIMUS_PRIME_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    	new MovieOptimusPrimeAltmodeWeaponized("movie_optimus_prime_altmode_weaponized_boots",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    	
            	    	new MovieOptimusPrimeAltmodeWeaponizedMid1("movie_optimus_prime_altmode_weaponized_mid1_helmet",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    	new MovieOptimusPrimeAltmodeWeaponizedMid1("movie_optimus_prime_altmode_weaponized_mid1_chestplate",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    	new MovieOptimusPrimeAltmodeWeaponizedMid1("movie_optimus_prime_altmode_weaponized_mid1_leggings",  MOVIE_OPTIMUS_PRIME_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    	new MovieOptimusPrimeAltmodeWeaponizedMid1("movie_optimus_prime_altmode_weaponized_mid1_boots",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),

            	    	new MovieOptimusPrimeAltmodeWeaponizedMid2("movie_optimus_prime_altmode_weaponized_mid2_helmet",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    	new MovieOptimusPrimeAltmodeWeaponizedMid2("movie_optimus_prime_altmode_weaponized_mid2_chestplate",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    	new MovieOptimusPrimeAltmodeWeaponizedMid2("movie_optimus_prime_altmode_weaponized_mid2_leggings",  MOVIE_OPTIMUS_PRIME_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    	new MovieOptimusPrimeAltmodeWeaponizedMid2("movie_optimus_prime_altmode_weaponized_mid2_boots",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    	
            	    	new MovieOptimusPrimeAltmodeWeaponizedMid3("movie_optimus_prime_altmode_weaponized_mid3_helmet",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.HEAD),
            	    	new MovieOptimusPrimeAltmodeWeaponizedMid3("movie_optimus_prime_altmode_weaponized_mid3_chestplate",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.CHEST),
            	    	new MovieOptimusPrimeAltmodeWeaponizedMid3("movie_optimus_prime_altmode_weaponized_mid3_leggings",  MOVIE_OPTIMUS_PRIME_MATERIAL, 2, EntityEquipmentSlot.LEGS),
            	    	new MovieOptimusPrimeAltmodeWeaponizedMid3("movie_optimus_prime_altmode_weaponized_mid3_boots",  MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
            	    	
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
                    
                    new MovieOptimusPrimeBack1("movie_optimus_prime_back1_boots", MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    new MovieOptimusPrimeBack2("movie_optimus_prime_back2_boots", MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    new MovieOptimusPrimeBack3("movie_optimus_prime_back3_boots", MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    new MovieOptimusPrimeBack4("movie_optimus_prime_back4_boots", MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    new MovieOptimusPrimeBack5("movie_optimus_prime_back5_boots", MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    new MovieOptimusPrimeBack6("movie_optimus_prime_back6_boots", MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    new MovieOptimusPrimeBack7("movie_optimus_prime_back7_boots", MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    new MovieOptimusPrimeBack8("movie_optimus_prime_back8_boots", MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    new MovieOptimusPrimeBack9("movie_optimus_prime_back9_boots", MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    
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
                    new Vurp("vurp_leggings", VURP_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new Vurp("vurp_boots", VURP_MATERIAL, 1, EntityEquipmentSlot.FEET),
                    
                  //Subwoofer
                    new Subwoofer1("subwoofer_helmet", SUBWOOFER_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new Subwoofer1("subwoofer_chestplate", SUBWOOFER_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new Subwoofer2("subwoofer_leggings", SUBWOOFER_MATERIAL, 2, EntityEquipmentSlot.LEGS),
                    new Subwoofer2("subwoofer_boots", SUBWOOFER_MATERIAL, 1, EntityEquipmentSlot.FEET),  
                    
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
            	   
//            	   new EnergonEngineBlock("energon_engine", Material.IRON).setHardness(2),
            	    new LockBlock("lock_block", Material.IRON).setHardness(3),

            	    new BlockAssembler("assembler", Material.IRON).setHardness(3),

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
            		registerProjectile("rocket", EntityLargeRocket.class, Reference.ENTITY_LARGE_ROCKET, 2, 1, true),
            		registerProjectile("bullet", EntityBullet.class, Reference.ENTITY_BULLET, 2, 1, true),
            		registerEntity("vehicon", EntityVehicon.class, Reference.ENTITY_VEHICON, 1, true, 000000, 660066),
            		registerEntity("swindle", EntitySwindle.class, Reference.ENTITY_SWINDLE, 1, true, 8983288, 16043109),
            		registerEntity("decepticon_brute", EntityDecepticonBrute.class, Reference.ENTITY_DECEPTICON_BRUTE, 1, true, 8983288, 16043109),
            		registerEntity("decepticon_vehicon_1", EntityDecepticonVehiconVariant1.class, Reference.ENTITY_DECEPTICON_VEHICON_1, 1, true, 8983288, 16043109),
            		registerEntity("decepticon_vehicon_2", EntityDecepticonVehiconVariant2.class, Reference.ENTITY_DECEPTICON_VEHICON_2, 1, true, 8983288, 16043109),
            		
//            		registerEntity("playerdummy", EntityPlayerDummy.class, Reference.ENTITY_PLAYER_DUMMY, 1, true),
                    
            };
            
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
        

        
        public static EntityEntry registerProjectile(String name, Class<? extends Entity> entity, int id, int trackRange, int frequency, boolean velocityUpdates) 
    	{
			return createEntityBuilder(name).entity(entity).id(new ResourceLocation(Reference.MOD_ID + ":" + name), 2).tracker(trackRange, frequency, velocityUpdates).build();
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
             ModelLoaderRegistry.registerLoader(new BBGunLoader());
        }
        
        @SubscribeEvent
    	public static void onPotionRegister(RegistryEvent.Register<PotionType> event) {
    		ModPotionTypes.registerPotionTypes();
    		
    	}
    }
    
    

    
//    @Mod.EventBusSubscriber(Side.CLIENT)
//    public static class ModelRegistry {
//    @SubscribeEvent
//	public static void onRegisterItems(RegistryEvent.Register<Item> event) {
//		final IForgeRegistry<Item> registry = event.getRegistry();
//		final Item[] items = {
//				
//		};
//		registry.registerAll(items);
//	}
//    }
    
}