package com.marctron.transformersmod.util.handlers;

import com.marctron.transformersmod.commands.CommandDimensionTeleport;
import com.marctron.transformersmod.init.EntityInit;
import com.marctron.transformersmod.init.ModBlocks;
import com.marctron.transformersmod.init.ModItems;
import com.marctron.transformersmod.util.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler 
{
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for(Item item : ModItems.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : ModBlocks.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
		
	}
	public static void preInitRegistries(FMLPreInitializationEvent event)
	{
		EntityInit.registerEntities();
		RenderHandler.registerEntityRenders();
	}

	public static void preInitRegistriesSide() 
	{
		EntityInit.registerEntities();
		RenderHandler.registerEntityRenders();
		
	}
	public static void initRegistries() 
	{
		SoundsHandler.registerSounds();
	}
	public static void serverRegistries(FMLServerStartingEvent event) 
	{
		event.registerServerCommand(new CommandDimensionTeleport());
	}
}