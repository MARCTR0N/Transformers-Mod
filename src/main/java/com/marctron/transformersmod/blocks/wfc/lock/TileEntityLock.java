package com.marctron.transformersmod.blocks.wfc.lock;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.items.ItemFragment;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityLock extends TileEntity implements ITickable {

	public ItemStackHandler handler;
	private int maxNumberOfItems;
	private int numberOfItems = 0;

	public TileEntityLock() {
		this.handler = new ItemStackHandler(1);
		this.maxNumberOfItems = 100;
	}

	@Nullable
	@Override
	public ITextComponent getDisplayName() {
		return new TextComponentTranslation("container.tm_lock");
	}

	@Override
	public void update() {
		if (handler.getStackInSlot(0).getItem() instanceof ItemFragment && numberOfItems != maxNumberOfItems) {
			IBlockState oldState = this.world.getBlockState(this.pos);
			handler.getStackInSlot(0).shrink(1);
			numberOfItems++;
			if (numberOfItems == maxNumberOfItems) {
				world.setBlockState(pos,
						world.getBlockState(pos).withProperty(LockBlock.FULLCONTENT, Boolean.valueOf(true)), 3);
			} else {
				if (world.getBlockState(pos).getValue(LockBlock.FULLCONTENT)) {
					world.setBlockState(pos,
							world.getBlockState(pos).withProperty(LockBlock.FULLCONTENT, Boolean.valueOf(false)), 3);
				}
			}
			this.world.notifyBlockUpdate(this.pos, oldState,
					this.world.getBlockState(this.pos), 1);
			this.world.scheduleBlockUpdate(pos, blockType, 0, 0);
			this.markDirty();

		}
	}

	@Override
	public void markDirty() {
		super.markDirty();
	}

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
		return oldState.getBlock() != newState.getBlock();
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		return this.writeToNBT(new NBTTagCompound());
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.handler.deserializeNBT(compound.getCompoundTag("Inventory"));
		maxNumberOfItems = compound.getInteger("MaxNumberOfItems");
		numberOfItems = compound.getInteger("NumberOfItems");
		Main.logger.info("Number of items on load: " + numberOfItems);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setTag("Inventory", this.handler.serializeNBT());
		compound.setInteger("MaxNumberOfItems", maxNumberOfItems);
		compound.setInteger("NumberOfItems", numberOfItems);
		Main.logger.info("Number of items on save: " + numberOfItems);
		return compound;
	}

	public void setMaxNumberOfItems(int maxNumberOfItems) {
		IBlockState oldState = this.world.getBlockState(this.pos);
		if(numberOfItems > maxNumberOfItems) {
			numberOfItems = maxNumberOfItems;
		}
		this.maxNumberOfItems = maxNumberOfItems;
		if (numberOfItems == maxNumberOfItems) {
			world.setBlockState(pos,
					world.getBlockState(pos).withProperty(LockBlock.FULLCONTENT, Boolean.valueOf(true)), 3);
		} else {
			if (world.getBlockState(pos).getValue(LockBlock.FULLCONTENT)) {
				world.setBlockState(pos,
						world.getBlockState(pos).withProperty(LockBlock.FULLCONTENT, Boolean.valueOf(false)), 3);
			}
		}
		this.world.notifyBlockUpdate(this.pos, oldState,
				this.world.getBlockState(this.pos), 1);
		this.world.scheduleBlockUpdate(pos, blockType, 0, 0);
		this.markDirty();
	}

	public int getMaxNumberOfItems() {
		return maxNumberOfItems;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	@Override
	public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return true;
		return super.hasCapability(capability, facing);
	}

	@Nullable
	@Override
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return (T) this.handler;
		return super.getCapability(capability, facing);
	}
}
