package com.marctron.transformersmod.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/** @author Toma */
public interface IProxy {
    void preInit(FMLPreInitializationEvent e);
    void init(FMLInitializationEvent e);
    void postInit(FMLPostInitializationEvent e);
}
