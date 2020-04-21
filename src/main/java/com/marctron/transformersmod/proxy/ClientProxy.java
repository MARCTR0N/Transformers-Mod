package com.marctron.transformersmod.proxy;

import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;

import com.marctron.transformersmod.client.modelloaders.bbmodel.BBGunLoader;
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
//import com.marctron.transformersmod.fpr.RFP2;
//import com.marctron.transformersmod.fpr.RFP2Keybind;
//import com.marctron.transformersmod.fpr.State;
//import com.marctron.transformersmod.fpr.playerdummy.EntityPlayerDummy;
//import com.marctron.transformersmod.fpr.playerdummy.RenderPlayerDummy;
import com.marctron.transformersmod.items.ACHILLESA4;
import com.marctron.transformersmod.items.DARKSTARSABER;
import com.marctron.transformersmod.items.M1_GARAND_FULL;
import com.marctron.transformersmod.transformers.renderers.RenderArmor;
import com.marctron.transformersmod.transformers.renderers.RenderArmorNoItem;
import com.marctron.transformersmod.util.Reference;
import com.marctron.transformersmod.util.handlers.RegistryHandler;
import com.marctron.transformersmod.util.handlers.RegistryHandler.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.registry.EntityRegistry;


public class ClientProxy implements IProxy {

    public static final KeyBinding ALT_MODE = new KeyBinding("key.transform", Keyboard.KEY_X, "category.transformers");
    public static final KeyBinding ROBOT_MODE = new KeyBinding("key.robotmode", Keyboard.KEY_Y, "category.transformers");
    public static final KeyBinding RELOAD = new KeyBinding("key.reload", Keyboard.KEY_R, "category.transformers");
    
//    public static RFP2Keybind keybindArmsToggle         = new RFP2Keybind("key.arms.desc", Keyboard.KEY_SEMICOLON, "key.rfp2.category");
//    public static RFP2Keybind keybindModToggle          = new RFP2Keybind("key.mod.desc", Keyboard.KEY_APOSTROPHE, "key.rfp2.category");
//    public static RFP2Keybind keybindHeadRotationToggle = new RFP2Keybind("key.head.desc", Keyboard.KEY_H, "key.rfp2.category");
// 

	public static RenderArmor RENDERER;
	public static RenderArmorNoItem RENDERER_NO_ITEM;

	private Minecraft mc = Minecraft.getMinecraft();

	
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(new ClientEvents());
        ClientRegistry.registerKeyBinding(ROBOT_MODE);
        ClientRegistry.registerKeyBinding(ALT_MODE);
        ClientRegistry.registerKeyBinding(RELOAD);
        
   
        registerEntityRenderers();
        
        OBJLoader.INSTANCE.addDomain(Reference.MOD_ID);
        
        RenderingRegistry.registerEntityRenderingHandler(EntityDecepticonBrute.class, RenderDecepticonBrute::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDecepticonVehiconVariant1.class, RenderDecepticonVehiconVariant1::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDecepticonVehiconVariant2.class, RenderDecepticonVehiconVariant2::new);
        
        RenderingRegistry.registerEntityRenderingHandler(EntityVehicon.class, RenderVehicon::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitySwindle.class, RenderSwindle::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, RenderBullet::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityLargeRocket.class, RenderRocket::new);
        
