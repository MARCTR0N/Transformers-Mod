package com.marctron.transformersmod.items;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.entity.EntityLargeRocket;
import com.marctron.transformersmod.init.ModItems;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemStarSaber extends ItemSword {

    private final float attackDamage;

    int Cooldown;

    public ItemStarSaber(String name, int cooldown, ToolMaterial material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tabTransformers);

        Cooldown = cooldown;


        setMaxStackSize(1);

        ModItems.ITEMS.add(this);

        this.attackDamage = 1.0F;
    }


    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        Vec3d aim = playerIn.getLookVec();
        EntityLargeRocket fireball = new EntityLargeRocket(worldIn, playerIn, 1, 1, 1);

//		EntityBullet fireball = new EntityBullet(worldIn, 1, 1, 1);


//		if(playerIn.getHealth() != playerIn.getMaxHealth())
//		{
        playerIn.getCooldownTracker().setCooldown(this, Cooldown);
        if (!worldIn.isRemote) {
//				playerIn.setHealth(playerIn.getHealth() + HealthFix);
            fireball.setPosition(playerIn.posX + aim.x * 1.5D, playerIn.posY + aim.y + 1 * 1.5D, playerIn.posZ + aim.z * 1.5D);
            fireball.accelerationX = aim.x * 0.05;
            fireball.accelerationY = aim.y * 0.05;
            fireball.accelerationZ = aim.z * 0.05;
            worldIn.spawnEntity(fireball);
            fireball.explosionPower = 4;


        }

//			playerIn.inventory.clearMatchingItems(ModItems.ENERGON_SHARD, 0, 1, null);

//		}

        return new ActionResult(EnumActionResult.SUCCESS, itemstack);
    }

    public void addInformation(ItemStack stack, @Nullable World world, List<String> list, ITooltipFlag flag) {
        list.add(TextFormatting.DARK_PURPLE + I18n.format(TextFormatting.BOLD + I18n.format("Mythic")));
    }

}
