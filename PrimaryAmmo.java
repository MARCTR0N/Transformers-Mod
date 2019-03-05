package com.marctron.transformersmod.items;

import javax.annotation.Nullable;

import com.marctron.transformersmod.util.CommonUtils;
import com.marctron.transformersmod.util.handlers.EnumGuiID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class PrimaryAmmo extends ItemBase
{
    //TODO: Make ammo belt be able to be put in the belt bauble slot

    public PrimaryAmmo()
    {
        super("primary_ammo");
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if(!worldIn.isRemote && !playerIn.isSneaking())
            CommonUtils.openGui(playerIn, worldIn, EnumGuiID.PRIMARY_AMMO);
        return new ActionResult<>(EnumActionResult.PASS, playerIn.getHeldItem(hand));
    }

    public static ItemStackHandler getInventoryHandler(ItemStack stack)
    {
        return (ItemStackHandler) stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
    }

    @Override
    public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt)
    {
        return new ICapabilitySerializable()
        {
            private ItemStackHandler items = new ItemStackHandler(9);

            @Override
            public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing)
            {
                return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
            }

            @Override
            public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing)
            {
                return hasCapability(capability, facing) ? (T) items : null;
            }

            @Override
            public NBTBase serializeNBT()
            {
                return items.serializeNBT();
            }

            @Override
            public void deserializeNBT(NBTBase nbt)
            {
                items.deserializeNBT((NBTTagCompound) nbt);
            }
        };
    }
}
