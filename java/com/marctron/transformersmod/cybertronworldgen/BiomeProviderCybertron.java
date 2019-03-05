package com.marctron.transformersmod.cybertronworldgen;

import com.marctron.transformersmod.init.ModBiomes;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class BiomeProviderCybertron extends BiomeProvider
{
    
    /**
     * Instantiates a new biome provider cloud.
     */
    public BiomeProviderCybertron(World world) {
		super(world.getWorldInfo());
		allowedBiomes.clear();
		allowedBiomes.add(ModBiomes.CYBERTRON);

		getBiomesToSpawnIn().clear();
		getBiomesToSpawnIn().add(ModBiomes.CYBERTRON);
	}

	@Override
	public GenLayer[] getModdedBiomeGenerators(WorldType worldType, long seed, GenLayer[] original) {
		GenLayer biomes = new GenLayerBiomesCybertron(1);

		biomes = new GenLayerBiomesCybertron(1000, biomes);
		biomes = new GenLayerZoom(1000, biomes);
		biomes = new GenLayerZoom(1001, biomes);
		biomes = new GenLayerZoom(1002, biomes);
		biomes = new GenLayerZoom(1003, biomes);
		biomes = new GenLayerZoom(1004, biomes);

		GenLayer biomeIndexLayer = new GenLayerVoronoiZoom(10L, biomes);
		biomeIndexLayer.initWorldGenSeed(seed);

		return new GenLayer[] { biomes, biomeIndexLayer };
	}
}
