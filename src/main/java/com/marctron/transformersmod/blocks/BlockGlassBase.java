package com.marctron.transformersmod.blocks;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.init.ModBlocks;
import com.marctron.transformersmod.init.ModItems;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;

import java.util.Random;

public class BlockGlassBase extends BlockBreakable {
    public BlockGlassBase(String name, Material material, boolean ignoreSimilarity) {
        super(material, ignoreSimilarity);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tabTransformers);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

//    @Override
//	public boolean isOpaqueCube(IBlockState state)
//	{
//		return false;
//	}

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    protected boolean canSilkHarvest() {
        return true;
    }
}
