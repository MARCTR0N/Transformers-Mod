package com.marctron.transformersmod.blocks;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.util.handlers.RegistryHandler;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockContainerBase extends BlockContainer{

	protected BlockContainerBase(Material materialIn, String name) {
		super(materialIn);
		setRegistryName(name);
		this.setUnlocalizedName(name);
		setCreativeTab(Main.tabTransformers);
		
		RegistryHandler.Registry.registerItemBlock(this);
	}
	
	
	 @SideOnly(Side.CLIENT)
	    public void initModel() {
	        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return null;
	}
}
