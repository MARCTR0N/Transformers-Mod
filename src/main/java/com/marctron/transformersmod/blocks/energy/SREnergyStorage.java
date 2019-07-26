package com.marctron.transformersmod.blocks.energy;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.energy.EnergyStorage;

public class SREnergyStorage extends EnergyStorage implements INBTSerializable<NBTTagCompound> {
    public SREnergyStorage(int capacity, int maxReceive, int maxExtract) {
        super(capacity, maxReceive, maxExtract);
    }

    /**
     * Sets the energy stored to the amount given, but still must be between 0 and the capacity
     */
    public void setEnergyStored(int amount) {
        energy = amount;
        if (energy > capacity)
            energy = capacity;
        if (energy < 0)
            energy = 0;
    }

    /**
     * Changes the energy stored directly without checking max input/output rates
     * Energy will still stay between 0 and the capacity
     */
    public void modifyEnergy(int amount) {
        if (amount == 0) return;
        int newEnergy = energy + amount;
        energy = newEnergy < 0 ? 0 : newEnergy > capacity ? capacity : newEnergy;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setInteger("energy", energy);
        tag.setInteger("maxEnergy", capacity);
        tag.setInteger("maxReceive", maxReceive);
        tag.setInteger("maxExtract", maxExtract);
        return tag;
    }

    @Override
    public void deserializeNBT(NBTTagCompound tag) {
        energy = tag.getInteger("energy");
        capacity = tag.getInteger("maxEnergy");
        maxReceive = tag.getInteger("maxReceive");
        maxExtract = tag.getInteger("maxExtract");
    }

    @Override
    public String toString() {
        return "energy: " + energy + ", max: " + capacity + " in: " + maxReceive + " out: " + maxExtract;
    }
}