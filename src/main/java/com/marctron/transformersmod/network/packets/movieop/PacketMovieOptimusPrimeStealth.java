package com.marctron.transformersmod.network.packets.movieop;

import java.util.Timer;
import java.util.TimerTask;

import com.marctron.transformersmod.util.handlers.RegistryHandler;
import com.marctron.transformersmod.util.handlers.SoundsHandler;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketMovieOptimusPrimeStealth implements IMessage{

	  public int toSend;
	  public PacketMovieOptimusPrimeStealth(int toSend) {
	    this.setToSend(toSend); 
	  }
	  
	  public PacketMovieOptimusPrimeStealth() {
		    
		  }
	
	

	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		toSend = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		buf.writeInt(toSend);
	}

	public int getToSend() {
		return toSend;
	}

	public void setToSend(int toSend) {
		this.toSend = toSend;
	}

	public static class Handler implements IMessageHandler<PacketMovieOptimusPrimeStealth, IMessage>
	
	{
		@Override public IMessage onMessage(PacketMovieOptimusPrimeStealth message, MessageContext ctx) {
		    // This is the player the packet was sent to the server from
		    EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
		    // The value that was sent
		    int amount = message.toSend;
		    // Execute the action on the main server thread by adding it as a scheduled task

//		    System.out.println("Yuck!");
//		    serverPlayer.inventory.setInventorySlotContents(1, new ItemStack(Items.DIAMOND, 1));
//		    serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK1_BOOTS));
		    
		    if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_HELMET&& serverPlayer.inventory.armorItemInSlot(2) != null && serverPlayer.inventory.armorItemInSlot(2).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_CHESTPLATE&& serverPlayer.inventory.armorItemInSlot(1) != null && serverPlayer.inventory.armorItemInSlot(1).getItem() ==  RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_LEGGINGS&& serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() ==  RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_BOOTS) 
		    { 
//		    	serverPlayer.playSound(SoundsHandler.WFCPRIMEVEHICLE, 1F, 1.0F);
		    	serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID1_BOOTS));
    			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID1_LEGGINGS));
    			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID1_CHESTPLATE));
    			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID1_HELMET));
		    	serverPlayer.eyeHeight=0.6F;
		    	
		    	if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID1_BOOTS) 
		    	{
					
		    		serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_BOOTS));
		    		serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_LEGGINGS));
		    		serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_CHESTPLATE));
		    		serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_HELMET));
		    		serverPlayer.eyeHeight=0.6F;
					//--------------------------------------------
		    		Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						
						@Override
						public void run() {
					//--------------------------------------------
		    		if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_BOOTS) 
		    		{
						
		    			serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID3_BOOTS));
				    	serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID3_LEGGINGS));
				    	serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID3_CHESTPLATE));
				    	serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID3_HELMET));
		    			//--------------------------------------------
			    		Timer timer = new Timer();
						timer.schedule(new TimerTask() {
							
							@Override
							public void run() {
						//--------------------------------------------
		    			if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID3_BOOTS) 
		    			{
							
		    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_BOOTS));
		    				serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_LEGGINGS));
		    				serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_CHESTPLATE));
		    				serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_HELMET));
		    				serverPlayer.eyeHeight=0.6F;
		    				//--------------------------------------------
				    		
								    	}
					}
							
						}, 70);
			    	}
		    	}

					}, 70);
		    	}
		    }
		    
		    
		    
		    
		    //-------Altmode-------
		    
		    if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_HELMET&& serverPlayer.inventory.armorItemInSlot(2) != null && serverPlayer.inventory.armorItemInSlot(2).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_CHESTPLATE&& serverPlayer.inventory.armorItemInSlot(1) != null && serverPlayer.inventory.armorItemInSlot(1).getItem() ==  RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_LEGGINGS&& serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() ==  RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_BOOTS) 
		    { 
//		    	serverPlayer.playSound(SoundsHandler.WFCPRIMEVEHICLE, 1F, 1.0F);
		    	serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID3_BOOTS));
		    	serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID3_LEGGINGS));
		    	serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID3_CHESTPLATE));
		    	serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID3_HELMET));
		    	serverPlayer.eyeHeight=0.6F;
		    	
		    	
		    	if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID3_BOOTS) 
		    	{
					
		    		serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_BOOTS));
		    		serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_LEGGINGS));
		    		serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_CHESTPLATE));
		    		serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_HELMET));
		    		serverPlayer.eyeHeight=0.6F;
					//--------------------------------------------
		    		Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						
						@Override
						public void run() {
					//--------------------------------------------
		    		if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_BOOTS) 
		    		{
						
		    			serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID1_BOOTS));
		    			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID1_LEGGINGS));
		    			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID1_CHESTPLATE));
		    			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID1_HELMET));
		    			//--------------------------------------------
			    		Timer timer = new Timer();
						timer.schedule(new TimerTask() {
							
							@Override
							public void run() {
						//--------------------------------------------
		    			if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID1_BOOTS) 
		    			{
							
		    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_BOOTS));
		    				serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_LEGGINGS));
		    				serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_CHESTPLATE));
		    				serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_HELMET));
		    				serverPlayer.eyeHeight=0.6F;
		    				//--------------------------------------------
				    		
								    	}
					}
							
						}, 70);
			    	}
		    	}

					}, 70);
		    	}
		    }

		    
		    
		    // No response packet
		    return null;
		  }
	}
	
	
	
	
}
