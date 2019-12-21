package com.marctron.transformersmod.network.packets;

import com.marctron.transformersmod.proxy.ClientProxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketInventoryHandler implements IMessageHandler<PacketInventory, IMessage> {

	public static SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("mymodid");
	
	@Override
	public IMessage onMessage(PacketInventory message, MessageContext ctx) {
		// This is the player the packet was sent to the server from
	    EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
	    // The value that was sent
	    int amount = message.getToSend();
	    // Execute the action on the main server thread by adding it as a scheduled task
//	    if (ClientProxy.ROBOT_MODE.isKeyDown()) {
	    if (Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown()) {
	    serverPlayer.getServerWorld().addScheduledTask(() -> {
	      serverPlayer.inventory.addItemStackToInventory(new ItemStack(Items.DIAMOND, amount));
	    });
	    }
	    // No response packet
	    return null;
	}
	
	public static void registerMessages(String channelName) {
		INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(channelName);
		INSTANCE.registerMessage(PacketInventoryHandler.class, PacketInventory.class, 9, Side.SERVER);
		
	}

}
