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
import com.marctron.transformersmod.transformers.transformer.sideswipe.ArmorModelSideswipe;
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
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_HELMET).setRenderer(RENDERER);
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_CHESTPLATE).setRenderer(RENDERER); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_LEGGINGS).setRenderer(RENDERER); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_BOOTS).setRenderer(RENDERER); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_MID_HELMET).setRenderer(RENDERER_NO_ITEM); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_MID_CHESTPLATE).setRenderer(RENDERER_NO_ITEM); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_MID_LEGGINGS).setRenderer(RENDERER_NO_ITEM); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_MID_BOOTS).setRenderer(RENDERER_NO_ITEM); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_MID2_HELMET).setRenderer(RENDERER_NO_ITEM); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_MID2_CHESTPLATE).setRenderer(RENDERER_NO_ITEM); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_MID2_LEGGINGS).setRenderer(RENDERER_NO_ITEM); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_MID2_BOOTS).setRenderer(RENDERER_NO_ITEM); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_MID3_HELMET).setRenderer(RENDERER_NO_ITEM); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_MID3_CHESTPLATE).setRenderer(RENDERER_NO_ITEM); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_MID3_LEGGINGS).setRenderer(RENDERER_NO_ITEM); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_MID3_BOOTS).setRenderer(RENDERER_NO_ITEM); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_MID4_HELMET).setRenderer(RENDERER_NO_ITEM); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_MID4_CHESTPLATE).setRenderer(RENDERER_NO_ITEM); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_MID4_LEGGINGS).setRenderer(RENDERER_NO_ITEM); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_MID4_BOOTS).setRenderer(RENDERER_NO_ITEM); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_ALTMODE_HELMET).setRenderer(RENDERER_NO_ITEM); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_ALTMODE_CHESTPLATE).setRenderer(RENDERER_NO_ITEM); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_ALTMODE_LEGGINGS).setRenderer(RENDERER_NO_ITEM); 
    	((ArmorModelSideswipe)ModItems.SIDESWIPE_ALTMODE_BOOTS).setRenderer(RENDERER_NO_ITEM);
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
