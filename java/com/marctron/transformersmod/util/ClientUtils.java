package com.marctron.transformersmod.util;

import com.marctron.transformersmod.items.ItemBaseMeta;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.IFluidBlock;

import java.awt.*;

public class ClientUtils
{
    private static Minecraft mc = Minecraft.getMinecraft();

    //Register a model
    public static void regModel(Item item)
    {
        if(item instanceof ItemBaseMeta && item.getHasSubtypes())
            for(int meta = 0; meta < ((ItemBaseMeta) item).getSubNames().length; meta++)
                ModelLoader.setCustomModelResourceLocation(item, meta,
                        new ModelResourceLocation(item.getRegistryName().toString() + "/" + ((ItemBaseMeta) item).getSubNames()[meta], "inventory"));
        else
            regModel(item, 0);
    }

    public static void regModel(Block block)
    {
        regModel(Item.getItemFromBlock(block), 0);
    }

    //Register a model with meta
    public static void regModel(Item item, int meta)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    //Register a fluid model
    public static void regFluidModel(IFluidBlock fluidBlock)
    {
        Item item = Item.getItemFromBlock((Block) fluidBlock);
        if(item == null)
        {
            LogHelper.fatal("Fluid " + ((Block) fluidBlock).getRegistryName() + " gave a null Item!");
            return;
        }
        ModelBakery.registerItemVariants(item);
        final ModelResourceLocation modelLoc = new ModelResourceLocation(Reference.MOD_ID + ":fluid"); //, fluidBlock.getFluid().getName());
        ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition()
        {
            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack)
            {
                return modelLoc;
            }
        });
        ModelLoader.setCustomStateMapper((Block) fluidBlock, new StateMapperBase()
        {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
            {
                return modelLoc;
            }
        });
    }

}
