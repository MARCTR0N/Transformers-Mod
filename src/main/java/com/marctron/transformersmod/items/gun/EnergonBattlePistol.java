package com.marctron.transformersmod.items.gun;

import com.marctron.transformersmod.entity.EntityBullet;
import com.marctron.transformersmod.init.ModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EnergonBattlePistol extends ItemGunBase
{
    public EnergonBattlePistol()
    {
        super("energon_pistol", 9);
    }

    @Override
    public IShootable getAmmoItem()
    {
        return ModItems.Energon_Battle_Pistol_CLip;
    }
    
    @Override
    protected void spawnBullet(World world, EntityPlayer player)
    {
        world.spawnEntity(new EntityBullet(world, player).setDamage(6f));
    }
}
