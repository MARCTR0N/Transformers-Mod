package com.marctron.transformersmod.items;

import com.marctron.transformersmod.Main;

import net.minecraft.item.Item;

public class DARKSTARSABER extends Item{

	public static final String name = "darkstarsaber";
		
		 protected final String TOOLTIP;

		 public DARKSTARSABER(String name) {    
		        setUnlocalizedName(name);
		        setRegistryName(name);
		        setCreativeTab(Main.tabTransformers);
		        TOOLTIP = name + ".tooltip.";
		
	}

		 
		 
}