package com.marctron.transformersmod.network.packets;

import com.marctron.transformersmod.entity.EntityLargeRocket;
//import com.marctron.transformersmod.sounds.DrivingSound;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketDrivingSound implements IMessage{

	
	
	
	  public int toSend;
	  public PacketDrivingSound(int toSend) {
	    this.setToSend(toSend); 
	  }
	  
	  public PacketDrivingSound() {
		    
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
	
	
	
public static class Handler implements IMessageHandler<PacketDrivingSound, IMessage>
	
	{
		private long lastPress = 0;
		private long cooldownTime = 1000; // 2000 milliseconds	
		private long time;
	
		@Override public IMessage onMessage(PacketDrivingSound message, MessageContext ctx) {
		    // This is the player the packet was sent to the server from
		    EntityPlayer serverPlayer = ctx.getServerHandler().player;
		    // The value that was sent
		    int amount = message.toSend;
		    // Execute the action on the main server thread by adding it as a scheduled task
		    
		    serverPlayer.noClip = true;
//		    serverPlayer.posY = serverPlayer.prevPosY;
		    System.out.println("noClip");
//		    Minecraft.getMinecraft().getSoundHandler().playSound(new DrivingSound(serverPlayer));
		   
//		    serverPlayer.world.createExplosion(serverPlayer,serverPlayer.posX , serverPlayer.posY, serverPlayer.posZ, 2, false);
		    
		    
		    
		    // No response packet
		    return null;
		  }
	}
}
