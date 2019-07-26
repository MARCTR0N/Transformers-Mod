package com.marctron.transformersmod.items.gun;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.items.ItemBase;
import com.marctron.transformersmod.util.NBTHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class AmmoClip extends ItemBase implements IShootable {
    //TODO: Make texture change depending on how full it is?
    public int clipSize;

    public AmmoClip(String itemName, int clipSize) {
        super(itemName);
        setMaxStackSize(1);
        this.clipSize = clipSize;
        setCreativeTab(Main.tabWeapons);
    }

    public static void setBulletsAmount(ItemStack stack, int amount) {
        NBTHelper.setInteger(stack, "ammo", Math.max(Math.min(amount, ((AmmoClip) stack.getItem()).clipSize), 0));
    }

    public static int getBulletsAmount(ItemStack stack) {
        return NBTHelper.getInt(stack, "ammo");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
            //Add empty and full clips
            ItemStack clip = new ItemStack(this);
            setBulletsAmount(clip, 0);
            items.add(clip.copy());
            setBulletsAmount(clip, clipSize);
            items.add(clip);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.YELLOW + I18n.format("Ammo"));
        tooltip.add("Bullets: " + getBulletsAmount(stack) + "/" + clipSize);

    }

    @Override
    public boolean isClip() {
        return true;
    }

    @Override
    public int getMaxAmmo() {
        return clipSize;
    }
}