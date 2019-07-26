package com.marctron.transformersmod.items;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemMedkit extends Item {


    int HealthFix;
    int Cooldown;

    public ItemMedkit(String name, int StackSize, int health, int cooldown) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tabTransformers);

        Cooldown = cooldown;
        HealthFix = health;

        setMaxStackSize(1);

        ModItems.ITEMS.add(this);

    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (playerIn.getHealth() != playerIn.getMaxHealth()) {
            playerIn.getCooldownTracker().setCooldown(this, Cooldown);
            if (!worldIn.isRemote) {
                playerIn.setHealth(playerIn.getHealth() + HealthFix);

            }

            playerIn.inventory.clearMatchingItems(ModItems.ENERGON_SHARD, 0, 1, null);

        }

        return new ActionResult(EnumActionResult.SUCCESS, itemstack);
    }
}