package com.marctron.transformersmod.init;

import com.marctron.transformersmod.capabilities.IWork;
import com.marctron.transformersmod.capabilities.Worker;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class ModCapabilities {

	/**
	 * The reference for use in
	 * {@link ICapabilityProvider#getCapability(Capability, EnumFacing)} and
	 * {@link ICapabilityProvider#hasCapability(Capability, EnumFacing)}
	 */
	@CapabilityInject(IWork.class)
	public static Capability<IWork> CAPABILITY_WORKER = null;

	/**
	 * Register all of the capabilities
	 */
	public static void registerCapabilities() {
		CapabilityManager.INSTANCE.register(IWork.class, new CapabilityWorker(), Worker.class);
	}

	/**
	 * The capability for the {@link IWork} interface
	 * 
	 * @author CJMinecraft
	 *
	 */
	public static class CapabilityWorker implements IStorage<IWork> {

		@Override
		public NBTBase writeNBT(Capability<IWork> capability, IWork instance, EnumFacing side) {
			return null;
		}

		@Override
		public void readNBT(Capability<IWork> capability, IWork instance, EnumFacing side, NBTBase nbt) {
		}

	}
}
