package com.marctron.transformersmod.items;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.init.ModItems;
import com.marctron.transformersmod.util.interfaces.IHasModel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemEnergonMugRed extends ItemFood implements IHasModel 
{
	

	private PotionEffect[] effects;

	public ItemEnergonMugRed(String name,  int amount, boolean isWolfFood,  PotionEffect...potionEffects) 
	{
		super(amount, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabTransformers);
		
		
		setMaxStackSize(1);
		
	
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

	@Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
        
    }
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
	{
		for(PotionEffect effect : effects) {
			player.addPotionEffect(effect);
		}
	}
		
	

}
