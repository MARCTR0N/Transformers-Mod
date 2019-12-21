package com.marctron.transformersmod.network.packets;


import com.marctron.transformersmod.util.Reference;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class PacketSender {
	
	public static SimpleNetworkWrapper INSTANCE;

	
	
//	INSTANCE.sendToServer(new MyMessage(toSend);
	
	
	public static void sendToServer(String channelName)
	{
		INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(channelName);
		
//		INSTANCE.sendToServer();
	}
}
