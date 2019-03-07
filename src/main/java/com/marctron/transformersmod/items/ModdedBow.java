package com.marctron.transformersmod.items;

import javax.annotation.Nullable;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.init.ModItems;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModdedBow extends ItemBow
{
	
	
		public ModdedBow(String name)
		{
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Main.tabTransformers);
		
		ModItems.ITEMS.add(this);
	

        this.maxStackSize = 1;
        this.setMaxDamage(384);
       
        this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter()
        {
        @SideOnly(Side.CLIENT)
        public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
        {
        if (entityIn == null)
        {
        return 0.0F;
        }
        else
        {
        return entityIn.getActiveItemStack().getItem() != ModItems.PHOTON_BURST_RIFLE ? 0.0F : (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F;
        }
        }
        });
        this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter()
        {
        @SideOnly(Side.CLIENT)
        public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
        {
        return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
        }
        });
        
        
	}
	
	private ItemStack findAmmo(EntityPlayer player)
    {
        if (this.isItemArrow(player.getHeldItem(EnumHand.OFF_HAND)))
        {
            return player.getHeldItem(EnumHand.OFF_HAND);
        }
        else if (this.isItemArrow(player.getHeldItem(EnumHand.MAIN_HAND)))
        {
            return player.getHeldItem(EnumHand.MAIN_HAND);
        }
        else
        {
            for (int i = 0; i < player.inventory.getSizeInventory(); ++i)
            {
                ItemStack itemstack = player.inventory.getStackInSlot(i);

                if (this.isItemArrow(itemstack))
                {
                    return itemstack;
                }
            }

            return ItemStack.EMPTY;
        }
    }
	
	private boolean isItemArrow(ItemStack itemstack) {
		
		return itemstack.getItem() instanceof ItemArrow;
	}
	
	public static float getArrowVelocity(int charge)
    {
        float f = (float)charge / 4.0F; 
        f = (f * f + f * 2.0F) / 3.0F;

        if (f > 1.0F)
        {
            f = 1.0F;
        }

        return f;
    }
	
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft)
	{
	if (entityLiving instanceof EntityPlayer)
	{
	EntityPlayer entityplayer = (EntityPlayer)entityLiving;
	boolean flag = entityplayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;//flag is true if no arrows are to be consumed
	ItemStack itemstack = this.findAmmo(entityplayer);//looks for ammo (see above)

	int i = this.getMaxItemUseDuration(stack) - timeLeft;//the time that it has been used for
	i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer, i, !itemstack.isEmpty() || flag);
	if (i < 0) return;

	if (!itemstack.isEmpty() || flag)
	{
	if (itemstack.isEmpty())
	{
	itemstack = new ItemStack(Items.ARROW);
	}

	float f = getArrowVelocity(i);

	if ((double)f >= 0.1D)//if the velocity is lower than this, it does not fire
	{
	boolean flag1 = entityplayer.capabilities.isCreativeMode || (itemstack.getItem() instanceof ItemArrow && ((ItemArrow) itemstack.getItem()).isInfinite(itemstack, stack, entityplayer));

	if (!worldIn.isRemote)
	{
		ItemArrow itemarrow = (ItemArrow)(itemstack.getItem() instanceof ItemArrow ? itemstack.getItem() : Items.ARROW);
	EntityArrow entityarrow = itemarrow.createArrow(worldIn, itemstack, entityplayer);//creates the arrow entity
	entityarrow.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 10.0F/*velocity*/, 1.0F/*inaccuracy*/);
	
	if (f == 1.0F)
	{
	entityarrow.setIsCritical(true);//arrow entity does more damage
	}

	int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);

	if (j > 0)
	{
	entityarrow.setDamage(entityarrow.getDamage() + (double)j * 0.2D + 0.2D);//adds damage to arrow entity
	}

	int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);

	if (k > 0)
	{
	entityarrow.setKnockbackStrength(k);//adds knockback
	}

	if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0)
	{
	entityarrow.setFire(100);//adds fire
	}

	stack.damageItem(1, entityplayer);//damages bow

	if (flag1 || entityplayer.capabilities.isCreativeMode && (itemstack.getItem() == Items.SPECTRAL_ARROW || itemstack.getItem() == Items.TIPPED_ARROW))
	{
	entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;//prevents survival players from picking up the arrow
	}

	worldIn.spawnEntity(entityarrow);
	}

	worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);//plays the shooting sound

	if (!flag1 && !entityplayer.capabilities.isCreativeMode)
	{
	itemstack.shrink(1);//removes the arrow

	if (itemstack.isEmpty())
	{
	entityplayer.inventory.deleteStack(itemstack);
	}
	}

	entityplayer.addStat(StatList.getObjectUseStats(this));//adds stat
	}
	}
	}
	}
	
	//cancel pull
	 public EnumAction getItemUseAction(ItemStack p_77661_1_)
	    {
	        return EnumAction.NONE;
	    }

	public void registerModels() 
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	public int getItemEnchantability()
    {
        return 0;
    }
}
        