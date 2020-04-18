package com.marctron.transformersmod.blocks;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.blocks.tileentity.TileEntityLock;
import com.marctron.transformersmod.util.Reference;
import com.marctron.transformersmod.util.handlers.RegistryHandler;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class LockBlock extends BlockContainer {

	public static final PropertyBool FULLCONTENT = PropertyBool.create("fullcontent");

	public LockBlock(String name, Material mat) {
		super(mat);

		setRegistryName(name);
		setCreativeTab(Main.tabTransformers);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FULLCONTENT, false));

		RegistryHandler.Registry.registerItemBlock(this);
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
		return new BlockStateContainer(this, new IProperty[] { FULLCONTENT });
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FULLCONTENT, meta == 1);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		if (state.getValue(FULLCONTENT).booleanValue()) {
			return 1;
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

	@Nullable
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityLock();
	}
}
