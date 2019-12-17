package com.marctron.transformersmod.proxy;

import org.lwjgl.input.Keyboard;

import com.marctron.transformersmod.entity.EntityBullet;
import com.marctron.transformersmod.entity.EntityDecepticonBrute;
import com.marctron.transformersmod.entity.EntityDecepticonVehiconVariant1;
import com.marctron.transformersmod.entity.EntityDecepticonVehiconVariant2;
import com.marctron.transformersmod.entity.EntityLargeRocket;
import com.marctron.transformersmod.entity.EntitySwindle;
import com.marctron.transformersmod.entity.EntityVehicon;
import com.marctron.transformersmod.entity.render.RenderBullet;
import com.marctron.transformersmod.entity.render.RenderDecepticonBrute;
import com.marctron.transformersmod.entity.render.RenderDecepticonVehiconVariant1;
import com.marctron.transformersmod.entity.render.RenderDecepticonVehiconVariant2;
import com.marctron.transformersmod.entity.render.RenderRocket;
import com.marctron.transformersmod.entity.render.RenderSwindle;
import com.marctron.transformersmod.entity.render.RenderVehicon;
import com.marctron.transformersmod.events.ClientEvents;
import com.marctron.transformersmod.transformers.models.sideswipe.SideswipeModel;
import com.marctron.transformersmod.transformers.renderers.RenderArmor;
import com.marctron.transformersmod.transformers.renderers.RenderArmorNoItem;
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
import com.marctron.transformersmod.transformers.transformer.sideswipe.ArmorModelSideswipe;
import com.marctron.transformersmod.transformers.transformer.starscream.Starscream;
import com.marctron.transformersmod.transformers.transformer.starscream.StarscreamAltmode;
import com.marctron.transformersmod.transformers.transformer.starscream.StarscreamMid1;
import com.marctron.transformersmod.transformers.transformer.starscream.StarscreamMid2;
import com.marctron.transformersmod.transformers.transformer.starscream.StarscreamMid3;
import com.marctron.transformersmod.transformers.transformer.starscream.StarscreamMid4;
import com.marctron.transformersmod.transformers.transformer.starscream.StarscreamMid5;
import com.marctron.transformersmod.transformers.transformer.starscream.StarscreamMid6;
import com.marctron.transformersmod.util.Reference;
import com.marctron.transformersmod.util.handlers.RegistryHandler;
import com.marctron.transformersmod.util.handlers.RegistryHandler.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class ClientProxy implements IProxy {

    public static final KeyBinding ALT_MODE = new KeyBinding("key.transform", Keyboard.KEY_X, "category.transformers");
    public static final KeyBinding ROBOT_MODE = new KeyBinding("key.robotmode", Keyboard.KEY_Y, "category.transformers");

	public static RenderArmor RENDERER;
	public static RenderArmorNoItem RENDERER_NO_ITEM;

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(new ClientEvents());
        ClientRegistry.registerKeyBinding(ROBOT_MODE);
        ClientRegistry.registerKeyBinding(ALT_MODE);
        registerEntityRenderers();
    }

    @Override
    public void init(FMLInitializationEvent e) {
    	RENDERER = new RenderArmor(Minecraft.getMinecraft().getRenderManager(), false);
    	RENDERER_NO_ITEM = new RenderArmorNoItem(Minecraft.getMinecraft().getRenderManager(), false);
        //Breakdown
        ModItems.BREAKDOWN_HELMET.setRenderer(RENDERER);
        ModItems.BREAKDOWN_CHESTPLATE.setRenderer(RENDERER);
        ModItems.BREAKDOWN_LEGGINGS.setRenderer(RENDERER);
        ModItems.BREAKDOWN_BOOTS.setRenderer(RENDERER);
        
      //Vurp
        ModItems.VURP_HELMET.setRenderer(RENDERER);
        ModItems.VURP_CHESTPLATE.setRenderer(RENDERER);
        ModItems.VURP_LEGGINGS.setRenderer(RENDERER);
        ModItems.VURP_BOOTS.setRenderer(RENDERER);
        
      //Subwoofer
        ModItems.SUBWOOFER_HELMET.setRenderer(RENDERER);
        ModItems.SUBWOOFER_CHESTPLATE.setRenderer(RENDERER);
        ModItems.SUBWOOFER_LEGGINGS.setRenderer(RENDERER);
        ModItems.SUBWOOFER_BOOTS.setRenderer(RENDERER);
        
      //TFP Ultra Magnus
        ModItems.ULTRA_MAGNUS_HELMET.setRenderer(RENDERER);
        ModItems.ULTRA_MAGNUS_CHESTPLATE.setRenderer(RENDERER);
        ModItems.ULTRA_MAGNUS_LEGGINGS.setRenderer(RENDERER);
        ModItems.ULTRA_MAGNUS_BOOTS.setRenderer(RENDERER);
        
        
      //Sideswipe
        ModItems.SIDESWIPE_HELMET.setRenderer(RENDERER);
        ModItems.SIDESWIPE_CHESTPLATE.setRenderer(RENDERER);
        ModItems.SIDESWIPE_LEGGINGS.setRenderer(RENDERER);
        ModItems.SIDESWIPE_BOOTS.setRenderer(RENDERER);

        ModItems.SIDESWIPE_MID_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.SIDESWIPE_MID_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.SIDESWIPE_MID_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.SIDESWIPE_MID_BOOTS.setRenderer(RENDERER_NO_ITEM);
        
        ModItems.SIDESWIPE_MID2_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.SIDESWIPE_MID2_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.SIDESWIPE_MID2_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.SIDESWIPE_MID2_BOOTS.setRenderer(RENDERER_NO_ITEM);

        ModItems.SIDESWIPE_MID3_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.SIDESWIPE_MID3_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.SIDESWIPE_MID3_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.SIDESWIPE_MID3_BOOTS.setRenderer(RENDERER_NO_ITEM);

        ModItems.SIDESWIPE_MID4_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.SIDESWIPE_MID4_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.SIDESWIPE_MID4_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.SIDESWIPE_MID4_BOOTS.setRenderer(RENDERER_NO_ITEM);

        ModItems.SIDESWIPE_ALTMODE_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.SIDESWIPE_ALTMODE_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.SIDESWIPE_ALTMODE_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.SIDESWIPE_ALTMODE_BOOTS.setRenderer(RENDERER_NO_ITEM);
        
      //Movie Optimus Prime
        ModItems.MOVIE_OPTIMUS_PRIME_HELMET.setRenderer(RENDERER);
        ModItems.MOVIE_OPTIMUS_PRIME_CHESTPLATE.setRenderer(RENDERER);
        ModItems.MOVIE_OPTIMUS_PRIME_LEGGINGS.setRenderer(RENDERER);
        ModItems.MOVIE_OPTIMUS_PRIME_BOOTS.setRenderer(RENDERER);
        
        ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_BOOTS.setRenderer(RENDERER_NO_ITEM);
        
        ModItems.MOVIE_OPTIMUS_PRIME_MID1_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID1_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID1_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID1_BOOTS.setRenderer(RENDERER_NO_ITEM);
        
        ModItems.MOVIE_OPTIMUS_PRIME_MID2_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID2_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID2_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID2_BOOTS.setRenderer(RENDERER_NO_ITEM);
        
        ModItems.MOVIE_OPTIMUS_PRIME_MID3_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID3_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID3_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID3_BOOTS.setRenderer(RENDERER_NO_ITEM);
        
        ModItems.MOVIE_OPTIMUS_PRIME_MID4_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID4_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID4_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID4_BOOTS.setRenderer(RENDERER_NO_ITEM);    
        
        ModItems.MOVIE_OPTIMUS_PRIME_MID5_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID5_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID5_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID5_BOOTS.setRenderer(RENDERER_NO_ITEM);
        
        ModItems.MOVIE_OPTIMUS_PRIME_MID6_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID6_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID6_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID6_BOOTS.setRenderer(RENDERER_NO_ITEM);
        
        ModItems.MOVIE_OPTIMUS_PRIME_MID7_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID7_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID7_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID7_BOOTS.setRenderer(RENDERER_NO_ITEM);
        
        ModItems.MOVIE_OPTIMUS_PRIME_MID8_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID8_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID8_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID8_BOOTS.setRenderer(RENDERER_NO_ITEM);
        
        ModItems.MOVIE_OPTIMUS_PRIME_MID9_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID9_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID9_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_MID9_BOOTS.setRenderer(RENDERER_NO_ITEM);
        
        
        
        ModItems.MOVIE_OPTIMUS_PRIME_BACK1_BOOTS.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_BACK2_BOOTS.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_BACK3_BOOTS.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_BACK4_BOOTS.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_BACK5_BOOTS.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_BACK6_BOOTS.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_BACK7_BOOTS.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_BACK8_BOOTS.setRenderer(RENDERER_NO_ITEM);
        ModItems.MOVIE_OPTIMUS_PRIME_BACK9_BOOTS.setRenderer(RENDERER_NO_ITEM);
        
      //Starscream
        ModItems.STARSCREAM_HELMET.setRenderer(RENDERER);
        ModItems.STARSCREAM_CHESTPLATE.setRenderer(RENDERER);
        ModItems.STARSCREAM_LEGGINGS.setRenderer(RENDERER);
        ModItems.STARSCREAM_BOOTS.setRenderer(RENDERER);

        ModItems.STARSCREAM_ALTMODE_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.STARSCREAM_ALTMODE_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.STARSCREAM_ALTMODE_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.STARSCREAM_ALTMODE_BOOTS.setRenderer(RENDERER_NO_ITEM);
        
        ModItems.STARSCREAM_MID1_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.STARSCREAM_MID1_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.STARSCREAM_MID1_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.STARSCREAM_MID1_BOOTS.setRenderer(RENDERER_NO_ITEM);

        ModItems.STARSCREAM_MID2_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.STARSCREAM_MID2_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.STARSCREAM_MID2_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.STARSCREAM_MID2_BOOTS.setRenderer(RENDERER_NO_ITEM);

        ModItems.STARSCREAM_MID3_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.STARSCREAM_MID3_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.STARSCREAM_MID3_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.STARSCREAM_MID3_BOOTS.setRenderer(RENDERER_NO_ITEM);

        ModItems.STARSCREAM_MID4_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.STARSCREAM_MID4_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.STARSCREAM_MID4_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.STARSCREAM_MID4_BOOTS.setRenderer(RENDERER_NO_ITEM);

        ModItems.STARSCREAM_MID5_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.STARSCREAM_MID5_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.STARSCREAM_MID5_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.STARSCREAM_MID5_BOOTS.setRenderer(RENDERER_NO_ITEM);

        ModItems.STARSCREAM_MID6_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.STARSCREAM_MID6_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.STARSCREAM_MID6_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.STARSCREAM_MID6_BOOTS.setRenderer(RENDERER_NO_ITEM);
        
      //Skywarp
        ModItems.SKYWARP_HELMET.setRenderer(RENDERER);
        ModItems.SKYWARP_CHESTPLATE.setRenderer(RENDERER);
        ModItems.SKYWARP_LEGGINGS.setRenderer(RENDERER);
        ModItems.SKYWARP_BOOTS.setRenderer(RENDERER);

        ModItems.SKYWARP_ALTMODE_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.SKYWARP_ALTMODE_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.SKYWARP_ALTMODE_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.SKYWARP_ALTMODE_BOOTS.setRenderer(RENDERER_NO_ITEM);
        
        ModItems.SKYWARP_MID1_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.SKYWARP_MID1_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.SKYWARP_MID1_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.SKYWARP_MID1_BOOTS.setRenderer(RENDERER_NO_ITEM);

        ModItems.SKYWARP_MID2_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.SKYWARP_MID2_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.SKYWARP_MID2_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.SKYWARP_MID2_BOOTS.setRenderer(RENDERER_NO_ITEM);

        ModItems.SKYWARP_MID3_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.SKYWARP_MID3_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.SKYWARP_MID3_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.SKYWARP_MID3_BOOTS.setRenderer(RENDERER_NO_ITEM);

        ModItems.SKYWARP_MID4_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.SKYWARP_MID4_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.SKYWARP_MID4_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.SKYWARP_MID4_BOOTS.setRenderer(RENDERER_NO_ITEM);

        ModItems.SKYWARP_MID5_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.SKYWARP_MID5_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.SKYWARP_MID5_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.SKYWARP_MID5_BOOTS.setRenderer(RENDERER_NO_ITEM);

        ModItems.SKYWARP_MID6_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.SKYWARP_MID6_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.SKYWARP_MID6_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.SKYWARP_MID6_BOOTS.setRenderer(RENDERER_NO_ITEM);
        
      //Thundercracker
        ModItems.THUNDERCRACKER_HELMET.setRenderer(RENDERER);
        ModItems.THUNDERCRACKER_CHESTPLATE.setRenderer(RENDERER);
        ModItems.THUNDERCRACKER_LEGGINGS.setRenderer(RENDERER);
        ModItems.THUNDERCRACKER_BOOTS.setRenderer(RENDERER);

        ModItems.THUNDERCRACKER_ALTMODE_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.THUNDERCRACKER_ALTMODE_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.THUNDERCRACKER_ALTMODE_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.THUNDERCRACKER_ALTMODE_BOOTS.setRenderer(RENDERER_NO_ITEM);
        
        ModItems.THUNDERCRACKER_MID1_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.THUNDERCRACKER_MID1_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.THUNDERCRACKER_MID1_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.THUNDERCRACKER_MID1_BOOTS.setRenderer(RENDERER_NO_ITEM);

        ModItems.THUNDERCRACKER_MID2_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.THUNDERCRACKER_MID2_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.THUNDERCRACKER_MID2_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.THUNDERCRACKER_MID2_BOOTS.setRenderer(RENDERER_NO_ITEM);

        ModItems.THUNDERCRACKER_MID3_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.THUNDERCRACKER_MID3_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.THUNDERCRACKER_MID3_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.THUNDERCRACKER_MID3_BOOTS.setRenderer(RENDERER_NO_ITEM);

        ModItems.THUNDERCRACKER_MID4_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.THUNDERCRACKER_MID4_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.THUNDERCRACKER_MID4_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.THUNDERCRACKER_MID4_BOOTS.setRenderer(RENDERER_NO_ITEM);

        ModItems.THUNDERCRACKER_MID5_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.THUNDERCRACKER_MID5_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.THUNDERCRACKER_MID5_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.THUNDERCRACKER_MID5_BOOTS.setRenderer(RENDERER_NO_ITEM);

        ModItems.THUNDERCRACKER_MID6_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.THUNDERCRACKER_MID6_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.THUNDERCRACKER_MID6_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.THUNDERCRACKER_MID6_BOOTS.setRenderer(RENDERER_NO_ITEM);
        
   	 //Vehicon
        ModItems.CUSTOM_HELMET.setRenderer(RENDERER);
        ModItems.CUSTOM_CHESTPLATE.setRenderer(RENDERER);
        ModItems.CUSTOM_LEGGINGS.setRenderer(RENDERER);
        ModItems.CUSTOM_BOOTS.setRenderer(RENDERER);

        ModItems.VEHICON_MID_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.VEHICON_MID_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        ModItems.VEHICON_MID_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        ModItems.VEHICON_MID_BOOTS.setRenderer(RENDERER_NO_ITEM);
	    
        ModItems.VEHICON_MID_2_HELMET.setRenderer(RENDERER_NO_ITEM);
        ModItems.VEHICON_MID_2_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
	    ModItems.VEHICON_MID_2_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
	    ModItems.VEHICON_MID_2_BOOTS.setRenderer(RENDERER_NO_ITEM);

	    ModItems.VEHICON_ALTMODE_HELMET.setRenderer(RENDERER_NO_ITEM);
	    ModItems.VEHICON_ALTMODE_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
	    ModItems.VEHICON_ALTMODE_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
	    ModItems.VEHICON_ALTMODE_BOOTS.setRenderer(RENDERER_NO_ITEM);
	    
	  //Tarn
	    ModItems.TARN_HELMET.setRenderer(RENDERER);
	    ModItems.TARN_CHESTPLATE.setRenderer(RENDERER);
	    ModItems.TARN_LEGGINGS.setRenderer(RENDERER);
	    ModItems.TARN_BOOTS.setRenderer(RENDERER);

	    ModItems.TARN_MID1_HELMET.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID1_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID1_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID1_BOOTS.setRenderer(RENDERER_NO_ITEM);

	    ModItems.TARN_MID2_HELMET.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID2_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID2_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID2_BOOTS.setRenderer(RENDERER_NO_ITEM);

	    ModItems.TARN_MID3_HELMET.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID3_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID3_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID3_BOOTS.setRenderer(RENDERER_NO_ITEM);
	    
	    ModItems.TARN_MID4_HELMET.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID4_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID4_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID4_BOOTS.setRenderer(RENDERER_NO_ITEM);

	    ModItems.TARN_ALTMODE_HELMET.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_ALTMODE_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_ALTMODE_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_ALTMODE_BOOTS.setRenderer(RENDERER_NO_ITEM);

	    ModItems.TARN_MID5_HELMET.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID5_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID5_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID5_BOOTS.setRenderer(RENDERER_NO_ITEM);

	    ModItems.TARN_MID6_HELMET.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID6_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID6_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID6_BOOTS.setRenderer(RENDERER_NO_ITEM);

	    ModItems.TARN_MID7_HELMET.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID7_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID7_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID7_BOOTS.setRenderer(RENDERER_NO_ITEM);

	    ModItems.TARN_MID8_HELMET.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID8_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID8_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
	    ModItems.TARN_MID8_BOOTS.setRenderer(RENDERER_NO_ITEM);

    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }

    public static void registerEntityRenderers() {
        
        
        RenderingRegistry.registerEntityRenderingHandler(EntityDecepticonBrute.class, RenderDecepticonBrute::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDecepticonVehiconVariant1.class, RenderDecepticonVehiconVariant1::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDecepticonVehiconVariant2.class, RenderDecepticonVehiconVariant2::new);
        
        RenderingRegistry.registerEntityRenderingHandler(EntityVehicon.class, RenderVehicon::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitySwindle.class, RenderSwindle::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, RenderBullet::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityLargeRocket.class, RenderRocket::new);
    }
}
