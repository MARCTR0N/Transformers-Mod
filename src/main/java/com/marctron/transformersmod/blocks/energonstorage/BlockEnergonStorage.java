package com.marctron.transformersmod.blocks.energonstorage;

import com.marctron.transformersmod.Main;


import com.marctron.transformersmod.util.Reference;
import com.marctron.transformersmod.util.handlers.RegistryHandler;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockEnergonStorage extends Block {
    public BlockEnergonStorage(String name, Material material) {
        super(material);
      
        setRegistryName(name);
        setCreativeTab(Main.tabTransformers);
        RegistryHandler.Registry.registerItemBlock(this);


//        ModBlocks.BLOCKS.add(this);
//        RegistryHandler.Registry.onItemRegister(this);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityEnergonStorage();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            playerIn.openGui(Main.instance, Reference.GUI_ENERGON_STORAGE, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }

        return true;
    }
}
