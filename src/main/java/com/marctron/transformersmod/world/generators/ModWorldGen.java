package com.marctron.transformersmod.world.generators;


import com.marctron.transformersmod.util.handlers.RegistryHandler;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class ModWorldGen implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case -1:
                generateNether(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
                break;

            case 0:
                generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
                break;

            case 1:
                generateEnd(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
                break;
        }

    }

    private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        generateOre(RegistryHandler.ModBlocks.BLUE_ENERGON_ORE_BLOCK.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 1, 100, random.nextInt(9) + 4, 8, Blocks.STONE);
        generateOre(RegistryHandler.ModBlocks.RED_ENERGON_ORE_BLOCK.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 1, 66, random.nextInt(8) + 5, 7, Blocks.STONE);
        generateOre(RegistryHandler.ModBlocks.DARK_ENERGON_ORE_BLOCK.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 1, 33, random.nextInt(7) + 4, 6, Blocks.STONE);
        generateOre(RegistryHandler.ModBlocks.TRANSFORMIUM_ORE_BLOCK.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 1, 70, random.nextInt(6) + 2, 8, Blocks.STONE);
    }

    private void generateNether(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        generateOre(RegistryHandler.ModBlocks.RED_ENERGON_ORE_BLOCK_NETHERRACK.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 1, 100, random.nextInt(8) + 16, 16, Blocks.NETHERRACK);

    }

    private void generateEnd(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        generateOre(RegistryHandler.ModBlocks.DARK_ENERGON_ORE_BLOCK_END_STONE.getDefaultState(), world, random, chunkX * 16, chunkZ * 16, 1, 130, random.nextInt(8) + 12, 12, Blocks.END_STONE);

    }

//	private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances, Block bl﻿oc﻿﻿k﻿﻿﻿﻿)
//	{
//		int deltaY = maxY - minY;
//		
//		for (int i = 0; i < chances; i++) {
//			BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));
//			
//			WorldGenMinable generator = new WorldGenMinable(ore, size, BlockMatcher.forBlock(bl﻿oc﻿﻿k﻿﻿﻿﻿));
//			generator.generate(world, random, pos);
//		}
//	}

    private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY, int size, int chances, Block block) {
        int deltaY = maxY - minY;

        for (int i = 0; i < chances; i++) {
            BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));

            WorldGenMinable generator = new WorldGenMinable(ore, size, BlockMatcher.forBlock(block));
            generator.generate(world, random, pos);
        }
    }
}
