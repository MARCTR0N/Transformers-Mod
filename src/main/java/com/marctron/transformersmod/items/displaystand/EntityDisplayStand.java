package com.marctron.transformersmod.items.displaystand;

import com.marctron.transformersmod.Main;
import com.marctron.transformersmod.util.Reference;

import net.minecraft.entity.IMerchant;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;

public class EntityDisplayStand extends EntityArmorStand{

	
	private final InventoryBasic DisplayStandInventory;
	
	public EntityDisplayStand(World worldIn) {		
		super(worldIn);
		this.DisplayStandInventory = new InventoryBasic("Items", false, 4);
	}
	
	 public EntityDisplayStand(World worldIn, double posX, double posY, double posZ)
	    {
	        this(worldIn);
	        this.setPosition(posX, posY, posZ);
	    }
	
	@Override
	public EnumActionResult applyPlayerInteraction(EntityPlayer player, Vec3d vec, EnumHand hand)
    {
//		player.
		System.out.println("right click");
		return EnumActionResult.PASS;
    }
	
	public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);


        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.DisplayStandInventory.getSizeInventory(); ++i)
        {
            ItemStack itemstack = this.DisplayStandInventory.getStackInSlot(i);

            if (!itemstack.isEmpty())
            {
                nbttaglist.appendTag(itemstack.writeToNBT(new NBTTagCompound()));
            }
        }

        compound.setTag("Inventory", nbttaglist);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);

        NBTTagList nbttaglist = compound.getTagList("Inventory", 10);

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            ItemStack itemstack = new ItemStack(nbttaglist.getCompoundTagAt(i));

            if (!itemstack.isEmpty())
            {
                this.DisplayStandInventory.addItem(itemstack);
            }
        }

    }
    
    public InventoryBasic getDisplayStandInventory()
    {
        return this.DisplayStandInventory;
    }

    
}
