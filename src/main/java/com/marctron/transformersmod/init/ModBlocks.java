package com.marctron.transformersmod.init;

import java.util.ArrayList;
import java.util.List;

import com.marctron.transformersmod.blocks.BlockBase;
import com.marctron.transformersmod.blocks.BlockEnergonCrate;
import com.marctron.transformersmod.blocks.EnergoncubeBlock;
import com.marctron.transformersmod.blocks.EnergonoreBlock;
import com.marctron.transformersmod.blocks.TransformiumoreBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	
	public static final Block ENERGON_CUBE_BLOCK = new EnergoncubeBlock("energon_cube_block", Material.IRON).setHardness(3);
	public static final Block ENERGON_ORE_BLOCK = new EnergonoreBlock("energon_ore_block", Material.IRON);
	public static final Block TRANSFORMIUM_BLOCK = new BlockBase("transformium_block", Material.IRON).setHardness(3);
	public static final Block TRANSFORMIUM_ORE_BLOCK = new TransformiumoreBlock("transformium_ore_block", Material.IRON);
	
	public static final Block ENERGON_CRATE_BLOCK = new BlockEnergonCrate("energon_crate_block");
	
	
	public static final Block SPACE_BRIDGE_BLOCK = new BlockBase("space_bridge_block",Material.IRON);


}
