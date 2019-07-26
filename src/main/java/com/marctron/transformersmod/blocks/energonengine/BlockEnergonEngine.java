package com.marctron.transformersmod.blocks.energonengine;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.blocks.AbstractBlockContainer;
import com.marctron.transformersmod.util.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockEnergonEngine extends AbstractBlockContainer {
    public BlockEnergonEngine() {
        super("energon_engine", Material.IRON);
        setBlockUnbreakable();

    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            playerIn.openGui(Main.instance, Reference.GUI_ENERGON_ENGINE, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }

        return true;
    }


    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntityEnergonEngine tileentity = (TileEntityEnergonEngine) worldIn.getTileEntity(pos);
        worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), tileentity.handler.getStackInSlot(0)));
        super.breakBlock(worldIn, pos, state);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        // TODO Auto-generated method stub
        return new TileEntityEnergonEngine();
    }


}
