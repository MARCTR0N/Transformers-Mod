package com.marctron.transformersmod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBasicMeta extends ItemBase {
    protected String[] subNames;

    public ItemBasicMeta(String itemName, String... subNames) {
        super(itemName);
        setHasSubtypes(subNames != null && subNames.length > 0);
        this.subNames = hasSubtypes ? subNames : null;
    }

    /**
     * Returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
            items.add(new ItemStack(this));
        }
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        if (hasSubtypes)
            return super.getUnlocalizedName(stack) + "." + getSubNames()[stack.getMetadata()];
        return super.getUnlocalizedName(stack);
    }

    public String[] getSubNames() {
        return subNames;
    }
}