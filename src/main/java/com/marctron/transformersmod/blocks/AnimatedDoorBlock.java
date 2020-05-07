package com.marctron.transformersmod.blocks;

import java.util.Random;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.blocks.tileentity.AnimatedDoorTileEntity;
import com.marctron.transformersmod.util.handlers.RegistryHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class AnimatedDoorBlock extends Block {

	private String name;
	public static final PropertyDirection FACING = BlockHorizontal.FACING;

	public AnimatedDoorBlock(String name, Material material) {
		super(material);
		this.setUnlocalizedName(name);
		setRegistryName(name);
		this.name = name;
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		if (name.equals("door_block_external")) {
			setCreativeTab(Main.tabTransformers);
			RegistryHandler.Registry.registerItemBlock(this);
		}
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return name.equals("door_block");
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {

		switch (blockState.getValue(FACING)) {
		case NORTH:
		case SOUTH:
			switch (name) {
			case "door_block":
				if (worldIn.getTileEntity(pos) != null && worldIn.getTileEntity(pos) instanceof AnimatedDoorTileEntity)
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos)).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0, 0, 0.49, 1, 1, 0.63);
			case "door_block_internal":
				if (worldIn.getTileEntity(pos.east()) != null
						&& worldIn.getTileEntity(pos.east()) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.east())).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0, 0, 0.49, 1, 1, 0.63);
				} else {
					if (worldIn.getTileEntity(pos.west()) != null
							&& worldIn.getTileEntity(pos.west()) instanceof AnimatedDoorTileEntity)
						return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.west())).isOpened() ? NULL_AABB
								: new AxisAlignedBB(0, 0, 0.49, 1, 1, 0.63);
				}
			case "door_block_external":
				if (worldIn.getTileEntity(pos.up()) != null
						&& worldIn.getTileEntity(pos.up()) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.up())).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0, 0, 0.49, 1, 1, 0.63);
				}
				if (worldIn.getTileEntity(pos.down()) != null
						&& worldIn.getTileEntity(pos.down()) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.down())).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0, 0, 0.49, 1, 1, 0.63);
				}
				if (worldIn.getTileEntity(pos.west(2)) != null
						&& worldIn.getTileEntity(pos.west(2)) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.west(2))).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0, 0, 0.49, 1, 1, 0.63);
				}
				if (worldIn.getTileEntity(pos.east(2)) != null
						&& worldIn.getTileEntity(pos.east(2)) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.east(2))).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0, 0, 0.49, 1, 1, 0.63);
				}
				if (worldIn.getTileEntity(pos.down().west(2)) != null
						&& worldIn.getTileEntity(pos.down().west(2)) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.down().west(2))).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0, 0, 0.49, 1, 1, 0.63);
				}
				if (worldIn.getTileEntity(pos.down().east(2)) != null
						&& worldIn.getTileEntity(pos.down().east(2)) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.down().east(2))).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0, 0, 0.49, 1, 1, 0.63);
				}
				if (worldIn.getTileEntity(pos.up().east(2)) != null
						&& worldIn.getTileEntity(pos.up().east(2)) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.up().east(2))).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0, 0, 0.49, 1, 1, 0.63);
				}
				if (worldIn.getTileEntity(pos.up().west(2)) != null
						&& worldIn.getTileEntity(pos.up().west(2)) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.up().west(2))).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0, 0, 0.49, 1, 1, 0.63);
				}
				if (worldIn.getTileEntity(pos.down().west()) != null
						&& worldIn.getTileEntity(pos.down().west()) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.down().west())).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0, 0, 0.49, 1, 1, 0.63);
				}
				if (worldIn.getTileEntity(pos.down().east()) != null
						&& worldIn.getTileEntity(pos.down().east()) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.down().east())).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0, 0, 0.49, 1, 1, 0.63);
				}
				if (worldIn.getTileEntity(pos.up().east()) != null
						&& worldIn.getTileEntity(pos.up().east()) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.up().east())).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0, 0, 0.49, 1, 1, 0.63);
				}
				if (worldIn.getTileEntity(pos.up().west()) != null
						&& worldIn.getTileEntity(pos.up().west()) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.up().west())).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0, 0, 0.49, 1, 1, 0.63);
				}
			}
		case WEST:
		case EAST:
			switch (name) {
			case "door_block":
				if (worldIn.getTileEntity(pos) != null && worldIn.getTileEntity(pos) instanceof AnimatedDoorTileEntity)
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos)).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0.49, 0, 0, 0.63, 1, 1);
			case "door_block_internal":
				if (worldIn.getTileEntity(pos.north()) != null
						&& worldIn.getTileEntity(pos.north()) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.north())).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0.49, 0, 0, 0.63, 1, 1);
				} else {
					if (worldIn.getTileEntity(pos.south()) != null
							&& worldIn.getTileEntity(pos.south()) instanceof AnimatedDoorTileEntity)
						return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.south())).isOpened() ? NULL_AABB
								: new AxisAlignedBB(0.49, 0, 0, 0.63, 1, 1);
				}
			case "door_block_external":
				if (worldIn.getTileEntity(pos.up()) != null
						&& worldIn.getTileEntity(pos.up()) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.up())).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0.49, 0, 0, 0.63, 1, 1);
				}
				if (worldIn.getTileEntity(pos.down()) != null
						&& worldIn.getTileEntity(pos.down()) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.down())).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0.49, 0, 0, 0.63, 1, 1);
				}
				if (worldIn.getTileEntity(pos.south(2)) != null
						&& worldIn.getTileEntity(pos.south(2)) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.south(2))).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0.49, 0, 0, 0.63, 1, 1);
				}
				if (worldIn.getTileEntity(pos.north(2)) != null
						&& worldIn.getTileEntity(pos.north(2)) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.north(2))).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0.49, 0, 0, 0.63, 1, 1);
				}
				if (worldIn.getTileEntity(pos.down().south(2)) != null
						&& worldIn.getTileEntity(pos.down().south(2)) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.down().south(2))).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0.49, 0, 0, 0.63, 1, 1);
				}
				if (worldIn.getTileEntity(pos.down().north(2)) != null
						&& worldIn.getTileEntity(pos.down().north(2)) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.down().north(2))).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0.49, 0, 0, 0.63, 1, 1);
				}
				if (worldIn.getTileEntity(pos.up().north(2)) != null
						&& worldIn.getTileEntity(pos.up().north(2)) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.up().north(2))).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0.49, 0, 0, 0.63, 1, 1);
				}
				if (worldIn.getTileEntity(pos.up().south(2)) != null
						&& worldIn.getTileEntity(pos.up().south(2)) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.up().south(2))).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0.49, 0, 0, 0.63, 1, 1);
				}
				if (worldIn.getTileEntity(pos.down().south()) != null
						&& worldIn.getTileEntity(pos.down().south()) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.down().south())).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0.49, 0, 0, 0.63, 1, 1);
				}
				if (worldIn.getTileEntity(pos.down().north()) != null
						&& worldIn.getTileEntity(pos.down().north()) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.down().north())).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0.49, 0, 0, 0.63, 1, 1);
				}
				if (worldIn.getTileEntity(pos.up().north()) != null
						&& worldIn.getTileEntity(pos.up().north()) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.up().north())).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0.49, 0, 0, 0.63, 1, 1);
				}
				if (worldIn.getTileEntity(pos.up().south()) != null
						&& worldIn.getTileEntity(pos.up().south()) instanceof AnimatedDoorTileEntity) {
					return ((AnimatedDoorTileEntity) worldIn.getTileEntity(pos.up().south())).isOpened() ? NULL_AABB
							: new AxisAlignedBB(0.49, 0, 0, 0.63, 1, 1);
				}
			}
		default:
			break;
		}

		return FULL_BLOCK_AABB;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {

		switch (state.getValue(FACING)) {
		case NORTH:
		case SOUTH:
			return new AxisAlignedBB(0, 0, 0.49, 1, 1, 0.63);
		case WEST:
		case EAST:
			return new AxisAlignedBB(0.49, 0, 0, 0.63, 1, 1);
		}
		return new AxisAlignedBB(0, 0, 0, 0, 0, 0);
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		if (hasTileEntity(state)) {
			return new AnimatedDoorTileEntity();
		}
		return null;
	}

	@Override
	public boolean isFullBlock(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING });
	}

	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		IBlockState state = this.getStateFromMeta(meta);

		return state.withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	@SuppressWarnings("incomplete-switch")
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		boolean canBePlaced = true;
		switch (state.getValue(FACING)) {
		case NORTH:
		case SOUTH:
			canBePlaced = worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.up())
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.up().east())
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.up().east(2))
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.up().west())
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.up().west(2))
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.east())
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.east(2))
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.west())
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.west(2))
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.up(2))
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.up(2).east())
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.up(2).east(2))
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.up(2).west())
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.up(2).west(2));
			break;
		case EAST:
		case WEST:
			canBePlaced = worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.up())
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.up().north())
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.up().north(2))
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.up().south())
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.up().south(2))
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.north())
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.north(2))
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.south())
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.south(2))
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.up(2))
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.up(2).north())
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.up(2).north(2))
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.up(2).south())
					&& worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos.up(2).south(2));
			break;
		}
		if (canBePlaced) {
			switch (state.getValue(FACING)) {
			case NORTH:
				worldIn.setBlockState(pos.east(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.NORTH),
						4);
				worldIn.setBlockState(pos.east(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.NORTH),
						4);
				worldIn.setBlockState(pos.up().east(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.NORTH),
						4);
				worldIn.setBlockState(pos.up(2).east(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.NORTH),
						4);
				worldIn.setBlockState(pos.up().east(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_internal"))
								.getDefaultState().withProperty(FACING, EnumFacing.NORTH),
						4);
				worldIn.setBlockState(pos.up(2).east(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.NORTH),
						4);
				worldIn.setBlockState(pos.up(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block")).getDefaultState()
								.withProperty(FACING, EnumFacing.NORTH),
						4);
				worldIn.setBlockState(pos.up(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.NORTH),
						4);
				worldIn.setBlockState(pos.west(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.NORTH),
						4);
				worldIn.setBlockState(pos.west(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.NORTH),
						4);
				worldIn.setBlockState(pos.up().west(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.NORTH),
						4);
				worldIn.setBlockState(pos.up(2).west(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.NORTH),
						4);
				worldIn.setBlockState(pos.up().west(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_internal"))
								.getDefaultState().withProperty(FACING, EnumFacing.NORTH),
						4);
				worldIn.setBlockState(pos.up(2).west(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.NORTH),
						4);
				break;
			case SOUTH:
				worldIn.setBlockState(pos.east(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.SOUTH),
						4);
				worldIn.setBlockState(pos.east(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.SOUTH),
						4);
				worldIn.setBlockState(pos.up().east(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.SOUTH),
						4);
				worldIn.setBlockState(pos.up(2).east(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.SOUTH),
						4);
				worldIn.setBlockState(pos.up().east(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_internal"))
								.getDefaultState().withProperty(FACING, EnumFacing.SOUTH),
						4);
				worldIn.setBlockState(pos.up(2).east(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.SOUTH),
						4);
				worldIn.setBlockState(pos.up(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block")).getDefaultState()
								.withProperty(FACING, EnumFacing.SOUTH),
						4);
				worldIn.setBlockState(pos.up(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.SOUTH),
						4);
				worldIn.setBlockState(pos.west(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.SOUTH),
						4);
				worldIn.setBlockState(pos.west(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.SOUTH),
						4);
				worldIn.setBlockState(pos.up().west(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.SOUTH),
						4);
				worldIn.setBlockState(pos.up(2).west(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.SOUTH),
						4);
				worldIn.setBlockState(pos.up().west(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_internal"))
								.getDefaultState().withProperty(FACING, EnumFacing.SOUTH),
						4);
				worldIn.setBlockState(pos.up(2).west(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.SOUTH),
						4);
				break;
			case EAST:
				worldIn.setBlockState(pos.north(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.EAST),
						4);
				worldIn.setBlockState(pos.north(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.EAST),
						4);
				worldIn.setBlockState(pos.up().north(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.EAST),
						4);
				worldIn.setBlockState(pos.up(2).north(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.EAST),
						4);
				worldIn.setBlockState(pos.up().north(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_internal"))
								.getDefaultState().withProperty(FACING, EnumFacing.EAST),
						4);
				worldIn.setBlockState(pos.up(2).north(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.EAST),
						4);
				worldIn.setBlockState(pos.up(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block")).getDefaultState()
								.withProperty(FACING, EnumFacing.EAST),
						4);
				worldIn.setBlockState(pos.up(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.EAST),
						4);
				worldIn.setBlockState(pos.south(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.EAST),
						4);
				worldIn.setBlockState(pos.south(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.EAST),
						4);
				worldIn.setBlockState(pos.up().south(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.EAST),
						4);
				worldIn.setBlockState(pos.up(2).south(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.EAST),
						4);
				worldIn.setBlockState(pos.up().south(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_internal"))
								.getDefaultState().withProperty(FACING, EnumFacing.EAST),
						4);
				worldIn.setBlockState(pos.up(2).south(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.EAST),
						4);
				break;
			case WEST:
				worldIn.setBlockState(pos.north(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.WEST),
						4);
				worldIn.setBlockState(pos.north(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.WEST),
						4);
				worldIn.setBlockState(pos.up().north(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.WEST),
						4);
				worldIn.setBlockState(pos.up(2).north(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.WEST),
						4);
				worldIn.setBlockState(pos.up().north(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_internal"))
								.getDefaultState().withProperty(FACING, EnumFacing.WEST),
						4);
				worldIn.setBlockState(pos.up(2).north(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.WEST),
						4);
				worldIn.setBlockState(pos.up(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block")).getDefaultState()
								.withProperty(FACING, EnumFacing.WEST),
						4);
				worldIn.setBlockState(pos.up(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.WEST),
						4);
				worldIn.setBlockState(pos.south(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.WEST),
						4);
				worldIn.setBlockState(pos.south(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.WEST),
						4);
				worldIn.setBlockState(pos.up().south(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.WEST),
						4);
				worldIn.setBlockState(pos.up(2).south(2),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.WEST),
						4);
				worldIn.setBlockState(pos.up().south(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_internal"))
								.getDefaultState().withProperty(FACING, EnumFacing.WEST),
						4);
				worldIn.setBlockState(pos.up(2).south(),
						ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tm", "door_block_external"))
								.getDefaultState().withProperty(FACING, EnumFacing.WEST),
						4);
				break;
			}
		} else {
			worldIn.setBlockToAir(pos);
			if (!worldIn.isRemote) {
				worldIn.spawnEntity(
						new EntityItem(worldIn, placer.posX, placer.posY, placer.posZ, new ItemStack(this)));
			}
		}
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		// TODO Auto-generated method stub
		return ForgeRegistries.ITEMS.getValue(new ResourceLocation("tm", "door_block_external"));
	}

	@SuppressWarnings("incomplete-switch")
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		super.breakBlock(worldIn, pos, state);
		switch (state.getValue(FACING)) {
		case NORTH:
		case SOUTH:
			if (name.equals("door_block_internal") || name.equals("door_block")) {
				worldIn.setBlockToAir(pos.up());
				worldIn.setBlockToAir(pos.east());
				worldIn.setBlockToAir(pos.west());
				worldIn.setBlockToAir(pos.down());
				worldIn.setBlockToAir(pos.up().east());
				worldIn.setBlockToAir(pos.up().west());
				worldIn.setBlockToAir(pos.down().east());
				worldIn.setBlockToAir(pos.down().west());
			} else {
				if (worldIn.getBlockState(pos.up()).getBlock().getRegistryName().getResourcePath()
						.equals("door_block_internal")
						|| worldIn.getBlockState(pos.up()).getBlock().getRegistryName().getResourcePath()
								.equals("door_block")) {
					worldIn.setBlockToAir(pos.up());
				}
				if (worldIn.getBlockState(pos.down()).getBlock().getRegistryName().getResourcePath()
						.equals("door_block_internal")
						|| worldIn.getBlockState(pos.down()).getBlock().getRegistryName().getResourcePath()
								.equals("door_block")) {
					worldIn.setBlockToAir(pos.down());
				}
				if (worldIn.getBlockState(pos.east()).getBlock().getRegistryName().getResourcePath()
						.equals("door_block_internal")
						|| worldIn.getBlockState(pos.east()).getBlock().getRegistryName().getResourcePath()
								.equals("door_block")) {
					worldIn.setBlockToAir(pos.east());
				}
				if (worldIn.getBlockState(pos.west()).getBlock().getRegistryName().getResourcePath()
						.equals("door_block_internal")
						|| worldIn.getBlockState(pos.west()).getBlock().getRegistryName().getResourcePath()
								.equals("door_block")) {
					worldIn.setBlockToAir(pos.west());
				}
				if (worldIn.getBlockState(pos.down().west()).getBlock().getRegistryName().getResourcePath()
						.equals("door_block_internal")
						|| worldIn.getBlockState(pos.down().west()).getBlock().getRegistryName().getResourcePath()
								.equals("door_block")) {
					worldIn.setBlockToAir(pos.down().west());
				}
				if (worldIn.getBlockState(pos.down().east()).getBlock().getRegistryName().getResourcePath()
						.equals("door_block_internal")
						|| worldIn.getBlockState(pos.down().east()).getBlock().getRegistryName().getResourcePath()
								.equals("door_block")) {
					worldIn.setBlockToAir(pos.down().east());
				}
				if (worldIn.getBlockState(pos.up().west()).getBlock().getRegistryName().getResourcePath()
						.equals("door_block_internal")
						|| worldIn.getBlockState(pos.up().west()).getBlock().getRegistryName().getResourcePath()
								.equals("door_block")) {
					worldIn.setBlockToAir(pos.up().west());
				}
				if (worldIn.getBlockState(pos.up().east()).getBlock().getRegistryName().getResourcePath()
						.equals("door_block_internal")
						|| worldIn.getBlockState(pos.up().east()).getBlock().getRegistryName().getResourcePath()
								.equals("door_block")) {
					worldIn.setBlockToAir(pos.up().east());
				}
			}
			break;
		case EAST:
		case WEST:
			if (name.equals("door_block_internal") || name.equals("door_block")) {
				worldIn.setBlockToAir(pos.up());
				worldIn.setBlockToAir(pos.north());
				worldIn.setBlockToAir(pos.south());
				worldIn.setBlockToAir(pos.down());
				worldIn.setBlockToAir(pos.up().north());
				worldIn.setBlockToAir(pos.up().south());
				worldIn.setBlockToAir(pos.down().north());
				worldIn.setBlockToAir(pos.down().south());
			} else {
				if (worldIn.getBlockState(pos.up()).getBlock().getRegistryName().getResourcePath()
						.equals("door_block_internal")
						|| worldIn.getBlockState(pos.up()).getBlock().getRegistryName().getResourcePath()
								.equals("door_block")) {
					worldIn.setBlockToAir(pos.up());
				}
				if (worldIn.getBlockState(pos.down()).getBlock().getRegistryName().getResourcePath()
						.equals("door_block_internal")
						|| worldIn.getBlockState(pos.down()).getBlock().getRegistryName().getResourcePath()
								.equals("door_block")) {
					worldIn.setBlockToAir(pos.down());
				}
				if (worldIn.getBlockState(pos.north()).getBlock().getRegistryName().getResourcePath()
						.equals("door_block_internal")
						|| worldIn.getBlockState(pos.north()).getBlock().getRegistryName().getResourcePath()
								.equals("door_block")) {
					worldIn.setBlockToAir(pos.north());
				}
				if (worldIn.getBlockState(pos.south()).getBlock().getRegistryName().getResourcePath()
						.equals("door_block_internal")
						|| worldIn.getBlockState(pos.south()).getBlock().getRegistryName().getResourcePath()
								.equals("door_block")) {
					worldIn.setBlockToAir(pos.south());
				}
				if (worldIn.getBlockState(pos.down().south()).getBlock().getRegistryName().getResourcePath()
						.equals("door_block_internal")
						|| worldIn.getBlockState(pos.down().south()).getBlock().getRegistryName().getResourcePath()
								.equals("door_block")) {
					worldIn.setBlockToAir(pos.down().south());
				}
				if (worldIn.getBlockState(pos.down().north()).getBlock().getRegistryName().getResourcePath()
						.equals("door_block_internal")
						|| worldIn.getBlockState(pos.down().north()).getBlock().getRegistryName().getResourcePath()
								.equals("door_block")) {
					worldIn.setBlockToAir(pos.down().north());
				}
				if (worldIn.getBlockState(pos.up().south()).getBlock().getRegistryName().getResourcePath()
						.equals("door_block_internal")
						|| worldIn.getBlockState(pos.up().south()).getBlock().getRegistryName().getResourcePath()
								.equals("door_block")) {
					worldIn.setBlockToAir(pos.up().south());
				}
				if (worldIn.getBlockState(pos.up().north()).getBlock().getRegistryName().getResourcePath()
						.equals("door_block_internal")
						|| worldIn.getBlockState(pos.up().north()).getBlock().getRegistryName().getResourcePath()
								.equals("door_block")) {
					worldIn.setBlockToAir(pos.up().north());
				}
			}
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		switch (meta) {
		case 0:
			return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
		case 1:
			return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
		case 2:
			return this.getDefaultState().withProperty(FACING, EnumFacing.EAST);
		case 3:
			return this.getDefaultState().withProperty(FACING, EnumFacing.WEST);
		}
		return this.getDefaultState();
	}

	@SuppressWarnings("incomplete-switch")
	@Override
	public int getMetaFromState(IBlockState state) {
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
		return 0;
	}

}
