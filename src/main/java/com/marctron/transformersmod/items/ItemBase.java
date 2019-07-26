package com.marctron.transformersmod.items;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.init.ModItems;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    protected final String TOOLTIP;

    public ItemBase(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tabTransformers);
        TOOLTIP = getUnlocalizedName() + ".tooltip.";

        ModItems.ITEMS.add(this);
    }
}

