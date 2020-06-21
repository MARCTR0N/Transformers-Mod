package com.marctron.transformersmod.blocks;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.blocks.tileentity.TileEntityLock;
import com.marctron.transformersmod.util.Reference;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class LockBlock extends BlockBase {

	public static final PropertyBool FULLCONTENT = PropertyBool.create("fullcontent");
	public static final PropertyDirection FACING = BlockHorizontal.FACING;

	public LockBlock(String name, Material mat) {
		super(name, mat);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH)
				.withProperty(FULLCONTENT, Boolean.valueOf(false)));
	}

	@Override
	public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return blockState.getValue(FULLCONTENT).booleanValue() ? 15 : 0;
	}

	@Override
	public boolean canProvidePower(IBlockState state) {
		return true;
	}

	public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return ((Boolean) blockState.getValue(FULLCONTENT)).booleanValue() ? 15 : 0;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FULLCONTENT, FACING });
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		switch (meta) {
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

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote)
			playerIn.openGui(Main.instance, Reference.GUI_LOCK, worldIn, pos.getX(), pos.getY(), pos.getZ());

		return true;
	}

	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	/**
	 * Determines if an entity can path through this block
	 */
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
		return true;
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
	}

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing) state.getValue(FACING)));
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 4);
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityLock();
	}
}
