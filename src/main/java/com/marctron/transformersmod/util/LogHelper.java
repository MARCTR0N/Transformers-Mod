package com.marctron.transformersmod.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.FMLLog;
import org.apache.logging.log4j.Level;


public class LogHelper {
	
	private static Logger logger;
	
	public static Logger getLogger() {
		if (logger == null) {
			logger = LogManager.getFormatterLogger(Reference.MOD_ID);
		}
		return logger;
	}
	
    public static void log(Level logLevel, Object object) {
        FMLLog.log(Reference.MOD_ID, logLevel, String.valueOf(object));
    }

    
    public static void all(Object object) {
        log(Level.ALL, object);
    }

    public static void debug(Object object) {
        log(Level.DEBUG, object);
    }

    public static void error(Object object) {
        log(Level.ERROR, object);
    }

    public static void fatal(Object object) {
        log(Level.FATAL, object);
    }

    public static void info(Object object) {
        log(Level.INFO, object);
    }

    public static void off(Object object) {
        log(Level.OFF, object);
    }

    public static void trace(Object object) {
        log(Level.TRACE, object);
    }

    public static void warn(Object object) {
        log(Level.WARN, object);
    }

	public static void fatal(String string, ResourceLocation registryName) {
		// TODO Auto-generated method stub
		
	}
}
