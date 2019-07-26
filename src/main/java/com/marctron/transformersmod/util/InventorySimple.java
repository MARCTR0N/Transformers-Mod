package com.marctron.transformersmod.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class InventorySimple implements IInventory {
    private final boolean hasCustomName;
    private final int slotCount, stackLimit;
    private final NonNullList<ItemStack> contents;
    private String title;

    public InventorySimple(String title, boolean hasCustomName, int slotCount, int stackLimit) {
        this.title = title;
        this.hasCustomName = hasCustomName;
        this.slotCount = slotCount;
        this.stackLimit = stackLimit;
        this.contents = NonNullList.withSize(slotCount, ItemStack.EMPTY);
    }

    public ItemStack addItem(ItemStack stack) {
        ItemStack itemstack = stack.copy();

        for (int i = 0; i < slotCount; ++i) {
            ItemStack itemstack1 = getStackInSlot(i);

            if (itemstack1.isEmpty() && isItemValidForSlot(i, itemstack)) {
                setInventorySlotContents(i, itemstack);
                markDirty();
                return null;
            }

            if (ItemStack.areItemsEqual(itemstack1, itemstack)) {
                int j = Math.min(getInventoryStackLimit(), itemstack1.getMaxStackSize());
                int k = Math.min(itemstack.getCount(), j - itemstack1.getCount());

                if (k > 0) {
                    itemstack1.grow(k);
                    itemstack.shrink(k);

                    if (itemstack.getCount() <= 0) {
                        markDirty();
                        return null;
                    }
                }
            }
        }

        if (itemstack.getCount() != stack.getCount())
            markDirty();

        return itemstack;
    }

    @Override
    public int getSizeInventory() {
        return slotCount;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return index >= 0 && index < slotCount ? contents.get(index) : ItemStack.EMPTY;
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        ItemStack itemStack = ItemStackHelper.getAndSplit(contents, index, count);

        if (!itemStack.isEmpty())
            markDirty();

        return itemStack;
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        if (!contents.get(index).isEmpty()) {
            ItemStack itemstack = contents.get(index);
            contents.set(index, ItemStack.EMPTY);
            return itemstack;
        } else
            return null;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        contents.set(index, stack);

        if (stack.getCount() > getInventoryStackLimit())
            stack.setCount(getInventoryStackLimit());

        markDirty();
    }

    @Override
    public int getInventoryStackLimit() {
        return stackLimit;
    }

    @Override
    public void markDirty() {
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void openInventory(EntityPlayer player) {
    }

    @Override
    public void closeInventory(EntityPlayer player) {
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {
    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {
        contents.clear();
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public boolean hasCustomName() {
        return hasCustomName;
    }

    @Override
    public ITextComponent getDisplayName() {
        return hasCustomName() ? new TextComponentString(getName()) : new TextComponentTranslation(getName());
    }
}