     // Register entity rendering handler for the player dummy
//        RenderingRegistry.registerEntityRenderingHandler(EntityPlayerDummy.class, RenderPlayerDummy::new);

    }

    @Override
    public void init(FMLInitializationEvent e) {
    	
//    	MinecraftForge.EVENT_BUS.register(new DetectDriving());

    	
    	
    	RENDERER = new RenderArmor(Minecraft.getMinecraft().getRenderManager(), false);
    	RENDERER_NO_ITEM = new RenderArmorNoItem(Minecraft.getMinecraft().getRenderManager(), false);
    
      //Megatron
    	ModItems.TFPMEGATRON_HELMET.setRenderer(RENDERER);
        ModItems.TFPMEGATRON_CHESTPLATE.setRenderer(RENDERER);
        ModItems.TFPMEGATRON_LEGGINGS.setRenderer(RENDERER);
        ModItems.TFPMEGATRON_BOOTS.setRenderer(RENDERER);
    	
      //Menasor
    	ModItems.MENASOR_HELMET.setRenderer(RENDERER);
        ModItems.MENASOR_CHESTPLATE.setRenderer(RENDERER);
        ModItems.MENASOR_LEGGINGS.setRenderer(RENDERER);
        ModItems.MENASOR_BOOTS.setRenderer(RENDERER);
    	
      //Motormaster
    	ModItems.MOTORMASTER_HELMET.setRenderer(RENDERER);
        ModItems.MOTORMASTER_CHESTPLATE.setRenderer(RENDERER);
        ModItems.MOTORMASTER_LEGGINGS.setRenderer(RENDERER);
        ModItems.MOTORMASTER_BOOTS.setRenderer(RENDERER);
        
        	ModItems.MOTORMASTER_HELMET_MID1.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_CHESTPLATE_MID1.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_LEGGINGS_MID1.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_BOOTS_MID1.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.MOTORMASTER_HELMET_MID2.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_CHESTPLATE_MID2.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_LEGGINGS_MID2.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_BOOTS_MID2.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.MOTORMASTER_HELMET_MID3.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_CHESTPLATE_MID3.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_LEGGINGS_MID3.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_BOOTS_MID3.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.MOTORMASTER_HELMET_MID4.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_CHESTPLATE_MID4.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_LEGGINGS_MID4.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_BOOTS_MID4.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.MOTORMASTER_HELMET_MID5.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_CHESTPLATE_MID5.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_LEGGINGS_MID5.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_BOOTS_MID5.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.MOTORMASTER_HELMET_MID6.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_CHESTPLATE_MID6.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_LEGGINGS_MID6.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_BOOTS_MID6.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.MOTORMASTER_HELMET_MID7.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_CHESTPLATE_MID7.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_LEGGINGS_MID7.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_BOOTS_MID7.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.MOTORMASTER_HELMET_MID8.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_CHESTPLATE_MID8.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_LEGGINGS_MID8.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_BOOTS_MID8.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.MOTORMASTER_HELMET_MID9.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_CHESTPLATE_MID9.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_LEGGINGS_MID9.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_BOOTS_MID9.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.MOTORMASTER_HELMET_MID10.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_CHESTPLATE_MID10.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_LEGGINGS_MID10.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_BOOTS_MID10.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.MOTORMASTER_HELMET_MID11.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_CHESTPLATE_MID11.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_LEGGINGS_MID11.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_BOOTS_MID11.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.MOTORMASTER_HELMET_MID12.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_CHESTPLATE_MID12.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_LEGGINGS_MID12.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_BOOTS_MID12.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.MOTORMASTER_HELMET_MID13.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_CHESTPLATE_MID13.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_LEGGINGS_MID13.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_BOOTS_MID13.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.MOTORMASTER_HELMET_MID14.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_CHESTPLATE_MID14.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_LEGGINGS_MID14.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_BOOTS_MID14.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.MOTORMASTER_HELMET_MID15.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_CHESTPLATE_MID15.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_LEGGINGS_MID15.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_BOOTS_MID15.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.MOTORMASTER_HELMET_ALTMODE.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_CHESTPLATE_ALTMODE.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_LEGGINGS_ALTMODE.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOTORMASTER_BOOTS_ALTMODE.setRenderer(RENDERER_NO_ITEM);
        
    	
      //Breakdown
        ModItems.BREAKDOWN_HELMET.setRenderer(RENDERER);
        ModItems.BREAKDOWN_CHESTPLATE.setRenderer(RENDERER);
        ModItems.BREAKDOWN_LEGGINGS.setRenderer(RENDERER);
        ModItems.BREAKDOWN_BOOTS.setRenderer(RENDERER);
        
      //Dragstrip
        ModItems.DRAGSTRIP_HELMET.setRenderer(RENDERER);
        ModItems.DRAGSTRIP_CHESTPLATE.setRenderer(RENDERER);
        ModItems.DRAGSTRIP_LEGGINGS.setRenderer(RENDERER);
        ModItems.DRAGSTRIP_BOOTS.setRenderer(RENDERER);
        
      //Deadend
        ModItems.DEADEND_HELMET.setRenderer(RENDERER);
        ModItems.DEADEND_CHESTPLATE.setRenderer(RENDERER);
        ModItems.DEADEND_LEGGINGS.setRenderer(RENDERER);
        ModItems.DEADEND_BOOTS.setRenderer(RENDERER);
        
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
        //transformation
        	ModItems.ULTRA_MAGNUS_HELMET_MID1.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID1.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID1.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID1.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_MID2.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID2.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID2.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID2.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_MID3.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID3.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID3.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID3.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_MID4.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID4.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID4.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID4.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_MID5.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID5.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID5.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID5.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_MID6.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID6.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID6.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID6.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_MID7.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID7.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID7.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID7.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_MID8.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID8.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID8.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID8.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_MID9.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID9.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID9.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID9.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_MID10.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID10.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID10.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID10.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_MID11.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID11.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID11.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID11.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_MID12.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID12.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID12.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID12.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_MID13.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID13.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID13.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID13.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_MID14.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID14.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID14.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID14.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_MID15.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID15.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID15.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID15.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_MID16.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID16.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID16.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID16.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_MID17.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID17.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID17.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID17.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_MID18.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID18.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID18.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID18.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_MID19.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID19.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID19.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID19.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_MID20.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID20.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID20.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID20.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_MID21.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID21.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID21.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID21.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_MID22.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_MID22.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_MID22.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_MID22.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.ULTRA_MAGNUS_HELMET_ALTMODE.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_CHESTPLATE_ALTMODE.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_LEGGINGS_ALTMODE.setRenderer(RENDERER_NO_ITEM);
        	ModItems.ULTRA_MAGNUS_BOOTS_ALTMODE.setRenderer(RENDERER_NO_ITEM);
        	
        
        
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
        	//Stealth
        	ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_HELMET.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_BOOTS.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID1_HELMET.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID1_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID1_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID1_BOOTS.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_HELMET.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_BOOTS.setRenderer(RENDERER_NO_ITEM);
        	
        	ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID3_HELMET.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID3_CHESTPLATE.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID3_LEGGINGS.setRenderer(RENDERER_NO_ITEM);
        	ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID3_BOOTS.setRenderer(RENDERER_NO_ITEM);
        
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
	    
	    
	    
	    
	    
	    RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
	    renderItem.getItemModelMesher().register(RegistryHandler.ModItems.ACHILLESA4, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ACHILLESA4.name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(RegistryHandler.ModItems.ACHILLESA4, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + ACHILLESA4.name,"inventory"));
	    
	    //renderItem.getItemModelMesher().register(RegistryHandler.ModItems.M1_GARAND_FULL, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + M1_GARAND_FULL.name, "inventory"));
	    //ModelLoader.setCustomModelResourceLocation(RegistryHandler.ModItems.M1_GARAND_FULL, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + M1_GARAND_FULL.name,"inventory"));
	    
	    renderItem.getItemModelMesher().register(RegistryHandler.ModItems.DARKSTARSABER, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + DARKSTARSABER.name, "inventory"));
	    ModelLoader.setCustomModelResourceLocation(RegistryHandler.ModItems.DARKSTARSABER, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + DARKSTARSABER.name,"inventory"));

