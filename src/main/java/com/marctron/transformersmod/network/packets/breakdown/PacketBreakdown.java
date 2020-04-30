package com.marctron.transformersmod.network.packets.breakdown;

import java.util.Timer;
import java.util.TimerTask;

import com.marctron.transformersmod.util.handlers.RegistryHandler;
import com.marctron.transformersmod.util.handlers.SoundsHandler;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketBreakdown implements IMessage{

	  public int toSend;
	  public PacketBreakdown(int toSend) {
	    this.setToSend(toSend); 
	  }
	  
	  public PacketBreakdown() {
		    
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

	public static class Handler implements IMessageHandler<PacketBreakdown, IMessage>
	
	{
		@Override public IMessage onMessage(PacketBreakdown message, MessageContext ctx) {
		    // This is the player the packet was sent to the server from
		    EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
		    // The value that was sent
		    int amount = message.toSend;
		    // Execute the action on the main server thread by adding it as a scheduled task

//		    System.out.println("Yuck!");
//		    serverPlayer.inventory.setInventorySlotContents(1, new ItemStack(Items.DIAMOND, 1));
//		    serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.MOVIE_OPTIMUS_PRIME_BACK1_BOOTS));
		    
		    if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.BREAKDOWN_HELMET&& serverPlayer.inventory.armorItemInSlot(2) != null && serverPlayer.inventory.armorItemInSlot(2).getItem() ==RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE&& serverPlayer.inventory.armorItemInSlot(1) != null && serverPlayer.inventory.armorItemInSlot(1).getItem() ==  RegistryHandler.ModItems.BREAKDOWN_LEGGINGS&& serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() ==  RegistryHandler.ModItems.BREAKDOWN_BOOTS) 
		    { 
//		    	serverPlayer.world.playSound(serverPlayer, serverPlayer.posX, serverPlayer.posY, serverPlayer.posZ, SoundsHandler.TFPTRANSFORM, SoundCategory.PLAYERS, 1, 1);
//		    	serverPlayer.playSound(SoundsHandler.WFCPRIMEVEHICLE, 1F, 1.0F);
		    	serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID1));
    			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID1));
    			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID1));
    			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID1));
		    	serverPlayer.eyeHeight=0.6F;
		    	
		    	if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.BREAKDOWN_HELMET_MID1) 
		    	{
					
		    		serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID2));
	    			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID2));
	    			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID2));
	    			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID2));
		    		serverPlayer.eyeHeight=0.6F;
					//--------------------------------------------
		    		Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						
						@Override
						public void run() {
					//--------------------------------------------
		    		if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.BREAKDOWN_HELMET_MID2) 
		    		{
						
		    			serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID3));
		    			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID3));
		    			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID3));
		    			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID3));
		    			//--------------------------------------------
			    		Timer timer = new Timer();
						timer.schedule(new TimerTask() {
							
							@Override
							public void run() {
						//--------------------------------------------
		    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID3) 
		    			{
							
		    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID4));
		        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID4));
		        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID4));
		        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID4));
		    				serverPlayer.eyeHeight=0.6F;
		    				//--------------------------------------------
				    		
		    				Timer timer = new Timer();
							timer.schedule(new TimerTask() {
								
								@Override
								public void run() {
							//--------------------------------------------
			    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID4) 
			    			{
								
			    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID5));
			        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID5));
			        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID5));
			        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID5));
			    				serverPlayer.eyeHeight=0.6F;
			    				//--------------------------------------------
			    				
			    				Timer timer = new Timer();
								timer.schedule(new TimerTask() {
									
									@Override
									public void run() {
								//--------------------------------------------
				    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID5) 
				    			{
									
				    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID6));
				        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID6));
				        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID6));
				        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID6));
				    				serverPlayer.eyeHeight=0.6F;
				    				//--------------------------------------------
				    				
				    				Timer timer = new Timer();
									timer.schedule(new TimerTask() {
										
										@Override
										public void run() {
									//--------------------------------------------
					    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID6) 
					    			{
										
					    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID7));
					        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID7));
					        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID7));
					        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID7));
					    				serverPlayer.eyeHeight=0.6F;
					    				//--------------------------------------------
					    				
					    				Timer timer = new Timer();
										timer.schedule(new TimerTask() {
											
											@Override
											public void run() {
										//--------------------------------------------
						    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID7) 
						    			{
											
						    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID8));
						        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID8));
						        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID8));
						        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID8));
						    				serverPlayer.eyeHeight=0.6F;
						    				//--------------------------------------------
						    				Timer timer = new Timer();
											timer.schedule(new TimerTask() {
												
												@Override
												public void run() {
											//--------------------------------------------
							    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID8) 
							    			{
												
							    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID9));
							        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID9));
							        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID9));
							        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID9));
							    				serverPlayer.eyeHeight=0.6F;
							    				//--------------------------------------------
							    				Timer timer = new Timer();
												timer.schedule(new TimerTask() {
													
													@Override
													public void run() {
												//--------------------------------------------
								    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID9) 
								    			{
													
								    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID10));
								        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID10));
								        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID10));
								        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID10));
								    				serverPlayer.eyeHeight=0.6F;
								    				//--------------------------------------------
								    				Timer timer = new Timer();
													timer.schedule(new TimerTask() {
														
														@Override
														public void run() {
													//--------------------------------------------
									    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID10) 
									    			{
														
									    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID11));
									        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID11));
									        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID11));
									        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID11));
									    				serverPlayer.eyeHeight=0.6F;
									    				//--------------------------------------------
									    				Timer timer = new Timer();
														timer.schedule(new TimerTask() {
															
															@Override
															public void run() {
														//--------------------------------------------
										    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID11) 
										    			{
															
										    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID12));
										        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID12));
										        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID12));
										        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID12));
										    				serverPlayer.eyeHeight=0.6F;
										    				//--------------------------------------------
										    				Timer timer = new Timer();
															timer.schedule(new TimerTask() {
																
																@Override
																public void run() {
															//--------------------------------------------
											    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID12) 
											    			{
																
											    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID13));
											        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID13));
											        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID13));
											        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID13));
											    				serverPlayer.eyeHeight=0.6F;
											    				//--------------------------------------------
											    				Timer timer = new Timer();
																timer.schedule(new TimerTask() {
																	
																	@Override
																	public void run() {
																//--------------------------------------------
												    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID13) 
												    			{
																	
												    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID14));
												        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID14));
												        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID14));
												        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID14));
												    				serverPlayer.eyeHeight=0.6F;
												    				//--------------------------------------------
												    				Timer timer = new Timer();
																	timer.schedule(new TimerTask() {
																		
																		@Override
																		public void run() {
																	//--------------------------------------------
													    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID14) 
													    			{
																		
													    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID15));
													        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID15));
													        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID15));
													        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID15));
													    				serverPlayer.eyeHeight=0.6F;
													    				//--------------------------------------------
													    				Timer timer = new Timer();
																		timer.schedule(new TimerTask() {
																			
																			@Override
																			public void run() {
																				//--------------------------------------------
																    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID15) 
																    			{
																					
																    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID16));
																        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID16));
																        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID16));
																        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID16));
																    				serverPlayer.eyeHeight=0.6F;
																    				//--------------------------------------------
																    				Timer timer = new Timer();
																					timer.schedule(new TimerTask() {
																						
																						@Override
																						public void run() {
																							//--------------------------------------------
																			    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID16) 
																			    			{
																								
																			    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID17));
																			        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID17));
																			        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID17));
																			        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID17));
																			    				serverPlayer.eyeHeight=0.6F;
																			    				//--------------------------------------------
																			    				Timer timer = new Timer();
																								timer.schedule(new TimerTask() {
																									
																									@Override
																									public void run() {
																										//--------------------------------------------
																						    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID17) 
																						    			{
																											
																						    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID18));
																						        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID18));
																						        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID18));
																						        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID18));
																						    				serverPlayer.eyeHeight=0.6F;
																						    				//--------------------------------------------
																						    				Timer timer = new Timer();
																											timer.schedule(new TimerTask() {
																												
																												@Override
																												public void run() {
																													//--------------------------------------------
																									    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID18) 
																									    			{
																														
																									    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID19));
																									        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID19));
																									        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID19));
																									        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID19));
																									    				serverPlayer.eyeHeight=0.6F;
																									    				//--------------------------------------------
																									    				Timer timer = new Timer();
																														timer.schedule(new TimerTask() {
																															
																															@Override
																															public void run() {
																																//--------------------------------------------
																												    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID19) 
																												    			{
																																	
																												    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID20));
																												        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID20));
																												        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID20));
																												        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID20));
																												    				serverPlayer.eyeHeight=0.6F;
																												    				//--------------------------------------------
																												    				Timer timer = new Timer();
																																	timer.schedule(new TimerTask() {
																																		
																																		@Override
																																		public void run() {
																																			//--------------------------------------------
																															    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID20) 
																															    			{
																																				
																															    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID21));
																															        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID21));
																															        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID21));
																															        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID21));
																															    				serverPlayer.eyeHeight=0.6F;
																															    				//--------------------------------------------
																															    				Timer timer = new Timer();
																																				timer.schedule(new TimerTask() {
																																					
																																					@Override
																																					public void run() {
																																						//--------------------------------------------
																																		    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID21) 
																																		    			{
																																							
																																		    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID22));
																																		        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID22));
																																		        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID15));
																																		        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID22));
																																		    				serverPlayer.eyeHeight=0.6F;
																																		    				//--------------------------------------------
																																		    				Timer timer = new Timer();
																																							timer.schedule(new TimerTask() {
																																								
																																								@Override
																																								public void run() {
																																									//--------------------------------------------
																																					    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID22) 
																																					    			{
																																										
																																					    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID23));
																																					        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID23));
																																					        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID23));
																																					        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID23));
																																					    				serverPlayer.eyeHeight=0.6F;
																																					    				//--------------------------------------------
																																					    				Timer timer = new Timer();
																																										timer.schedule(new TimerTask() {
																																											
																																											@Override
																																											public void run() {
																																												//--------------------------------------------
																																								    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID23) 
																																								    			{
																																													
																																								    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID24));
																																								        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID24));
																																								        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID24));
																																								        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID24));
																																								    				serverPlayer.eyeHeight=0.6F;
																																								    				//--------------------------------------------
																																								    				Timer timer = new Timer();
																																													timer.schedule(new TimerTask() {
																																														
																																														@Override
																																														public void run() {
																																															//--------------------------------------------
																																											    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID24) 
																																											    			{
																																																
																																											    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID25));
																																											        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID25));
																																											        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID25));
																																											        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID25));
																																											    				serverPlayer.eyeHeight=0.6F;
																																											    				//--------------------------------------------
																																											    				Timer timer = new Timer();
																																																timer.schedule(new TimerTask() {
																																																	
																																																	@Override
																																																	public void run() {
																		//--------------------------------------------
														    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID25) 
														    			{
																			
														    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_ALTMODE));
														        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_ALTMODE));
														        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_ALTMODE));
														        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_ALTMODE));
														    				serverPlayer.eyeHeight=0.6F;
														    				//--------------------------------------------
					    		
											}}
												}, 38);	
											}}
												}, 38);	
											}}
												}, 38);						
											}}
												}, 38);
											}}
												}, 38);
											}}
												}, 38);
											}}		
												}, 38);
											}}
												}, 38);
											}}
												}, 38);
											}}		
												}, 38);
											}}
												}, 38);
						    				}}																																		
												}, 38);						
									    	}}
												}, 38);
									    	}}
												}, 38);
									    	}}
												}, 38);
					    					}}		
												}, 38);
											}}
												}, 38);
											}}
												}, 38);	
							    			}}
												}, 38);
											}}
												}, 38);
											}}
												}, 38);
											}}
												}, 38);	
						    				}}
												}, 38);
			    							}}
												}, 38);
		    								 }
		    }
		    
		    
		    
		    
		    //-------Altmode-------
		    
		    if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.BREAKDOWN_HELMET_ALTMODE&& serverPlayer.inventory.armorItemInSlot(2) != null && serverPlayer.inventory.armorItemInSlot(2).getItem() ==RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_ALTMODE&& serverPlayer.inventory.armorItemInSlot(1) != null && serverPlayer.inventory.armorItemInSlot(1).getItem() ==  RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_ALTMODE&& serverPlayer.inventory.armorItemInSlot(0) != null && serverPlayer.inventory.armorItemInSlot(0).getItem() ==  RegistryHandler.ModItems.BREAKDOWN_BOOTS_ALTMODE) 
		    { 
//		    	serverPlayer.playSound(SoundsHandler.WFCPRIMEVEHICLE, 1F, 1.0F);
		    	serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID25));
    			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID25));
    			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID25));
    			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID25));
		    	serverPlayer.eyeHeight=0.6F;
		    	
		    	if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.BREAKDOWN_HELMET_MID25) 
		    	{
					
		    		serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID24));
	    			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID24));
	    			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID24));
	    			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID24));
		    		serverPlayer.eyeHeight=0.6F;
					//--------------------------------------------
		    		Timer timer = new Timer();
					timer.schedule(new TimerTask() {
						
						@Override
						public void run() {
							//--------------------------------------------
				    		if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.BREAKDOWN_HELMET_MID24) 
				    		{
								
				    			serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID23));
				    			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID23));
				    			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID23));
				    			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID23));
				    			//--------------------------------------------
					    		Timer timer = new Timer();
								timer.schedule(new TimerTask() {
									
									@Override
									public void run() {
										//--------------------------------------------
							    		if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.BREAKDOWN_HELMET_MID23) 
							    		{
											
							    			serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID22));
							    			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID22));
							    			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID22));
							    			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID22));
							    			//--------------------------------------------
								    		Timer timer = new Timer();
											timer.schedule(new TimerTask() {
												
												@Override
												public void run() {
													//--------------------------------------------
										    		if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.BREAKDOWN_HELMET_MID22) 
										    		{
														
										    			serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID21));
										    			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID21));
										    			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID21));
										    			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID21));
										    			//--------------------------------------------
											    		Timer timer = new Timer();
														timer.schedule(new TimerTask() {
															
															@Override
															public void run() {
																//--------------------------------------------
													    		if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.BREAKDOWN_HELMET_MID21) 
													    		{
																	
													    			serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID20));
													    			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID20));
													    			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID20));
													    			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID20));
													    			//--------------------------------------------
														    		Timer timer = new Timer();
																	timer.schedule(new TimerTask() {
																		
																		@Override
																		public void run() {
																			//--------------------------------------------
																    		if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.BREAKDOWN_HELMET_MID20) 
																    		{
																				
																    			serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID19));
																    			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID19));
																    			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID19));
																    			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID19));
																    			//--------------------------------------------
																	    		Timer timer = new Timer();
																				timer.schedule(new TimerTask() {
																					
																					@Override
																					public void run() {
																						//--------------------------------------------
																			    		if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.BREAKDOWN_HELMET_MID19) 
																			    		{
																							
																			    			serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID18));
																			    			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID18));
																			    			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID18));
																			    			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID18));
																			    			//--------------------------------------------
																				    		Timer timer = new Timer();
																							timer.schedule(new TimerTask() {
																								
																								@Override
																								public void run() {
																									//--------------------------------------------
																						    		if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.BREAKDOWN_HELMET_MID18) 
																						    		{
																										
																						    			serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID17));
																						    			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID17));
																						    			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID17));
																						    			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID17));
																						    			//--------------------------------------------
																							    		Timer timer = new Timer();
																										timer.schedule(new TimerTask() {
																											
																											@Override
																											public void run() {
																												//--------------------------------------------
																									    		if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.BREAKDOWN_HELMET_MID17) 
																									    		{
																													
																									    			serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID16));
																									    			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID16));
																									    			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID16));
																									    			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID16));
																									    			//--------------------------------------------
																										    		Timer timer = new Timer();
																													timer.schedule(new TimerTask() {
																														
																														@Override
																														public void run() {
																															//--------------------------------------------
																												    		if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.BREAKDOWN_HELMET_MID16) 
																												    		{
																																
																												    			serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID15));
																												    			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID15));
																												    			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID15));
																												    			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID15));
																												    			//--------------------------------------------
																													    		Timer timer = new Timer();
																																timer.schedule(new TimerTask() {
																																	
																																	@Override
																																	public void run() {
																																		//--------------------------------------------
																															    		if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.BREAKDOWN_HELMET_MID15) 
																															    		{
																																			
																															    			serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID14));
																															    			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID14));
																															    			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID14));
																															    			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID14));
																															    			//--------------------------------------------
																																    		Timer timer = new Timer();
																																			timer.schedule(new TimerTask() {
																																				
																																				@Override
																																				public void run() {
					//--------------------------------------------
		    		if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() ==RegistryHandler.ModItems.BREAKDOWN_HELMET_MID14) 
		    		{
						
		    			serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID13));
		    			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID13));
		    			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID13));
		    			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID13));
		    			//--------------------------------------------
			    		Timer timer = new Timer();
						timer.schedule(new TimerTask() {
							
							@Override
							public void run() {
						//--------------------------------------------
		    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID13) 
		    			{
							
		    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID12));
		        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID12));
		        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID12));
		        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID12));
		    				serverPlayer.eyeHeight=0.6F;
		    				//--------------------------------------------
				    		
		    				Timer timer = new Timer();
							timer.schedule(new TimerTask() {
								
								@Override
								public void run() {
							//--------------------------------------------
			    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID12) 
			    			{
								
			    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID11));
			        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID11));
			        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID11));
			        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID11));
			    				serverPlayer.eyeHeight=0.6F;
			    				//--------------------------------------------
			    				
			    				Timer timer = new Timer();
								timer.schedule(new TimerTask() {
									
									@Override
									public void run() {
								//--------------------------------------------
				    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID11) 
				    			{
									
				    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID10));
				        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID10));
				        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID10));
				        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID10));
				    				serverPlayer.eyeHeight=0.6F;
				    				//--------------------------------------------
				    				
				    				Timer timer = new Timer();
									timer.schedule(new TimerTask() {
										
										@Override
										public void run() {
									//--------------------------------------------
					    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID10) 
					    			{
										
					    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID9));
					        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID9));
					        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID9));
					        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID9));
					    				serverPlayer.eyeHeight=0.6F;
					    				//--------------------------------------------
					    				
					    				Timer timer = new Timer();
										timer.schedule(new TimerTask() {
											
											@Override
											public void run() {
										//--------------------------------------------
						    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID9) 
						    			{
											
						    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID8));
						        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID8));
						        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID8));
						        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID8));
						    				serverPlayer.eyeHeight=0.6F;
						    				//--------------------------------------------
						    				Timer timer = new Timer();
											timer.schedule(new TimerTask() {
												
												@Override
												public void run() {
											//--------------------------------------------
							    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID8) 
							    			{
												
							    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID7));
							        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID7));
							        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID7));
							        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID7));
							    				serverPlayer.eyeHeight=0.6F;
							    				//--------------------------------------------
							    				Timer timer = new Timer();
												timer.schedule(new TimerTask() {
													
													@Override
													public void run() {
												//--------------------------------------------
								    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID7) 
								    			{
													
								    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID6));
								        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID6));
								        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID6));
								        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID6));
								    				serverPlayer.eyeHeight=0.6F;
								    				//--------------------------------------------
								    				Timer timer = new Timer();
													timer.schedule(new TimerTask() {
														
														@Override
														public void run() {
													//--------------------------------------------
									    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID6) 
									    			{
														
									    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID5));
									        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID5));
									        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID5));
									        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID5));
									    				serverPlayer.eyeHeight=0.6F;
									    				//--------------------------------------------
									    				Timer timer = new Timer();
														timer.schedule(new TimerTask() {
															
															@Override
															public void run() {
														//--------------------------------------------
										    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID5) 
										    			{
															
										    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID4));
										        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID4));
										        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID4));
										        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID4));
										    				serverPlayer.eyeHeight=0.6F;
										    				//--------------------------------------------
										    				Timer timer = new Timer();
															timer.schedule(new TimerTask() {
																
																@Override
																public void run() {
															//--------------------------------------------
											    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID4) 
											    			{
																
											    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID3));
											        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID3));
											        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID3));
											        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID3));
											    				serverPlayer.eyeHeight=0.6F;
											    				//--------------------------------------------
											    				Timer timer = new Timer();
																timer.schedule(new TimerTask() {
																	
																	@Override
																	public void run() {
																//--------------------------------------------
												    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID3) 
												    			{
																	
												    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID2));
												        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID2));
												        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID2));
												        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID2));
												    				serverPlayer.eyeHeight=0.6F;
												    				//--------------------------------------------
												    				Timer timer = new Timer();
																	timer.schedule(new TimerTask() {
																		
																		@Override
																		public void run() {
																	//--------------------------------------------
													    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID2) 
													    			{
																		
													    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS_MID1));
													        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS_MID1));
													        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE_MID1));
													        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET_MID1));
													    				serverPlayer.eyeHeight=0.6F;
													    				//--------------------------------------------
													    				Timer timer = new Timer();
																		timer.schedule(new TimerTask() {
																			
																			@Override
																			public void run() {
																		//--------------------------------------------
														    			if (serverPlayer.inventory.armorItemInSlot(3) != null && serverPlayer.inventory.armorItemInSlot(3).getItem() == RegistryHandler.ModItems.BREAKDOWN_HELMET_MID1) 
														    			{
																			
														    				serverPlayer.inventory.armorInventory.set(0, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_BOOTS));
														        			serverPlayer.inventory.armorInventory.set(1, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_LEGGINGS));
														        			serverPlayer.inventory.armorInventory.set(2, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_CHESTPLATE));
														        			serverPlayer.inventory.armorInventory.set(3, new ItemStack(RegistryHandler.ModItems.BREAKDOWN_HELMET));
														    				serverPlayer.eyeHeight=0.6F;
														    				//--------------------------------------------
					    		
											}}
												}, 38);	
											}}
												}, 38);	
											}}
												}, 38);						
											}}
												}, 38);
											}}
												}, 38);
											}}
												}, 38);
								    		}}		
												}, 38);
											}}
												}, 38);
											}}
												}, 38);	
											}}
												}, 38);
											}}
												}, 38);
						    				}}
												}, 38);						
									    	}}
												}, 38);
									    	}}
												}, 38);
									    	}}
												}, 38);
					    					}}		
												}, 38);
											}}
												}, 38);
											}}
												}, 38);	
							    			}}
												}, 38);
											}}
												}, 38);
											}}
												}, 38);
											}}
												}, 38);	
						    				}}
												}, 38);
			    							}}
												}, 38);
		    								 }
		    }

		    
		    
		    // No response packet
		    return null;
		  }
	}
	
	
	
	
}
