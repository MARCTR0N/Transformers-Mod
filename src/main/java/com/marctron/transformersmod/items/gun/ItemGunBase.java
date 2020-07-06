package com.marctron.transformersmod.items.gun;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.util.LogHelper;
import com.marctron.transformersmod.util.NBTHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public abstract class ItemGunBase extends ItemCooldown implements IGun {
    public ItemGunBase(String itemName, int maxCooldown) {
        super(itemName, maxCooldown);
        setCreativeTab(Main.tabWeapons);
    }

    private static boolean isAmmoForGun(ItemStack gun, ItemStack ammo) {
        if (!(gun.getItem() instanceof IGun) || !(ammo.getItem() instanceof IShootable))
            return false;
        return ((IGun) gun.getItem()).getAmmoItem() == ammo.getItem();
    }

    /**
     * Reloads the gun as much as possible using any ammo clips in the player's inventory
     */
    public static void reloadAll(EntityPlayer player, ItemStack gunStack) {
        if (!(gunStack.getItem() instanceof IGun)) {
            LogHelper.error("Trying to reload an ItemStack that is null or it's Item isn't an instance of IUseAmmo!");
            return;
        }

        //Check held items first
        for (EnumHand hand : EnumHand.values()) {
            ItemStack heldStack = player.getHeldItem(hand);
            int remaining = reloadWithStack(gunStack, heldStack);
            if (heldStack.getCount() == 0) player.setHeldItem(hand, ItemStack.EMPTY);
            if (remaining == 0) return;
        }

    

        //Check main inventory
        for (int i = 0; i < player.inventory.mainInventory.size(); i++) {
            ItemStack stack = player.inventory.mainInventory.get(i);
            int remaining = reloadWithStack(gunStack, stack);
            if (stack.getCount() == 0) player.inventory.mainInventory.set(i, ItemStack.EMPTY);
            if (remaining == 0) return;
        }
    }

    /**
     * Reloads the gun with the given stack
     * Returns how many bullets weren't used of the amount given
     */
    public static int reloadWithStack(ItemStack gunStack, ItemStack clipStack) {
        if (!isAmmoForGun(gunStack, clipStack) || !(clipStack.getItem() instanceof IShootable)) return -1;
        boolean isClip = ((IShootable) clipStack.getItem()).isClip();
        int ammo = isClip ? AmmoClip.getBulletsAmount(clipStack) : clipStack.getCount();
        int remaining = reload(gunStack, ammo);
        if (isClip)
            AmmoClip.setBulletsAmount(clipStack, remaining);
        else
            clipStack.setCount(remaining);
        return ((IGun) gunStack.getItem()).getAmmoSpace(gunStack);
    }

    /**
     * Reloads the gun with the given amount of bullets
     * Returns how many bullets weren't used of the amount given
     */
    public static int reload(ItemStack gunStack, int bullets) {
        int spaceInGun = ((IGun) gunStack.getItem()).getAmmoSpace(gunStack);
        if (spaceInGun == 0 || bullets == 0)
            return bullets;
        int toRefill = Math.min(spaceInGun, bullets);
        ((IGun) gunStack.getItem()).setAmmoAmount(gunStack, ((IGun) gunStack.getItem()).getAmmoAmount(gunStack) + toRefill);
        return bullets - toRefill;
    }

    /**
     * Called to spawn the bullet(s) in the world
     * Ammo reduction is handled after this
     */
    protected abstract void spawnBullet(World world, EntityPlayer player);

    public int getMaxAmmo() {
        return getAmmoItem().getMaxAmmo();
    }

    /**
     * This will get called by onItemRightClick when the cooldown is 0
     *
     * @return True if the cooldown should be started.
     */
    @Override
    protected boolean doRightClickAction(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
        if (world.isRemote) return true;

        int ammo = getAmmoAmount(stack);

        if (player.isSneaking()) {
            //Reload
            if (ammo < getMaxAmmo()) {
                reloadAll(player, stack);
                return true;
            }
            return false;
        } else {
            if (!player.capabilities.isCreativeMode && ammo == 0) {
                player.world.playSound(null, player.getPosition(), SoundEvents.BLOCK_DISPENSER_FAIL, SoundCategory.NEUTRAL, 1f, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + 0.5F);
                return false;
            }
            //Shoot
            spawnBullet(world, player);
            player.world.playSound(null, player.getPosition(), SoundEvents.ENTITY_FIREWORK_LARGE_BLAST, SoundCategory.NEUTRAL, 1f, 1.30F / (itemRand.nextFloat() * 0.4F + 1.2F) + 0.00001F);
            player.world.playSound(null, player.getPosition(), SoundEvents.ENTITY_BLAZE_HURT, SoundCategory.NEUTRAL, 0.05f, 1.10F / (itemRand.nextFloat() * 0.4F + 1.2F) + 0.00001F);
            player.world.playSound(null, player.getPosition(), SoundEvents.BLOCK_STONE_BREAK, SoundCategory.NEUTRAL, 1f, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + 0.00001F);
            if (!player.capabilities.isCreativeMode)
                setAmmoAmount(stack, --ammo);
            return true;
        }
    }

    @Override
    public void setAmmoAmount(ItemStack stack, int amount) {
        NBTHelper.setInteger(stack, "ammo", Math.max(amount, 0));
    }

    @Override
    public int getAmmoAmount(ItemStack stack) {
        return NBTHelper.getInt(stack, "ammo");
    }

    @Override
    public int getAmmoSpace(ItemStack stack) {
        return getMaxAmmo() - getAmmoAmount(stack);
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        return 1 - ((float) getAmmoAmount(stack) / (float) getMaxAmmo());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add("Ammo: " + getAmmoAmount(stack) + "/" + getMaxAmmo());
    }


}