package com.marctron.transformersmod;

import java.io.File;
import java.util.ArrayList;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

import com.marctron.transformersmod.commands.CommandDimensionTeleport;
import com.marctron.transformersmod.init.CybertronWorldGen;
import com.marctron.transformersmod.init.GunEntities;
import com.marctron.transformersmod.init.ModRecipes;
import com.marctron.transformersmod.network.packets.tf.TFNetworkManager;
import com.marctron.transformersmod.proxy.IProxy;
import com.marctron.transformersmod.resize.potions.PotionGrowth;
import com.marctron.transformersmod.resize.potions.PotionShrinking;
//import com.marctron.transformersmod.sounds.DetectDriving;
import com.marctron.transformersmod.util.Reference;
import com.marctron.transformersmod.util.handlers.GuiHandler;
import com.marctron.transformersmod.util.handlers.RegistryHandler;
import com.marctron.transformersmod.util.handlers.SoundsHandler;
import com.marctron.transformersmod.world.generators.ModWorldGen;
import com.marctron.transformersmod.world.generators.WorldGenCustomStructures;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
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

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	
	public static EntityLivingBase entity ;
	
	public static final Potion SHRINKING = new PotionShrinking("shrinking", entity);
	public static final Potion GROWTH = new PotionGrowth("growth");

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
            return new ItemStack(RegistryHandler.ModItems.D_I);
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
            return new ItemStack(RegistryHandler.ModItems.A_I);
        };

        @Override
        public boolean hasSearchBar() {
            return false;
        }

    };

	
    public static SimpleNetworkWrapper network;
    
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
//        
//        network = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
//        network.registerMessage(new PacketInventory.Handler(), PacketInventory.class, 2, Side.SERVER);
        
       
        TFNetworkManager.registerPackets();
    

        
        

//		network.registerMessage(new PacketUpdatePedestal.Handler(), PacketUpdatePedestal.class, 0, Side.CLIENT);
//		network.registerMessage(new PacketRequestUpdatePedestal.Handler(), PacketRequestUpdatePedestal.class, 1, Side.SERVER);
        

        
    }

    @EventHandler
    public static void init(FMLInitializationEvent event) {
    	
        ModRecipes.init();
        // TODO: Should be instantiated in Forge related event RegistryEvent.Register<SoundEvent> -Toma
        SoundsHandler.init();
        GunEntities.regEntities();
//        MinecraftForge.EVENT_BUS.register(new DetectDriving());
        
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
