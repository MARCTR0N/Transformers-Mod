package com.marctron.transformersmod.blocks.obj;

import javax.annotation.Nullable;

import com.marctron.transformersmod.blocks.BlockBase;
import com.marctron.transformersmod.blocks.tileentity.TileEntityLock;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TestBlock extends BlockBase{

	public static final PropertyBool FULLCONTENT = PropertyBool.create("fullcontent");
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	
	public TestBlock(String name, Material material) {
		super(name, material);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(FACING, EnumFacing.SOUTH).withProperty(FACING, EnumFacing.EAST).withProperty(FACING, EnumFacing.WEST).withProperty(FULLCONTENT, Boolean.valueOf(false)));
		// TODO Auto-generated constructor stub
	}
	
	
	 public boolean isOpaqueCube(IBlockState state)
	    {
	        return false;
	    }

	    public boolean isFullCube(IBlockState state)
	    {
	        return false;
	    }

	    /**
	     * Determines if an entity can path through this block
	     */
	    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
	    {
	        return true;
	    }
	
	
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
	}
	
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer)).withProperty(FULLCONTENT, Boolean.valueOf(false));
    }


	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING, FULLCONTENT});
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		switch(meta) {
		case 0:
			return this.getDefaultState().withProperty(FULLCONTENT, false).withProperty(FACING, EnumFacing.NORTH);
		case 1:
			return this.getDefaultState().withProperty(FULLCONTENT, false).withProperty(FACING, EnumFacing.SOUTH);
		case 2:
			return this.getDefaultState().withProperty(FULLCONTENT, false).withProperty(FACING, EnumFacing.EAST);
		case 3:
			return this.getDefaultState().withProperty(FULLCONTENT, false).withProperty(FACING, EnumFacing.WEST);
		case 4:
			return this.getDefaultState().withProperty(FULLCONTENT, true).withProperty(FACING, EnumFacing.NORTH);
		case 5:
			return this.getDefaultState().withProperty(FULLCONTENT, true).withProperty(FACING, EnumFacing.SOUTH);
		case 6:
			return this.getDefaultState().withProperty(FULLCONTENT, true).withProperty(FACING, EnumFacing.EAST);
		case 7:
			return this.getDefaultState().withProperty(FULLCONTENT, true).withProperty(FACING, EnumFacing.WEST);
		}
		return this.getDefaultState().withProperty(FULLCONTENT, meta == 1);
	}

	@SuppressWarnings("incomplete-switch")
	@Override
	public int getMetaFromState(IBlockState state) {
		if (!state.getValue(FULLCONTENT)) {
			switch (state.getValue(FACING)) {
			case NORTH:
				return 0;
			case SOUTH:
				return 1;
			case EAST:
				return 2;
			case WEST:
				return 3;
			}
		} else {
			switch (state.getValue(FACING)) {
			case NORTH:
				return 4;
			case SOUTH:
				return 5;
			case EAST:
				return 6;
			case WEST:
				return 7;
			}
		}
		return 0;
	}
	
	
}
