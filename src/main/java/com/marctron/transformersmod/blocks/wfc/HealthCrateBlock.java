package com.marctron.transformersmod.blocks.wfc;

import java.util.Random;

import com.marctron.transformersmod.blocks.BlockBase;
import com.marctron.transformersmod.util.handlers.RegistryHandler;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HealthCrateBlock extends BlockBase {

	public HealthCrateBlock(String name, Material material) {
		super(name, material);
		// TODO Auto-generated constructor stub
	}

	 @Override
	    public Item getItemDropped(IBlockState state, Random par2Random, int par3) {
	        return new ItemStack(RegistryHandler.ModItems.MEDKIT).getItem();

	    }
}
