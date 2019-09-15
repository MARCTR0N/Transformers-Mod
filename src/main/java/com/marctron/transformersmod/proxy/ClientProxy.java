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

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public class ClientProxy implements IProxy {

    public static final KeyBinding ALT_MODE = new KeyBinding("key.transform", Keyboard.KEY_X, "category.transformers");
    public static final KeyBinding ROBOT_MODE = new KeyBinding("key.robotmode", Keyboard.KEY_Y, "category.transformers");

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(new ClientEvents());
        ClientRegistry.registerKeyBinding(ROBOT_MODE);
        ClientRegistry.registerKeyBinding(ALT_MODE);
        registerEntityRenderers();
    }

    @Override
    public void init(FMLInitializationEvent e) {

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
