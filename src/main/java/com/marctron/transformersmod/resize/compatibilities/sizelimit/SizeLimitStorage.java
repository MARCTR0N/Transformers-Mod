package com.marctron.transformersmod.resize.compatibilities.sizelimit;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class SizeLimitStorage implements IStorage<ISizeLimit>{
	
	public static final SizeLimitStorage storage = new SizeLimitStorage();

	@Override
	public NBTBase writeNBT(Capability<ISizeLimit> capability, ISizeLimit instance, EnumFacing side)
	{
		final NBTTagCompound tag = new NBTTagCompound();
		tag.setBoolean("transformed", instance.getTrans());
		return tag;
	}

	@Override
	public void readNBT(Capability<ISizeLimit> capability, ISizeLimit instance, EnumFacing side, NBTBase nbt)
	{
		if (nbt instanceof NBTTagCompound) {
			final NBTTagCompound tag = (NBTTagCompound) nbt;
			if (tag.hasKey("transformed")) {
				instance.setTrans(tag.getBoolean("transformed"));
			}
		}
	}

}
