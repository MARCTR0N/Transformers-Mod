package com.marctron.transformersmod.resize.compatibilities.sizelimit;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class SizeLimitPro implements ICapabilitySerializable<NBTTagCompound>{

	private ISizeLimit capabilitySize = null;

	public SizeLimitPro()
	{
		this.capabilitySize = new SizeDefaultLimit();
	}

	public SizeLimitPro(ISizeLimit capability)
	{
		this.capabilitySize = capability;
	}

	@CapabilityInject(ISizeLimit.class)
	public static final Capability<ISizeLimit> sizeCapability = null;

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
		return capability == sizeCapability;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
		if (sizeCapability != null && capability == sizeCapability)
		{
			return (T) this.capabilitySize;
		}
		return null;
	}

	@Override
	public NBTTagCompound serializeNBT()
	{
		return this.capabilitySize.saveNBT();
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt)
	{
		this.capabilitySize.loadNBT(nbt);
	}
}