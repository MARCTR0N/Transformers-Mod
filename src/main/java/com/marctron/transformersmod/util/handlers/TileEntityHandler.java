package com.marctron.transformersmod.util.handlers;


import com.marctron.transformersmod.blocks.energonstorage.TileEntityEnergonStorage;
import com.marctron.transformersmod.blocks.machinery.energonengine.EnergonEngineTile;
import com.marctron.transformersmod.blocks.tileentity.TileEntityEnergonCrate;
import com.marctron.transformersmod.blocks.wfc.lock.TileEntityLock;
import com.marctron.transformersmod.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
    public static void registerTileEntities() {
        GameRegistry.registerTileEntity(TileEntityEnergonCrate.class, new ResourceLocation(Reference.MOD_ID + ":energon_crate_block"));
//        GameRegistry.registerTileEntity(EnergonEngineTile.class, new ResourceLocation(Reference.MOD_ID + ":energon_engine"));
        GameRegistry.registerTileEntity(TileEntityEnergonStorage.class, new ResourceLocation(Reference.MOD_ID + ":energon_storage_block"));
        GameRegistry.registerTileEntity(TileEntityLock.class, new ResourceLocation(Reference.MOD_ID + ":lock_block"));
    }
}
