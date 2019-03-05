package com.marctron.transformersmod.capabilities;

import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;

public interface ITransform {
	
	
	
	public default void hasCapability(Capability<?> capability, EnumFacing facing) {
	  if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
	    return;
	  }
	  
	}

}
