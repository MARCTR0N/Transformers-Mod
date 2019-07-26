package com.marctron.transformersmod.items.gun;

import com.marctron.transformersmod.entity.EntityLargeRocket;
import com.marctron.transformersmod.init.ModItems;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class RocketLauncher extends ItemGunBase {
    int Cooldown;

    public RocketLauncher(int cooldown) {
        super("rocket_launcher", 50);
        Cooldown = cooldown;

    }

    @Override
    public IShootable getAmmoItem() {
        return ModItems.Rocket_Clip;
    }

    @Override
    protected void spawnBullet(World world, EntityPlayer player) {

        player.getCooldownTracker().setCooldown(this, Cooldown);

        Vec3d aim = player.getLookVec();
        EntityLargeRocket fireball = new EntityLargeRocket(world, player, 1, 1, 1);
        fireball.setPosition(player.posX + aim.x * 1.5D, player.posY + aim.y + 1 * 1.5D, player.posZ + aim.z * 1.5D);
        fireball.accelerationX = aim.x * 0.15;
        fireball.accelerationY = aim.y * 0.15;
        fireball.accelerationZ = aim.z * 0.15;
        world.spawnEntity(fireball);
        fireball.explosionPower = 3;

    }


    public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
        list.add(TextFormatting.GOLD + I18n.format(TextFormatting.BOLD + I18n.format("Legendary")));
        list.add("Ammo: " + getAmmoAmount(stack) + "/" + getMaxAmmo());

    }

    @Override
    public boolean getBoolean(String string) {
        // TODO Auto-generated method stub
        return true;
    }
}