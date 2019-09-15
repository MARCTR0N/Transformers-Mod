package com.marctron.transformersmod.items.gun;

import com.marctron.transformersmod.entity.EntityBullet;
import com.marctron.transformersmod.entity.EntityLargeRocket;
import com.marctron.transformersmod.util.handlers.RegistryHandler;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class NeutronRepeater extends ItemGunBase {
    int Cooldown;

    public NeutronRepeater(int cooldown) {
        super("neutron_repeater", 3);
        Cooldown = cooldown;
    }

    @Override
    public IShootable getAmmoItem() {
        return RegistryHandler.ModItems.Neutron_Repeater_Clip;
    }

    @Override
    protected void spawnBullet(World world, EntityPlayer player) {
        player.getCooldownTracker().setCooldown(this, Cooldown);
        world.spawnEntity(new EntityBullet(world, player).setDamage(2f));
//        world.spawnEntity(new EntityBullet(world, player, Cooldown));
//        Vec3d aim = player.getLookVec();
//        EntityBullet bullet = new EntityBullet(world, 1, 1, 1);
//        bullet.setPosition(player.posX + aim.x * 1.5D, player.posY + aim.y + 1 * 1.5D, player.posZ + aim.z * 1.5D);
//        bullet.motionX = aim.x * 0.05;
//        bullet.motionY = aim.y * 0.05;
//        bullet.motionZ = aim.z * 0.05;
//        world.spawnEntity(bullet);

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
