package com.marctron.transformersmod.blocks.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

public class TileEntityCreativeGenerator extends TileEntity implements ITickable
{
    @Override
    public void update()
    {
        if(world.isRemote) return;

        for(EnumFacing dir : EnumFacing.values())
        {
            TileEntity te = world.getTileEntity(pos.offset(dir));
            if(te == null) continue;
            IEnergyStorage energy = te.getCapability(CapabilityEnergy.ENERGY, null);
            if(energy == null) continue;
            energy.receiveEnergy(Integer.MAX_VALUE, false);
        }
    }
}