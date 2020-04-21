//package com.marctron.transformersmod.blocks.fabricator;
//
//import com.marctron.transformersmod.util.Reference;
//
//import net.minecraft.block.ITileEntityProvider;
//import net.minecraft.client.renderer.texture.ITickable;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.entity.player.InventoryPlayer;
//import net.minecraft.inventory.Container;
//import net.minecraft.inventory.IInventory;
//import net.minecraft.item.ItemStack;
//import net.minecraft.nbt.NBTTagCompound;
//import net.minecraft.tileentity.TileEntityLockableLoot;
//import net.minecraft.util.NonNullList;
//
//public class TileEntityFabricator extends TileEntityLockableLoot implements ITickable
//{
//    public IInventory output = new InventoryFabricatorOutput();
//
//    private Hero selectedHero;
//    public int energy;
//
//    public boolean unlocked;
//
//    @Override
//    public void update()
//    {
//        ItemStack[] itemstacks = selectedHero != null ? selectedHero.getArmorStacks() : new ItemStack[4];
//
//        int energy = FabricatorHelper.getTotalEnergy(this);
//        boolean flag = selectedHero != null && energy >= FabricatorHelper.getMaterialCost(selectedHero);
//
//        for (int slot = 0; slot < 4; ++slot)
//        {
//            output.setInventorySlotContents(slot, flag ? itemstacks[slot] : null);
//        }
//
//       
//    }
//
////    public Hero getHero()
////    {
////        return selectedHero;
////    }
//
//    @Override
//	public int getSizeInventory()
//	{
//		return 6;
//	}
//    
//    @Override
//	public int getInventoryStackLimit() 
//	{
//		return 64;
//	}
//
//    @Override
//    public String getName()
//    {
//        return "gui.suit_fabricator";
//    }
////
////    @Override
////    public void readCustomNBT(NBTTagCompound nbt)
////    {
////        super.readCustomNBT(nbt);
////        energy = nbt.getInteger("MaterialEnergy");
////    }
////
////    @Override
////    public void writeCustomNBT(NBTTagCompound nbt)
////    {
////        super.writeCustomNBT(nbt);
////        nbt.setInteger("MaterialEnergy", energy);
////    }
//
//  
//
//	@Override
//	public boolean isEmpty() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getGuiID() 
//	{
//		return Reference.MOD_ID + ":energon_crate";
//	}
//
//	@Override
//	public void tick() {
//		
//		
//	}
//
//	@Override
//	protected NonNullList<ItemStack> getItems() {
//		
//		return this.getItems();
//	}
//}
