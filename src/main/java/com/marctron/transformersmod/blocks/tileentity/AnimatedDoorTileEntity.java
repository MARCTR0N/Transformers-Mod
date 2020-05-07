package com.marctron.transformersmod.blocks.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;

public class AnimatedDoorTileEntity extends TileEntity implements ITickable {

	private boolean opened = true;
	private int openedProgress = 0;

	public void setOpenedProgress(int openedProgress) {
		this.openedProgress = openedProgress;
	}

	public int getOpenedProgress() {
		return openedProgress;
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setBoolean("opened", opened);
		compound.setInteger("openedProgress", openedProgress);
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		opened = nbt.getBoolean("opened");
		openedProgress = nbt.getInteger("openedProgress");
	}
	
	@Override
	public void update() {

		switch (world.getBlockState(pos).getValue(BlockHorizontal.FACING)) {
		case NORTH:
		case SOUTH:
			opened = world.isBlockPowered(pos) || world.isBlockPowered(pos.up())
					|| world.isBlockPowered(pos.up().east()) || world.isBlockPowered(pos.up().east(2))
					|| world.isBlockPowered(pos.up().west()) || world.isBlockPowered(pos.up().west(2))
					|| world.isBlockPowered(pos.down()) || world.isBlockPowered(pos.down().east())
					|| world.isBlockPowered(pos.down().east(2)) || world.isBlockPowered(pos.down().west())
					|| world.isBlockPowered(pos.down().west(2)) || world.isBlockPowered(pos.down())
					|| world.isBlockPowered(pos.east()) || world.isBlockPowered(pos.east(2))
					|| world.isBlockPowered(pos.west()) || world.isBlockPowered(pos.west(2));
			break;
		case EAST:
		case WEST:

			opened = world.isBlockPowered(pos) || world.isBlockPowered(pos.up())
					|| world.isBlockPowered(pos.up().south()) || world.isBlockPowered(pos.up().south(2))
					|| world.isBlockPowered(pos.up().north()) || world.isBlockPowered(pos.up().north(2))
					|| world.isBlockPowered(pos.down()) || world.isBlockPowered(pos.down().south())
					|| world.isBlockPowered(pos.down().south(2)) || world.isBlockPowered(pos.down().north())
					|| world.isBlockPowered(pos.down().north(2)) || world.isBlockPowered(pos.down())
					|| world.isBlockPowered(pos.south()) || world.isBlockPowered(pos.south(2))
					|| world.isBlockPowered(pos.north()) || world.isBlockPowered(pos.north(2));
			break;
		}
		if (opened) {
			if (openedProgress < 100) {
				openedProgress+=10;
				world.notifyBlockUpdate(pos, world.getBlockState(pos), world.getBlockState(pos), 0);
			} else {
				openedProgress = 100;
			}
		} else {
			if (openedProgress > 0) {
				openedProgress-=10;
				world.notifyBlockUpdate(pos, world.getBlockState(pos), world.getBlockState(pos), 0);
			}else {
				openedProgress = 0;
			}
		}
	}

	public boolean isOpened() {
		return opened;
	}

	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		switch(world.getBlockState(pos).getValue(BlockHorizontal.FACING)) {
		case NORTH:
		case SOUTH:
			return new AxisAlignedBB(pos.down().east(4), pos.up().west(3));
		case WEST:
		case EAST:
			return new AxisAlignedBB(pos.down().north(3), pos.up().south(4));
		}
		return super.getRenderBoundingBox();
	}
}
