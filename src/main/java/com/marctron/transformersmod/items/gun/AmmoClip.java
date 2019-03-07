package com.marctron.transformersmod.items.gun;
import com.marctron.transformersmod.items.ItemBase;
import com.marctron.transformersmod.items.ItemBasic;
import com.marctron.transformersmod.util.NBTHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

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
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems)
    {
        //Add empty and full clips
        ItemStack clip = new ItemStack(itemIn);
        setBulletsAmount(clip, 0);
        subItems.add(clip.copy());
        setBulletsAmount(clip, clipSize);
        subItems.add(clip);
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
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
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