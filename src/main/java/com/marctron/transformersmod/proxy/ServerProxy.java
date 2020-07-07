package com.marctron.transformersmod.proxy;

import javax.annotation.Nullable;

import com.marctron.transformersmod.events.CommonEvents;
import com.marctron.transformersmod.resize.attributes.AttachAttributes;
import com.marctron.transformersmod.resize.compatibilities.Capabilities;
import com.marctron.transformersmod.resize.compatibilities.CapabilitiesHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/** Only <b>SERVER</b> related code **/
public class ServerProxy implements IProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
    	Capabilities.init();
        MinecraftForge.EVENT_BUS.register(new CommonEvents());
    }

    @Override
    public void init(FMLInitializationEvent e) {

    	MinecraftForge.EVENT_BUS.register(new CapabilitiesHandler());
		MinecraftForge.EVENT_BUS.register(new AttachAttributes());
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }

	@Override
	public EntityPlayer getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Nullable
	public EntityLivingBase getEntityLivingBase(MessageContext context, int entityID)
	{
		if(context.side.isServer())
		{
			final Entity entity = context.getServerHandler().player.world.getEntityByID(entityID);
			return entity instanceof EntityLivingBase ? (EntityLivingBase) entity : null;
		}
		throw new WrongSideException("Tried to get the player from a client-side MessageContext on the dedicated server");
	}

	@Override
	public void serverStarting(FMLServerStartingEvent event) {
		// TODO Auto-generated method stub
		
	}
}
