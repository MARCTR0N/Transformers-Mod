package com.marctron.transformersmod.init;

import javax.annotation.Nullable;

import com.marctron.transformersmod.cybertronworldgen.WorldProviderCybertron;
import com.marctron.transformersmod.cybertronworldgen.WorldTypeCybertron;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry.IVillageCreationHandler;

public class CybertronWorldGen 
{  
    public static final String CYBERTRON_NAME = "cybertron";
    public static final int CYBERTRON_DIM_ID = findFreeDimensionID();
    public static final DimensionType CYBERTRON_DIM_TYPE = DimensionType.register(CYBERTRON_NAME, "_"+CYBERTRON_NAME, CYBERTRON_DIM_ID, WorldProviderCybertron.class, false);
    public static final WorldType CYBERTRON_WORLD_TYPE = new WorldTypeCybertron(); // although instance isn't used, must create the instance to register the WorldType
   
    // public static final IVillageCreationHandler CLOUD_VILLAGE_HANDLER = new VillageHouseCloudCreationHandler();
    
    /**
     * Register dimensions.
     */
    public static final void registerDimensions()
    {
        DimensionManager.registerDimension(CYBERTRON_DIM_ID, CYBERTRON_DIM_TYPE);
    }
    
    @Nullable
    private static Integer findFreeDimensionID()
    {
        for (int i=2; i<Integer.MAX_VALUE; i++)
        {
            if (!DimensionManager.isDimensionRegistered(i))
            {
                // DEBUG
                System.out.println("Found free dimension ID = "+i);
                return i;
            }
        }
        
        // DEBUG
        System.out.println("ERROR: Could not find free dimension ID");
        return null;
    }

    /**
     * Register world generators.
     */
   /** public static void registerWorldGenerators()
     *	{
     *  	// DEBUG
     *   	System.out.println("Registering world generators");
     *   	GameRegistry.registerWorldGenerator(new WorldGenShrine(), 10);
    }*/
}