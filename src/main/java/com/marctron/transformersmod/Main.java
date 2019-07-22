package com.marctron.transformersmod;

import java.io.File;

import com.marctron.transformersmod.init.CybertronWorldGen;
import com.marctron.transformersmod.init.EntityInit;
import com.marctron.transformersmod.init.GunEntities;
import com.marctron.transformersmod.init.ModBiomes;
import com.marctron.transformersmod.init.ModItems;
import com.marctron.transformersmod.init.ModRecipes;
import com.marctron.transformersmod.proxy.CommonProxy;
import com.marctron.transformersmod.util.Reference;
import com.marctron.transformersmod.util.handlers.RegistryHandler;
import com.marctron.transformersmod.util.handlers.RenderHandler;
import com.marctron.transformersmod.world.generators.ModWorldGen;
import com.marctron.transformersmod.world.generators.WorldGenCustomStructures;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	
	
	public static File config;

	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
		
		CybertronWorldGen.registerDimensions();
		
		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
		
		//ModBiomes.registerBiomes();
		
		RegistryHandler.preInitRegistries(event);
		
		//GunEntities.regEntities();
		
		
	
	  
	}
	
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		ModRecipes.init();
		RegistryHandler.initRegistries();
		proxy.register();
		GunEntities.regEntities();
	}
	
	@EventHandler
	public static void preInitRegistries()
	{
		EntityInit.registerEntities();
		RenderHandler.registerEntityRenders();
	}
	
	public static void postInit(FMLPostInitializationEvent event)
	{
		
	}
		
		public static CreativeTabs tabTransformers = new CreativeTabs("tabTransformersMod") {

			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ModItems.ENERGON_SHARD);
			};
			
			@Override
			public boolean hasSearchBar() {
				return true;
			}
			
		}.setBackgroundImageName("item_search.png");
		
		public static CreativeTabs tabWeapons = new CreativeTabs("tabWeapons") {

			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ModItems.AMMO);
			};
			
			@Override
			public boolean hasSearchBar() {
				return false;
			}
			
		};
		
		public static CreativeTabs tabDecepticon = new CreativeTabs("tabDecepticon") {

			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ModItems.DECEPTICON_INSGINIA);
			};
			
			@Override
			public boolean hasSearchBar() {
				return false;
			}
			
		};
		
		public static CreativeTabs tabAutobot = new CreativeTabs("tabAutobot") {

			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ModItems.AUTOBOT_INSGINIA);
			};
			
			@Override
			public boolean hasSearchBar() {
				return false;
			}
			
		};
		
		@EventHandler
		public static void serverInit(FMLServerStartingEvent event)
		{
				RegistryHandler.serverRegistries(event);
		}
		
	
	
		
}
