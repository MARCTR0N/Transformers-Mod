package com.marctron.transformersmod.network.packets;

import com.marctron.transformersmod.Main;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class MessageEntityPosVelUpdate extends MessageBase<MessageEntityPosVelUpdate> {
	
	private double x, y, z, dx, dy, dz;
	
	private int id, dimension;
	
	public MessageEntityPosVelUpdate() {
		// TODO Auto-generated constructor stub
	}
	
	public MessageEntityPosVelUpdate(Entity entity) {
		this.x = entity.posX;
		this.y = entity.posY;
		this.z = entity.posZ;
		this.dx = entity.motionX;
		this.dy = entity.motionY;
		this.dz = entity.motionZ;
		this.id = entity.getEntityId();
		this.dimension = entity.dimension;
	}
	

	@Override
	public void fromBytes(ByteBuf buf) {
		x = buf.readDouble();
		y = buf.readDouble();
		z = buf.readDouble();
		dx = buf.readDouble();
		dy = buf.readDouble();
		dz = buf.readDouble();
		id = buf.readInt();
		dimension = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeDouble(x);
		buf.writeDouble(y);
		buf.writeDouble(z);
		buf.writeDouble(dx);
		buf.writeDouble(dy);
		buf.writeDouble(dz);
		buf.writeInt(id);
		buf.writeInt(dimension);
	}

	@Override
	public void handleClientSide(MessageEntityPosVelUpdate message, EntityPlayer player) {
		if (player.dimension == message.dimension) {
			Entity entity = player.world.getEntityByID(message.id);
			if (entity != null) {
				entity.posX = message.x;
				entity.posY = message.y;
				entity.posZ = message.z;
				entity.motionX = message.dx;
				entity.motionY = message.dy;
				entity.motionZ = message.dz;
			}
			else {
				Main.logger.info("Entity Not Found");
			}
		}
	}

	@Override
	public void handleServerSide(MessageEntityPosVelUpdate message, EntityPlayer player) {
		
	}

}