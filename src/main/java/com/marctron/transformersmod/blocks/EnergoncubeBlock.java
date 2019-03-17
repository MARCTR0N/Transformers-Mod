package com.marctron.transformersmod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class EnergoncubeBlock extends BlockBase
{

	public EnergoncubeBlock(String name, Material material) {
		super(name, material);
		this.setSoundType(SoundType.METAL);
		this.setHardness(5.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setLightLevel(0.6F);
	}


}