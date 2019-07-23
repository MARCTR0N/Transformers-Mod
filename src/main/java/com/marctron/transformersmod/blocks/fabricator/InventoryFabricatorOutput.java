package com.marctron.transformersmod.blocks.fabricator;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;

public class InventoryFabricatorOutput implements IInventory {
	
	
    private ItemStack[] stackResult = new ItemStack[4];

    @Override
    public int getSizeInventory()
    {
        return stackResult.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return stackResult[slot];
    }

    @Override
    public String getName()
    {
        return "Result";
    }

	@Override
	public boolean hasCustomName() {
		// TODO Auto-generated method stub
		return false;
	}

    @Override
    public ItemStack decrStackSize(int slot, int amount)
    {
        if (stackResult[slot] != null)
        {
            ItemStack itemstack = stackResult[slot];
            stackResult[slot] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }


    @Override
    public void setInventorySlotContents(int slot, ItemStack itemstack)
    {
        stackResult[slot] = itemstack;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public void markDirty()
    {
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player)
    {
        return true;
    }

    @Override
    public void openInventory(EntityPlayer player)
    {
    }

    @Override
    public void closeInventory(EntityPlayer player) 
    {
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemstack)
    {
        return true;
    }

	@Override
	public ITextComponent getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}



	}


