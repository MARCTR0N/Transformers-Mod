package com.marctron.transformersmod.network.packets.movieop;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.marctron.transformersmod.entity.Player;
import com.marctron.transformersmod.network.packets.tf.MessageUpdateArmor;
import com.marctron.transformersmod.proxy.ClientProxy;
import com.marctron.transformersmod.util.handlers.RegistryHandler;
import com.marctron.transformersmod.util.handlers.SoundsHandler;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PacketMovieOptimusPrime implements IMessage{

	  public int toSend;
	  public PacketMovieOptimusPrime(int toSend) {
	    this.setToSend(toSend); 
	  }
	  
	  public PacketMovieOptimusPrime() {
		    
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

	public static class Handler implements IMessageHandler<PacketMovieOptimusPrime, IMessage>
	
	{
		@Override public IMessage onMessage(PacketMovieOptimusPrime message, MessageContext ctx) {
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
		    	serverPlayer.inventory.armorInventory.set(1, new ItemStack(Items.AIR));
		    	serverPlayer.inventory.armorInventory.set(2, new ItemStack(Items.AIR));
		    	serverPlayer.inventory.armorInventory.set(3, new ItemStack(Items.AIR));
		    	
		    	
		    	if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID1_BOOTS) 
		    	{
					
		    		serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_BOOTS));
		    		serverPlayer.inventory.armorInventory.set(1, new ItemStack(Items.AIR));
		    		serverPlayer.inventory.armorInventory.set(2, new ItemStack(Items.AIR));
		    		serverPlayer.inventory.armorInventory.set(3, new ItemStack(Items.AIR));
					//--------------------------------------------
		    		Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						
						@Override
						public void run() {
					//--------------------------------------------
		    		if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_BOOTS) 
		    		{
						
		    			serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID3_BOOTS));
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
		    //---------    				
		    //---------				
		    //---------
		    if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_HELMET&& serverPlayer.inventory.armorItemInSlot(2) != null && serverPlayer.inventory.armorItemInSlot(2).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_CHESTPLATE&& serverPlayer.inventory.armorItemInSlot(1) != null && serverPlayer.inventory.armorItemInSlot(1).getItem() ==  RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_LEGGINGS&& serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() ==  RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_BOOTS) 
		    { 
		    	serverPlayer.playSound(SoundsHandler.WFCPRIMEVEHICLE, 1F, 1.0F);
		    	serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK1_BOOTS));
		    	serverPlayer.inventory.armorInventory.set(1, new ItemStack(Items.AIR));
		    	serverPlayer.inventory.armorInventory.set(2, new ItemStack(Items.AIR));
		    	serverPlayer.inventory.armorInventory.set(3, new ItemStack(Items.AIR));
		    	
		    	
		    	if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK1_BOOTS) 
		    	{
					
		    		serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK2_BOOTS));
		    		serverPlayer.inventory.armorInventory.set(1, new ItemStack(Items.AIR));
		    		serverPlayer.inventory.armorInventory.set(2, new ItemStack(Items.AIR));
		    		serverPlayer.inventory.armorInventory.set(3, new ItemStack(Items.AIR));
					//--------------------------------------------
		    		Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						
						@Override
						public void run() {
					//--------------------------------------------
		    		if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK2_BOOTS) 
		    		{
						
		    			serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK3_BOOTS));
		    			//--------------------------------------------
			    		Timer timer = new Timer();
						timer.schedule(new TimerTask() {
							
							@Override
							public void run() {
						//--------------------------------------------
		    			if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK3_BOOTS) 
		    			{
							
		    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK4_BOOTS));
		    				//--------------------------------------------
				    		Timer timer = new Timer();
							timer.schedule(new TimerTask() {
								
								@Override
								public void run() {
							//--------------------------------------------	
		    				if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK4_BOOTS) 
			    			{
								
			    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK5_BOOTS));
			    				//--------------------------------------------
					    		Timer timer = new Timer();
								timer.schedule(new TimerTask() {
									
									@Override
									public void run() {
								//--------------------------------------------	
			    				if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK5_BOOTS) 
				    			{
									
				    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK6_BOOTS));
				    				//--------------------------------------------
						    		Timer timer = new Timer();
									timer.schedule(new TimerTask() {
										
										@Override
										public void run() {
									//--------------------------------------------
				    				if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK6_BOOTS) 
					    			{
										
					    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK7_BOOTS));
					    				//--------------------------------------------
							    		Timer timer = new Timer();
										timer.schedule(new TimerTask() {
											
											@Override
											public void run() {
										//--------------------------------------------
					    				if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK7_BOOTS) 
						    			{
											
						    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK8_BOOTS));
						    				//--------------------------------------------
								    		Timer timer = new Timer();
											timer.schedule(new TimerTask() {
												
												@Override
												public void run() {
											//--------------------------------------------
						    				if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK8_BOOTS) 
							    			{
												
							    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK9_BOOTS));
							    				//--------------------------------------------
									    		Timer timer = new Timer();
												timer.schedule(new TimerTask() {
													
													@Override
													public void run() {
												//--------------------------------------------
							    				if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK9_BOOTS) 
								    			{
													
								    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BOOTS));
								    				serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_LEGGINGS));
								    				serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_CHESTPLATE));
								    				serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_HELMET));
	
												}
											}
												}, 70);
									    	}
										}
							    			}, 70);
										    	}
									}
												}, 70);
									    	}
								}
											}, 70);
								    	}
							}
						    			}, 70);
									    	}
						}
											}, 70);
								    	}
					}
							
						}, 70);
			    	}
		    	}

					}, 70);
		    	}
		    }
		    
		    
		    //-----
		    	    	}
							}
									
								}, 70);
					    	}
				    	}

							}, 70);
				    	}
				    }
		    
		    
		    
		    //-------Altmode-------
		    if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_HELMET&& serverPlayer.inventory.armorItemInSlot(2) != null && serverPlayer.inventory.armorItemInSlot(2).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_CHESTPLATE&& serverPlayer.inventory.armorItemInSlot(1) != null && serverPlayer.inventory.armorItemInSlot(1).getItem() ==  RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_LEGGINGS&& serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() ==  RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BOOTS) 
		    { 
		    	serverPlayer.playSound(SoundsHandler.WFCPRIMEROBOT, 1F, 1.0F);
		    	serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID1_BOOTS));
		    	serverPlayer.inventory.armorInventory.set(1, new ItemStack(Items.AIR));
		    	serverPlayer.inventory.armorInventory.set(2, new ItemStack(Items.AIR));
		    	serverPlayer.inventory.armorInventory.set(3, new ItemStack(Items.AIR));
		    	
		    	
		    	if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID1_BOOTS) 
		    	{
					
		    		serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID2_BOOTS));
		    		serverPlayer.inventory.armorInventory.set(1, new ItemStack(Items.AIR));
		    		serverPlayer.inventory.armorInventory.set(2, new ItemStack(Items.AIR));
		    		serverPlayer.inventory.armorInventory.set(3, new ItemStack(Items.AIR));
					//--------------------------------------------
		    		Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						
						@Override
						public void run() {
					//--------------------------------------------
		    		if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID2_BOOTS) 
		    		{
						
		    			serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID3_BOOTS));
		    			//--------------------------------------------
			    		Timer timer = new Timer();
						timer.schedule(new TimerTask() {
							
							@Override
							public void run() {
						//--------------------------------------------
		    			if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID3_BOOTS) 
		    			{
							
		    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID4_BOOTS));
		    				//--------------------------------------------
				    		Timer timer = new Timer();
							timer.schedule(new TimerTask() {
								
								@Override
								public void run() {
							//--------------------------------------------	
		    				if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID4_BOOTS) 
			    			{
								
			    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID5_BOOTS));
			    				//--------------------------------------------
					    		Timer timer = new Timer();
								timer.schedule(new TimerTask() {
									
									@Override
									public void run() {
								//--------------------------------------------	
			    				if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID5_BOOTS) 
				    			{
									
				    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID6_BOOTS));
				    				//--------------------------------------------
						    		Timer timer = new Timer();
									timer.schedule(new TimerTask() {
										
										@Override
										public void run() {
									//--------------------------------------------
				    				if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID6_BOOTS) 
					    			{
										
					    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID7_BOOTS));
					    				//--------------------------------------------
							    		Timer timer = new Timer();
										timer.schedule(new TimerTask() {
											
											@Override
											public void run() {
										//--------------------------------------------
					    				if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID7_BOOTS) 
						    			{
											
						    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID8_BOOTS));
						    				//--------------------------------------------
								    		Timer timer = new Timer();
											timer.schedule(new TimerTask() {
												
												@Override
												public void run() {
											//--------------------------------------------
						    				if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID8_BOOTS) 
							    			{
												
							    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID9_BOOTS));
							    				//--------------------------------------------
									    		Timer timer = new Timer();
												timer.schedule(new TimerTask() {
													
													@Override
													public void run() {
												//--------------------------------------------
							    				if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() == RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_MID9_BOOTS) 
								    			{
													
								    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_BOOTS));
								    				serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_LEGGINGS));
								    				serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_CHESTPLATE));
								    				serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_HELMET));
								    				
								    				serverPlayer.setEntityBoundingBox(new AxisAlignedBB(serverPlayer.getEntityBoundingBox().minX, serverPlayer.getEntityBoundingBox().minY, serverPlayer.getEntityBoundingBox().minZ, serverPlayer.getEntityBoundingBox().minX + 0.6F, serverPlayer.getEntityBoundingBox().minY + 0.7F, serverPlayer.getEntityBoundingBox().minZ + 0.6F));

								    				
								    				
								    				//---------
								    				
								    				if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_HELMET&& serverPlayer.inventory.armorItemInSlot(2) != null && serverPlayer.inventory.armorItemInSlot(2).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_CHESTPLATE&& serverPlayer.inventory.armorItemInSlot(1) != null && serverPlayer.inventory.armorItemInSlot(1).getItem() ==  RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_LEGGINGS&& serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() ==  RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_BOOTS) 
								    			    { 
//								    			    	serverPlayer.playSound(SoundsHandler.WFCPRIMEVEHICLE, 1F, 1.0F);
								    			    	serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID3_BOOTS));
								    			    	serverPlayer.inventory.armorInventory.set(1, new ItemStack(Items.AIR));
								    			    	serverPlayer.inventory.armorInventory.set(2, new ItemStack(Items.AIR));
								    			    	serverPlayer.inventory.armorInventory.set(3, new ItemStack(Items.AIR));
								    			    	
								    			    	
								    			    	if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID3_BOOTS) 
								    			    	{
								    						
								    			    		serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_BOOTS));
								    			    		serverPlayer.inventory.armorInventory.set(1, new ItemStack(Items.AIR));
								    			    		serverPlayer.inventory.armorInventory.set(2, new ItemStack(Items.AIR));
								    			    		serverPlayer.inventory.armorInventory.set(3, new ItemStack(Items.AIR));
								    						//--------------------------------------------
								    			    		Timer timer = new Timer();
								    						timer.schedule(new TimerTask() {
								    							
								    							@Override
								    							public void run() {
								    						//--------------------------------------------
								    			    		if (serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() ==RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID2_BOOTS) 
								    			    		{
								    							
								    			    			serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_ALTMODE_WEAPONIZED_MID1_BOOTS));
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
								    			    				//--------------------------------------------
								    					    	}
								    								}
								    										
								    									}, 70);
								    						    	}
								    					    	}

								    								}, 70);
								    					    	}
								    					    }
								    				
								    				//-------
	
												}
											}
												}, 70);
									    	}
										}
							    			}, 70);
										    	}
									}
												}, 70);
									    	}
								}
											}, 70);
								    	}
							}
						    			}, 70);
									    	}
						}
											}, 70);
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
