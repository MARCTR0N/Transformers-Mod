package com.marctron.transformersmod.items.displaystand;

import java.util.List;
import java.util.Random;

import com.marctron.transformersmod.items.ItemBase;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Rotations;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;

public class DisplayStand extends ItemBase
{
    

    public DisplayStand(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/**
     * Called when a Block is right-clicked with this Item
     */
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (facing == EnumFacing.DOWN)
        {
            return EnumActionResult.FAIL;
        }
        else
        {
            boolean flag = worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos);
            BlockPos blockpos = flag ? pos : pos.offset(facing);
            ItemStack itemstack = player.getHeldItem(hand);

            if (!player.canPlayerEdit(blockpos, facing, itemstack))
            {
                return EnumActionResult.FAIL;
            }
            else
            {
                BlockPos blockpos1 = blockpos.up();
                boolean flag1 = !worldIn.isAirBlock(blockpos) && !worldIn.getBlockState(blockpos).getBlock().isReplaceable(worldIn, blockpos);
                flag1 = flag1 | (!worldIn.isAirBlock(blockpos1) && !worldIn.getBlockState(blockpos1).getBlock().isReplaceable(worldIn, blockpos1));

                if (flag1)
                {
                    return EnumActionResult.FAIL;
                }
                else
                {
                    double d0 = (double)blockpos.getX();
                    double d1 = (double)blockpos.getY();
                    double d2 = (double)blockpos.getZ();
                    List<Entity> list = worldIn.getEntitiesWithinAABBExcludingEntity((Entity)null, new AxisAlignedBB(d0, d1, d2, d0 + 1.0D, d1 + 2.0D, d2 + 1.0D));

                    if (!list.isEmpty())
                    {
                        return EnumActionResult.FAIL;
                    }
                    else
                    {
                        if (!worldIn.isRemote)
                        {
                            worldIn.setBlockToAir(blockpos);
                            worldIn.setBlockToAir(blockpos1);
                            EntityDisplayStand entityarmorstand = new EntityDisplayStand(worldIn, d0 + 0.5D, d1, d2 + 0.5D);
                            float f = (float)MathHelper.floor((MathHelper.wrapDegrees(player.rotationYaw - 180.0F) + 22.5F) / 45.0F) * 45.0F;
                            entityarmorstand.setLocationAndAngles(d0 + 0.5D, d1, d2 + 0.5D, f, 0.0F);
                            this.applyRandomRotations(entityarmorstand, worldIn.rand);
                            ItemMonsterPlacer.applyItemEntityDataToEntity(worldIn, player, itemstack, entityarmorstand);
                            worldIn.spawnEntity(entityarmorstand);
                            worldIn.playSound((EntityPlayer)null, entityarmorstand.posX, entityarmorstand.posY, entityarmorstand.posZ, SoundEvents.ENTITY_ARMORSTAND_PLACE, SoundCategory.BLOCKS, 0.75F, 0.8F);
                        }

                        itemstack.shrink(1);
                        return EnumActionResult.SUCCESS;
                    }
                }
            }
        }
    }

    private void applyRandomRotations(EntityDisplayStand armorStand, Random rand)
    {
        Rotations rotations = armorStand.getHeadRotation();
        float f = 1F;
        float f1 = 1F;
        Rotations rotations1 = new Rotations(rotations.getX() + f, rotations.getY() + f1, rotations.getZ());
        armorStand.setHeadRotation(rotations1);
        rotations = armorStand.getBodyRotation();
        f = rand.nextFloat() * 10.0F - 5.0F;
        rotations1 = new Rotations(rotations.getX(), rotations.getY() + f, rotations.getZ());
        armorStand.setBodyRotation(rotations1);
    }
    
    public static class InterfaceCraftingTable implements IInteractionObject
    {
        private final World world;
        

        public InterfaceCraftingTable(World worldIn, BlockPos pos)
        {
            this.world = worldIn;
            
        }

        /**
         * Get the name of this object. For players this returns their username
         */
        public String getName()
        {
            return "crafting_table";
        }

        /**
         * Returns true if this thing is named
         */
        public boolean hasCustomName()
        {
            return false;
        }

        /**
         * Get the formatted ChatComponent that will be used for the sender's username in chat
         */
        public ITextComponent getDisplayName()
        {
            return new TextComponentTranslation(Blocks.CRAFTING_TABLE.getUnlocalizedName() + ".name", new Object[0]);
        }

        public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
        {
            return new ContainerWorkbench(playerInventory, this.world, null);
        }

        public String getGuiID()
        {
            return "minecraft:crafting_table";
        }
    }
}