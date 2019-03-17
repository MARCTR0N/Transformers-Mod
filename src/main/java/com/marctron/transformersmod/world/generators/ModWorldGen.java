package com.marctron.transformersmod.world.generators;

import java.util.Random;

import com.marctron.transformersmod.init.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch(world.provider.getDimension())
				{
				case -1:
					generateNether(random, chunkX * 16, chunkZ * 16, world, chunkGenerator, chunkProvider);
					break;
					
				case 0:
					generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
					break;
					
				case 1:
					generateEnd(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
					break;
				}
		/*
		if (world.provider.getDimension() == 0) {
			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
		if (world.provider.getDimension() == -1) {
			generateNether(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
		if (world.provider.getDimension() == 1) {
			generateEnd(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
		*/
	}
	
	private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		generateOre(ModBlocks.ENERGON_ORE_BLOCK.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 1, 100, random.nextInt(8) + 4, 8);
		generateOre(ModBlocks.RED_ENERGON_ORE_BLOCK.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 1, 66, random.nextInt(8) + 5, 7);
		generateOre(ModBlocks.DARK_ENERGON_ORE_BLOCK.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 1, 33, random.nextInt(8) + 4, 6);
		generateOre(ModBlocks.TRANSFORMIUM_ORE_BLOCK.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 1, 70, random.nextInt(6) + 2, 8);
	}
	
	private void generateNether(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		generateOre(ModBlocks.RED_ENERGON_ORE_BLOCK.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 1, 100, random.nextInt(8) + 4, 8);
		
	}
	
	private void generateEnd(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		generateOre(ModBlocks.DARK_ENERGON_ORE_BLOCK.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 1, 100, random.nextInt(8) + 4, 8);
		
	}
	
	private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances) 
	{
		int deltaY = maxY - minY;
		
		for (int i = 0; i < chances; i++) {
			BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));
			
			WorldGenMinable generator = new WorldGenMinable(ore, size);
			generator.generate(world, random, pos);
		}
	}
}
