package com.marctron.transformersmod.blocks.deco;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockCybertron1 extends BlockHorizontalBase{

	public BlockCybertron1(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.METAL);
        setHardness(50.0F);
        setHarvestLevel("pickaxe", 3);
	}

}
