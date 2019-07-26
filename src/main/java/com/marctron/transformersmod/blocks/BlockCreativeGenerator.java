package com.marctron.transformersmod.blocks;

import com.marctron.transformersmod.blocks.tileentity.TileEntityCreativeGenerator;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockCreativeGenerator extends AbstractBlockContainer {
    public BlockCreativeGenerator() {
        super("creative_generator", Material.IRON);
        setBlockUnbreakable();
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityCreativeGenerator();
    }
}