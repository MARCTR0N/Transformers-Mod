package com.marctron.transformersmod.util.handlers;

import com.marctron.transformersmod.blocks.tileentity.TileEntityEnergonCrate;
import com.marctron.transformersmod.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler 
{
	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityEnergonCrate.class, new ResourceLocation(Reference.MOD_ID + ":energon_crate_block"));
	}	
}