//	    Render renderBlock =Minecraft.getMinecraft().getBlockRendererDispatcher();
	    // Register player dummy entity
//        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "PlayerDummy"), EntityPlayerDummy.class, "PlayerDummy", Reference.ENTITY_PLAYER_DUMMY, Reference.MOD_ID, 5, 100, false);

	 
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
//    	RFP2.state = new State();
    }

    public static void registerEntityRenderers() {
        
        
//        RenderingRegistry.registerEntityRenderingHandler(EntityDecepticonBrute.class, RenderDecepticonBrute::new);
//        RenderingRegistry.registerEntityRenderingHandler(EntityDecepticonVehiconVariant1.class, RenderDecepticonVehiconVariant1::new);
//        RenderingRegistry.registerEntityRenderingHandler(EntityDecepticonVehiconVariant2.class, RenderDecepticonVehiconVariant2::new);
//        
//        RenderingRegistry.registerEntityRenderingHandler(EntityVehicon.class, RenderVehicon::new);
//        RenderingRegistry.registerEntityRenderingHandler(EntitySwindle.class, RenderSwindle::new);
//        RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, RenderBullet::new);
//        RenderingRegistry.registerEntityRenderingHandler(EntityLargeRocket.class, RenderRocket::new);
        
     // Register player dummy entity
//        RenderingRegistry.registerEntityRenderingHandler(EntityPlayerDummy.class, RenderPlayerDummy::new);

    }
    
    
    public EntityPlayer getPlayer()
    {
        return mc.player;
    }
    
    
    
    @Override
	@Nullable
	public EntityLivingBase getEntityLivingBase(MessageContext context, int entityID)
	{
		final EntityPlayer player = context.side.isClient() ? Minecraft.getMinecraft().player : context.getServerHandler().player;
		final Entity entity = player.world.getEntityByID(entityID);
		return entity instanceof EntityLivingBase ? (EntityLivingBase) entity : null;
	}

	@Override
	public void serverStarting(FMLServerStartingEvent event) {
		// TODO Auto-generated method stub
		
	}
}
