package com.marctron.transformersmod.network.packets;

import com.marctron.transformersmod.entity.EntityLargeRocket;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketShootRocket implements IMessage{

	
	
	
	  public int toSend;
	  public PacketShootRocket(int toSend) {
	    this.setToSend(toSend); 
	  }
	  
	  public PacketShootRocket() {
		    
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
	
	
	
public static class Handler implements IMessageHandler<PacketShootRocket, IMessage>
	
	{
		private long lastPress = 0;
		private long cooldownTime = 1000; // 2000 milliseconds	
		private long time;
	
		@Override public IMessage onMessage(PacketShootRocket message, MessageContext ctx) {
		    // This is the player the packet was sent to the server from
		    EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
		    // The value that was sent
		    int amount = message.toSend;
		    // Execute the action on the main server thread by adding it as a scheduled task
		    
		    Vec3d aim = serverPlayer.getLookVec();
	        EntityLargeRocket fireball = new EntityLargeRocket(serverPlayer.world, serverPlayer, 1, 1, 1);
//
//
//	        if (!ctx.side.isClient())
//	       {
//
//	            fireball.setPosition(serverPlayer.posX + aim.x * 2.5D, serverPlayer.posY + aim.y + 0.4 * 2.5D, serverPlayer.posZ + aim.z * 2.5D);
//	            fireball.accelerationX = aim.x * 0.05;
//	            fireball.accelerationY = aim.y * 0.05;
//	            fireball.accelerationZ = aim.z * 0.05;
//	            serverPlayer.world.spawnEntity(fireball);
//	            fireball.explosionPower = 2;
//
//
//	        }
		    long time = System.currentTimeMillis();	
			if (time > lastPress + cooldownTime) {
//				EntitySheep sheep = new EntitySheep(serverPlayer.world);
//				sheep.setPosition(serverPlayer.posX , serverPlayer.posY, serverPlayer.posZ );
//				serverPlayer.world.spawnEntity(sheep);
				
				fireball.setPosition(serverPlayer.posX + aim.x * 0.5D, serverPlayer.posY + aim.y + 0.4 * 0.5D, serverPlayer.posZ + aim.z * 0.5D);
	            fireball.accelerationX = aim.x * 0.2;
	            fireball.accelerationY = aim.y * 0.2;
	            fireball.accelerationZ = aim.z * 0.2;
	            serverPlayer.world.spawnEntity(fireball);
	            fireball.explosionPower = 4;
				lastPress = time;
			}
		   
//		    serverPlayer.world.createExplosion(serverPlayer,serverPlayer.posX , serverPlayer.posY, serverPlayer.posZ, 2, false);
		    
		    
		    
		    // No response packet
		    return null;
		  }
	}
}
