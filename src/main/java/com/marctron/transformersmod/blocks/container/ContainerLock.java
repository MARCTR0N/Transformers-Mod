package com.marctron.transformersmod.blocks.container;

import com.marctron.transformersmod.blocks.tileentity.TileEntityLock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerLock extends Container {

    private TileEntityLock te;
    private IItemHandler handler;

    public ContainerLock(IInventory playerInv, TileEntityLock te){
        this.te = te;
        this.handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

        this.addSlotToContainer(new SlotItemHandler(te.handler,0,81,35));

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int k = 0; k < 9; ++k)
        {
            this.addSlotToContainer(new Slot(playerInv, k, 8 + k * 18, 142));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack transferred = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        int otherSlots = this.inventorySlots.size() - 36;

        if (slot != null && slot.getHasStack()) {
            ItemStack current = slot.getStack();
            transferred = current.copy();

            if (index < otherSlots) {
                if (!this.mergeItemStack(current, otherSlots, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(current, 0, otherSlots, false)) {
                return ItemStack.EMPTY;
            }

            if (current.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }

        return transferred;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }
}
