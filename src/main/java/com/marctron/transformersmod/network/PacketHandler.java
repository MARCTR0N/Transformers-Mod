package com.marctron.transformersmod.network;

import com.marctron.transformersmod.network.packets.PacketInventory;
import com.marctron.transformersmod.network.packets.PacketInventoryHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {
	
//	EntityPlayer player = Minecraft.getMinecraft().player
	
	/**
	 * The instance of packet handler, for use to be able to send messages
	 */
	public static SimpleNetworkWrapper INSTANCE;

	/**
	 * The unique ID tracker for our packets
	 */
	private static int ID = 0;

	/**
	 * Get the next id
	 * 
	 * @return The next id
	 */
	private static int nextID() {
		return ID++;
	}

	/**
	 * Register all of our network messages on their appropriate side
	 * 
	 * @param channelName
	 *            The name of the network channel
	 */
	public static void registerMessages(String channelName) {
		INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(channelName);

//		EntityPlayer entityplayer = (EntityPlayer) entity;
	
		
		// Server packets
		INSTANCE.registerMessage(PacketGetWorker.Handler.class, PacketGetWorker.class, nextID(), Side.SERVER);
		
		INSTANCE.registerMessage(PacketInventoryHandler.class, PacketInventory.class, nextID(), Side.SERVER);
		
		INSTANCE.registerMessage(PacketGetEnergyDifference.Handler.class, PacketGetEnergyDifference.class, nextID(), 
				Side.SERVER);
		

		// Client packets
		INSTANCE.registerMessage(PacketReturnWorker.Handler.class, PacketReturnWorker.class, nextID(), Side.CLIENT);
		INSTANCE.registerMessage(PacketReturnEnergyDifference.Handler.class, PacketReturnEnergyDifference.class,
				nextID(), Side.CLIENT);
	}
	
	
}