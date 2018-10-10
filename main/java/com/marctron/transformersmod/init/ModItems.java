package com.marctron.transformersmod.init;

import java.util.ArrayList;
import java.util.List;

import com.marctron.transformersmod.items.ItemBase;
import com.marctron.transformersmod.items.ItemCustomFood;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ModItems 
{

	
	
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item ENERGON_SHARD = new ItemBase("energon_shard");
	public static final Item MUG = new ItemBase("mug");
	public static final Item ENERGON_MUG = new ItemCustomFood("energon_mug", 4, false);
	public static final Item TRANSFORMIUM = new ItemBase("transformium");
	
	
	
}
