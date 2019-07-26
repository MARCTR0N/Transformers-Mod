package com.marctron.transformersmod.proxy;

import com.marctron.transformersmod.events.ClientEvents;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.input.Keyboard;

public class ClientProxy implements IProxy {

    public static final KeyBinding MY_KEYBINDING = new KeyBinding("key.transform", Keyboard.KEY_X, "category.transformers");
    public static final KeyBinding ROBOT_MODE = new KeyBinding("key.robotmode", Keyboard.KEY_Y, "category.transformers");

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(new ClientEvents());
        ClientRegistry.registerKeyBinding(ROBOT_MODE);
        ClientRegistry.registerKeyBinding(MY_KEYBINDING);
        registerEntityRenderers();
    }

    @Override
    public void init(FMLInitializationEvent e) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }

    private static void registerEntityRenderers() {
        //RenderingRegistry.registerEntityRenderingHandler(Entity.class, RenderEntity::new);
    }
}
