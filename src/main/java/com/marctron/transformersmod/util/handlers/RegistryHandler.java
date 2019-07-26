package com.marctron.transformersmod.util.handlers;

import com.marctron.transformersmod.commands.CommandDimensionTeleport;
import com.marctron.transformersmod.init.EntityInit;
import com.marctron.transformersmod.init.ModBlocks;
import com.marctron.transformersmod.transformers.MovieOptimusPrime;
import com.marctron.transformersmod.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class RegistryHandler {

    @GameRegistry.ObjectHolder(Reference.MOD_ID)
    public static final class ModItems {
        public static final MovieOptimusPrime MOVIE_OPTIMUS_PRIME_HELMET = null;
        public static final MovieOptimusPrime MOVIE_OPTIMUS_PRIME_CHESTPLATE = null;
        public static final MovieOptimusPrime MOVIE_OPTIMUS_PRIME_LEGGINGS = null;
        public static final MovieOptimusPrime MOVIE_OPTIMUS_PRIME_BOOTS = null;
    }

    @GameRegistry.ObjectHolder(Reference.MOD_ID)
    public static final class ModBlocks {

    }

    @Mod.EventBusSubscriber
    public static class Registry {

        @SubscribeEvent
        public static void onItemRegister(RegistryEvent.Register<Item> event) {
            final Item[] items = {
                    new MovieOptimusPrime("movie_optimus_prime_helmet", com.marctron.transformersmod.init.ModItems.MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.HEAD),
                    new MovieOptimusPrime("movie_optimus_prime_chestplate", com.marctron.transformersmod.init.ModItems.MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new MovieOptimusPrime("movie_optimus_prime_leggings", com.marctron.transformersmod.init.ModItems.MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.CHEST),
                    new MovieOptimusPrime("movie_optimus_prime_boots", com.marctron.transformersmod.init.ModItems.MOVIE_OPTIMUS_PRIME_MATERIAL, 1, EntityEquipmentSlot.CHEST)
            };
            event.getRegistry().registerAll(items);
            event.getRegistry().registerAll(com.marctron.transformersmod.init.ModItems.ITEMS.toArray(new Item[0]));
        }

        @SubscribeEvent
        public static void onBlockRegister(RegistryEvent.Register<Block> event) {
            final Block[] blocks = {};
            event.getRegistry().registerAll(blocks);
            event.getRegistry().registerAll(com.marctron.transformersmod.init.ModBlocks.BLOCKS.toArray(new Block[0]));
            TileEntityHandler.registerTileEntities();
        }

        @SubscribeEvent
        public static void entityRegistry(RegistryEvent.Register<EntityEntry> e) {
            final EntityEntry[] entry = {};
            // use
            e.getRegistry().registerAll(entry);
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