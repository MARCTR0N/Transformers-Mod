package com.marctron.transformersmod;

import com.marctron.transformersmod.commands.CommandDimensionTeleport;
import org.apache.logging.log4j.Logger;
import com.marctron.transformersmod.init.*;
import com.marctron.transformersmod.network.packets.PacketInventory;
import com.marctron.transformersmod.network.packets.PacketInventoryHandler;
import com.marctron.transformersmod.proxy.IProxy;
import com.marctron.transformersmod.util.Reference;
import com.marctron.transformersmod.util.handlers.GuiHandler;
import com.marctron.transformersmod.util.handlers.RegistryHandler;
import com.marctron.transformersmod.util.handlers.SoundsHandler;
import com.marctron.transformersmod.world.generators.ModWorldGen;
import com.marctron.transformersmod.world.generators.WorldGenCustomStructures;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

import java.io.File;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

    @Instance
    public static Main instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;


    public static File config;
        
    
    
    public static CreativeTabs tabTransformers = new CreativeTabs("tabTransformersMod") {

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(RegistryHandler.ModItems.ENERGON_SHARD);
        }

        ;

        @Override
        public boolean hasSearchBar() {
            return true;
        }

    }.setBackgroundImageName("item_search.png");
    
    public static CreativeTabs tabWeapons = new CreativeTabs("tabWeapons") {

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(RegistryHandler.ModItems.AMMO);
        };

        @Override
        public boolean hasSearchBar() {
            return false;
        }

    };
    public static CreativeTabs tabDecepticon = new CreativeTabs("tabDecepticon") {

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(RegistryHandler.ModItems.D_INSGINIA);
        };

        @Override
        public boolean hasSearchBar() {
            return false;
        }

    };
    public static Logger logger;
    
    public static CreativeTabs tabAutobot = new CreativeTabs("tabAutobot") {

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(RegistryHandler.ModItems.A_INSGINIA);
        }

        ;

        @Override
        public boolean hasSearchBar() {
            return false;
        }

    };

	

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
    	proxy.preInit(event);
       
    	GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
        
        logger = event.getModLog();

        CybertronWorldGen.registerDimensions();

        GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);

        //ModBiomes.registerBiomes();

//        EntityInit.registerEntities();

        //GunEntities.regEntities();
        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
        

        
    }

    @EventHandler
    public static void init(FMLInitializationEvent event) {
        ModRecipes.init();
        // TODO: Should be instantiated in Forge related event RegistryEvent.Register<SoundEvent> -Toma
        SoundsHandler.init();
        GunEntities.regEntities();
        
        proxy.init(event);
    }

    @EventHandler
    public static void preInitRegistries() {
//        EntityInit.registerEntities();
    }

    public static void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @EventHandler
    public static void serverInit(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandDimensionTeleport());
    }


}
