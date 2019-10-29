package com.marctron.transformersmod.blocks.machinery;

import com.marctron.transformersmod.util.handlers.RegistryHandler;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotMachineFuel extends SlotItemHandler{

	public SlotMachineFuel(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
		
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return TileEntityFurnace.isItemFuel(stack) || net.minecraft.inventory.SlotFurnaceFuel.isBucket(stack);
		
	}
	
	@Override
	public int getItemStackLimit(ItemStack stack) {
		return net.minecraft.inventory.SlotFurnaceFuel.isBucket(stack) ? 1 : super.getItemStackLimit(stack);
	}
}
