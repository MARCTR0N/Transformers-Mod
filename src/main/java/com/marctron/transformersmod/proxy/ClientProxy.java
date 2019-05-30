package com.marctron.transformersmod.proxy;

import org.lwjgl.input.Keyboard;

import com.marctron.transformersmod.events.ClientEvents;
import com.marctron.transformersmod.util.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraft.util.ResourceLocation;

public class ClientProxy extends CommonProxy 
{
	
	public static final KeyBinding MY_KEYBINDING = new KeyBinding ("key.transform", Keyboard.KEY_X, "category.transformers");
	public static final KeyBinding ROBOT_MODE = new KeyBinding ("key.robotmode", Keyboard.KEY_Y, "category.transformers");
	@Override
	public void register()
    {
		MinecraftForge.EVENT_BUS.register(new ClientEvents());
        ClientRegistry.registerKeyBinding(MY_KEYBINDING);
        MinecraftForge.EVENT_BUS.register(new ClientEvents());
        ClientRegistry.registerKeyBinding(ROBOT_MODE);
    }
	
	
		
    
	
	
	@Override
	public void registerItemRenderer(Item item, int meta, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	@Override
	public void registerVariantRenderer(Item item, int meta, String filename, String id) 
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MOD_ID, filename), id));
	}
}
