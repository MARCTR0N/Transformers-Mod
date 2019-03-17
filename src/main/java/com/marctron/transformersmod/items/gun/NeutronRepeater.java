package com.marctron.transformersmod.items.gun;

import com.marctron.transformersmod.entity.EntityBullet;
import com.marctron.transformersmod.init.ModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class NeutronRepeater extends ItemGunBase
{
    public NeutronRepeater()
    {
        super("neutron_repeater", 3);
    }

    @Override
    public IShootable getAmmoItem()
    {
        return ModItems.Neutron_Repeater_Clip;
    }
    
    @Override
    protected void spawnBullet(World world, EntityPlayer player)
    {
        world.spawnEntity(new EntityBullet(world, player).setDamage(2f));
    }
}
