package com.marctron.transformersmod.init;

import java.util.ArrayList;
import java.util.List;

import com.marctron.transformersmod.blocks.BlockBase;
import com.marctron.transformersmod.blocks.BlockEnergonCrate;
import com.marctron.transformersmod.blocks.BlockGlassBase;
import com.marctron.transformersmod.blocks.BlueEnergonoreBlock;
import com.marctron.transformersmod.blocks.DarkEnergonoreBlock;
import com.marctron.transformersmod.blocks.EnergoncubeBlock;
import com.marctron.transformersmod.blocks.EnergonoreBlock;
import com.marctron.transformersmod.blocks.ItemSpawner;
import com.marctron.transformersmod.blocks.RedEnergonoreBlock;
import com.marctron.transformersmod.blocks.TransformiumoreBlock;
import com.marctron.transformersmod.blocks.energonengine.BlockEnergonEngine;
import com.marctron.transformersmod.blocks.energonstorage.BlockEnergonStorage;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	
	public static final Block ENERGON_CUBE_BLOCK = new EnergoncubeBlock("energon_cube_block", Material.IRON).setHardness(3);
	public static final Block RED_ENERGON_CUBE_BLOCK = new EnergoncubeBlock("red_energon_cube_block", Material.IRON).setHardness(3);
	public static final Block BLUE_ENERGON_CUBE_BLOCK = new EnergoncubeBlock("blue_energon_cube_block", Material.IRON).setHardness(3);
	public static final Block DARK_ENERGON_CUBE_BLOCK = new EnergoncubeBlock("dark_energon_cube_block", Material.IRON).setHardness(3);
	public static final Block SYNTHETIC_ENERGON_CUBE_BLOCK = new EnergoncubeBlock("synthetic_energon_cube_block", Material.IRON).setHardness(3);
	
	public static final Block ENERGON_ORE_BLOCK = new EnergonoreBlock("energon_ore_block", Material.IRON, true);
	public static final Block RED_ENERGON_ORE_BLOCK = new RedEnergonoreBlock("red_energon_ore_block", Material.IRON, true);
	public static final Block BLUE_ENERGON_ORE_BLOCK = new BlueEnergonoreBlock("blue_energon_ore_block", Material.IRON, true);
	public static final Block DARK_ENERGON_ORE_BLOCK = new DarkEnergonoreBlock("dark_energon_ore_block", Material.IRON, true);
	public static final Block RED_ENERGON_ORE_BLOCK_NETHERRACK = new RedEnergonoreBlock("red_energon_ore_block_netherrack", Material.IRON, true);
	public static final Block DARK_ENERGON_ORE_BLOCK_END_STONE = new DarkEnergonoreBlock("dark_energon_ore_block_end_stone", Material.IRON, true);
	
	public static final Block TRANSFORMIUM_BLOCK = new BlockBase("transformium_block", Material.IRON).setHardness(3);
	public static final Block TRANSFORMIUM_ORE_BLOCK = new TransformiumoreBlock("transformium_ore_block", Material.IRON);
	
	public static final Block ENERGON_CRATE_BLOCK = new BlockEnergonCrate("energon_crate_block");
	
	public static final Block ITEM_SPAWNER = new ItemSpawner("item_spawner");
	
	public static final Block SPACE_BRIDGE_BLOCK = new BlockBase("space_bridge_block",Material.IRON);

	//Machinery
	public static final Block ENERGON_ENGINE = new BlockEnergonEngine("energon_engine", Material.IRON);
	public static final Block ENERGON_STORAGE = new BlockEnergonStorage("energon_storage", Material.IRON);

	//Dyed Stuff
	
		//Wool
		public static final Block WOOL_PALE_GREEN = new BlockBase("wool_pale_green",Material.CLOTH);
		public static final Block WOOL_PALE_BROWN = new BlockBase("wool_pale_brown",Material.CLOTH);
		public static final Block WOOL_DARK_RED = new BlockBase("wool_dark_red",Material.CLOTH);
		public static final Block WOOL_DARK_GRAY = new BlockBase("wool_dark_gray",Material.CLOTH);
		public static final Block WOOL_BEIGE= new BlockBase("wool_beige",Material.CLOTH);
		
		//Glass
		public static final Block STAINED_GLASS_PALE_GREEN = new BlockGlassBase("stained_glass_pale_green",Material.GLASS, false);
		public static final Block STAINED_GLASS_PALE_BROWN = new BlockGlassBase("stained_glass_pale_brown",Material.GLASS, false);
		public static final Block STAINED_GLASS_DARK_RED = new BlockGlassBase("stained_glass_dark_red",Material.GLASS, false);
		public static final Block STAINED_GLASS_DARK_GRAY = new BlockGlassBase("stained_glass_dark_gray",Material.GLASS, false);
		public static final Block STAINED_GLASS_BEIGE= new BlockGlassBase("stained_glass_beige",Material.GLASS, false);
		
		//Clay
		public static final Block STAINED_HARDENED_CLAY_PALE_GREEN = new BlockBase("stained_hardened_clay_pale_green",Material.CLAY);
		public static final Block STAINED_HARDENED_CLAY_PALE_BROWN = new BlockBase("stained_hardened_clay_pale_brown",Material.CLAY);
		public static final Block STAINED_HARDENED_CLAY_DARK_RED = new BlockBase("stained_hardened_clay_dark_red",Material.CLAY);
		public static final Block STAINED_HARDENED_CLAY_DARK_GRAY = new BlockBase("stained_hardened_clay_dark_gray",Material.CLAY);
		public static final Block STAINED_HARDENED_CLAY_BEIGE= new BlockBase("stained_hardened_clay_beige",Material.CLAY);
		
}
