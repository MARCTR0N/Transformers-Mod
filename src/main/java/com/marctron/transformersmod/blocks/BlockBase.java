package com.marctron.transformersmod.blocks;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.init.ModBlocks;
import com.marctron.transformersmod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block {
    public BlockBase(String name, Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tabTransformers);


        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }
}
