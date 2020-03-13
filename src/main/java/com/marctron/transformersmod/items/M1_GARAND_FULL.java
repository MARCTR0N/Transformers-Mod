package com.marctron.transformersmod.items;

import com.marctron.transformersmod.Main;

import net.minecraft.item.Item;

public class M1_GARAND_FULL extends Item{

	public static final String name = "m1_garand_full";
		
		 protected final String TOOLTIP;

		 public M1_GARAND_FULL(String name) {    
		        setUnlocalizedName(name);
		        setRegistryName(name);
		        setCreativeTab(Main.tabTransformers);
		        TOOLTIP = name + ".tooltip.";
		
	}

		 
		 
}