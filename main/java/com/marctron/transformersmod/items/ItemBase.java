package com.marctron.transformersmod.items;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.init.ModItems;
import com.marctron.transformersmod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel{
	
	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabTransformers);
		
		ModItems.ITEMS.add(this);
	}
	

	@Override
	public void registerModel() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}


	
	

}
