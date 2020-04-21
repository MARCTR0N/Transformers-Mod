package com.marctron.transformersmod.blocks;



import com.marctron.transformersmod.util.handlers.RegistryHandler;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class DarkEnergonoreBlock extends BlockBase {

    private final boolean isOn;

    public DarkEnergonoreBlock(String name, Material material, boolean isOn) {
        super(name, material);
        setSoundType(SoundType.METAL);
        setHardness(5.0F);
        setHarvestLevel("pickaxe", 2);
        setLightLevel(0.3F);


        if (isOn) {
            this.setTickRandomly(true);
        }

        this.isOn = isOn;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random par2Random, int par3) {
        return new ItemStack(RegistryHandler.ModItems.DARK_ENERGON_SHARD).getItem();

    }

    public int quantityDroppedWithBonus(int fortune, Random random) {
        return 2 + random.nextInt(6);
    }

    //_____________________________________________________________________________________________________________________________


    public int tickRate(World worldIn) {
        return 30;

    }

    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        this.activate(worldIn, pos);
        super.onBlockClicked(worldIn, pos, playerIn);
    }

    /**
     * Called when the given entity walks on this Block
     */
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        this.activate(worldIn, pos);
        super.onEntityWalk(worldIn, pos, entityIn);
    }


    private void activate(World worldIn, BlockPos pos) {
        this.spawnParticles(worldIn, pos);

        if (this == RegistryHandler.ModBlocks.DARK_ENERGON_ORE_BLOCK) {
            worldIn.setBlockState(pos, RegistryHandler.ModBlocks.DARK_ENERGON_ORE_BLOCK.getDefaultState());
        }
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (this == RegistryHandler.ModBlocks.DARK_ENERGON_ORE_BLOCK) {
            worldIn.setBlockState(pos, RegistryHandler.ModBlocks.DARK_ENERGON_ORE_BLOCK.getDefaultState());
        }
    }


    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (this.isOn) {
            this.spawnParticles(worldIn, pos);
        }
    }


    private void spawnParticles(World worldIn, BlockPos pos) {
        //this.activate(worldIn, pos);

        Random random = worldIn.rand;
        double d0 = 0.0625D;

        for (int i = 0; i < 6; ++i) {
            double d1 = (double) ((float) pos.getX() + random.nextFloat());
            double d2 = (double) ((float) pos.getY() + random.nextFloat());
            double d3 = (double) ((float) pos.getZ() + random.nextFloat());

            if (i == 0 && !worldIn.getBlockState(pos.up()).isOpaqueCube()) {
                d2 = (double) pos.getY() + 0.0625D + 1.0D;
            }

            if (i == 1 && !worldIn.getBlockState(pos.down()).isOpaqueCube()) {
                d2 = (double) pos.getY() - 0.0625D;
            }

            if (i == 2 && !worldIn.getBlockState(pos.south()).isOpaqueCube()) {
                d3 = (double) pos.getZ() + 0.0625D + 1.0D;
            }

            if (i == 3 && !worldIn.getBlockState(pos.north()).isOpaqueCube()) {
                d3 = (double) pos.getZ() - 0.0625D;
            }

            if (i == 4 && !worldIn.getBlockState(pos.east()).isOpaqueCube()) {
                d1 = (double) pos.getX() + 0.0625D + 1.0D;
            }

            if (i == 5 && !worldIn.getBlockState(pos.west()).isOpaqueCube()) {
                d1 = (double) pos.getX() - 0.0625D;
            }

            if (d1 < (double) pos.getX() || d1 > (double) (pos.getX() + 1) || d2 < 0.0D || d2 > (double) (pos.getY() + 1) || d3 < (double) pos.getZ() || d3 > (double) (pos.getZ() + 1)) {
                worldIn.spawnParticle(EnumParticleTypes.REDSTONE, d1, d2, d3, 0.5D, 0.0D, 0.8D);
                //worldIn.spawnParticle(EnumParticleTypes.DRAGON_BREATH, d1, d2, d3, 0.0D, 0.0D, 0.0D);


            }
        }
    }


}
