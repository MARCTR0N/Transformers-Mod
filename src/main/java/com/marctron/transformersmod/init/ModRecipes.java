package com.marctron.transformersmod.init;

import java.util.Arrays;

import com.marctron.transformersmod.items.gun.AmmoClip;
import com.marctron.transformersmod.util.ShapelessNBTRecipe;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.RecipeSorter;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.util.Arrays;
import java.util.Map;


public class ModRecipes {

	
	public static void init() {
		GameRegistry.addSmelting(ModBlocks.TRANSFORMIUM_ORE_BLOCK, new ItemStack(ModItems.TRANSFORMIUM, 1), 1.5f);
	
		
		
		
		
	
	 RecipeSorter.register("ShapelessNBTRecipe", ShapelessNBTRecipe.class, RecipeSorter.Category.SHAPELESS, "after:minecraft:shapeless");
	
	//Empty Bullet Clip
		 ItemStack emptyClip = new ItemStack((Block) ModItems.Energon_Battle_Pistol_CLip);
		 AmmoClip.setBulletsAmount(emptyClip, 0);
		 GameRegistry.addShapedRecipe(null, null, emptyClip, null);
	 
    //Bullet Clips
		 int max = ModItems.Energon_Battle_Pistol_CLip.clipSize;
		 for(int clipSize = 0; clipSize < max; clipSize++)
		 {
			 for(int numBullets = 1; numBullets <= Math.min(Math.min(max, 8), max - clipSize); numBullets++)
			 {
            //Add recipes to fill a bullet clip for every possible combination
				 ItemStack[] bullets = new ItemStack[numBullets + 1];
				 Arrays.fill(bullets, ModItems.getBasicItem(EItemBasic.BULLET));
            
				 ItemStack inputClip = new ItemStack((Block) ModItems.Energon_Battle_Pistol_CLip);
				 AmmoClip.setBulletsAmount(inputClip, clipSize);
				 bullets[0] = inputClip;

				 ItemStack outputClip = new ItemStack((Block) ModItems.Energon_Battle_Pistol_CLip);
				 AmmoClip.setBulletsAmount(outputClip, clipSize + numBullets);

				 GameRegistry.addShapelessRecipe(name, , output, params);
            
				// (new ShapelessNBTRecipe(outputClip, (Object[]) bullets));
          
            
            
        }
    }
   

	} 
	

	}
}

