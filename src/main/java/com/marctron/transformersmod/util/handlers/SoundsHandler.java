package com.marctron.transformersmod.util.handlers;

import com.marctron.transformersmod.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundsHandler {
//	public static SoundEvent ENTITY_VEHICON_AMBIENT, ENTITY_VEHICON_HURT, ENTITY_VEHICON_DEATH;
//	
//	public static void init()
//	{
//		ENTITY_VEHICON_AMBIENT = registerSound("entity.vehicon.ambient");
//		ENTITY_VEHICON_HURT = registerSound("entity.vehicon.hurt");
//		ENTITY_VEHICON_DEATH = registerSound("entity.vehicon.death");
//	}

    //private static int size = 0;

    public static SoundEvent TRANSFORMONE;
    public static SoundEvent TRANSFORMTWO;
    
    public static SoundEvent WFCPRIMEROBOT;
    public static SoundEvent WFCPRIMEVEHICLE;
    
    public static SoundEvent HAMMERPOUND;
    
    public static SoundEvent CARDRIVESTART;
    public static SoundEvent CARDRIVE;

    public static void init() {
        //size = SoundEvent.REGISTRY.getKeys().size();

        TRANSFORMONE = registerSound("transformation.transformone");
        TRANSFORMTWO = registerSound("transformation.transformtwo");
        
        WFCPRIMEROBOT = registerSound("transformation.wfcprimerobot");
        WFCPRIMEVEHICLE = registerSound("transformation.wfcprimevehicle");
        
        HAMMERPOUND = registerSound("misc.hammerpound");
        
        CARDRIVE = registerSound("misc.cardrive");
        CARDRIVESTART = registerSound("misc.cardrivestart");	
    }


    public static SoundEvent registerSound(String name) {
        ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        //SoundEvent.REGISTRY.register(size, location, event);
        //size++;
        return event;
    }

}
