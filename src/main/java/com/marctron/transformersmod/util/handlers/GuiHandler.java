package com.marctron.transformersmod.util.handlers;

import com.marctron.transformersmod.blocks.container.ContainerEnergonCrate;
import com.marctron.transformersmod.blocks.energonengine.ContainerEnergonEngine;
import com.marctron.transformersmod.blocks.energonengine.GuiEnergonEngine;
import com.marctron.transformersmod.blocks.energonengine.TileEntityEnergonEngine;
import com.marctron.transformersmod.blocks.energonstorage.ContainerEnergonStorage;
import com.marctron.transformersmod.blocks.energonstorage.GuiEnergonStorage;
import com.marctron.transformersmod.blocks.energonstorage.TileEntityEnergonStorage;
import com.marctron.transformersmod.blocks.gui.GuiEnergonCrate;
import com.marctron.transformersmod.blocks.tileentity.TileEntityEnergonCrate;
import com.marctron.transformersmod.util.Reference;
import com.marctron.transformersmod.blocks.container.ContainerEnergonCrate;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		
		if(ID == Reference.GUI_ENERGON_CRATE) return new ContainerEnergonCrate(player.inventory, (TileEntityEnergonCrate)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == Reference.GUI_ENERGON_ENGINE) return new ContainerEnergonEngine(player.inventory, (TileEntityEnergonEngine)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == Reference.GUI_ENERGON_STORAGE) return new ContainerEnergonStorage(player.inventory, (TileEntityEnergonStorage)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		
		if(ID == Reference.GUI_ENERGON_CRATE) return new GuiEnergonCrate(player.inventory, (TileEntityEnergonCrate)world.getTileEntity(new BlockPos(x,y,z)), player);
		if(ID == Reference.GUI_ENERGON_ENGINE) return new GuiEnergonEngine(player.inventory, (TileEntityEnergonEngine)world.getTileEntity(new BlockPos(x,y,z)));
		if(ID == Reference.GUI_ENERGON_STORAGE) return new GuiEnergonStorage(player.inventory, (TileEntityEnergonStorage)world.getTileEntity(new BlockPos(x,y,z)));
		return null;
	}

}
