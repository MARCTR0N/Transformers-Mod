package com.marctron.transformersmod.blocks.energonengine;

import javax.annotation.Nullable;

import com.marctron.transformersmod.blocks.energy.CustomEnergyStorage;
import com.marctron.transformersmod.init.ModItems;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityEnergonEngine extends TileEntity implements ITickable
{
	public ItemStackHandler handler = new ItemStackHandler(1);
	private EnergyStorage storage = new EnergyStorage(100000, 0, 200, 0);
	public int energy = storage.getEnergyStored();
	private String customName;
	public int cookTime;
	
	
	
	@Override
	public void update()
	{
		if(world.isRemote) return;

        for(EnumFacing dir : EnumFacing.values())
        {
        	TileEntity te = world.getTileEntity(pos.offset(dir));
            if(te == null) continue;
            IEnergyStorage energy = te.getCapability(CapabilityEnergy.ENERGY, null);
            if(energy == null) continue;
            energy.receiveEnergy(1, false);
            this.storage.extractEnergy(1000, false);
           
        }
		
//		 for (EnumFacing facing : EnumFacing.VALUES) {
//	            BlockPos checking = this.pos.offset(facing);
//	            TileEntity checkingTile = this.world.getTileEntity(checking);
//	            if (checkingTile != null) {
//	                if (checkingTile.hasCapability(CapabilityEnergy.ENERGY, facing.getOpposite())) {
//	                    IEnergyStorage storage = checkingTile.getCapability(CapabilityEnergy.ENERGY, facing.getOpposite());
//	                    int energy = storage.receiveEnergy(Math.min(this.storage.getEnergyStored(), 1000), false);
//	                    if (energy > 0) {
//	                        this.storage.extractEnergy(energy, false);
//	                        return;
//	                    }
//	                }
//	            }
//	        }
		 
		 
		
		if(!handler.getStackInSlot(0).isEmpty() && isItemFuel(handler.getStackInSlot(0)))
		{
			cookTime++;
			if(cookTime == 25)
			{
				energy += getFuelValue(handler.getStackInSlot(0));
				handler.getStackInSlot(0).shrink(1);
				cookTime = 0;
			}
		}
		
		
	}
	
	private boolean isItemFuel(ItemStack stack) 
	{
		return getFuelValue(stack) > 0;
	}
	
	private int getFuelValue(ItemStack stack) 
	{
		if(stack.getItem() == ModItems.BLUE_ENERGON_SHARD) return 1000;
		
		//else if(stack.getItem() == Items.XXX) return 500; to add new fuels
		else return 0;
	}

	
	
    
	
	@Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
//		System.out.println("capability checked");
        if (capability == CapabilityEnergy.ENERGY) return (T) storage;
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T)this.handler;
        return super.getCapability(capability, facing);
    }
	


	
	@Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityEnergy.ENERGY || super.hasCapability(capability, facing);
    }
	
	
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setTag("Inventory", this.handler.serializeNBT());
		compound.setInteger("CookTime", this.cookTime);
		compound.setInteger("GuiEnergy", this.energy);
		compound.setString("Name", getDisplayName().toString());
//		this.storage.writeToNBT(compound);
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		super.readFromNBT(compound);
		this.handler.deserializeNBT(compound.getCompoundTag("Inventory"));
		this.cookTime = compound.getInteger("CookTime");
		this.energy = compound.getInteger("GuiEnergy");
		this.customName = compound.getString("Name");
//		this.storage.readFromNBT(compound);
		super.readFromNBT(compound);
	}
	
	
	
	
	@Override
	public ITextComponent getDisplayName()
	{
		return new TextComponentTranslation("container.coal_generator");
	}
	
	public int getEnergyStored()
	{
		return this.energy;
	}
	
	public int getMaxEnergyStored()
	{
		return this.storage.getMaxEnergyStored();
	}
	
	public int getField(int id)
	{
		switch(id)
		{
		case 0:
			return this.energy;
		case 1:
			return this.cookTime;
		default:
			return 0;
		}
	}
	
	public void setField(int id, int value)
	{
		switch(id)
		{
		case 0:
			this.energy = value;
		case 1:
			this.cookTime = value;
		}
	}
	
	public boolean isUsableByPlayer(EntityPlayer player) 
	{
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
	}

}