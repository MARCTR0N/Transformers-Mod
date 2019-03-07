package com.marctron.transformersmod.items.gun;
import com.marctron.transformersmod.items.ItemBase;
import com.marctron.transformersmod.items.ItemBasic;
import com.marctron.transformersmod.util.NBTHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

import javax.annotation.Nullable;

public class AmmoClip extends ItemBase implements IShootable
{
    //TODO: Make texture change depending on how full it is?
    public int clipSize;

    public AmmoClip(String itemName, int clipSize)
    {
        super(itemName);
        setMaxStackSize(1);
        this.clipSize = clipSize;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (this.isInCreativeTab(tab))
        {
            items.add(new ItemStack(this));
        }
    }

    public static void setBulletsAmount(ItemStack stack, int amount)
    {
        NBTHelper.setInteger(stack, "ammo", Math.max(Math.min(amount, ((AmmoClip) stack.getItem()).clipSize), 0));
    }

    public static int getBulletsAmount(ItemStack stack)
    {
        return NBTHelper.getInt(stack, "ammo");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
    
        tooltip.add("Bullets: " + getBulletsAmount(stack) + "/" + clipSize);
    }

    @Override
    public boolean isClip()
    {
        return true;
    }

    @Override
    public int getMaxAmmo()
    {
        return clipSize;
    }
}