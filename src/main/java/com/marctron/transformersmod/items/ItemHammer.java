package com.marctron.transformersmod.items;



import com.marctron.transformersmod.entity.EntityHammerPound;
import net.ilexiconn.llibrary.server.entity.EntityPropertiesHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.*;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


import com.marctron.transformersmod.Main;

import java.util.List;

import javax.annotation.Nullable;

public class ItemHammer extends ItemSword {
	
	private final float attackDamage;
	int Cooldown;
	
    public ItemHammer(String name, ToolMaterial material, int cooldown) {
    	super(material);
    	setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.tabTransformers);
        
        Cooldown = cooldown;
        this.attackDamage = 5;
    }

    @Override
    public boolean getIsRepairable(ItemStack itemStack, ItemStack itemStackMaterial) {
        return false;
    }

    @Override
    public boolean hitEntity(ItemStack heldItemStack, EntityLivingBase player, EntityLivingBase entityHit) {
        if (!player.world.isRemote) {
            player.playSound(SoundEvents.BLOCK_ANVIL_LAND, 0.3F, 0.5F);
        }
        return true;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
        if (!world.isRemote) {

        	

                if (player.isSneaking() && player.onGround) {
//                	player.getCooldownTracker().setCooldown(this, Cooldown);
                    EntityHammerPound hammerpound = new EntityHammerPound(world, player, true);
                    world.spawnEntity(hammerpound);
                    
                }
//                else {
//                	EntityHammerPound axeAttack = new EntityHammerPound(world, player, false);
//                    world.spawnEntity(axeAttack);
//                }


        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
    }

    @Override
    public boolean onBlockDestroyed(ItemStack itemStack, World world, IBlockState block, BlockPos pos, EntityLivingBase destroyer) {
        return true;
    }

    @Override
    public float getDestroySpeed(ItemStack itemStack, IBlockState block) {
        return 1.0F;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack itemStack) {
        return EnumAction.BOW;
    }

//    @Override
//    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
//        super.addInformation(stack, worldIn, tooltip, flagIn);
//        
//    }
}