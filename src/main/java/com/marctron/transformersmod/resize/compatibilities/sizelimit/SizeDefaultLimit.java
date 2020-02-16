package com.marctron.transformersmod.resize.compatibilities.sizelimit;

import net.minecraft.nbt.NBTTagCompound;

public class SizeDefaultLimit implements ISizeLimit {

	boolean transformed = false;
	float defaultWidth;
	float defaultHeight;

	public SizeDefaultLimit(){}

	public SizeDefaultLimit(boolean transformed, float defaultWidth, float defaultHeight)
	{
		this.transformed = transformed;
		this.defaultWidth = defaultWidth;
		this.defaultHeight = defaultHeight;
	}

	@Override
	public boolean getTrans()
	{
		return this.transformed;
	}

	@Override
	public void setTrans(boolean transformed)
	{
		this.transformed = transformed;
	}

	@Override
	public float getDefaultWidth()
	{
		return this.defaultWidth;
	}

	@Override
	public void setDefaultWidth(float defaultWidth)
	{
		this.defaultWidth = defaultWidth;
	}

	@Override
	public float getDefaultHeight() {
		return this.defaultHeight;
	}

	@Override
	public void setDefaultHeight(float defaultHeight)
	{
		this.defaultHeight = defaultHeight;
	}

	@Override
	public NBTTagCompound saveNBT()
	{
		return (NBTTagCompound) SizeLimitStorage.storage.writeNBT(SizeLimitPro.sizeCapability, this, null);
	}

	@Override
	public void loadNBT(NBTTagCompound compound)
	{
		SizeLimitStorage.storage.readNBT(SizeLimitPro.sizeCapability, this, null, compound);
	}
}