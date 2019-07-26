package com.marctron.transformersmod.util.handlers;

import com.marctron.transformersmod.blocks.energonengine.TileEntityEnergonEngine;
import com.marctron.transformersmod.blocks.energonstorage.TileEntityEnergonStorage;
import com.marctron.transformersmod.blocks.tileentity.TileEntityEnergonCrate;
import com.marctron.transformersmod.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
    public static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityEnergonCrate.class, new ResourceLocation(Reference.MOD_ID + ":energon_crate_block"));
        GameRegistry.registerTileEntity(TileEntityEnergonEngine.class, new ResourceLocation(Reference.MOD_ID + ":energon_engine_block"));
        GameRegistry.registerTileEntity(TileEntityEnergonStorage.class, new ResourceLocation(Reference.MOD_ID + ":energon_storage_block"));
    }
}
