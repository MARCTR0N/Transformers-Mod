package com.marctron.transformersmod.proxy;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/** @author Toma */
public interface IProxy {
    void preInit(FMLPreInitializationEvent e);
    void init(FMLInitializationEvent e);
    void postInit(FMLPostInitializationEvent e);
    void serverStarting(FMLServerStartingEvent event);
	
	
    public EntityPlayer getPlayer();
    
    @Nullable
	public EntityLivingBase getEntityLivingBase(MessageContext context, int entityID);
    
    class WrongSideException extends RuntimeException
	{
		public WrongSideException(final String message)
		{
			super(message);
		}

		public WrongSideException(final String message, final Throwable cause)
		{
			super(message, cause);
		}
	}
}
