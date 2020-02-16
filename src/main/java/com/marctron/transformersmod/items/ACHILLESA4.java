package com.marctron.transformersmod.items;

import com.marctron.transformersmod.Main;

import net.minecraft.item.Item;

public class ACHILLESA4 extends Item{

	public static final String name = "achillesa4";
		
		 protected final String TOOLTIP;

		 public ACHILLESA4(String name) {    
		        setUnlocalizedName(name);
		        setRegistryName(name);
		        setCreativeTab(Main.tabTransformers);
		        TOOLTIP = name + ".tooltip.";
		
	}

		 
}
