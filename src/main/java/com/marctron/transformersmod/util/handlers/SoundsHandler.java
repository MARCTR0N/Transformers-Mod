package com.marctron.transformersmod.util.handlers;

import com.marctron.transformersmod.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler 
{
	public static SoundEvent ENTITY_VEHICON_AMBIENT, ENTITY_VEHICON_HURT, ENTITY_VEHICON_DEATH;
	
	public static void registerSounds()
	{
		ENTITY_VEHICON_AMBIENT = registerSound("entity.vehicon.ambient");
		ENTITY_VEHICON_HURT = registerSound("entity.vehicon.hurt");
		ENTITY_VEHICON_DEATH = registerSound("entity.vehicon.death");
	}
	
	private static SoundEvent registerSound(String name)
	{
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		SoundEvent event = new SoundEvent(location);
		event.setRegistryName(name);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}
}
