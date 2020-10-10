package com.marctron.transformersmod.items.displaystand;

import com.marctron.transformersmod.blocks.tileentity.TileEntityEnergonCrate;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerDisplayStand extends Container {
   

	public ContainerDisplayStand(InventoryPlayer inventory, TileEntityDisplayStand tileEntity, EntityPlayer player) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		
        
		return false;
	}

}
