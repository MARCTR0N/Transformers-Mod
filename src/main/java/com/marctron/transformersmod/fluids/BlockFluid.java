package com.marctron.transformersmod.fluids;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.util.handlers.RegistryHandler;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluid extends BlockFluidClassic{

	public BlockFluid(String name,Fluid fluid, Material material) {
		super(fluid, material);
		this.setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tabTransformers);

        RegistryHandler.Registry.registerItemBlock(this);
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		// TODO Auto-generated method stub
		return EnumBlockRenderType.MODEL;
	}

}
