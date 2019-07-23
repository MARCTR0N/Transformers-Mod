package com.marctron.transformersmod.blocks;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.blocks.tileentity.TileEntityCreativeGenerator;
import com.marctron.transformersmod.init.ModBlocks;
import com.marctron.transformersmod.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCreativeGenerator extends AbstractBlockContainer
{
    public BlockCreativeGenerator()
    {
        super("creative_generator", Material.IRON);
        setBlockUnbreakable();
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityCreativeGenerator();
    }
}