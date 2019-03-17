package com.marctron.transformersmod.items.gun;

import com.marctron.transformersmod.entity.EntityBullet;
import com.marctron.transformersmod.init.ModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ScatterBlaster extends ItemGunBase
{
    public ScatterBlaster()
    {
        super("scatterblaster", 6);
    }

    @Override
    public IShootable getAmmoItem()
    {
        return ModItems.Scatter_Blaster_Shell;
    }

    @Override
    protected void spawnBullet(World world, EntityPlayer player)
    {
        for(int i = 0; i < 6; i++)
            world.spawnEntity(new EntityBullet(world, player, 35f));
    }
}
