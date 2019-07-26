package com.marctron.transformersmod.items.gun;

import com.marctron.transformersmod.entity.EntityBullet;
import com.marctron.transformersmod.init.ModItems;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class EnergonBattlePistol extends ItemGunBase {
    int Cooldown;

    public EnergonBattlePistol(int cooldown) {
        super("energon_pistol", 9);
        Cooldown = cooldown;
    }

    @Override
    public IShootable getAmmoItem() {
        return ModItems.Energon_Battle_Pistol_Clip;
    }

    @Override
    protected void spawnBullet(World world, EntityPlayer player) {
        player.getCooldownTracker().setCooldown(this, Cooldown);
        world.spawnEntity(new EntityBullet(world, player).setDamage(5f));
    }

    public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
        list.add(TextFormatting.GREEN + I18n.format(TextFormatting.BOLD + I18n.format("Common")));
        list.add("Ammo: " + getAmmoAmount(stack) + "/" + getMaxAmmo());

    }

    @Override
    public boolean getBoolean(String string) {
        // TODO Auto-generated method stub
        return true;
    }
}
