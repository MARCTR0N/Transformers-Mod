package com.marctron.transformersmod.init;


import com.marctron.transformersmod.util.ModConfiguration;
import com.marctron.transformersmod.world.biomes.BiomeCybertron;

import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBiomes {
	
public static final Biome CYBERTRON = new BiomeCybertron(); 
	
	public static void registerBiomes()
	{
		initBiome(CYBERTRON, "Cybertron", BiomeType.WARM, Type.HILLS, Type.PLAINS, Type.DRY);
	}
	
	private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
		
		if(ModConfiguration.spawnCustomBiomesInOverworld) 
		{
			BiomeManager.addSpawnBiome(biome);
		}
		return biome;
	}
}


