package com.marctron.transformersmod;

import com.marctron.transformersmod.init.ModItems;
import com.marctron.transformersmod.init.ModRecipes;
import com.marctron.transformersmod.proxy.CommonProxy;
import com.marctron.transformersmod.util.Reference;
import com.marctron.transformersmod.util.handlers.RegistryHandler;
import com.marctron.transformersmod.world.ModWorldGen;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	


	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
		RegistryHandler.preInitRegistriesSide();
	}
	
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		ModRecipes.init();
		RegistryHandler.initRegistries();
		
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event)
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
		
	
	
		
}
