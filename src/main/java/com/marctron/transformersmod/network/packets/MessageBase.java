package com.marctron.transformersmod.network.packets;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public abstract class MessageBase<REQ extends IMessage> implements IMessage, IMessageHandler<REQ, REQ> {

	@Override
	public REQ onMessage(REQ message, MessageContext ctx) {
		if (ctx.side == Side.SERVER) {
			EntityPlayerMP player = ctx.getServerHandler().player;
			
			if (player == null) {
				return null;
			}
			
			final WorldServer WorldServer = player.getServerWorld();
			
		    WorldServer.addScheduledTask(new Runnable() {
		    	
		    	@Override
		    	public void run() {
		    		handleServerSide(message, player);
		    	}
		    	
		    });

		    return null;
		}
		else {
			
			final Minecraft minecraft = Minecraft.getMinecraft();
			
			minecraft.addScheduledTask(new Runnable() {

				@Override
				public void run() {
					handleClientSide(message, minecraft.player);
				}
				
			});
			
			return null;
		}
	}
	
	public abstract void handleClientSide(REQ message, EntityPlayer player);
	
	public abstract void handleServerSide(REQ message, EntityPlayer player);
}