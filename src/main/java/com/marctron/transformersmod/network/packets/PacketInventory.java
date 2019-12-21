package com.marctron.transformersmod.network.packets;

import java.util.List;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.marctron.transformersmod.entity.Player;
import com.marctron.transformersmod.network.packets.tf.MessageUpdateArmor;
import com.marctron.transformersmod.proxy.ClientProxy;

import io.netty.buffer.ByteBuf;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PacketInventory implements IMessage{

	  public int toSend;
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

	public static class Handler implements IMessageHandler<PacketInventory, IMessage>
	
	{
	@Override
	public IMessage onMessage(PacketInventory message, MessageContext ctx) {
		// This is the player the packet was sent to the server from
	    EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
	    // The value that was sent
	    int amount = message.getToSend();
	    // Execute the action on the main server thread by adding it as a scheduled task
//	    if (ClientProxy.ROBOT_MODE.isKeyDown()) {
//	    if (Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown()) {
	    serverPlayer.getServerWorld().addScheduledTask(() -> {
	      serverPlayer.inventory.addItemStackToInventory(new ItemStack(Items.DIAMOND, amount));
//	      if (ClientProxy.ROBOT_MODE.isKeyDown()) {
	    	  serverPlayer.inventory.addItemStackToInventory(new ItemStack(Items.DIAMOND, amount));
	    	  System.out.println("fuck");
//	      }
	    });
//	    }
	    // No response packet
	    return null;
	}
	}
	
	
	
	
}
