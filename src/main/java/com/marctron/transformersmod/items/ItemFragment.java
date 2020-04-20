package com.marctron.transformersmod.items;

import com.marctron.transformersmod.Main;

import net.minecraft.item.Item;

public class ItemFragment extends Item {

	public ItemFragment(String name) {

		this.setCreativeTab(Main.tabTransformers);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}
}
