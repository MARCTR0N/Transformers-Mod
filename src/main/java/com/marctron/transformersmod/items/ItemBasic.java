package com.marctron.transformersmod.items;

import com.marctron.transformersmod.Main;
import net.minecraft.item.Item;

public class ItemBasic extends Item {
    protected final String TOOLTIP;

    public ItemBasic(String itemName) {
        setCreativeTab(Main.tabTransformers);
        setUnlocalizedName(itemName);
        setRegistryName(itemName);
        TOOLTIP = getUnlocalizedName() + ".tooltip.";
    }


}