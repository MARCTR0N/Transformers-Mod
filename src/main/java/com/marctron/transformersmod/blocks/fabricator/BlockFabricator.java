//package com.marctron.transformersmod.blocks.fabricator;
//
//import java.util.Random;
//
//import com.marctron.transformersmod.Main;
//import com.marctron.transformersmod.blocks.energonengine.TileEntityEnergonEngine;
//import com.marctron.transformersmod.util.Reference;
//
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockContainer;
//import net.minecraft.block.material.Material;
//import net.minecraft.block.state.IBlockState;
//import net.minecraft.entity.item.EntityItem;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.inventory.IInventory;
//import net.minecraft.item.ItemStack;
//import net.minecraft.nbt.NBTTagCompound;
//import net.minecraft.tileentity.TileEntity;
//import net.minecraft.util.EnumFacing;
//import net.minecraft.util.EnumHand;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
//public class BlockFabricator extends BlockContainer
//{
//   
//
//    private final Random rand = new Random();
//
//    public BlockFabricator()
//    {
//        super(Material.IRON);
//    }
//
//    @Override
//    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
//    {
//        if (!player.isSneaking())
//        {
//        	player.openGui(Main.instance, Reference.GUI_ENERGON_ENGINE, worldIn, pos.getX(), pos.getY(), pos.getZ());
//            return true;
//        }
//        else
//        {
//            return false;
//        }
//    }
//
//    @Override
//    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) 
//    {
//        IInventory inventory = (IInventory) worldIn.getTileEntity(pos);
//
//        if (inventory != null)
//        {
//            for (int i = 0; i < inventory.getSizeInventory(); ++i)
//            {
//                ItemStack itemstack = inventory.getStackInSlot(i);
//
//                if (itemstack != null)
//                {
//                    float f = rand.nextFloat() * 0.8F + 0.1F;
//                    float f1 = rand.nextFloat() * 0.8F + 0.1F;
//                    float f2 = rand.nextFloat() * 0.8F + 0.1F;
//
//                    while (itemstack.getMaxStackSize() > 0)
//                    {
//                        int j = rand.nextInt(21) + 10;
//
//                        if (j > itemstack.getMaxStackSize())
//                        {
//                            j = itemstack.getMaxStackSize();
//                        }
//
//                       
//                        EntityItem entityitem = new EntityItem(worldIn, f, f1, f2, itemstack);
//
//                        if (itemstack.hasTagCompound())
//                        {
//                            entityitem.getItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
//                        }
//
//                        float f3 = 0.05F;
//                        entityitem.motionX = (float) rand.nextGaussian() * f3;
//                        entityitem.motionY = (float) rand.nextGaussian() * f3 + 0.2F;
//                        entityitem.motionZ = (float) rand.nextGaussian() * f3;
//                        worldIn.spawnEntity(entityitem);
//                    }
//                }
//            }
//            TileEntityFabricator tileentity = (TileEntityFabricator)worldIn.getTileEntity(pos);
//            worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ()));
//        }
//
//        super.breakBlock(worldIn, pos, state);
//    }
//
//    @Override
//    public TileEntity createNewTileEntity(World world, int metadata)
//    {
//        return new TileEntityFabricator();
//    }
//
//    
//}
