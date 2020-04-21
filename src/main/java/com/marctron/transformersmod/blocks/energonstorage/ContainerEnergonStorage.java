package com.marctron.transformersmod.blocks.energonstorage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;

public class ContainerEnergonStorage extends Container {
    private final TileEntityEnergonStorage tileentity;
    private int energy;

    public ContainerEnergonStorage(InventoryPlayer player, TileEntityEnergonStorage tileentity) {
        this.tileentity = tileentity;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return this.tileentity.isUsableByPlayer(playerIn);
    }

    @Override
    public void updateProgressBar(int id, int data) {
        this.tileentity.setField(id, data);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (int i = 0; i < this.listeners.size(); ++i) {
            IContainerListener listener = (IContainerListener) this.listeners.get(i);
            if (this.energy != this.tileentity.getField(0))
                listener.sendWindowProperty(this, 0, this.tileentity.getField(0));
        }

        this.energy = this.tileentity.getField(0);
    }
}