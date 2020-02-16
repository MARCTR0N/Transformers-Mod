package com.marctron.transformersmod.resize.compatibilities;

import java.util.concurrent.Callable;

import com.marctron.transformersmod.resize.compatibilities.sizelimit.ISizeLimit;
import com.marctron.transformersmod.resize.compatibilities.sizelimit.SizeDefaultLimit;
import com.marctron.transformersmod.resize.compatibilities.sizelimit.SizeLimitStorage;

import net.minecraftforge.common.capabilities.CapabilityManager;

public class Capabilities {

	public static void init()
	{
		CapabilityManager.INSTANCE.register(ISizeLimit.class, new SizeLimitStorage(), new CababilityFactory());
	}

	private static class CababilityFactory implements Callable<ISizeLimit>
	{
		@Override
		public ISizeLimit call() throws Exception
		{
			return new SizeDefaultLimit();
		}
	}
}