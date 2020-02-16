package com.marctron.transformersmod.resize.compatibilities.sizelimit;

import net.minecraft.nbt.NBTTagCompound;

public interface ISizeLimit {

	boolean getTrans();

	void setTrans(boolean transformed);

	float getDefaultWidth();

	void setDefaultWidth(float width);

	float getDefaultHeight();

	void setDefaultHeight(float height);

	NBTTagCompound saveNBT();

	void loadNBT(NBTTagCompound compound);
}
