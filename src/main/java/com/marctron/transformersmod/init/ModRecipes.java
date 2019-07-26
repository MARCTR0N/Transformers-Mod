package com.marctron.transformersmod.init;

import java.util.Arrays;

import com.marctron.transformersmod.items.gun.AmmoClip;
import com.marctron.transformersmod.util.Reference;
import com.marctron.transformersmod.util.ShapelessNBTRecipe;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.RecipeSorter;

import java.util.Arrays;
import java.util.Map;


public class ModRecipes {

	
	public static void init() {
		GameRegistry.addSmelting(ModBlocks.TRANSFORMIUM_ORE_BLOCK, new ItemStack(ModItems.TRANSFORMIUM, 1), 1.5f);
	
		
		
		
		
	
	 
	/*
	//Empty Bullet Clip
		 ItemStack emptyClip = new ItemStack((Block) ModItems.Energon_Battle_Pistol_Clip);
		 AmmoClip.setBulletsAmount(emptyClip, 0);
		 GameRegistry.addShapedRecipe(emptyClip, "i i", "i i", " i ", 'i', Items.IRON_INGOT);
	 */
    //Bullet Clips
		// int max = ModItems.Energon_Battle_Pistol_Clip.clipSize;
//		 for(int clipSize = 0; clipSize < max; clipSize++)
//		 {
//			 for(int numBullets = 1; numBullets <= Math.min(Math.min(max, 8), max - clipSize); numBullets++)
//			 {
//            //Add recipes to fill a bullet clip for every possible combination
//				 Object[] bullets = new ItemStack[numBullets + 1];
//				 Arrays.fill(bullets, ModItems.getBasicItem(EItemBasic.BULLET));
//            
//				 ItemStack inputClip = new ItemStack((Block) ModItems.Energon_Battle_Pistol_Clip);
//				 AmmoClip.setBulletsAmount(inputClip, clipSize);
//				 bullets[0] = inputClip;
//
//				 ItemStack outputClip = new ItemStack((Block) ModItems.Energon_Battle_Pistol_Clip);
//				 AmmoClip.setBulletsAmount(outputClip, clipSize + numBullets);
//
//				// GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID, "pistol_clip"), null, outputClip, (Ingredient[]) bullets);
//				 for(int i = 0; i < 10; i++)
//				 {
//				     ItemStack stack = new ItemStack((Block) ModItems.Energon_Battle_Pistol_Clip, 1, i);
//				     GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID, "pistol_clip" + i), null, outputClip, (Ingredient[]) bullets);
//				 }
				 
				// ItemStack stack = new ItemStack((Block) ModItems.Energon_Battle_Pistol_Clip, 1, i);
				    // GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID, ((Object) ModItems.Energon_Battle_Pistol_Clip.getRegistryName()).getPath() + i), null, outputClip, (Ingredient[]) bullets);
            
        }
			 
    
   

	} 
	

	


