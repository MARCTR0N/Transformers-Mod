package com.marctron.transformersmod.items;

import com.marctron.transformersmod.Main;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemEnergonMugRed extends ItemFood {


    private PotionEffect[] effects;

    public ItemEnergonMugRed(String name, int amount, boolean isWolfFood, PotionEffect... potionEffects) {
        super(amount, isWolfFood);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tabTransformers);


        setMaxStackSize(1);


       
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.DRINK;

    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        for (PotionEffect effect : effects) {
            player.addPotionEffect(effect);
        }
    }


}
