package com.marctron.transformersmod.blocks;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.util.handlers.RegistryHandler;

//import com.marctron.transformersmod.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {
    public BlockBase(String name, Material material) {
        super(material);
        this.setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tabTransformers);


        RegistryHandler.Registry.registerItemBlock(this);
    }
}
