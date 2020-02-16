package com.marctron.transformersmod.items;

import com.marctron.transformersmod.Main;

import com.marctron.transformersmod.util.handlers.RegistryHandler;

import net.minecraft.item.Item;

public class ItemBase extends Item {

    protected final String TOOLTIP;

    public ItemBase(String name) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tabTransformers);
        TOOLTIP = name + ".tooltip.";

        
    }
}

