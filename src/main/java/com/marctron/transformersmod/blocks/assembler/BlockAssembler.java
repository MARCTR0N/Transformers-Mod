package com.marctron.transformersmod.blocks.assembler;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.blocks.BlockBase;
import com.marctron.transformersmod.util.Reference;
import com.marctron.transformersmod.util.handlers.RegistryHandler;
import com.marctron.transformersmod.util.interfaces.IEnableable;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;

public class BlockAssembler extends Block implements ITileEntityProvider, IEnableable 
{
    public BlockAssembler(String name, Material material) {
        super(material);
       
        setRegistryName(name);
        setCreativeTab(Main.tabTransformers);


        RegistryHandler.Registry.registerItemBlock(this);
    }

    /**
     * Called when the block is right clicked by a player.
     */
    
    @Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (world.isRemote) {
			return true;
		} else {
			TileEntity tileentity = world.getTileEntity(pos);

			if (tileentity instanceof TileAssembler) {
				player.openGui(Main.instance, Reference.GUI_ASSEMBLER, world, pos.getX(), pos.getY(), pos.getZ());
			}
			
			return true;
		}
	}
    
    	
    	
			
					


    @Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileAssembler();
	}
    
    @Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
    	TileAssembler tile = (TileAssembler) world.getTileEntity(pos);
		if (tile != null) {
			NonNullList<ItemStack> matrix = tile.getMatrix();
			for (int i = 0; i < matrix.size(); i++) {
				ItemStack stack = matrix.get(i);
				this.spawnAsEntity(world, pos, stack);
			}
		}
		
		super.breakBlock(world, pos, state);
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
}