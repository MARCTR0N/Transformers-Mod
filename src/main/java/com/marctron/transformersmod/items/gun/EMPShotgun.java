package com.marctron.transformersmod.items.gun;

import java.util.List;

import javax.annotation.Nullable;

import com.marctron.transformersmod.entity.EntityBullet;
import com.marctron.transformersmod.util.handlers.RegistryHandler;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class EMPShotgun extends ItemGunBase {
    int Cooldown;

    public EMPShotgun(int cooldown) {
        super("empshotgun", 11);
        Cooldown = cooldown;
    }

    @Override
    public IShootable getAmmoItem() {
        return RegistryHandler.ModItems.EMP_Shotgun_Shell;
    }

    @Override
    protected void spawnBullet(World world, EntityPlayer player) {
        player.getCooldownTracker().setCooldown(this, Cooldown);

        for (int i = 0; i < 6; i++)
            world.spawnEntity(new EntityBullet(world, player, 10f).setDamage(2f));
    }

    public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
        list.add(TextFormatting.AQUA + I18n.format(TextFormatting.BOLD + I18n.format("Uncommon")));
        list.add("Ammo: " + getAmmoAmount(stack) + "/" + getMaxAmmo());

    }

    @Override
    public boolean getBoolean(String string) {
        // TODO Auto-generated method stub
        return true;
    }
}

