package com.marctron.transformersmod.init;

import com.marctron.transformersmod.fluids.FluidBase;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidInit {
	
	public static final FluidBase ENERGON_FLUID= (FluidBase) new FluidBase("energon_fluid",
			new ResourceLocation("tm:blocks/energon_fluid_still"),
			new ResourceLocation("tm:blocks/energon_fluid_flow"))
			.setDensity(900)
			.setLuminosity(10)
			.setGaseous(false)
			.setViscosity(2500)
			.setTemperature(300)
			
			;
	
	
	public static void registerFluids(){
		registerFluid(ENERGON_FLUID);
	}


	public static void registerFluid(Fluid fluid) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);		
	}
	
	

}
