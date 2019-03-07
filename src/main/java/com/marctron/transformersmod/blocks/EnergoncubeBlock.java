package com.marctron.transformersmod.blocks;

import net.minecraft.block.SoundType;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EnergoncubeBlock extends BlockBase
{

	public EnergoncubeBlock(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.METAL);
		setHardness(5.0F);
		setHarvestLevel("pickaxe", 2);
		this.setLightLevel(0.7F);
	}
	

}
