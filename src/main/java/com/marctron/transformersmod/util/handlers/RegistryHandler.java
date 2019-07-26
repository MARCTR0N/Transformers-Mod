package com.marctron.transformersmod.util.handlers;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.commands.CommandDimensionTeleport;
import com.marctron.transformersmod.init.EntityInit;
import com.marctron.transformersmod.init.ModBlocks;
import com.marctron.transformersmod.init.ModItems;
import com.marctron.transformersmod.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

@EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
        TileEntityHandler.registerTileEntities();

    }


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

    public static void preInitRegistries(FMLPreInitializationEvent event) {
        EntityInit.registerEntities();
        RenderHandler.registerEntityRenders();
    }

    public static void preInitRegistriesSide() {
        EntityInit.registerEntities();
        RenderHandler.registerEntityRenders();
        SoundsHandler.init();
    }

    public static void initRegistries() {
        SoundsHandler.init();
        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
    }

    public static void serverRegistries(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandDimensionTeleport());
    }
}