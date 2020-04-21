package com.marctron.transformersmod.blocks;

import com.marctron.transformersmod.blocks.tileentity.TileEntityCreativeGenerator;
import com.marctron.transformersmod.util.handlers.RegistryHandler;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockCreativeGenerator extends AbstractBlockContainer {
    public BlockCreativeGenerator(String name, Material material) {
        super(name, material);
        setBlockUnbreakable();
        
        RegistryHandler.Registry.registerItemBlock(this);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityCreativeGenerator();
    }
}