package com.marctron.transformersmod.network.packets;

import java.util.List;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.marctron.transformersmod.entity.Player;


import io.netty.buffer.ByteBuf;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.relauncher.Side;

public class PacketInventory implements IMessage{

	  private int toSend;
	  public PacketInventory(int toSend) {
	    this.setToSend(toSend); 
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

	
	
	
	
	
}
