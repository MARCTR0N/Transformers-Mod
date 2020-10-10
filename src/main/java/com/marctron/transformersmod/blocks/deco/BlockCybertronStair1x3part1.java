package com.marctron.transformersmod.blocks.deco;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCybertronStair1x3part1 extends BlockHorizontalBase{

	
	public static AxisAlignedBB AABB_N_1;
	public static AxisAlignedBB AABB_N_2;
	public static AxisAlignedBB AABB_N_3;
	public static AxisAlignedBB AABB_N_4;
	public static AxisAlignedBB AABB_N_5;
	public static AxisAlignedBB AABB_N_6;
	
	public static AxisAlignedBB AABB_S_1;
	public static AxisAlignedBB AABB_S_2;
	public static AxisAlignedBB AABB_S_3;
	public static AxisAlignedBB AABB_S_4;
	public static AxisAlignedBB AABB_S_5;
	public static AxisAlignedBB AABB_S_6;
	
	public static AxisAlignedBB AABB_E_1;
	public static AxisAlignedBB AABB_E_2;
	public static AxisAlignedBB AABB_E_3;
	public static AxisAlignedBB AABB_E_4;
	public static AxisAlignedBB AABB_E_5;
	public static AxisAlignedBB AABB_E_6;
	
	public static AxisAlignedBB AABB_W_1;
	public static AxisAlignedBB AABB_W_2;
	public static AxisAlignedBB AABB_W_3;
	public static AxisAlignedBB AABB_W_4;
	public static AxisAlignedBB AABB_W_5;
	public static AxisAlignedBB AABB_W_6;
	
	public BlockCybertronStair1x3part1(String name, Material material) {
		super(name, material);
		AABB_N_1 = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);
		AABB_N_2 = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 0.8125D);
		AABB_N_3 = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.1875D, 0.625D);
		AABB_N_4 = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 0.4375D);
		AABB_N_5 = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.3125D, 0.25D);
		AABB_N_6 = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 0.0625D);
		
		AABB_S_1 = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);
		AABB_S_2 = new AxisAlignedBB(0.0D, 0.0D, 0.0625D, 1.0D, 0.125D, 1.0D);
		AABB_S_3 = new AxisAlignedBB(0.0D, 0.0D, 0.25D, 1.0D, 0.1875D, 1.0D);
		AABB_S_4 = new AxisAlignedBB(0.0D, 0.0D, 0.4375D, 1.0D, 0.25D, 1.0D);
		AABB_S_5 = new AxisAlignedBB(0.0D, 0.0D, 0.625D, 1.0D, 0.3125D, 1.0D);
		AABB_S_6 = new AxisAlignedBB(0.0D, 0.0D, 0.8125D, 1.0D, 0.375D, 1.0D);
		
		AABB_W_1 = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);
		AABB_W_2 = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.8125D, 0.125D, 1.0D);
		AABB_W_3 = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.625D, 0.1875D, 1.0D);
		AABB_W_4 = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.4375D, 0.25D, 1.0D);
		AABB_W_5 = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.25D, 0.3125D, 1.0D);
		AABB_W_6 = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0625D, 0.375D, 1.0D);
		
		AABB_E_1 = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);
		AABB_E_2 = new AxisAlignedBB(0.0625D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D);
		AABB_E_3 = new AxisAlignedBB(0.25D, 0.0D, 0.0D, 1.0D, 0.1875D, 1.0D);
		AABB_E_4 = new AxisAlignedBB(0.4375D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D);
		AABB_E_5 = new AxisAlignedBB(0.625D, 0.0D, 0.0D, 1.0D, 0.3125D, 1.0D);
		AABB_E_6 = new AxisAlignedBB(0.8125D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D);
		
		setCreativeTab(Main.tabTFBlocks);			
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_)
	{
//		for (AxisAlignedBB axisAlignedBB : getCollisionBoxesWest())
//		{
//			addCollisionBoxToList(pos,entityBox, collidingBoxes, axisAlignedBB);
//		}
		
		switch ((EnumFacing)state.getValue(FACING))
        {
		
            case SOUTH:
            	for (AxisAlignedBB axisAlignedBB : getCollisionBoxesNorth())
        		{
        			addCollisionBoxToList(pos,entityBox, collidingBoxes, axisAlignedBB);
        		}
            default:            	
                return ;
            case NORTH:
            	for (AxisAlignedBB axisAlignedBB : getCollisionBoxesSouth())
        		{
        			addCollisionBoxToList(pos,entityBox, collidingBoxes, axisAlignedBB);
        		}
                return ;
            case WEST:
            	for (AxisAlignedBB axisAlignedBB : getCollisionBoxesEast())
            		{
            			addCollisionBoxToList(pos,entityBox, collidingBoxes, axisAlignedBB);
            		}
                return ;
            case EAST:
            	for (AxisAlignedBB axisAlignedBB : getCollisionBoxesWest())
        		{
        			addCollisionBoxToList(pos,entityBox, collidingBoxes, axisAlignedBB);
        		}
                return ;
        }
	}


	private List<AxisAlignedBB> getCollisionBoxesNorth()
	{
		List<AxisAlignedBB> aabb = new ArrayList<>();
		aabb.add(AABB_N_1);
		aabb.add(AABB_N_2);
		aabb.add(AABB_N_3);
		aabb.add(AABB_N_4);
		aabb.add(AABB_N_5);
		aabb.add(AABB_N_6);
      
		return aabb;
	}
	private List<AxisAlignedBB> getCollisionBoxesSouth()
	{
		List<AxisAlignedBB> aabb = new ArrayList<>();
		aabb.add(AABB_S_1);
		aabb.add(AABB_S_2);
		aabb.add(AABB_S_3);
		aabb.add(AABB_S_4);
		aabb.add(AABB_S_5);
		aabb.add(AABB_S_6);
      
		return aabb;
	}	
	private List<AxisAlignedBB> getCollisionBoxesEast()
	{
		List<AxisAlignedBB> aabb = new ArrayList<>();
		aabb.add(AABB_E_1);
		aabb.add(AABB_E_2);
		aabb.add(AABB_E_3);
		aabb.add(AABB_E_4);
		aabb.add(AABB_E_5);
		aabb.add(AABB_E_6);
      
		return aabb;
	}	
	private List<AxisAlignedBB> getCollisionBoxesWest()
	{
		List<AxisAlignedBB> aabb = new ArrayList<>();
		aabb.add(AABB_W_1);
		aabb.add(AABB_W_2);
		aabb.add(AABB_W_3);
		aabb.add(AABB_W_4);
		aabb.add(AABB_W_5);
		aabb.add(AABB_W_6);
      
		return aabb;
	}
}
