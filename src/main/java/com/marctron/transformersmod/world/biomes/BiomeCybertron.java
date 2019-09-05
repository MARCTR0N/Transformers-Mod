package com.marctron.transformersmod.world.biomes;

import com.marctron.transformersmod.entity.EntityVehicon;

import com.marctron.transformersmod.util.handlers.RegistryHandler;

import net.minecraft.world.biome.Biome;

public class BiomeCybertron extends Biome {
    public BiomeCybertron() {
        super(new BiomeProperties("Cybertron").setBaseHeight(1.0F).setHeightVariation(1.0F).setRainDisabled().setTemperature(1.0F).setWaterColor(16711861));

        topBlock = RegistryHandler.ModBlocks.TRANSFORMIUM_BLOCK.getDefaultState();
        fillerBlock = RegistryHandler.ModBlocks.TRANSFORMIUM_ORE_BLOCK.getDefaultState();

        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();

        this.spawnableCreatureList.add(new SpawnListEntry(EntityVehicon.class, 5, 1, 5));
    }

}
