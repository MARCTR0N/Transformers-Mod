package com.marctron.transformersmod.items;

import java.util.List;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.init.ModItems;
import com.marctron.transformersmod.util.interfaces.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBase extends Item implements IHasModel{
	
	public ItemBase(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabTransformers);
		
		ModItems.ITEMS.add(this);
	}
	

	@Override
	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}


	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
	
		
	}


	
	

}

