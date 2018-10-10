package com.marctron.transformersmod.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

	
	public static void init() {
		GameRegistry.addSmelting(ModBlocks.TRANSFORMIUM_ORE_BLOCK, new ItemStack(ModItems.TRANSFORMIUM, 1), 1.5f);
	}
}
