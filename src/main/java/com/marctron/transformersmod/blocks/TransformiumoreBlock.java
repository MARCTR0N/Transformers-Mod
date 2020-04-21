package com.marctron.transformersmod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class TransformiumoreBlock extends BlockBase {

    public TransformiumoreBlock(String name, Material material) {
        super(name, material);
        setSoundType(SoundType.METAL);
        setHardness(5.0F);
        setHarvestLevel("pickaxe", 2);

    }

}
